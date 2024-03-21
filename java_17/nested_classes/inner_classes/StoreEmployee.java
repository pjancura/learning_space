package java_17.nested_classes.inner_classes;

import java.util.Comparator;

import java_17.abstraction.Store;
import java_17.nested_classes.static_nested.*;

public class StoreEmployee extends Employee {
    
    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee> {

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result = o1.store.compareTo(o2.store);
            if (result == 0) {
                return new Employee.EmployeeComparator<>("yearStarted").compare(o1, o2);
            }
            return result;
        }
    }

    @Override
    public String toString() {
        return "%-8s %s".formatted(super.toString(), this.store);
    }
}
