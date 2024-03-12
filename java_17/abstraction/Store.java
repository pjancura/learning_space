package java_17.abstraction;

import java.util.ArrayList;
import java.util.Scanner;

import java_17.oop_composition.Product;

public class Store {
    
    public static void main(String[] args) {
        Milk twoPercentGallon = new Milk("2% Milk Gallon", 4.00, "This is a gallon of 2% milk in a gallon jug. Pasteurized. Organic.");
        Milk twoPercentHalfGallon = new Milk("2% Milk Half-Gallon", 2.75, "This is an half-gallon of 2% milk. Pasteurized. Organic.");
        Milk twoPercentPint = new Milk("2% Milk Pint", 1.75, "A pint of 2% milk in a carton.  Pasteurized. Organic.");

        Vegetable lettuce = new Vegetable("Green Leaf Lettuce", 0.90, "Green Leaf Lettuce. sold by the head. Organic.");
        Vegetable potatoes = new Vegetable("Yukon Gold Potatoes", 0.50, "Yukon Gold Potatoes grown in Idaho.  Harvested in late October by hand.");
        Vegetable tomatoes = new Vegetable("Roma Tomatoes", 1.00, "Roma tomatoes sold by the pound. Grown in Nebraska. Harvested by hand.");

        Bread hotDogBuns = new Bread("Hotdog Buns, 6pk", 4.50, "6 pack of the finest hotdogs. Made with whole grain wheat.");
        Bread baguette = new Bread("Baguette", 3.50, "12\" long baguette.  Made with whole wheat sourdough. This item is meant to be taken home and baked for perfect freshness");
        Bread dinnerRoll = new Bread("Dinner Roll - 10pack", 6.25, "10 pack of Dinner Rolls. Made with sweet bread that will add exactly what you are looking for to enhance your family get together.");

        Store store = new Store();
        store.addProduct(twoPercentGallon);
        store.addProduct(twoPercentHalfGallon);
        store.addProduct(twoPercentPint);
        store.addProduct(lettuce);
        store.addProduct(potatoes);
        store.addProduct(tomatoes);
        store.addProduct(hotDogBuns);
        store.addProduct(baguette);
        store.addProduct(dinnerRoll);

        // for (ProductForSale product : store.getProductsForSale()) {
        //     product.showDetails();
        // }

        store.openStore();
    }

    private ArrayList<ProductForSale> productsForSale;

    public Store() {
        this.productsForSale = new ArrayList<>();
    }

    public Store(ArrayList<ProductForSale> productsForSale) {
        this.productsForSale = productsForSale;
    }

    public void addProduct(ProductForSale productForSale) {
        this.productsForSale.add(productForSale);
    }

    public ArrayList<ProductForSale> getProductsForSale() {
        return this.productsForSale;
    }

    public void openStore() {
        String menu = """
                Menu Options:
                (A)dd Line Item
                (R)emove Line Item
                (P)rint Order
                (M)enu
                (Q)uit
                """;
                System.out.println(menu);
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (true) {
            String input = s.nextLine();
            switch(input.toUpperCase().charAt(0)) {
                case 'A' -> {
                    OrderItem orderItem = this.addOrderItem();
                    if (orderItem != null) {
                        orderItems.add(orderItem);
                    } else {
                        System.out.println("Invalid Order Item, pick new Option.");
                        System.out.println(menu);
                    }
                }
                case 'R' -> {
                    this.removeOrderItem(orderItems);
                }
                case 'P' -> this.printOrderItems(orderItems);
                case 'M' -> System.out.println(menu);
                case 'Q' -> {
                    break;
                }
                default -> {
                    System.out.println("Invalid input"); 
                    // continue;
                }
            };
        }
    }

    public OrderItem addOrderItem() {
        OrderItem orderItem = null;
        Scanner s = new Scanner(System.in);
        System.out.println("What type of product are you looking for?\n(M)ilk\n(V)egetable\n(B)read");
        String input = s.nextLine();
        switch (input.toUpperCase().charAt(0)) {
            case 'M' -> orderItem = this.createOrderItem("Milk");
            case 'V' -> orderItem = this.createOrderItem("Vegetable");
            case 'B' -> orderItem = this.createOrderItem("Bread");
            default -> {
                System.out.println("Invalid Input");
                // continue;
            }
        };
        return orderItem;
    }

