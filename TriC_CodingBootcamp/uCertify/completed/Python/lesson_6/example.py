#dictionary = {}

contacts = {"Jason": "740-634-8888", "Carl":"555-666-7777"}

#print(dir(contacts))

print(isinstance(contacts, dict))   #checks if object is a dict (aka: dictionary)



print("\nJason phone num: ",contacts["Jason"],"\n")

contacts["Tony"] = "777-666-5555"     #adds Tony to contacts

print(contacts,"\n")

del contacts["Jason"]  #deletes Jason from contacts

print(contacts,'\n')

# n = input()

# #lis = list(n)  this didn't help achieve my goal

# #num = int(lis)  can't do this to a list

# print(n.isnumeric())

# print(isinstance(n, int))

# print(isinstance(n, str))

