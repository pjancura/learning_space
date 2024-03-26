package java_17.interfaces;

public record DragonFly(String name, String type) implements FlightEnabled {
    @Override
    public void takeOff() {
        System.out.println(this.getClass().getSimpleName() + " is taking off.");
    }

    @Override
    public void land() {
        System.out.println(this.getClass().getSimpleName() + " is landing.");
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + " is flying.");
    }
    
}
