public class SecondLargestWithBinarySearchTree {

    public static int findTheSecondLargestInBST(Node root) {
        if (root == null) {
            System.out.println("This is an empty BST");
        }

        if (root.left == null && root.right == null) {
            System.out.println("There should be minimum two entries in the BST");
        }

        if (root.left != null && root.right == null) {
            return findTheLargest(root.left);
        }

        if (root.right != null && root.right.left == null && root.right.right == null) {
            return root.key;
        }

        return findTheSecondLargestInBST(root.right);
    }

    private static int findTheLargest(Node root) {
        if (root == null) {
            System.out.println("Root of BST cannot be null");
        }

        if (root.right == null) {
            return root.key;
        }

        return findTheLargest(root.right);
    }

    static class BinarySearchTree {
        Node root;

        BinarySearchTree() {
            root = null;
        }

        Node insertKey(Node node, int key) {
            if (node == null) {
                node = new Node(key);
                return node;
            }

            if (key < node.key) {
                node.left = insertKey(node.left, key);
            } else if (key > node.key) {
                node.right = insertKey(node.right, key);
            }
            return node;
        }

        Node searchKey(Node root, int key) {
            if (root == null || root.key == key) {
                return root;
            }

            if (root.key < key) {
                return searchKey(root.right, key);
            }

            return searchKey(root.left, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Inserting nodes
        tree.root = tree.insertKey(tree.root, 50);
        tree.insertKey(tree.root, 30);
        tree.insertKey(tree.root, 20);
        tree.insertKey(tree.root, 40);
        tree.insertKey(tree.root, 70);
        tree.insertKey(tree.root, 60);
        tree.insertKey(tree.root, 80);

        int result = findTheSecondLargestInBST(tree.root);
        System.out.println(result);
    }
}
