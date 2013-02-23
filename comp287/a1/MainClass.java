public class MainClass
{
    public static void main(String[] args)
    {
	try
	{
	    Sparrow spar = new Sparrow("Habitat");
	    System.out.println("Successfully created a Sparrow");
	    System.out.println("Also created a Bird and Animal as super");


	    Mammal mam = new Mammal("Habitat");
	    System.out.println("Successfully created a Mammal");

	    Cat cat = new Cat("Habitat");
	    System.out.println("Successfully created a Cat");

	    Emu em = new Emu("Habitat");
	    System.out.println("Successfully created a Emu");

	    Bat bat = new Bat("Habitat");
	    System.out.println("Successfully created a Bat");

	}
	catch(Exception e)
	{
	    System.out.println(e.getMessage());
	}
    }

}