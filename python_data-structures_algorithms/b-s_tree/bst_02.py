class Node():
    def __init__(self, data = None, left = None, right = None):
        self.data = data
        self.left = left
        self.right = right

class BinarySearchTree():
    def __init__(self, data=None):
        if data:
            self.root = Node(data)
        else:
            self.root = None

    def insert(self, data):
        new_node = Node(data)
        if self.root is None:
            self.root = new_node
        else:
            self._insert(data, self.root)

    def _insert(self, data, node):
        if data < node.data:
            if node.left is None:
                node.left = Node(data)
            else:
                self._insert(data, node.left)
        else:
            if node.right is None:
                node.right = Node(data)
            else:
                self._insert(data, node.right)

    def print_levels(self):
        if self.root is None:
            print("BinarySearchTree is empty")
        else:
            queue = [self.root]

            while len(queue) > 0:
                level_size = len(queue)
                level_values = []

                for i in range(level_size):
                    popped = queue.pop(0)
                    level_values.append(popped.data)
                    if popped.left:
                        queue.append(popped.left)
                    if popped.right:
                        queue.append(popped.right)

                print(level_values, sep=" ")

    # Function to perform level order traversal
    def levelOrder(self):
        res = []
        self.levelOrderRec(self.root, 0, res)
        return res
    
    # Helper function for recursive level order traversal
    def levelOrderRec(self, root, level, res):
        if not root:
            return

        # Add a new level to the result if needed
        if len(res) <= level:
            res.append([])

        # Add current node's data to its corresponding level
        res[level].append(root.data)

        # Recur for left and right children
        self.levelOrderRec(root.left, level + 1, res)
        self.levelOrderRec(root.right, level + 1, res)


    

if __name__ == "__main__":

    bst = BinarySearchTree()
    
    arr_1 = [15, 10, 20, 8, 12, 17, 25, 13]

    for a in arr_1:
        bst.insert(a)

    bst.print_levels()

    res = bst.levelOrder()
    # Print the result
    for level in res:
        for data in level:
            print(data, end=" ")
        print()
