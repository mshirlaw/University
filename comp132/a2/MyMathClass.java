/*
  The MyMathClass is a generic class that calculates the standard
  deviation and the mean for the objects stored in an ArrayList of objcts
  which are a subclass of Number>
*/
 
import java.util.ArrayList;

public class MyMathClass<T extends Number>
{

    /**
      The calStandardDeviation method accepts an ArrayList<T>
      and calculates the standard deviation of the objects which are 
      stored in the ArrayList
      @param theListArray An ArrayList of objects which are a subclass of Number
      @return stdDeviation The standard deviation of the objects in the ArrayList
    */

	public double calStandardDeviation(ArrayList<T> theListArray)
	{
   
	    double stdDeviation;
	    double variance;
	    double mean;
	    double sum = 0; //accumulator used in calculating the variance
	    	    
	    mean = this.calMean(theListArray);

	    //sum (element - mean) for each object in the ArrayList
	    for (int i = 0; i<theListArray.size(); i++)
		sum += (Math.pow((theListArray.get(i).doubleValue() - mean),2));
	    
	    //calculate the variance
	    variance = sum / (theListArray.size()-1);
	    
	    //calculate standard deviation by taking the square root of the variance
	    stdDeviation = Math.pow(variance, 0.5);

	    return stdDeviation;
	
	}

    /**
      The calMean method accepts an ArrayList<T> and calculates themean
      of the objects which are stored in the ArrayList
      @param theListArray An ArrayList of objects which are a subclass of Number
      @return mean The mean of the objects in the ArrayList
    */

	public double calMean(ArrayList<T> theListArray)
	{
	    double mean;
	    double sum = 0; //accumulator used in calculating the mean

	    //sum each object in the ArrayList
	    for (int i = 0; i<theListArray.size(); i++)
		sum += (theListArray.get(i).doubleValue());
	    
	    //calculate mean
	    mean = sum / theListArray.size();
	    
	    return mean;
	}
	

}
