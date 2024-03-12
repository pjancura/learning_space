# linked lists
class Node:
    def __init__(self, data = None, next = None):
        self.data = data
        self.next = next

class LinkedList:
    # points at the beginning of the linked list
    def __init__(self):
        self.head = None

    def insert_at_beginning(self, data):
        if self.head == None:
            print("None :head")
        else:
            print(str(self.head.next) + " :head")
        node = Node(data, self.head)
        self.head = node
        print(str(self.head.next) + " :head after addition")

    def print(self):
        if self.head is None:
            print("Linked list is empty")
            return
        
        itr = self.head
        ll_str = ''
        while itr:
            ll_str += str(itr.data) + " --> "
            itr = itr.next

        print(ll_str)

    def insert_at_end(self, data):
        print(self.head)
        if self.head is None:
            print("insert_at_end: head is NONE")
            self.head = Node(data, None)
            return
        
        itr = self.head
        print(itr)
        while itr.next:
            itr = itr.next  # when this becomes Null -> i am at the last node

        itr.next = Node(data, None)

    def insert_values(self, data_list):
        if not self.head:
            self.head = None
        for data in data_list:
            self.insert_at_end(data)

    def get_length(self):
        count = 0
        itr = self.head
        while itr:
            count += 1
            itr = itr.next

        return count
    
    def remove_at(self, index):
        if index < 0 or index >= self.get_length():
            raise Exception("Invalid Index")
        if index == 0:
            self.head = self.head.next
            return
        
        count = 0
        itr = self.head
        while itr:
            if count == index - 1:
                itr.next = itr.next.next
                break
            itr = itr.next
            count += 1

    def insert_at(self, index, data):
        if index < 0 or index > self.get_length():
            raise Exception("Invalid Index")
        
        if index == 0:
            self.insert_at_beginning(data)
        
        count = 0
        itr = self.head
        while itr:
            if count == index - 1:
                node = Node(data, itr.next)
                itr.next = node
                break
            itr = itr.next
            count += 1

    def insert_after_value(self, data_after, data_to_insert):
        # get index of data_after
        count = 0
        itr = self.head
        while itr.next:
            if itr.data == data_after:
                break
            itr = itr.next
            count += 1
            if count == self.get_length():
                raise Exception("Value Not in Linked List")
        # insert_at(index_of_data_after, data_to_insert)
        self.insert_at(count + 1, data_to_insert)

    def remove_by_value(self, data):
        # get index of data
        count = 0
        itr = self.head
        while itr.next:
            if itr.data == data:
                break
            itr = itr.next
            count += 1
            if count == self.get_length():
                raise Exception("Value not in Linked List")
                

        # remove_at(index)
        self.remove_at(count)
        
        

if __name__ == '__main__':
    ll = LinkedList()
    ll.insert_at_beginning(5)
    ll.insert_at_beginning(89)
    print(ll.head)
    ll.print()
    ll.insert_values(["banana", "mango", "grapes", "orange"])
    ll_2 = LinkedList() 
    ll_2.insert_values([1, 2, 3, 4])
    ll_2.print()
    ll.print()
    ll.insert_at_end(79)
    ll.remove_at(2)
    # ll.remove_at(20)
    ll.insert_at(0, "figs")
    ll.insert_at(2, "jackfruit")
    print(f"length: {ll.get_length()}")
    print(ll.head.next, ll.head.data)
    print(ll.head.next.next.next, ll.head.next.next.data)
    # next line raises an exception
    # ll.insert_after_value("apple", "pineapple")
    ll.insert_after_value("mango", "apple")
    ll.insert_after_value(79, "kiwi")
    ll.print()
    ll.remove_by_value("jackfruit")
    ll.remove_by_value(79)
    ll.remove_by_value("figs")
    ll.print()
    print(ll)
    ll_2.remove_by_value(1)
    ll_2.remove_by_value(4)
    ll_2.remove_by_value(3)
    ll_2.remove_by_value(2)
    ll_2.print()