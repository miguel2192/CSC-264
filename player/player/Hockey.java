 /**********************************************************
 * Program Name   : Hockey
 * Author         : Miguel Rodriguez
 * Date           : February 26, 2016
 * Course/Section : CSC264
 * Program Description: This class creates a sports player.
 * Methods:
 * -------
 * +toString()
 * +Hockey(parameters)
 *
 **********************************************************/
import java.text.*;
public class Hockey extends Player
{


   /**********************************************************
    * Method Name    : Hockey - keeps track of the Hockey records
    * Author         : Miguel Rodriguez
    * Date           : February 26, 2016
    * Course/Section : CSC264
    * Program Description:
    *
    * BEGIN creates a player
    *   hockey extend player
    *   creates a hockey player
    *   comnputes the total points
    *   creates and retunrs a string
    * END creates a player
    **********************************************************/

    //Local constants

    //Local variables
    protected double goals;             //holds the total goals
    protected double assists;           //holds the total assists
    protected double ttlPts;            //holds the total points
    protected String hDisplay;          //holds a string

    //creates an object to format the output to three decimal places
    DecimalFormat fmt = new DecimalFormat("0.00");


	public Hockey(String fName, String lName, String pPosition, double goals, double assists)
	{

        //calls the constructor from the player's class
		super(fName, lName, pPosition);

		this.goals   = goals;
		this.assists = assists;


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

	   /********************   Start main toString  *****************/

	   //computes the batting average
	   ttlPts = goals + assists;

	   //creates a string and returns it
	   hDisplay = Util.setLeft(17, "Player's name: "+ fName + " " +lName)+ "\n"+ Util.setLeft(17,"Position: " +
								   pPosition) + "\n"+ Util.setLeft(17,"Total Points: " + fmt.format(ttlPts));

	   return hDisplay;

	}//ends toString method


} //ends class player
