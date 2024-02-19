class Node:
    def __init__(self, data, next_node):
        self.data = data
        self.next_node = next_node

class LinkedList:
    def __init__(self):
        self.head = None
    
    def insert_at_beginning(self, data):
        node = Node(data, self.head)
        self.head = node

    def insert_at_end(self, data):
        if self.head == None:
            self.head = Node(data, self.head)
            return
        
        itr = self.head
        while itr.next_node:
            itr = itr.next_node

        itr.next_node = Node(data, None)


    def print(self):
        if self.head == None:
            print("Linked List is empty")
            return

        itr = self.head
        ll_str = ''
        while itr:
            ll_str += str(itr.data) + " --> "
            itr = itr.next_node

        print(ll_str)

    def insert_values(self, data_list):
        for data in data_list:
            self.insert_at_end(data)

    def get_length(self):
        counter = 0
        itr = self.head
        while itr:
            counter += 1
            itr = itr.next_node
        
        return counter
    
    def remove_at(self, index):
        if index < 0 or index > self.get_length() - 1:
            raise Exception("Invalid Index")
        if index == 0:
            self.head = self.head.next_node
        counter = 0

        itr = self.head
        while itr.next_node:
            if counter == index - 1:
                itr.next_node = itr.next_node.next_node
                break
            itr = itr.next_node
            counter += 1

    def insert_at(self, index, data):
        if index < 0 or index > self.get_length() - 1:
            raise Exception("Invalid Index")
        if index == 0:
            self.insert_at_beginning(data)
        counter = 0
        itr = self.head
        while itr.next_node:
            if counter == index - 1:
                node = Node(data, itr.next_node)
                itr.next_node = node
                break
            itr = itr.next_node
            counter += 1




if __name__ == '__main__':
    ll = LinkedList()
    print(ll.get_length())
    ll.insert_at_beginning(5)
    ll.insert_values([1, 2, 3, 4, 6])
    ll.insert_at_end(50)
    ll.insert_at_beginning(25)
    print(ll.get_length())
    ll.remove_at(7)
    ll.insert_at(2, 24)
    ll.insert_at(0, 24)
    # ll.insert_at(10, 24)
    ll.print()
