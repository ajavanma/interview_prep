class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinarySearchTree:
    def __init__(self):
        self.root = None

    # insert a node in a binary search tree
    def insert(self, value):
        self.root = self._insert(self.root, value)

    def _insert(self, root, value):
        if root is None:
            return TreeNode(value)
        if value < root.data:
            root.left = self._insert(root.left, value)
        else:
            root.right = self._insert(root.right, value)
        return root

    # in-order traversal of a binary search tree
    # left, root, right
    def in_order(self):
        self._in_order(self.root)
        print()  # New line 

    def _in_order(self, root):
        if root is not None:
            self._in_order(root.left)
            print(root.data, end=' ')
            self._in_order(root.right)

    # validate if a given tree is a binary search tree
    def is_valid(self, root=None, min=float('-inf'), max=float('inf')):
        if root is None:
            return True
        if not (min < root.data < max):
            return False
        return self.is_valid(root.left, min, root.data) and self.is_valid(root.right, root.data, max)

    # search a given key in a binary search tree (recursion)
    def search(self, key):
        return self._search(self.root, key)

    def _search(self, root, key):
        if root is None or root.data == key:
            return root
        if key < root.data:
            return self._search(root.left, key)
        return self._search(root.right, key)


# Example usage:
if __name__ == '__main__':
    bst = BinarySearchTree()
    bst.insert(5)
    bst.insert(3)
    bst.insert(7)
    bst.insert(1)

    bst.in_order()  # Outputs the sorted elements of the BST

    result = bst.search(10)
    if result:
        print("Key found!")
    else:
        print("Key not found!")
