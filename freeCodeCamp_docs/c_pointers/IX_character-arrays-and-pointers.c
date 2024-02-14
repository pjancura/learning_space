// strings are groups of characters
// character arrays are used to store strings

// you need a character array of length of the characters in the string + 1
// OR size of array >= length of string + 1

// WHY + 1
// the + 1 stores the fact that it is end of the string
// in the + 1 position goes a NULL character == '\0'

// arrays an dpointers are different types that are used in similar manner
// char c1[6] = "Hello";
// char *c2 = c1;  remember that c1 only has the address of the first character of the array
// printf(c2[2]);  => 'l'
// c2[0] = 'A'; =>     "Aello"
// c2[i] really means *(c2 + i)
// remember that *(c2 + i) means that c2[i] is being dereferenced thus you get the value back at the i-th index
// also this means that since c2 is just a memory address c2++ is a valid statement
// this can help you traverse an array

// remember arrays are always passed to functions by reference

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print(char *c);

int main()
{
    char str[5];
    str[0] = 'J';
    str[1] = 'O';
    str[2] = 'H';
    str[3] = 'N';
    str[4] = '\0';
    printf("\n");
    printf("Value of str = %s\n", str);
    // length will be calculated until the NULL terminator is reached
    int len = strlen(str);
    printf("Length of str = %d\n", len);


    // example of string literal
    // str2 will not be able to be modified
    char str2[5] = "PAUL";
    int sizeStr2 = sizeof(str2);
    printf("size of str2 in byte = %d\n", sizeStr2);
    int len2 = strlen(str2);
    printf("Length of str2 = %d\n", len2);
    printf("more bytes are needed than the length to account for the NULL character\n");

    // this is another way to initialize a string in C
    char str3[5] = {'P', 'A', 'U', 'L', '\0'};
    printf("value of str3 = %s\n", str3);

    printf("\n");
    printf("\n");

    char str4[32] = "Hello";
    print(str4);



    return 0;
}

void print(char *c)
{
    int i = 0;
    while ( c[i] != '\0')
    {
        printf("%c", c[i]);
        i++;
    }
    printf("\n");

    while (*c != '\0')
    {
        printf("%c", *c);
        c++;
    }
    printf("\n");
}