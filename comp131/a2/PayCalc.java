import java.util.Scanner;
import java.text.DecimalFormat;

public class PayCalc 
{

	/** This program asks a user to enter the number of
	 * hours worked and the number of dependents and then
	 * calculates an employee's projected yearly gross salary.
	 * It also uses superannuation, income tax,
	 * medicare payments and payments for child support
	 * to calculate weekly take home pay
	 * 
	 * Input: 	The number of hours worked and 
	 * 			The number of dependents 
	 * Output:	Projected yearly gross salary
	 * 			Superannuation contributions
	 * 			Weekly income tax
	 * 			Medicare levy
	 * 			Child support
	 * 			Weekly take home pay
	 *********************************************************/
	
	public static void main(String[] args) 
	{

		// declare final constants
		final double SALARY_SACRIFICE = 100;	//stores amount of salary sacrifice	
		final double SUPER_RATE = 0.09;			//stores employer contribution rate
		final double MEDICARE_RATE = 0.015;		//stores medicare levy rate
		final double HOURLY_RATE = 15.50;		//stores hourly rate of pay
		final double CHILD_SUPPORT = 50.0;		//stores child support per child
		
		// declare variables
		double hoursWorked;						//number of hours worked in a week
		double dependents;						//number of dependent children
		double employerSuper;					//employer superannuation contribution
		double grossWeeklyPay;					//gross weekly pay
		double adjustedGrossWeeklyPay;			//gross weekly pay less salary sacrifice
		double assessableIncome;				//to hold assessable income
		double medicareLevy;					//contribution to medicare
		double annualAdjustedGrossSalary;		//projected annual adjusted gross salary for a year
		double yearlyTax;						//forecast amount of tax payable for a year
		double weeklyTax;						//tax payable per week
		double weeklyTakeHome;					//take home pay per week
		
		//create scanner for keyboard entry		
		Scanner keyboard = new Scanner(System.in);
		
		//allows formatting of output
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		//prompt for number of hours worked
		System.out.print("Enter the number of hours worked: ");
		hoursWorked = keyboard.nextDouble();
		
		//prompt for number of dependents
		System.out.print("Enter the number of dependents\t: ");
		dependents = keyboard.nextDouble();
		
		//calculate grossPay
		if (hoursWorked > 38)
			grossWeeklyPay = (( hoursWorked - 38.0 ) * HOURLY_RATE * 1.5) + ( 38.0 * HOURLY_RATE);
		else
			grossWeeklyPay = hoursWorked * HOURLY_RATE;
	
		//calculate adjustedGrossPay
		adjustedGrossWeeklyPay = grossWeeklyPay - SALARY_SACRIFICE;

		//calculate medicare levy
		medicareLevy = MEDICARE_RATE * grossWeeklyPay;
		
		//calculate projected annual adjusted pay over 52 weeks
		annualAdjustedGrossSalary = adjustedGrossWeeklyPay * 52.0;

		//calculate yearly income tax payable based on annual adjusted pay
		if (annualAdjustedGrossSalary <= 6000)
			yearlyTax = 0;
		else if ((annualAdjustedGrossSalary > 6000) && (annualAdjustedGrossSalary <= 25000))
			yearlyTax = (annualAdjustedGrossSalary-6000)*0.15;
		else if ((annualAdjustedGrossSalary > 25000) && (annualAdjustedGrossSalary <= 75000))
			yearlyTax = ((annualAdjustedGrossSalary-25000)*0.30) + 2850.00;
		else if ((annualAdjustedGrossSalary > 75000) && (annualAdjustedGrossSalary <= 150000))
			yearlyTax = ((annualAdjustedGrossSalary-75000)*0.40) + 2850.00 + 15000.0;
		else
			yearlyTax = ((annualAdjustedGrossSalary-150000)*0.45) + 2850.0 + 15000.0 + 30000.0;

		//calculate weekly income tax
		weeklyTax = yearlyTax / 52.0;

		//calculate weekly assessable income. In this case. Same as adjusted adjustedGrossWeeklyPay
		assessableIncome = grossWeeklyPay - SALARY_SACRIFICE; 	
		
		//calculate weekly take home pay
		weeklyTakeHome = assessableIncome - weeklyTax - medicareLevy - (dependents * CHILD_SUPPORT);

		//calculate employer super contribution
		employerSuper = SUPER_RATE * grossWeeklyPay;
		
		System.out.println();
		System.out.println("Worker's projected yearly gross salary\t: "+ formatter.format(annualAdjustedGrossSalary));
		System.out.println();
		System.out.println("Superannuation Contribution");
		System.out.println("Employer contribution\t\t\t: "+ formatter.format(employerSuper));
		System.out.println("Employee contribution\t\t\t: "+ formatter.format(SALARY_SACRIFICE));
		System.out.println();
		System.out.println("Worker's weekly assessable income\t: "+ formatter.format(assessableIncome));
		System.out.println("Weekly income tax\t\t\t: "+ formatter.format(weeklyTax));
		System.out.println("Medicare levy\t\t\t\t: "+ formatter.format(medicareLevy));
		System.out.println("Child support contribution\t\t: "+ formatter.format(dependents * CHILD_SUPPORT));
		System.out.println("\t\t\t\t\t: =======");
		System.out.println("Take home pay\t\t\t\t: "+ formatter.format(weeklyTakeHome));
	}
}
