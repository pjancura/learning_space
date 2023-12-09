#include <stdio.h>
#include <stdlib.h>

int main()
{
    int age = 30;
    double gpa = 3.4;
    char grade = 'A';

    // the line below is pointer that is storing the memory address another one of our variables in our program
    int * pAge = &age;
    double * pGpa = &gpa;
    char * pGrade = &grade;

    printf("Memory Addresses: \n");
    printf("Age: %p\n", pAge);                     // %p == pointer...this will print the physical memory address of the age variable
    printf("GPA: %p\n", pGpa);                     // the & (ampersand) is the pointer, with the & it will grab the memory address of the variable that comes after it  (if i understand this correctly)
    printf("Grade: %p\n", pGrade);

    // dereferencing a pointer will pull whatever data is stored at that address
    printf("Dereferencing Pointers: \n");
    printf("Age: %d\n", *pAge);                         // using the * (asterisk) in front of a pointer variable will grab whatever data lives at the address
    printf("GPA: %lf\n", *pGpa);                        // as a result the format specifier needs to be of the same type as the data that is stored
    printf("Grade: %c\n", *pGrade);                     // *&age == *pAge

    return 0;
}