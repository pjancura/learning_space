#include <stdio.h>
#include <stdlib.h>

int main()
{
    int age = 30;
    double gpa = 3.4;
    char grade = 'A';

    printf("Age: %p\n", &age);                     // %p == pointer...this will print the physical memory address of the age variable
    printf("GPA: %p\n", &gpa);
    printf("Grade: %p\n", &grade);

    return 0;
}