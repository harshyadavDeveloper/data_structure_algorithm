class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        inOrder(root);
        System.out.println("Minimun value node is: " + findMin(root));
        System.out.println("Maximum value node is: " + findMax(root));

    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left); // fully explore the left side first
        System.out.print(node.data + " "); // then visit this node
        inOrder(node.right); // then fully explore everything on the right
    }

    public static int findMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);

        return Math.min(node.data, Math.min(leftMin, rightMin));
    }

    public static int findMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));
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