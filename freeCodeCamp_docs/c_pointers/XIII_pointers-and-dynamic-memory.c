// when our function calls exceed the memory space allocated for the stack portion of our program
// this causes a stack overflow and our program will fail

// applications heap is not fixed and can vary during the lifetime of the program
// heap can grow unless it outgrows the memory of the whole system (computer)
// using the heap is known as dynamic memory allocation

// to use dynamic memory in C you need to know
// malloc   calloc  realloc     free

// if malloc() is unable to find space in the heap it will return NULL
// keep this in mind for error handling of your programs

#include <stdio.h>
#include <stdlib.h>

int square(int x);
int squareOfSum(int x, int y);

int main()
{
    printf("\n");

    int a = 4;    // goes on the stack
    int b = 4;
    int *p;
    p = (int*)malloc(sizeof(int));          // this will reserve 4 bytes of data in the heap
    *p = 10;                                // only way to access this data is through the pointer
                                            // otherwise your program will not know how to access the value stored in the heap
    
    free(p);                                // this will free up the previous allocation of p in the heap

    p = (int*)malloc(sizeof(int));          // this will reserve a new block of 5 bytes in the heap
    *p = 20;                                // this is the new value for that block of memory
                                            // however, the previous allocation in the heap for 10 still exists  (unless free() is called)
                                            // so we need to remember to remove it
                                            // otherwise it will be there wasting space

    free(p);

    printf("square() = %d\n", square(a));
    printf("squareOfSum() = %d\n", squareOfSum(a, b));


    printf("\n");
    return 0;
}

int square(int x)
{
    return x*x;
};


int squareOfSum(int x, int y)
{
    return square(x + y);
};