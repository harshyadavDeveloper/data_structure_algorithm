// Task 89: Build a BST from {10, 20, 30, 40, 50, 60, 70} inserted in that
// order, and another from {40, 20, 60, 10, 30, 50, 70}. Print height() for
// both. Before running: predict both heights, and predict whether the in-order
// traversal of the two trees will match or differ.

// the height will differ here cause of the order of the element but inorder will be exact same for both because the logic for print does not change it will to the lesser node no matter the order or the shape of the tree

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
        inOrder(root1);
        System.out.println("height of root1 is : " + printHeight(root1));

        inOrder(root2);
        System.out.println("height of root2 is: " + printHeight(root2));

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