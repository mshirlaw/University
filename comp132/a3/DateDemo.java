import java.util.StringTokenizer;
import java.util.Scanner;

public class DateDemo
{
    public static void main(String[] args) throws DayException, MonthException, YearException
    {
	String input; //to hold user inpute
	int aMonth; //to hold an integer value for a month
	int aDay;  // to hold an integer value for a day
	int aYear; //to hold an integer value for a year
	
	boolean valid = false; //used to test whether the date is a valid date
	boolean isLeapYear = false; //used to test whether the year is a leap year

	//for user input
	Scanner keyboard = new Scanner(System.in);

	//prompt the user to enter a date to parse
	System.out.println("Enter date to parse (MM/DD/YYYY format):");
	input = keyboard.nextLine();
	
	//create a StringTokenizer object to break the date up into its components
	StringTokenizer tokenizer = new StringTokenizer(input, "/");
	
	//store the first token in the string as an integer in the aMonth variable
	input = tokenizer.nextToken();
	aMonth = Integer.parseInt(input);
	
	//store the second token in the string as an integer in the aDay variable
	input = tokenizer.nextToken();
	aDay = Integer.parseInt(input);

	//store the final token in the string as an integer in the aYear variable
	input = tokenizer.nextToken();
	aYear = Integer.parseInt(input);

	//create an instance of the date class
	Date theDate = new Date();	

	//repeat the loop while ever the date is not a valid date
	while (!valid)
	    {

		try
		    {
			//test whether the year that the user entered is a leap year
			isLeapYear = theDate.leapYear(aYear);
			
			//set the month - only valid entries will be accepted otherwise a MonthException will be thrown
			theDate.setMonth(aMonth);
			
			//set the day and indicate if the year is a leap year to account for 29 days in Feb
			//only valid entries will be accepted otherwise a DayException will be thrown
			theDate.setDay(aDay, isLeapYear);

			//set the year - only valid entries will be accepted otherwise a YearException will be thrown
			theDate.setYear(aYear);
			valid = true;
		    }
		catch(YearException e)
		    {
			//catch the YearException and print an error message for the user. Prompt for 
			//the user to enter a new year
			System.out.print(e.getMessage());
			System.out.println(" Reenter a valid year: ");
			aYear = keyboard.nextInt();
		    }
		catch(MonthException e)
		    {
			//catch the MonthException and print an error message for the user. Prompt for 
			//the user to enter a new month
			System.out.print(e.getMessage());
			System.out.println(" Reenter a valid month: ");
			aMonth = keyboard.nextInt();
		    }
		catch(DayException e)
		    {
			//catch the DayException and print an error message for the user. Prompt for 
			//the user to enter a new day
			System.out.print(e.getMessage());
			System.out.println(" Reenter a valid day: ");
			aDay = keyboard.nextInt();
		    }
	    }

	//print the valid date as a string representation for the user
	System.out.println("Parsed date: "+theDate.toString());
	  
    }

}
