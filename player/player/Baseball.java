/**********************************************************
 * Program Name   : player
 * Author         : Miguel Rodriguez
 * Date           : February 26, 2016
 * Course/Section : CSC264
 * Program Description: This class creates a sports player.
 * Methods:
 * -------
 * +toString()
 * +Baseball(parameters)
 *
 **********************************************************/

import java.text.*;
public class Baseball extends Player
{


   /**********************************************************
    * Method Name    : Baseball -
    * Author         : Miguel Rodriguez
    * Date           : February 26, 2016
    * Course/Section : CSC264
    * Program Description:
    *
    * BEGIN creates a player
    *    Baseball extends player
    *    creates a baseball player
    *    computes the total points
    *    creates and returns a string
    * END creates a player
    **********************************************************/

    //Local Caonstants

    //Local Variables

    private double nHits;       //holds the number of hits
    private double nBats;       //holds the number of bats
    private double bttAvg;      //holds the batting average
    private String baseDisplay; //holds the baseball display

    //creates an object to format the output to three decimal places
    DecimalFormat fmt = new DecimalFormat("0.000");

    public Baseball(String fName, String lName, String pPosition, double nHits, double nBats)
    {

		//calls the constructor from the player's class
		super(fName, lName, pPosition);

		this.nHits = nHits;
		this.nBats = nBats;


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

	   //computes the batting average
       bttAvg = nHits / nBats;

        //creates a string and returns it
		baseDisplay = Util.setLeft(17, "Player's name: "+ fName + " " +lName)+ "\n"+ Util.setLeft(17,"Position: " +
		                           pPosition) + "\n"+ Util.setLeft(17,"Batting average: " + fmt.format(bttAvg));

		return baseDisplay;

	}//ends toString method

} //ends class player
