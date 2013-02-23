/**
	Assignment P6. 
	@author mshirlaw
*/

import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class ShoppingList
{

	private static final int MAX_ITEMS = 100;
	private int countItems; 		//used to keep track of how many items there are
	private String fileName;	 	//to store the name of the file
	private Item[] items; 			//array to hold the items
	private boolean upToDate; 		//flag to check whether the file needs to be updated
	
	/**
		Constructor initialises all private member fields
	*/
	
	public ShoppingList() throws IOException
	{
	
	//initialise all private member variables
	countItems = 0;
	fileName = "shopping.dat";
	upToDate = true;
	items = new Item[MAX_ITEMS];
		
	//call the readFile method
	readFile();
	
	}

	/**
		readFile method reads the file and stores entries into the items array
	*/
		
	public void readFile() throws IOException
	{
		String input;
		String cost;
		String descr;
		String quan;
		Item myItem;
		
		//create a FileReader and Buffered reader object to read from file
		FileReader freader = new FileReader(fileName);
		BufferedReader inputFile = new BufferedReader(freader);
		
		//read in first line 
		input = inputFile.readLine();
		
		while (input != null)
		{
		
		//create a StringTokenizer object to split the string
		StringTokenizer tokenizer = new StringTokenizer(input, "  ");
		
		//extract three tokens representing the cost per item, description and quantity
		cost = tokenizer.nextToken();
		quan = tokenizer.nextToken();
		descr = tokenizer.nextToken();
		
		//check whether the description has more than one word, if so concatenate the strings
		while (tokenizer.hasMoreTokens())
			descr = descr+ " "+tokenizer.nextToken();

		//create an item for each line making sure to trim whitespace 
		myItem = new Item(descr.trim(), Double.parseDouble(cost.trim()), Integer.parseInt(quan.trim()));
		
		//store each item in the array
		this.items[countItems] = myItem;
		this.countItems++;
		
		//read another line
		input = inputFile.readLine();
		
		}	
		
		inputFile.close();
		
	}
	
	/**
		addItem method will test if the item is on the list already
		If the item is already on the list, the quantity will be increased by the quantity passed
		If the item is a new item it will be added to the list if there is room
		@param descr The item description
		@param cost The item cost
		@param quan The quantity of the item to buy
	*/
	
	public void addItem(String descr, double cost, int quan)
	{
		int newQuan; //to store the new quantity if the item is already on the list
		int i; //loop control variable
		boolean descrMatch = false;
		
		//test if the new item will fit on the list and if so, add it and increment item count
		if(countItems>=items.length)
			System.out.println("There is no more room on the list");
		else
		{
			for(i=0; i<countItems; i++)
			{
				//test if the descriptions match. If so, add item quantities and set flag to true
				if(descr.equals(this.items[i].getDescription()))
				{
					newQuan = this.items[i].getQuantity() + quan;
					this.items[i].setQuantity(newQuan);
					descrMatch = true;
					this.upToDate = false;
				}
			}
		}
		
		//if the description does not match, add the item and increment item count
		if(!descrMatch)
		{
			Item myItem = new Item(descr, cost, quan);
			this.items[this.countItems] = myItem;
			this.countItems++;
			this.upToDate = false;
		}
	}	
	
	/**
		totalCost method returns the total cost of all items in the shopping list
		@return totalCost The total cost of all items in the shopping list
	*/
	
	public double totalCost()
	{
		double totalCost = 0;
		int i;
		for (i=0; i<countItems; i++)
		{
			totalCost += (items[i].getQuantity()*items[i].getCost());
		}
		
		return totalCost;
	}
	
	/**
		output method outputs the contents of the list to the screen
	*/
	
	public void output()
	{
		//to format output
		DecimalFormat formatter = new DecimalFormat("#0.00");

		int i;
		System.out.println();
		System.out.println("Item Cost"+ "  Quantity"+"  Description");
		System.out.println("==================================================");
		for(i=0; i<countItems; i++)
			System.out.println("     "+formatter.format(this.items[i].getCost())+"\t  "+this.items[i].getQuantity()+"  "+this.items[i].getDescription());
		System.out.println("==================================================");
		System.out.println();
	}

	/**
		save method updates the contents of shopping.dat file
	*/
		
	public void save() throws IOException
	{
		System.out.println();
		System.out.println("Updated contents of dat file");
		
		FileWriter fwriter = new FileWriter(fileName);
		PrintWriter outputFile = new PrintWriter(fwriter);
		
		//to format output
		DecimalFormat formatter = new DecimalFormat("#0.00");

		int i;
		for(i=0; i<countItems; i++)
			outputFile.println("     "+formatter.format(this.items[i].getCost())+"\t      "+this.items[i].getQuantity()+"  "+this.items[i].getDescription());

		
		outputFile.close();
		this.upToDate = true;
		
	}

	/**
		isUpToDate method tests whether the list is up to date
		@return upToDate Returns false if the list has been changed since the last save
	*/
	
	public boolean isUpToDate()
	{
	
		return upToDate;
	
	}
	
}//end ShoppingList class


