def missing_no(arr: list[int]) -> int:
    n = len(arr) + 1

    curr_sum = sum(arr)

    expected_sum = (n * (n + 1)) // 2

    return expected_sum - curr_sum

if __name__ == "__main__":
    test_arrays = [
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],  # Missing 10
        [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],  # Missing 1
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19],  # Missing 20
        [1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20],  # Missing 7
        [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20]   # Missing 18
    ]

    for a in test_arrays:
        print(missing_no(a))