// we can have a pointer that points the address of a function

// what is the address of a function?
//      it is the place in RAM where the first line of the function is stored
//      remember one of the segments of an applications memory is reserved just for the text


#include <stdio.h>
#include <stdlib.h>

int add(int a, int b);
void printHello(char *name);

int main()
{
    printf("\n");

    //pointer to function should take
    // (int, int) as argument/parameter and return int
    // notice how the structure of this pointer is reminiscent 
    // of a pointer for a n-d array
    // 
    int (*p)(int, int);
    // the following line says that we are declaring a pointer to the return of a function
    // int *p(int, int);

    // this fills in the address of add() in p
    p = &add;
    // the following line is de-referencing and executing the function
    int c = p(2, 3);
    // this line is the same as above
    // int c = (*p)(2, 3);
    printf("value of add() = %d\n", c);

    // PRACTICE with other functions
    void (*f)(char*) = &printHello;
    f("Name");

    printf("\n");
    return 0;
}

int add(int a, int b)
{
    return a + b;
}

void printHello(char *name)
{
    printf("Hello %s!\n", name);
}