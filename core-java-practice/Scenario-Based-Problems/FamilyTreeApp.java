import java.util.*;

public class FamilyTreeApp {

    static class Node {
        String name;
        Node left, right;

        Node(String name) {
            this.name = name;
        }
    }

    Node root;


    void preorderRecursive(Node node) {
        if (node == null)
            return;

        System.out.print(node.name + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }


    void inorderRecursive(Node node) {
        if (node == null)
            return;

        inorderRecursive(node.left);
        System.out.print(node.name + " ");
        inorderRecursive(node.right);
    }


    void postorderRecursive(Node node) {
        if (node == null)
            return;

        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.name + " ");
    }


    void levelOrderRecursive(Node node) {

        int height = height(node);

        for (int i = 1; i <= height; i++) {
            printLevel(node, i);
        }
    }


    void printLevel(Node node, int level) {

        if (node == null)
            return;

        if (level == 1)
            System.out.print(node.name + " ");
        else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }


    void preorderIterative(Node node) {

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {

            Node current = stack.pop();

            if (current != null) {
                System.out.print(current.name + " ");

                stack.push(current.right);
                stack.push(current.left);
            }
        }
    }


    void inorderIterative(Node node) {

        Stack<Node> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            System.out.print(node.name + " ");

            node = node.right;
        }
    }


    void postorderIterative(Node node) {

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(node);

        while (!stack1.isEmpty()) {

            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null)
                stack1.push(current.left);

            if (current.right != null)
                stack1.push(current.right);
        }

        while (!stack2.isEmpty())
            System.out.print(stack2.pop().name + " ");
    }


    void levelOrderIterative(Node node) {

        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(current.name + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }
    }


    int height(Node node) {

        if (node == null)
            return 0;

        return 1 + Math.max(
                height(node.left),
                height(node.right)
        );
    }


    void countNodesEachLevel() {

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            System.out.println("Level Nodes: " + size);

            while (size-- > 0) {

                Node current = queue.poll();

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }
    }


    int diameter = 0;

    int diameterHeight(Node node) {

        if (node == null)
            return 0;

        int left = diameterHeight(node.left);
        int right = diameterHeight(node.right);

        diameter = Math.max(
                diameter,
                left + right + 1
        );

        return 1 + Math.max(left, right);
    }


    boolean isBalanced(Node node) {

        if (node == null)
            return true;

        int left = height(node.left);
        int right = height(node.right);

        return Math.abs(left - right) <= 1
                && isBalanced(node.left)
                && isBalanced(node.right);
    }


    public static void main(String[] args) {

        FamilyTreeApp tree = new FamilyTreeApp();

        tree.root = new Node("Grandparent");
        tree.root.left = new Node("Parent1");
        tree.root.right = new Node("Parent2");
        tree.root.left.left = new Node("Child1");
        tree.root.left.right = new Node("Child2");


        System.out.println("Recursive Preorder:");
        tree.preorderRecursive(tree.root);

        System.out.println("\nRecursive Inorder:");
        tree.inorderRecursive(tree.root);

        System.out.println("\nRecursive Postorder:");
        tree.postorderRecursive(tree.root);

        System.out.println("\nRecursive Level Order:");
        tree.levelOrderRecursive(tree.root);


        System.out.println("\n\nIterative Preorder:");
        tree.preorderIterative(tree.root);

        System.out.println("\nIterative Inorder:");
        tree.inorderIterative(tree.root);

        System.out.println("\nIterative Postorder:");
        tree.postorderIterative(tree.root);

        System.out.println("\nIterative Level Order:");
        tree.levelOrderIterative(tree.root);


        System.out.println("\n\nHeight: "
                + tree.height(tree.root));

        System.out.println("Nodes at Each Level:");
        tree.countNodesEachLevel();


        tree.diameterHeight(tree.root);

        System.out.println("Diameter: "
                + tree.diameter);

        System.out.println("Balanced: "
                + tree.isBalanced(tree.root));
    }
}