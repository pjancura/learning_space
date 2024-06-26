package java_17.lambdas_et_al.method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class PlainOld {
    private static int last_id = 0;

    private int id;

    public PlainOld() {
        id = last_id++;
        System.out.println("Creating a PlainOld Object: id = " + id);
    }
}

public class Main {
    
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));

        // System.out::println is an example of a method reference
        list.forEach(System.out::println);

        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 1.25, 10.25);

        Supplier<PlainOld> reference1 = PlainOld::new;

        PlainOld newPofo = reference1.get();

        System.out.println("Getting array");
        PlainOld[] pojo1 = seedArray(reference1, 10);

        calculator((s1, s2) -> s1 + s2, "Hello ", "World");
        calculator(String::concat, "Hello ", "World");

        BinaryOperator<String> b1 = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello", "world"));
        System.out.println(b2.apply("Hello    ", "world"));
        System.out.println(u1.apply("Hello"));

        String result = "Hello".transform(u1);
        System.out.println(result);

        //          String::toLowerCase   is an example of a bounded receiver (a specific type of method reference)
        result = result.transform(String::toLowerCase);
        System.out.println(result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println(resultBoolean);
    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}
