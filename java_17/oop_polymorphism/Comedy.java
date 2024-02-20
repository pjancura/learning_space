package java_17.oop_polymorphism;

public class Comedy extends Movie {
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


    public void watchComedy() {
        System.out.println("Watchin a Comedy!");
    }
}
