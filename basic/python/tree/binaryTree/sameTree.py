from typing import Optional


# Given the roots of two binary trees p and q, write a function to check if they are the same or not.
# Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # If both nodes are None, then we've reached the end of both trees at this branch
        if not p and not q:
            return True
        # If only one of the nodes is None or the values do not match, trees are not the same
        if not p or not q or p.val != q.val:
            return False
        # Recursively check the left and right subtrees
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)



# Usage:
node1 = TreeNode(1, TreeNode(2), TreeNode(3))
node2 = TreeNode(1, TreeNode(2), TreeNode(3))
sol = Solution()
print(sol.isSameTree(node1, node2))  # True

node3 = TreeNode(1, TreeNode(2))
node4 = TreeNode(1, None, TreeNode(2))
print(sol.isSameTree(node3, node4))  # False
