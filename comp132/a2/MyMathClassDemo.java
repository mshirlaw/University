/*
  The MyMathClassDemo program tests the MyMathClass generic class. 
  It first creates two ArrayList objects and then calculates the standard deviation
  for each list
  @author Matthew Shirlaw
*/


import java.util.ArrayList;

public class MyMathClassDemo
{
	
    public static void main(String[] args)
    {
	
	//create two ArrayLists, one to store Integer objects and one to store Double objects
	ArrayList<Integer> integerList = new ArrayList<Integer>();
	ArrayList<Double> doubleList = new ArrayList<Double>();
	
	//store three Integer objects
	integerList.add(new Integer(1));
	integerList.add(new Integer(2));
	integerList.add(new Integer(3));
	
	//store three double objects
	doubleList.add(new Double(1.5));
	doubleList.add(new Double(3.0));
	doubleList.add(new Double(5.0));

	//create an instance of MyMathClass that accepts integer values
	MyMathClass<Integer> integerMath = new MyMathClass<Integer>();

	//create an instance of the MyMathClass that accepts double values
	MyMathClass<Double> doubleMath = new MyMathClass<Double>();

	//calculate the standard deviation for the Integer list
	System.out.println("For the Integer list, the standard deviation is "+ integerMath.calStandardDeviation(integerList));
	
	//calculate the standard deviation for the Double list
	System.out.println("For the Double list, the standard deviation is "+doubleMath.calStandardDeviation(doubleList));
	
    }
    
}
