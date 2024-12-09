def maximum_subarray_sum(arr: list[int]) -> tuple[list[int]: int]:
    maximum = arr[0]
    curr_max = arr[0]
    start_i = 0
    end_i = 1

    for i in range(1, len(arr)):
        if curr_max > 0:
            curr_max += arr[i]
        else:
            curr_max = arr[i]
            if curr_max > maximum:
                start_i = i

        if curr_max > maximum:
            end_i = i + 1
            maximum = curr_max

    return arr[start_i: end_i], maximum

if __name__ == "__main__":
    arr = [[1, 1, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0], [-10, -1000, -1, -2], [2, 3, -8, 7, -1, 2, 3], [5, 6, -3, 7, -13, 8, -2, 5, -6, 7, -11, 3, 10, -10, -6, -10, 7, 2]]

    for a in arr:
        print(maximum_subarray_sum(a))
        