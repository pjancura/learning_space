package java_17.oop_inheritance;

public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog() {
        // super() needs to be the first call of the child class's constructor
        super("Mutt", "Big", 50);
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" + 
                "earShape='" + this.earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    public void makeNoise() {
        System.out.println("Bark!");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        System.out.println("Dogs walk, run, and wag their tail");
    }
    
}
