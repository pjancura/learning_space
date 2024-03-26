// generalization is the process of identifying which features your objects have in common
//      by doing this you can create a more succinct hierarchy 
//      the base class will be the most basic building block that everything has in common


//  abstraction -> think of creating an umbrella to capture more specific objects
//      ex: animal -> very abstract, many things fall into this category
//          penguin -> more specific type of animal
//          emperor pengin -> even more specific penguin

// an abstract method has a method signature, and a return type, but doesn't have a method body
//      we say an abstract mehtod is "unimplemented"
//      it's purpose is to describe behavior, which any object of that type will always have

// Move and eat could be abstract methods for an animal since all animals would have that in common
//      an abstract method is like a contract
//          it promises that all subtypes will provide the promised functionality, with the agreed upon name and arguments

// concrete method -> has a method body, usually with at least one statement
//      this means it has operational code, that gets executed, under the right conditions
//      It is said to "implement" an abstract method, if it overrides one
//      abstract classes and interfaces, can have a mix of abstract and concrete methods

//     

package java_17.abstraction;

import java.util.ArrayList;

public class PartOne {
   
    public static void main(String[] args) {
        // Animal animal = new Animal("animal", "big", 100);        // this line doesn't compile because it an abstract class and can't be instantiated
        Dog dog = new Dog("Wolf", "big", 100);
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 15));
        animals.add(new Horse("Clydesdale", "Extra Large", 1500));

        System.out.println(animals);

        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal) {
                currentMammal.shedHair();
            }
        }
    }

    private static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
        animal.move("slow");
    }    

}

abstract class Mammal extends Animal {
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.print(this.getExplicitType() + " ");
        System.out.println( speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}


abstract class Animal{ // this is how you declare an abstract class
                            // you can't create an instance of an abstract class
                            // it can still have a constructor, which will be called by its subclasses, during their construction
    protected String type;
    private String size;
    private double weight;
    
    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);

    public abstract void makeNoise();

    // final keeps you from using @Override on the method in a subclass
    public final String getExplicitType() {
        return this.getClass().getSimpleName() + " (" + this.type + ")";
    }
}

// a subclass must provide a concrete method for any abstract method declared on its parent
class Dog extends Mammal {

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        // System.out.println("The dog runs at " + speed + "mph!");
        if (speed == "slow") {
            System.out.println("The " + this.getExplicitType() + " is walking.");
        } else {
            System.out.println("The " + this.getExplicitType() + " is moving fast!");
        }
    }

    @Override
    public void makeNoise() {
        if (this.type == "Wolf") {
            System.out.println("Howling!");
        } else {
            System.out.println("Bow wow!");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(this.getExplicitType() + " shed hair all of the time!");
    }
}

class Fish extends Animal {

    public Fish(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        // System.out.println("The dog runs at " + speed + "mph!");
        if (speed == "slow") {
            System.out.println("The " + this.getExplicitType() + " is lazily.");
        } else {
            System.out.println("The " + this.getExplicitType() + " is darting!");
        }
    }

    @Override
    public void makeNoise() {
        if (this.type == "Goldfish") {
            System.out.println("Blub!");
        } else {
            System.out.println("Splash!");
        }
    }
}

class Horse extends Mammal {
    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void makeNoise() {
        System.out.println(this.getExplicitType() + " whinnies!");
    }

    @Override
    public void shedHair() {
        System.out.println(this.getExplicitType() + " sheds in the spring.");
    }


}