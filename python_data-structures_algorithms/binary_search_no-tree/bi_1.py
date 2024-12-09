def binary_search(arr: list[int], n: int) -> int:
    l = len(arr)
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2 # find the middle index

        if arr[mid] == n:
            return mid
        elif arr[mid] < n:
            left = mid + 1 # search right half
        else:
            right = mid - 1 # search left half
    
    return -1

if __name__ == "__main__":

    arrays = [
        [1, 3, 5, 7, 9, 11, 13, 15, 17, 19], 
        [2, 4, 6, 8, 10, 12, 14, 16, 18, 20],
        [5, 10, 15, 20, 25, 30, 35, 40, 45, 50],
        [3, 6, 9, 12, 15, 18, 21, 24, 27, 30],
        [42]
    ]

    queries = [11, 2, 50, 7, 42]

    for a, q in zip(arrays, queries):
        print(binary_search(a, q))

# Answers: 5, 0, 9, -1, 0


# Query 1: Middle Element
# Array: [1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
# Search Integer: 11
# Expected Output: 5 (index of the element)

# Query 2: First Element
# Array: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
# Search Integer: 2
# Expected Output: 0 (index of the element)

# Query 3: Last Element
# Array: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]
# Search Integer: 50
# Expected Output: 9 (index of the element)

# Query 4: Element Not Present
# Array: [3, 6, 9, 12, 15, 18, 21, 24, 27, 30]
# Search Integer: 7
# Expected Output: -1 (indicating not found)

# Query 5: Single Element Array
# Array: [42]
# Search Integer: 42
# Expected Output: 0 (index of the element)