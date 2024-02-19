animals = ["lion","zebra","panther","antelope"]
animals.append("elephant")
print(animals)
wild = []
wild.extend(animals)
print("wild: ",wild)
animals.insert(2,"cheetah")
print(animals)
animals.pop(1)
animals.insert(1,"giraffe")
print(animals)
animals.sort()
print(animals)

