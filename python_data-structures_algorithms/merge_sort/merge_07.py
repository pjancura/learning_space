def merge_sort(arr) -> list[int]:
    if len(arr) <= 1:
        return arr
    
    mid = len(arr) // 2
    left = arr[:mid]
    right = arr[mid:]

    left = merge_sort(left)
    right = merge_sort(right)

    return merge_two_lists(left, right)

def merge_two_lists(a, b) -> list[int]:
    result = []
    len_a = len(a)
    len_b = len(b)
    i = j = 0

    while i < len_a and j < len_b:
        if a[i] < b[j]:
            result.append(a[i])
            i += 1
        else:
            result.append(b[j])
            j += 1

    result.extend(a[i:])
    result.extend(b[j:])

    return result


if __name__ == "__main__":
    arr = [
        [1, 2, 3, 4, 5],            # [1, 2, 3, 4, 5]
        [5, 4, 3, 2, 1],            # [1, 2, 3, 4, 5]
        [4, 2, 4, 3, 1, 3],         # [1, 2, 3, 3, 4, 4]
        [42],                       # [42]
        []                          # []
    ]
    for a in arr:
        print(merge_sort(a))

        