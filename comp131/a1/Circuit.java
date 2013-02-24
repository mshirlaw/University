/** Circuit.java computes the equivalent resistance, electrical current and
*	power dissipated by a circuit. It also calculates voltage values at 
*	two points in the circuit, v1 and v2.
*
* Input: The voltage (volts) and four resistor values (Ohms) for a circuit
* Output: Equivalent resistance (Ohms), electrical current (Amps),
* power dissipated (Watts) and voltage (Volts).
* 
* Program written by mshirlaw
**************************************************************************/
import java.util.Scanner;

public class Circuit
{
	public static void main(String[] args)
	{
		double voltage; 	//to hold the voltage in Volts
		double resistor1; 	//to hold the value of resistor 1 in Ohms
		double resistor2; 	//to hold the value of resistor 2 in Ohms
		double resistor3; 	//to hold the value of resistor 3 in Ohms
		double resistor4; 	//to hold the value of resistor 4 in Ohms
		double r5; 			//to hold the value of parallel resistor r5 in Ohms
		double r6; 			//to hold the value of parallel resistor r6 in Ohms
		double req; 		//to hold the value of equivalent resistance in Ohms
		double iTotal; 		//to hold the value of electrical current in Amps
		double p; 			//to hold the value of power dissipated in Watts
		double v1, v2; 		//to hold two values for voltage in Volts
		
		//create a scanner variable to receive input from the keyboard
		Scanner keyboard = new Scanner(System.in);
		
		//prompt for user input and store values in appropriate variables
		System.out.print("Enter voltage (in Volts): ");
		voltage = keyboard.nextDouble();
		
		System.out.print("Enter Resistor1 value (in ohms): ");
		resistor1 = keyboard.nextDouble();
		
		System.out.print("Enter Resistor2 value (in ohms): ");
		resistor2 = keyboard.nextDouble();
		
		System.out.print("Enter Resistor3 value (in ohms): ");
		resistor3 = keyboard.nextDouble();
		
		System.out.print("Enter Resistor4 value (in ohms): ");
		resistor4 = keyboard.nextDouble();
	
		//compute values for r5 and r6
		r5 = (resistor1 + resistor3); 
		r6 = (resistor2 + resistor4);
		
		//compute values for req, iTotal and p
		req = 1 / (( 1/r5) + (1/r6));
		iTotal = voltage / req;
		p = (Math.pow(iTotal, 2)) * req;
		
		//compute values for v1 and v2
		v1 = voltage * (resistor3 / (resistor1 + resistor3));
		v2 = voltage * (resistor4 / (resistor2 + resistor4));
		
		//print values to the screen
		System.out.println(" ");
		System.out.println("Req = "+req+" Ohms");
		System.out.println(" ");
		System.out.println("I Total = "+iTotal+" Amps");	
		System.out.println(" ");
		System.out.println("Total power dissipated is: "+p+" Watts");
		System.out.println(" ");
		System.out.println("Voltage at V1 is: "+v1+" Volts");
		System.out.println("Voltage at V2 is: "+v2+" Volts");		
	}
}