// Task 91: Copy your search() and add a counter that increments on every node visited. Run search(70) on both Task 89 trees. 
// Before running: which tree do you expect to take more steps, and about how many? Then check, and note in a comment what Big-O 
// each count corresponds to.

// tree one will take more count because of its structure rn it is just a linkedin list so if the number is present in the very 
// end then i will take n jumps to find the num whereas tree two takes 3 that is less than half of tree one. it is because tree 2 is balanced. so the tree 1 takes O(n) and tree two take O(log n)

public class Task91_CountSearchSteps {
    public static int count = 0;

    public static void main(String[] args) {
        int[] arr1 = { 10, 20, 30, 40, 50, 60, 70 };
        int[] arr2 = { 40, 20, 60, 10, 30, 50, 70 };

        TreeNode root1 = null;
        TreeNode root2 = null;

        for (int num : arr1) {
            root1 = insert(root1, num);
        }

        for (int num : arr2) {
            root2 = insert(root2, num);
        }

        search(root2, 70);
        System.out.println(count);

    }

    public static boolean search(TreeNode root, int num) {
        if (root == null) {
            return false;
        }

        if (root.val == num) {
            count++;
            return true;
        } else if (num < root.val) {
            count++;
            return search(root.left, num);
        } else {
            count++;
            return search(root.right, num);
        }
    }

    public static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
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