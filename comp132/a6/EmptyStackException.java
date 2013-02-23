/**
    This class represents an exception 
    thrown by pop and peek when the stack is empty.
*/
class EmptyStackException extends RuntimeException
{
	/**
      This constructor uses a generic
      error message.
   */
   public EmptyStackException()
   {
      super("Error: Empty Stack");
   }

   /**
      This constructor specifies error message.
      @param The exception message.
   */
   public EmptyStackException(String message)
   {
      super(message);
   }    
}
