class Main {

    public static void main(String[] args) {
        int[] arr = { 40, 20, 60, 10, 30, 50, 70 };

        TreeNode root = null;

        for (int num : arr) {
            root = insert(root, num);
        }

        // System.out.println("this tree has total leaves: " + countLeaves(root));
        // TreeNode target = returnParentNode(root, 10);
        // System.out.println("Parent of target is : " + target.val);
        // System.out.println("is the current tree balanced is? : " + isValidBST(root,
        // Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println("The second largest value in the tree is " + findSecondMax(root, null));

    }

    public static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }

        if (num < root.val) {
            root.left = insert(root.left, num);
        } else {
            root.right = insert(root.right, num);
        }
        return root;
    }

    // 1. Given the root of a binary tree, write a function to count the total
    // number of leaf nodes (nodes with no children).
    public static int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    // 2. Given a BST and a target value, write a function that returns the node's
    // parent if the target exists, or null if it doesn't (don't just return whether
    // it exists — return the parent node).
    public static TreeNode returnParentNode(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        if (target < node.val) {
            if (node.left != null && node.left.val == target) {
                return node;
            }
            return returnParentNode(node.left, target);
        }
        if (target > node.val) {
            if (node.right != null && node.right.val == target) {
                return node;
            }
            return returnParentNode(node.right, target);
        }

        return null;
    }

    // 3. Write a function to check if a given binary tree is a valid BST. (Careful
    // — checking only node.left.val < node.val < node.right.val at each node is not
    // sufficient. Think about why.)
    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    // 4. Given a BST, find the second largest value in it, without using any
    // traversal that stores all values in an array/list first.

    // soluttion: Largest node ka left subtree hai → us left subtree ka largest node
    // = second largest.
    // Largest node ka left subtree nahi hai → largest ka parent = second largest.
    public static int findSecondMax(TreeNode root, TreeNode parent) {
        if (root == null) {
            return -1;
        }

        if (root.right == null) {
            if (root.left != null) {
                return findMax(root.left);
            }

            return parent.val;
        }

        return findSecondMax(root.right, root);

    }

    public static int findMax(TreeNode node) {
        if (node == null) {
            return -1;
        }

        if (node.right == null) {
            return node.val;
        }

        return findMax(node.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}