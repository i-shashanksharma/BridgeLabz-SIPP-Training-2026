class BrowserHistoryReverse {
    static class Node {
        int page;
        Node next;

        Node(int page) {
            this.page = page;
        }
    }

    static Node reverseHistory(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.page + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head = reverseHistory(head);

        display(head);
    }
}