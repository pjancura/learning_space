package java_17.lambdas_et_al.method_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class Challenge {

    private record Person(String first) {

        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }
    
    public static void main(String[] args) {
        ArrayList<String> source = new ArrayList<>(List.of("Bob", "ted", "fred", "Anna", "Paul", "theresa"));

        Person tom = new Person("Tom");

        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> randomMiddleInitial = (s) -> s + " " + ((char) new Random().nextInt('A', 'Z' + 1)) + ".";
        Function<String, String> addLastName = (s) -> s + " " + new StringBuilder(s.split(" ")[0]).reverse();

        String[] sourceArray = new String[source.size()];
        for (int i = 0; i < source.size(); i++) {
            sourceArray[i] = source.get(i);
        }

        List<Function<String, String>> stringFunctions = new ArrayList<>(List.of(toUpperCase, randomMiddleInitial, addLastName,
                                                            String::new, s-> new String("Howdy " + s), String::valueOf, tom::last
                                                        ));

        applyChanges(source, stringFunctions);

        // source.replaceAll((s) -> s.transform(toUpperCase));
        // source.forEach(System.out::println);

        // source.replaceAll(s -> s.transform(randomMiddleInitial));
        // source.forEach(System.out::println);

        // source.replaceAll(s -> s.transform(addLastName));
        // source.forEach(System.out::println);


    }

    private static void applyChanges(List<String> source, List<Function<String, String>> stringFunctions) {
        stringFunctions.forEach(f -> {
                source.replaceAll((s) -> s.transform(f));
                source.forEach(System.out::println);
        });
       
    }

}
