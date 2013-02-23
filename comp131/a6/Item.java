/**
	Assignment P6. 
	@author mshirlaw
*/

public class Item 
{
	private String description;
	private Double costPerItem; //wrapper object not primative, return a copy
	private Integer quantity; //wrapper object not primative, return a copy
	
	/**
		Constructor 
		Accepts a string literal, double and integer and
		stores them in the relevant private member objects
	*/
	
	public Item(String n, double c, int q)
	{
		this.description = n;
		this.costPerItem = new Double(c);
		this.quantity = new Integer(q);
	}
	
	/**
		getDiscription method returns the description of the item as a referece ti a String
		@return description A reference to a String descritpion of the item
	*/
	
	public String getDescription()
	{
		return this.description;
	}
	
	/**
		getCost method returns the cost of the item as a reference to a Double object 
		The copy avoids making a private member available outside of the class
		@return costPerItem A reference to a copy of the Double object which represents the cost per item
	*/
	
	public double getCost()
	{
		double theCost = this.costPerItem; //unboxing
		return theCost;
	}

	/**
		getQuantity method returns the quantity of the item as a reference to an Integer object 
		The copy avoids making a private member available outside of the class
		@return quantity A reference to a copy of the Integer object which represents the quantity
	*/
		
	public int getQuantity()
	{
		int theQuan = this.quantity; //unboxing
		return theQuan; 
	}
	
	/** 
		setDescription method accepts a string literal and sets the 
		private member filed equal to this string
		@param n A string representation of the iten description
	*/
	
	public void setDescription(String n)
	{
		this.description = n;
	}
	
	public void setCost(double c)
	{
		this.costPerItem = new Double(c);	
	}
	
	public void setQuantity(int q)
	{
		this.quantity = new Integer(q);
	}
	
}//end Item



