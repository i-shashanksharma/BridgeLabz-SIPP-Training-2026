import java.util.*;

public class HospitalTriageSystem {

    static class Patient {
        String name;
        int urgency;

        Patient(String name, int urgency) {
            this.name = name;
            this.urgency = urgency;
        }

        public String toString() {
            return name + " (Urgency: " + urgency + ")";
        }
    }


    static class TriageQueue {

        PriorityQueue<Patient> queue =
                new PriorityQueue<>(
                        (a, b) -> b.urgency - a.urgency
                );

        void enqueue(Patient p) {
            queue.add(p);
        }

        Patient dequeue() {
            return queue.poll();
        }

        void display() {
            System.out.println(queue);
        }
    }


    static int[] slidingWindowMaximum(int[] vitals, int k) {

        int n = vitals.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty()
                    && vitals[deque.peekLast()] <= vitals[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result[index++] = vitals[deque.peekFirst()];
            }
        }

        return result;
    }


    static class CircularQueue {

        int[] queue;
        int front = -1;
        int rear = -1;
        int size;

        CircularQueue(int size) {
            this.size = size;
            queue = new int[size];
        }


        void add(int process) {

            if ((rear + 1) % size == front) {
                System.out.println("CPU Queue Full");
                return;
            }

            if (front == -1)
                front = 0;

            rear = (rear + 1) % size;
            queue[rear] = process;
        }


        int remove() {

            if (front == -1)
                return -1;

            int process = queue[front];

            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return process;
        }


        void display() {

            if (front == -1)
                return;

            int i = front;

            while (true) {

                System.out.print(queue[i] + " ");

                if (i == rear)
                    break;

                i = (i + 1) % size;
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {

        TriageQueue triage = new TriageQueue();

        triage.enqueue(new Patient("John", 3));
        triage.enqueue(new Patient("Alice", 10));
        triage.enqueue(new Patient("Mark", 7));

        System.out.println("Highest Urgency Patient:");
        System.out.println(triage.dequeue());


        int[] vitals = {80, 70, 90, 60, 100, 85};

        System.out.println("Sliding Window Maximum:");

        System.out.println(
                Arrays.toString(
                        slidingWindowMaximum(vitals, 3)
                )
        );


        CircularQueue cpu =
                new CircularQueue(5);

        cpu.add(101);
        cpu.add(102);
        cpu.add(103);

        System.out.println("CPU Round Robin Queue:");
        cpu.display();

        System.out.println("Executing Process: "
                + cpu.remove());

        cpu.add(104);

        System.out.println("Updated CPU Queue:");
        cpu.display();
    }
}