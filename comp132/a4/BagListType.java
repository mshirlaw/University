import java.util.Iterator;

/**
   The BagListType is a concrete class
   for storing a list of objects as a Bag. It does recognise
   repeat values but they are only stored once.
*/

public class BagListType<E> implements BagList<E>, Iterable<E>
{

    //constants for the default capacity + resize factor
    private final int DEFAULT_CAPACITY = 10;
    private final int RESIZE_FACTOR = 2;
    
    private E[] list; //the list to hold the Bag
    private int[] counts; //the array to hold the count of each element
    private int elements; //to hold the number of elements stored
    
    /**
       The constructor creates an empty list of default capacity and
       an empty counts array of the same size
    */
    
    public BagListType()
    {
	//create a reference to an array of Objects and cast to E
	//creates a compiler warning
	list = (E[])(new Object[DEFAULT_CAPACITY]);
	elements = 0;
	
	//create a reference to an array of ints to hold the number of
	//each element
	counts = new int[DEFAULT_CAPACITY];

    }
 
   /**
       The insert method inserts an element
       into the Bag or increments the count array if it is already
       in the Bag
       @param entry The element to be inserted to the Bag
    */

    public void insert(E entry)
    {
	boolean duplicate = false;

	if(isEmpty())
	{
	    
	    //add elements to the end of the list
	    list[elements] = entry;
	    
	    //add one to the counts array
	    counts[elements] = counts[elements] + 1;

	    //adjust number of elements
	    elements++;

	}
	else 
	{
	    //if the list is full, resize it
	    if(elements == list.length)
		resize();
	    
	    //test if the element already exists, if so add one to the counts
	    //array
	    for(int i = 0; i<elements; i++)
	    {
		if(list[i].equals(entry))
		{
		    counts[i] = counts[i] +1;
		    duplicate = true;
		}
	    }
	    
	    //if not a duplicate, add the item to the end of the list
	    if(!duplicate)
	    {
		//add elements to the end of the list
		list[elements] = entry;

		//add one to the counts array
		counts[elements] = counts[elements] + 1;

		//adjust number of elements
		elements++;
	    }  

	}

    }	

    /** 
	The erase method removes a specific element from the list
	@param element The element to remove.
	@return target If the element was found, null if not found.
    */

    public E erase(E target)
    {
	int i=0; //to count the index
	boolean found = false; //flag for searching the array

	//perform a sequential search of the array and remove the 
	//element at target after it is found
	while(!found && i< elements)
	{
	    if(list[i].equals(target))
	    {
		list[i] = null;
		counts[i] = 0;
		found = true;
	    }
	    i++;
	}

	//if found == true, shift elements to the front of the array
	//and return target
	if(found)
	{
	    while(i< elements)
	    {
		//shift elements in the list and count array
		list[i-1] = list[i];
		counts[i-1] = counts[i];
	    }

	    //decrement number of elements by one
	    elements--;
	    
	    //return target
	    return target;
	}
	else
	    //if not found return null
	    return null;
    }

   /** 
       Search the list for a specified element and count all
       occurances of that element
       @param target The element to search for.
       @return theCount The number if occurances of the element
   */

    public int count(E target)
    {
	int theCount = 0;
	int index = 0; //index counter to loop through array

	//step through the list. When target is found increment theCount
	while(index< elements)
	{
	    if(list[index].equals(target))
	    {
		theCount = theCount + counts[index];
	    }
	    index++;
	}
    	return theCount;
    }

   /** 
       Iterate through the list sequentially and set all elements to null
       and all items in the counts array to zero
   */

    public void clear()
    {
	//set each element in the list equal to null
	for (int i = 0; i<elements; i++)
        {
	    list[i] = null;
	    counts[i] = 0;
	}
	
	//set elements = 0
	elements = 0;
    }

    /** 
	The isEmpty method tests whether elements == 0
	@return true If the list is empty, false if the list contains at least 
	one element
    */
    
    public boolean isEmpty()
    {
	
	if (elements == 0)
	    return true;
	else
	    return false;
    }

    /**
       The capacity method returns the current capacity of the 
       Bag
       @return the capacity of the Bag
    */

    public int capacity()
    {
  	return list.length;
    }

    /** 
	The size method determines the number of elements in the list
	@return The number of elements in the list.
    */

    public int size()
    {
	return elements;
    }

    /** 
	The get method returns the element at a specified index
	@param index The index of the element to return.
	@return The element stored at the index.
	@exception IndexOutOtBoundsException When index
	is out of bounds.     
    */
    
    public E get(int index)
    {
	if(index>= elements || index <0)
	    throw new IndexOutOfBoundsException();
	else
	    return list[index];
    }
   /** 
	The getCounts method returns the count of an element at a 
	specified index
	@param index The index of the element to return.
	@return The count of the element stored at the index.
	@exception IndexOutOtBoundsException When index
	is out of bounds.     
    */
    
    public int getCounts(int index)
    {
	if(index>= elements || index <0)
	    throw new IndexOutOfBoundsException();
	else
	    return counts[index];
    }

    /** 
	The remove method removes an element at a specific index
	@param index The index of the element to remove.
	@return The element that was removed.
	@exception IndexOutOtBoundsException When index
	is out of bounds.
    */
    
    public E remove(int index)
    {
	if(index>= elements || index <0)
	    throw new IndexOutOfBoundsException();
	
	//save the element 
	E theObject = list[index];
	
	//remove the element
	list[index] = null;
	counts[index] = 0;
	index++;

	//shift elements to forward one element
	while(index< elements)
	{
	    list[index-1] = list[index];
	    counts[index-1] = counts[index];
	    index++;
	}

	//adjust number of elements
	elements--;
	
	return theObject;

    }


    /** 
	Resizes the list to twice its current length and the 
	counts array to twice its current length
    */
    
    private void resize()
    {
	//calculate new length
	int newLength = list.length * RESIZE_FACTOR;

	//create a new list of newLength 
	//this causes a compiler error but is necessary
	E[] tempList = (E[])(new Object[newLength]);
	int[] tempCounts = new int[newLength];

	//copy existing elements into new list
	for (int i = 0; i<elements; i++)
	    tempList[i] = list[i];

	//replace list and counts arrays with the larger arrays
	list = tempList;
	counts = tempCounts;
	
    }

    /** 
	The erase_one method removes an occurance of an element at 
	a specific index
	@param index The index of the element to remove.
	@return The element that was removed.
	@exception IndexOutOtBoundsException When index
	is out of bounds.
    */

    public boolean erase_one(E target)
    {
	int index = 0;
	boolean erased = false;

	if(index>= elements || index <0)
	    throw new IndexOutOfBoundsException();
	
	//step through the list. When target is found, decrement the 
	//appropriate index of the counts array. If the occurances goes 
	//to zero or below, remove the element
	while(index< elements && !erased)
        {
	    if(list[index].equals(target))
	    {
		erased = true;
		counts[index] = counts[index] - 1;

		if (counts[index] <= 0)
		{
		    remove(index);
	        }
	    }
	    index++;
	}
	
	return erased;
    }
    
    public BagTypeIterator<E> iterator()
    {
	return new BagTypeIterator<E>(this);
    }
	

}

