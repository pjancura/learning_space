

#include <stdio.h>
#include <stdlib.h>

int main()
{
    // starting variable a = 5
    int a = 5;
    printf("Initial Value a = %d\n", a);
    printf("Address of a = %p\n", &a);
    // the value of pA is the memory address of a
    int *pA = &a;
    printf("Value of pA = %p\n", pA);
    // the value at memory address pA is 6
    // so a = 6
    *pA = 6;
    printf("Updated Value at memory address pA = %d\n", a);
    // the value of pPA is the memory address of pA
    int **pPA = &pA;
    printf("Address of pPA = %p\n", &pPA);
    printf("Value of pPA / Address of pA = %p\n", pPA);
    printf("Value of pPA, dereferenced = %p\n", *pPA);
    printf("Value of pPA, dereferenced, then dereferencing the value at address pA = %d\n", *(*pPA));  // the extra parentheses are unneccessary but it allows us to understand precedence
    // the value of pPPA is the memory address of pPA
    int ***pPPA = &pPA;
    printf("Address of pPPA = %p\n", &pPPA);
    printf("Value of pPPA / Address of pPA = %p\n", pPPA);
    printf("Value of pPPA, dereferenced * 1 = %p\n", *pPPA);
    printf("Value of pPPA, dereferenced * 2 = %p\n", **pPPA);
    printf("Value of pPPA, dereferenced * 2, then dereferencing the value at address pA = %d\n", *(**pPPA));


    return 0;
}