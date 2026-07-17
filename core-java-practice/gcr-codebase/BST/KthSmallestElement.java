import java.util.*;

class KthSmallestElement {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public int kthSmallest(Node root, int k) {

        Deque<Node> stack = new ArrayDeque<>();

        Node current = root;

        int count = 0;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            count++;

            if (count == k)
                return current.val;

            current = current.right;
        }

        throw new IllegalArgumentException("k out of range");
    }

    public static void main(String[] args) {

        KthSmallestElement tree = new KthSmallestElement();

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);

        System.out.println(tree.kthSmallest(root, 3));
    }
}