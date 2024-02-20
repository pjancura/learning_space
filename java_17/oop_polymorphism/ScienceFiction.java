package java_17.oop_polymorphism;

public class ScienceFiction extends Movie {
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


    public void watchScienceFiction() {
        System.out.println("Watchin an Science Fiction!");
    }
}
