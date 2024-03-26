package java_17.nested_classes.local_classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


record Employee(String fName, String lName, int hireDate) {};

public class Challenge {
    
    public static void main(String[] args) {
        
        System.out.println("Original Employees:");
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ralph", "Smith", 2015),
            new Employee("Carole", "Burnette", 2021),
            new Employee("Jane", "Goodall", 2013),
            new Employee("Laura", "Kampf", 2020),
            new Employee("Jim", "Johnson", 2018)
        ));
        print(employees);
        creatEnhancedEmployees(employees);

    }

    private static void print(List<? extends Employee> list) {
        for (var employee : list) 
        System.out.println(employee);
    }

    private static <T> void creatEnhancedEmployees(List<Employee> list) {

        class EnhancedEmployee {
            private String fullName;
            private int yearsWorked;
            private Employee originalEmployee;
            
            public EnhancedEmployee(Employee originalEmployee) {
                this.fullName = "";
                this.yearsWorked = 0;
                this.originalEmployee = originalEmployee;
                this.fullName = this.getFullName();
                this.yearsWorked = this.getYearsWorked();
            }
            
            public String getFullName() {
                return this.originalEmployee.fName() + " " + this.originalEmployee.lName();
            }
            
            public int getYearsWorked() {
                return 2024 - this.originalEmployee.hireDate();
            }

            @Override
            public String toString() {
                return this.fullName + "\tYears Worked: " + this.yearsWorked; 
            }

        }
        System.out.println("\nEnhanced Employees:");
        List<EnhancedEmployee> enhanced = new ArrayList<>();
        for (Employee employee : list) {
            EnhancedEmployee enEmp = new EnhancedEmployee(employee);
            enhanced.add(enEmp);
            System.out.println(enEmp);
        }

        var c0 = new Comparator<EnhancedEmployee>() {
            @Override
            public int compare(EnhancedEmployee o1, EnhancedEmployee o2) {
                return Integer.valueOf(o1.yearsWorked).compareTo(Integer.valueOf(o2.yearsWorked));
            }
        };
        System.out.println("\nSorted by YearsWorked: ");
        enhanced.sort(c0);
        for (EnhancedEmployee enEmp : enhanced) {
            System.out.println(enEmp);
        }

        var c1 = new Comparator<EnhancedEmployee>() {
            @Override
            public int compare(EnhancedEmployee o1, EnhancedEmployee o2) {
                return o1.fullName.compareTo(o2.fullName);
            }
        };

        System.out.println("\nSorted by Full Name: ");
        enhanced.sort(c1);
        for (EnhancedEmployee enEmp : enhanced) {
            System.out.println(enEmp);
        }
    }
}
