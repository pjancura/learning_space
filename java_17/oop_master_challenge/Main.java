package java_17.oop_master_challenge;

public class Main {
    
    public static void main(String[] args) {
        Hamburger cheese = Hamburger.getHamburger("Cheese Burger");
        System.out.println(cheese.describeHamburger());

        System.out.println(new SideItem().describeSideItem());
        System.out.println(new Drink().describeDrink());

        // Hamburger superBurger = Hamburger.getHamburger("Super Burger");
        // System.out.println(cheese.describeHamburger());
        // // Topping topping = new Topping("Patty (Extra)");
        // // SuperBurger superBurger2 = new SuperBurger("Super Burger", topping, topping, topping, topping, topping);

        // Drink coke = new Drink("Coke" , "Large");
        // System.out.println(coke.describeDrink());

        // SideItem fries = new SideItem("Fries");
        // System.out.println(fries.describeSideItem());

        // MealOrder meal1 = new MealOrder(cheese, coke, fries);
        // meal1.printMealOrder();

        // MealOrder meal2 = new MealOrder(superBurger, coke, fries);
        // meal2.printMealOrder();

        // MealOrder meal3 = new MealOrder();
        // meal3.printMealOrder();

        MealOrder.createMealOrder().printMealOrder();
    }
}

