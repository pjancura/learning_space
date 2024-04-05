package java_17.interfaces;

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage() {
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1 ) % allStages.length];
    }
}

interface OrbitEarth extends FlightEnabled {
    void achieveOrbit();

    private static void log(String description) {
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning Transition to " + nextStage);
        return nextStage;
    }
}

interface FlightEnabled {

    public static final double MILES_TO_KM = 1.60934;   // this line is equivalent to the next line of code
    double KM_TO_MILES = 0.621371;

    //  public and abstract are redundant
    public abstract void takeOff();

    // abstract is redundant here
    abstract void land();
    
    void fly();

    // "default" allows you update an interface without having to update every single 
    //      class that implements this interface
    //      you do you need to add some "default" behavior for the function however
    default FlightStages transition(FlightStages stage) {
        // System.out.println("Transition not implemented on " + this.getClass().getName());
        // return null;

        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    };

}

interface Trackable {
    void track();
}

public abstract class Animal {
    
    public abstract void move();
}
