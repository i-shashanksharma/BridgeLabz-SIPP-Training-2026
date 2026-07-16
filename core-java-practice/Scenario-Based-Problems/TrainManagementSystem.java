import java.util.*;

public class TrainManagementSystem {

    static class Node {
        int coach;
        Node next;

        Node(int coach) {
            this.coach = coach;
            this.next = null;
        }
    }

    Node head;

    void addCoach(int coach) {
        Node newNode = new Node(coach);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }


    void removeCoach(int coach) {
        if (head == null)
            return;

        if (head.coach == coach) {
            head = head.next;
            return;
        }

        Node current = head;

        while (current.next != null &&
                current.next.coach != coach) {
            current = current.next;
        }

        if (current.next != null)
            current.next = current.next.next;
    }


    void reverseTrain() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }


    boolean detectCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }


    void findMiddleCoach() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != null)
            System.out.println("Middle Coach: " + slow.coach);
    }


    static Node mergeSortedTrains(Node first, Node second) {

        Node dummy = new Node(0);
        Node current = dummy;

        while (first != null && second != null) {

            if (first.coach <= second.coach) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }

            current = current.next;
        }

        if (first != null)
            current.next = first;

        if (second != null)
            current.next = second;

        return dummy.next;
    }


    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.coach + " ");
            temp = temp.next;
        }

        System.out.println();
    }


    public static void main(String[] args) {

        TrainManagementSystem train =
                new TrainManagementSystem();

        train.addCoach(10);
        train.addCoach(20);
        train.addCoach(30);
        train.addCoach(40);

        System.out.println("Original Train:");
        train.display();

        train.removeCoach(20);

        System.out.println("After Removing Coach:");
        train.display();

        train.reverseTrain();

        System.out.println("Reversed Train:");
        train.display();

        train.findMiddleCoach();

        System.out.println("Cycle Exists: "
                + train.detectCycle());


        TrainManagementSystem train1 =
                new TrainManagementSystem();

        TrainManagementSystem train2 =
                new TrainManagementSystem();

        train1.addCoach(1);
        train1.addCoach(3);
        train1.addCoach(5);

        train2.addCoach(2);
        train2.addCoach(4);
        train2.addCoach(6);

        Node merged = mergeSortedTrains(
                train1.head, train2.head);

        System.out.println("Merged Train Schedule:");

        while (merged != null) {
            System.out.print(merged.coach + " ");
            merged = merged.next;
        }
    }
}