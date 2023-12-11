// how is memory assigned to an array when it is passed as an argument
// only the address of the first element of the array is passed to the called function's stack frame
// this way the whole array isn't needing to be copied to the new stack from 

// this is also a call by reference

#include <stdio.h>
#include <stdlib.h>

int sumOfElements(int arr[], int size);
void doubleElements(int *arr, int size);


int main()
{
    int a[5] = {1, 2, 3, 4, 5};
    // the below line will give me the length of the array
    // taking the byte size of the entire array and dividing it by the byte size of an array element
    int size = sizeof(a) / sizeof(a[0]);    
    int total = sumOfElements(a, size);
    printf("sumOfElements() result = %d\n", total);
    doubleElements(a, size);
    for (int i = 0; i < size; i++){
        printf("%d ", a[i]);
    }
    printf("\n");
    
    return 0;
}

int sumOfElements(int arr[], int size)
{
    int i, sum = 0;
    for (i = 0; i < size; i++){
        sum += arr[i];
    }
    return sum;
}

// this means the same as function above, because the arr will only be passed as a pointer reference instead of a copy
// so the size needs to be calculated local to the array and passed into the function
int sumOfElements2(int *arr, int size){
    int i, sum = 0;
    for (i = 0; i < size; i++){
        sum += arr[i];
    }
    return sum;
}

void doubleElements(int *arr, int size){
    for (int i = 0; i < size; i++){
        printf("Value %d = %d\n", i, arr[i]);
        printf("Address %d = %p\n", i, &arr[i]);
        *(arr + i) = 2 * arr[i];
    }
}