
	/**Calculate contains methods that determines the number of data 
	 * entries in a file, read the data into an array, and calculate 
	 * and return the mean, variance of a set of numbers stored in an 
	 * array.
	 *******************************************************************/

import java.io.*;
import java.util.Scanner;

public class Calculate
{	
	/**This method counts the number of lines in a data
	 * file and returns an integer value which represents the
	 * number of doubles in the file as each appear on a new line
	 * 
	 * @param f The file name
	 * @return The number of lines in the file (represents the amount
	 * of numbers in the data file)
	 * @throws IOException
	 */
	
	public static int countData(String f) throws IOException
	{
		//create a variable to count the number of lines
		int count = 0;
		
		//create a FileReader and BufferedReader object to read from the file
		File myFile = new File(f);
		Scanner inputFile = new Scanner(myFile);
		
		//loop through the file counting each line as each number appears on a new line
		while (inputFile.hasNext())
		{
			count++;
			inputFile.nextLine();		
		}
		
		//close the file
		inputFile.close();

		// return the number of lines in the file which is equal to the 	
		return count; 
	}

	/**This method accepts a file name and a reference to an
	 * array of doubles. It reads from the data file and populates the 
	 * array with the numbers in the data file 
	 * 
	 * @param f The name of the file 
	 * @param myArray Reference to an array of doubles
	 * @throws IOException
	 */
	
	public static void readData(String f, double myArray[]) throws IOException
	{
    
		String input;	// to hold lines read from the file 
		int i = 0;	    // index variable
		
		// open the file 		
		File myFile = new File(f);
		Scanner inputFile = new Scanner(myFile);
		
		// read the file contents into the array (the array still references the same array) 		
		while (inputFile.hasNext() && i < myArray.length) 
		{
			input = inputFile.nextLine();
			myArray[i] = Double.parseDouble(input); 
			i++; 
		}
		
		// close the file
		inputFile.close();
		
	}

	/**This method accepts a reference to an 
	 * array of doubles and then calculates the mean
	 * @param myArray A reference to an array of doubles
	 * @return The calculated value of the mean 
	 */
	
	public static double calMean(double myArray[])
	{
		double sum = 0; //sum of all elements in the array
		double mean = 0; //to store the mean
		int i; //an index variable
		
		//loop through the array and sum each element
		for (i=0; i<myArray.length; i++)
			sum += myArray[i];
		
		//divide the sum of each element by the number of elements
		mean = sum / myArray.length;
		
		//return the mean
		return mean;      
	}

	/**This method accepts a reference to an array of doubles and 
	 * a double value which represents the mean of the numbers in the 
	 * array. It returns the value of the variance of the numbers in the array
	 * 
	 * @param myArray A reference to an array of doubles
	 * @param mean The mean value of an array of doubles
	 * @return The variance of an array of doubles
	 */
	
	public static double calVariance(double myArray[], double mean)
	{
		double variance = 0;
		double sum = 0; //an accumulator 
		int i; //index variable
		
		//calculate series of ((x - mean) squared) for each element in the array
		for (i=0; i<myArray.length; i++)
			sum += Math.pow((myArray[i] - mean), 2);
		
		//calculate ((n-1) * series)
		variance = (Math.pow(myArray.length, -1.0)) * sum;
		
		//return the variance
		return variance;      
	}

}