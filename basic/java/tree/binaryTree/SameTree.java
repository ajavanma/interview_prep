package java.tree.binaryTree;


// Given the roots of two binary trees p and q, write a function to check if they are the same or not.
// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



public class SameTree {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        // Recursively check the left subtree and the right subtree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}




// // usage:
// public class Main {
//     public static void main(String[] args) {
//         // Create first pair of trees that are the same
//         TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//         TreeNode node2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

//         // Create second pair of trees that are different
//         TreeNode node3 = new TreeNode(1, new TreeNode(2), null);
//         TreeNode node4 = new TreeNode(1, null, new TreeNode(2));

//         SameTree sol = new SameTree();
        
//         // Check if first pair of trees are the same
//         System.out.println("Tree 1 and Tree 2 are the same: " + sol.isSameTree(node1, node2)); // true
        
//         // Check if second pair of trees are the same
//         System.out.println("Tree 3 and Tree 4 are the same: " + sol.isSameTree(node3, node4)); // false
//     }
// }
