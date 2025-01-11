from typing import Self

class Node():

    def __init__(self, data: any, left: Self = None, right:Self = None) -> None:
        self.data = data
        self.left = left
        self.right = right


class DoublyLinkedList():
    def __init__(self):
        self.head = None

    def prepend(self, data: any) -> None:          
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
        else:
            new_node.right = self.head
            self.head.left = new_node
            self.head = new_node

    def append(self, data: any) -> None:
        new_node = Node(data)

        curr_node = self.head

        while curr_node.right:
            curr_node = curr_node.right

        new_node.left = curr_node
        curr_node.right = new_node


    def print_doubly_linked_list(self, backwards: bool = False) -> None:
        curr_node = self.head
        if curr_node.right == None:
            print("Doubly Linked List is empty")
            return
        if not backwards:
            while curr_node:
                print(f"{curr_node.data} -> ", end=" ")
                curr_node = curr_node.right

            print("None")
        else:
            values = []
            values.append(curr_node.data)
            while curr_node.right:
                curr_node = curr_node.right
                values.append(curr_node.data)

            print("None", end=" ")
            for v in reversed(values):
                print(f"-> {v}", end=" ")

    def remove_head(self) -> None:
        if self.head is None:
            self.print_empty_list()

        elif self.head.right is None:
            self.head = None

        else:
            self.head = self.head.right
            self.head.left = None

    def remove_tail(self) -> None:
        if self.head is None:
            self.print_empty_list()
        elif self.head.right is None:
            self.head = None
        else:
            curr_node = self.head
            while curr_node.right:
                curr_node = curr_node.right

            curr_node.left.right = None

    def insert_at_index(self, index: int, data: any) -> None:
        new_node = Node(data)
        if self.head is None and index == 0:
            self.head = new_node
        elif self.head is None and index != 0:
            self.print_empty_list()
        else:
            curr_node = self.head
            while index - 1 != 0:
                curr_node = curr_node.right
                index -= 1

            if index - 1 > 0:
                print(f"Index out of range")
            else:
                new_node.right = curr_node.right
                new_node.left = curr_node
                curr_node.right = new_node  

    def delete_node(self, key: any) -> None:
        if self.head is None:
            self.print_empty_list()

        else:
            curr_node = self.head

            while curr_node.data != key and curr_node:
                curr_node = curr_node.right

            if curr_node.data is None:
                print(f"Value not in DoublyLinkedList")              
            else:
                curr_node.left.right = curr_node.right
                curr_node.right = curr_node.left
        

    def print_empty_list(self):
        print(f"Doubly Linked List is Empty")

if __name__ == "__main__":
    head = DoublyLinkedList()

    head.prepend(4)
    head.prepend(3)
    head.prepend(2)
    head.prepend(1)
    head.append(10)
    head.remove_head()
    head.remove_tail()
    head.insert_at_index(2, 25)
    head.insert_at_index(1, 100)
    head.print_doubly_linked_list()
    head.delete_node(100)
    # head.traverse()
    # head.delete_node(4)

    # # to traverse and print the nodes:
    head.print_doubly_linked_list()
    head.print_doubly_linked_list(backwards=True)


        
