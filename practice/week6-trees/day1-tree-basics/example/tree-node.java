class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        inOrder(root);

    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left); // fully explore the left side first
        System.out.println(node.data + " "); // then visit this node
        inOrder(node.right); // then fully explore everything on the right
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