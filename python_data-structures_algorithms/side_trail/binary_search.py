def binary_search(arr, value):
    low = 0
    high = len(arr) - 1
    mid = 0

    while low <= high:
        mid = (high + low) // 2

        # if value is greater, ignore left half
        if arr[mid] < value:
            low = mid + 1
        # if value is smaller, ignore right half
        elif arr[mid] > value:
            high = mid - 1
        # means value is present at mid
        else: 
            return mid
        
    # if value not present
    return -1


  

if __name__ == "__main__":
    arr = [1, 4, 56, 7, 9, 4, 7, 5, 9, 0, 123]
    arr.sort()
    print(arr)
    value = 9
    print(f"Value ({value}) found at index: {binary_search(arr, value)}")
    value = 124
    print(f"Value ({value}) found at index: {binary_search(arr, value)}")
    
