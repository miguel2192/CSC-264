/**********************************************************
 * Program Name   : gpaManager
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This program provides with many options
 *    so users can manage courses and compute the GPA.
 *
 * Methods:
 * -------
 * +main (String[] args)
 **********************************************************/

public class gpaManager
{
	 /**************************************************************
	 * Program Name   : gpaManager
	 * Author         : Miguel Rodriguez
	 * Date           : February 12, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This program provides with many options
     *    so users can manage courses and compute the GPA
	 *
	 * BEGIN gpaManager
	 *    to add a course enter 1 or to quit -1
	 *    store input in cChoice
	 *    WHILE(cChoice != -1)
	 *       SWITCH(cChoice)
	 *          case 1:
	 *             please enter the course prefix
	 *             please enter the course number
	 *             please enter the credit hours
	 *             Please enter the grade recieved
	 *             calls the CourseInfo
	 *             exit case
	 *          case 2:
	 *             Please enter the semester's term
	 *             calls semesterInfo
	 *             exit case
	 *       END SWITCH
	 *          Do you cant to continue adding courses yes-(1) no(-1)
	 *    END WHILE
	 *    call the CourseInfo class
	 *    Displays a heading for the courses
	 *    Displays the toString method created in the CourseInfo class
	 * END CourseInfo
	 **************************************************************/


	public static void main (String[] args)
	{

	   //Local Constants
	   final int EXIT     = -1;

	   //Local Variables
	   String cPrefix     = "";    //stores the course prefix
       int  cNumber       = 0;     //stores the course number
	   int  cCreditH      = 0;     //stores the course credit hours
	   int  cChoice;               //sotes user choice
	   double  cGrade     = 0;     //stores the grade
	   String semTerm;             //stores the semester's term
	   CourseInfo course;
	   SemesterInfo semester = new SemesterInfo("Spring 16");

	   /********************   Start main method  *****************/

       //creates a space
       System.out.println();

       //asks the user if they wich to add courses
       System.out.print(Util.setLeft(17, "Please choose one of the following options: \n")+
                        Util.setLeft(15, "Add course (1) Add semester(2) Quit program(-1) "));

       //reads input and stores it in cChoice
       cChoice = Keyboard.readInt();

       //allows the user to run the program multiple times
       while(cChoice != EXIT)
       {
		  //provides with many options to the user(for now there is just one)
          switch(cChoice)
          {

             //adds courses
             case 1:

                   //creates a space
                   System.out.println();

                   //asks the user to enter course prefix
                   System.out.print(Util.setLeft(23, "Please enter the course prefix: "));

                   //reads the input
	               cPrefix = Keyboard.readString();

                   //asks the user to enter the course number
	               System.out.print(Util.setLeft(23, "Please enter the course number: "));

	               //reads user input
	               cNumber = Keyboard.readInt();

                   //asks the user to enter the course credit hours
	               System.out.print(Util.setLeft(23, "Please enter the course credit hours: "));

	               //reads the input
	               cCreditH = Keyboard.readInt();



                   //asks the user to enter the course grade
	               System.out.print(Util.setLeft(23, "Please enter the course grade recieved: "));

	               //reads the input
	               cGrade  = Keyboard.readDouble();

                   //creates a course
	               course = new CourseInfo(cPrefix, cNumber, cCreditH, cGrade);

                   //adds the courses
	               semester.addCourses(course);

                   //breaks out of the case
                   break;

             case 2:

                   //creates a space
				   System.out.println();

				   //asks the user to enter course prefix
				   System.out.print(Util.setLeft(23, "Please enter the semester's term: "));

				   //reads the input
			       semTerm = Keyboard.readString();

				   //breaks out of the case
                   break;


	      }//ends switch

          //creates a space
          System.out.println();

          //asks the user if they wish to continue
          System.out.print(Util.setLeft(11, "Do you want to continue adding courses yes(1) or no(-1)? "));

          //reads user input
          cChoice = Keyboard.readInt();

       }//ends while

       //creates and object to call the class CourseInfo
       CourseInfo courseRep = new CourseInfo(cPrefix, cNumber, cCreditH, cGrade);

       //creates a space
       System.out.println();


       //Displays the course info
       System.out.println(semester);

       //creates a space
       System.out.println();

	}//ends main

}//ends driver