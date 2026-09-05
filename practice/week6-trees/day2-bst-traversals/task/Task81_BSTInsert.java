// Task 81: Implement insert() as derived above. Insert 50, 30, 70, 20, 40, 60,
// 80 one at a time (starting from null root), then run inOrder to confirm you
// get them back sorted.

class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int value : arr) {
            root = insert(root, value);
        }
        inOder(root);

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
