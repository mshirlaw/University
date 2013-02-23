public class DayException extends Exception
{
    /**
       This constructor uses a generic error message.
    */
    
    public DayException()
    {
	super("Error: Invalid Day");
    }
    
    /**
       The constructor accepts a String which 
       represents the error message and calls the
       super class constructor with the given message.
    */
       
    public DayException(String message)
    {
	super(message);
    }	
}