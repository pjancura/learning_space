package java_17.nested_classes.anonymous_classes;

// anonymous classes were used more prior to JDK 8 and the introduction of the lambda expression
//      but you will see them in old code and sometimes they have their uses

import java.util.ArrayList;
import java.util.List;

import java_17.nested_classes.static_nested.Employee;
import java_17.nested_classes.inner_classes.StoreEmployee;
import java_17.nested_classes.inner_classes.StoreEmployee.StoreComparator;

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
        System.out.println("\nPigLatin Names:");
        addPigLatinName(storeEmployees);


    }

    public static void addPigLatinName(List<? extends StoreEmployee> list) {
        // lastName is an example of an "effectively final" variable
        //      meaning that because it is used in the local class
        //      I can't change the value of lastName after the class declaration
        String lastName = "Piggy";

        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee> {
            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " \t" + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return this.pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());
        for (var employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);

        for (DecoratedEmployee dEmp : newList) {
            System.out.println(dEmp);
        }


    }
}
