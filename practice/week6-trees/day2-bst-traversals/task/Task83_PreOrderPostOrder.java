// Task 83: Implement both preOrder and postOrder, run both on your Task 81 tree, and manually verify the outputs against the 
// tree's actual shape (draw it out or trace by hand first).

class Task83_PreOrderPostOrder {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int value : arr) {
            root = insert(root, value);
        }
        // inOder(root);
        // System.out.println("Searching for element: " + search(root, 100));
        printPreOrder(root);
        printPostOrder(root);

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

    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
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
