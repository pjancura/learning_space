def merge_sort(elements, key='time_hours', descending=True):
    if len(elements) <= 1:
        return elements
    
    mid = len(elements) // 2
    left = elements[:mid]
    right = elements[mid:]

    left = merge_sort(left, key, descending)
    right = merge_sort(right, key, descending)

    return merge_two_sorted_iterables(left, right, key, descending)

def merge_two_sorted_iterables(a, b, key, descending):
    result = []
    len_a = len(a)
    len_b = len(b)
    i = j = 0

    while i < len_a and j < len_b:
        if descending != True:
            if a[i][key] <= b[j][key]:
                result.append(a[i])
                i += 1
            else:
                result.append(b[j])
                j += 1
        if descending == True:
            if a[i][key] > b[j][key]:
                result.append(a[i])
                i += 1
            else:
                result.append(b[j])
                j += 1

    result.extend(a[i:])
    result.extend(b[j:])

    return result

if __name__ == "__main__":
    elements = [
        { 'name': 'vedanth',   'age': 17, 'time_hours': 1},
        { 'name': 'rajab', 'age': 12,  'time_hours': 3},
        { 'name': 'vignesh',  'age': 21,  'time_hours': 2.5},
        { 'name': 'chinmay',  'age': 24,  'time_hours': 1.5},
    ]

    for el in merge_sort(elements):
        print(el)

    print()

    for el in merge_sort(elements, descending=False):
        print(el)
    
    print()

    for el in merge_sort(elements, key="name", descending=False):
        print(el)

    print()

    for el in merge_sort(elements, key="name"):
        print(el)

    # print(elements[0]['name'])

