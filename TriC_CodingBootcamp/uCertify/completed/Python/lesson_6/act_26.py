

def sentence_analyzer(s_tr):
    empt_dict = {}
    white_out = s_tr.replace(" ",'')
    for i in white_out:
        num_of_occ = white_out.count(i)
        letter = i
        empt_dict.update({letter:str(num_of_occ)})
        #print(empt_dict)
    myKeys = list(empt_dict.keys())
    myKeys.sort()
    #print(myKeys)
    sort_dict = {}
    for i in myKeys:
        #print('Key: ',i)
        #print('Value: ',empt_dict[i])
        #sort_dict[i] = empt_dict[i]              #this line and the one below do the same thing
        sort_dict.update({i:empt_dict[i]})      #this line and the one above do the same thing
        #print(sort_dict)
    #sorted_dict = {i: empt_dict[i] for i in myKeys}   #this line is similar to the for loop jsut above it
    return sort_dict

s_1 = "Pythonnoonn"
s_2 = "Cleveland Codes community"
print('\nThis is the number of times a letter appears in a string:\n', sentence_analyzer(s_1))


'''
#their solution

def sentence_analyzer(sentence):
  solution = {}
  for char in sentence:
    if char != ' ':
      if char in solution:
       solution[char] += 1
      else:
       solution[char] = 1
      
  return solution
'''