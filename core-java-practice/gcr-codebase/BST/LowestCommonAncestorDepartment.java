class LowestCommonAncestorDepartment {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node lowestCommonAncestor(Node root, int p, int q) {

        Node current = root;

        while (current != null) {

            if (p < current.val && q < current.val) {
                current = current.left;
            } else if (p > current.val && q > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        LowestCommonAncestorDepartment tree = new LowestCommonAncestorDepartment();

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.right.left = new Node(60);
        root.right.right = new Node(80);

        Node lca = tree.lowestCommonAncestor(root, 20, 40);

        System.out.println("LCA = " + lca.val);
    }
}