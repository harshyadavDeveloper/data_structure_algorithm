// Task 84 (fresh derivation): Write findMin(TreeNode node) that returns the minimum value in a BST. Think about the BST rule: 
// given that rule, without checking every single node, where must the smallest value always live? (Hint: which direction would 
// you keep walking, and when do you stop?)

class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int value : arr) {
            root = insert(root, value);
        }
        // inOder(root);
        // System.out.println("Searching for element: " + search(root, 100));
        // printPreOrder(root);
        // printPostOrder(root);
        // findMin(root);
        System.out.println("Maximun value node in the tree is: " + findMax(root));

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

    public static int findMin(TreeNode node) {
        // keep going LEFT
        // ↓
        // until LEFT is null
        // ↓
        // current node = minimum
        if (node == null) {
            return -1;
        }
        if (node.left == null) {
            System.out.println("Mininum value in the BST is: " + node.data);
            return node.data;
        } else {
            return findMin(node.left);

        }
    }

    public static int findMax(TreeNode node) {
        // keep going right
        // ↓
        // until RIGHT is null
        // ↓
        // current node = meximun
        if (node == null) {
            return -1;
        }

        if (node.right == null) {
            return node.data;
        } else {
            return findMax(node.right);
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
