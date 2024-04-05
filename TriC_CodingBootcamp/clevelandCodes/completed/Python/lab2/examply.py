# def add_nums(a, b):
#     return a + b


# num_1 = 90
# num_2 = 90

# print(add_nums(b = num_1,a = num_2))

str_1 = input("Enter a string: ")

for i in str_1:
    print(i)

for j in range(len(str_1)):
    print(j)

for i in range(len(str_1)-1,-1,-1):
    print(str_1[i])

x = str_1.count("E")
print(x)