#include <stdio.h>
#include <stdlib.h>

int main()
{   
    char line[1000];

    FILE * fpointer = fopen("employees.txt", "r");

    fgets(line, 50, fpointer);                     // fgets(whereDoYouStoreTheInfo, MAX_ARRAY_SIZE, whereIsTheInfoComingFrom)
    fgets(line, 1000, fpointer);                     // this will print the second line              
    printf("%s", line);                             // fgets apparently only reads until it hits the newline character
    
    printf("\n%p\n", fpointer);

    fclose(fpointer);

    return 0;
}