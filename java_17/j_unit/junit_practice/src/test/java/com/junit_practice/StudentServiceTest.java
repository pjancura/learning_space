package com.junit_practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class StudentServiceTest {

    @Test
    void testGetStudents() {

        StudentService studentService = new StudentService();

        // Student student = new Student(1, "Paul");

        List<Student> listOfStudents = studentService.getStudents();
        // studentService.addStudent(student);

        boolean actualResult = listOfStudents.isEmpty();

        // assertTrue(actualResult);

        // assertTrue(() -> actualResult);

        // this message should
        // describe what the test is looking
        // for, in this case the test is looking for an empty
        // list
        // assertTrue(actualResult, "List of students is empty");

        // assertTrue(() -> actualResult, "List of students is empty!");

        // the lambda function only runs if the boolean condition returns false
        // assertTrue(actualResult, () -> "List of students is empty!");

        assertTrue(() -> actualResult, () -> "List of students is empty!");
    }

    @Test
    public void getStudentsTestUsingAssertFalse() {

        StudentService studentService = new StudentService();

        // Student student = new Student(1, "Paul");
        List<Student> studentList = studentService.getStudents();
        // studentService.addStudent(student);

        boolean actualResult = studentList.isEmpty();

        assertFalse(actualResult, "List of students should not be empty!");
    }

    @Test
    public void getStudentByIdTest() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Paul");
        studentService.addStudent(student);

        Student actualResult = studentService.getStudentById(2);

        assertNull(actualResult, "Student with id of 2 equals null!");
    }

    @Test
    public void getStudentByIdTestUsingAssertNotNull() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Paul");
        studentService.addStudent(student);

        Student actualResult = studentService.getStudentById(1);

        assertNotNull(actualResult, "Student should not be null!");

    }

    @Test
    public void getStudentByIdTestUsingAssertEquals() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Paul");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

        assertEquals(1, actualObject.getId(), "Id of student is not equal");
        assertEquals("Paul", actualObject.getName(), "Name of student is not equal");
    }

    @Test
    public void getStudentByIdTestUsingAssertNotEquals() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Paul");
        studentService.addStudent(student);

        Student actualObject = studentService.getStudentById(1);

        assertNotEquals(2, actualObject.getId(), "Id of student is equal");
        assertNotEquals("James", actualObject.getName(), "Name of student is equal");
    }

    @Test
    public void getStudentByNameTestUsingAssertThrows() {
        StudentService studentService = new StudentService();

        Student student = new Student(1, "Paul");
        studentService.addStudent(student);

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("James");
        });

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("James");
        }, "StudentNotFoundException should be thrown, but it wasn't!");

        assertThrows(StudentNotFoundException.class, () -> {
            studentService.getStudentByName("James");
        }, () -> "StudentNotFoundException should be thrown, but it wasn't!");

        // the following test works because of inheritance of the RuntimeException class
        assertThrows(RuntimeException.class, () -> {
            studentService.getStudentByName("James");
        }, "StudentNotFoundException should be thrown, but it wasn't!");

    }
}
