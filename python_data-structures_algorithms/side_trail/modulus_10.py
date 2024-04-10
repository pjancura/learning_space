import math

arr = []
arr_2 = []
input_num = 23621512732

while input_num > 9:
    arr_2.append(int(input_num % 10))
    arr.append(int(input_num))
    input_num /= 10

arr_2.append(int((input_num % 10)))
arr.append(int(input_num))

print(arr)
print(arr_2)

num = 12345
num_str = str(num)
rev_str = num_str[::-1]
rev_num = int(rev_str)
print(rev_num, type(rev_num))