package java_17.lambdas_et_al.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Challenge {
    
    public static void main(String[] args) {
        
        ArrayList<String> source = new ArrayList<>(List.of("Bob", "ted", "fred", "Anna", "Paul", "theresa"));
        
        source.replaceAll((s) -> {
            return s.substring(0, 1).toUpperCase().concat(s.substring(1, s.length()));
        });

        source.forEach(word -> System.out.println(word));

        String[] middleInitials = {"F", "P", "A", "S"};
        String[] selectedInitials = getMiddleInitialsRandomly(source.size(), middleInitials, () -> new Random().nextInt(0, middleInitials.length));
        System.out.println(Arrays.toString(selectedInitials));
        
        source.replaceAll((s) -> s + " " + selectedInitials[source.indexOf(s)] + ".");
        
        source.forEach(word -> System.out.println(word));
        
        String[] newNames = new String[source.size()];

        Arrays.setAll(newNames, (i) -> {
            String temp = "";
            String firstName = source.get(i).split(" ")[0];
            for (int j = firstName.length(); j > 0; j--) {
                if (j == firstName.length()) {
                    temp += String.valueOf(source.get(i).charAt(j - 1)).toUpperCase();
                    continue;
                }
                temp += String.valueOf(source.get(i).charAt(j - 1)).toLowerCase();
            }
            return source.get(i) + " " + temp;
        });

        printNames(newNames);

        Arrays.setAll(newNames, (i) -> newNames[i].toUpperCase());

        printNames(newNames);

        source.replaceAll((s) -> newNames[source.indexOf(s)]);

        
        source.removeIf((s) -> s.split(" ")[0].equals(s.split(" ")[2]));
        
        source.forEach(word -> System.out.println(word));


        
    }

    public static String[] getMiddleInitialsRandomly(int howMany, String[] middleInitials, Supplier<Integer> s) {
        String[] generated = new String[howMany];
        for (int i = 0; i < howMany; i++) {
            generated[i] = middleInitials[s.get()];
        }
        return generated;
    }

    public static void printNames(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
