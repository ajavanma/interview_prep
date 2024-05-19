package java.tree.binaryTree;

// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}

// //
// // Definition for a binary tree node:
// //
// // first variant: Standalone TreeNode
// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     // Provides three constructors to create instances in different ways:
//     //  without parameters (using default values), 
//     //  with a specific value, 
//     //  with specific value and links to left and right child nodes.
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

// // second variant: Inner TreeNode
// // treenode is encapsulated within the binary tree class
// // This definition only provides a constructor to initialize the node's data;
// //  initial links to child nodes are implicitly null and must be set via the BinaryTree class methods.
// public class BinaryTree {
    
//     private TreeNode root;
    
//     private class TreeNode {
//         private int data; 
//         private TreeNode left;
//         private TreeNode right;

//         public TreeNode(int data) {
//             this.data = data;
//         }
//     }
// }