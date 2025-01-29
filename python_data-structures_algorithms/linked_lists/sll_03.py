class Node:
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

class SinglyLinkedList:
    def __init__(self, node=None):
        self.head = node

    def append(self, data):
        if self.head is None:
            self.head = Node(data)
        else:
            curr_node = self.head

            while curr_node.right:
                curr_node = curr_node.right

            curr_node.right = Node(data)

    def print_sll(self):
        if self.head is None:
            print("SLL is empty")
        else:
            curr_node = self.head

            while curr_node:
                print(curr_node.data, "->", end=" ")
                curr_node = curr_node.right

            print("None")

    def reverse(self):
        if self.head is None:
            print("SLL is empty")
        else:
            
            prev_node = None
            curr_node = self.head
            next_node = curr_node.right

            while curr_node:
                curr_node.right = prev_node
                prev_node = curr_node
                curr_node = next_node
                next_node = curr_node.right if curr_node else None
                if curr_node is None:
                    self.head = prev_node



if __name__ == "__main__":
    sll = SinglyLinkedList()

    arr = [1, 2, 3, 4, 5]

    for n in arr:
        sll.append(n)

    sll.print_sll()

    sll.reverse()

    sll.print_sll()

    
