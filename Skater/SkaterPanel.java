//********************************************************************
//  FahrenheitPanel.java       Java Foundations
//
//  Demonstrates the use of text fields.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;

public class SkaterPanel extends JPanel
{

   //Local variables
   private JLabel inputLabel_1;
   private JLabel inputLabel_2;
   private JLabel inputLabel_3;
   private JLabel inputLabel_4;
   private JLabel inputLabel_5;
   private JLabel inputLabel_6;
   private JLabel inputLabel_11;


   private JTextField inputText_1;
   private JTextField inputText_2;
   private JTextField inputText_3;
   private JTextField inputText_4;
   private JTextField inputText_5;
   private JTextField inputText_6;

   private JButton push;
   private JButton push2;

   //-----------------------------------------------------------------
   //  Constructor: Sets up the main GUI components.
   //-----------------------------------------------------------------
   public SkaterPanel()
   {
	  //asks the user for input
	  inputLabel_11 = new JLabel("Olympic Skaters Final Score");
      inputLabel_1 = new JLabel("Enter Score # 1:");
      inputLabel_2 = new JLabel("Enter Score # 2:");
      inputLabel_3 = new JLabel("Enter Score # 3:");
      inputLabel_4 = new JLabel("Enter Score # 5:");
      inputLabel_5 = new JLabel("Enter Score # 5:");


      add(inputLabel_11);


      //creates the label and textbox for input
      inputText_1=  new JTextField(5);
      inputText_1.addActionListener(new TempListener());
      add(inputLabel_1);
      add(inputText_1);

      inputText_2=  new JTextField(5);
      inputText_2.addActionListener(new TempListener());
      add(inputLabel_2);
      add(inputText_2);

      inputText_3=  new JTextField(5);
      inputText_3.addActionListener(new TempListener());
      add(inputLabel_3);
      add(inputText_3);

      inputText_4=  new JTextField(5);
      inputText_4.addActionListener(new TempListener());
      add(inputLabel_4);
      add(inputText_4);

      inputText_5=  new JTextField(5);
      inputText_5.addActionListener(new TempListener());
      add(inputLabel_5);
      add(inputText_5);

      //sets the size of the window
      setPreferredSize(new Dimension(225, 210));

      //changes the color of the window
      setBackground(Color.white);

      //creates button named compute
	  push = new JButton("Compute");
	  push.addActionListener(new TempListener());
	  add(push);

      //creates a button name clear
	  push2 = new JButton("Clear");
	  push2.addActionListener(new TempListener());
	  add(push2);

	  inputLabel_6 = new JLabel("Skater's Score:");
	  inputText_6=  new JTextField(5);
	  inputText_6.addActionListener(new TempListener());
	  add(inputLabel_6);
      add(inputText_6);

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
      public void actionPerformed(ActionEvent event)
      {
		  //local constants

		  //local variables
		  String text1;
		  String text2;
		  String text3;
		  String text4;
		  String text5;
		  int text1_temp;
		  int text2_temp;
		  int text3_temp;
		  int text4_temp;
		  int text5_temp;
		  int total_Score;
		  //int[] score_Array = new int[5];

		  if (event.getSource() == push)
          {

		  if(inputText_1.getText().isEmpty() || inputText_2.getText().isEmpty() || inputText_3.getText().isEmpty() || inputText_4.getText().isEmpty() || inputText_5.getText().isEmpty())
		  {
			  JOptionPane.showMessageDialog(null, "Please enter a valid number!");
		  }//ends if

         //gets the texts and conver'ts it to an integer
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




         int score_Array[] = {text1_temp, text2_temp, text3_temp, text4_temp, text5_temp};

         // sorting array
         Arrays.sort(score_Array);

         for(int i = 0; i < score_Array.length; i++)
         {
            System.out.println(score_Array[i]);
	     }

         System.out.println(text1_temp);

         total_Score = score_Array[1] + score_Array[2] + score_Array[3];

         inputText_6.setText(Integer.toString(total_Score));



		  }//ends if
		  else
		  {
			  inputText_1.setText("");
			  inputText_2.setText("");
			  inputText_3.setText("");
			  inputText_4.setText("");
			  inputText_5.setText("");
			  inputText_6.setText("");

	      }//ends else


      }
   }


}
