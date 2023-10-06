def print_arguments(*args):
    for item in args:
        if type(item) == int:
            continue
        else:
            print(item)

print_arguments(2, 3.4,"args",4.13, 5, 10, "nope")
