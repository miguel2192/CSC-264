 /***************************************************************
 * Program Name   : CourseInfo
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This class will keep track of the
 *   semesters.
 *
 * Methods:
 *
 ***************************************************************/

import java.text.*;
public class CourseInfo
{


   //Local Constants

   //Local Variables
   String coPrefix;          //stores the course prefix
   int coNumber;             //stores the course number
   double coGrade;           //stores the course grade
   int cHours;               //stores the course hours
   double grPts;             //stores the grade points
   String strDisplay;        //stores a string which is outputted

   //formats the grade output to one dicimal place
   DecimalFormat fmt = new DecimalFormat("0.00");

     /**************************************************************
	 * Program Name   : CourseInfo
	 * Author         : Miguel Rodriguez
	 * Date           : February 12, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This class creates a course and computes
	 *    the total GPA of the user based on the inputs from the user.
	 *
	 * BEGIN CourseInfo
	 *    CourseInfo(coPrefix , coNumber, cHours, coGrade)
	 *       computes the grade points
	 *    returns toString
	 * END CourseInfo
	 **************************************************************/
   public CourseInfo(String coPrefix, int coNumber, int cHours, double coGrade)
   {
      this.coPrefix = coPrefix;
      this.coNumber = coNumber;
      this.cHours   = cHours;
      this.coGrade  = coGrade;

      //calculates the grade points
	  grPts = coGrade * cHours;


   }//ends the constructor

     /**************************************************************
	 * Program Name   : toString
	 * Author         : Miguel Rodriguez
	 * Date           : February 12, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This class creates a course and computes
	 *    the total GPA of the user based on the inputs from the user.
	 *
	 * BEGIN CourseInfo
	 *    CourseInfo(coPrefix , coNumber, cHours, coGrade)
	 *       computes the grade points
	 *    returns toString
	 * END CourseInfo
	 **************************************************************/
   public String toString()
   {
	  //Local Constants

	  //Local Variables

      //creates a string and stores it in strDisplay
      strDisplay = Util.setLeft(15, " " + coPrefix + coNumber + "\t" +"  " + fmt.format(coGrade) + "\t" +
                                "\t" +  cHours + "  " + "\t\t " + fmt.format(grPts));

       //returns strDisplay
       return strDisplay;

   } //ends toString method

}//ends CourseInfo class