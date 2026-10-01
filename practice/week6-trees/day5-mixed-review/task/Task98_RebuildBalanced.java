// Task 98 → Task98_RebuildBalanced.java
// Take the in-order output from Task 97 (which is sorted) and feed it into your buildBalancedBST() method from Task 92. Check 
// height() and isBalanced() on the result.

class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 25, 40, 50, 60, 70, 80 };

        TreeNode root = buildBalancedTree(arr, 0, arr.length - 1);

        System.out.println("Height of the tree is: " + height(root));
        System.out.println("is the tree balanced: " + isBalanced(root));

    }

    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static TreeNode buildBalancedTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildBalancedTree(arr, start, mid - 1);
        root.right = buildBalancedTree(arr, mid + 1, end);

        return root;
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