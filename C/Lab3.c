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
//This file does not work, but it has all the code i wrote to try
//and validate course codes
//
/******************************************************/



int *sID;
//char *cID[10];
void addStudents(int studentNum);
//void addCourses(int CoursesNum, char a[]);
void addCourses2(int CoursesNum, char a[]);
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

    char a[coursesNum][8];

    //cID = &a;

    //cID = (char*)calloc(coursesNum, 8);

    char *course[8];

    int endLoop = 0;
    
    while (endLoop < coursesNum){

        printf("Enter the course index [%d", endLoop);
        printf("] course id (3 alphas)(4 digits): ");
        scanf("%s", &course);

        cID[endLoop] = course;
    }
   
    //addCourses2(coursesNum, a[coursesNum]);
    
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

/*
void addCourses2(int coursesNum, char cID[]){

    char *course[8];

    int endLoop = 0;
    
    while (endLoop < coursesNum){

        printf("Enter the course index [%d", endLoop);
        printf("] course id (3 alphas)(4 digits): ");
        scanf("%s", &course);

        cID[endLoop] = course;
    }

}
*/
/*
void addCourses(int coursesNum, char cID[]){

    int courseIDint;
    char cIDintTOchar[4];
    char courseIDchar[3];
    char courseID[7];
    int endLoop = 0;

    int good = 0;

    while (endLoop < coursesNum){

        printf("Enter the course index [%d", endLoop);
        printf("] course id (3 alphas)(4 digits): ");
        scanf("%d", &courseIDint);

        if(courseIDint < 1){

            char temp[20];
            scanf("%s", temp);
        }
        else if (countDigits(courseIDint) == 4){

            
            
            good = 1;
        }
        else{
            printf("Course ID must be 3 alphas 4 digits\n");
            courseIDint = 0;
        }

        if (good == 1){

            scanf("%s", courseIDchar);

            cID[endLoop] = courseIDchar;
            //printf("%s", courseIDchar);
            //cID[endLoop] = courseIDchar;

            //printf("%d", cID[endLoop]);
            printf("%d", courseIDint);

            int i = 0;
            for (i; i < 3; i++)
            {
                printf("%c", cID[i]);
            }
            printf("\n");


            endLoop++;
            courseIDint = 0;

            
        }
              
    }
}
*/

int countDigits(int num){

    int incr = 0;

    do{
        num = num / 10;
        incr++;
    }
    while (num != 0);

    return incr;  
}
