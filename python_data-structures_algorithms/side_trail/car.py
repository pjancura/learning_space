class Car:
    def __init__(self, make, model, color, doors):
        self.make = make
        self.model = model
        self.color = color
        self.doors = doors

    def honk_the_horn(self):
        print("Beep Beep")