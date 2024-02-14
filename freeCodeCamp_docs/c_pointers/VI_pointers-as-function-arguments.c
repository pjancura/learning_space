// Pointers as function arguments or Call by reference

// an example of an application's memory allocation is divided into
// the code the script of instructions, the variables (static or global) in the code, the stack (local variables are stored here), and the heap (will be covered later)
// code, static and global variables, and the stack are fixed amounts of memory when the program starts 
// the heap can be dynamic (i assume)

#include <stdio.h>
#include <stdlib.h>

int increment(int a);
void incrementByReference(int *p);


int main()
{
    int a = 10;
    printf("Initial value of a = %d\n", a);
    printf("Address of a in main() = %p\n", &a);
    a = increment(a);
    printf("a after increment() =  %d\n", a);

    int b = 20;
    printf("Initial value of b = %d\n", b);
    printf("Address of b in main() = %p\n", &b);
    incrementByReference(&b);
    printf("After incrementByReference(), value of b = %d\n", b);

    return 0;
}


int increment(int a)
{
    a = a + 1;
    printf("Address of a in increment() = %p\n", &a);
    return a;

}

// this saves the program from copying a whole bunch of data again
// to perform the function
// this version is simply referencing the memory address of the argument to be manipulated
void incrementByReference(int *p)
{
    *p = (*p) + 1;
}