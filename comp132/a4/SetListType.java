import java.util.Iterator;

/**
   The SetListType is a concrete class
   for storing a list of objects as a Set. It does not
   allow repeat values.
*/

public class SetListType<E> implements SetList<E>, Iterable<E>
{

    //constants for the default capacity + resize factor
    private final int DEFAULT_CAPACITY = 10;
    private final int RESIZE_FACTOR = 2;
    
    private E[] list; //the list to hold the Set
    private int elements; //to hold the number of elements stored
    
    /**
       The constructor creates an empty list of default capacity
    */
    
    public SetListType()
    {
	//create a reference to an array of Objects and cast to E
	//creates a compiler warning
	list = (E[])(new Object[DEFAULT_CAPACITY]);
	elements = 0;
    }
 
   /**
       The insert method inserts an element
       into the Set only if it is not already in the Set
       @param entry The element to be inserted to the Set
    */

    public void insert(E entry)
    {
	if(count(entry) == 0)
	{
	    //if the list is full, resize it
	    if(elements == list.length)
		resize();
	    
	    //add elements to the end of the list
	    list[elements] = entry;

	    //adjust number of elements
	    elements++;

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
		//shift elements
		list[i-1] = list[i];
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
	int theCount = 0; //number of occurances of target
	int index = 0; //index counter to loop through array

	//step through the list. When target is found increment theCount
	while(index< elements)
        {
	    if(list[index].equals(target))
		theCount++;
	    index++;
	}
	return theCount;
    }

   /** 
       Iterate through the list sequentially and set all elements to null
   */

    public void clear()
    {
	//set each element in the list equal to null
	for (int i = 0; i<elements; i++)
	    list[i] = null;
	
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
	index++;

	//shift elements to forward one element
	while(index< elements)
	{
	    list[index-1] = list[index];
	    index++;
	}

	//adjust number of elements
	elements--;
	
	return theObject;

    }

    /** 
	Resizes the list to twice its current length. 
    */
    
    private void resize()
    {
	//calculate new length
	int newLength = list.length * RESIZE_FACTOR;

	//create a new list of newLength 
	//this causes a compiler error but is necessary
	E[] tempList = (E[])(new Object[newLength]);

	//copy existing elements into new list
	for (int i = 0; i<elements; i++)
	    tempList[i] = list[i];

	//replace list with the new list
	list = tempList;
	
    }

    /**
       The iterator method allows us to iterate over the list
       @return An iterator object
    */

    public SetTypeIterator<E> iterator()
    {
	return new SetTypeIterator<E>(this);
    }
	
}

