//********************************************************************
//  pizzaPanel.java
//
//  Autor: Miguel Rodriguez
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pizzaPanel extends JPanel
{
   private JLabel pepMes, cheMes , bacMes, menu, toppings, sizes, pepp, chees, bac,sm, med, larg, totall, total, say,say1,say2;
   private JCheckBox pepperoni, cheese, bacon;
   private JRadioButton small, medium, large;
   private String smallMes, mediumMes, largeMes;
   private JLabel quote, totalOut;
   private JButton push;
   private JLabel inputLabel;

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and some check boxes that
   //  control the style of the label's font.
   //-----------------------------------------------------------------
   public pizzaPanel()
   {

	  //uses JLabels to output the title & menu
	  menu = new JLabel("       MENU                           ");
      menu.setFont(new Font("Helvetica", Font.BOLD, 25));
      add(menu);

      toppings = new JLabel("              Toppings            ");
	  toppings.setFont(new Font("Helvetica", Font.BOLD, 20));
      add(toppings);

      pepp = new JLabel("               Pepperoni......$2.00  ");
	  pepp.setFont(new Font("Helvetica", Font.PLAIN, 15));
      add(pepp);

      chees = new JLabel("               Cheese.........$3.00  ");
	  chees.setFont(new Font("Helvetica", Font.PLAIN, 15));
      add(chees);

      bac = new JLabel("                Bacon...........$4.00  ");
	  bac.setFont(new Font("Helvetica", Font.PLAIN, 15));
      add(bac);

      sizes = new JLabel("               Sizes                   ");
	  sizes.setFont(new Font("Helvetica", Font.BOLD, 20));
      add(sizes);

      sm = new JLabel("               Small.............$5.00  ");
	  sm.setFont(new Font("Helvetica", Font.PLAIN, 15));
	  add(sm);

	  med = new JLabel("               Medium.........$5.00  ");
	  med.setFont(new Font("Helvetica", Font.PLAIN, 15));
	  add(med);

	  larg = new JLabel("               Large ...........$5.00  ");
	  larg.setFont(new Font("Helvetica", Font.PLAIN, 15));
      add(larg);

      pepMes = new JLabel("Pepperoni");
      pepMes.setFont(new Font("Helvetica", Font.PLAIN, 12));

      cheMes = new JLabel("Cheese");
      cheMes.setFont(new Font("Helvetica", Font.PLAIN, 12));

      bacMes = new JLabel("Bacon");
      bacMes.setFont(new Font("Helvetica", Font.PLAIN, 12));


      //prints blank spaces when checkboxes a un-selected
      say = new JLabel("         ");
	  say.setFont(new Font("Helvetica", Font.PLAIN, 12));

	  say1 = new JLabel("      ");
	  say1.setFont(new Font("Helvetica", Font.PLAIN, 12));

	  say2 = new JLabel("     ");
      say2.setFont(new Font("Helvetica", Font.PLAIN, 12));


      //creates checkboxes for the toppings
      pepperoni = new JCheckBox("Pepperoni");
      pepperoni.setBackground(Color.cyan);

      cheese = new JCheckBox("Cheese");
      cheese.setBackground(Color.cyan);

      bacon = new JCheckBox("Bacon");
      bacon.setBackground(Color.cyan);

      //adds the checkboxes to a listener
	  checkListener listener = new checkListener();
      pepperoni.addItemListener(listener);
      cheese.addItemListener(listener);
      bacon.addItemListener(listener);

      //adds checkboxes to the JFrame
      add(pepperoni);
      add(cheese);
      add(bacon);


     //messages for the radioButtons
     smallMes = " Small Pizza";
	 mediumMes = " Medium Pizza";
	 largeMes = " Large Pizza";

	 quote = new JLabel(smallMes);
     quote.setFont(new Font("Helvetica", Font.BOLD, 12));

     //creates the radio buttons
     small = new JRadioButton("Small", true);
	 small.setBackground(Color.cyan);
	 medium = new JRadioButton("Medium");
	 medium.setBackground(Color.cyan);
	 large = new JRadioButton("Large");
	 large.setBackground(Color.cyan);

     //adds the buttons to a group
	 ButtonGroup group = new ButtonGroup();
	 group.add(small);
	 group.add(medium);
     group.add(large);

     //adds the buttons to a listener
     buttonListener listener2 = new buttonListener();
	 small.addActionListener(listener2);
	 medium.addActionListener(listener2);
     large.addActionListener(listener2);

     //adds the buttons to JFrame
     add(small);
	 add(medium);
     add(large);
     add(quote);

     //adds the toppings to JFrame
     add(pepMes);
	 add(cheMes);
     add(bacMes);

     //adds the black sayings to JFrame
     add(say);
	 add(say1);
     add(say2);

     //########################buttons###########################################//
      //creates button named compute
	 // push = new JButton("     Orde Pizza     ");
	  //push.addActionListener(new TempListener());
	  //add(push);
     //####################buttons###########################################//

     //displays total amount
     totall = new JLabel("      Total Amount: ");
     totall.setFont(new Font("Helvetica", Font.BOLD, 20));
     add(totall);

     total = new JLabel();
	 total.setFont(new Font("Helvetica", Font.BOLD, 20));
     add(total);

     totalOut = new JLabel();
     totalOut.setFont(new Font("Helvetica", Font.BOLD, 20));
     add(totalOut);


     //sets the background color and size
     setBackground(Color.cyan);
     setPreferredSize(new Dimension(260, 450));
   }

   //*****************************************************************
   //  Represents the listener for multiple checkboxes
   //*****************************************************************
   private class checkListener implements ItemListener
   {
      //--------------------------------------------------------------
      //  Logic for the checkboxes.
      //--------------------------------------------------------------


      //Local constants

      //Local variables
       int toppng;        //holds the total amount
	   int pepe;          //holds the a value for the pepperoni
	   int chee;          //holds the value for the cheese
       int bac;           //holds the value for the vacon

      public void itemStateChanged(ItemEvent event)
      {


         if (pepperoni.isSelected())
         {

            pepMes.setVisible(true);
            pepe = 2;


		}
         else
         {
            pepMes.setVisible(false);
            say.setVisible(true);
            pepe = 0;
		}


         if (cheese.isSelected())
         {

            cheMes.setVisible(true);
            chee = 3;

		 }
		else
		 {
			cheMes.setVisible(false);
			say1.setVisible(true);
			chee = 0;
		}
       if (bacon.isSelected())
        {

            bacMes.setVisible(true);
            bac = 4;


		}
	   else
		{
			bacMes.setVisible(false);
			say2.setVisible(true);
			bac = 0;
		}


        //computes the total for the pizza order
		toppng = pepe + chee + bac + 5;

        //displays the final amount to the user
        totalOut.setText(Integer.toString(toppng));

      }
   }

   //*****************************************************************
      //  Represents the listener for all radio buttons
      //*****************************************************************
      private class buttonListener implements ActionListener
      {
         //--------------------------------------------------------------
         //  Sets the text of the label depending on which radio
         //  button was pressed.
         //--------------------------------------------------------------
         public void actionPerformed(ActionEvent event)
         {
            Object source = event.getSource();

            if (source == small)
               quote.setText(smallMes);
            else if (source == medium)
               quote.setText(mediumMes);
            else
               quote.setText(largeMes);
         }
   }//ends wuoteListener

      //*****************************************************************
      //  Represents an action listener for the temperature input field.
      //*****************************************************************
     /* private class TempListener implements ActionListener
      {
         //--------------------------------------------------------------
         //  Performs the conversion when the enter key is pressed in
         //  the text field.
         //--------------------------------------------------------------
         public  void actionPerformed(ActionEvent event)
      {
	  }
  }*/


}
