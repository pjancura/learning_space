// the easiest way for me to look at hex number in decimal is as follows:
// using python in the terminal
// int.from_bytes(bytes.fromhex("some_hex_value"), "big")
// this proves that an integer in this C program on my mac takes up 4 bytes of memory

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 10;
    int *pA = &a;

    // Pointer arithmetic
    printf("Pointer arithmetic example: \n");
    printf("Memory address of a: %p\n", pA);
    // printf("Decimal value of pA: %d\n", *pA);
    printf("pA + 1 = %p\n", pA + 1);

    printf("memory size of integer is %lu bytes\n", sizeof(int));


    printf("value at pA + 10: %d\n", *(pA + 10));


    char b = 'b';
    char *pB = &b;

    printf("%p\n", pB);
    printf("%lu\n", sizeof(char));




    return 0;
}

