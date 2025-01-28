from typing import Self, Literal, Optional

class Node:
    def __init__(self, data: any, left: Self = None, right: Self = None) -> None:
        self.data = data
        self.left = left
        self.right = right

class BinarySearchTree:
    def __init__(self, root: Node = None) -> None:
        self.root: Node = root

    def insert(self, data: any) -> None:
        if self.root is None:
            self.root = Node(data)
        else:
            self._insert(data, self.root)

    def _insert(self, data: any, node: Node) -> None:
        if data <= node.data:
            if node.left is None:
                node.left = Node(data)
            else:
                self._insert(data, node.left)
        else:
            if node.right is None:
                node.right = Node(data)
            else:
                self._insert(data, node.right)

    def _inorder_traversal(self, node: Node) -> None:
        if node is not None:
            self._inorder_traversal(node.left)
            print(node.data, end=" ")
            self._inorder_traversal(node.right)

    def search(self, data: any) -> Optional[Node]:
        if self.root is None:
            print("Binary Tree is empty")
        else:
            curr_node = self.root

            while curr_node:
                if data == curr_node.data:
                    return curr_node
                if data < curr_node.data:
                    curr_node = curr_node.left
                


if __name__ == "__main__":
    bst = BinarySearchTree()
    
    arr_1 = [15, 10, 20, 8, 12, 17, 25, 13]

    for a in arr_1:
        bst.insert(a)

    bst._inorder_traversal(bst.root)