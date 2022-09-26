#include<stdio.h>

int main()
{
    int num;
    printf("Enter a binary number: ");
    scanf("%d", &num);

    int incr = 1;
    int num2 = num;
    int dec = 0;

    while(num2 > 10){

        num2 = num2 / 10;
        incr++;
    }

    num2 = num;
    int temp;
    int loopNum = 0;

    while (num2 > 0){

        temp = num2 % 10;

        if (temp == 1){

            if (loopNum == 0){
                
                dec = 1;
            }
            else{
                int toAdd = 2;

                for (int i = 1; i < loopNum; i++){
                
                    toAdd = toAdd * 2;
                }

                dec = dec + toAdd;
            }
        }
        incr--;
        loopNum++;

        num2 = num2 / 10;
    }

    printf("The decimal equivalent of %d", num);
    printf (" is %d", dec);
    printf("\n");

    return 0;
}