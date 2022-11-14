#include<stdio.h>



void userBets(){

    char userBetYorN = ' ';
    userBetYorN = getchar();
    do{
        printf("Would you like to bet? [y / Y] or [n / N] ");
        userBetYorN = fgetc(stdin);
        
        if(userBetYorN != 'Y' && userBetYorN != 'N' && userBetYorN != 'y' & userBetYorN != 'n'){
            
            printf("Invalid input\n");
            
            userBetYorN = getchar();
        }
    }while(userBetYorN != 'Y' && userBetYorN != 'N' && userBetYorN != 'y' && userBetYorN != 'n');


    printf("You have $%d", betMoney);
    printf(", bets are 5$ each, how many bets would you like to make? ");

    int betsNum = 0;

    int maxBets = betMoney/5;

    do{
        printf("You can make from 1 to %d", maxBets);
        printf(" bet(s) ");
        scanf("%d", &betsNum);

        if(betsNum < 1 || betsNum > maxBets){
            printf("Invalid bet\n");
            char temp[25];
            scanf("%s", temp);
        }
    }while(betsNum < 1 || betsNum > maxBets);

    printf("You bet $%d", betsNum*5);
}