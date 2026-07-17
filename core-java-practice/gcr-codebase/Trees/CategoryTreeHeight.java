class CategoryTreeHeight {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public int height(Node node) {
        if (node == null)
            return -1;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isTooDeep(Node root, int threshold) {
        return height(root) > threshold;
    }

    public static void main(String[] args) {
        CategoryTreeHeight tree = new CategoryTreeHeight();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        int threshold = 2;
        System.out.println("Height = " + tree.height(root));
        System.out.println("Too Deep? " + tree.isTooDeep(root, threshold));
    }
}