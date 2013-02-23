public class MonthException extends Exception
{
    /**
       This constructor uses a generic error  message.
    */
       
    public MonthException()
    {
	super("Error: Invalid Month");
    }

    /**
       The constructor accepts a String which 
       represents the error message and calls the
       super class constructor with the given message.
    */
       
    public MonthException(String message)
    {
	super(message);
    }
}