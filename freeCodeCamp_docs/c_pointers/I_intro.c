// different types of data take up diffrent amounts of bytes
// pointers - variables that store address of another variable
// a pointer variable can be modified to point to a different spot in memory
// int a;   (this will store an integer)
// int * pA = &a; (this will reference the memory address of a)
// if i understand correctly
// * asks for the value
// & asks for the pointer / memory address


// I guess think of every variable as being an object
// the * asks for the value
// the & asks for the memory address



#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n = 5;
    int *pN = &n;

    printf("Value of n: %d\n", n);
    printf("Value of pN or memory address of n: %p\n", pN);
    printf("Example of dereferencing pN: %d\n", *pN);



    return 0;
}