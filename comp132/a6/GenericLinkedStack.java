/**
   The GenericLinkedStack class uses a generic linked list to 
   implement a stack
*/

public class GenericLinkedStack<T>
{
    /**
       The Node class is used to implement a generic linked
       list
    */
    
    private class Node
    {
	T value;
	Node next;
	
	Node(T val, Node n)
	{
	    value = val;
	    next = n;
	}
    }

    private Node top = null; //to store top of the stack

    /**
       The isEmpty method checks whether the stack is 
       empty or not
    */
    
    public boolean isEmpty()
    {
	return top == null;
    }

    /**
       The pop method returns the value at the top of the stack
       @return retValue The value of the object at the top of the stack
       @exception EmptyStackException if the stack is empty
    */

    public T pop()
    {
	if(isEmpty())
	    throw new EmptyStackException();
	else
        {
	    T retValue = top.value;
	    top = top.next;
	    return retValue;
	}	
    }

    /**
       The puch method pushes a new item to the top of the 
       stack
       @param item The item to push to the top of the stack
    */

    public void push(T item)
    {
	top = new Node(item, top);
    }
	
    /**
       The peek method returns the value of the item at the top of 
       the stack but does not remove it
       @return The value at the top of the stack
       @exception EmptyStackException if the stack is empty
    */
    
    public T peek()
    {
	if(isEmpty())
	    throw new EmptyStackException();
	else
	    return top.value;
    }

}

