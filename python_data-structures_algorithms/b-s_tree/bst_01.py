from typing import Self, Literal, Optional

class Node:
    def __init__(self, value: any, left: Self = None, right: Self = None) -> None:
        self.value = value
        self.left = left
        self.right = right


class BinarySearchTree:
    def __init__(self, root: Node = None) -> None:
        self.root: Node = root

    def insert(self, value: any) -> None:
        if self.root is None:
            self.root = Node(value)
        else:
            self._insert(value, self.root)

    def _insert(self, value: any, node: Node) -> None:
        if value < node.value:
            if node.left is None:
                node.left = Node(value)
            else:
                self._insert(value, node.left)
        else:
            if node.right is None:
                node.right = Node(value)
            else:
                self._insert(value, node.right)

    def search(self, value: any) -> Optional[Node]:
        if self.root is None:
            return None
        
        node = self.root
        while node is not None:
            if value == node.value:
                return node
            elif value < node.value:
                node = node.left
            else:
                node = node.right
        
        return None
    
    def print_tree(self, traversal_type: Literal["inorder", "preorder", "postorder", "levels"] = "inorder") -> None:
        if self.root is None:
            print("Tree is empty")
        else:
            match traversal_type:
                case "inorder":
                    print("Inorder: ", end=" ")
                    self._inorder_traversal(self.root)
                case "preorder":
                    print("Preorder: ", end=" ")
                    self._preorder_traversal(self.root)
                case "postorder":
                    print("Postorder: ", end=" ")
                    self._postorder_traversal(self.root)
                case "levels":
                    print("Levels:")
                    self._bst_level_traversal(self.root)
                case _:
                    print("invalid traversal type")
        print()
                
    # retains the structure of the BST as it is printed on a single line
    def _inorder_traversal(self, node: Node) -> None:
        if node is not None:
            self._inorder_traversal(node.left)
            print(node.value, end=" ")
            self._inorder_traversal(node.right)
        
    # print the root node, then left and right subtrees (root, left, right) 
    def _preorder_traversal(self, node: Node) -> None:
        if node is not None:
            print(node.value, end=" ")
            self._preorder_traversal(node.left)
            self._preorder_traversal(node.right)

    # prints the left and right subtrees then the root (left, right, root)
    def _postorder_traversal(self, node: Node) -> None:
        if node is not None:
            self._postorder_traversal(node.left)
            self._postorder_traversal(node.right)
            print(node.value, end=" ")

    def _bst_level_traversal(self, node: Node) -> None:
        if node is None:
            return None

        queue: list[Node] = [node]
        while queue:
            level_size = len(queue)
            level_values = []
            for _ in range(level_size):
                node = queue.pop(0)
                level_values.append(node.value)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            print(level_values)

    
    def delete(self, value: any) -> None:
        if self.root is None:
            print(f"Error: Cannot delete value {value}. The tree is empty.")
        elif not self.search(value):
            print(f"Error: Value {value} not found in the tree.")
        else:
            self.root = self._delete(value, self.root)

    def _delete(self, value: any, node: Node) -> Node:
        self.print_tree(traversal_type="levels")
        print("value: ", value, "\t", "node.value: ", node.value if node is not None else "None")
        if node is None:
            return node
        
        if value < node.value:
            node.left = self._delete(value, node.left)
        elif value > node.value:
            node.right = self._delete(value, node.right)
        else:
            # case 1: node is a leaf
            if node.left is None and node.right is None:
                return None
            
            # case 2: node has one child
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            
            # case 3: node has two children
            temp = self._find_min(node.right)
            # switch the values of the inorder successor and the value to be deleted
            node.value = temp.value
            # delete the other node that had its value moved
            node.right = self._delete(temp.value, node.right)

        return node

    def _find_min(self, node: Node) -> Optional[Node]:
        if node is None:
            return None

        while node.left:
            node = node.left
        return node

    
if __name__ == "__main__":
    bst = BinarySearchTree()
    
    arr_1 = [15, 10, 20, 8, 12, 17, 25, 13]

    bst.delete(20)

    for a in arr_1:
        bst.insert(a)

    bst.print_tree()
    bst.print_tree(traversal_type="preorder")
    bst.print_tree(traversal_type="postorder")
    bst.print_tree(traversal_type="levels")


    n = bst.search(20)
    print(bst.search(20).value if bst.search(20) is not None else "None")
    print(bst.search(4).value if bst.search(4) is not None else "None")

    bst.delete(14)
    bst.delete(20)
    bst.print_tree(traversal_type="levels")
    bst.delete(15)
    bst.print_tree(traversal_type="levels")
    bst.delete(12)
    bst.print_tree(traversal_type="levels")




    

