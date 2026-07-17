class ProductSKUDeletion {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node delete(Node node, int sku) {

        if (node == null)
            return null;

        if (sku < node.val) {
            node.left = delete(node.left, sku);
        } else if (sku > node.val) {
            node.right = delete(node.right, sku);
        } else {

            if (node.left == null && node.right == null)
                return null;

            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            Node successor = node.right;

            while (successor.left != null)
                successor = successor.left;

            node.val = successor.val;

            node.right = delete(node.right, successor.val);
        }

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

        ProductSKUDeletion tree = new ProductSKUDeletion();

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        root = tree.delete(root, 50);

        tree.inorder(root);
    }
}