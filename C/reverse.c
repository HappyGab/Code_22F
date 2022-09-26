#include<stdio.h>

int main()
{
    int num;
    printf("Enter an integer: ");
    scanf("%d", &num);

    int num2 = num;
    int rev = 0;
    int rest = 0;

    while(num2 > 0){

        rest = num2 % 10;
        rev = rev * 10;
        rev = rev + rest;
        num2 = num2 / 10;
    }

    printf("The reverse of %d", num);
    printf (" is %d", rev);
    printf("\n");

    return 0;
}