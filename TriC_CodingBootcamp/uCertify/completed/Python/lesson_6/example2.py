a = {}
print(a)
a.update({"name": "Dan Brown"})
print(a)
a.update({"name": "Dan Brown Xavier"})
print(a)
a["name"] = "Dan Brown Xavier"
print('\nThis after trying to add in a similar key:value into the end of the dictionary: ',a)
a.clear()
print(a)


b = {"name": "Skandar Keynes", "age": "24"}
print('\nB: ')
del b["name"]
print(b)
b.update({"name": "Skandar Keynes"})
c = b.pop("name")
print(b)
print('\n What got popped: ',c)

#below demonstrates shallow copies, but updated y does not update z
z = {"name": "Skandar Keynes", "age": "24"}
y = z.copy()
print('\nshallow copy of z: ',y)

z["name"] = "Janet Jackson"
print('\nThis is z: ',z)
print('\nThis is y: ',y)

#be demonstrates a deepcopy changes in one will reflect in the other
x = z
print('\nthis is x and z deepcopy: ', x)
z['name'] = 'Paula Abdul'
print('\nupdated z and reflects in x')
print('this is x: ', x)
print('this is z: ', z)

#you can popitems by the key
z.popitem()
print('\npopped item in z from the end: ',z)



def dictionary_masher(dict_a, dict_b):
  for key, value in dict_b.items():
    print(key)
    print(value)
    if key not in dict_a:
      dict_a[key] = value
  return dict_a

d_1 = {"name":"Bob"}
d_2 = {"role":"plumber"}
d_3 = {"years": '4'}

print()
print(dictionary_masher(d_1,d_2))
print()