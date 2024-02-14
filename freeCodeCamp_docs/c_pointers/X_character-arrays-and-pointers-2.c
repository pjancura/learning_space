// 

#include <stdio.h>
#include <stdlib.h>

void print(char *c);

int main()
{
    
    char str4[32] = "Hello";        // this string literal is stored in strack frame of main
    char *str5 = "Hello";           // this string gets stored as a constant at the time of compilation, this string cannot be modified
    // str5[0] = 'A';               // will cause a compilation error
    print(str4);

    printf(" %c\n", str4[5]);


    return 0;
}


void print(char *c)
{
    while (*c != '\0')
    {
        printf("%c", *c);
        c++;
    }
    printf("\n");
}

void printConstant(const char *c)
{
    // c[0] = 'A';                 // this will cause an error because c is now being treated as a constant and no longer be modified
    while (*c != '\0')
    {
        printf("%c", *c);
        c++;
    }
    printf("\n");
}