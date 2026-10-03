class Main {

    public static void main(String[] args) {
        int[] arr = { 40, 20, 60, 10, 30, 50, 70 };

        TreeNode root = null;

        for (int num : arr) {
            root = insert(root, num);
        }

        // System.out.println("this tree has total leaves: " + countLeaves(root));
        TreeNode target = returnParentNode(root, 10);
        System.out.println("Parent of target is : " + target.val);

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