package java_17.nested_classes;

import java.util.ArrayList;
import java.util.List;

// static nested class  -> declared in class body. much like a static field, access to this class is through the class name identifier
// instance or inner class -> declared in class body. this type of class can only be accessed through an instance of the outer class.
// local class -> declared within a method body.
// anonymous class -> unnamed class, declared and instantiated in same statement.

public class Main {
    
    public static void main(String[] args) {
        
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee(100001, "Ralph", 2015),
            new Employee(100100, "Carole", 2021),
            new Employee(100220, "Jane", 2013),
            new Employee(102341, "Laura", 2020),
            new Employee(100005, "Jim", 2018)
        ));

        // var comparator = new EmployeeComparator<>();
        // employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for (Employee e : employees) {
            System.out.println(e);
        }        

    }
}
