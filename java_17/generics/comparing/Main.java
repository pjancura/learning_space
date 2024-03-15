package java_17.generics.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (val ==  0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        // this compareTo() will compare the unicode value
        for (String str : fruit) {
            int val = banana.compareTo(str);
            System.out.printf("%s %s %s: compareTo=%d%n", banana, (val == 0 ? "==" : (val < 0) ? "<" : ">"), str, val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        Student[] students = {
            new Student("Anna"),
            new Student("Bob"),
            new Student("Theresa"),
            new Student("Paul")
        };

        Student george = new Student("George");

        for (Student stud : students) {
            int val = george.compareTo(stud);
            System.out.printf("%s %s %s: compareTo=%d%n", george, (val == 0 ? "==" : (val < 0) ? "<" : ">"), stud.toString(), val);
        }

        System.out.println("result= " + george.compareTo(new Student("George")));

        Comparator<Student> gpaSorter = new StudentGPAComparator();

        // this overloaded method allows you to specify what to use to sort the array object
        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {
    private static int LAST_ID = 1000;
    private static Random random = new Random();


    String name;
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        this.id = LAST_ID++;
        this.gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(this.id, this.name, this.gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(this.id).compareTo(Integer.valueOf(o.id));
    }
}