/* another type of comment in C,
this will work for multiple lines */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int num = 6;

    printf("%f\n", 5 + 4.5);
    printf("%d\n", 5 / 4);          // even though this would be a floating point number, the %d will round the number off
    printf("%f\n", num / 4.0);

    printf("%f\n", pow(2, 3));      // pow(2, 3) = 2 cubed
    printf("%f\n", sqrt(4.0));          // squareroot
    printf("%f\n", ceil(3.14159));          // rounds up
    printf("%f\n", floor(3.9));         // rounds down

    return 0;
}