def set_maker():
  global the_list
  the_list = []
  the_list= [1,1,2,2,2,3,4,6,5,5]
  dict_ = dict.fromkeys(the_list)
  print('\nthis is a dictionary from the original list: \n',dict_,'\n')
  the_list = list(dict_)
  print("list from dict_: ", the_list,'\n')
  the_list= set(the_list)
  print('set from list: ',the_list,'\n')
  return the_list

set_maker()
print(the_list)