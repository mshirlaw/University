/**
   PizzaFrame.java

   The PizzaFrame displays a CenteredFrame
   and allows a user to order a pizza from a 
   given set of sizes, crusts and toppings

   @author mshirlaw
*/

import java.awt.*;

public class PizzaFrame extends CenteredFrame
{

    /**
       The Constructor passes the title of the
       window to the superclass constructor
       and then creates the GUI
       @param title The title of the window
    */

    public PizzaFrame(String title)
    {
	super(title);
	makeGUI(this);
    }

    /**
       The makeGUI method sets up a number of panels and adds 
       them to the main frame to make the GUI
       @param f The main frame for the GUI
    */

    public void makeGUI(Frame f)
    {	
	//set a layout for the main frame 
	//and create the fonts to be used throughout
	f.setLayout(new GridLayout(3,1));
	Font titleFont = new Font("Serif", Font.BOLD, 30);
	Font subTitle = new Font("SansSerif", Font.BOLD, 18);
	Font otherText = new Font("SansSerif", Font.ITALIC, 14);
	
	//create a panel to hold the labels and set a grid layout
	Panel labels = new Panel();
	labels.setLayout(new GridLayout(2,1));
	Label title = new Label("Welcome to the Pizza Shop", Label.CENTER);
	Label instructions = new Label("Please use the "+
				       "options below to make your "+
				       "selection and then press "+
				       "submit", Label.CENTER);
	title.setFont(titleFont);
	instructions.setFont(subTitle);
	labels.add(title); //add the title label
	labels.add(instructions); //add the instructions label

	//create a panel to hold the size checkboxes 
	//and set a grid layout for this panel
	Panel sizes = new Panel();
	sizes.setLayout(new GridLayout(5,1));
	sizes.setFont(otherText);
	Label msg1 = new Label("Choose the size "+
			       "of your pizza: ", Label.CENTER);
	CheckboxGroup grp = new CheckboxGroup();
	sizes.add(msg1);
	sizes.add(new Checkbox("Small (8 inches)", grp, true));
	sizes.add(new Checkbox("Medium (10 inches)", grp, false));
	sizes.add(new Checkbox("Large (12 inches)", grp, false));
	sizes.add(new Checkbox("Family (15 inches)", grp, false));
	
	//create a panel to hold the crust check boxes and 
	//set a grid layout
	Panel crusts = new Panel();
	crusts.setLayout(new GridLayout(4,1));
	CheckboxGroup grp2 = new CheckboxGroup();
	Label msg2 = new Label("Choose the type "+
			       "of crust for your pizza: ", Label.CENTER);
	crusts.add(msg2);
	crusts.add(new Checkbox("Thin and crispy", grp2, true));
	crusts.add(new Checkbox("Thick and tasty", grp2, false));
	crusts.add(new Checkbox("Cheese filled", grp2, false));


	//create a panel to hold the toppings and set a grid layout
	Panel toppings = new Panel();
	toppings.setLayout(new GridLayout(5,1));
	Label msg3 = new Label("Choose extra toppings: ", Label.CENTER);
	List list = new List(7);
	list.setMultipleMode(true);
	list.add("None");
	list.add("Ham");
	list.add("Cheese");
	list.add("Pineapple");
	list.add("Chicken");
	list.add("Anchovies");
	list.select(1);
	toppings.add(msg3);
	toppings.add(list);
	
	//create a center panel to hold the 
	//checkboxes, buttons and list panels
	Panel center = new Panel();
	center.setLayout(new GridLayout(1,3));
	center.setFont(otherText);
	center.add(sizes);
	center.add(crusts);
	center.add(toppings);

	//create a panel to hold the buttons and set a flow layout
	Panel buttons = new Panel();
	buttons.setLayout(new FlowLayout());
	buttons.setFont(otherText);
	Button cancelButton = new Button("Cancel");
	Button submitButton = new Button("Submit");
	buttons.add(submitButton);
	buttons.add(cancelButton);

	//add all of the individual 
	//panels to the main frame in order
	f.add(labels);
	f.add(center);
	f.add(buttons);
  
    }

    /**
       main method to create an instance of 
       the PizzaFrame and display the GUI
    */

    public static void main(String[] args)
    {
	//create an instance of the pizza frame
	PizzaFrame pFrame = new PizzaFrame("Order a Pizza");
	
	//set the background colour and make the frame visible
	pFrame.setBackground(Color.WHITE);
	pFrame.setVisible(true);
    }
}