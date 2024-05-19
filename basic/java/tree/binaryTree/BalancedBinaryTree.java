package java.tree.binaryTree;

// Given a binary tree, determine if it is height-balanced
// A height-balanced binary tree:
//  a binary tree in which the depth of the two subtrees of every node never differs by more than one


// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }


 class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // helper function
    private int checkHeight(TreeNode node) {
        if (node == null)  return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;  // difference greater than 1 => current node is unbalanced

        return Math.max(leftHeight, rightHeight) + 1;           // Return the height of the current node
    }
}
