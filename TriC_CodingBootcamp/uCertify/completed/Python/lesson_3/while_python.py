password = "random"
user_input = input("Please enter your password\n")
while password != user_input:
    if password != user_input:
        print("---------\nPlease enter a different password \n---------")
        user_input = input("Please enter your password\n")
else:
    print("You've entere the correct password")

