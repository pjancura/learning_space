// arrays will reserve a block of memory

// pointer arithmetic makes sense with arrays
// because we know what is stored in the neighboring memory block

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[5] = {1, 5, 10, 15, 20};
    printf("first value in a[] = %d\n", *a);
    printf("also first value in a[] = %d\n", a[0]);
    printf("address first value in a[] = %p\n", &a[0]);
    // notice how you do not need the & for an array to store the address
    int *pA = a;
    printf("Address of first element in array = %p\n", pA);

    // another example of how to extract values from an array
    for(int i = 0; i < 5; i++){
        printf("Address %d = %p\n", i, &a[i]);
        printf("Address %d = %p\n", i, a + i);
        printf("Value %d = %d\n", i, a[i]);
        printf("Value %d = %d\n", i, *(a + i));
    }



    return 0;
}