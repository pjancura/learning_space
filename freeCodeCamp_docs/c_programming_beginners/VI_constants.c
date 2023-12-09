// constants are variables that can't be modified

#include <stdio.h>
#include <stdlib.h>

int main()
{

    const int FAV_NUM = 5;              // this variable is now a constant, and named with ALL_CAPS

    printf("%d\n", FAV_NUM);

    printf("Hello\n");                  // this is also a constant because I can't modify it

    return 0;
}