package java_17.oop_master_challenge;

import java.util.Scanner;

public class Hamburger {
    private String type;
    private double cost = 3.50;

    public Hamburger(String type) {
        this.type = type;
    }
    public Hamburger(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }
    
    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }

    public String describeHamburger() {
        String classString = this.getClass().getSimpleName().toUpperCase();
        String splitClass = classString.substring(0, classString.indexOf("BURGER")) + " " + classString.substring(classString.indexOf("BURGER"));
        return String.format("%20s: %6.2f\n%20s\n%20s\n%20s\n", splitClass, this.getCost(), "Lettuce", "Tomato", "Ketchup");
    }

    public static Hamburger getHamburger(String type) {
        return switch(type.toUpperCase().charAt(0)) {
            case 'C' -> new CheeseBurger("Cheese Burger");
            case 'D' -> new DoubleBurger("Double Burger");
            case 'B' -> new BaconBurger("Bacon Burger");
            case 'S' -> new SuperBurger("Super Burger");
            case 'T' -> new TailoredBurger("Tailored Burger");
            default -> new Hamburger("Regular Hamburger");
        };
    }

}

class CheeseBurger extends Hamburger {
    private Topping topping1 = new Topping("Cheese");
    private Topping topping2 =new Topping("Onions");
    private Topping topping3 = new Topping("None");

    public CheeseBurger(String type) {
        super(type);
        Topping[] toppings = {this.topping1, this.topping2, this.topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    public CheeseBurger(String type, Topping topping1, Topping topping2, Topping topping3) {
        super(type);
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        Topping[] toppings = {topping1, topping2, topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    @Override
    public String describeHamburger() {
        return super.describeHamburger() + String.format("%20s\n".repeat(2), this.topping1.getType(), this.topping2.getType());
    }
}

class DoubleBurger extends Hamburger {
    private Topping topping1 = new Topping("Patty");
    private Topping topping2 = new Topping("Onions");
    private Topping topping3 = new Topping("Mushrooms");

    public DoubleBurger(String type) {
        super(type);
        Topping[] toppings = {this.topping1, this.topping2, this.topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    public DoubleBurger(String type, Topping topping1, Topping topping2, Topping topping3) {
        super(type);
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        Topping[] toppings = {topping1, topping2, topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    @Override
    public String describeHamburger() {
        return super.describeHamburger() + String.format("%20s\n".repeat(3), this.topping1.getType(), this.topping2.getType(), this.topping3.getType());
    }
}

class BaconBurger extends Hamburger {
    private Topping topping1 = new Topping("Bacon");
    private Topping topping2 = new Topping("Onions");
    private Topping topping3 = new Topping("Mushrooms");

    public BaconBurger(String type) {
        super(type);
        Topping[] toppings = {this.topping1, this.topping2, this.topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    public BaconBurger(String type, Topping topping1, Topping topping2, Topping topping3) {
        super(type);
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        Topping[] toppings = {topping1, topping2, topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    @Override
    public String describeHamburger() {
        return super.describeHamburger() + String.format("%20s\n".repeat(3), this.topping1.getType(), this.topping2.getType(), this.topping3.getType());
    }
}

class SuperBurger extends Hamburger {
    private Topping topping1;
    private Topping topping2;
    private Topping topping3;
    private Topping topping4;
    private Topping topping5;

    public SuperBurger(String type) {
        super(type);
        System.out.println("You can pick up to 5 toppings.");
        this.topping1 = Topping.getTopping();
        this.topping2 = Topping.getTopping();
        this.topping3 = Topping.getTopping();
        this.topping4 = Topping.getTopping();
        this.topping5 = Topping.getTopping();
        super.setCost(15.00);
    }

    public SuperBurger(String type, Topping topping1, Topping topping2, Topping topping3, Topping topping4, Topping topping5) {
        super(type);
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.topping4 = topping4;
        this.topping5 = topping5;
        super.setCost(15.00);
    }

    @Override
    public String describeHamburger() {
        String s = super.describeHamburger();
        if (topping1.getCost() != -1) {
            s += String.format("%20s\n", this.topping1.getType());
        }
        if (topping2.getCost() != -1) {
            s += String.format("%20s\n", this.topping2.getType());
        }
        if (topping3.getCost() != -1) {
            s += String.format("%20s\n", this.topping3.getType());
        }
        if (topping4.getCost() != -1) {
            s += String.format("%20s\n", this.topping4.getType());
        }
        if (topping5.getCost() != -1) {
            s += String.format("%20s\n", this.topping5.getType());
        }
        return s;
    }
}

class TailoredBurger extends Hamburger {
    private Topping topping1;
    private Topping topping2;
    private Topping topping3;

    public TailoredBurger(String type) {
        super(type);
        System.out.println("You can pick up to 3 toppings.");
        this.topping1 = Topping.getTopping();
        this.topping2 = Topping.getTopping();
        this.topping3 = Topping.getTopping();
        Topping[] toppings = {this.topping1, this.topping2, this.topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }


    public TailoredBurger(String type, Topping topping1, Topping topping2, Topping topping3, Topping topping4, Topping topping5) {
        super(type);
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        Topping[] toppings = {this.topping1, this.topping2, this.topping3};
        super.setCost(super.getCost() + Topping.toppingCostCalculator(toppings));
    }

    @Override
    public String describeHamburger() {
        String s = super.describeHamburger();
        if (topping1.getCost() != -1) {
            s += String.format("%20s\n", this.topping1.getType());
        }
        if (topping2.getCost() != -1) {
            s += String.format("%20s\n", this.topping2.getType());
        }
        if (topping3.getCost() != -1) {
            s += String.format("%20s\n", this.topping3.getType());
        }
        return s;
    }
}

