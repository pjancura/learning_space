def maxSubarraySum(arr):
    max_sum = arr[0]
    curr_sum = arr[0]
    start_index = 0
    end_index = 0
    temp_start_index = 0

    for i in range(1, len(arr)):
        if curr_sum >= 0:
            curr_sum += arr[i]
        else:
            curr_sum = arr[i]

        print(f"curr_sum: {curr_sum}\tmax_sum: {max_sum}")
        if max_sum < curr_sum:
            max_sum = curr_sum
            end_index = i + 1
            if temp_start_index != 0:
                start_index = temp_start_index

        if curr_sum < 0 :
            temp_start_index = i + 1
        print(start_index, end_index)
    max_elements = arr[start_index: end_index]
    return max_elements, sum(max_elements)

if __name__ == "__main__":
    # arr = [2, 3, -8, 7, -1, 2, 3]
    arr = [5, 6, -3, 7, -13, 8, -2, 5, -6, 7, -11, 3, 10, -10, -6, -10, 7, 2]
    print(maxSubarraySum(arr))