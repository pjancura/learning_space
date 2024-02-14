#this func asks for a string and something to look for in that string

def find_count():
    s = input("Type a string:\n").lower()
    query = input("Type something to look for in your string:\n").lower()
    return s.count(query)

print(find_count())


#this function checks for a palindrome
def palindrome_check():
    pal = input("Type a string: \n (not case-sensitive)\n")
    rev_pal = pal[::-1]
    for i in range(len(pal)-1,-1,-1):
        print(pal[i])
    if pal.lower() == rev_pal.lower():
        print("Found a palindrome!")
    else:
        print("That's not a palindrom")

palindrome_check()
