package java_17.list_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "Dairy", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", this.count, name.toUpperCase(), this.type);
    }
}

public class Start {
    
    public static void main(String[] args) {
        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);

        System.out.println(Arrays.toString(groceryArray));

        ArrayList objectList = new ArrayList<>();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");
        
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Cheddar Cheese"));
        groceryList.add(new GroceryItem("Heavy Cream"));
        System.out.println(groceryList.toString());
        groceryList.add(0, new GroceryItem("Cottage Cheese"));
        System.out.println(groceryList.toString());


        String[] items = {"apples", "bananas", "milk", "eggs"};

        List<String> list = List.of(items);
        System.out.println(list);

        System.out.println(list.getClass().getName());

        // the following line causes a compilation error because List is an immutable object
        // list.add("yogurt");

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);

        System.out.println("third item = " + groceries.get(2));

        if (groceries.contains("mustard")) {
            System.out.println("this contains mustard");
        }
        groceries.add("pickles");
        System.out.println("first = " + groceries.indexOf("pickles"));
        System.out.println("Last = " + groceries.lastIndexOf("pickles"));

        groceries.remove(2);
        System.out.println(groceries);
        groceries.remove("cheese");
        System.out.println(groceries);
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        groceries.clear();
        System.out.println(groceries);

        System.out.println("isEmpty = " + groceries.isEmpty());

        groceries.addAll(List.of("apples", "millk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        var groceryArr = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArr));
    }
}
