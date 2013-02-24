guesses: main.o screen.o
	gcc main.o screen.o -lcurses -o guesses
main.o:	main.c screen.h
	gcc -c main.c
screen.o: screen.c 
	gcc -c screen.c
