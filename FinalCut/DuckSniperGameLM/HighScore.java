 /*************************************************************************************
 * Program Name   : HighScore.java
 * Author         : Luke Cavanaugh & Miguel Rodriguez
 * Date           : May 5, 2016
 * Course/Section : CSC264
 * Program Description:  This class gathers all of the user scores and adds them to a
 *    string which is return using a toStrin() method.
 *
 * Methods:
 * -------
 * +setDiff(int diff)
 * +setLevel(String level)
 * +setScore(int score)
 * +toString()
 *
 * Begin HighScore
 *    Create a setter to set the difficulty
 *    Create a setter to set the level
 *    Create a setter to set the score
 *    create a toString() method
 *    create a variable str in toString()
 *    add all data from setters into str
 *    return str
 * End HighScore
 **************************************************************************************/

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import java.util.Random;

 public class HighScore
 {


    //Global variables

    //Global constants
    private static int diff;                //holds the difficulty
    private static String level;            //holds the level
    private static int score;               //holds the score

    /*************************************************************************************
	* Program Name   : setDiff(int diff)
	* Author         : Luke Cavanaugh & Miguel Rodriguez
	* Date           : May 5, 2016
	* Course/Section : CSC264
	* Program Description:  This setter sets the players difficulty to the diff variable.
	*
	*
	* Methods:
	* -------
	* +setDiff(int diff)
    **************************************************************************************/
    public void setDiff(int diff)
    {

	   //Local Constants

	   //Local variables

	  //********************Starts setDiff(int diff)************************************//

       //set diff
       this.diff = diff;
    }



    /*************************************************************************************
    * Program Name   : setLevel(String level)
    * Author         : Luke Cavanaugh & Miguel Rodriguez
    * Date           : May 5, 2016
    * Course/Section : CSC264
    * Program Description:  This setter sets the player's level to a level variable.
    *
    *
    * Methods:
    * -------
    * +setLevel(String level)
    **************************************************************************************/
    public void setLevel(String level)
    {

	  //Local Constants

	  //Local variables

	  //********************Starts setLevel(String level)********************************//

	  //set level
      this.level = level;
    }



    /*************************************************************************************
	* Program Name   : setScore(int score)
	* Author         : Luke Cavanaugh & Miguel Rodriguez
	* Date           : May 5, 2016
	* Course/Section : CSC264
	* Program Description:  This setter sets the players score to a score variable.
	*
	*
    * Methods:
	* -------
	* +setScore(int score)
    **************************************************************************************/
    public void setScore(int score)
    {

	  //Local Constants

	  //Local variables

	  //********************Starts setScore(int score)***********************************//

	  //set score
      this.score = score;
    }



    /*************************************************************************************
	* Program Name   : toString()
	* Author         : Luke Cavanaugh & Miguel Rodriguez
	* Date           : May 5, 2016
	* Course/Section : CSC264
	* Program Description:  This method creates a toString() method which creates a string
	*    and adds score, diff, and level. It then proceeds to return the string.
	*
	*
	* Methods:
	* -------
	* +toString()
    **************************************************************************************/
    public String toString()
    {

       //Local constants

       //Local Variables
       String str;                //holds a string of high score info


       //********************Starts toString()*******************************************//

       //adds contents to string
       str = "   \t"+ score + "  \t" + diff +"  \t"+ level ;

       //returns the string
       return str;

    }//ends the toString()

}//ends HighScore