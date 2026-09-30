// Task 92 (the real test): Given int[] arr = {1, 2, 3, 4, 5, 6, 7} — already sorted — build a BST from it that comes out balanced.
// Trace by hand first: if you want the left and right sides of the root to end up equal size, which element has to be the root? 
// What's left over on each side once you pick it — does that look like a smaller version of the same problem? Write the method, 
// then confirm with height() and isBalanced().

public class Task92_SortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        TreeNode root = buildBalancedBST(arr, 0, arr.length - 1);

        boolean check = isBalanced(root);
        System.out.println("The tree is " + check);

    }

    public static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public static int calculateHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftnode = calculateHeight(root.left);
        int rightnode = calculateHeight(root.right);

        if (Math.abs(leftnode - rightnode) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static TreeNode buildBalancedBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = buildBalancedBST(arr, start, mid - 1);

        root.right = buildBalancedBST(arr, mid + 1, end);

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
