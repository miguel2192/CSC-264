 /**********************************************************
 * Program Name   : Sketers
 * Author         : Miguel Rodriguez
 * Date           : February 12, 2016
 * Course/Section : CSC264
 * Program Description: This class creates many different
 *    skaters and store them in an array. It them creates a string
 *    using a toString() method and returns the string.
 *    race.
 *
 * Methods:
 * -------
 * +main (String[] args)
 **********************************************************/
import java.util.*;
public class Skaters
{
	/**************************************************************
	* Program Name   : Skater
	* Author         : Miguel Rodriguez
	* Date           : January 29, 2016
	* Course/Section : CSC-264 - 001
	* Program Description: This Skaters class creates many different
	*   skaters and store them in an array. It them creates a string
    *    using a toString() method and returns the string.
    *    race.
    *
	* BEGIN Skaters
	*    Initialize local constants
	*    Initialize local variables
	*    Initialize a names array to 10
	*    Initialize a scores array to 10
	*    Skaters(String name, int totScore)
	*    creates a toString()
	*    IF the names[] index is not null and socres[] index is not 0
	*       add names and socres to string
	*    END IF
	* END Skaters
	**************************************************************/

	//local constatns
	private static final int ARRAY_MAX  = 10;                    //sets the sixe of the array

	//local variables
	public String name;                                          //holds the name
	public int totalScore;                                       //holds the totalScore
	public static int counter = 0;                               //holds the counter
	private static final String[] names = new String[ARRAY_MAX]; //initializes a name array
    private static final int[] scores = new int[ARRAY_MAX];      //initializes a scores array

    //***********************Start Skaters********************************//


	public Skaters(String name, int totScore)   //constructor
	{
		//contains name nad totalScore
		this.name = name;
		this.totalScore = totScore;

	}//ends constructor



	public String toString()  //toString method
	{
		//local constants

		//local variables
		String strDisplay   = "";  //holds the string to be return

        try{
            //inputs names
		    names[counter] = name;

	        //inputs scores
		    scores[counter]= totalScore;

		   }
		catch (ArrayIndexOutOfBoundsException nfe) {

			System.out.println("Array is full!");

           }//ends catch


       for(int i=0; i<counter; i++)
        {

	       if(names[i] != null || scores[i] != 0)
		  {

                 //creates a string
		         strDisplay  += names[i] + "---" + scores[i] + "\n";

		  }//ends if

	    }//ends for

	    //increase counter by one
        counter++;

      return strDisplay;  //returns string

   }//edns toString method


}//ends class