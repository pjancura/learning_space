// this includes passing n-D arrays to functions

#include <stdio.h>
#include <stdlib.h>



int main()
{
    printf("\n");

    // 3d array
    int a[3][2][2] = {{{1, 2}, {3, 4}}, 
                      {{5, 6}, {7, 8}}, 
                      {{9, 10}, {11, 12}}};
    int (*pA)[2][2] = a;

    printf("Address of a[0][0][0] = %p\n", &a[0][0][0]);
    printf("Address of a[0][0][0] / pA = %p\n", pA);
    printf("Address of &a = %p\n", &a);

    printf("Value of a[1][1][1] = %d\n", a[1][1][1]);
    printf("Value of *(a[1][1] + 1) = %d\n", *(a[1][1] + 1));
    printf("Value of *(*(a[1] + 1) + 1) = %d\n", *(*(a[1] + 1) + 1));
    printf("Value of *(*(*(a + 1) + 1) + 1) = %d\n", *(*(*(a + 1) + 1) + 1));


    printf("\n");
    return 0;
}


// NOTICE HOW ONLY THE OUTER MOST LAYER OF THE N-D ARRAY LENGTH DOES NOT HAVE TO BE SPECIFIED
// void func(int (*arr)[3]){}    // this will point to the 1-d array inside a 2-d array
// void func(int arr[][3]){}     // this is the same as above line

// void func(int arr[][2][2]){}  // this will point to the 1-d array inside a 2-d array, inside a 3-d array
// void func(int *arr[2][2]){}

// void func(int ***arr){}       // THIS SYNTAX DOES NOT WORK ....  POINTER TO POINTER REFERENCE JUST DOESN'T WORK