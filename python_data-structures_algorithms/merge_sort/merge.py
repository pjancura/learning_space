def merge_sort(arr):
    print(arr)
    if len(arr) <= 1:
        return arr
    
    mid = len(arr) // 2
    left = merge_sort(arr[0:mid])
    right = merge_sort(arr[mid:])

    return merge(left, right)

def merge(left, right):
    print("left: ", left, "right: ", right)
    result = []
    i = j = 0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1

    result.extend(left[i:])
    result.extend(right[j:])
    return result


if __name__ == "__main__":
    arr = [38, 27, 43, 3, 9, 82, 10]
    sorted_arr = merge_sort(arr)
    print(sorted_arr)  # Output: [3, 9, 10, 27, 38, 43, 82]