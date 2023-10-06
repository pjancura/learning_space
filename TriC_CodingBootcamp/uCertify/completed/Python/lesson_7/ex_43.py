class Cat:
    def __init__(self, mass, lifespan, speed):
        self.mass_in_kg = mass
        self.lifespan_in_years = lifespan
        self.speed_in_kph = speed

    def vocalize(self):
        print("Chuff")

    def __str__(self):
        facts = (f"The {type(self).__name__.lower()} "\
                    f"weighs {self.mass_in_kg}kg,"\
                    f" has a lifespan of {self.lifespan_in_years} years and "\
                    f"can run at a maximum speed of {self.speed_in_kph}kph.")
        return facts
        

cat = Cat(4, 18, 48)
print("___________________")
cat.vocalize()
print(cat)

#below are 3 subclasses of Cat....they will inherit all of the properties of Cat as well

class Cheetah(Cat):
    def __init__(self, mass, lifespan, speed):
        super().__init__(mass, lifespan, speed)
        self.spotted_coat = True

    def vocalize(self):
        print("Chirrup")

        

class Lion(Cat):
    def vocalize(self):
        print("ROAR")

class Leopard(Cat):
    def vocalize(self):
        print("Rawr,rawr")

class Tiger(Cat):
    def __init__(self,mass,lifespan,speed):
        super().__init__(mass, lifespan, speed)
        self.coat_pattern = "striped"

    def vocalize(self):
        print("RAWR")
        
    def __str__(self):
        facts = super().__str__()
        facts = f"{facts} It also has a {self.coat_pattern} coat."
        return facts




cheetah = Cheetah(72, 12, 120)
lion = Lion(190, 14, 80)
leopard = Leopard(90, 17, 58)
tiger = Tiger(90, 17, 58)
#print(cheetah)

print()
print()
print(tiger)
print()

