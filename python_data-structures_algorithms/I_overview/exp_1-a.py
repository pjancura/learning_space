# use list compreshension to return all non-white space characters individually 

list_comprehension = [c for c in "4 and 20 blackbirds.\n" if c != ' ']

print(list_comprehension)