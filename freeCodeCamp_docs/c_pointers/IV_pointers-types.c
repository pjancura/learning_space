// the reason why pointers are strongly typed and the type of the pointer must match the type of the value stored there
// is because a pointer variable can also be used to dereference the pointer
// thus returning the value of the same type as the pointer variable
// also the type of pointer tells the compiler how many bytes to look at the pull the value


#include <stdio.h>
#include <stdlib.h>

int main()
{

    int a = 1025;
    int *pA = &a;

    printf("size of integer memory is %lu bytes\n", sizeof(int));
    printf("Address = %p, value = %d\n", pA, *pA);
    printf("Address = %p, value = %d\n", pA + 1, *(pA + 1));

    char *pC;
    pC = (char*)pA;
    printf("size of char memory is %lu bytes\n", sizeof(char));
    // the value below is 1, because it is looking at the first byte of a and that is == 1
    printf("Address = %p, value = %d\n", pC, *pC);
    // the value below is 4, because the byte that it is looking at now is == 4
    printf("Address = %p, value = %d\n", pC + 1, *(pC + 1));


    // void pointer - generic pointer
    void *pV = pA;
    printf("Address pV = %p\n", pV);
    printf("Address pV + 1 = %p\n", pV + 1);
    // there is no value and gives compilation error
    // printf("Value at pV: %d\n", *pV);


    return 0;
}