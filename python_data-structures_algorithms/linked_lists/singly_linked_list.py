from typing import Self

class Node:
    def __init__(self, data=None) -> None:
        # Data stored in the node
        self.data = data
        # Reference to the next node in the lingly linked list
        self.next = None

class Singly_Linked_List:

    def __init__(self) -> None:
        self.head = None

    def insert_at_beginning(self, data: any) -> None:
        new_node = Node(data)
        new_node.next = self.head # new node points to current head
        self.head = new_node # head is updated to point to the new node

    
    def traverse(self) -> None:
        current: Self = self.head
        while current:
        # Print the current node's data followed by an arrow and space
            print(str(current.data) + " -> ", end=" ")
            current = current.next
        
        # At the end of the list, print None to indicate no more nodes
        print("None")

if __name__ == "__main__":
    head = Singly_Linked_List()

    head.insert_at_beginning(4)
    head.insert_at_beginning(3)
    head.insert_at_beginning(2)
    head.insert_at_beginning(1)

    # # to traverse and print the nodes:
    head.traverse()
