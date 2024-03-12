package java_17.oop_polymorphism;

public class ElectricCar extends Car {
    private double avgKmPerCharge = 300;
    private int batterySize = 100;

    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine(){
        super.startEngine();
        System.out.println("The car makes little sounds from the electronics coming to life!");
    }

    @Override
    public void drive() {
        System.out.println("The car drives itself!");
    }
}
