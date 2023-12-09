// variables - a container to store data
// they centralize data and make updates to the program easier and faster

#include <stdio.h>
#include <stdlib.h>

int main()
{
    char characterName[] = "Tom";                      // char is the character data type, the [] tells the program it is going to be multiple characters;
    int characterAge = 67;                              // int is the integer data type

    printf("There once was a man named %s\n", characterName);   // %s tells the compiler that a string goes there,  ", variableName"  will be substituted for the %s when the function is executed
    printf("He was %d years old.\n", characterAge);                           // %d works with int data type
    
    characterAge = 30;                                          // this is an example of updating the value being stored in a variable
    printf("He really liked the name %s,\n", characterName);
    printf("but he did not like being %d.\n", characterAge);


    return 0;
}