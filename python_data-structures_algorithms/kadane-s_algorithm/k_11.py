#!/usr/bin/env python3.13

from typing import Optional, Union, Tuple, List, Never

# remember that if the arrays were to be particularly large using mod 10^9 + 7 is a good way to keep answers under that integer limit and still with good distribution
#  largest integer that can be stored is .... 2,147,483,647   .... granted this is for 32-bit systems  

def kadanes_product(arr) -> Tuple[List[int], Optional[int]]:
    if len(arr) == 0:
        return [], None
    elif len(arr) == 1:
        return arr, arr[0]
    
    curr_max = arr[0]
    curr_min = arr[0]
    maximum = arr[0]

    start = 0
    end = start + 1
    temp_start = 0
    neg_count = 0 if arr[0] >= 0 else 1          # keeps track of negative numbers in the subarray

    while arr[temp_start] == 0:
        temp_start += 1
    
    for i in range(1, len(arr)):
        print(i, neg_count)
        # if arr[i] < 0:
        #     neg_count += 1

        temp = max(arr[i], curr_max * arr[i], curr_min * arr[i])
        curr_min = min(arr[i], curr_max * arr[i], curr_min * arr[i])
        curr_max = temp

        if maximum <= curr_max:
            maximum = curr_max
            start = temp_start
            end = i + 1

        # print("curr_max: ", curr_max)
        if arr[i] == 0:
            temp_start = i + 1
            print("changes temp_start")
            neg_count = 0
            curr_max = 1
            curr_min = 1
        
        if arr[i] < 0:
            if i < end and i > start:
                neg_count += 1

        # print(maximum)
    # print(neg_count)
    # print(start, neg_count)
    if start < end and neg_count % 2 != 0:
        start += 1

    return arr[start: end], maximum

if __name__ == "__main__":
    arr = [
        # [1, 2, 3, 4],                   # [1, 2, 3, 4], 24
        # [-1, -2, -3, -4],               # [-1, -2, -3, -4], 24
        # [5],                            # [5], 5
        # [-5],                           # [-5], -5
        # [1, 0, 3, -2, 4],               # [4], 4
        # [2, 3, -2, 4],                  # [2, 3], 6
        # [-2, 3, 4],                     # [3, 4], 12
        # [-2, -3, -7, -1],               # [-2, -3, -7, -1], 42
        # [0, 0, 0],                      # [0], 0       
        # [1, -2, -3, 4, -5],             # [-3, 4, -1, 5], 60
        # [-1, 2, -3, 4, -1, 5],          # [2, -3, 4, -1, 5], 120
        # [1],                            # [1], 1
        # [],                              # [], None
        [0, -1, 2, -3, 4, 0],           # [-1, 2, -3, 4], 24
        [-2, 3, 4, -2, -1, -1, -1],     # [-2, 3, 4, -2, -1, -1], 48
    ]

    for a in arr:
        print(kadanes_product(a))