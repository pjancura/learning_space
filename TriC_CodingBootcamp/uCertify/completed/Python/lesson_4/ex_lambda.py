answer = lambda first, second : first + second
print(answer(6, 9))

#this demonstrates a map() utilizing a lambda function
#the list() is needed to turn the map() into an output of type list/array
numbers = [2, 4, 6, 8, 10]
squared = list(map(lambda num: num ** 2, numbers))

print(squared)

