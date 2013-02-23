/*nonempty.c*/

#include <stdio.h>
#define NEWLINE '\n'

int main (void)
{
	char c;
	while ((c=getchar())!=EOF)
	{
		//test if first char is a newline character
		if (c == NEWLINE)    
		{ 
			//test if the next char is also a newline character
			if ((c=getchar()) != NEWLINE) 
			{
				printf("\n");  //if not, print a newline then the char
				putchar(c);
			}
			else
				putchar(c);    //if so, print second newline only
		}
		else
			putchar(c);        //if char is not a newline, print it
	}
	printf("\n");
}
