 /**********************************************************
 * Program Name   : SkaterPanel
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This class creates many different
 *    TextFields, buttons, labels, and it also implements
 *    action listeners for the button.
 *
 * Methods:
 * -------
 * +main (String[] args)
 **********************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class SkaterPanel extends JPanel
{
	/**************************************************************
	* Program Name   : Skater
	* Author         : Miguel Rodriguez
	* Date           : January 29, 2016
	* Course/Section : CSC-264 - 001
	* Program Description: This Skater class is the main class
	*    for the Skaters and SkaterPanel class.
	*
	* BEGIN SkaterPanel
	*    creates Jlabels
	*    creates JTextFields
	*    initialize local constants
	*    initialize local variables
	*    Creates a SkaterPanel constructor
	*       adds title heading to JPanel
	*       asks the use for input
	*       gets input with JTextFields
	*       sorts the array
	*       computes the sum and gets rid of lowest and highest scores
	*       sends skater's name and totalsore to Skaters class
	*    Ends skatePanel constructor
	* END SkaterPanel
	**************************************************************/


   //Local constants

   //Local variables

   //creates labels
   private JLabel inputLabel_1;
   private JLabel inputLabel_2;
   private JLabel inputLabel_3;
   private JLabel inputLabel_4;
   private JLabel inputLabel_5;
   private JLabel inputLabel_6;
   private JLabel inputLabel_11;
   private JLabel inputLabel_12;
   private JLabel inputLabel_13;

   private static int counter = 0;             //holds a counter
   private static int endCount = 0;            //holds a counter

   //creates input boxes
   private JTextField inputText_1;
   private JTextField inputText_2;
   private JTextField inputText_3;
   private JTextField inputText_4;
   private JTextField inputText_5;
   private JTextField inputText_6;
   private JTextField inputText_12;
   private Skaters skater;                    //holds an object for the Skaters class
   private JTextArea outputText;              //holds the output text

   //creates buttons
   private JButton push;
   private JButton push2;
   private JButton push3;
   private JButton push4;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------

   //***********************start SkaterPanel****************************/
   public SkaterPanel()
   {
	  //Displays the title and changes color to red
	  inputLabel_11 = new JLabel("OLYMPIC SKATERS FINAL SCORE");
	  add(inputLabel_11);
	  inputLabel_11.setForeground(Color.RED);

      //creates a subtitle
	  inputLabel_13 = new JLabel("Enter up to 10 Skaters or less");
	  add(inputLabel_13);


	  //asks the user for input
	  inputLabel_12 = new JLabel("Skater's Name:");
      inputLabel_1 =  new JLabel("Enter Score # 1:");
      inputLabel_2 =  new JLabel("Enter Score # 2:");
      inputLabel_3 =  new JLabel("Enter Score # 3:");
      inputLabel_4 =  new JLabel("Enter Score # 4:");
      inputLabel_5 =  new JLabel("Enter Score # 5:");


      //creates the label and textbox for input
	  inputText_12 =  new JTextField(9);
	  inputText_12.setText("Default Miguel");
	  inputText_12.addActionListener(new TempListener());
	  add(inputLabel_12);
      add(inputText_12);

      //creates the labels and textboxs for input
      inputText_1=  new JTextField(9);
      inputText_1.addActionListener(new TempListener());
      add(inputLabel_1);
      add(inputText_1);

      inputText_2=  new JTextField(9);
      inputText_2.addActionListener(new TempListener());
      add(inputLabel_2);
      add(inputText_2);

      inputText_3=  new JTextField(9);
      inputText_3.addActionListener(new TempListener());
      add(inputLabel_3);
      add(inputText_3);

      inputText_4=  new JTextField(9);
      inputText_4.addActionListener(new TempListener());
      add(inputLabel_4);
      add(inputText_4);

      inputText_5=  new JTextField(9);
      inputText_5.addActionListener(new TempListener());
      add(inputLabel_5);
      add(inputText_5);

      //sets the size of the window
      setPreferredSize(new Dimension(240, 460));

      //changes the background color of the window
      setBackground(Color.white);

      //creates button named compute
	  push = new JButton("Compute");
	  push.addActionListener(new TempListener());
	  add(push);

      //creates a button name clear
	  push2 = new JButton("Clear");
	  push2.addActionListener(new TempListener());
	  add(push2);

      //creates a label for output the result
	  inputLabel_6 = new JLabel("Skater's Score:");
	  inputLabel_6.setForeground(Color.RED);
	  inputText_6=  new JTextField(9);
	  inputText_6.addActionListener(new TempListener());
	  add(inputLabel_6);
      add(inputText_6);

      //creates a heading for the final output
	  push4 = new JButton("                          Name        Score");
	  push4.addActionListener(new TempListener());
	  add(push4);
	  push4.setEnabled(false);//disables end button

      //creates button named End that ends program
	  push3 = new JButton("END");
	  push3.addActionListener(new TempListener());
	  add(push3);


      //creates a JTextArea for displaying final output
	  outputText =  new JTextArea(10,2);
	  //outputText.addActionListener(new TempListener());
      add(outputText);

   }

   //*****************************************************************
   //  Represents an action listener for the temperature input field.
   //*****************************************************************
   private class TempListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Performs the conversion when the enter key is pressed in
      //  the text field.
      //--------------------------------------------------------------
      public  void actionPerformed(ActionEvent event)
      {
		  //local constants

		  //local variables
		  //holds Text for the JTextFields
		  String text1;
		  String text2;
		  String text3;
		  String text4;
		  String text5;
		  String text12;

		  //holds the integers for the JTextFields
		  int text1_temp;
		  int text2_temp;
		  int text3_temp;
		  int text4_temp;
		  int text5_temp;
		  int total_Score;     //holds total scores


          try{

			   //if compute button is press
		       if (event.getSource() == push)
               {

                  //if any of the fields is blank
		          if(inputText_1.getText().isEmpty() || inputText_2.getText().isEmpty()
		            || inputText_3.getText().isEmpty() || inputText_4.getText().isEmpty() || inputText_5.getText().isEmpty())
		          {

                     //return an error
			         inputText_6.setText("Invalid Entry!");

		          }//ends if


                  //gets the texts from JTextField and converts it to integers
                  text1 = inputText_1.getText();
                  text1_temp = Integer.parseInt(text1);

                  text2 = inputText_2.getText();
                  text2_temp = Integer.parseInt(text2);

                  text3 = inputText_3.getText();
                  text3_temp = Integer.parseInt(text3);

                  text4 = inputText_4.getText();
                  text4_temp = Integer.parseInt(text4);

                  text5 = inputText_5.getText();
                  text5_temp = Integer.parseInt(text5);

                  text12 = inputText_12.getText();


                  //puts the scores into the array
                  int score_Array[] = {text1_temp, text2_temp, text3_temp, text4_temp, text5_temp};

                  //sorting array
                  Arrays.sort(score_Array);

                  //adds scores
                  total_Score = score_Array[1] + score_Array[2] + score_Array[3];

                  //converts the integer value to a string and displays
                  inputText_6.setText(Integer.toString(total_Score));

                  //increase counter
                  counter++;


			      //if the counter is equal or greater than ten disables the compute button
			      if (counter >= 10)
			      {
				     //disables button push
				     push.setEnabled(false);

			      }//ends if

			      //if any of the fields is blank
		         if(text12.isEmpty())
		         {

                    //return error
			        inputText_6.setText("Invalid Entry!");

		         }//ends if
		         else
		         {

                    //pass the name and total to Skaters class constructor
                    skater = new Skaters(text12, total_Score);

                    //clears the JTextFields
                    inputText_1.setText("");
		            inputText_2.setText("");
		            inputText_3.setText("");
		            inputText_4.setText("");
		            inputText_5.setText("");
		            inputText_6.setText("");

                    //prints the toString
                    System.out.println(skater.toString());

		         }//ends else


		  }//ends if

          //if clear button is press clears
		  else if(event.getSource() == push2)
		  {
			  inputText_1.setText("");
			  inputText_2.setText("");
			  inputText_3.setText("");
			  inputText_4.setText("");
			  inputText_5.setText("");
			  inputText_6.setText("");
			  inputText_12.setText("");


	      }//ends else

	      else
	      {
		     try{
			      push.setEnabled(false); //disbles compute button
			      push3.setEnabled(false); //disbles end button

                  if(endCount < 1)
                  {
					 //displays toStrin()
			         outputText.setText(skater.toString());
			      }

			      //increment counter by one
                  endCount++;

			    }//ends try
			 catch (NullPointerException nfe) {

                  //displays nullPointerException
				  System.out.println("NullPointerException!");

                }//ends catch


		  }//ends else

		  }catch (NumberFormatException nfe) {

              //displays blank fields not allow
		      System.out.println("Blank fields NOT allow!");

          }//ends catch

      }
   }
}
