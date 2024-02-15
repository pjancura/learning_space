package java_17.oop_inheritance;

public class Animal {
    
    private String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public Animal() {
        
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + this.type + '\'' +
                ", size='" + this.size + '\'' +
                ", weight= " + this.weight + "}";
    }

    public void move(String speed) {
        System.out.println(this.type + " moves " + speed);
    }

    public void makeNoise() {
        System.out.println((this.type + " makes some kind of noise!"));
    }
}
