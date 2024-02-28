package java_17.list_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedChallenge {
    
    public static void main(String[] args) {
        Place.planTrip();

        // LinkedList<Place> places = Place.getPlaces();
        // System.out.println(Place.queryPlaces("Sydney").getClass().getSimpleName() );
        // System.out.println(Place.addStop().getTown());
        // Place.printItinerary(places);

    }

}

class Place {
    private String town;
    private int distanceFromSydney;

    public Place(String town, int distanceFromSydney) {
        this.town = town;
        this.distanceFromSydney = distanceFromSydney;
    }

    public int getDistanceFromSydney() {
        return distanceFromSydney;
    }

    public String getTown() {
        return town;
    }

    public void setDistanceFromSydney(int distanceFromSydney) {
        this.distanceFromSydney = distanceFromSydney;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public static LinkedList<Place> getPlaces() {
        LinkedList<Place> places =  new LinkedList<Place>();
        places.add(new Place("Sydney", 0));
        places.add(new Place("Adelaide", 1374));
        places.add(new Place("Brisbane", 917));
        places.add(new Place("Darwin", 3972));
        places.add(new Place("Melbourne", 877));
        places.add(new Place("Perth", 3923));
        return places;
    }

    public void printPlace() {
        System.out.println("Town: " + this.getTown() + "\tdistanceFromSydney: " + this.getDistanceFromSydney());
    }

    public static void printDestinations() {
        for (Place place : Place.getPlaces()) {
            place.printPlace();
        }
    }

    public static void printItinerary(LinkedList<Place> list) {
        System.out.println("Trip starts at " + list.getFirst().getTown());
        String previousTown = list.getFirst().getTown();
        ListIterator<Place> iterator = list.listIterator(1);
        while(iterator.hasNext()) {
            Place town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town.getTown());
            previousTown = town.getTown();
            
        }
        if (list.size() > 1) {
            System.out.println("Trip ends at " + list.getLast().getTown());
        } else {
            System.out.println("Add some places to travel to.");
        }
    }

    public static Place queryPlaces(String townName) {
        LinkedList<Place> places = Place.getPlaces();
        for (Place town : places) {
            if (town.getTown() == townName) {
                System.out.println(town.getTown() + " was added to your Itinerary.");
                return town;
            }
        }
        System.out.println("That town isn't an option");
        return null;
    }


    public static void addStop(LinkedList<Place> places) {
        Scanner s = new Scanner(System.in);
        System.out.println("Pick a place from our options");
        Place.printDestinations();
        String input = s.nextLine();
        // char inputChar = input.toUpperCase().charAt(0);
        // char[] chars = {'S', 'A', 'B', 'D', 'M', 'P'};
        // try {

        // }
        switch(input.toUpperCase().charAt(0)) {
            case 'S':
                places.add(Place.queryPlaces("Sydney"));
                break;
            case 'A':
                places.add(Place.queryPlaces("Adelaide"));
                break;
            case 'B':
                places.add(Place.queryPlaces("Brisbane"));
                break;
            case 'D':
                places.add(Place.queryPlaces("Darwin"));
                break;
            case 'M':
                places.add(Place.queryPlaces("Melbourne"));
                break;
            case 'P':
                places.add(Place.queryPlaces("Perth"));
                break;
            default:
                System.out.println("Sorry that place isn't an option");
                break;
        };
    }

    public static void removeStop(LinkedList<Place> places) {
        Scanner s = new Scanner(System.in);
        System.out.println("Pick a place to remove from your itinerary:");
        Place.printItinerary(places);
        String str = s.nextLine();
        String removal = "";
        switch(str.toUpperCase().charAt(0)) {
            case 'S' -> removal = "Sydney";
            case 'A' -> removal = "Adelaide";
            case 'B' -> removal = "Brisbane";
            case 'D' -> removal = "Darwin";
            case 'M' -> removal = "Melbourne";
            case 'P' -> removal = "Perth";
            default -> System.out.println("Sorry that place isn't an option");
        };
        for (Place town : places) {
            // System.out.println(((town.getTown() instanceof String) + " " + (removal instanceof String)));
            if (town.getTown() == removal) {
                places.remove(town);
                System.out.println(town.getTown() + " was removed from your itinerary.");
                break;
            }
        } 
    }

    public static int nextStop(int index, LinkedList<Place> places) {
        // System.out.println("Index: " + index + "\tPlaces.size(): " + places.size());
        if (places.size() <= 1) {
            System.out.println(places.get(0).getTown() + " is your only stop.");
            return 1;
        } else if (index > places.size() || index + 1 >= places.size()) {
            System.out.println(places.getLast().getTown() + " is your last stop.");
            return places.size() - 1;
        } else if (index == 0 && places.size() > 1) {
            System.out.println(places.get(index + 1).getTown() + " is your next stop.");
            return index += 2;
        } else if (index <= 0) {
            System.out.println(places.getFirst().getTown() + " is your first stop.");
            return 1;
        }
        System.out.println(places.get(index).getTown() + " is your next stop.");
        return index += 1;
    }

    public static int previousStop(int index, LinkedList<Place> places) {
        // System.out.println("Index: " + index + "\tPlaces.size(): " + places.size());
        if (places.size() <= 1) {
            System.out.println(places.get(0).getTown() + " is your only stop.");
            return 1;
        } else if (index > places.size() && index != 0) {
            System.out.println(places.getLast().getTown() + " is your last stop.");
            return places.size() - 1;
        } else if (index <= 0) {
            System.out.println(places.getFirst().getTown() + " is your first stop.");
            return 0;
        } else if (index == places.size() - 1) {
            System.out.println(places.get(index - 1).getTown() + " was the previous stop.");
            return index - 2;
        }
        System.out.println(places.get(index).getTown() + " was the previous stop.");
        return index -= 1;
    }

    public static void planTrip() {
        Scanner s = new Scanner(System.in);
        String menuOptions = """
                _____________________        
                Available actions (select word or letter):
                (N)ext Stop
                (P)revious Stop
                (L)ist Itinerary
                (O)ptional Stops
                (A)dd Stop
                (R)emove Stop
                (M)enu
                (Q)uit
                _____________________
                """;
        // LinkedList<Place> placeOptions = Place.getPlaces();
        LinkedList<Place> itinerary = new LinkedList<>();
        itinerary.add(new Place("Sydney", 0));
        int currentIndex = 1;
        char planning = 'Y';
        System.out.println(menuOptions);
        do {
            System.out.print("Enter menu option:\t");
            String input = s.nextLine();
            switch(input.toUpperCase().charAt(0)) {
                case 'N' -> currentIndex = Place.nextStop(currentIndex, itinerary);
                case 'P' -> currentIndex = Place.previousStop(currentIndex, itinerary);
                case 'L' -> Place.printItinerary(itinerary);
                case 'O' -> Place.printDestinations();
                case 'A' -> Place.addStop(itinerary);
                case 'R' -> Place.removeStop(itinerary);
                case 'M' -> System.out.println(menuOptions);
                case 'Q' -> planning = 'Q';
                default -> System.out.println("Try new Input");
            };
            // System.out.println("CurrentIndex: " + currentIndex);
        } while(planning != 'Q');
        System.out.println("Thanks for planning your trip!\nHere is your itinerary:\n");
        Place.printItinerary(itinerary);
        s.close();
    }
}


