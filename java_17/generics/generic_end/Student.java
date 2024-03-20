package java_17.generics.generic_end;


import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {
    private String name;
    private String course;
    private int yearStarted;
    private String id;

    protected static Random random = new Random();

    private static String[] firstName = {"Ann", "Bill", "Cathy", "John", "Time"};
    private static String[] courses = {"C++", "Java", "Python"};
    private static int ID_START = 1;

    public Student() {
        int leastNameIndex = random.nextInt(65, 91);
        this.name = firstName[random.nextInt(5)] + " " + (char) leastNameIndex;
        this.course = courses[random.nextInt(3)];
        this.yearStarted = random.nextInt(2024, 2029);
        this.id = "000000".substring(String.valueOf(ID_START).length()) + String.valueOf(ID_START++);
    }

    @Override
    public String toString() {
        return "%s %-15s %-15s %d".formatted(this.id, this.name, this.course, this.yearStarted);
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

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(this.id).compareTo(Integer.valueOf(o.id));
    }

    // this code was a really complicated way to implement a sort functionality based on the different fields of the Student object
    // public List<Student> orderOnField(String fieldName, List<Student> students) {
    //     boolean swapped = false;
    //     for (int i = 0; i < students.size() - 1; i++) {
    //         swapped = false;
    //         // System.out.println("_________________________________________________");
    //         for (int j = 0; j < students.size() - 1 - i; j++) {
    //             try {
    //                 Student student1 = (Student) students.get(j);
    //                 // System.out.println(student1.getClass().getDeclaredField(fieldName).getType().getName() instanceof String);
    //                 if (student1.getClass().getDeclaredField(fieldName).getType().getName() == "int") {
    //                     if (student1.intCompare(fieldName, j, students)) {
    //                         swapped = true;
    //                     };
    //                 } else if (student1.getClass().getDeclaredField(fieldName).getType().getName() instanceof String) {
    //                     if (student1.stringCompare(fieldName, j, students)) {
    //                         swapped = true;
    //                     };
    //                 }
    //             } catch (NoSuchFieldException err) {
    //                 System.out.println(err);
    //             }
    //         }
    //         if (swapped == false) {
    //             break;
    //         }
    //     }
    //     return students;
    // }

    // public boolean intCompare(String fieldName, Integer index, List<Student> students) {
    //     // System.out.println("index: " + index);
    //     int compareValue = 0;
    //     boolean swapped = false;
    //     Student student1 = students.get(index);
    //     Student student2 = students.get(index + 1);
    //     switch (fieldName.toUpperCase()) {
    //         case "YEARSTARTED" -> {
    //             compareValue = Integer.valueOf(student1.yearStarted).compareTo(Integer.valueOf(student2.yearStarted));
    //             System.out.println(compareValue);
    //             if (compareValue > 0) {
    //                 Student temp = student2;
    //                 students.set(index + 1, student1);
    //                 students.set(index, temp);
    //                 swapped = true;
    //                 // System.out.println("student1: " + student1);
    //                 // System.out.println("student2: " + student2);
    //                 // System.out.println("Swapped: " + swapped);
    //             }
    //         }
    //         default -> System.out.println("Field Name doesn't exist");
    //     };
    //     return swapped;
    // }

    // public boolean stringCompare(String fieldName, Integer index, List<Student> students) {
    //     int compareValue = 0;
    //     boolean swapped = false;
    //     Student student1 = students.get(index);
    //     Student student2 = students.get(index + 1);
    //     switch (fieldName.toUpperCase()) {
    //         case "NAME" -> {
    //             compareValue = (student1.name).compareTo(student2.name);
    //             // System.out.println(compareValue);
    //             if (compareValue > 0) {
    //                 // System.out.println("swapping");
    //                 Student temp = student2;
    //                 students.set(index + 1, student1);
    //                 students.set(index, temp);
    //                 swapped = true;
    //             }
    //         }
    //         case "COURSE" -> {
    //             compareValue = student1.course.compareTo(student2.course);
    //             if (compareValue > 0) {
    //                 Student temp = student2;
    //                 students.set(index + 1, student1);
    //                 students.set(index, temp);
    //                 swapped = true;
    //             }
    //         }
    //         case "ID" -> {
    //             compareValue = Integer.valueOf(student1.id).compareTo(Integer.valueOf(student2.id));
    //             if (compareValue > 0) {
    //                 Student temp = student2;
    //                 students.set(index + 1, student1);
    //                 students.set(index, temp);
    //                 swapped = true;
    //             }
    //         }
    //         default -> System.out.println("Field Name doesn't exist");
    //     };
    //     return swapped;
    // }



}
