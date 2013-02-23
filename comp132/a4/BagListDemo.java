import java.util.*;

/**
   This program gives a demonstration of the 
   BagListType class and the BagTypeIterator
*/

public class BagListDemo
{
    public static void main(String[] args)
    {
	boolean exit = false; //flag to end program
	String input; //to hold user input
	int choice; //to hold the iteger value of the user's choice
	
	//scanner for user input
	Scanner keyboard = new Scanner(System.in);
	
	//create a Bag to hold Integer objects
	BagListType<Integer> bag = new BagListType<Integer>();
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
			insertSome(bag);
			break;
		    case 2:
			//remove the first and last element
			bag.remove(0);
			bag.remove(bag.size()-1);
			break;
		    case 3:
			//clear all items in the bag
			bag.clear();
			break;
		    case 4:
			//test the iterator 
			iterateOver(bag);
			break;
		    case 5:
			//remove one occurance
			removeAnOccurance(bag);
			break;
		    case 6:
			//Display the size of the set
			System.out.println("\nThe size of the Bag is: "+bag.size());
			break;
		    case 7:
			//display the bag
			displayBag(bag);
			break;
		    case 8:
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
	System.out.println("1.\tAdd items to the Bag.");
	System.out.println("2.\tRemove the first and last element of the Bag.");
	System.out.println("3.\tClear all items in the Bag.");
	System.out.println("4.\tRemove an item using the Iterator.");
	System.out.println("5:\tRemove an occurance of an item in the Bag.");
	System.out.println("6.\tDisplay the size of the Bag.");
	System.out.println("7.\tDisplay the Bag.");
	System.out.println("8.\tExit.");
	System.out.println();
	System.out.print("Choice: ");
    }  
   
    /**
       The insertSome method prompts the user to input some items to add to the Bag
       @param bag A BagListType object to add items to
     */

    public static void insertSome(BagListType bag)
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
		    bag.insert(new Integer(item));
	    }
    }

    /**
       The iterateOver method tests the BagTypeIterator
       @param bag A BagListType object to iterate over
    */

    public static void iterateOver(BagListType bag)
    {
	String item;
	int toRemove;
	Scanner keyboard =  new Scanner(System.in);
	//get an iterator
	BagTypeIterator<Integer> it = bag.iterator();
	
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
       The removeAnOccurance method removes one occurance of an 
       item in the Bag. If the number of items falls to zero, the entire
       element is removed
       @param bag A BagListType object to remove one occurnance from
     */

    public static void removeAnOccurance(BagListType bag)
    {
	String item;
	int toRemove;
	Scanner keyboard =  new Scanner(System.in);
 	
	System.out.print("\nEnter an item to remove a single occurance: ");
	item = keyboard.nextLine();
	toRemove = Integer.parseInt(item);

	bag.erase_one(toRemove);
   
    }

    /**
       The displayBag method dispalys the items in the Bag and the 
       count of each item
       @param theBag A BagListType object to dispaly
     */

	    
    public static void displayBag(BagListType theBag)
    {
	System.out.println("The Bag is:");
	for (int i = 0; i<theBag.size(); i++)
	    System.out.println("Index at "+i+": "+theBag.get(i)+"\tCount: "+
			       theBag.getCounts(i)); 
	
    }

}