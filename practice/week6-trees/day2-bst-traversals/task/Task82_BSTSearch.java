// Task 82: Implement search(). Test on your Task 81 tree: search for 40 (should be found) and 100 (should not).

class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int value : arr) {
            root = insert(root, value);
        }
        // inOder(root);
        System.out.println("Searching for element: "+ search(root, 100));

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

    public static boolean search(TreeNode node, int target) {
        if (node == null) {
            return false;
        }

        if (node.data == target) {
            return true;
        } else if (target < node.data) {
            return search(node.left, target);
        } else {
            return search(node.right, target);
        }
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
