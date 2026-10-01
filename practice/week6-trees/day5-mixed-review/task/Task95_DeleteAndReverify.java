// Delete 30 from your tree (it has two children — this is the case-3 delete from Day 3). Before running your delete():

// What's the minimum value in 30's right subtree?
// What should the tree look like after the delete — draw it?

// After deleting, run in-order traversal. Does the result still come out sorted, with 30 missing and no duplicates?

class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80, 10, 25 };
        TreeNode root = null;

        for (int num : arr) {
            root = insert(root, num);
        }
        root = delete(root, 30);
        inOrder(root);

    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static TreeNode delete(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (target < root.val) {
            root.left = delete(root.left, target);
        } else if (target > root.val) {
            root.right = delete(root.right, target);
        } else {
            // found it
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                int successorValue = findMin(root.right);
                root.val = successorValue;
                root.right = delete(root.right, successorValue);
            }
        }
        return root;
    }

    public static int findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.val;
    }

    public static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }

        if (num < root.val) {
            root.left = insert(root.left, num);
        } else {
            root.right = insert(root.right, num);
        }
        return root;
    }

    public static boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
