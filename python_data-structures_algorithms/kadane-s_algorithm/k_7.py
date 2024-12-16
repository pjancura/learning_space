def maximum_subarray_sum(arr: list[int]) -> tuple[list[int], int]:
    curr = arr[0]
    maximum = arr[0]
    left_i = 0
    right_i = 1

    for i in range(1, len(arr)):
        if curr > 0:
            curr += arr[i]
        else:
            curr = arr[i]
            if curr > maximum:
                left_i = i

        if curr >= maximum:
            maximum = curr
            right_i = i + 1


    return arr[left_i: right_i], maximum


if __name__ == "__main__":
    arr = [[1, 1, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0], [-10, -1000, -1, -2], [2, 3, -8, 7, -1, 2, 3], [5, 6, -3, 7, -13, 8, -2, 5, -6, 7, -11, 3, 10, -10, -6, -10, 7, 2]]

    for a in arr:
        print(maximum_subarray_sum(a))