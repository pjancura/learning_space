package java_17.oop_polymorphism;

public class ExerciseForty {
    
    public static void main(String[] args) {
    }
}

class Car {
    private boolean engine = true;
    private int cylinders;
    private String name;
    private int wheels = 4;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
    }

    public Car(boolean engine, int cylinders, String name, int wheels) {
        this.engine = engine;
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = wheels;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return "A " + this.getClass().getSimpleName() + " engine is starting.";
    }

    public String accelerate() {
        return "A " + this.getClass().getSimpleName() + " is accelerating.";
    }

    public String brake() {
        return "A " + this.getClass().getSimpleName() + " is braking.";
    }
}

class Mitsubishi extends Car {
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "A " + this.getClass().getSimpleName() + " engine is starting.";
    }

    @Override
    public String accelerate() {
        return "A " + this.getClass().getSimpleName() + " is accelerating.";
    }

    @Override
    public String brake() {
        return "A " + this.getClass().getSimpleName() + " is braking.";
    }
}

class Holden extends Car {
    public Holden( int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "A " + this.getClass().getSimpleName() + " engine is starting.";
    }

    @Override
    public String accelerate() {
        return "A " + this.getClass().getSimpleName() + " is accelerating.";
    }

    @Override
    public String brake() {
        return "A " + this.getClass().getSimpleName() + " is braking.";
    }
}

class Ford extends Car {
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "A " + this.getClass().getSimpleName() + " engine is starting.";
    }

    @Override
    public String accelerate() {
        return "A " + this.getClass().getSimpleName() + " is accelerating.";
    }

    @Override
    public String brake() {
        return "A " + this.getClass().getSimpleName() + " is braking.";
    }
}
