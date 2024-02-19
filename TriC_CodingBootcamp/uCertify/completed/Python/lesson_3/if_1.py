release_year = '1991'

answer = input('When was Python first released? ')

if answer == release_year:
    print('Congratulations! That is correct.')
elif answer > release_year:
    print('No, that\'s too late')
elif answer < release_year:
    print('No, that\'s too early')

print('Bye!')

answer2 = input('True or False: Python was first released in 1991. \n')

if answer2 == True:
    print("That is correct")
elif answer2 != True or False:
    print("Please enter 'True' or 'False'")
else:
    print("That is incorrect")
