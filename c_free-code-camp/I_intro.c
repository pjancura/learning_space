#include <stdio.h>
#include <stdlib.h>

int main ()                                     // main is the method that will be executed after we compile the program
{
    printf("Hello world!\n");                   // printf() prints values to the terminal, every line in a C program needs end with a ;
    printf("Hello world!\n");

    printf("    /|\n");
    printf("   / |\n");
    printf("  /  |\n");        
    printf(" /   |\n");
    printf("/____|\n");



    return 0;
}

// compilation takes this program and translates it into machine code

// clang filename.c -o compiledName             this will compile the program, the -o allows you to name the output file
// ./compiledName                               this will execute the program in the terminal