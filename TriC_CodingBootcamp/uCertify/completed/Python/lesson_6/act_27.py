def dictionary_masher(*d_dict):
    new_dict = {}
    #print(len(d_dict))
    for i in range(len(d_dict)):
        #print(i)
        for key,value in d_dict[i].items():
            #print(j)       #j was used when   ".items()" was not being used    
            #new_dict[j] = d_dict[i][j]
            #print(key)
            #print(value)
            new_dict[key] = value
            #print(new_dict)
            #popped = d_dict[i].popitem()
            #popped = d_dict[i].pop(j)
            #print(popped)
            #new_dict[popped[0]] = popped[1]
    #pop1 = dict1.popitem()
    #pop2 = dict2.popitem()
    #new_dict[pop1[0]] = pop1[1]
    #new_dict[pop2[0]] = pop2[1]
    return new_dict

d_1 = {"name":"Bob"}
d_2 = {"role":"plumber"}
d_3 = {"years": '4'}

print()
print(dictionary_masher(d_1,d_2,d_3))
print()


'''
#their answer

def dictionary_masher(dict_a, dict_b):
  for key, value in dict_b.items():
    if key not in dict_a:
      dict_a[key] = value
  return dict_a
'''