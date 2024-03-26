package java_17.oop_master_challenge;

public class Drink {
    private String type;
    private String size;
    private double price;

    public Drink() {
        this.type = "Coke";
        this.size = "Medium";
        this.price = priceCalculator(this.size);
    }

    public Drink(String type, String size) {
        this.type = type;
        this.size = selectSize(size);
        this.price = priceCalculator(size);
    }

    private double priceCalculator(String drinkSize) {
        return switch (drinkSize.toUpperCase().charAt(0)) {
            case 'S' -> 1.0;
            case 'M' -> 1.5;
            case 'L' -> 2.0;
            default -> 0.0;
        };
    }

    private String selectSize(String size) {
        return switch(size.toUpperCase().charAt(0)) {
            case 'S' -> "Small";
            case 'M' -> "Medium";
            case 'L' -> "Large";
            default -> "None";
        };
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String describeDrink() {
        return String.format("%20s: %6.2f\n", this.getSize().toUpperCase() + " " + this.getType().toUpperCase(), this.getPrice()); 
    }

}
