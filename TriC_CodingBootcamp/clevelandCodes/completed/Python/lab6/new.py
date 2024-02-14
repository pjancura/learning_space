drink = None
food = 'Available'
def menu(x):
    if x == drink:
        print(drink)
    else:
        print(food)
menu(drink)
menu(food)

detail = { 'John': 1, 'Jack': 2, 'Jim': 3 }
for name in detail:
    print(name)

class Person:
    def __init__(self):
        print("Person is ready")
    def who(self):
        print("Person")
    def work(self):
        print("Works faster")
class Jack(Person):
    def __init__(self):
        super().__init__()
    def who(self):
        print("Jack")
    def run(self):
        print("Runs faster")
p = Jack()
p.who()
p.work()
p.run()

s = 5
a = lambda s: 1 + 2
print(a(s))


a = "Python"
def x(a,b):
    s = a[0]
    return s
print(x(a))