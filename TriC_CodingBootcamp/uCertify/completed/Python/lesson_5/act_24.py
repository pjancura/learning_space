words = ("one","two","three","four","five")
nums = tuple([i for i in range(1,6)])    #this is an example of tuple generation through list comprehension

def list_match(list1, list2):
    if len(list1) == len(list2):
        new_tup = tuple([(list1[i],list2[i]) for i in range(len(list1)-1)])    
        print(new_tup)
    else:
        print("lists need to be the same length")

list_match(words,nums)

'''
below is the books example for the matching of items in 2 tuples
'''
wordList = ["two", "four", "six", "eight", "ten", "twelve", "fourteen", "sixteen", "eighteen", "twenty"]
numList = list(range(2,22,2))
def listMatch(listOne, listTwo):
    tempList = []
    for i in range(len(listOne)):
       tempTuple = (listOne[i],listTwo[i])
       tempList.append(tempTuple)
    return tempList
finalList = listMatch(numList, wordList)
print(finalList)
