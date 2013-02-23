// ---------------------------------------------------------------------------
// LocationDemo.java - driver file for the Location class
//
// ---------------------------------------------------------------------------
import java.util.Scanner;

public class LocationDemo
{
  public static void main(String[] args)
  {

    // test the constructors
    Location Armidale = new Location(-30.42, 151.63);
    Location Timisoara = new Location(45.7366, 21.2208);
    Location AliceSpring = new Location(-23.6647, 133.9508);

    Location Equator, Southpole;
    Equator  =  new Location();
    Location  Pole = new Location(-90.0, 0.0);
    //test copy constructor
    Southpole = new Location(Pole);
    
    //create an array of Locations
    Location[] places = new Location[4];
    places[0] = Equator;           // (assignment)
    places[1] = Timisoara;         // (assignment)
    places[2] = AliceSpring;       // (assignment)
    places[3] = Southpole;         // (assignment)

    //display distances from Armidale to these places
    for(int i = 0; i < 4; i++)
    {
    	double distance = Location.distance(Armidale, places[i]);
    	System.out.println("Distance from Armidale to " + places[i] + 
                         " is " + distance + " miles.");
    }

    Scanner input = new Scanner(System.in);
    String answer;
    //prompt user for input
    System.out.print("Do you want to test more places?(y=yes, n=no) ");

    answer = input.nextLine();
    double x, y, a, b;
    Location newl;
    while (answer.charAt(0)== 'y' || answer.charAt(0) == 'Y')
    {
      //prompt user for latitude and longitude
      System.out.println("Enter a place somewhere on the earth: ");
      System.out.print("Enter Lat :");
      x = input.nextDouble();
      System.out.print("Enter Lon :");
      y = input.nextDouble();

      newl = new Location(x, y);
      //test the getters
      a = newl.getLat();
      b = newl.getLon();
      System.out.println("Your place has latitude:  " + a +
                         "  and longitude:  " + b);
      //test toString method
      System.out.println(newl);
      //test distance method
      double newdist = Location.distance(Armidale,newl);
      //test equals method
      if (Armidale.equals(newl))
        System.out.println("So, you are interested only in that place of Armidale!");
      else if (newdist < 3.0)
          System.out.println("You are still in Armidale! " + "Don't you like to travel?");
      System.out.println("Distance from Armidale to your place = " + newdist +
                         " miles");
      System.out.println("Try another place:");
      //test setters
      System.out.print("latitude = ");
      Location new2 = new Location();
      double aa, bb;
      aa = input.nextDouble();
      new2.setLat(aa);
      System.out.print("longitude = ");
      bb = input.nextDouble();
      new2.setLon(bb);
      System.out.println(new2);
      double newdist2 = Location.distance(Armidale, new2);
      if (newdist2 < 3.0)
        System.out.println("You are still in Armidale! " +
                           "Don't you like to travel?");
      System.out.println("Distance from Armidale to your new place = " +
                          newdist2);
      System.out.print("Do you want to test more places? (y=yes, n=no) ");
      //clear keyboard buffer
      input.nextLine();
      answer = input.nextLine();
    }

  }

}
