package java_17.oop_polymorphism;

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
        s.close();
    }

}

