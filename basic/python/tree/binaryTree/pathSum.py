# Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that
#  adding up all the values along the path equals targetSum.

# A leaf is a node with no children.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def hasPathSum(self, root: TreeNode, targetSum: int) -> bool:
        if not root:
            return False
        
        # Check if it's a leaf node
        if not root.left and not root.right:
            return targetSum == root.val
        
        # Recursively check the left and right subtree
        left_path = self.hasPathSum(root.left, targetSum - root.val)    # root here means the current node
        right_path = self.hasPathSum(root.right, targetSum - root.val)
        
        return left_path or right_path


# Example:

#     5
#    / \
#   4   8
#  /   / \
# 11  13  4
# / \      \
#7   2      1
root = TreeNode(5)
root.left = TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2)))
root.right = TreeNode(8, TreeNode(13), TreeNode(4, None, TreeNode(1)))
sol = Solution()
print(sol.hasPathSum(root, 22))  # True
