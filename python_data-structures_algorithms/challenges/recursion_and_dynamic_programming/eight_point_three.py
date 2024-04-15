# magic index
#       a magic index is descirbed as a[i] = i
#       assume the array is sorted, numbers may or may not be distinct

def find_magic_index(arr):
    if len(arr) == 0:
        return -1
    arr.sort()
    for i in range(len(arr)):
        if arr[i] == i:
            return i
    return -1

#                              NON-DISTINCT ELEMENTS
def find_magic_index_non_distinct(arr, start = 0, end = 0):
    if start == 0 and end == 0:
        end = len(arr) -1
    print(f'start: {start}, end: {end}')
    if end < start:
        return -1
    mid = (start + end) // 2
    mid_value = arr[mid]
    print(f'mid: {mid}, mid_value: {mid_value}')
    if mid == mid_value:
        return mid
    
    # looking to the left (smaller values)
    left_index = min(mid - 1, mid_value)
    left = find_magic_index_non_distinct(arr, start, left_index)
    if left >= 0:
        return left
    
    # looking to the right (larger values)
    right_index = max(mid + 1, mid_value)
    right = find_magic_index_non_distinct(arr, right_index, end)
    return right

#                                       BOOK SOLUTION 1  (USING DISTINCT ELEMENTS)
def find_magic_index_book_one(arr, start = 0, end = 0):
    if start == 0 and end == 0:
        end = len(arr) - 1
    print(f'start: {start}, end: {end}')
    if end < start:
        return -1
    mid = (start + end) // 2
    print(f'mid: {mid}')
    if arr[mid] == mid:
        # print(f'mid: {mid}')
        return mid
    elif arr[mid] > mid:
        return find_magic_index_book_one(arr, 0, mid)
    else:
        return find_magic_index_book_one(arr, mid, len(arr) - 1)
    

if __name__ == "__main__":
    ints = [-10, 1, 2, 4, 6, 8, 10, 40, 56, 62, 90, 100, 102, 165, 180]

    print(find_magic_index(ints))

    print(find_magic_index_book_one(ints))

    non_distinct_ints = [1, 1, 1, 1, 1, 1, 10, 40, 56, 62, 90, 100, 102, 165, 180]

    print(find_magic_index_non_distinct(non_distinct_ints))