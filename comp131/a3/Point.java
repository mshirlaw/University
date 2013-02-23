import java.util.Scanner;

public class Point
{
	/**This program displays the coordinates of a point and
	 * repeatedly prompts the user to enter a direction to move the point.
	 * The coordinates of the point are then updated until the point reaches a 
	 * predetermined boundary.
	 * 
	 * Input: u (up), d (down), l(left) or r(right)
	 * Output: Coordinates of a point (x,y)
	 */
	
	public static void main(String[] args)
	{
		int xCoord = 0;	//to store the x coordinate of the point
		int yCoord = 0;	//to store the y coordinate of the point
		boolean boundaryReached = false;	//set to true if the point has reached the boundary
		char direction;	//to store the direction that the point is to be moved
		String input;	//to accept a direction from the keyboard
		int moves = 0;	//to store the number of times the point has been moved
				
		//create a scanner variable to receive input
		Scanner keyboard = new Scanner(System.in); 
		
		//display the purpose of the program and the initial position of the point
		System.out.println("This program updates the position of a travelling point in a square.");
		System.out.println("Starting position of the point is ("+xCoord+","+yCoord+")");
		
		//prompt for the user to enter a direction to move the point
		System.out.print("Enter a direction for the point to move (u, d, l or r): ");
		input = keyboard.nextLine();
		direction = input.charAt(0);
				
		//update the coordinates of the point until the point reaches the boundary
		while (!boundaryReached)
		{
			if ((direction == 'u') || (direction == 'U'))
			{
				yCoord++;
				moves++;
			}
			else if (((direction == 'd') || (direction == 'D')))
			{
				yCoord--;
				moves++;	
			}
			else if (((direction == 'l') || (direction == 'L')))
			{
				xCoord--;
				moves++;	
			}
			else if (((direction == 'r') || (direction == 'R')))
			{
				xCoord++;
				moves++;
			}
			else 
			{
				System.out.println();
				System.out.println("Invalid entry, try again.");
			}
			
			//call the displayPoint method to display the coordinates of the point and
			//determine whether or not the point has reached the boundary
			boundaryReached = displayPoint(xCoord, yCoord, moves);
			
			//if the boundary has not been reached, prompt for a new direction from the user
			if (boundaryReached == false)
			{
				System.out.print("Enter a new direction (u, d, l or r): ");
				input = keyboard.nextLine();
				direction = input.charAt(0);
			}
		}
	}
	
	/**This method accepts the x and y coordinates of a point and tests whether
	 * a boundary condition has been reached. If the boundary condition has been 
	 * reached, the final coordinates of the point are printed and the 
	 * boundary variable is set to true. If the boundary condition has not
	 * been reached, the new position of the point is printed and the 
	 * boundary condition is set to false.
	 * 
	 * @param x X coordinate of the point
	 * @param y Y coordinate of the point
	 * @param m Number of times the point has been changed
	 * @return boundary A boolean flag to indicate that the boundary has been reached
	 */
	
	public static boolean displayPoint(int x, int y, int m)
	{
		final int MAX = 4;
		final int MIN = -4;
		boolean boundary = false;
		
		//test whether the x or y coordinate are equal to the boundary
		if (((x == MAX) || (x == MIN)) || ((y == MAX) || (y == MIN)))
		{
			System.out.println("The point reached the boundary at ("+x+","+y+") after "+m+" moves.");
			boundary = true; //set to true if the boundary has been reached
		}
		else
		{
			System.out.println("Position of the point is now ("+x+","+y+")");
			boundary = false; //set to false if the boundary has not been reached
		}
		return boundary; //used to determine if the boundary has been reached
	}
}

