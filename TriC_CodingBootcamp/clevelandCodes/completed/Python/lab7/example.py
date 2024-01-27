new_list = (item for item in range(0,101,5))


print("______________")

for item in new_list:
    print(item)
# print(new_list)

(print(i, end=' ') for i in new_list)
[print(i) for i in new_list]
print("--------------")