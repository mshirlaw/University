import java.util.Iterator;
import java.util.NoSuchElementException;

/**
   An iterator class for the BagList class
*/

public class BagTypeIterator<E> implements Iterator<E>
{

    private BagList<E> list; //the Bag to iterate over
    private int previous; //the previous element
    boolean canRemove; //a flag to manage removals
    
    /**
       Constructor 
       @param aList The Bag to iterate over
    */

    public BagTypeIterator(BagList<E> aList)
    {
	//save the reference to the Bag
	list = aList;

	//postition the iterator just before the first element
	previous = -1;
	
	//initialise the canRemove field to false as the remove method
	//can only be called after the next method is called
	canRemove = false;

    }

    /**
       The hasNext method determines whether another element 
       can be returned by a call to next. 
       @return true if the iterator has more elements
    */

    public boolean hasNext()
    {
	//(previous + 1) is the element returned by a call to next
	if ((previous + 1) < list.size())
	    return true;
	else 
	    return false;
    }

    /**
       The next method returns the next element in the
       Bag
       @return The next element in the Bag
       @exception NoSuchElementException if there are no more elements
    */

    public E next()
    {
	//throw an exception if there are no more elements
	if (!hasNext())
	    throw new NoSuchElementException();
	
	//increment previous to get the next element
	previous++;

	//set canRemove to true
	canRemove = true;

	//return the element which was just iterated over
	return list.get(previous);
    }

    /**
       The remove method removes from the Bag the last element
       that was returned by the next method
       @exception IllegalStateException if the remove method has been called 
       before the next method

    */

    public void remove()
    {
	//test whether the next method has been called
	if (!canRemove)
	    throw new IllegalStateException();

	//remove the previous element
	list.remove(previous);

	//adjust previous 
	previous--;
	
	//reset the canRemove field
	canRemove = false;

    }

}