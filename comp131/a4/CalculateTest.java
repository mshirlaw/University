	/** Assignment_P4 reads a set of real numbers from a file and
	 * stores them in an array of type double.
	 * The program then calculates and displays the mean, variance, and 
	 * standard deviation of these real numbers.
	 * 
	 * Input:   a set of real numbers
	 * Output:  mean, variance, standard deviation
	 ******************************************************************/

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class CalculateTest
{
   public static void main(String[] args) throws IOException
   {
	   String fileName;	//holds the name of the data file
	   int dataNumbers; //variable to store the number of numbers in the data file
	   double theMean; //to hold the mean
	   double theVariance; //to hold the variance
	   double standardDeviation; //to hold the standard deviation
	   double[] theArray;  //to hold the numbers
	   
	   //create a scanner object to read from the keyboard
	   Scanner keyboard = new Scanner(System.in);
	   
	   //prompt for the name of the data file
	   System.out.print("Enter the name of the data file: ");
	   fileName = keyboard.nextLine();
	   
	   //pass the file name to the countData method of the Calculate class
	   dataNumbers = Calculate.countData(fileName);
	   
	   if (dataNumbers <= 1)
	   {
		   System.out.println();
		   System.out.println("The file "+fileName+ " needs to contain more than 1 number.");
	   }
	   else
	   {
		   //create an array to store the numbers in the file
		   theArray = new double[dataNumbers];
	  
		   //read the array and fill it
		   Calculate.readData(fileName, theArray);
	   
		   //calculate the mean
		   theMean = Calculate.calMean(theArray);
	   
		   //calculate the variance
		   theVariance = Calculate.calVariance(theArray, theMean);
	   
		   //calculate the standard deviation
		   standardDeviation = Math.pow(theVariance, 0.5);
	   
		   //create a decimal format object to format to four decimal places
		   DecimalFormat formatter = new DecimalFormat("#0.0000");
	   
		   //print results
		   System.out.println();
		   System.out.println("Mean is: "+(formatter.format(theMean)));
		   System.out.println("Variance is: "+(formatter.format(theVariance)));
		   System.out.println("Std is: "+(formatter.format(standardDeviation)));	   
	   }
   }
}

