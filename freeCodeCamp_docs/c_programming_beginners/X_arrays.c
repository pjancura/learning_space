#include <stdio.h>
#include <stdlib.h>

int main()
{
    int luckyNums[] = {4, 8, 15, 16, 23, 42};
    luckyNums[1] = 200;

    printf("%d\n", luckyNums[1]);

    int newNums[10];                            // this creates spaces for an array of length 10
    newNums[1] = 56;
    newNums[0] = 64;
    printf("%d\n", newNums[1]);


    return 0;
}