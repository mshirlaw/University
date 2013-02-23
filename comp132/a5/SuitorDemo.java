import java.util.Scanner;

/**
   This class tests the SuitorNode class
   @author Matthew Shirlaw
*/

public class SuitorDemo
{
    public static void main(String[] args)
    {
	//for user input
	Scanner keyboard = new Scanner(System.in);
	int suitors = 0;

	//prompt for user input
	System.out.println("Enter the number of suitors: ");
	suitors = keyboard.nextInt();
	
	if(suitors == 0)
	    System.out.println("Not enough suitors.");
	else if (suitors == 1)
	    System.out.println("The suitor would stand first in line.");
	else
	{
	    //create a circular linked list
	    SuitorNode myNodeList = new SuitorNode();
	    
	    //add the total number of suiters to the list
	    for(int i=1; i<= suitors; i++)
		myNodeList.add(i);
	    
	    //used when debugging
	    //System.out.println();

	    //reduce the list to one suitor
	    System.out.println("To win the princess, the suitor should stand in position " +myNodeList.reduceList());
	}

    }
}
