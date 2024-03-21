package java_17.nested_classes.inner_classes.challenge.burger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Meal {

    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;

    public Meal() {
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        this.burger = new Burger();
        this.burger.setPrice(this.burger.getPrice() + burger.addToppings(Burger.Extra.values()));
        this.drink = new Item("coke", "drink", 1.5);
        this.side = new Item("fries", "side", 2.0);
    }

    public double getTotal() {

        double total = this.burger.getPrice() + drink.price + side.price;                   /// fix getTotal() for burger
        return Item.getPrice(total, conversionRate);
    }

    public Burger getBurger() {
        return burger;
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger.toString(), drink, side,
                "Total Due: ", getTotal());
    }

    private class Item {

        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            this(name, type, 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name,
                    getPrice(price, conversionRate));
        }

        private static double getPrice(double price, double rate) {
            return price * rate;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public void setPrice(double price) {
            this.price = price;
        }


    }

    private class Burger extends Item {
        private enum Extra {
            AVACADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;
            
            private double getPrice() {
                return switch (this) {
                    case AVACADO -> 1.5;
                    case BACON -> 1.0;
                    default -> 0;
                };
            }
        }

        private List<Item> toppings;

        Burger() {        
            super("regular", "burger", 4.00);
            this.toppings = new ArrayList<>();
        }

        public Burger(String name, String type, double price) {
            super(name, type, 4.00);
            this.toppings = new ArrayList<>();
        }

        @Override
        public double getPrice() {
            return super.getPrice();
        }

        public List<Item> getToppings() {
            return this.toppings;
        }

        private double addToppings(Extra[] selectedToppings) {
            double toppingTotal = 0.00;
            for (Extra selectedTopping : selectedToppings) {
                this.toppings.add(new Item(selectedTopping.name(), "topping", selectedTopping.getPrice()));
                toppingTotal += selectedTopping.getPrice();
            }
            return toppingTotal;
        }

        @Override
        public String toString() {
            String str = super.toString();
            for (Item topping : this.toppings) {
                str += "\n%-10s %15s$%.2f".formatted(topping.name, " ", topping.price);
            }
            return str;
        }
    }

}
