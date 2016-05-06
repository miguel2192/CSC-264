/*******************************************************************************
* Program Name   : QDuckGame.java
* Author         : Luke Cavanaugh & Miguel Rodriguez
* Date           : May 5, 2016
* Course/Section : CSC264
* Program Description:  This class is encharge of running the game.
*    It accomplishes this by calling the QDuckPanel.java class.
*
* Methods:
* -------
* +main(String[] args)
*
*
* Begin QDuckGame
*    Initialize Global constants
*    Initialize Global variables
*    Initialize Local constants
*    Initialize Local variables
*    create integer variables xsize & ysize
*    creates a frame and sets the title "DuckSniper"
*    makes sures the frame fully closes when X in press
*    sets the decoration equal to false
*    calls the pack() method
*    sets the frame always ontop
*    makes the frame un-resizeble
*    sets the frame's visbility equal to true
*    gets the current size of the screen
*    stores the horizontal size in xsize & vertial in ysize
*    sets the bounds of the frame equal to screen size
*    calls QDuckPanel and adds it to the frame
*    sets the frame location equal to null(centers the frame in center of screen)
*    creates an object to call duckHuntPanel.java
* Ends QDuckGame
*******************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QDuckGame
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------

   //Global constants

   //Global variables
   private static JFrame frame;    //a JFrame variable


   public static void main(String[] args)
   {

    //Local constants

    //Local variables
    int xsize;                   //holds the horizontal screen size
    int ysize;                   //holds the vertical screen size


    //*******************Starts Main****************************************/


    //creates a frame and sets the title to "DuckSniper"
      frame = new JFrame("DuckSniper");

      //makes that the application is fully close
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //makes truly fullscreen by removing all decorations
      frame.setUndecorated(true);

      //calls the pack() method
      frame.pack();

      //sets the frame always on top
      frame.setAlwaysOnTop(true);

      //disables the option to rezise
      frame.setResizable(false);

      //sets the frame to visible
      frame.setVisible(true);

      //gets the current size of the screen
      Toolkit tk = Toolkit.getDefaultToolkit();

      //sets the horizontal size of the screen equal to xsize
      xsize = (int) tk.getScreenSize().getWidth();

      //sets the vertical size of the screen equal to ysize
      ysize = (int) tk.getScreenSize().getHeight();

      //sets the horizontal & vertical size of the frame equal to the size of the screen
      frame.setBounds(400,400,xsize, ysize);

      //calls and adds the QDuckPanel class
      frame.getContentPane().add(new QDuckPanel());

      //sets the location to null(Places the frame in the center of the screen)
      frame.setLocationRelativeTo(null);


      //object to call the duckHuntPanel class
      duckHuntPanel ui = new duckHuntPanel();

   }//ends main

   /*******************************************************************************
   * Program Name   : hidePanel()
   * Author         : Luke Cavanaugh & Miguel Rodriguez
   * Date           : May 5, 2016
   * Course/Section : CSC264
   * Program Description:  This method hides the game when it is called.
   *
   * Methods:
   * -------
   * +main(String[] args)
   *
   *
   * Begin hidePanel()
   *    Hides the game whe it is call by making the frame invisible
   * Ends hidePanel()
   *******************************************************************************/

   public void hidePanel()
   {

    //**************Starts hidePanel()******************************************//

      //sets the frame visibility equal to false
      frame.setVisible(false);

      //prints a statement to make sure that the method was call
      System.out.println("hide panel called!");

   }//ends hide

}//ends class