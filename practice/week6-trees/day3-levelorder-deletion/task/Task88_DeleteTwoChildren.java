// Task 88 (the real test): Delete 30 from your original Task 81 tree (30 has two children: 20 and 40). Trace by hand first: what's 
// the minimum of 30's right subtree (just 40, in this case, since 40 has no left child)? Confirm your code correctly replaces 30's 
// value with 40, then removes the original 40 node, and that inOrder afterward is still 20 40 50 60 70 80 (sorted, no duplicates, no 
// 30).

public class Task88_DeleteTwoChildren {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int value : arr) {
            root = insert(root, value);
        }
        System.out.println("30 has total children: " + countChild(root, 30));
        inOrder(root);
        root = delete(root, 30);

        System.out.println("\nAfter deletion:");
        inOrder(root);

    }

    public static int countChild(TreeNode node, int target) {
        if (node == null) {
            return -1;
        }

        if (target < node.data) {
            return countChild(node.left, target);
        } else if (target > node.data) {
            return countChild(node.right, target);
        } else {
            if (node.left == null && node.right == null) {
                return 0;
            } else if (node.left != null && node.right != null) {
                System.out.print(node.left.data + " " + node.right.data);
                return 2;
            } else {
                return 1;
            }
        }
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
            if (root.right == null && root.left == null) {
                return null;
            }
            if (root.left != null && root.right == null) {
                return root.left;
            }

            if (root.left == null && root.right != null) {
                return root.right;
            }

            if (root.left != null && root.right != null) {
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

    public static TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;

    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
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
