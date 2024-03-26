package java_17.lambdas_et_al.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java_17.oop_intro.ClassesObjects.Person;

public class Main {

    record Person(String fName, String lName) {

        @Override
        public String toString() {
            return fName + " " + lName;
        }
    }
    
    public static void main(String[] args) {
        
        List<Person> people = new ArrayList<>(Arrays.asList(
            new Main.Person("Lucy", "Van Pelt"),
            new Person("Sally", "Brown"),
            new Person("Linus", "Van Pelt"),
            new Person("Peppermint", "Patty"),
            new Person("Charlie", "Brown")     
        ));

        // using anonymous class
        // var comparatorLastName = ;

        people.sort((Person o1, Person o2) -> o1.lName(). compareTo(o2.lName()));
        System.out.println(people);

        interface enhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new enhancedComparator<Person>() {

            @Override
            public int compare (Person o1, Person o2) {
                int result = o1.lName().compareTo(o2.lName());
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.fName().compareTo(o2.fName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);


        List<String> list = new ArrayList<>(List.of(
            "alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("______");
        list.forEach(myString -> System.out.println(myString));

        System.out.println("______");
        String prefix = "nato";
        list.forEach((var myString) -> {
            char first = myString.charAt(0);
            System.out.println(prefix + " " + myString + " means " + first);
        });

        int result = calculator((Integer a, Integer b) -> a + b, 5, 2);
        var result2 = calculator((a, b) -> a / b, 10.0, 2.5);
        var result3 = calculator((a, b) -> a.toUpperCase() + " " + b.toUpperCase(), "Ralph", "Kramer");

    }

    public static <T> T calculator(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
