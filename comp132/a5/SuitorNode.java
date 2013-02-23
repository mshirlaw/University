/**
   This class provides the foundation for a 
   circular linked list
   @author Matthew Shirlaw
*/

public class SuitorNode
{
    private class Node
    {
	int value; //to store the suitor number
	Node next; //to hold a reference to the successor node in the list

	/**
	   Constructor 1
	   @param val The value to store in the linked list
	   @param n The reference to the successor
	*/

	Node(int val, Node n)
	{
	    value = val;
	    next = n;
	}
	
	/**
	   Constructor 2 
	   This constructor simply calls
	   the sister constructor
	   @param val A value to add to the linked list
	*/

	Node(int val)
	{
	    this(val, null);
	}

    }//end of private class

    //private members for the SuitorNode class
    private Node first; //to keep track of the first item in the list
    private Node last;  //to keep track of the last item in the list

    /**
       Constructor
    */

    public SuitorNode()
    {
	first = null;
	last = null;
    }

    /**
       The isEmpty method tests whether the 
       linked list is empty
       @return true if the linked list is empty, false otherwise
    */

    public boolean isEmpty()
    {
	return first == null;
    }

    /**
       The size method returns the length of the linked list
       @return count The number of elements in the list
    */
    
    public int size()
    {
	int count = 0;
	Node p = first;
	while(p.next != first)
	{
	    count++; //increment count
	    p=p.next; //traverse the linked list
	}
	return count;
    }

    /**
       The add method adds an element to the end of the list
       @param val The value to add to the end of the list
    */

    public void add(int val)
    {
	if(isEmpty())
	{
	    //add the value to first
	    first = new Node(val);
	    
	    //the first element is also the last element
	    last = first;
	    
	    //set successor of last to first to complete circle
	    last.next = first;
	}
	else
	{
	    //add value to end of the existing list
	    last.next = new Node(val);
	    
	    //the new element becomes the last element
	    last = last.next;
	    
	    //set successor of last to first to complete the circle
	    last.next = first;
	}

    }

    /**
       The remove method removes an element.
       @param element The element to remove
       @return true if the remove was successful, false otherwise
    */

    public boolean remove(int element)
    {
	if(isEmpty())
	    return false;
	
	if(element == first.value)
	{
	    //remove the first item in the list
	    first = first.next;
	    
	    //check if first is now empty
	    if(first == null)
		last = null;
	    else
		//set the successor of last to first
		last.next = first;	
	    
	    return true;   
	}

	//find predecessor of the element to remove
	//start at first item in the list
	Node pred = first;

	while(pred.next != null && !(pred.next.value == element))
	{
	    pred = pred.next;
	}

	//check if pred.next == null - the element is not in the list
	if(pred.next == null)
	{
	    return false;
	}

	//pred.next.value must be the element we are looking for
	//route pred.next past the next element
	pred.next = pred.next.next;

	//check if pred.next now points back to the start of the list
	//if so, pred is now the last element
	if(pred.next == first)
	{
	    last = pred;
	}

	return true;
    }

    /**
       The printList method prints the list to stdout
       and is primarily used for debugging the program
    */

    public void printList()
    {
	Node p = first;
	while(p.next != first)
	{
	    System.out.print(p.value+" ");
	    p=p.next;
	}
	System.out.print(p.value);
    }

    /**
       The reduceList method calls the recursive version of the 
       reduceList method to reduce the list down to one suitor
    */

    public int reduceList()
    {
	return reduceList(first);
    }

    /**
       The recursive version of the reduceList method
       uses recursion to reduce the list down to one suitor by 
       removing every third element
       @param list The list to reduce to one element
    */

    public int reduceList(Node list)
    { 
	//for debugging
	//printList();

	//base case
	if(size()==0)
	{
	    return list.value;
	}
	else
	{
	    //move through the list two places
	    Node p = list.next.next;
	    
	    //for debugging
	    //System.out.print(" -> Start counting from "+list.value); 
	    //System.out.println(". Suitor "+p.value+" to be eliminated. ");
	    
	    //remove the element at the current position
	    remove(p.value);
	    
	    //call the reduce method again with the tail until 
	    //the list is reduced to one element
	    return reduceList(p.next);
	}
    }
}
