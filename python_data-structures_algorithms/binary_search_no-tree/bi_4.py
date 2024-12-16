def binary_search(arr: list[int], target: int) -> int:
    right = len(arr) - 1
    left = 0

    while left <= right:
        mid = (right + left) // 2

        if target > arr[mid]:
            left = mid + 1
        elif target < arr[mid]:
            right = mid - 1
        else:
            return mid
    
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