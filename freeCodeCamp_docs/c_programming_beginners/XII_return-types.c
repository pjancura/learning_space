#include <stdio.h>
#include <stdlib.h>

double cubed(double num);       // this is called prototyping, the definition for the function is below main,
                                // but by declaring it up here the main() will still be able to call the function
                                // this can make your code more neat??



int main()
{
    double userInput;
    printf("Enter a number to be cubed: ");
    scanf("%lf", &userInput);
    printf("%lf\n", cubed(userInput));


    return 0;
}


double cubed(double num){
    // double result = num * num * num;
    // return result;
    return num * num * num;
}