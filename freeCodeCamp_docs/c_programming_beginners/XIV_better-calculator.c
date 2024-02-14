#include <stdio.h>
#include <stdlib.h>

int main()
{
    double num1;
    double num2;
    char op;
    
    printf("enter a number: ");
    scanf("%lf", &num1);
    printf("enter operator (+, -, *, /): ");
    scanf(" %c", &op);                                  // %c needs a space before it in order for scanf() to work
    printf("enter a 2nd number: ");
    scanf("%lf", &num2);
    if (op == '+'){
        printf("%lf %c %lf = %lf\n", num1, op, num2, num1 + num2);
    } else if (op == '-'){
        printf("%lf %c %lf = %lf\n", num1, op, num2, num1 - num2);
    } else if (op == '*'){
        printf("%lf %c %lf = %lf\n", num1, op, num2, num1 * num2);
    } else if (op == '/') {
        printf("%lf %c %lf = %lf\n", num1, op, num2, num1 / num2);
    } else {
        printf("Invalid Operator\n");
    }


    return 0;
}