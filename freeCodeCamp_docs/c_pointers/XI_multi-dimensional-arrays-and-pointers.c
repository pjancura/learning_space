// the type of a pointer matters when you dereference the memory address

// the variable name for an array is just the pointer value
// int a[4] = ????;
// int *pA = a;
// thus int *pA is literally the same as a

// int b[2][3] = {{1, 2, 3}, {4, 5, 6}};
// int *pB[3] = b;                          // will return a pointer to 1d array of 3 integers
// print b or &b[0] will return the first memory address for b
// print **b or *b[0] or b[0][0] will all return the value at the first memory address

////////////////////////////////////////////////////////////
// IMPORTANT //
// will return values
// b[i][j] == *(b[i] + j) || *(*(b + i) + j)
////////////////////////////////////////////////////////////

#include <stdio.h>
#include <stdlib.h>

// READ BELOW
void print2DArray(int (*arr)[3], int size1, int size2);

int main()
{
    printf("\n");

    int b[2][3] = {{1, 2, 3}, {4, 5, 6}};

    printf("%p\n", b + 1); // prints address of b + 1 or b[1][0]
    printf("%p\n", *(b + 1));
    printf("%p\n", &b[1]);
    printf("%p\n", &b[1][0]);
    printf("%p\n", b); // prints address of b[0][0]
    printf("%p\n", &b[0][0]);
    printf("%d\n", **(b + 1)); // prints the value at b + 1 or b[1][0]
    printf("%d\n", *b[1]);
    printf("value at b[0][0] = %d\n", **b);

    int (*pB)[3] = b;                 // the 3 needs to match because it needs to match the type of array that it will dereference
    printf("Address: %p\n", pB);
    printf("Address: %p\n", b);
    printf("Value: %d\n", *pB[0]);
    printf("Address: %p\n", pB[1]);
    printf("Value: %d\n", *pB[1]);
    // even though *pB[2] will create a garbage / irrelevant value at this address
    // because it is referencing the start of each array in b[2][3] 
    // thus adding the length of memory needed to store the 3 integer array in side the 2 array array
    printf("Address: %p\n", pB[2]);
    printf("Value: %d\n", *pB[2]);


    // READ BELOW
    int size1 = sizeof(b) / sizeof(b[0]);
    int size2 = sizeof(b[0]) / sizeof(b[0][0]);
    printf("size1 = %d, size2 = %d\n", size1, size2);
    // pB[0] has the memory address of b[0][0] which is needed to start the function
    print2DArray(pB, size1, size2);


    printf("\n");
    return 0;
}

//  look at (*arr)[3]....precedence matters
// *arr[3] is not the same and resulted in me not being able to pass the pointer correctly
void print2DArray(int (*arr)[3], int size1, int size2)
{
    for (int i = 0; i < size1; i++)
    {
        printf("%d\n", *(*(arr) + i));
        for (int j = 0; j < size2; j++)
        {
            printf("Address at [%d][%d] = %p\n", i, j, &arr[i][j]);
            printf("Value at [%d][%d] = %d\n", i, j, *(*(arr + i) + j));
        }
        printf("\n");
    }
    printf("\n");

}