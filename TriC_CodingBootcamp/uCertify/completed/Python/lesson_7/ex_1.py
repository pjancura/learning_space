class Person_1:
    pass

# print(type(Person))

# jack = Person()

# print(type(jack))
# jill = Person()

# print(type(jill))

# print(jack is jill)

# jack2 = jack
# print(jack2 is jack)

person1 = Person_1()

person1.name = "Roger D Bigg"
person1.name = "Gol D. Roger"
person1.age = 53
person1.height_in_cm = 180
print(person1.__dict__)
print(person1.name, person1.age, person1.height_in_cm)

    # below is the PYthon constructor method for an object
    #now we must pass a name whenever we instantiate a Person
class Person_2:
    def __init__(self, name):
       self.name = name

person_1 = Person_2("Gregor")

print(person_1.name)

class Person_3:
    def __init__(self,name,age,height_in_cm):
        self.name = name
        self.age = age
        self.height_in_cm = height_in_cm
    
    def speak(self):
        print(f"Hello! My name is {self.name}. I am {self.age} years old.")
    
    def greet(self, person_3):
        print(f"Hi {person_3.name}")

person_2 = Person_3("Mel",90,200)

print(person_2.name,person_2.age,person_2.height_in_cm)
print(person_2.greet(person_2))


import math

class Circle:
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return math.pi * self.radius ** 2

    def circumference(self):
        return 2 * math.pi * self.radius

    def change_radius(self, new_radius):
        self.radius = new_radius

circle = Circle(7)

while True:
    radius = float(input("Circle radius: "))
    circle.change_radius(radius)
    print("Area:", circle.area())
    print("Circumference:", circle.circumference())


