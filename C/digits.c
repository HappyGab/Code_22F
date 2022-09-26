#include<stdio.h>



int main()
{
    int num;
    printf("Enter an integer: ");
    scanf("%d", &num);

    int incr = 1;
    int num2 = num;

    while(num2 > 10){

        num2 = num2 / 10;
        incr++;
    }

    printf("Number of digits in %d", num);
    printf (" is %d", incr);
    printf("\n");

    return 0;
}