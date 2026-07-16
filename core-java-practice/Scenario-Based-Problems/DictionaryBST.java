import java.util.*;

public class DictionaryBST {

    static class Node {
        String word;
        Node left, right;

        Node(String word) {
            this.word = word;
        }
    }

    Node root;


    Node insert(Node node, String word) {

        if (node == null)
            return new Node(word);

        if (word.compareTo(node.word) < 0)
            node.left = insert(node.left, word);
        else
            node.right = insert(node.right, word);

        return node;
    }


    boolean search(Node node, String word) {

        if (node == null)
            return false;

        if (node.word.equals(word))
            return true;

        if (word.compareTo(node.word) < 0)
            return search(node.left, word);

        return search(node.right, word);
    }


    Node delete(Node node, String word) {

        if (node == null)
            return null;

        if (word.compareTo(node.word) < 0) {
            node.left = delete(node.left, word);
        }

        else if (word.compareTo(node.word) > 0) {
            node.right = delete(node.right, word);
        }

        else {

            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            Node successor = findMin(node.right);

            node.word = successor.word;

            node.right = delete(node.right, successor.word);
        }

        return node;
    }


    Node findMin(Node node) {

        while (node.left != null)
            node = node.left;

        return node;
    }


    void inorder(Node node) {

        if (node == null)
            return;

        inorder(node.left);
        System.out.print(node.word + " ");
        inorder(node.right);
    }


    int count = 0;

    String kthSmallest(Node node, int k) {

        if (node == null)
            return null;

        String left = kthSmallest(node.left, k);

        if (left != null)
            return left;

        count++;

        if (count == k)
            return node.word;

        return kthSmallest(node.right, k);
    }


    boolean validateBST(Node node, String min, String max) {

        if (node == null)
            return true;

        if ((min != null && node.word.compareTo(min) <= 0) ||
            (max != null && node.word.compareTo(max) >= 0))
            return false;

        return validateBST(node.left, min, node.word)
                && validateBST(node.right, node.word, max);
    }


    Node lowestCommonAncestor(Node node,
                              String word1,
                              String word2) {

        if (node == null)
            return null;

        if (word1.compareTo(node.word) < 0 &&
                word2.compareTo(node.word) < 0)
            return lowestCommonAncestor(node.left,
                    word1, word2);

        if (word1.compareTo(node.word) > 0 &&
                word2.compareTo(node.word) > 0)
            return lowestCommonAncestor(node.right,
                    word1, word2);

        return node;
    }


    public static void main(String[] args) {

        DictionaryBST dictionary = new DictionaryBST();

        String[] words = {
                "apple", "banana", "cat", "dog", "elephant",
                "fish", "grape", "horse", "ice", "juice",
                "kite", "lion", "moon", "night", "orange",
                "pear", "queen", "rose", "star", "tree"
        };


        for (String word : words)
            dictionary.root =
                    dictionary.insert(dictionary.root, word);


        System.out.println("BST Inorder:");
        dictionary.inorder(dictionary.root);


        System.out.println("\n\nSearch apple: "
                + dictionary.search(dictionary.root, "apple"));

        System.out.println("Search zebra: "
                + dictionary.search(dictionary.root, "zebra"));


        dictionary.root =
                dictionary.delete(dictionary.root, "apple");

        dictionary.root =
                dictionary.delete(dictionary.root, "lion");

        dictionary.root =
                dictionary.delete(dictionary.root, "night");


        System.out.println("\nAfter Deletion:");
        dictionary.inorder(dictionary.root);


        dictionary.count = 0;

        System.out.println("\n\n5th Alphabetical Word: "
                + dictionary.kthSmallest(dictionary.root, 5));


        System.out.println("Valid BST: "
                + dictionary.validateBST(
                        dictionary.root, null, null));


        Node lca = dictionary.lowestCommonAncestor(
                dictionary.root, "grape", "juice");

        System.out.println("Lowest Common Ancestor: "
                + lca.word);
    }
}