#!/usr/bin/env python3

'''
3A
'''

l_1 = [10,20,30,40]
l_2 = [5,10,15,20]

def intersection(list1, list2):
    list3 = []
    for i in range(len(list1)):
        for j in range(len(list2)):
            if list1[i] == list2[j]:
                list3.append(list2[j])
    return list3  



print('\n3A: \n',intersection(l_1, l_2))


'''
3B
'''

l_1 = [30,10,40,20]
l_2 = [5,10,15,20]
l_3 = [i for i in range(100,600,100)]

def add_lists(*a_list):           #the *    means that this function can take a variable number of like sized lists
    big_list = []
    for i in range(len(a_list[0])):
        temp_list = []
        #count = 0
        for j in range(len(a_list)):
           #print(count)
           temp_list.append(a_list[j][i])
           #print(temp_list)
           #count+=1
        big_list.append(sum(temp_list))
    return big_list


print('\n3B:\n',add_lists(l_1,l_2))


'''
3C
'''
print("\n3C: \n")
student_scores = ["Snoop",[89,78,88,70,95],
                  "Omar",[88,88,85,76,89],
                  "Stringer",[98,93,99,95,99],
                  "Marlo",[79,76,88,87,100]]

def stats_scoring(combi_list):
    for i in range(0,len(combi_list), 2):
        name = combi_list[i]
        odd_index = combi_list[i+1]
        t_score = sum(odd_index)
        avg_score = round(t_score / len(odd_index))
        print(name)
        print("Total Score: ",t_score)
        print("Average Score: ",avg_score)
        print()

stats_scoring(student_scores)


'''
3D
'''

l_split = [22,54,76,87,47,77,98,30,76,90,21,22,45,76,81]

def even_odds(a_list):
    e_list = []
    o_list = []
    for i in a_list:
        if i%2 == 0:
            e_list.append(i)
        else:
            o_list.append(i)
    e_list.sort()
    o_list.sort()
    return e_list,o_list


evens,odds = even_odds(l_split)
print("\n3D: \nEvens: ",evens,"\nOdds: ", odds,"\n")

'''
3E
'''

s_1 = "python"
s_2 = "ClevelandCodes"

def str_to_tuple(s):
    unpacked = [*s]
    tupled = tuple(unpacked)
    return tupled
print('\n3E: ')
print(str_to_tuple(s_1))
print(str_to_tuple(s_2))

'''
3F
'''
stooges = ('Larry','Curly','Moe')

def change_tuple(a_tuple):
    a_list = list(a_tuple)
    indy = a_list.index('Curly')
    a_list.remove('Curly')
    a_list.insert(indy,'Shemp')
    b_tuple = tuple(a_list)
    return b_tuple

print("\n3F: \n",stooges,"\n",change_tuple(stooges),'\n')



