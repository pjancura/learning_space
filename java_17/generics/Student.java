package java_17.generics;

import java.util.Random;

public class Student implements QueryItem {
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    private static String[] firstName = {"Ann", "Bill", "Cathy", "John", "Time"};
    private static String[] courses = {"C++", "Java", "Python"};

    public Student() {
        int leastNameIndex = random.nextInt(65, 91);
        name = firstName[random.nextInt(5)] + " " + (char) leastNameIndex;
        course = courses[random.nextInt(3)];
        yearStarted = random.nextInt(2024, 2029);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    public int getYearStarted() {
        return this.yearStarted;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch(fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }
}
