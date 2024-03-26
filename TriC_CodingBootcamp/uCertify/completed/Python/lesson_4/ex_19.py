# Initialise global variable "number" to 5
number = 5

"""
Define function "summation" that takes two parameters
Note that the function accesses the global variable "number"
"""
def summation(first, second):
  # Add the parameters and global number together
  total = first + second + number
  # Return result
  return total
  
# Call the "summation" function with two parameters as expected
outer_total = summation(10, 20)

# Print out the initial value of "number"
print("The first number we initialised was " + str(number))

# Try to access the local variable "total"
print("The total after summation is " + str(outer_total))