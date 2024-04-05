package java_17.oop_intro;

// import java_17.oop_intro.Carpet;
// import java_17.oop_intro.Floor;

public class Calculator {
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public Carpet getCarpet() {
        return carpet;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setCarpet(Carpet carpet) {
        this.carpet = carpet;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public double getTotalCost() {
        return this.floor.getArea() * this.carpet.getCost();
    }

    public static void main(String[] args) {
        Floor floor1 = new Floor(5, 5);
        Carpet carpet1 = new Carpet(5.00);
        Calculator calc1 = new Calculator(floor1, carpet1);

        System.out.println(calc1.getTotalCost());

    }
}
