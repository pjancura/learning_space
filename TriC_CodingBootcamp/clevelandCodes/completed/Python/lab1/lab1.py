#import Math Library
import math

i = 0                        #this is the total number of inputs the user did            
max_num = 0                #this is the highest value the user entered
min_num = 0                 #this is the lowest value the user entered
quit_var =  "Q"

user_input = input("Enter a number between 1 and 100 ")                #allows the user to exit the loop

while quit_var.lower() != user_input.lower():    
    if user_input == "" or not (user_input.isdigit()):                      #tests for NaN
        user_input = input("Guess a real integer from 1 - 100: ")
        continue
    user_num = int(user_input)
    i = i + 1                  #converts user_input to an integer            
    if user_num >= 101 or user_num <= 0:        #checks if the input is in range
        print("Not in Range")
    elif user_num <= 100 and user_num >= 1:         #if the input is in range
        if min_num == 0:
            min_num = user_num
            max_num = user_num
        elif user_num >= max_num:                   #new max
            max_num = user_num
        elif user_num <= min_num:                   #new min
            min_num = user_num
        else:                                       #just another input
            continue     
    else:
        print("Something went wrong")
        break
    user_input = input("Guess again: ")

# End of loop statements
print(f"You entered {i} numbers.")
print(f"The highest value was: {max_num}")
print(f"The lowest value was: {min_num}")