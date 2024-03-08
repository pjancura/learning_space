//  interface is similar to an abstract class, although it isn't a class at all
//  it's a special type, that's more like a contract between the class and client code, taht the compiler enforces
//  by declaring it's using an interface, your class must implement all the abstract methods, on the interface
//  a class agress to this, because it wants to be known by that type, by the outside world, or the client code
//  an interface lets classes taht might have little else in common, be recognized as a special reference type

// an interface is usually named, according to the set of behaviors it describes
//  many interfaces will end in 'able', like Comparable, and Iterable, again meaning something is capable, or can do, a given set of behaviors

//  a class is associated to an interface, by using the implements clause in the class declaration

//  Example:
// public class Bird implements FlightEnabled {}
// b/c of this declaration, we can use FlightEnabled as the reference type, and assign it an instance of bird
// in this code sample, we create a new Bird object, but we assign it to the FlightEnabled variable named flier
//  FlightEnabled flier = new Bird();

//  interfaces are implicitely "abstract" thus you do not need to state that an interface or an interface method is "abstract"

// interfaces can be extended by other interfaces
//      interfaces do not implement other interfaces (unlike a class which does implement interfaces)
package java_17.interfaces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Intro {
    
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        FlightEnabled flier = bird;
        Trackable tracked = bird;

        animal.move();
        // flier.move();
        // tracked.move();

        // flier.takeOff();
        // flier.fly();
        // flier.land();
        // tracked.track();

        inFlight(flier);
        inFlight(new Jet());
        Trackable tracked_2 = new Truck();
        tracked_2.track();

        double kmsTraveled = 100;
        double milesTraveled = kmsTraveled * FlightEnabled.KM_TO_MILES;
        System.out.printf("The truck traveled %.2f km or %.2f miles%n", kmsTraveled, milesTraveled);

        // inFlight(new Satellite());
        // new Satellite().achieveOrbit();

        LinkedList<FlightEnabled> fliers = new LinkedList<>();
        fliers.add(bird);
        
        List<FlightEnabled> betterFliers = new ArrayList<>();
        betterFliers.add(bird);

        triggerFliers(fliers);
        flyFliers(fliers);
        landFliers(fliers);

        triggerFliers(betterFliers);
        flyFliers(betterFliers);
        landFliers(betterFliers);

        // OrbitEarth.log("Testing " + new Satellite());

        orbit(new Satellite());
    }

    public static void inFlight(FlightEnabled flier) {
        flier.takeOff();
        flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if(flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    public static void orbit(OrbitEarth flier) {
        flier.takeOff();
        // flier.transition(FlightStages.LAUNCH);
        flier.fly();
        if(flier instanceof Trackable tracked) {
            tracked.track();
        }
        flier.land();
    }

    private static void triggerFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.takeOff();
        }
    }

    private static void flyFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.fly();
        }
    }

    private static void landFliers(List<FlightEnabled> fliers) {
        for (var flier : fliers) {
            flier.land();
        }
    }
}


