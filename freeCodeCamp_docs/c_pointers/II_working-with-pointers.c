

#include <stdio.h>
#include <stdlib.h>

int main()
{

    int a = 6;
    int *pA = &a;

    printf("%p\n", pA);
    printf("%d\n", a);

    int b = 20;
    // *pA will now equal the value of b and changing a's value
    // this does not point the memory address of b
    *pA = b;                
    printf("Shows that the address of a is unchanged from the start: %p\n", pA);
    printf("Shows that the value of *pA is now b: %d\n", *pA);
    printf("the value of a has been changed but not the address: %d\n", a);
    printf("Memory address of b: %p\n", &b);


    return 0;
}