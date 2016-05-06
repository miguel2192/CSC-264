 /*******************************************************************************
 * Program Name   : SplashScreen.java
 * Author         : Luke Cavanaugh & Miguel Rodriguez
 * Date           : May 5, 2016
 * Course/Section : CSC264
 * Program Description:  A simple application to show a title screen in the
 *    center of the screen for the amount of time given in the constructor.
 *    This is the welcome screen that provides cool presentable graphics.
 *
 * Methods:
 * -------
 * +showSplash()
 * +SpashScreen(int d)
 * +ShowSplashAndExit()
 *******************************************************************************/

 import java.awt.*;
 import javax.swing.*;

public class SplashScreen extends JWindow {

  //Global constants

  //Global variables
  private int duration;              //sets the duration for the splash screen
  private  JPanel content;           //creates a panel named content
  private JLabel label, copyrt;      //creates labels
  private duckHuntPanel duckPanel;   //creates and object for duckHuntPanel class


  //******************Starts Splash Screen****************************************//


  /*******************************************************************************
  * Program Name   : SplashScreen(int d)
  * Author         : Luke Cavanaugh & Miguel Rodriguez
  * Date           : May 5, 2016
  * Course/Section : CSC264
  * Program Description:  This constructor takes the duration from the main class
  *    and assigns it to duration. The driver class is duckSniperDriver.java.
  *
  * Methods:
  * -------
  * +SplashScreen(int d)
  *
  *
  * Begin SplashScreen(int d)
  *    sets the duration to whatever value is set in driver class
  * Ends SplashScreen(int d)
  *******************************************************************************/

  public SplashScreen(int d)
  {

    //Local constants

    //Local variables

    //**************************Starts Constructor*******************************//

    //sets the duration for the splash screen
    duration = d;

  }//ends constructor




  /*******************************************************************************
  * Program Name   : showSplash()
  * Author         : Luke Cavanaugh & Miguel Rodriguez
  * Date           : May 5, 2016
  * Course/Section : CSC264
  * Program Description:  This method shows a title screen in the center
  *    of the screen for the amount of time given in the constructor
  * Methods:
  * -------
  * +showSplash()
  *
  * Begin showSplash()
  *    initialize local constants
  *    initialize local variables
  *    create a panel named content
  *    sets the background to white
  *    creates a variable width and sets it to 600
  *    creates a variable height and sets it 400
  *    gets the current resolution of the screen
  *    divides the current screens resultion by 2 (Horizontally & Vertically)
  *    sets the new horizontal resolution equal to x
  *    sets the new vertical resoltion equal to y
  *    sets the bounds of the SplashScreen (x,y,width,height)
  *    gets an image and adds it to a label
  *    creates a label named copyrt
  *    use the copyrt label to diplay information about copyright
  *    set the visibility to true
  *    creates an object named duckPanel of type duckHuntPanel
  *    calls the duckHuntPanel class
  *    sets duckHuntPanel visibility to true
  *    uses try & catch to handled errors
  * End showSplash()
  *******************************************************************************/

  public void showSplash()
  {

  //Local constants

  //Local variables
  int width;                       //holds the width of the splahScreen
  int height;                      //holds the height of the splashScreen
  int x;                           //sets the horizontal location of SplashScreen
  int y;                           //sets the vertical location of the SplashScreen


  //*********************Starts showSplash() method****************************//

  //creates a panel named content
    content = (JPanel)getContentPane();

    //sets the bakcground of the label named content to white
    content.setBackground(Color.white);

    //Set the window's bounds, centering the window
    width = 600;
    height =400;

    //gets the size current size of the screen
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    //divides the current size by two (Horizontal & Vertical)
    x = (screen.width-width)/2;
    y = (screen.height-height)/2;

    //sets the bounds of the screen
    setBounds(x,y,width,height);


    // Build the splash screen
    ImageIcon Splash =  new ImageIcon(getClass().getResource("/SplashScreen.jpg"));
    label = new JLabel(Splash);

    //adds some information about copyright in a label in the splash screen
    copyrt = new JLabel("Copyright 2016/17, Luke & Miguel", JLabel.CENTER);
    copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
    content.add(label, BorderLayout.CENTER);
    content.add(copyrt, BorderLayout.SOUTH);
    Color oraRed = new Color(156, 20, 20,  255);
    content.setBorder(BorderFactory.createLineBorder(oraRed, 10));

    // Display it
    setVisible(true);

    // Wait a little while, maybe while loading resources
    try
    {
     Thread.sleep(duration);
    }
    catch (Exception e)
    {
     //if an exception occurs
     e.printStackTrace();
    }

    //after the form finish loading set it to false
    setVisible(false);

    //creates a reference object for the duckHuntPanel class
    duckPanel = new duckHuntPanel();

    //calls the duckHuntPanel class and sets it to visible
    duckPanel.setVisible(true);
    }


 /*******************************************************************************
 * Program Name   : showSplashAndExit()
 * Author         : Luke Cavanaugh & Miguel Rodriguez
 * Date           : May 5, 2016
 * Course/Section : CSC264
 * Program Description:  This method calls the method showSplash() which runs
 *    the splash screen.
 * Methods:
 * -------
 * +showSplashAndExit()
 *
 * Begin showSplashAndExit()
 *    calls the method shoSplash wich runs the SplashScreen
 * End showSplashAndExit()
 *******************************************************************************/
 public void showSplashAndExit()
 {
   //Local constants

   //Local variables


   //**************************Starts showSplashAndExit() method***************//

   //calls the showSplash() method
   showSplash();

 }//ends showSplashAndExit method

}//ends class
