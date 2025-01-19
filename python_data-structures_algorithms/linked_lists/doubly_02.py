from typing import Self

class Node():
    def __init__(self, data: int | str | float, left: Self = None, right: Self = None) -> None:
        self.data = data
        self.left = left
        self.right = right

class DoublyLinkedList():
    def __init__(self) -> None:
        self.head: Node = None

    def prepend(self, data: any) -> None:
        if self.head is None:
            self.head = Node(data)
        else:
            new_node = Node(data)
            new_node.right = self.head
            self.head.left = new_node
            self.head = new_node

    def append(self, data:any) -> None:
        if self.head is None:
            self.head = Node(data)

        else:
            new_node = Node(data)
            curr_node = self.head

            while curr_node.right:
                curr_node = curr_node.right
            
            curr_node.right = new_node
            new_node.left = curr_node

    def remove_head(self) -> None:
        if self.head is None:
            print("DoublyLinkedList is empty")
        elif self.head.right is None:
            self.head = None
        else:
            self.head = self.head.right
            self.head.left = None

    def remove_tail(self) -> None:
        if self.head is None:
            print("DoublyLinkedList is empty")

        elif self.head.right is None:
            self.head = None
        else:
            curr_node = self.head

            while curr_node.right:
                curr_node = curr_node.right
            
            curr_node.left.right = None
            curr_node.right = None

    def insert_at_index(self, index: int, data: any) -> None:
        if self.head is None:
            print("DoublyLinkedList is empty")
        else:
            curr_node = self.head

            while index - 1> 0 and curr_node:
                curr_node = curr_node.right
                index -= 1

            if index - 1 == 0:
                new_node = Node(data)
                curr_node.right.left = new_node
                new_node.right = curr_node.right
                curr_node.right = new_node
                new_node.left = curr_node
            else:
                print("Index out of bounds error")

    def delete_node(self, data: any) -> None:
        if self.head is None:
            print("DoublyLinkedList is empty") 
        else:
            curr_node = self.head

            while curr_node.data != data:
                curr_node = curr_node.right

            if curr_node.data == data:
                curr_node.right.left = curr_node.left
                curr_node.left.right = curr_node.right
            else:
                print("Data does not exist in DoublyLinkedList")

    def reverse_dll(self) -> None:
        if self.head is None:
            print("DoublyLinkedList is empty") 
        else:
            curr_node = self.head

            while curr_node:
                if curr_node.right == None:
                    curr_node.right = curr_node.left
                    curr_node.left = None
                    self.head = curr_node
                    break

                temp = curr_node.right
                curr_node.right = curr_node.left
                curr_node.left = temp
                curr_node = curr_node.left

                # elif curr_node.left == None:
                #     curr_node.left = curr_node.right
                #     curr_node.right = None
                #     curr_node = curr_node.left
                # else:
                #     temp = curr_node.right
                #     curr_node.right = curr_node.left
                #     curr_node.left = temp
                #     curr_node = curr_node.right
                

    def print_dll(self):
        curr_node = self.head

        while curr_node:
            print(curr_node.data, "<->", sep=" ", end=" ")
            curr_node = curr_node.right
        if self.head is None:
            print("DoublyLinkedList is empty")
        else:
            print("None")

if __name__ == "__main__":
    head = DoublyLinkedList()

    head.reverse_dll()
    head.append(150)
    head.reverse_dll()
    head.prepend(4)
    head.prepend(3)
    head.prepend(2)
    head.prepend(1)
    head.append(10)
    head.remove_head()
    head.reverse_dll()
    head.print_dll()
    # head.remove_head()
    # head.print_dll()
    # head.remove_head()
    # head.print_dll()
    # head.remove_head()
    # head.print_dll()
    # head.remove_head()
    # head.print_dll()
    # head.remove_head()
    # head.print_dll()
    # head.remove_head()
    # head.print_dll()
    head.remove_tail()
    # head.remove_tail()
    # head.remove_tail()
    # head.remove_tail()
    # head.remove_tail()
    # head.remove_tail()
    # head.remove_tail()
    head.insert_at_index(2, 25)
    head.insert_at_index(1, 100)
    head.print_dll()
    head.delete_node(100)
    head.print_dll()
    head.delete_node(4)

    # # to traverse and print the nodes:
    head.print_dll()
    # head.print_doubly_linked_list(backwards=True)
        