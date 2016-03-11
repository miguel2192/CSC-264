/**********************************************************
 * Program Name   : Program Template - Calculate Average
 * Author         : Professor Scheemaker
 * Date           : February 01, 2001
 * Course/Section : CSC111 - 02
 * Program Description: This program will act as a template for all
 *    CSC111 programmin assingments.
 *
 * Methods:
 * -------
 * Main - calculates the average of 2 quiz grades
 *
 **********************************************************/


public class Template264
{


   /**********************************************************
    * Method Name    : Lab01 - Calculate Average
    * Author         : Professor Scheemaker
    * Date           : February 01, 2001
    * Course/Section : CSC111 - 02
    * Program Description: This method will calculate the of two quiz
    *    grades.  The grades will be input from the keyboard.  The
    *    program will then sum the grades and calculate the average.
    *    Finally, the average will be displayed on the screen.
    *    If either grade is invalid it will display an error message
    *    instead.
    *
    * BEGIN Calc Average
    *    Prompt user for first quiz grade
    *    Prompt user for second quiz grade
    *    IF (either grade is not in range)
    *        Display error message
    *    ELSE
    *        Calculate quiz grade average
    *        Display quiz grade average
    *    END IF
    * END Calc Average
    **********************************************************/

   public static void main (String [] args)
   {
      //local constants
      final int NUM_QUIZZES = 2;
      final int MAX_GRADE   = 100;

      //local variables
      int quizGrade1;      //first qiz grade input by user
      int quizGrade2;      //second quiz grade input by user
      float avgGrade;      //average of the quiz grades

	  Library myLib = new Library();

      /********************   Start main method  *****************/

      //prompt user for first quiz grade
      System.out.print("Enter Quiz Grade 1: ");
      quizGrade1 = Keyboard.readInt();

      //prompt user for second quiz grade
      System.out.print("Enter Quiz Grade 2: ");
      quizGrade2 = Keyboard.readInt();

      //clear the screen
      myLib.clrscr();

      //if either grade is invalid
      if (quizGrade1 > MAX_GRADE || quizGrade2 > MAX_GRADE)

         //display error message
         System.out.println("\n\n\n\t\t\tERROR: Invalid Quiz Grade\n\n\n\n");

      //else grades were both valid
      else
      {

		  //calculate the average of the three grades
		  avgGrade = ((float) quizGrade1 + quizGrade2) / NUM_QUIZZES;

		  //display the quiz average
		  System.out.println();
		  System.out.println("\n\n\n\n\t\t\t\tAverage = " + avgGrade);
		  System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
	  }

      //pause the screen - just a comment to show what the pause screen command looks like.
      //myLib.pause();

   } //end main method

} //end Template264

