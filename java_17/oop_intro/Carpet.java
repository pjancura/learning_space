package java_17.oop_intro;

public class Carpet {
    private double cost;

    public Carpet(double cost) {
        this.cost = cost;
        if (cost < 0) {
            this.cost = 0;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
        if (cost < 0) {
            this.cost = 0;
        }
    }
}
