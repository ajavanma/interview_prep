from collections import deque
from typing import Optional

# Given a binary tree, find its minimum depth.
# The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
# Note: A leaf is a node with no children.

# Breadth-First Search (BFS) approach. 

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        queue = deque([(root, 1)])  # "double-ended Queue" of pairs (node, depth): syntax = list of tuples

        while queue:
            node, depth = queue.popleft()
            
            # Check if this is a leaf node
            if not node.left and not node.right:
                return depth
            
            # Otherwise, add the children to the queue with incremented depth
            if node.left:
                queue.append((node.left, depth + 1))
            if node.right:
                queue.append((node.right, depth + 1))
        
        return 0  # This line is never reached because we return inside the loop
