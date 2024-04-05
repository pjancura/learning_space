package java_17.oop_polymorphism;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void describeCar() {
        String objectType = this.getClass().getSimpleName();
        System.out.println(this.description + " is a " + objectType + " type of vehicle");
    }

    public static Car getCar( String type, String description) {
        return switch(type.toUpperCase().charAt(0)) {
            case 'G' -> new GasPoweredCar(description);
            case 'H' -> new HybridCar(description);
            case 'E' -> new ElectricCar(description);
            default -> new Car(description);
        };
    }

    public void startEngine() {
        System.out.println("You push the button to start the car");
    }
    
    public void drive() {
        System.out.println("Steerin!");
    }

    protected void runEngine() {
        System.out.println("protected runEngine()");
    }

    public static void main(String[] args) {
        Car car = new Car("blue chevy");
        car.describeCar();
        ElectricCar eCar = new ElectricCar("White Tesla");
        eCar.describeCar();



        Object gasCar = Car.getCar("G", "red honda");
        ((Car) gasCar).describeCar();
        GasPoweredCar gasPoweredCar = (GasPoweredCar) gasCar;
        gasPoweredCar.startEngine();
    }
}
