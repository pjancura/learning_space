#include <stdio.h>
#include <stdlib.h>

int main()
{
    char color[32];
    char pluralNoun[32];
    char celebrityF[32];
    char celebrityL[32];

    printf("Enter a color: ");
    scanf("%s", color);
    printf("Enter a Plural Noun: ");
    scanf("%s", pluralNoun);
    printf("Enter a Celebrity (first and last name): ");        // this will force the user to enter 2 strings
    scanf("%s%s", celebrityF , celebrityL);

    printf("Roses are %s\n", color);
    printf("%s are blue\n", pluralNoun);
    printf("I love %s %s\n", celebrityF, celebrityL);

    return 0;
}