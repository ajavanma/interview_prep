import Optional

# Given a binary tree, determine if it is height-balanced
# A height-balanced binary tree:
#  a binary tree in which the depth of the two subtrees of every node never differs by more than one

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def checkHeight(node):
            if not node:
                return 0  # An empty tree has height 0 and is balanced
            
            leftHeight = checkHeight(node.left)
            if leftHeight == -1:
                return -1  
            
            rightHeight = checkHeight(node.right)
            if rightHeight == -1:
                return -1 
            
            if abs(leftHeight - rightHeight) > 1:
                return -1  
            
            return max(leftHeight, rightHeight) + 1  # Return the height of the current node

        # The tree is balanced if the helper does not return -1
        return checkHeight(root) != -1
