// Task 85: Implement levelOrder() using Queue<TreeNode>, run it on your Task 81
// tree, confirm 50 30 70 20 40 60 80.

import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        int[] values = { 50, 30, 70, 20, 40, 60, 80 };
        TreeNode root = null;

        for (int val : values) {
            root = insert(root, val);

        }

        printLevelOrder(root);

    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.print(currNode.value + " ");

            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.value) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}