// execute while the statement is true

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int index = 1;
    printf("While: \n");
    while(index <= 5){
        printf("%d\n", index);
        index++;
    }

    printf("Do / while: \n");
    do {
        printf("%d\n", index);
        index++;
    } while(index <= 10);





    return 0;
}