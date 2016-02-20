
 /***************************************************************
 * Program Name   : CourseInfo
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This class creates a course and computes
 *    the total GPA of the user based on the inputs from the user.
 *
 * Methods:
 *
 ***************************************************************/
 import java.text.*;
public class SemesterInfo
{


	 //Class contants
     final int COUR_MAX      = 7;

	 //Class variables
	 private float sGpa;
	 private String sTerm;
	 private int tlHours;
	 private float grPts;
	 private int courseCount;
	 private String semDisplay;

     //creates the array with the fixed size of 7
     CourseInfo[] courses = new CourseInfo[COUR_MAX];





     /**************************************************************
	 * Program Name   : Semester Info
	 * Author         : Miguel Rodriguez
	 * Date           : February 12, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This class creates a course and computes
	 *    the total GPA of the user based on the inputs from the user.
	 *
	 * BEGIN semesterInfo
	 *    initialize the instance data
	 * END semesterInfo
	 **************************************************************/
	 public SemesterInfo(String semTerm)
	 {
		  //local constants

		  //local variables

      	  /********************   Start constructor method  *****************/

          //creates a semester
		  sTerm       = semTerm;
		  sGpa        = 0;
		  tlHours     = 0;
		  grPts       = 0;
		  courseCount = 0;



	 }//ends the constructor


	 /**************************************************************
	 * Program Name   : add courses
	 * Author         : Miguel Rodriguez
	 * Date           : February 12, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This method adds the courses to the array,
	 *.   it checks for duplicates and it keeps track of the array size.
	 *
	 * BEGIN addCourses
	 *    IF(courseCount less than array size)
	 *       add course to array
	 *       increase the course count
	 *    ELSE
	 *       Display "The array is full"
	 *    END IF
	 * END addCourses
	 **************************************************************/

     public void addCourses(CourseInfo course)
     {
		 //Local Constants

		 //Local Variables


         //checks to see if array is full
		 if(courseCount < courses.length)
		 {
			 //adds the courses to the array
			 courses[courseCount] = course;

			 tlHours += course.cHours;
			 grPts   += course.grPts;
			 sGpa     = grPts / tlHours;

             //increases the course count
			 courseCount++;

		 }//ends if
		 else
		 {
             //if the array reached its maximum
			 System.out.println("You have reach the maximum amount of courses");

		 }//ends else


     }//ends add courses


     /**************************************************************
	 * Program Name   : add courses
	 * Author         : Miguel Rodriguez
	 * Date           : February 12, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This method adds the courses to the array,
	 *.   it checks for duplicates and it keeps track of the array size.
	 *
	 * BEGIN addCourses
	 *    IF(courseCount less than array size)
	 *       add course to array
	 *       increase the course count
	 *    ELSE
	 *       Display "The array is full"
	 *    END IF
	 * END addCourses
	 **************************************************************/
     public String toString()
     {
		 //Local Constants

		 //Local Variables
         DecimalFormat fmt = new DecimalFormat("0.00");

        //creates a string and stores it in strDisplay
		semDisplay = Util.setLeft(14, sTerm) + "\n";
		semDisplay += Util.setLeft(15, " Name \t" + " Grade \t" + " Credit Hours \t" + "  Grade Points \t") + "\n";



       for(int i = 0; i<courseCount; i++)
       {
		   semDisplay += courses[i].toString() + "\n";
	   }

	   semDisplay += "\n";

	   //semDisplay += Util.setLeft(15, " Total Hours \t" + " Total Grade Points \t" + " Semester GPA") + "\n";

	   semDisplay += Util.setLeft(16,"ttlCrHrs  : " +tlHours ) + Util.setLeft(3,"ttlGrdPts : " +
	                              fmt.format(grPts) + Util.setLeft(4,"GPA: "+ fmt.format(sGpa)));

	   //semDisplay += Util.setLeft(16,"ttlGrdPts : " + fmt.format(grPts));
	   //semDisplay += Util.setLeft(16,"GPA: "+ fmt.format(sGpa));

	   //returns strDisplay
       return semDisplay;

     }//ends toString method


}