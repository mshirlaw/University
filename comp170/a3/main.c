/**A screen handling version of  the guesses.c program
 * Accepts a time limit and maximum number from the cmd line 
 * and asks the user to guess a number between 1 & the max
 * By Matthew Shirlaw
 **/

#include <unistd.h> /*for the alarm() function*/
#include <stdio.h>  /*for the sscanf() function*/
#include <signal.h> /*for the signal() function*/
#include <time.h>   /*for the time() funtion*/
#include "screen.h" /*for he functions from screen.c*/


int main(int argc, char *argv[])
{

  int secret;           //global variable to hold the randomly generated number
  int max;              //global variable for max number
  unsigned int seconds; //variable to set the number of seconds until time out
  int guess;            //to store the user's guess

  //seed the random number generator
  srand(time(NULL));

  //set up the screen
  initscr();
  clear();

  //test the number of cmd args
  if (argc == 3)
  {
    sscanf(argv[1], "%d",  &seconds);
    sscanf(argv[2], "%d", &max);
    
    //set the secret number to a random value
    secret = (rand() % max)+1;

    signal(SIGALRM, handler);
    alarm(seconds);

    //loop while the user's guess is not equal to the secret number
    while (guess != secret)
    {
      showRules(seconds, max);
      guess = promptGuess();
      if (guess == secret)
	correctAnswer();
      else
	incorrectAnswer();
    }

    sleep(3);
    endwin();
  }
  //display an error message if innapropriate use of cmd args
  else 
    incorrectUsage();
}
