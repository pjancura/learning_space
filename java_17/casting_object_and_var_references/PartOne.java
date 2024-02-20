package java_17.casting_object_and_var_references;

import java.util.Scanner;
import java_17.oop_polymorphism.Movie;
import java_17.oop_polymorphism.Adventure;
import java_17.oop_polymorphism.Comedy;
import java_17.oop_polymorphism.ScienceFiction;

public class PartOne {
    
    public static void main(String[] args) {
        // Movie movie = Movie.getMovie("A", "Jaws");
        // movie.watchMovie();

        // // this is an example of casting an object's type
        // Adventure jaws = (Adventure) Movie.getMovie("A", "El Dorado");
        // jaws.watchMovie();

        // Object comedy = Movie.getMovie("C", "Airplane");
        // Comedy comedyMovie = (Comedy) comedy;
        // comedyMovie.watchMovie();
        // comedyMovie.watchComedy();

        // var airplaneII = Movie.getMovie("C", "Airplane II");
        // airplaneII.watchMovie();

        // LVTI -> local variable type inference
        //  benefits the readability of the code, and to reduce boilerplate code
        //  can't be used in field declaarations on a class
        //  can't be used in method signatures, either as a parameter type or a return type
        //  can't be used without an assignment, because the type can't be inferred in that case
        //  can't be assigned a null literal, because a type can't be inferred in that case
        var plane = new Comedy("Planes");
        plane.watchMovie();
        plane.watchComedy();


        // this is testing the runtime type of unknownObject
        Object unknownObject = Movie.getMovie("C", "Airplane");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) {        // the object is being assigned to the binding variable "syfy"
            syfy.watchScienceFiction();
        }
    }


}

// class Movie {
//     private String title;

//     public Movie(String title) {
//         this.title = title;
//     }

//     public void watchMovie() {
//         String instanceType = this.getClass().getSimpleName();
//         System.out.println("\"" + this.title + "\"" + " is a " + instanceType + " film");
//     }

//     // this is called a factory method
//     //      this will give us a correctly instatiated object without having to know the details
//     //      of how to create one or specify the exact class we want
//     public static Movie getMovie(String type, String title) {
//         return switch(type.toUpperCase().charAt(0)) {
//             case 'A' -> new Adventure(title);
//             case 'C' -> new Comedy(title);
//             case 'S' -> new ScienceFiction(title);
//             default -> new Movie(title);
//         };
//     }
// }

// class Adventure extends Movie {
//     public Adventure(String title) {
//         super(title);
//     }   

//     @Override
//     public void watchMovie() {
//         super.watchMovie();
//         System.out.printf("... %s %n".repeat(3),
//                         "Pleasant Scene",
//                             "Scary Music",
//                             "Something Bad Happens");
//     }
// }

// class Comedy extends Movie {
//     public Comedy(String title) {
//         super(title);
//     }

//     @Override
//     public void watchMovie() {
//         super.watchMovie();
//         System.out.printf("... %s %n".repeat(3),
//                             "Something funny happens",
//                             "Somehthing even funnier happens",
//                             "Happy Ending");
//     }
// }

// class ScienceFiction extends Movie {
//     public ScienceFiction(String title) {
//         super(title);
//     }

//     @Override
//     public void watchMovie() {
//         super.watchMovie();
//         System.out.printf("... %s %n".repeat(3),
//                             "Aliens do bad stuff",
//                             "Space guys chase aliens",
//                             "Planet Blows up");
//     }
// }