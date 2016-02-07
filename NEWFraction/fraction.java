 /**************************************************************
 * Program Name   : fraction
 * Author         : Miguel Rodriguez
 * Date           : January 28, 2016
 * Course/Section : CSC-264 - 001
 * Program Description: This program asks the user to enter a numerator
 *    and denominator. it then outputs the fraction to three decimal places.
 *
 * Methods:
 * -------
 * Main - main(String[] args)
 **************************************************************/
import java.util.*;
import java.text.*;

public class fraction
{

    /**********************************************************
    * Method Name    : Fraction: Outputs a fraction to three decimal places
    * Author         : Miguel Rodriguez
    * Date           : January 28, 2016
    * Course/Section : CSC-264 - 001
    * Program Description: This program asks the the user to enter the
    *    numerator and denominator and then displays the fraction to
    *    three decimal places.
    *
    *  BEGIN fraction
    *     enter numerator or 0 to quit
    *     WHILE(not 0)
    *        enter denominator
    *        fraction = numerator/denominator
    *        display fraction to three decimal places and center to middle/scr
    *        Enter numerator or quit
    *     END WHILE
    *  END fraction
    **********************************************************/
public static void main(String[] args)
{

   //Local constants

   //Local variables
   float numerator;        //stores the numerator
   float denominator;      //stores the denominator
   float fraction;         //stores the fraction

   //Formats the output
   DecimalFormat fmt = new DecimalFormat("#.###");

   //creates an object to call the library class
   Library64 myLib = new Library64();

   /********************   Start main method  *****************/

   //creates a space
   System.out.println();

   //aks the user to input the numerator or 0 to quit
   System.out.print(Util.setLeft(13,"Please enter numerator or '0' to quit: "));

   //reads the input and stores it in the numerator
   numerator = Keyboard.readInt();

   //clears the screen
   myLib.clrscr();

   //the user keeps etering fractions until he enters 0
   while(numerator != 0)
      {

	  //creates a space
      System.out.println();

	  //asks the user to enter denominator or 0 to quit
	  System.out.print(Util.setLeft(13,"Please enter denominator or '0' to quit: "));

	  //reads the user input and stores it into denominator
	  denominator = Keyboard.readInt();

	  //clears the screen
      myLib.clrscr();

      //divides the numerator by the denominator and stores it in fraction
	  fraction = numerator/denominator;

      //creates two spaces
      System.out.println();
      System.out.println();

      //displays the title
      System.out.println(Util.setLeft(30,"Converted Fraction: "));

      //creates a space
      System.out.println();

      //outputs the fraction as a decimal to three decimal places
	  System.out.println(Util.setRight(42, fmt.format(fraction)));

	  //creates a space between the end of the output and the following input
	  System.out.println();

	  //asks the user to enter denominator or 0 to quit
	  System.out.print(Util.setLeft(13,"Please enter denominator or '0' to quit: "));

	  //reads the input and stores it into the numerator
	  numerator = Keyboard.readInt();

	  //clears the screen
      myLib.clrscr();

      }//ends while loop
 }//ends main method
}//ends class