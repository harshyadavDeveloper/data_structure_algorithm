// Before writing any code, trace this insert sequence by hand on paper: 50, 30, 70, 20, 40, 60, 80, 10, 25. Draw the resulting 
// tree. Where does 10 land? Where does 25 land? Once you've drawn it, code the insert loop above and print an in-order traversal 
// — does it match what you expect from a sorted list of those 9 numbers?
public class Task93_TraceInsertOrder {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80, 10, 25 };
        TreeNode root = null;

        for (int num : arr) {
            root = insert(root, num);
        }

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
