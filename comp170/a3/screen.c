#include <curses.h> /*for curses functions*/
#include <stdlib.h> /*for the exit(1) function */

#define RULES_ROW 1  //row where rules are displayed
#define RULES_COL 10 //col where rules start
#define PROMPT_ROW 3 //row for prompt
#define PROMPT_COL 10   //col where prompt starts
#define ERROR_ROW 1 //row for error message
#define ERROR_COL 10 //column for error message
#define ANSWER_ROW 5 //row for result of guess message
#define ANSWER_COL 10 //column for result of guess message

//this function handles the SIGALRM event when the time runs out
void handler()
{
  clear();
  mvaddstr(ERROR_ROW, ERROR_COL, "Bad luck, you ran out of time!");
  mvaddstr(ERROR_ROW+2, ERROR_COL, "Press a key to exit...");
  refresh();
  getch();
  endwin();
  exit(1);
}

//this function prints the rules of the game to the screen
void showRules(int timeLimit, int maxNumber)
{
  mvprintw(RULES_ROW, RULES_COL, "You get %d seconds to guess a number between 1 and %d", timeLimit, maxNumber);
  refresh();
}

//this function prompts for a guess and returns the guess to the calling statment
int promptGuess(void)
{
  int g;
  mvprintw(PROMPT_ROW, PROMPT_COL, "What is your guess: ");
  refresh();
  scanw("%d", &g);
  return g;
}

//this function excecutes if the correct answer is chosen
void correctAnswer()
{
  mvaddstr(ANSWER_ROW, ANSWER_COL, "Congratulations! Exiting now, please wait...");
  refresh();
}

//this function excecutes if the incorrect answer is chosen
void incorrectAnswer()
{
  clear();
  mvaddstr(ANSWER_ROW, ANSWER_COL, "Keep trying!");
  refresh();
}

//this function displays an error message if there are insufficent cmd line args
void incorrectUsage()
{
  mvaddstr(ERROR_ROW, ERROR_COL, "Usage: guesses seconds maximum"); 
  mvaddstr(ERROR_ROW+2, ERROR_COL, "Press a key to exit...");
  refresh();
  getch();
  endwin();
  exit(1);
}
