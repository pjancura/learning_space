package java_17.interfaces;

//  classes can only be extended by one class, but they can implement many interfaces
public class Bird extends Animal implements  Trackable, FlightEnabled {
    
    @Override
    public void move() {
        System.out.println("flaps wings");
    }

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

    @Override
    public void track() {
        System.out.println(this.getClass().getSimpleName() + "'s coordinates recorded.");
    }


}
