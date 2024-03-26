# inheritance creates subclasses based on super classes
#       is_a relationship

class Animal:
    def eat(self):
        print(str(type(self)).split(".")[1][:-2] + " Ate")


class Dog(Animal):
    def bark(self):
        print("Woof")



class Cat(Animal):
    def meow(self):
        print("Meow")


class Robot():
    def move(self):
        print("Ahh...mobility")

class CookRobot(Robot):
    def cook(self):
        print("I cook the pasta")

class CleanRobot(Robot):
    def clean(self):
        print("I am cleaning")

# composition - make each method into a class and compose a new
#   class by including objects from other classes
#    has_a relationship
#   methods in a composite class call the method from the base (origin) class
#       but still need to be defined in the new composite class
# composition allows you to pick and choose what to take from another class
        
class SuperBot():
    def __init__(self):
        '''this class contains 3 objects
        they come from other classes already defined'''
        self.o1 = Dog()
        self.o2 = Robot()
        self.o3 = CleanRobot()

    def play_game(self):
        print('chess is best')

    def move(self):
        return self.o2.move()
    
    def bark(self):
        return self.o1.bark()
    
    def clean(self):
        return self.o3.clean()


if __name__ == "__main__":

    # inheritance exmaples
    snoopy = Dog()
    garfield = Cat()
    snoopy.bark()
    snoopy.eat()
    garfield.meow()
    garfield.eat()

    cleaner = CleanRobot()
    chef = CookRobot()

    cleaner.clean()
    chef.cook()
    cleaner.move()

    # composite examples

    henry = SuperBot()
    henry.move()
    henry.play_game()

