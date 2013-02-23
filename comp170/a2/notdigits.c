/*notdigits.c*/

#include <stdio.h>

int main (void)
{
	char c;

	//assign each character in test to variable c and print non integers
	while ((c=getchar()) != EOF)
	{    
		if (!(isdigit(c)))  //tests whether each char is 0- 9
			putchar(c);
	}
	printf("\n");
}
 
