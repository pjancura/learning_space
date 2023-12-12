// Allocates block of memory
// malloc() : void* malloc(size_type size)
//          size_t = stores only integers of x >= 0, this is the number 
//          size = number of bytes
//          malloc == memory allocation
//          void* means that it just points to the block of memory there is no data there yet
//          example:
//              void *p = malloc(4);
//              print(p) => some address
//          another:
//              void *p = malloc(sizeof(int));
//              void *p = malloc(10*(sizeof(int)));   => allocates 10 blocks of the memory the size of an integer block
//          the void *p needs to be type casted into the correct type before it can be used
//          in a block of memory think about how we have discussed assigning values in an array

// calloc()
//          calloc takes 2 arguments size_type num, size_type size
//          size_type num => number of elements of a particular data type
//          size_type size => size of the data type
//          example:
//              int *p = calloc(3, sizeof(int));
//          calloc() will set all values (in this case 0) in the memory block to a value unlike malloc, which does not

// realloc()
//          void* realloc(void *ptr, size_type size)
//              void *ptr => pointer to the starting address of the current block
//              size_type size => size of the new block
//          a few possibilities, if the block has room to grow, it may just expand there
//              if not, then the whole of what was currently in the block will be copied to a new block
//              

// deallocates block of memory
// free()

#include <stdio.h>
#include <stdlib.h>



int main()
{
    printf("\n");

    // use case 1
    // dynamically allocated array

    int n;
    printf("Enter size of array \n");
    scanf("%d", &n);
    // int arr[n];   this will give you a compilation error because an array's size must be known at the time of compilation
    // what to do instead
    int *pArr = (int*)malloc(n*sizeof(int));
    // if we wanted to use calloc() instead
    // int *pArr = (int*)calloc(n, sizeof(int));
    printf("First address of pArr: %p\n", pArr);
    for (int i = 0; i < n; i++)
    {
        pArr[i] = i + 1;
    }
    // at the time of compilation when i ran free() it turned all of the values in pArr[] to 0
    // free(pArr);
    // i could try to assign a value at pArr[3], but this could cause the program to crash on some systems
    // because free() could wipe the memory allocation entirely and then pArr would no longer exist

    printf("This is the generated array: \n");
    for (int i = 0; i < n; i++)
    {
        if (i < n - 1){
            printf("%d, ", pArr[i]);
        } else {
            printf("%d", pArr[i]);
        }
    }
    printf("\n");

    int *pN = &n;
    *pN = 2*n;
    int *pBrr = (int*)realloc(pArr, n * sizeof(int));
    // int *pBrr = (int*)realloc(pArr, 0);                  // this is equivalent to using free(pArr);
    // int *pArr = (int*)realloc(NULL, n * sizeof(int));    // this is equivalent to malloc(); and will create a brand new block of memory not copying anything from the previous pArr
    printf("Address of pBrr after realloc: %p\n", pBrr);
    printf("n = %d\n", n);
    for (int i = 0; i < n; i++)
    {
        pBrr[i] = i + 1;
    }
    printf("This is the generated array after realloc(): \n");
    for (int i = 0; i < n; i++)
    {
        if (i < n - 1){
            printf("%d, ", pBrr[i]);
        } else {
            printf("%d", pBrr[i]);
        }
    }

    printf("\n");
    return 0;
}