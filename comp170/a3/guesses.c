/* guesses.c You get GUESSES goes to guess a number between 1 and MAX */
#include <stdio.h>
#include <time.h>
#define GUESSES 4
#define MAX 10

int main( void )
{
    int guess, secret, guesses;

    srand( time(NULL) );
    secret = (rand() % MAX) + 1;

    guess = 0;
    printf( "You get %d goes to guess a number between %d and %d\n", GUESSES, 1, MAX );
    printf( "What is your guess: " );
    scanf( "%d", &guess );
    guesses = 1;
    while( (guess != secret) && (guesses < GUESSES) )
    {
        printf( "No. Guess again: " );
        scanf( "%d", &guess );
        guesses++;
        }
    if( (guess == secret) && (guesses <= GUESSES) )
        printf( "Got it in %d guesses!\n", guesses );
    else
        printf( "It was %d\n", secret );
    }
