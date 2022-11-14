#include<stdio.h>
#include"Assignment_1_header.h"


void main(){

    char userPlay = ' ';
    do{
        printf("Please enter [y or Y] to play Dice or [n or N] to exit: ");
        userPlay = fgetc(stdin);
        
        if(userPlay != 'Y' && userPlay != 'N' && userPlay != 'y' & userPlay != 'n'){
            
            printf("Invalid input\n");
            
            userPlay = getchar();
        }
    }while(userPlay != 'Y' && userPlay != 'N' && userPlay != 'y' && userPlay != 'n');

    userBets();

}