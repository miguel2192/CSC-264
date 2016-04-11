 /**********************************************************
 * Program Name   : gpaManager
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This program provides the user with a GUI
 *    to input 5 scores. It then proceeds to find the final score
 *    of an olympic skater. There is a clear option that allows the user
 *    to start again. it also error checks for valid inputs.
 *
 * Methods:
 * -------
 * +main (String[] args)
 **********************************************************/

//********************************************************************
//  Fahrenheit.java       Java Foundations
//
//  Demonstrates the use of text fields.
//********************************************************************

import javax.swing.JFrame;

public class Skater
{
   //-----------------------------------------------------------------
   //  Creates and displays the temperature converter GUI.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
	  //initializes a frame
      JFrame frame = new JFrame("Skater's Score");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      SkaterPanel panel = new SkaterPanel();
      frame.getContentPane().add(panel);

      frame.pack();
      frame.setVisible(true);
   }
}

