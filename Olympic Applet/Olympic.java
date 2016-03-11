//********************************************************************
//  Olympic.java       Author: Miguel Rodriguez
//
//
//********************************************************************
import java.applet.Applet;
import java.awt.*;


public class Olympic extends Applet
{
   //-----------------------------------------------------------------
   //  Draws the Olympic logo into an applet
   //-----------------------------------------------------------------
   public void paint(Graphics page)
   {

	  //set background to gray
      setBackground(Color.white);

	  //set circle to blue
      page.setColor(Color.blue);

      //set circle dimensions and draws it
      page.drawOval(100, 65, 40, 40);

	  //set circle to black
      page.setColor(Color.black);

	  //set circle dimensions and draws it
      page.drawOval(150, 65, 40, 40);

	  //set circle to red
      page.setColor(Color.red);

	  //set circle dimensions and draws it
      page.drawOval(200, 65, 40, 40);

	  //set circle to yellow
      page.setColor(Color.yellow);

      //set circle dimesions and draws it
      page.drawOval(125, 85, 40, 40);

      //sets the color to gree
      page.setColor(Color.green);

      //sets circle dimensions and draws it
      page.drawOval(175, 85, 40, 40);


   }
}