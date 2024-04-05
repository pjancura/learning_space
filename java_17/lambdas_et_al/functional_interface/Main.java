package java_17.lambdas_et_al.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import java_17.lambdas_et_al.lambdas.*;

public class Main {
    
    public static void main(String[] args) {
        var result4 = calculator((a, b) -> a * b, 10, 12);  
        
        var coords = Arrays.asList(
            new double[]{47.2160, -95.2348},
            new double[]{29.1566, -89.2495},
            new double[]{35.1556, -90.0659}
        );

        List<String> list = new ArrayList<>(List.of(
            "alpha", "bravo", "charlie", "delta"));

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        System.out.println();

        BiConsumer<Double,Double> p1 = (lat, lng) -> System.out.printf("[lat:%.2f, long:%.2f]%n", lat, lng);

        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("\nUsing Biconsumer Functional Interface");

        coords.forEach(s -> processPoint(s[0], s[1], p1));

        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i + 1) + ". " + 
            switch(i) {
                case 0 -> "one";
                case 1 -> "two";
                case 2 -> "three";
                case 3 -> "four";
                default -> "";
            }
        );
        
        System.out.println(Arrays.toString(emptyStrings));

        String[] names = {"Ann", "bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names, 
                                () -> new Random().nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));


        
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
