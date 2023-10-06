esdic = {}                              #creates an empty dictionary
l=0                                        #counts lines in the txt file
with open("eng-span.txt") as file:          #opens the .txt file
    for line in file:                       #looks at each line of the file
        parts = line.split()                #a split operation that splits on the white space
        esdic[parts[0]] = parts[-2]         #this pulls the english and then spanish equivalent  for key:value pair
        l+=1                                #increases the counter
        #print(parts)
esdic["is"]="es"                            #adds is to the esdic
esdic["the"]="el"                           #adds the to the esdic
print(f"{l} lines read into dictionary")    #prints the total number of lines read
#print(esdic)

#the does the conversion of english to spanish
def get_spanish(e_str, punct):
    e_list = e_str.split()
    #print(e_list)
    s_list = []
    for i in e_list:
        lowered = i.lower()
        #print(lowered)
        if i in esdic:
            s_list.append(esdic[i])
        elif lowered in esdic:
            s_list.append(esdic[lowered])
        else:
            s_list.append(lowered)
    #print(s_list)
    conc_str = ""
    for i in s_list:
        #print(i)
        #print(s_list.index(i))
        conc_str += f"{i} "
    if punct == ".":
        conc_str += f"\b{punct}"
    if punct == "?":
        conc_str = f"¿{conc_str}\b?"
    if punct == "!":
        conc_str = f"¡{conc_str}\b!"
    return conc_str 







# print("_______________")
# in_str = input("Enter a sentence without the puncuation mark: \n")
# punctuation = input("Enter the appropriate puncuation for the end of the sentence: \n")
# print("_______________")                
# print(f"\nHere is your sentence in Spanish:\n{get_spanish(in_str, punctuation)}")
# print("_______________")                

def fibonacci(num_digits):
    sequence = []
    sequence.append(0)
    sequence.append(1)
    for num in range(2,num_digits):
        sequence.append((sequence[num-2]+sequence[num-1]))
    return sequence

new_num = int(input("\nNumber of digits you want returned from the sequence: \n"))
print(f"Fib Seq: {fibonacci(new_num)}")





# def get_spanish(e_str, punct):
#     e_list = e_str.split()
#     s_list = []
#     for i in e_list:
#         lowered = i.lower()
#         if lowered in esdic:
#             s_list.append(esdic[lowered])
#         else:
#             s_list.append(lowered)
#     conc_str = ""
#     for i in s_list:
#         conc_str += f"{i} "
#     if punct == ".":
#         conc_str += f"\b{punct}"
#     if punct == "?":
#         conc_str = f"¿{conc_str}?"
#     if punct == "!":
#         conc_str = f"¡{conc_str}!"
#     return conc_str 