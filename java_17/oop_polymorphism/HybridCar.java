package java_17.oop_polymorphism;

public class HybridCar extends Car {
    private double avgKmPerLitre = 75;
    private int batterySize = 50;
    private int cylinders = 4;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String description, double avgKmPerLitre, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine(){
        super.startEngine();
        System.out.println("The car produces a gentle hum from the engine to start!");
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("The hybrid car sounds interesting when the engine shuts off the electric motors take over");
    }
}
