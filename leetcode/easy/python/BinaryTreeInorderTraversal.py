from typing import Optional, List

# Given the root of a binary tree, return the inorder traversal of its nodes' values.
# example:
# Input: root = [1,null,2,3]
# Output: [1,3,2]

# Definition for a binary tree node.
# Python's dynamic nature and support for default arguments make it unnecessary to define a separate constructor for when only a value is given
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result, stack = [], []
        current = root
        
        while current or stack:
            while current:
                stack.append(current)
                current = current.left
            current = stack.pop()
            result.append(current.val)
            current = current.right
        
        return result
