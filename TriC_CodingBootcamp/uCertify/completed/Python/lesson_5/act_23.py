pets = ('cat', 'cat', 'cat', 'dog', 'horse')

c = pets.count("cat")

d = len(pets)

#if c > (d/2):
if (c/d)*100 > 50.0:
    print("too many cats")
else:
    print("everything is fine")
