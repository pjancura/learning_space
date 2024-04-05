package java_17.list_concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArrayListChallenge {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        ArrayList<String> groceryList = new ArrayList<>();
        int currentOperation = 1;
        int[] operationOptions = {0, 1, 2};
        while (currentOperation != 0) {
            int operation = 0;
            System.out.println("Available actions:\n\n0 - to shutdown\n\n1 - to add item(s) to list (comma delimited list)\n\n2 - to remove any items (comma delimited list)\n\nEnter a number for which action you want to do:\n");
            try {
                operation = Integer.parseInt(s.nextLine());
            } catch (Exception e){
                System.out.println("Not a number. Please enter an appropriate response...");
                continue;
            }
            System.out.println(Arrays.binarySearch(operationOptions, operation));
            if (Arrays.binarySearch(operationOptions, operation) >= 0) {
                if (operation == 0) {
                    break;
                } else if (operation == 1) {
                    System.out.println("Enter items to add to your grocery list: ");
                    String str = s.nextLine();
                    String[] strArray = str.split(",");
                    for (var item : strArray) {
                        String trimmed = item.trim();
                        if (groceryList.contains(trimmed)) {
                            continue;
                        } else {
                            groceryList.add(trimmed);
                        }
                    }
                } else {
                    if (groceryList.size() >= 1) {
                        System.out.println("enter items to remove from your grocery list:");
                        String str = s.nextLine();
                        String[] strArray = str.split(",");
                        for (var item : strArray) {
                            if (groceryList.contains(item)) {
                                groceryList.remove(item);
                            } else {
                                System.out.println(item + " not in list");
                                continue;
                            }
                        }
                    } else {
                        System.out.println("List is empty...");
                        continue;
                    }
                }
            } else {
                System.out.println("Please enter an appropriate response...");
                continue;
            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println("Grocery List: \n");
            for (var item : groceryList) {
                System.out.printf("%20s\n", item);
            }
        }
        groceryList.sort(Comparator.naturalOrder());
        System.out.println("Finalized Grocery List: \n");
        if (groceryList.size() > 0) {
            for (var item : groceryList) {
                System.out.printf("%20s\n", item);
            }
        } else {
            System.out.println("\t\tGrocery List is empty...");
        }
        s.close();
    }
}
