package java_17.oop_polymorphism;

public class GasPoweredCar extends Car {
    private double avgKmPerLitre = 50;
    private int cylinders = 4;

    public GasPoweredCar(String description) {
        super(description);
    }
    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine(){
        super.startEngine();
        System.out.println("The car roars to life with the power of gasoline!");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("You feel the gasoline being consumed and turned into horsepower through the steerign wheel");
    }
}
