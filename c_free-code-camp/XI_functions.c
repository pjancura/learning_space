#include <stdio.h>
#include <stdlib.h>

void sayHi(char name[], int age){
    printf("Hello %s, you are %d\n", name, age);
}

int main()
{

    sayHi("Paul", 56);
    sayHi("Theresa", 32);
    sayHi("John", 18);


    return 0;
}
