#include <stdio.h>
#include <stdlib.h>

int main()
{   

    // * fpointer points to the memory address of the file that we are looking at
    FILE * fpointer = fopen("employees.txt", "a");
    // there are 3 modes r, w, a
    // r == read, w == write, a == append
    // w will also create a file if it doesn't exist already

    // this is used to print information to the file
    //fprintf(fpointer, "Jim, Salesman\nPam, Saleswoman\nOscar, Accountant\nDwight, Assistant to the Regional Manager\n");
    
    // this information would overwrite the previous information in the file if w mode is used
    //fprintf(fpointer, "overridden");

    // this information will be appended because the mode was changed to a
    fprintf(fpointer, "Kelly, Customer Service\n");

    // you need to make sure that you close the file to prevent memory leak (i think)
    fclose(fpointer);

    return 0;
}