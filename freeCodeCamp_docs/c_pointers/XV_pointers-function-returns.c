// it is possible for a function to return a pointer

#include <stdio.h>
#include <stdlib.h>

// add() => called function
int add(int a, int b);
int addByReference(int *a, int *b);
int *addReturnsPointer(int *a, int *b);

// main() => calling function 
int main()  
{
    printf("\n");

    int x = 2, y = 4;
    // remember that value of x is being copied to value of argument a
    // and value y is being copied to value of argument b
    int z = add(x, y);

    printf("sum() = %d\n", z);

    int a = 4, b = 5;
    printf("address of a in main() = %p\n", &a);
    int c = addByReference(&a, &b);
    printf("addByReference() = %d\n", c);

    int n = 3, m = 2;
    printf("address of c in main() = %p\n", &a);
    int *e = addReturnsPointer(&n, &m);
    printf("addReturnsPointer() = %d\n", *e);


    printf("\n");
    return 0;
}

int add(int a, int b)
{
    int c = a+b;
    return c;
}

// these are pointer arguments
int addByReference(int *a, int *b)
{
    printf("Address of a in addByReference() = %p\n", a);
    int c = (*a) + (*b);
    return c;
}

// return by pointer
int *addReturnsPointer(int *a, int *b)
{
    printf("Address of c from main() in addByReference() = %p\n", a);
    // this stores the answer to *a + *b to the heap instead of the stack
    // this guarantees that when i print the result of addReturnsPointer()
    // the printf() will get the correct data
    // because another function on the call stack could overwrite this local variable / address
    int *c = (int*)malloc(sizeof(int));
    *c = (*a) + (*b);
    return c;
}

void printHelloWorld(){
    printf("Hello World\n");
}