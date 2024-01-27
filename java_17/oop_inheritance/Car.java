// a class is said to be a top-level class, if it is defined in the source code file, 
// and not enclosed in the code block of another class, type, or method.

// public -> any other class in any package can access this class.
//      if public is omitted then the class is only accessible to 
//      classes in the same package

// access modifiers
//      at the member level, allows granular control over class members
//      public -> described above
//      protected -> allows classes in the same package, and any 
//          subclasses in other packages, to have access to the member.
//      "   " -> described above
//      private -> no other class can access this member

// fields should be private ths is called encapsulation
//    encapsulation-> bundling of behacior and attributes on a single object
//          OR practice of hiding fields, and some methods, from public access

package java_17.oop_inheritance;

public class Car {

    private String make = "Tesla";
    private String model = "Model X";
    private String color = "Gray";
    private int doors = 2;
    private boolean convertible = false;

    // the next 5 methods are the getter methods for a Car
    // they will return the different fields of a Car
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public int getDoors() {
        return doors;
    }
    public boolean isConvertible() {
        return convertible;
    }

    // the next 5 methods are setter methods for a Car
    // this is special keyword in Java
    //      this refers to the instance that was created when the object was instantiated
    //      this is a special reference name for the object or instance,
    //          which it can use to describe itself
    //      this allows you to access fields on the class
    public void setMake(String make) {
        if (make == null) make = "Unknown";
        String lowercaseMake = make.toLowerCase();
        switch(lowercaseMake) {
            case "subaru", "porsche", "tesla" -> this.make = make;
            default -> {
                this.make = "Unsupported";
            } 
        };
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setDoors(int doors) {
        this.doors = doors;
    }
    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    
    public void describeCar() {
        System.out.println(doors + "-Door " +
                color + " " +
                make + " " +
                model + " " +
                (convertible ? "Convertible" : ""));
    }

}