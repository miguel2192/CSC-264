 /******************************************************************
 * Program Name   : Skater
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This program provides the user with a GUI
 *    to input 5 scores. It then proceeds to find the final score
 *    of an olympic skater. The user can enter up to 10 Skaters.
 *    There is a clear option that allows the userto start again. It
 *    error checks for users input and provides a button to end the
 *    race.
 *
 * Methods:
 * -------
 * +main (String[] args)
 *******************************************************************/

import javax.swing.JFrame;

public class Skater
{
	 /**************************************************************
	 * Program Name   : Skater
	 * Author         : Miguel Rodriguez
	 * Date           : January 29, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This Skater class is the main class
	 *    for the Skaters and SkaterPanel class.
	 *
	 * BEGIN Skater
	 *    Creates a JFrame
	 *    Creates a JPanel
	 *    Sets the frame to visible
	 *    Disables the resize for JFrame
	 *    Calls the SkaterPanel class
	 * END Skater
	 **************************************************************/

   public static void main(String[] args)
   {

	  /********************   Start main method  *****************/

	  //initializes a frame
      JFrame frame = new JFrame("Skater's Score");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //calls the class SkaterPanel
      SkaterPanel panel = new SkaterPanel();
      frame.getContentPane().add(panel);

      //sets the frame to visible and disables resizing
      frame.pack();
      frame.setVisible(true);
      frame.setResizable(false);

   }
}

