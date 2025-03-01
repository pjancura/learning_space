package java_17.oop_polymorphism;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        String instanceType = this.getClass().getSimpleName();
        System.out.println("\"" + this.title + "\"" + " is a " + instanceType + " film");
    }

    // this is called a factory method
    // this will give us a correctly instatiated object without having to know the
    // details
    // of how to create one or specify the exact class we want
    public static Movie getMovie(String type, String title) {
        return switch (type.toUpperCase().charAt(0)) {
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}
