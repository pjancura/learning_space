// POJO = Plain Old Java Object
//      generally only has instance fields
//      used to house and pass data between functional classes
//      usually has few, if any methods other than getters and setters
//      Many database frameworks use POJO's to read data from or write data to, databases, files or streams
//      can also be called a "bean" or "JavaBean"
//      sometimes called an "entity" (like in databases)
//      or DTO = "Data Transfer Object"


// record -> replaces boilerplate of the POJO, but more restrictive
//      seeks to achieve immutability 
//      only contains constructors and accessors
//      i as the developer, don't have to generate any of this code


package java_17.oop_intro;

public class PojoAndRecords {
    public static void main(String[] args) {
        
        for (int i = 1; i <= 5; i++) {
            Student s = new Student("S92300" + i,
                switch (i) {
                    case 1 -> "Mary";
                    case 2 -> "Carol";
                    case 3 -> "Tim";
                    case 4 -> "Harry";
                    case 5 -> "Lisa";
                    default -> "Anonymous";
                },
                "1985-11-05",
                "Java Masterclass");
            // this will implicitely call the toString() if there is one defined for the object
            System.out.println(s);
        }
        
        // using the record form of Student
        for (int i = 1; i <= 5; i++) {
            StudentRecord s = new StudentRecord("S92300" + i,
                switch (i) {
                    case 1 -> "Mary";
                    case 2 -> "Carol";
                    case 3 -> "Tim";
                    case 4 -> "Harry";
                    case 5 -> "Lisa";
                    default -> "Anonymous";
                },
                "1985-11-05",
                "Java Masterclass");
            // this will implicitely call the toString() if there is one defined for the object
            System.out.println(s);
        }
        Student pojoStudent = new Student("S923006", "PojoAnn", "1990-08-03", "Java Masterclass");
        StudentRecord recordStudent = new StudentRecord("S923006", "RecordAnn", "1990-08-03", "Java Masterclass");
        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());
    }


}
