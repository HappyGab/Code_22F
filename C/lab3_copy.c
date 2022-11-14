#include<stdio.h>
#include <stdlib.h>
#include <string.h>

/*
* Title: Lab Assessment #3 - Student Registration System
* Course: CST8234 C Language
* @Author: <<< Gabriel Koscielniak (041062261) >>>
* Lab Section: 011
* Professor: Surbhi Bahri
* Due date: 10-18-2022
* Submission date: 10-18-2022
*/

/******************************************************/
//
//This file works, but it does not validate course codes
//
/******************************************************/

int *sID;
void addStudents(int studentNum);
void printMenu();
int countDigits(int num);



void main(){

    printf("Welcome to Student Registration System\n\n");

    int studentNum = 0;

    do{
        printf("Enter the number of students to register: ");
        scanf("%d", &studentNum);

        if(studentNum < 1){
            char temp[20];
            scanf("%s", temp);
        }
    }while(studentNum < 1);

    sID = (int*)calloc(studentNum, sizeof(int));
   
    addStudents(studentNum);

    int coursesNum = 0;
    do{
        printf("Enter the number of courses available: ");
        scanf("%d", &coursesNum);

        if(coursesNum < 1){
            char temp[20];
            scanf("%s", temp);
        }
    }while(coursesNum < 1);

    char cID[coursesNum][8];

    int endLoop = 0;
    
    while (endLoop < coursesNum){

        printf("Enter the course index [%d", endLoop);
        printf("] course id (3 alphas)(4 digits): ");
        scanf("%s", cID[endLoop]);

        endLoop++;
    }

    int quit = 0;

    int userInput = 0;

    while (quit == 0){

        printMenu();

        printf("Enter an option from the menu: ");
        scanf("%d", &userInput);

        if(userInput < 1){
            printf("Invalid input\n");
            char temp[20];
            scanf("%s", temp);
        }
        else if(userInput == 1){
            printf("function not yet implemented\n");
        }
        else if (userInput == 2){
            printf("function not yet implemented\n");
        }
        else if (userInput == 3){
            printf("function not yet implemented\n");
        }
        else if (userInput == 4){
            quit = 1;
        }
    }
       
    free(sID);
}

void addStudents(int studentNum){

    int studentID;
    int endLoop = 0;

    while (endLoop < studentNum){

        printf("Enter the student index [%d", endLoop);
        printf("] student id (5 digits): ");
        scanf("%d", &studentID);

        if(studentID < 1){

            char temp[20];
            scanf("%s", temp);
        }
        else if (countDigits(studentID) == 5){
            sID[endLoop] = studentID;
            studentID = 0;
            endLoop++;
        }
        else{
            printf("Student ID must be 5 digits\n");
            studentID = 0;
        }
              
    }    
}

int countDigits(int num){

    int incr = 0;

    do{
        num = num / 10;
        incr++;
    }
    while (num != 0);

    return incr;  
}

void printMenu(){

    printf("Main menu:\n");
    printf("[1] Register student into a course\n");
    printf("[2] Drop student from a course\n");
    printf("[3] Display registration table\n");
    printf("[4] exit\n");
}