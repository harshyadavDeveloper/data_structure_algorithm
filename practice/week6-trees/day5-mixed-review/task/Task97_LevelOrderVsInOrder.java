import java.util.LinkedList;
import java.util.Queue;

// Run both levelOrder() (Day 3) and inOrder() on the tree after deletion. You'll get two different-looking sequences of the same 8 remaining numbers.
// Question: in-order gives you sorted output no matter the tree's shape — you proved that back in Task 89. Does level-order have 
// that same property, or does its output depend on shape? Think about it, then check by comparing level-order output against the 
// shape you drew for Task 95.

class Main {
    public static void main(String[] args) {
        int[] arr = { 50, 30, 70, 20, 40, 60, 80, 10, 25 };
        TreeNode root = null;

        for (int num : arr) {
            root = insert(root, num);
        }
        // System.out.println("Height of the tree before deleting 30: " + height(root));
        // System.out.println("Tree balanced before removing 30: " + isBalanced(root));
        // levelOrder(root);
        root = delete(root, 30);
        System.out.println();
        // levelOrder(root);
        inOrder(root);
        // System.out.println("Height of the tree after deleting 30: " + height(root));
        // System.out.println("Tree balanced after removing 30: " + isBalanced(root));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

        public static void levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            if(root==null){
                return;
            }

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
