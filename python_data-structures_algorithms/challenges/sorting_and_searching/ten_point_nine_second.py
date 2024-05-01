class Coordinate:
    def __init__(self, row, column) -> None:
        self.row: int = row
        self.column: int = column

    def inbounds(self, matrix) -> bool:
        return self.row >= 0 and self.column >= 0 and self.row < len(matrix) and self.column < len(matrix[0])
    
    def is_before(self, point) -> bool:
        return self.row <= point.row and self.column <= point.column
    
    def clone(self) -> object:
        return Coordinate(self.row, self.column)

    def set_to_average(self, minimum: object, maximum: object) -> None:
        self.row: int = (minimum.row + maximum.row) // 2
        self.column: int = (minimum.column + maximum.column) // 2
    
    def values(self):
        return [self.row, self.column]


def find_element(matrix: list[list[int]],value: int, origin: Coordinate = Coordinate(0, 0), dest: Coordinate = Coordinate(0, 0)) -> Coordinate:
    if dest.values() == [0, 0] and origin.values() == [0, 0]:
        dest: Coordinate = Coordinate(len(matrix) - 1, len(matrix[0]) - 1)
    if not origin.inbounds(matrix) or not dest.inbounds(matrix):
        return None
    if matrix[origin.row][origin.column] == value:
        return origin
    elif not origin.is_before(dest):
        return None
    
    #  set start to start of diagonal and end to the end of the diagonal.
    #  since the grid may not be square, the end of the diagonal may not equal dest
    start: Coordinate = origin.clone()
    diag_dist: int = min(dest.row - origin.row, dest.column - origin.column)
    end: Coordinate = Coordinate((start.row) + diag_dist, (start.column) + diag_dist)
    point: Coordinate = Coordinate(0, 0)

    # do binary search on the diagonal, looking for the first element > value
    while start.is_before(end):
        point.set_to_average(start, end)
        if value > matrix[point.row][point.column]:
            start.row = point.row + 1
            start.column = point.column + 1
        else:
            end.row = point.row - 1
            end.column = point.column - 1
    
    #  split the grid into quadrants. search the bottom left and the top right
    return partition_and_search(matrix, origin, dest, start, value)

def partition_and_search(matrix: list[list[int]], origin: Coordinate, dest: Coordinate, pivot: Coordinate, value: int) -> Coordinate:
    lower_left_origin: Coordinate = Coordinate(pivot.row, origin.column)
    lower_left_dest: Coordinate = Coordinate(dest.row, pivot.column - 1)
    upper_right_origin: Coordinate = Coordinate(origin.row, pivot.column)
    upper_right_dest: Coordinate = Coordinate(pivot.row - 1, dest.column)

    lower_left: Coordinate = find_element(matrix, value, lower_left_origin, lower_left_dest)
    if lower_left == None:
        return find_element(matrix, value, upper_right_origin, upper_right_dest)
    return lower_left

    




if __name__ == "__main__":

    row_1 = [1, 3, 5, 7, 9]
    row_2 = [2, 4, 6, 8, 10]
    row_3 = [11, 13, 14, 17, 19]
    row_4 = [12, 14, 16, 18, 20]

    matrix = [row_1, row_2, row_3, row_4]

    search_values = [5, 16, -1, 25]

    for value in search_values:
        coord: Coordinate = find_element(matrix, value)
        if coord != None:
            print(f'Row: {coord.row}, Column: {coord.column}')
        else:
            print("None")