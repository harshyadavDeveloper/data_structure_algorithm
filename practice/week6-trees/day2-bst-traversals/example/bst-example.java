class Main {
    public static void main(String[] args) {
        // 7,5,8,10,3,2,0
        int[] values = { 7, 5, 8, 10, 3, 2, 0, 13, 17 };
        TreeNode root = null;

        for (int value : values) {
            root = insert(root, value);
        }
        printInOrder(root);
        System.out.println("Searching for element: " + search(root, 3));

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

    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);

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
