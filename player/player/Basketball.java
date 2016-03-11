/**********************************************************
 * Program Name   : player
 * Author         : Miguel Rodriguez
 * Date           : February 26, 2016
 * Course/Section : CSC264
 * Program Description: This class creates a sports player.
 * Methods:
 * -------
 * +toString()
 * +Basketball(parameters)
 *
 **********************************************************/


import java.text.*;
public class Basketball extends Player
{


   /**********************************************************
    * Method Name    : Basketball- keeps tract of the basketball player
    * Author         : Miguel Rodriguez
    * Date           : February 26, 2016
    * Course/Section : CSC264
    * Program Description:
    *
    * BEGIN creates a player
    *    Basketball extend player
    *    Creates a player
    *    Computes the total points
    *    Creates and returns a string
    * END creates a player
    **********************************************************/

    //Local constants

    //Local variables
    protected double bTtlPts;        //holds the three point shots
    protected double ttlPts;        //holds the total points
    protected String baskDisplay;   //holds the basketball display


    //creates an object to format the output to three decimal places
    DecimalFormat fmt = new DecimalFormat("0.00");

    /********************   Start main basketball method  *****************/


	public Basketball(String fName, String lName, String pPosition, double bTtlPts)
	{


        //calls the constructor from the player's class
		super(fName, lName, pPosition);

		this.bTtlPts = bTtlPts;

	}//ends constructor


	/**********************************************************
	* Method Name    : toString() - creates a string
	* Author         : Miguel Rodriguez
	* Date           : February 26, 2016
	* Course/Section : CSC264
	* Program Description: creates a string
	*
	* BEGIN creates a player
	*    toString()
	*    creates a string
	*    returns string
	* END creates a player
    **********************************************************/

	public String toString()
		{

		   //Local constants

		   //Local variables

		   /********************   Start main method  *****************/


	       //creates a string and returns it
		   baskDisplay = Util.setLeft(17, "Player's name: "+ fName + " " +lName)+ "\n"+ Util.setLeft(17,"Position: " +
			                           pPosition) + "\n"+ Util.setLeft(17,"Total Points: " + fmt.format(bTtlPts));

		   return baskDisplay;

	}//ends toString method


} //ends class player
