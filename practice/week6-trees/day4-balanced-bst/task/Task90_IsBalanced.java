// Task 90: Build this tree by hand (not from an array):

// 10
// /
// 5
// /
// 3
// \
// 4

// Trace by hand first: if you only checked balance at the root (left subtree
// height vs right subtree height), does this tree pass or fail? Now check node
// 5 on its own — is it balanced by itself? Write boolean isBalanced(TreeNode
// node) that checks every node, and run it on this tree plus both trees from
// Task 89.

// and also root only check in my printHeight function can detect that this root3 is unbalanced
// no the node 5 on its own is not balanced becuase its height of left is 2 and right 0 2-0=2 which makes it unbalanced
class Main {
    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 30, 40, 50, 60, 70 };
        int[] arr2 = { 40, 20, 60, 10, 30, 50, 70 };
        TreeNode root1 = null;
        TreeNode root2 = null;

        for (int num : arr1) {
            root1 = insert(root1, num);

        }

        for (int num : arr2) {
            root2 = insert(root2, num);
        }

        TreeNode root3 = new TreeNode(10);
        root3.left = new TreeNode(5);
        root3.left.left = new TreeNode(3);
        root3.left.left.right = new TreeNode(4);

        inOrder(root2);
        System.out.println("height of root2 is: " + printHeight(root2));

        System.out.println("Is Tree 1 balanced? answer: " + isBalanced(root1));

        System.out.println("Is Tree 2 balanced? answer: " + isBalanced(root2));

        System.out.println("Is Tree 3 balanced? answer: " + isBalanced(root3));
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

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static int printHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(printHeight(root.left), printHeight(root.right));
    }

    public static boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }

        int leftHeight = printHeight(node.left);
        int rightHeight = printHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);

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