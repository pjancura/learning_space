#include <stdio.h>
#include <stdlib.h>

int main()
{
    char grade;

    printf("What grade did you get: ");
    scanf(" %c", &grade);


    switch(grade){
        case 'A' :
            printf("You did great!\n");
            break;
        case 'B' :
            printf("You did well\n");
            break;
        case 'C' :
            printf("Average\n");
            break;
        case 'D' :
            printf("Do better\n");
            break;
        case 'F' :
            printf("You failed\n");
            break;
        default :
            printf("Invalid grade");
            break;
    }




    return 0;
}