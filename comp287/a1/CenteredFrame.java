/**
   CenteredFrame.java
*/

import java.awt.*;
import java.awt.event.*;
public class CenteredFrame extends Frame 
{
    public CenteredFrame(String title)
    {
	super(title);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	int screenH = d.height;
        int screenW = d.width;
        setSize(screenW/2, screenH/2);
        setLocation(screenW/4, screenH/4);
	
	addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent we){
		    CenteredFrame.this.dispose();
		}
	    });
	
    }
    
    public static void main(String[] args) 
    {
	CenteredFrame f = new CenteredFrame("CenteredFrame");
	f.setVisible(true);
    }
}