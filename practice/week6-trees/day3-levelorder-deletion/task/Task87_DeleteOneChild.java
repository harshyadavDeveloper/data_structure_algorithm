// Task 87: First insert 45 into your tree (as a right child of 40, making 40 have exactly one child). Delete 40. Confirm 45 correctly 
// takes 40's place — trace what your delete() does here by hand before running.

class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;
        for (int val : arr) {
            root = insert(root, val);
        }
        // inOrder(root);
        System.out.println("Tree After inserting 45: ");
        root = insert(root, 45);
        inOrder(root);
        System.out.println("45 has total children: " + countChildren(root, 40));
        delete(root, 40);
        inOrder(root);

    }

    public static TreeNode delete(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (target < root.data) {
            root.left = delete(root.left, target);

        } else if (target > root.data) {
            root.right = delete(root.right, target);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int successorValue = findMin(root.right);
                root.data = successorValue;
                root.right = delete(root.right, successorValue);
            }

        }

        return root;
    }

    public static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public static int countChildren(TreeNode root, int target) {
        if (root == null) {
            return -1;
        }

        if (target < root.data) {
            return countChildren(root.left, target);
        } else if (target > root.data) {
            return countChildren(root.right, target);
        } else {
            if (root.left == null && root.right == null) {
                return 0;
            }
            if (root.left != null && root.right != null) {
                return 2;
            }
            return 1;
        }
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
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