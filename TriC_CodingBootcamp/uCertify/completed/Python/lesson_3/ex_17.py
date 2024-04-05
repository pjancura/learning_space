# Create a list with numbers 1 through 10
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Loop through the list of numbers
for num in numbers:
  # Calculate the square of the number
  square = num * num
  # Print out a string showing the number and its calculated square
  print(num ,' squared is ', square)
else:
  print('The last number was ', num)

numList = [10,5,7,4,8,9,1,2,6,5]
wordList = ["pomegranate", "apple", "grape", "banana"]
numList.sort()
wordList.sort()
print(numList)
print(wordList)

wordListSorted = sorted(wordList)
print(wordListSorted)
len_word_list = sorted(wordList, key=len)
print(len_word_list)
