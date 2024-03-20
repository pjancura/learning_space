package java_17.generics;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {
    @Override 
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
};

public class MainTwo {
    
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }
        printList(lpaStudents);
        printMoreList(lpaStudents);
        System.out.println(lpaStudents.get(0).getClass().getSuperclass().getSimpleName());


        testList(new ArrayList<String>(List.of("Able", "Barry", "Charlie")));
        testList(new ArrayList<Integer>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreList(matches);

        var students2024 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted",  "2025");
        printMoreList(students2024);
    }


    // printList() is a generic method
    //      the <T> before void
    //          doesn't necessarily refer to same type as is psecified in the generic class header
    public static <T extends Student> void printList(List<T> students) {
        for(var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    //  the ? is a wildcard
    //      this is a similar way of enforcing bounds to inputs as above
    public static void printMoreList(List<? extends Student> students) {
        for(var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();

        // the next line proves the type enforcement of more than one classes / interfaces on a class
        // QueryList<Employee> employeeList = new QueryList<>(null);
    }


    // the 2 testList() methods do not compile because of "type erasure"
    //      this means that the base class for both String and Integer are the same -> Object
    //      because of this, the two methods are not truly overloaded 
    //      the compiler will not let you run the code
    // public static void testList(List<String> list) {
    //     for (var element : list) {
    //         System.out.println("String: " + element.toUpperCase());
    //     }
    // }

    // public static void testList(List<Integer> list) {
    //     for (var element : list) {
    //         System.out.println("Integer: " + element.floatValue());
    //     }
    // }

    public static void testList(List<?> list) {
        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String: " + s.toUpperCase());
            } else if (element instanceof Integer i){
                System.out.println("Integer: " + i.floatValue());
            }
        }
    }

}
