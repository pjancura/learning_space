# Set release_year to 1991. This is the correct answer to the question to be asked
# Note that this is a string as user input is automatically set to type str
release_year = '1991'
# Set the condition "correct" to False
correct = False

# While the answer provided is not correct, keep the program running
while not correct:
  # Print out the question to stdout
  # Note the use of input(). This tells the terminal to wait for user keyboard input
  answer = input('When was Python first released?')

  # Use an if statement to check that the provided answer is correct
  if answer == release_year:
    # If the answer is correct, print success message to stdout
    print('Congratulations! That is correct.')
    # After printing message, set correct to True
    # This will cause the while loop to stop executing
    correct = True
  else:
    # If the answer is incorrect, encourage user to try again
    print('No, that\'s not it. Try again\n')

# Finally, print the exit message
# Note that this is only printed just before the program exits
print('Bye!')