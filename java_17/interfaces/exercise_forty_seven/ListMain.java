package java_17.interfaces.exercise_forty_seven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ListMain {
    
    public static void main(String[] args) {
        // ArrayList<Integer> intArray = generateListItems();
        ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(80, 95, 12, 70, 88, 45, 28, 5, 22, 18));
        ArrayList<Integer> intArrayNoRightLinks = new ArrayList<>(Arrays.asList(80, 12, 70, 88, 45, 28, 5, 22, 18));
        ArrayList<Integer> intArrCopy = new ArrayList<>(Arrays.asList(80, 95, 12, 70, 88, 45, 28, 5, 22, 18, 0));

        // MyLinkedList linked = new MyLinkedList(null);
        // for (Integer x : intArray) {
        //     // System.out.println("adding " + x + " to linked");
        //     linked.addItem(new Node(x));    
        //     linked.traverse(linked.getRoot());
        //     System.out.println(" ");
        // }

        SearchTree tree = new SearchTree(null);
        // intArray.sort(Comparator.naturalOrder());

        while (intArray.size() >= 1) {
            Integer mid = returnMid(intArray);
            System.out.println(mid);
            // System.out.println(intArray + "\t\t" + mid);
            // System.out.println("adding: " + mid);
            tree.addItem(new Node(mid));
        }
        // tree.traverse(tree.getRoot());
        System.out.println(" ");


        // System.out.println(intArrCopy);
        // for (Integer x : intArrCopy) {
        //     tree.findValue(new Node(Integer.valueOf(x)));
        // }

        // checks if a tree with a single root node can be deleted
        // Node node = new Node(15);
        // SearchTree tree2 = new SearchTree(node);
        // if (tree2.removeItem(node)) {
        //     System.out.println("Root was removed");
        // }
        // tree2.traverse(tree2.getRoot());

        Integer value = 12;
        if (tree.removeItem(new Node(value))) {
            System.out.println("Value " + value + " removed");
        };
        tree.traverse(tree.getRoot());

        
    }

    public static ArrayList<Integer> generateListItems() {
        ArrayList<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Integer x = (int) (Math.random() * 100);
            // System.out.println(x);
            intArray.add(x);
        }
        System.out.println(intArray);
        return intArray;
    }

    public static Integer returnMid(ArrayList<Integer> intArray) {
        Integer mid = 0;
        if (intArray.size() == 1) {
            mid = intArray.get(0);
        } else {
            mid = intArray.get((int) Math.ceil(intArray.size() / 2) - 1);
        }
        intArray.remove(mid);
        return mid;
    }


}
