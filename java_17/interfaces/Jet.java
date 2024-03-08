package java_17.interfaces;

public class Jet implements FlightEnabled, Trackable {
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

    @Override
    public FlightStages transition(FlightStages stage) {
        System.out.println(this.getClass().getSimpleName() + " transisitioning");
        return FlightEnabled.super.transition(stage);
    }
    
}
