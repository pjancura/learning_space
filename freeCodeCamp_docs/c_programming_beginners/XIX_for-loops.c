#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i = 1;

    printf("While loop: \n");
    while(i <= 5){
        printf("%d\n", i);
        i++;
    }

    int n;
    
    int luckyNums[] = {4, 8, 15, 23, 42};

    printf("For Loop: \n");
    for(n = 0; n < 5; n++){
        printf("%d\n", luckyNums[n]);
    }


    return 0;
}