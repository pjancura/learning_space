def merge_sort_in_place(arr):
    if len(arr) <= 1:
        return
    
    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    merge_sort_in_place(left)
    merge_sort_in_place(right)
    
    merge_two_sorted_lists(left, right, arr)

def merge_two_sorted_lists(a, b, arr):
    
    len_a = len(a)
    len_b = len(b)
    i = j = k = 0

    while i < len_a and j < len_b:
        if a[i] <= b[j]:
            arr[k] = a[i]
            i += 1
        else:
            arr[k] = b[j]
            j += 1
        k += 1

    while i < len_a:
        arr[k] = a[i]
        i += 1
        k += 1

    while j < len_b:
        arr[k] = b[j]
        j += 1
        k += 1

    # print(arr)


if __name__ == "__main__":
    arr = [
        [1, 2, 3, 4, 5],            # [1, 2, 3, 4, 5]
        [5, 4, 3, 2, 1],            # [1, 2, 3, 4, 5]
        [4, 2, 4, 3, 1, 3],         # [1, 2, 3, 3, 4, 4]
        [42],                       # [42]
        []                          # []
    ]
    for a in arr:
        merge_sort_in_place(a)
    for a in arr:
        print(a)


    
