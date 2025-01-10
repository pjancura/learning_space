def kadane_ret_subarray(arr: list[int]) -> list[int]:
    if len(arr) == 0:
        return arr
    
    curr_max = arr[0]
    maximum = arr[0]
    start = 0
    end = start + 1

    for i in range(1, len(arr)):

        if curr_max > 0:
            curr_max += arr[i]
        else:
            curr_max = arr[i]
            if curr_max > maximum:
                start = i
                end = i + 1
        
        if curr_max >= maximum:
            maximum = curr_max
            end = i + 1

    return arr[start:end]

if __name__ == "__main__":
    arr = [[1, 1, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0], [-10, -1000, -1, -2], [2, 3, -8, 7, -1, 2, 3], [5, 6, -3, 7, -13, 8, -2, 5, -6, 7, -11, 3, 10, -10, -6, -10, 7, 2], []]

    for a in arr:
        print(kadane_ret_subarray(a))

        