#include<stdio.h>

int ofThree();
int ofFive();

void main()
{

    int incr = 1;

    while(incr <= 100){

        printf("%d",incr);
        int mOf3 = ofThree(incr);
        int mOf5 = ofFive(incr);

        if(mOf3 != 0 && mOf5 == 0){
            printf(" I'm a multiple of 3!");
        }
        else if(mOf5 != 0 && mOf3 == 0){
            printf(" I'm a multiple of 5!");
        }
        else if(mOf5 != 0 && mOf3 != 0){
            printf(" I'm a multiple of 3 and 5!");
        }

        incr++;
        printf("\n");
    }
}

int ofThree(int num){

    if(num % 3 == 0){

        return 1;
    }

    return 0;
}

int ofFive(int num){

    if(num % 5 == 0){

        return 1;
    }

    return 0;
}