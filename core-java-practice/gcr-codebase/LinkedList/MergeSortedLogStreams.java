class MergeSortedLogStreams {
    static class Node {
        int timestamp;
        Node next;

        Node(int timestamp) {
            this.timestamp = timestamp;
        }
    }

    static Node mergeLogStreams(Node a, Node b) {

        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {

            if (a.timestamp <= b.timestamp) {
                tail.next = a;
                a = a.next;
            } 
            else {
                tail.next = b;
                b = b.next;
            }

            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;

        return dummy.next;
    }

    static void display(Node head) {

        while (head != null) {
            System.out.print(head.timestamp + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node a = new Node(1);
        a.next = new Node(4);
        a.next.next = new Node(7);

        Node b = new Node(2);
        b.next = new Node(3);
        b.next.next = new Node(8);

        Node result = mergeLogStreams(a, b);

        display(result);
    }
}