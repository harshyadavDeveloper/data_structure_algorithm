// Task 77: Build the TreeNode class exactly as derived above. Manually construct the exact tree shown in the diagram (10 at root, 
// 5/15 as children, 3/7 under 5, 20 under 15).

// Task 78: Implement inOrder() exactly as derived above, run it on your Task 77 tree, confirm you get 3 5 7 10 15 20.

// Task 79 (a fresh derivation): Write countNodes(TreeNode node) that returns the total number of nodes in the tree. Think about 
// it the way you approached arraySum in Week 4: what's the base case (an empty subtree — how many nodes does that contribute)? 
// And how does "count of this whole tree" relate to "count of the left subtree" and "count of the right subtree"?

//        10
//       /  \
//      5    15
//     / \     \
//    3   7    20

// Task 80 (another fresh derivation): Write height(TreeNode node) that returns the tree's height (the number of edges on the 
// longest path from root to a leaf; an empty tree has height -1, a single node has height 0). Think about it as: the height of 
// a tree is 1 more than the taller of its two subtrees' heights — what Java tool do you already know for "which of two things 
// is bigger" that could help here (hint: think back to Week 1's max-finding logic, or consider Math.max)?

class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        // inOrder(root);
        // count(root);
        int height = calculateHeight(root);
        System.out.println(height);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public static int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int count = 1 + count(node.left) + count(node.right);
        System.out.println(count);
        return count;
    }

    public static int calculateHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int height = 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
        return height;
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