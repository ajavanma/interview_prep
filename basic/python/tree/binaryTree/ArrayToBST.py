import Optional
from typing import List

# Given an integer array (nums) where the elements are sorted in ascending order, convert it to a height-balanced* binary search tree.
#  * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
 

# Approach: Recursion
class convertArrayToBinarySearchTree:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def _convert(left: int, right: int) -> Optional[TreeNode]:
            if len(nums) == 0:
                return None
            if left > right:
                return None
            
            mid = (left + right) // 2     # // is floor division; / results in float; Python has built-in big integer support, which means it can handle large integers automatically without overflow
            node = TreeNode(nums[mid])   # nums is written from the outer functions (not possible in java) 
            node.left = _convert(left, mid - 1)
            node.right = _convert(mid + 1, right)
            return node

        return _convert(0, len(nums) - 1)
    
    
# approach 2: checking the length and passing num in as the first parameter
class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        def _sortedArrayToBST(nums: List[int], left: int, right: int) -> Optional[TreeNode]:
            if len(nums) == 0:
                return None
            if left > right:
                return None
            
            mid = left + (right - left) // 2   # // is floor division; / results in float
            node = TreeNode(nums[mid])
            node.left = _sortedArrayToBST(nums, left, mid - 1)
            node.right = _sortedArrayToBST(nums, mid + 1, right)
            return node
        
        return _sortedArrayToBST(nums, 0, len(nums) - 1)