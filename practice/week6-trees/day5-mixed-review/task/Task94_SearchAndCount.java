// Run search(root, 25) and search(root, 65) on your Task 93 tree. Before running — how many nodes does each search have to visit? 
// Trace both by hand using the tree you drew, then confirm.
class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80, 10, 25 };
        TreeNode root = null;

        for (int num : arr) {
            root = insert(root, num);
        }

        boolean searchh = search(root, 10);
        System.out.println("Is the target Present: " + searchh);

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
