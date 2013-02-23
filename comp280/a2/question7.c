//
//  COMP280. Assignment 2. 
//  question7.c
//  Accepts a single character string as a cmd line
//  arg and converts occurances of "." to "_"
//  The new string is written to a file called out
//
//  Matthew Shirlaw 16/08/12.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define SIZE 50

int main(int argc, char *argv[])
{
    char *str;
    char newStr[SIZE];
    int i;
    FILE *file;

    //test for correct number of cmd args
    if(argc != 2)
    {
        printf("Usage: quesiton7 aString\n");
        exit(1);
    }        
    else
    {
        //ensure str points to cmd arg
        str = argv[1];
        for(i=0; i<SIZE; i++)
        {
            //replace occurances of "."
            if(*(str+i)=='.')
                newStr[i] = '_';
            else
                newStr[i] = *(str+i);
        }
        newStr[i] = '\0';
    }
    
    //open the output file for writing
    if((file = fopen("out", "w")) != NULL)
    {
        //print newStr to file
        fprintf(file, "%s\n",newStr);
        
        //close the output file
        fclose(file);    
    }
    else
    {
        printf("Error opening \"out\" file\n");
    }
}