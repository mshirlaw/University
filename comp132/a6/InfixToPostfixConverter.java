import java.util.Scanner;

/**
   The InfixToPostfixConverter class is ued to convert a
   mathematical expression from infix notation to postfix notation
*/

public class InfixToPostfixConverter
{
    /**
       The convertToPostfix method accepts a mathematical expression in
       infix format and converts it to postfix format
       @param infix The mathematical expression in infix notation
       @return postfix The mathematical expression in postfix notation
    */

    public static StringBuffer convertToPostfix(StringBuffer infix)
    {

	//create a StringBuffer object for the postfix notation
	StringBuffer postfix = new StringBuffer();

	//create a GenericLinkedStack to hold Character objects
	GenericLinkedStack<Character> theStack = new GenericLinkedStack<Character>();

	//push a left parenthesis onto the stack
	theStack.push(new Character('('));

	//append a right parenthesis to the end of infix
	infix.append(')');
	
	while(!theStack.isEmpty())
	{
     
	    for(int i = 0; i<infix.length(); i++)
	    {
		//autobox the current character to allow use of isDigit() wrapper method
		Character currentChar = new Character(infix.charAt(i));
		
		//convert to postfix
		if(Character.isDigit(currentChar))
		    postfix.append(infix.charAt(i));
		else if(infix.charAt(i) == '(')
		    theStack.push(infix.charAt(i));
		else if(isOperator(infix.charAt(i)))
		{
		    //pop operators if they are equal or higher precedence than the current operator 
		    while(isOperator(theStack.peek()) && precedence(infix.charAt(i), theStack.peek()))
		    {
			postfix.append(theStack.pop());
		    }
		    //push the current character to the stack
		    theStack.push(infix.charAt(i));
		}
		else if(infix.charAt(i) == ')')
		{
		    //pop operators from the top of the stack and append them to postfix until a 
		    //parenthesis is reached
		    while(theStack.peek() != '(')
		    {
			postfix.append(theStack.pop());
		    }
		    //pop and discard the left parenthesis
		    theStack.pop();
		}    
		
	    }
	}
	
	return postfix;
	
    }

    /**
       The isOperator method tests whether the parameter
       passed to the method is a valid mathematical operator
       @return true if the character is a mathematical operator, 
       false otherwise
    */

    public static boolean isOperator(char c)
    {
	if(c == '+' || c == '-') //addition or subtraction operator
	    return true;
	else if(c == '*' || c== '/') //multiply or divide operator
	    return true;
	else if(c=='^' || c=='%') //exponentiation or remainder operator
	    return true;
	else
	    return false;
    }

    /**
       The precedence method determines whether the precedence of 
       an operator is less than, equal to or greater than and operator on
       the stack
       @param operator1 The operator from the infix notation to test
       @param operator2 The operator from the stack to test against
       @return true if operator1 has a lower precedence than operator2,
       false otherwise
    */

    public static boolean precedence(char operator1, char operator2)
    {
	int op1Precedence = 0;
	int op2Precedence = 0;

	//assign operator1 precedence an integer value from 1-3
	if(operator1 == '+' || operator1 == '-')
	    op1Precedence = 1;
	else if(operator1 == '*' || operator1 == '/' || operator1 == '%')
	    op1Precedence = 2;
	else if(operator1 == '^')
	    op1Precedence = 3;
	
	//assign operator2 precedence an integer value from 1-3
	if(operator2 == '+' || operator2 == '-')
	    op2Precedence = 1;
	else if(operator2 == '*' || operator2 == '/' || operator2 == '%')
	    op2Precedence = 2;
	else if(operator2 == '^')
	    op2Precedence = 3;

	//compare precedence of operator1 and operator2
	if(op1Precedence < op2Precedence)
	    return true;
	else
	    return false;
    } 

    /**
       The main method asks for user inut and then calls the 
       convertToPostfix() method to convert a mathematical expression from 
       infix notation to postfix notation
    */

    public static void main(String[] args)
    {
	//create a Scanner object for user input
	Scanner keyboard = new Scanner(System.in);
	String input;

	//prompt the user to enter an infix expression
	System.out.println("Please enter an infix expression:");
	input = keyboard.nextLine();

	//create a StringBuffer object and pass the infix expression to the constructor
	StringBuffer infix = new StringBuffer(input);
	
	//display the original infix expression
	System.out.println("\nThe original infix expression is: ");
	System.out.println(infix);
	
	try
	{	
	    //display the expression using postfix notation
	    System.out.println("The expression in postfix notation is:");
	    System.out.println(convertToPostfix(infix));
	}
	catch(EmptyStackException e)
	{
	    System.out.println("Stack error: "+e.getMessage());
	} 
    }
}


