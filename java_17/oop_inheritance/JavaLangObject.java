package java_17.oop_inheritance;

// every class intrinsically extends java.lang.Object
// the hashcode is a pointer reference to an object


public class JavaLangObject extends java.lang.Object {
    
    
    public static void main(String[] args) {
        Student max = new Student( "Max", 21);
        System.out.println(max);

        PrimarySchoolStudent jimmy = new PrimarySchoolStudent("Jimmy", 5, "Carole");
        System.out.println(jimmy);
    }
}

class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // @Override
    // public String toString() {
    //     return super.toString();
    // }

    @Override
    public String toString() {
        return this.name + " is " + age;
    }

    
}

class PrimarySchoolStudent extends Student {

    private String parentName;

    public PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return parentName + "'s kid, " + super.toString();
    }
}
