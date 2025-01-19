from typing import Self

class Node():
    def __init__(self, data: any = None, left: Self = None, right: Self = None) -> None:
        self.data = data
        self.left = left
        self.right = right

class SinglyLinkedList():
    def __init__(self, data: any = None) -> None:
        if data:
            self.head = Node(data)
        else:
            self.head = None

    def append(self, data: any) -> None:
        new_node = Node(data)
        
        if self.head is None:
            self.head = new_node

        else:
            curr_node = self.head

            while curr_node.right:
                curr_node = curr_node.right

            curr_node.right = new_node

    def reverse_list(self) -> None:
        if self.head is None:
            print("Singly Linked List is empty")
        else:
            curr_node = self.head
            prev_node = None
            next_node = curr_node.right   

            while curr_node:
                p_d = prev_node.data if prev_node else None
                c_d = curr_node.data if curr_node else None
                n_d = next_node.data if next_node else None
                print(p_d, c_d, n_d)
                curr_node.right = prev_node
                prev_node = curr_node
                curr_node = next_node
                next_node = curr_node.right if curr_node else None
                if not curr_node:
                    self.head = prev_node    

    def print_sll(self) -> None:
        if self.head is None:
            print("Singly Linked List is empty")
        else:
            curr_node = self.head

            while curr_node:
                print(curr_node.data, "->", end=" ")
                curr_node = curr_node.right

            print("None")


if __name__ == "__main__":
    sll = SinglyLinkedList()

    arr = [5, 4, 3, 2, 1]

    sll.append(20)
    sll.reverse_list()
    sll.print_sll()

    for a in arr:
        sll.append(a)

    sll.reverse_list()
    sll.print_sll()
        