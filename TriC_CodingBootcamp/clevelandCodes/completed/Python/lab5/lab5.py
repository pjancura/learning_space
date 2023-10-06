class Person:
    def __init__(self,f_name,l_name,age,gender):
        self.f_name = f_name
        self.l_name = l_name
        self.age = age
        self.gender = gender

    def __str__(self):
        if self.gender.lower() == "m":
            phrase = f"{self.f_name} {self.l_name} a {self.age} year old Male."
        else:
            phrase = f"{self.f_name} {self.l_name} a {self.age} year old Female."
        return phrase
    
    def full_name(self):
        print(f"{self.f_name} {self.l_name}")

    def title(self):
        if self.gender.lower() == "m":
            print(f"Mr. {self.f_name} {self.l_name}")
        else:
            print(f"Ms. {self.f_name} {self.l_name}")



class Doctor(Person):
    def __str__(self):
        phrase = super().__str__()
        phrase = f"{phrase} They are a doctor."
        return phrase
    
    def title(self):
        print(f"Dr. {self.f_name} {self.l_name}")

class Professor(Person):
    def __str__(self):
        phrase = super().__str__()
        phrase = f"{phrase} They are a professor."
        return phrase

    def title(self):
        print(f"Prof. {self.f_name} {self.l_name}")
    


joe = Person("Joe", "Schmoe", "39", "M")
josie = Person("Josie", "schmoe", "35","F")
john = Professor("John", "Cleaver", "33","M")
johnette = Doctor("Johnette", "Bettice", "42", "F")

print("_____________")
print(joe)

joe.full_name()

joe.title()

print()
print()

print(josie)
josie.full_name()
josie.title()

print()
print()
print(john)
print(johnette)

print()
print()
john.title()
johnette.title()

print()
print()
super(type(john), john).title()   #this calls the version of title() from the parent class Person


