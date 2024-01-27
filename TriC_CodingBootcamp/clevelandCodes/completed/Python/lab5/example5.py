class Car:
    def __init__(self, make,model,color):
        self.make = make
        self.model = model
        self.color = color

    def honk_horn(self):
        if self.make.lower() == "ford":
            print("Beep! Beep!")
        elif self.make.lower() == "jeep":
            print("Beep, Beep, I'm a jeep!!")
        else:
            print("BEEEEEEEP!")
    
    def __str__(self):
        return f"This is a {self.make} {self.model} that is {self.color}."
    

class ClownCar(Car):
    def honk_horn(self, n):
            print("AWHHOOOOOOGGAH!!!!!!" * n)
    
    def __str__(self):
        phrase = super().__str__()
        phrase = f"{phrase} It is also a Clown Car."
        return phrase
    
    


car1 = Car("Chevy","Avalanche","Black")
car2 = Car("Ford","Pinto","Blue")
car3 = Car("Jeep","Wrangler","Red")
c_car1 = ClownCar("Mini","Cooper","polka-dot")
c_car2 = ClownCar("VW","Bug","Striped")



print("_________________")
print(car1)
car1.honk_horn()
print()
print(car2)
car2.honk_horn()
print()
print(car3)
car3.honk_horn()
print()
print(c_car1)
c_car1.honk_horn(3)
print(c_car2)
c_car2.honk_horn(1)

print()
print()
print(c_car1.__dict__)
print()
car1.color = "Pink"
print(car1)


print("________________")

