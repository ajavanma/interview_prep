package leetcode.easy.java;

// Given the root of a binary tree, invert the tree, and return its root.
// it will be mirrored
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

// Time complexity: O(N)
// Space complexity: O(N) Recursive stack space

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}