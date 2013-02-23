/**
   The SetList interface specifies the general operations 
   that are supported by the SetList type
*/

public interface SetList<E>
{

    /**
       The insert method inserts an element
       into the Set
       @param entry The element to be inserted to the Set
    */

    public void insert(E entry);
   
    /**
       The erase method erases an element from the Set
       @param target The element to be erased from the Set
       @return The element that is erased from the Set
    */

    public E erase(E target);

    /**
       The count method returns the number of occurances of a
       particular element  in the Set
       @param target The element to be counted
       @return The number of occurances of the given element
    */

    public int count(E target);

    /**
       The clear method clears all elements in the Set
    */

    public void clear();

    /**
       The isEmpty method determines if the Set is empty or not
       @return true if the Set is empty and false if the Set is not empty
    */

    public boolean isEmpty();

    /**
       The capacity method returns the capacity of the Set
       @return The current capacity of the Set
    */

    public int capacity();
    
    /**
       The size method returns the size of the Set
       @return The current size of the Set
    */

    public int size();

    /**
       The get method gets an element at a specific index
       @param index The index of the element to be returned
       @return The element at the given index
    */

    public E get(int index);

    /**
       The remove method removes an element at a specific index
       @param index  The index of the element to be removed
       @return The element that was removed
    */

    public E remove(int index);

}

