def find_missing_no(arr: list[int]) -> int:
    result = [0 for n in range(len(arr) + 1)]

    for i in range(len(arr)):
        n = arr[i] - 1
        result[n] = n + 1

    for i in range(len(result)):
        if result[i] == 0:
            return i + 1
        
    return -1

if __name__ == "__main__":
    test_arrays = [
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],  # Missing 10
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],  # Missing 1
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19],  # Missing 20
        [1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],  # Missing 7
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20]   # Missing 18
    ]

    for a in test_arrays:
        print(find_missing_no(a))


# Test Case 1: Missing Middle Number
# Input Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
# Missing Number: 10
# Expected Output: 10

# Test Case 2: Missing First Number
# Input Array: [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
# Missing Number: 1
# Expected Output: 1

# Test Case 3: Missing Last Number
# Input Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
# Missing Number: 20
# Expected Output: 20

# Test Case 4: Missing Random Number
# Input Array: [1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
# Missing Number: 7
# Expected Output: 7

# Test Case 5: Missing Number Near End
# Input Array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20]
# Missing Number: 18
# Expected Output: 18