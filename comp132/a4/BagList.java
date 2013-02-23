/**
   The BagList interface specifies the general operations 
   that are supported by the BagList type
*/

public interface BagList<E> extends SetList<E>
{

    /**
       The erase_one method erases one occurance of
       an element from the Bag
       @param target The element to be erased from the Bag
       @return The element that is erased from the Bag
    */

    public boolean erase_one(E target);
}
