package java_17.oop_inheritance;

public class PartTwo {
    
    public static void main(String[] args) {
        Animal animal = new Animal("Animal", "small", 35);
        doAnimalStuff(animal, "crawls");
        Dog yorkie = new Dog("Yorkie", 15);
        doAnimalStuff(yorkie, "fast");
        Dog retriever = new Dog("labrador Retriever", 65, "Floppy", "Swimmer");
        doAnimalStuff(retriever, "slow");

        
    }

    public static void doAnimalStuff(Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("___________");
    }
}
