package java_17.nested_classes;

import java.util.Comparator;

public class EmployeeComparator <T extends Employee> implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.valueOf(o1.getYearStarted()).compareTo(Integer.valueOf(o2.getYearStarted()));
        // return o1.getName().compareTo(o2.getName());
    }
}
