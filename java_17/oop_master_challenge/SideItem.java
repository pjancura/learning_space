package java_17.oop_master_challenge;

public class SideItem {
    private String type;
    private double price;

    public SideItem() {
        this.type = "Fries";
        this.price = priceCalculator(this.type);
    }

    public SideItem(String type) {
        this.type = selectType(type);
        this.price = priceCalculator(this.type);
    }

    private double priceCalculator(String type) {
        return switch(type.toUpperCase().charAt(0)) {
            case 'F' -> 1.5;        // fries
            case 'O' -> 1.75;       // onion rings
            case 'S' -> 2.0;        // salad
            default -> 0.0;
        };
    }

    private String selectType(String type) {
        return switch(type.toUpperCase().charAt(0)) {
            case 'F' -> "Fries";
            case 'O' -> "Onion Rings";
            case 'S' -> "Salad";
            default -> "None";
        };
    }

    public String getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String describeSideItem() {
        return String.format("%20s: %6.2f%n", this.getType().toUpperCase(), this.getPrice());
    }

}
