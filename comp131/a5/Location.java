/**
   This class stores a location given a 
   set of latitude and longitude coordinates  
   @author mshirlaw
*/

public class Location 
{
    private final static double DEG2RAD = (StrictMath.PI / 180); //sets DEG2RAD constant
    private double lat; //to hold a latitude value
    private double lon; //to hold a longitude value
    
    
    /**
       The no arg constructor
       Sets both longitude and latitude equal to zero
    */
    
    public Location()
    {
	this.lat = 0.0;
	this.lon = 0.0;
    }
    
    
    /**
       Constructor accepts double values for latitude and longitude
       @param lati A double value to represent latitude 
       @param longi A double value to represent longitude
    */
    
    public Location(double lati, double longi)
    {
	this.lat = lati;
	this.lon = longi;
    }
    
    /**
       Copy constructor accepts a Location object and copies it
       @param object2 The Location object to be copied
    */
    
    public Location(Location object2)
    {
	this.lat = object2.lat;
	this.lon = object2.lon;
    }
    
    /**
       Mutator method to set the latitude
       @param lati The latitude value which is to be set
    */
    
    public void setLat(double lati)
    {
	this.lat = lati;
    }
    
    /**
       Mutator method to set the longitude
       @param longi The longitude value which is to be set
    */
    
    public void setLon(double longi)
    {
	this.lon = longi;
    }
    
    /**
       Accessor method to access the latitude
       @return The latitude coordinate for the location
    */
    
    public double getLat()
    {
	return this.lat;
    }
    
    /**
       Accessor method to access the longitude
       @return The longitude coordinate for the location
    */
    
    public double getLon()
    {
	return this.lon;
    }
    
    /**
       To string method to return the coordinates of the 
       location as a string
    */
    
    public String toString()
    {
	return "Location: ["+lat+", "+lon+"]";
    }
    
    /**
       Equals method to test whether the location is equal to 
       a second location
       @param object2 The coordinates of a second location
       @return True if the coordinates are the same and False if they are different
    */
    
    public boolean equals(Location object2)
    {
	boolean isEqual = false;
	
	if ((this.lat == object2.lat) && (this.lon == object2.lon))
	    isEqual = true;
	
	return isEqual;
    }
    
    /**
       Static method to compute the distance between two locations
       @param l1 Location one
       @param l2 Location two
       @return Distance between the locations
    */
    
    public static double distance(Location l1, Location l2)
    {
	double dist;		
	double temp;
	
	//stores the latitude and longitude for location 1 in degrees
	double lat1 = l1.getLat();
	double lon1 = l1.getLon();
	
	//stores the latitude and longitude for location 2 in degrees
	double lat2 = l2.getLat();
	double lon2 = l2.getLon();
	
	//applies the formula to calculate the distance between two points 
	//making sure to convert each latitude and longitude value from degrees to radians
	//have used StrictMath to ensure greater accuracy and to match example output    
	temp =  StrictMath.sin(lat1 * DEG2RAD) * StrictMath.sin(lat2 * DEG2RAD) + StrictMath.cos(lat1 * DEG2RAD) * StrictMath.cos(lat2 * DEG2RAD) * StrictMath.cos((lon2-lon1) * DEG2RAD);
	dist = 60.0 * StrictMath.acos(temp) / DEG2RAD;
	
	return dist;
    }
}
