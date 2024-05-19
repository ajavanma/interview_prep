from typing import Optional

# Given the root of a binary tree, invert the tree, and return its root.

# Input: root = [4,2,7,1,3,6,9]
# Output: [4,7,2,9,6,3,1]

# Time complexity: O(N)
# Space complexity: O(N) Recursive stack space

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return root
        
        root.left, root.right = root.right, root.left   # swap can also be done after the recursive call, but it would be slower!
        
        self.invertTree(root.left)
        self.invertTree(root.right) 

        return root