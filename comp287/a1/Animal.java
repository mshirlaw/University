/**
 * The Animal class is an abstract class that describes the 
 * typical behaviour of an animal object. Each Animal object must 
 * have a habitat and implement the eat method.
*/

public abstract class Animal
{
    /**
       The habitat instance variable provides
       a String representation of an Animal's habitat
    */

   private String habitat;
 
    /**
       The Constructor accepts a String 
       object which describes the habitat of an Animal.
    */     
    
    public Animal(String hab)
    {
	habitat = hab;
    }
 
    /**
       The eat method describes the operations
       required in order for an Animal object to 
       eat
    */        
    
    public abstract void eat();
}
