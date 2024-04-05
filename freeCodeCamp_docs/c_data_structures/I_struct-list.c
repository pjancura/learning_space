// list: ADT
//      collection of objects that something in common
//      List
//          - store a given number of elements of a given data-type     int A[10]
//          - write / modify element at a position                      A[i] = 2;
//          - read element at a position                                print A[i]
//          - empty list has size 0
//          - insert, remove, count, read / modify
//          - specify data-type
//          - when array is full, create a new larger array, 
//                  copy previous array into the new array and
//                  double the size of the array so it hopefully
//                  does fill and need to be copied again
//          - free the memory for the previous array

// list: implementation
//      int A[MAXSIZE];
//      int end = -1;
//      insert(int, position);
//      
// Time (cost of the operations)
//      Access - with index is constant time  or O(1)
//      Insert - at end of list O(1)
//      Insert - in the middle or beginning is proportional to the size of the list or O(n)
//      Remove - proportional the size of the list or O(n)
//      Add - if the list is full already (because of operations mentioned above)  O(n)
//
// Because of lists being dynamic - Lists are not as efficient as they could be



#include <stdio.h>
#include <stdlib.h>



int main()
{
    printf("\n");


    printf("\n");
    return 0;
}