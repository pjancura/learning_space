// structs allow you to store different data types in a single entity

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Student{
    char name[64];
    char major[64];
    int age;
    double gpa;
};


int main()
{
    struct Student student1;                        // student1 is of type Student
    student1.age = 22;
    student1.gpa = 3.4;
    strcpy( student1.name, "John George");          // strcpy() stands for string copy, I assume this means it will combine the array of characters into a single string
    strcpy( student1.major, "Engineer");

    printf("%lf\n", student1.gpa);
    printf("%s\n", student1.name);

    struct Student student2;                        // student1 is of type Student
    student2.age = 22;
    student2.gpa = 3.8;
    strcpy( student2.name, "Georgetta Hans");          // strcpy() stands for string copy, I assume this means it will combine the array of characters into a single string
    strcpy( student2.major, "Industrial Design");

    printf("%lf\n", student2.gpa);
    printf("%s\n", student2.name);

    return 0;
}