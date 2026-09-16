class DeleteNode {
    public static void main(String[] args) {
        int[] values = { 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 90 };
        TreeNode root = null;

        for (int val : values) {
            root = insert(root, val);
        }
        deleteNode(root, 30);
        System.out.println("Tree after deletion: ");
        inOrder(root);

    }

    // 1. Target chhota hai → left jao.
    // 2. Target bada hai → right jao.
    // 3. Target mil gaya → children check karo.
    // 4. 0/1 child → jo child hai, usko meri jagah return karo.
    // 5. 2 children → right subtree ka minimum lao, value copy karo, original
    // minimum ko delete karo.

    public static TreeNode deleteNode(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        if (target < node.data) {
            node.left = deleteNode(node.left, target);
        } else if (target > node.data) {
            node.right = deleteNode(node.right, target);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                int successorValue = findMin(node.right);
                node.data = successorValue;
                node.right = deleteNode(node.right, successorValue);
            }
        }
        return node;
    }

    public static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}