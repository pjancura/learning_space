package java_17.oop_composition;

// composition is more flexible
//      you can add parts or remove them, and this way it has there are less downstream effects
// composition provides functional reuse outside of the class hierarchy
//      classes can share attributes & behavior, by having similar components, instead of inheriting functionality from a parent or base class
// Java's inheritance breaks encapsulation
//      b/c subclasses may need direct access to a parent's state or behavior

public class PartOne {

    public static void main(String[] args) {
        ComputerCase theCase = new ComputerCase("2208", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540 x 1440");
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PersonalComputer thePC = new PersonalComputer("2208", "Dell", theCase, theMotherboard, theMonitor);

        // thePC.getMonitor().drawPixelAt(10, 10, "red");   
        // thePC.getComputerCase().pressPowerButton();
        // thePC.getMotherboard().loadProgram("Windows OS");

        thePC.powerUp();
    }
}
