class DeleteFolderTree {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public void deleteFolderTree(Node node) {
        if (node == null)
            return;

        deleteFolderTree(node.left);
        deleteFolderTree(node.right);

        deleteNode(node);
    }

    private void deleteNode(Node node) {
        System.out.println("Deleted: " + node.val);
    }

    public static void main(String[] args) {
        DeleteFolderTree tree = new DeleteFolderTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        tree.deleteFolderTree(root);
    }
}