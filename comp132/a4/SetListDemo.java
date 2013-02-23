import java.util.*;

/**
   This program gives a demonstration of the 
   SetListType class and the SetTypeIterator
*/

public class SetListDemo
{
    public static void main(String[] args)
    {
	boolean exit = false; //flag to end program
	String input; //to hold user input
	int choice; //to hold the iteger value of the user's choice

	//scanner for user input
	Scanner keyboard = new Scanner(System.in);

	//create a Set to hold Integer objects
	SetListType<Integer> set = new SetListType<Integer>();
	System.out.println();

	while(!exit)
	{
	    try
	    {
		displayMenu();
		input = keyboard.nextLine();
		choice = Integer.parseInt(input);
		
		switch(choice)
		    {
		    case 1:
			//insert some items
			insertSome(set);
			break;
		    case 2:
			//remove the first and last element
			set.remove(0);
			set.remove(set.size()-1);
			break;
		    case 3:
			//clear all items in the set
			set.clear();
			break;
		    case 4:
			//test the iterator 
			iterateOver(set);
			break;
		    case 5:
			//Display the size of the set
			System.out.println("\nThe size of the Set is: "+set.size());
			break;
		    case 6:
			//display the set
			displaySet(set);
			break;
		    case 7:
			//exit from the program
			exit = true;
			break;
		    default:
			//invalid choice entered by the user
			System.out.print("Invalid Choice. Enter again: ");
			break;
		    }
		
		System.out.println();
	    }
	    catch (IndexOutOfBoundsException e)
		{
		    System.out.println(e.getMessage());
		}
	    catch(NoSuchElementException e )
		{
		    System.out.println(e.getMessage());
		}
	    catch(IllegalStateException e )
		{
		    System.out.println(e.getMessage());
		}
        }
    }

    /**
       displayMenu method displays a menu
       to prompt for user input
    */

    public static void displayMenu()
    {
	System.out.println("Choose an option from the list: ");
	System.out.println("1.\tAdd items to the Set.");
	System.out.println("2.\tRemove the first and last element of the Set.");
	System.out.println("3.\tClear all items in the Set.");
	System.out.println("4.\tRemove an item using the Iterator.");
	System.out.println("5.\tDisplay the size of the Set.");
	System.out.println("6.\tDisplay the Set.");
	System.out.println("7.\tExit.");
	System.out.println();
	System.out.print("Choice: ");
    }
    
    /**
       insertSome prompts the user to input some items to add to the Set
       @param set A SetListType object to add items to
     */

    public static void insertSome(SetListType set)
    {
	String item;
	Scanner keyboard =  new Scanner(System.in);
	boolean done = false;
	
	while(!done)
	    {
		//prompt for an item
		System.out.println("Enter an item or type F to exit: ");
		item = keyboard.nextLine();
		
		if(item.charAt(0) == 'F' || item.charAt(0) == 'f')
		    done = true;
		else
		    set.insert(new Integer(item));
	    }
    }

    /**
       The iterateOver method test the SetTypeIterator
       @param set A SetListType object to iterate over
    */

    public static void iterateOver(SetListType set)
    {
	String item;
	int toRemove;
	Scanner keyboard =  new Scanner(System.in);
	//get an iterator
	SetTypeIterator<Integer> it = set.iterator();
	
	//remove an item with the iterator
	System.out.print("\nEnter an item to remove: ");
	item = keyboard.nextLine();
	toRemove = Integer.parseInt(item);

	boolean removed = false;

	while(it.hasNext())
	    {
		if(it.next().equals(new Integer(toRemove)))
		    {
			it.remove();
			removed = true;
		    }	
	    }
	if (removed)
	    System.out.println("Successfully removed "+item);
	else
	    System.out.println("\n"+item+" not found. Did not remove any items.");
    }

    /**
       displaySet method displays the Set to stdout
       @param theSet A SetListType object to display
    */

    public static void displaySet(SetListType theSet)
    {
	System.out.println("\nThe Set is:");
	for (int i = 0; i<theSet.size(); i++)
	    System.out.println("Index "+i+": "+theSet.get(i)); 
	
    }
    
}