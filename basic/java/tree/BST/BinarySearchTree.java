package java.tree.BST;

public class BinarySearchTree {

   private TreeNode root;

   private class TreeNode {
      private int data;     // or val, of Generic type
      private TreeNode left;
      private TreeNode right;

      public TreeNode(int data) {
         this.data = data;
      }
   }
   //
   // insert a node in a binary search tree 
   //
   // recursive method
   //
   //    time complexity:
   //  best case: tree is balanced, meaning that for any given node, the heights of its left and right subtrees differ by at most one, 
   //    Time complexity: O(log n) 
   //     (in a balanced tree, the depth of the tree grows logarithmically with the number of nodes, 
   //     and the insert operation involves traversing from the root to a leaf node)
   //  worst case:  tree is skewed, meaning all the nodes are inserted in such a manner that the tree becomes essentially a linked list 
   //     the time complexity is O(n)  
   //
   // by implementing a self-balancing tree, such as an AVL tree or a red-black tree, worst case can be avoided
   //
   //   space complexity:
   //  worst case (skewed tree): O(n) 
   //  best case (balanced tree): O(log n)
   //
   public void insert(int value) {
      root = insert(root, value);
   }

   private TreeNode insert(TreeNode root, int value) {
      if (root == null) {
         root = new TreeNode(value);
         return root;
      }

      if (value < root.data) {
         root.left = insert(root.left, value);
      } else {
         root.right = insert(root.right, value);
      }
      return root;
   }

   // to print nodes into the console
   // left, root, right
   public void inOrder() {
      inOrder(root);
   }

   private void inOrder(TreeNode root) {
      if (root == null) {
         return;
      }
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
   }

   // validate if a given tree is a binary search tree
   // rule: Left < Right
   public boolean isValid(TreeNode root, long min, long max) {
      // base case
      if (root == null) return true;
  
      if (root.data <= min || root.data >= max) {
          return false;
      }
      
      // if we go to the left subtree:  min remains the same; max changes to parent value  (parent value is the root.data)
      // if we go to the right subtree: max remains the same; min changes to parent value
      boolean left = isValid(root.left, min, root.data);
      if (left) {
          boolean right = isValid(root.right, root.data, max);
          return right;
      }
      return false;
  }
  
   //
   // search a given key in a binary search tree (recursion)
   //
   // The Java compiler looks at the entire class to resolve method calls, 
   // so the placement of method definitions relative to each other within the same class is not significant for compilation.
   //
   // time and complexity: like insert 
   // 
   public TreeNode search(int key) {
      return search(root, key);
   }

   public TreeNode search(TreeNode root, int key) {
      // base case: nothing to search or not found or we found it
      if (root == null || root.data == key) { 
         return root;
      }

      if (key < root.data) {
         return search(root.left, key);
      } else {
         return search(root.right, key);
      }

   }

   public static void main(String[] args) {
      BinarySearchTree bst = new BinarySearchTree();
      bst.insert(5);
      bst.insert(3);
      bst.insert(7);
      bst.insert(1);

      bst.inOrder();

      System.out.println();

      if (null != bst.search(10)) {
         System.out.println("Key found !!!");
      } else {
         System.out.println("Key not found !!!");
      }
   }
}