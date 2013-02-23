/*duplicates.c*/

#include <stdio.h>

int main (void)
{

	char c;              //to store each character
	int length = 0;      //to store the total  number of characters
	int duplicates = 0;  //to store the number of duplicates
	int i;               //a counting variable
	int j;               //second counting variable
	char myArray[100];   //an array of characters
  
	//place all letters of the file in an array of characters
	while ((c=getchar()) != EOF)
	{
		myArray[length] = c;
		length++;
	}
  
	//compare each element in the array with the next element to count duplicates
	for (i=0, j=1; i<=length; i++, j++)
	{
		if (myArray[i] == myArray[j])
			duplicates++;
	}
  
	//output # of characters in the array, # of duplicates and non duplicates
	printf("%d %d %d", length, duplicates, (length - duplicates));
	printf("\n");
}
