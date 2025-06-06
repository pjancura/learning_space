def kadane_with_index(arr: list[int]) -> list[int]:
    max_sum = arr[0]
    curr_sum = arr[0]
    start_i = 0
    end_i  = 0
    temp_start_i = 0

    for i in range(1, len(arr)):
        if curr_sum < 0:
            curr_sum  = arr[i]
        else:
            curr_sum  += arr[i]

        if curr_sum >= max_sum:
            end_i = i + 1
            max_sum = curr_sum
            if temp_start_i != 0:
                start_i = temp_start_i

        if curr_sum < 0:
            temp_start_i = i + 1

    return arr[start_i: end_i], max_sum

if __name__ == "__main__":
    # arr = [2, 3, -8, 7, -1, 2, 3]
    arr = [5, 6, -3, 7, -13, 8, -2, 5, -6, 7, -11, 3, 10, -10, -6, -10, 7, 2]
    print(kadane_with_index(arr))    