#include <stdio.h>
#include <stdlib.h>

int main()
{
    int faveNum = 90;

    printf("Hello\nWorld!");
    printf("Hello\"World!");            //  \" will print a literal "
    printf("%d\n", 500);                  // %d is an example of a format specifier .... this works for an int
    printf("My favorite %s is %d\n", "Number" , 500);  // this is an example of combining format specifiers
    printf("My favorite %s is %f\n", "Number" , 3.14159);   // %f works for doubles (maybe floats too)
    printf("%d\n", faveNum);

    return 0;
}