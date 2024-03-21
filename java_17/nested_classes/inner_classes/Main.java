package java_17.nested_classes.inner_classes;

import java.util.ArrayList;
import java.util.List;

import java_17.nested_classes.static_nested.Employee;
import java_17.nested_classes.inner_classes.challenge.burger.*;

public class Main {
    
    public static void main(String[] args) {


        List<Employee> employees = new ArrayList<>(List.of(
            new Employee(100001, "Ralph", 2015),
            new Employee(100100, "Carole", 2021),
            new Employee(100220, "Jane", 2013),
            new Employee(102341, "Laura", 2020),
            new Employee(100005, "Jim", 2018)
        ));

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());
        for (Employee e : employees) {
            System.out.println(e);
        }  
        
        System.out.println("\nStore Members:");
        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
            new StoreEmployee(10015, "Meg", 2019, "Target"),
            new StoreEmployee(10515, "Joe", 2021, "Walmart"),
            new StoreEmployee(10105, "Tom", 2020, "Macy's"),
            new StoreEmployee(10215, "Marty", 2018, "Walmart"),
            new StoreEmployee(10322, "Bud", 2016, "Target")
        ));

        // var genericEmployee = new StoreEmployee();
        // var comparator = genericEmployee.new StoreComparator<>();

        // to create an instance of an inner class, you need to instantiate an instance of the outer class
        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);
        for(StoreEmployee sE : storeEmployees) {
            System.out.println(sE);
        }


    }
}
