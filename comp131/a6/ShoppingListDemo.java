/**
	Assignment P6. 
	@author mshirlaw
*/

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class ShoppingListDemo
{

	/**
		displayMenu method displays a menu for user input
	*/
	
	public static void displayMenu()
	{
		System.out.println();
		System.out.println("Options:"               );
		System.out.println("======================" );
		System.out.println("  1. Add/Increase Item" );
		System.out.println("  2. Output List"       );
		System.out.println("  3. Output Total Cost" );
		System.out.println("  4. Save List"         );
		System.out.println("  0. Quit"              );
		System.out.println("======================" );
		System.out.print("Enter Choice: ");
	}
  
	/**
		capitalise method capitalises the first letter of each word in the description
		@param str The string to be capitalised
	*/	
  
	public static String capitalise(String str)
	{
		final int MAX_WORDS = 50;
		
		//string tokenizer to split the description into tokens
		StringTokenizer tokenizer = new StringTokenizer(str);
	
		//array to store each word in the description	
		String[] wordArray = new String[MAX_WORDS];
	
		int length;
		String word;
		String temp;
		String temp2;
		String caps;
		String finalWord;
	
		int i =0;
		int count = 0;
	
		while (tokenizer.hasMoreTokens())
		{
			word = tokenizer.nextToken();
			length = word.length();
			temp = word.substring(0,1);
			temp2 = temp.toUpperCase();
			caps = temp2.concat(word.substring(1, word.length()));
			wordArray[i] = caps;
			count++;
			i++;
		}
	
		finalWord = wordArray[0];
		
		for(i=1; i<count; i++)
		{
			finalWord = finalWord + " " + wordArray[i];
		}
	
		return finalWord;
	}
  
	/**
		getInput method accepts a shopping list and allows user input
		@param myList A ShoppingList object
	*/
  
	public static void getInput(ShoppingList myList) throws IOException
	{
		
		//to allow user input
		Scanner keyboard = new Scanner(System.in);
		
		//to format numbers
		DecimalFormat formatter = new DecimalFormat("#0.00");
	
		//to store user input
		int choice;
		
		//flag to indicate that the loop should finish and the program should exit
		boolean exitNow = false;
		
		while (!exitNow)
		{
			choice = keyboard.nextInt();
	
			//variables for add item
			String input;
			String newDescr;
			double newCost;
			int newQuan;	
	
			switch (choice)
			{
				case 1:
					keyboard.nextLine(); //flush input buffer
					System.out.println();
					System.out.print("Enter Description: ");
					input = keyboard.nextLine();
					newDescr = capitalise(input);			
					System.out.print("Enter Cost: $");
					newCost = keyboard.nextDouble();
					System.out.print("Enter Quantity: ");
					newQuan = keyboard.nextInt();
					System.out.println();
					myList.addItem(newDescr, newCost, newQuan);
					displayMenu();
					break;
				case 2:
					myList.output();
					displayMenu();
					break;
				case 3:
					System.out.println();
					System.out.println("Total Cost: $" +formatter.format(myList.totalCost()));
					System.out.println();
					displayMenu();
					break;
				case 4:
					myList.save();
					displayMenu();
					break;
				case 0:
					keyboard.nextLine(); //flush input buffer
					if(!myList.isUpToDate())
					{
						System.out.println();
						System.out.println("The shopping list has changed since last saved.");
						System.out.print("Do you wish to save changes? (y/n): ");
						input = keyboard.nextLine();
						if (input.charAt(0) == 'y' || input.charAt(0) == 'Y')
							myList.save();
					}
					exitNow = true;
					break;
				default:
					displayMenu();
					System.out.println("Invalid input. Try again: ");
					break;
		}	
	}
}

	/** 
		main method instantiates a ShoppingList objec, calls displayMenu() and getInput() methods
	*/
	
	public static void main(String[] args) throws IOException
	{

		ShoppingList myList = new ShoppingList();

		displayMenu();
		getInput(myList);
	
	}
  
}//end ShoppingListDemo class

