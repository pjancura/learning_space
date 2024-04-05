from car import Car

    
class ClownCar(Car):   
    def __init__(self, make, model, color, doors, occupancy = "Too Many Clowns"):
        super().__init__(make, model, color, doors)
        self.occupancy = occupancy

    @classmethod
    def get_simple_clown_car(self):
        return ClownCar(make = "Subaru", 
                    model = "Outback", 
                    color = "Polka_dot", 
                    doors = 1, 
                    occupancy = "5 too many clowns more than seats")

    def honk_the_horn(self):
        print("Awwhoooogaaaa")
        Car.honk_the_horn(self)

    def __str__(self):
        return f"This is a {self.color} {self.make} {self.model} with {self.doors}. \n It has an occupancy of {self.occupancy}"
    

if __name__ == "__main__":
    cc = ClownCar("Ford", "Ranger", "Polka-Dot", 4)
    cc.honk_the_horn()
    chevy = Car("Chevy", "Cavalier", "Blue", 5)
    chevy.honk_the_horn()
    print(getattr(cc, "occupancy"))
    print(cc.occupancy)
    setattr(cc, "doors", 2)
    print(getattr(cc, "doors"))
    print(cc.__str__())
    cc_2 = ClownCar.get_simple_clown_car()
    print(cc_2.__str__())
    

    new_dict = {"1": 1, "2": 2, "3": 3}
    print(new_dict["1"])

    # print("1" + 2)

