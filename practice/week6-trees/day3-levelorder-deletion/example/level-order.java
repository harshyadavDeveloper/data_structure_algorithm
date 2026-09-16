import java.util.LinkedList;
import java.util.Queue;

class LevelOrder {
    public static void main(String[] args) {
        int[] values = { 50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 90 };
        TreeNode root = null;

        for (int val : values) {
            root = insert(root, val);
        }
        // printInOrder(root);
        printLevelOrder(root);

    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);

        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.print(currNode.val + " ");

            if (currNode.left != null) {
                queue.add(currNode.left);
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
            }

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