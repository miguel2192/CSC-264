/**********************************************************
 * Program Name   : player
 * Author         : Miguel Rodriguez
 * Date           : February 26, 2016
 * Course/Section : CSC264
 * Program Description: This class creates a sports player.
 * Methods:
 * -------
 * +player(String fName, String lName, String pPosition)
 **********************************************************/


public class Player
{

	//Local Constants


	//Local Variables

	protected String fName;            //holds the player's name
	protected String lName;            //holds the player's last name
	protected String pPosition;        //holds the player's position


    /**********************************************************
    * Method Name    : player- creates a player
    * Author         : Miguel Rodriguez
    * Date           : February 26, 2016
    * Course/Section : CSC264
    * Program Description:
    *
    * BEGIN creates a player
    *    player(firstName, lastname, position)
    *    return player
    * END creates a player
    **********************************************************/


    public Player(String fName, String lName, String pPosition)
    {

		//sets everything to whatever the user types
		this.fName     = fName;
		this.lName     = lName;
		this.pPosition = pPosition;
	}


} //ends class player
