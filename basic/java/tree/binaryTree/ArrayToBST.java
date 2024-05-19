package java.tree.binaryTree;

// Given an integer array (nums) where the elements are sorted in ascending order, convert it to a height-balanced* binary search tree.
//  * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

class convertArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convert(nums, 0, nums.length - 1);
    }

    // name is changed for readability, it can also be the same
    // convert method is private, whereas sortedArrayToBST is public
    private TreeNode convert(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;        // Find the middle element
        TreeNode node = new TreeNode(nums[mid]);    // to read the nums, it has to be passed in (unlike python)
        node.left = convert(nums, left, mid - 1);   // Recursively construct the left subtree
        node.right = convert(nums, mid + 1, right); // Recursively construct the right subtree
        return node;
    }
}



// class TreeNode {
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