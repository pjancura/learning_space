class OrderedArray(object):
    def __init__(self, initialSize):        # Constructor
        self.__a = [None] * initialSize     # the array stored as a list
        self.__nItems = 0                     # No items in array initially

    def __len__(self):                      # Special def for len() func
        return self.__nItems                # Return number of items
    
    def get(self, n):                       # Return the value at index n
        if 0 <= n and n < self.__nItems:    # check if n is in bounts, and
            return self.__a[n]              # only return item if in bounds
        raise IndexError(f"Index {str(n)} is out of range")     
        
    # Set is left out because that would allow a user
    # to change the order fo the array and then rendering
    # the binary search moot

    def insert(self, item):                     # Insert item into correct position
            if self.__nItems >= len(self.__a):  # If array is full,
                raise Exception("Array overflow")   # raise exception
            index = self.find(item)             # Find index where Item should go
            for j in range(self.__nItems, index, -1):   # Move bigger items
                self.__a[j] = self.__a[j-1]       # to the right
            self.__a[index] = item      # Item goes at current end
            self.__nItems += 1                  # Increment number of items

                                                # this is an example of binary search 
                                                # dividng the ordered array into halves and being able
                                                # to eliminate half of the possible places to look
                                                # make this a more effective way to find elements            
    def find(self, item):                       # find index at or just below
        lo = 0                                  # item in ordered list
        hi = self.__nItems - 1                  # Look between lo and hi
        while lo <= hi:                         
            mid = (lo + hi) // 2                # Select the midpoint
            if self.__a[mid] == item:           # did we find it at midpoint?
                return mid                      # return location of item
            elif self.__a[mid] < item:          # is item in upper half?
                lo = mid + 1                    # yes, raise the lo boundary
            else:
                hi = mid - 1                    # No, but could be in lower half
        return lo                               # Item not found, return insertion point instead
        

    def search(self, item):                     # Search for item    
        index = self.find(item)
        if index < self.__nItems and self.__a[index] == item:
            return self.__a[index]        # and return item if found

    def delete(self, item):                     # Delete any occurrence
        j = self.find(item)                     # Try to find the item
        if j < self.__nItems and self.__a[j] == item:   # If found,
            self.__nItems -= 1                  # One fewer at end
            for k in range(j, self.__nItems):  # Move bigger items left
                    self.__a[k] = self.__a[k+1] # 
            return True                         # return success flag    
        return False                            # Made it here, so couldn't find the item

    def traverse(self, function=print):         # Traverse all items
        for j in range(self.__nItems):            # and apply a function
            function(self.__a[j])

    def __str__(self):                          # Special def for str() func
        ans = "["                               # Surround with square brackets
        for i in range(self.__nItems):          # Loop through items
            if len(ans) > 1:                    # Except next to left bracket,
                ans += ", "                     # separate items with comma
            ans += str(self.__a[i])             # Add string form of item
        ans += "]"                              # Close with right bracket
        return ans