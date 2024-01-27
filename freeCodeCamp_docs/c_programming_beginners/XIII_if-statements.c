// logical operators 
// && == and
// || == or
// == == equals to
// != == not equals to
// !(3 > 2) == negation of the answer in the parentheses

#include <stdio.h>
#include <stdlib.h>

double max(double num1, double num2, double num3);


int main()
{
    double input1;
    double input2;
    double input3;
    printf("Enter a number: ");
    scanf("%lf", &input1);
    printf("Enter a 2nd number: ");
    scanf("%lf", &input2);
    printf("Enter a 2nd number: ");
    scanf("%lf", &input3);
    printf("%lf is greater.\n", max(input1, input2, input3));


    return 0;
}

double max(double num1, double num2, double num3){
    // if (num1 > num2){
    //     return num1;
    // } else {
    //     return num2;
    // }

    if (num1 >= num2 && num1 >= num3){
        return num1;
    } else if (num2 >= num1 && num2 >= num3){
        return num2;
    } else {
        return num3;
    }

}
