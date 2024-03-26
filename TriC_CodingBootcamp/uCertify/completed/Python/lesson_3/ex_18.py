# Create a list with three groups of numbers 1 through 9
groups = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

# Loop through the list of number groups
for group in groups:
  # Loop through numbers in group
  for num in group:
    # Calculate the square of the number
    square = num * num
    # Print out a string showing the number and its calculated square
    print(num ,' squared is ', square)