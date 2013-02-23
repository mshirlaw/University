public class YearException extends Exception
{
    
    /**
       This constructor uses a generic error  message.
    */
    
    public YearException()
    {
	super("Error: Invalid Month");
    }
    
    /**
       The constructor accepts a String which 
       represents the error message and calls the
       super class constructor with the given message.
    */
    
    public YearException(String message)
    {
	super(message);
    }
    
}
