d = dict(
    state="NY",
    city="New York"
  )

print(type(d))

print(d)

dictionary2 = {
  "state": "Maryland",
  "city": "Baltimore"
}

print(dictionary2)

dictionary2['bird'] = 'Baltimore oriole'

print(dictionary2)

d['state'] = 'New York'
print(d)

print(d['state'])

print(d.get('state'))
print(d.get('age'))
print(d.get('age', 'Key age is not defined'))   #the 2nd arg defines the error to print ....i think

for item in d:
  print(item)

dictionary1 = dict(
    state="NY",
    city="New York"
  )

#the below 2 for loops do the same thing
for item in dictionary1.keys():
  print(item,': ',dictionary1[item])

for key, value in dictionary1.items():
  print(key,':', value)


print("\nchecks if the key exists in the dictionary")

a = {
  "size": "10 feet",
  "weight": "16 pounds"
}

print("size" in a)
print("length" in a)

