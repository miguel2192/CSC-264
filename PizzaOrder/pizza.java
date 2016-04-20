//********************************************************************
//  pizza.java
//
//  Author: Miguel Rodriguez
//********************************************************************

import javax.swing.JFrame;

public class pizza
{
   //-----------------------------------------------------------------
   //  Creates and displays the style options frame.
   //-----------------------------------------------------------------
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Pizza Options");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new pizzaPanel());

      frame.pack();
      frame.setVisible(true);
      frame.setResizable(false);

   }
}

