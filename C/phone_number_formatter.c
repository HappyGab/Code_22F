#include<stdio.h>

/**
* File: phone_number_formatter.c
* Author: Gabriel Koscielniak
*
* Status:
*   Compiles without warning(s): true
*   Requirement #1 - exit on input of 0: complete
*   Requirement #2 - not a 7-digit number: complete
*   Requirement #3 - invalid phone number: complete
*   Requirement #4 - formatted phone number: complete
*   Requirement #5 - loops until input of 0: complete
*/

void main(){

    int loop = 0;

    while (loop == 0){

        int num;
        printf("Please enter a phone number: ");
        scanf("%d", &num);

        if (num == 0){

            printf("Quit signal received\n");
            printf("Program ended with exit code: 0\n");
            return;
        }

        int incr = 1;
        int tempNum = 0;

        int phoneNum[7];

        while(num > 10){

            if (incr <= 7){
                tempNum = num % 10;
                phoneNum[incr-1] = tempNum;
            }  

            num = num / 10;
            incr++;    
        }

        phoneNum[incr-1] = num;

        if (incr == 7){
            
            if (phoneNum[6] == 1){
                
                printf("Invalid phone number\n");
            }
            else{
                printf("The formatted phone number is: ");

                for (int i = 6; i >= 0; i--){
                    printf("%d", phoneNum[i]);

                    if (i == 4){
                        printf("-");
                    }
                }

                printf("\n");
            }
        }
        else{
            printf("The number entered is not 7 digits long\n");
        }
    }
}