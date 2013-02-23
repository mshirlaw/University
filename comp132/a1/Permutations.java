/**
   The Permutations class displays all permutatations 
   of a String. This is achieved through the use of a
   recursive method displayPermutations.
   @author Matthew Shirlaw
*/

import java.util.Scanner; //for user input

public class Permutations
{
    public static void main(String[] args)
    {
	String input; //to hold the user input
	Scanner keyboard = new Scanner(System.in);

	//display a message about the purpose of the program
	System.out.println("This program prints out all permutations of a string");
	
	//prompt for user input
	System.out.print("Enter a string: ");
	input = keyboard.nextLine();

	//call the displayPermutations method with the string input by the user
	displayPermutations(input); 
    }

    /**
      The displayPermutations method accepts a single String
      argument and passes an empty String and the received 
      String to the overloaded version of the method.
      @param text The string entered by the user
    */

    private static void displayPermutations(String text)
    {
	displayPermutations("", text);
    }

    /**
       The overloaded version of the displayPermutations method
       accepts two String arguments and recursively calls iteself to
       calculate all possible permutations of the origninal String entered
       by the user
       @param done A Strng to represent the letters which have been used
       @param todo A String to represent the remaining letters
    */

    private static void displayPermutations(String done, String todo)
    {

	if (todo == null || todo.equals(""))
	    {
		//Used to trace function return values during debugging
		//System.out.println("displayPermutations("+done+","+todo+") returns "+done);
		
		System.out.println(done);
	    }
	else
	    for (int i=0; i<todo.length(); i++) //loop through each character in the string
		{
		    String newDone = done+todo.charAt(i); //move one character from todo to done
		    String newToDo = todo.substring(0,i)+todo.substring(i+1); //create new string with remaining chars
		    
		    //Used to trace recursive calls during debugging
		    //System.out.println("Calling displayPermutations("+newDone+","+newToDo+")");
		    
		    displayPermutations(newDone, newToDo); //recursive call with new values of todo and done
		}
    }
}
