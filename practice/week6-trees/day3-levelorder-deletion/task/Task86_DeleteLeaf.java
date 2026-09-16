// Task 86: On your Task 81 tree, delete 20 (a leaf). Run inOrder before and after to confirm 20 is gone 
// and everything else remains correctly sorted.

class Task86_DeleteLeaf {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int value : arr) {
            root = insert(root, value);
        }
        System.out.println("Before deletion: ");
        inOder(root);
        deleteLeaf(root, 20);
        System.out.println("After deletion: ");
        inOder(root);

    }

    public static TreeNode deleteLeaf(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        if (target < node.data) {
            node.left = deleteLeaf(node.left, target);

        } else if (target > node.data) {
            node.right = deleteLeaf(node.right, target);
        } else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
        }

        return node;
    }

    public static void inOder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOder(node.left);
        System.out.print(node.data + " ");
        inOder(node.right);
    }

    public static TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        return node;

    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
