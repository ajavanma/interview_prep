package leetcode.easy.java;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


// Given the root of a binary tree, return the inorder traversal of its nodes' values.
// example:
// Input: root = [1,null,2,3]
// Output: [1,3,2]

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    // constructor to initialize the TreeNode
    TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();      // stack to keep track of the nodes
        TreeNode current = root;                   // current pointer starts at the root

        // Traverse the leftmost branch of the tree, pushing nodes onto the stack as you go
        // Once you reach a leaf (where current becomes null), pop a node from the stack, add its value to the result list, and move to its right child
        // Repeat this process until both the stack is empty and the current node is null, which means you've traversed the entire tree
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        
        return result;
    }
}
