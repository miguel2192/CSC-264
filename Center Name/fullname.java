/**********************************************************************
 * Program Name   : fullname
 * Author         : Miguel Rodriguez
 * Date           : January 28, 2016
 * Course/Section : CSC-264 - 001
 * Program Description: This program asks the user to enter his/hers
 *    fullname and then displays it and center it in the middle of the
 *    the screen.
 *
 * Methods:
 * -------
 * Main - main(String[] args)
 *
 *********************************************************************/
import java.util.*;

public class fullname
{

  /*******************************************************************
    * Method Name    : Full Name: Outputs the fullname and centers it
    * Author         : Miguel Rodriguez
    * Date           : January 23, 2016
    * Course/Section : CSC-264 - 001
    * Program Description: This program asks the the user to enter the
    *    first name and then the last last name and then it displays
    *    and centers the full name in the middle of the screen.
    *
    *  BEGIN fullname
    *     enter firstname
    *     enter lastname
    *     fullname = "firstname + lastname"
    *     center fullname in the middle of the screen
    *  END Name
    ******************************************************************/
public static void main(String[] args)
 {

   //Local constants

   //Local variables
   String fname;    //stores the first name
   String lname;    //stores the last name
   String flname;   //stores the fullname

   //creates an object to call the library class
   Library64 myLib = new Library64();

   /********************   Start main method  *****************/

   //adds an space
   System.out.println();

   //asks the user to enter the firstname
   System.out.print(Util.setLeft(28,"Please enter firstname: "));
   //reads the input and stores it into fname
   fname = Keyboard.readString();

   //asks the user to enter the lastname
   System.out.print(Util.setLeft(28,"Please enter lastname : "));
   //reads the input and stores it into lname
   lname = Keyboard.readString();

   //calls the method clrscr located in the library class
   myLib.clrscr();

   //adds the two strings and creates the fullname
   flname = fname + " " + lname;

   //creates a space between lines
   System.out.println();
   System.out.println();

   //prints out the fullname and centers it to the middle of screen
   System.out.println(Util.setRight(32, flname));

   //creates a space between the output and the press any key line
   System.out.println();

 }//ends main method
}//ends class fullname