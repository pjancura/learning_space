package java_17.generics.generic_end;

import java.util.Comparator;
import java.util.List;




public class Main {
    
    public static void main(String[] args) {

        int studentCount = 25;
        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < studentCount; i++) {
            queryList.add(new LPAStudent());
        }

        printMoreList(queryList);

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printMoreList(queryList);

        System.out.println("Matches");
        QueryList<LPAStudent> matches = queryList.getMatches("percentComplete", "50").getMatches("course", "Python");

        printMoreList(matches);

        matches.sort(new LPAStudentComparator());
        printMoreList(matches);

        System.out.println("Ordered");
        // i assume a null comparator will order the items as what would be returned by the defined compareTo() method
        matches.sort(null);
        printMoreList(matches);




        // List<Student> students = new ArrayList<>();
        // for (int i = 0; i < studentCount; i++) {
        //     students.add(new Student());
        // }
        // printMoreList(students);

        // List<LPAStudent> lpaStudents = new ArrayList<>();
        // for (int i = 0; i < studentCount; i++) {
        //     lpaStudents.add(new LPAStudent());
        // }
        // // System.out.println(lpaStudents.get(0).getClass().getSuperclass().getSimpleName());

        // printMoreList(lpaStudents);

        // students.get(0).orderOnField("yearStarted", students);
        // printMoreList(students);

        // students.get(0).orderOnField("name", students);
        // printMoreList(students);

        // students.get(0).orderOnField("course", students);
        // printMoreList(students);

        // students.get(0).orderOnField("id", students);
        // printMoreList(students);

        // List<LPAStudent> lessThan50P = new ArrayList<>();
        // for (LPAStudent lpaStudent : lpaStudents) {
        //     if(lpaStudent.matchFieldValue("percentComplete", "50")) {
        //         System.out.println(lpaStudent);
        //         lessThan50P.add(lpaStudent);
        //     }
        // }


        

    }

    public static void printMoreList(List<? extends Student> students) {
        for(var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }
}
