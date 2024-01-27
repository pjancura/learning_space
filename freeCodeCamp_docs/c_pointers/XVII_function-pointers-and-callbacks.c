// function pointers can be passed as arguments to functions

#include <stdio.h>
#include <stdlib.h>

void a();
void b(void (*ptr)());
int compare(int n, int m);
int compare2(const void *a, const void *b);
void bubbleSort(int *arr, int n, int (*compare)(int, int));
void bubbleSortDesc(int *arr, int n);

int main()
{
    printf("\n");

    void (*p)() = a;
    // the next 3 statements yield the same result
    b(a);
    b(&a);
    b(*p);
    b(p);


    int a[] = {3, 2, 1, 5, 6, 4};
    printf("\na[] before bubbleSort: \n");
        for (int i = 0; i < 6; i++)
    {
        printf("%d ", a[i]);
    }
    bubbleSort(a, 6, compare);
    printf("\na[] after bubbleSort: \n");
    for (int i = 0; i < 6; i++)
    {
        printf("%d ", a[i]);
    }
    bubbleSortDesc(a, 6);
    printf("\na[] after bubbleSortDesc: \n");
    for (int i = 0; i < 6; i++)
    {
        printf("%d ", a[i]);
    }
    int arr[] = {-1, 54, 23, -16, 90, 5};
    // qsort() stands for quicksort
    qsort(arr, 6, sizeof(int), compare2);
    printf("\narr[] after qsort: \n");
    for (int i = 0; i < 6; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
    

    printf("\n");
    return 0;
}

void a()
{
    printf("Hello\n");
}

void b(void (*ptr)())    // this is a function pointer as argument
{
    ptr();               // ptr() calls-back the function that "ptr" points to 
}


int compare(int n, int m)
{
    if (n > m) {
        return 1;
    } else {
        return -1;
    }
}

int compare2(const void *a, const void *b)
{
    int A = *((int*)a);         // typecasting from void* to int* and getting value
    int B = *((int*)b);
    return A - B;               // returning positive value means A > B, returning negative value means B > A;
}


// this is bubbleSort with a callback function to deterine whether to sort in ascending or descending order
// returns 1 if first element has higher rank, 0 if elements are equal and -1 if second element has higher rank
void bubbleSort(int *arr, int n, int (*compare)(int, int))
{
    int i, j, temp;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < n-1; j++)
        {
            // if(arr[j] > arr[j + 1])  // old logic
            if(compare(arr[j], arr[j + 1]) > 0)
            {
                // compare arr[j] and arr[j + 1] and swap if needed
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void bubbleSortDesc(int *arr, int n)
{
    int i, j, temp;
    for(i = 0; i < n; i++)
    {
        for(j = 0; j < n-1; j++)
        {
            if(arr[j] < arr[j + 1])
            {
                // compare arr[j] and arr[j + 1] and swap if needed
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}