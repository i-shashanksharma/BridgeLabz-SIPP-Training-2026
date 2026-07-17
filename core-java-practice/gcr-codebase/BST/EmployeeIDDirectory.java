class EmployeeIDDirectory {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node insert(Node node, int id) {

        if (node == null)
            return new Node(id);

        if (id < node.val)
            node.left = insert(node.left, id);

        else if (id > node.val)
            node.right = insert(node.right, id);

        return node;
    }

    public void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {

        EmployeeIDDirectory tree = new EmployeeIDDirectory();

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        root = tree.insert(root, 40);

        tree.inorder(root);
    }
}