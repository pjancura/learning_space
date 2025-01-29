import datetime

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
                else:
                    curr_node = curr_node.right

    def search_level_order(self, target, start_node=None):
        if self.root is None:
            print("binary tree is empty")
        else:
            queue = []
            if start_node is None:
                queue.append(self.root)
            else:
                queue.append(start_node)

            while len(queue) > 0:
                level_length = len(queue)
                for _ in range(level_length):
                    curr_node = queue.pop(0)
                    if curr_node.data == target:
                        return curr_node
                    if curr_node.left:
                        queue.append(curr_node.left)
                    if curr_node.right:
                        queue.append(curr_node.right)
            return None
        
    def _bst_level_traversal(self, node: Node) -> None:
        if node is None:
            return None

        queue: list[Node] = [node]
        while queue:
            level_size = len(queue)
            level_values = []
            for _ in range(level_size):
                node = queue.pop(0)
                level_values.append(node.data)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            print(level_values)
                


if __name__ == "__main__":
    bst = BinarySearchTree()
    
    arr_1 = [15, 10, 20, 8, 12, 17, 25, 13]

    for a in arr_1:
        bst.insert(a)

    bst._inorder_traversal(bst.root)
    print()
    bst._bst_level_traversal(bst.root)

    found_node = bst.search_level_order(20)

    print(found_node.data)

    found_node = bst.search_level_order(25, found_node)

    print(found_node.data if found_node else None)


    print(datetime.datetime.now().strftime("%Y-%m-%d"))