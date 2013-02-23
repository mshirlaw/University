/**
   The Date class stores the day, month and year of a date. 
   It contains methods to set the date, return the componenets of the date,
   return the date as a string and check if it is a leap year.
   @author Matthew Shirlaw
*/
  
public class Date
{

    private final int DAYS_IN_LONG = 31; //to store the number of days in a long month
    private final int DAYS_IN_SHORT = 30; //to store the number of days in a short month
    private final int DAYS_IN_FEB = 28; //to store the number of days in Feb in a non leap year


    private int day;
    private int month;
    private int year;
 
    /**
       The constructor initialises the date to an arbitrary 
       date of 1 January 1900. 
    */

    public Date()
    {
	day = 1;
	month = 1;
	year = 1900;
    }


    /**
       The setDay method accepts an integer value for a day and a
       boolean value which is True if the year is a leap year. It then tests if the day 
       is a valid day given the month and whether or not the year is a leap year. If so, the day is set.
       Call this method after the setMonth method.
       @param aDay The day to be set
       @param leapYear True if the year is a leap year
       @throws DayException If the day is not vaild
    */

    public void setDay(int aDay, boolean leapYear) throws DayException
    {

	if (this.month == 2)
	    {
		if (leapYear)
		    {
			if (aDay<1 || aDay>DAYS_IN_FEB+1)
			    throw new DayException("Invalid day.");
			else
			    this.day = aDay;
		    }
		else
		    {
			if (aDay<1 || aDay>DAYS_IN_FEB)
			    throw new DayException("Invalid day.");
			else
			    this.day = aDay;
		    }
	    }
	else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
	    {
    		if (aDay<1 || aDay>DAYS_IN_SHORT)
		    throw new DayException("Invalid day.");
		else
		    this.day = aDay;
	    }
	else
	    {
		if (aDay<1 || aDay>DAYS_IN_LONG)
		    throw new DayException("Invalid day.");
		else
		    this.day = aDay;
	    }
    }
    
    
    /**
       The setMonth method accepts an integer value for 
       the month and tests if it falls within the appropriate range
       (1-12). If it does not, a MonthException is generated. If the
       month is valid, the month field is set.
       @param aMonth The month to be set
       @throws MonthException If the month does not fall within the range 1-12
    */
    
    
    public void setMonth(int aMonth) throws MonthException
    {
	if (aMonth<1 || aMonth>12)
	    throw new MonthException("Invalid month.");
	else 
	    this.month = aMonth;
	
    }
    
    /**
       The setYear method accepts an integer value for 
       the year and tests if it falls within the appropriate range
       (1000-3000). If it does not, a YearException is generated. If the
       year is valid, the year field is set.
       @param aYear The year to be set
       @throws YearException If the year does not fall within the range 1000-3000
    */
    
    
    public void setYear(int aYear) throws YearException
    {
	if (aYear<1000 || aYear>3000)
	    throw new YearException("Invalid year.");
	else 
	    this.year = aYear;
	
    }

    /**
       The getDay method returns the integer value for the day
       @return day The integer value for the day
    */
    
    public int getDay()
    {
	return this.day;
    }

    /**
       The getMonth method returns the integer value for the month
       @return month The integer value for the month
    */
    
    public int getMonth()
    {
	return this.month;
    }

    /**
       The getYear method returns the integer value for the year
       @return year The integer value for the year
    */
    
    public int getYear()
    {
	return this.year;
    }

    /**
       The leapYear method test whether a given year is a leap year.
       @return leap True if the year is a leap year
    */
    
    public boolean leapYear(int aYear)
    {
	boolean leap = false;
	
        if (aYear % 4 == 0) //test if the year is divisible by 4
	    leap = true;
	else if (aYear % 100 == 0 && aYear % 400 == 0) //test if the year is divisible by 100 and 400
	    leap = true;
	else
	    return leap;
	
	return leap;
	
    }

    /**
       The toString method returns the date as a string in the form
       December 14, 1999
    */

    public String toString()
    {
	String monthName = "";

	switch (this.month)
	    {
	    case 1:
		monthName = "January";
		break;
	    case 2:
		monthName = "February";
		break;	
	    case 3:
		monthName = "March";
		break;	
	    case 4:
		monthName = "April";
		break;	
	    case 5:
		monthName = "May";
		break;	
	    case 6:
		monthName = "June";
		break;	
	    case 7:
		monthName = "July";
		break;	
	    case 8:
		monthName = "August";
		break;	
	    case 9:
		monthName = "September";
		break;	
	    case 10:
		monthName = "October";
		break;	
	    case 11:
		monthName = "November";
		break;	
	    case 12:
		monthName = "December";
		break;	
	    default:
		monthName = "Invalid Month";
		break;
	    }
	
	return monthName+" "+this.day+", "+this.year;
    }

}