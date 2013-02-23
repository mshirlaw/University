/**
 * The Bird class is an abstract class that 
 * extends the Animal class. It provides method
 * signatures for the eat method and the layEgg method
 */

public abstract class Bird extends Animal
{
    
    /**
       The Constructor accepts a String 
       object which describes the habitat of a Bird and
       passes this String to the super class constructor.
    */
    
    public Bird(String hab)
    {
	super(hab);
    }

     /**
      The eat method describes the operations
      required in order for a Bird object to 
      eat
    */   

    public abstract void eat();

    /**
      The layEgg method describes the operations
      required in order for a Bird object to 
      lay an egg
    */

    public abstract void layEgg();

}