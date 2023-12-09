#include <stdio.h>
#include <stdlib.h>

int main()
{
    // char grade;
    // printf("Enter your grade: ");
    // scanf("%c", &grade);                               
    // printf("Your grade is %c.\n", grade);
    
    // int age;
    // printf("Enter your age: ");
    // scanf("%d", &age);                                // this allows the user to input information,   the &  is a pointer (more on that later)
    // printf("You are %d years old.\n", age);

    // double gpa;
    // printf("Enter your gpa: ");
    // scanf("%lf", &gpa);                               
    // printf("Your gpa is %lf.\n", gpa);


    // char name[20];                                 // the 128 means that the name can be 128 characters long, this reserves the space in memory
    // printf("Your name is: ");
    // scanf("%s", name);                             // scanf()    will not recognize " " (spaces) in a string so "Paul Jancura" will only return "Paul"   
    // printf("Your name is %s.\n", name);    

    char nameAgain[20];
    printf("Enter your name: ");
    fgets(nameAgain, 64, stdin);                    // can grab a line of text from the user, can only store a string a of characters, can't store the input inside a variable (read more on this)
                                                    // fgets(variableName, integer* how many chars, how is it going to get the info (stdin refers to the console)), will also store "\n" at the end of the input string
    printf("Your name is %s.\n", nameAgain);

    return 0;
}