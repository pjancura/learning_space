package java_17.oop_polymorphism;

public class Adventure extends Movie {
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

    public void watchAdventure() {
        System.out.println("Watchin an Adventure!");
    }
}
