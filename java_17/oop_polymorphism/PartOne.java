package java_17.OopPolymorphism;

import java.util.Scanner;

public class PartOne {
    
    public static void main(String[] args) {
        Movie movie1 = new Movie("Basic Movie");
        movie1.watchMovie();

        Movie adventure1 = new Adventure("Adventure Movie");
        adventure1.watchMovie();
        
        Movie theMovie = Movie.getMovie("Adventure", "Adventure Time");
        theMovie.watchMovie();

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Type (A for Adventure, C for Comedy, " +
                            "S for Science Fiction, or Q to quit \t");
            String type = s.nextLine();
            if ("Qq".contains(type)) {
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();

        }
    }


}

class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.println("\"" + this.title + "\"" + " is a " + instanceType + " film");
    }

    // this is called a factory method
    //      this will give us a correctly instatiated object without having to know the details
    //      of how to create one or specify the exact class we want
    public static Movie getMovie(String type, String title) {
        return switch(type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie {
    public Adventure(String title) {
        super(title);
    }   

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s %n".repeat(3),
                        "Pleasant Scene",
                            "Scary Music",
                            "Something Bad Happens");
    }
}

class Comedy extends Movie {
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s %n".repeat(3),
                            "Something funny happens",
                            "Somehthing even funnier happens",
                            "Happy Ending");
    }
}

class ScienceFiction extends Movie {
    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf("... %s %n".repeat(3),
                            "Aliens do bad stuff",
                            "Space guys chase aliens",
                            "Planet Blows up");
    }
}