    public OrderItem createOrderItem(String category) {
        ArrayList<ProductForSale> productsInCategory = this.getProductsInCategory(category);
        this.printProductsInCategory(productsInCategory);
        ProductForSale pickedProduct = this.pickProduct(productsInCategory);
        if (pickedProduct != null) {
            return new OrderItem(pickedProduct);
        } else {
            return null;
        }
    }

    private ArrayList<ProductForSale> getProductsInCategory(String category) {
        ArrayList<ProductForSale> categoryProducts = new ArrayList<>();
        for (ProductForSale product : this.getProductsForSale()) {
            String productType = product.getClass().getSimpleName();
            if (productType.equals(category))  {
                System.out.println("added");
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    public void printProductsInCategory(ArrayList<ProductForSale> productsInCategory) {
        for (int i = 0; i < productsInCategory.size(); i++) {            
            System.out.print("(" + (i + 1) + ") ");
            productsInCategory.get(i).showDetails();
        }
    }

    public ProductForSale pickProduct(ArrayList<ProductForSale> productsInCategory) {
        System.out.print("Enter the number of the product you would like to add to your order:\t");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        for (int i = 0; i < productsInCategory.size(); i++) {
            if ((i + 1) == Integer.parseInt(input)) {
                return productsInCategory.get(i);
            }
        }
        return null;
    }

    public void removeOrderItem(ArrayList<OrderItem> orderItems) {
        if (orderItems.size() <= 0) {
            System.out.println("There are no items to remove.");
        } else {
            Scanner s = new Scanner(System.in);
            System.out.println("Which item would you like to remove?");
            for (int i = 0; i < orderItems.size(); i++) {
                OrderItem currentProduct = orderItems.get(i);
                System.out.print("(" + (i + 1) + ")");
                currentProduct.getProductForSale().printPricedLineItem(currentProduct.getQuantity());
            }
            System.out.print("Enter Item Number: ");
            String input = s.nextLine();
            orderItems.remove(Integer.parseInt(input) - 1);
        }
    }
    
    public void printOrderItems(ArrayList<OrderItem> orderItems) {
        if (orderItems.size() <= 0) {
            System.out.println("Your shopping list is empty.");
        } else {
            System.out.println("Here is your current shopping list:");
            double total = 0.00;
            for (OrderItem item : orderItems) {
                double quantity = item.getQuantity();
                System.out.print(quantity + " x\t");
                item.getProductForSale().printPricedLineItem(quantity);
                total += item.getProductForSale().getPrice() * quantity;
            }
            System.out.println("---------------------");
            System.out.printf("%28s: %10.2f%n", "TOTAL", total);
        }
    }
    

}

abstract class ProductForSale {
    protected String type;
    private double price;
    private String description;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    public double getSalesPrice(double quantity) {
        return quantity * this.price;
    }

    public void printPricedLineItem(double quantity) {
        System.out.printf("%20s: %10.2f%n", this.type, this.getSalesPrice(quantity));
    }

    public abstract void showDetails();
}

class Milk extends ProductForSale {
    public Milk(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        String formatted = String.format("%s%nPrice per Unit: %.2f%n%15s%n", this.type.toUpperCase(), this.getPrice(), this.getDescription());
        System.out.println(formatted);
    }
}

class Vegetable extends ProductForSale {
    public Vegetable(String type, double price, String description) {
        super(type, price, description); 
    }

    @Override
    public void showDetails() {
        String formatted = String.format("%s%nPrice per .lbs: %.2f%n%30s%n", this.type.toUpperCase(), this.getPrice(), this.getDescription());
        System.out.println(formatted);
    }
}

class Bread extends ProductForSale {
    public Bread(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        String formatted = String.format("%s%nPrice per Unit: %.2f%n%30s%n", this.type.toUpperCase(), this.getPrice(), this.getDescription());
        System.out.println(formatted);
    }
}

class OrderItem {
    private ProductForSale productForSale;
    private double quantity;

    public OrderItem(ProductForSale productForSale) {
        this.productForSale = productForSale;
        this.quantity = 0.00;
        this.setQuantity();
    }

    public OrderItem(ProductForSale productForSale, double quantity) {
        this.productForSale = productForSale;
        this.quantity = quantity;
    }

    public ProductForSale getProductForSale() {
        return productForSale;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setQuantity() {
        System.out.print("How much of " + this.productForSale.type.toUpperCase() + " would you like?\t");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        this.quantity = Double.parseDouble(input);
    }


}