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

    def append(self, data: any) -> None:
        new_node = Node(data)
        current: Self = self.head
        while current.next != None:
            current = current.next

        current.next = new_node

    def prepend(self, data: any) -> None:
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

    def insert_at_index(self, index: int, data: any) -> None:
        count = 0
        current: Self = self.head
        while count < index - 1 and current:
            current = current.next
            count += 1

        if count < index - 1:
            print("index out of bounds")
        else:
            self._insert_after(current, data)

    def _insert_after(self, prev_node: Self, data: any) -> None:
            new_node = Node(data)
            new_node.next = prev_node.next
            prev_node.next = new_node

    def delete_node(self, key: any) -> None:
        curr_node = self.head
        prev_node = None
        
        while curr_node and curr_node.data != key:
            prev_node = curr_node
            curr_node = curr_node.next
        
        if not curr_node:
            print("Value not in list")
            return
        if prev_node:
            prev_node.next = curr_node.next
        else:
            self.head = curr_node.next

    

if __name__ == "__main__":
    head = Singly_Linked_List()

    head.prepend(4)
    head.prepend(3)
    head.prepend(2)
    head.prepend(1)
    head.append(10)
    head.insert_at_index(2, 25)
    head.insert_at_index(1, 100)
    head.traverse()
    head.delete_node(100)
    head.traverse()
    head.delete_node(4)

    # # to traverse and print the nodes:
    head.traverse()
