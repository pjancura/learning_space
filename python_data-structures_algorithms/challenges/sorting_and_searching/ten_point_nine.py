# sorted matrix search:
#   given an M x N matrix write a method to find any element
#   both columns and row are sorted by ascending order

# naive approach is simply to look at each element
def find_value_in_matrix(matrix, search_value):
    is_in_matrix = False
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if search_value == matrix[i][j]:
                is_in_matrix = True
                break
    return is_in_matrix

# take advantage of sorted rows by adding binary_search() to each row
def find_value_in_matrix_2(matrix, search_value):
    is_in_matrix = False
    for arr in matrix:
        is_in_matrix = binary_search(arr, 0, len(arr) - 1, search_value)
        if is_in_matrix == True:
            break

    return is_in_matrix 

def binary_search(arr, left, right, search_value):
    if right >= left:
        mid_index = left + (right - left) // 2

        if search_value == arr[mid_index]:
            return True
        # search right side of array
        elif search_value > arr[mid_index]:
            return binary_search(arr, mid_index + 1, right, search_value)
        
        # search left side of array
        else:
            return binary_search(arr, 0, mid_index - 1, search_value)
    else:
        return False
    

#                                                                               BOOK SOLUTION 1
def find_element(matrix, elem):
    row = 0
    column = len(matrix) - 1

    while (row <= len(matrix) - 1 and column <= len(matrix[0])):
        if matrix[row][column] == elem:
            return True
        if matrix[row][column] > elem:
            column -= 1
        else:
            row += 1
    
    return False


if __name__ == "__main__":

    row_1 = [1, 3, 5, 7, 9]
    row_2 = [2, 4, 6, 8, 10]
    row_3 = [11, 13, 14, 17, 19]
    row_4 = [12, 14, 16, 18, 20]

    matrix = [row_1, row_2, row_3, row_4]

    search_values = [5, 9, -1, 25]

    for value in search_values:
        print(find_value_in_matrix(matrix, value))


    for value in search_values:
        print(find_value_in_matrix_2(matrix, value))

