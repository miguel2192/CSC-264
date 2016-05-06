 /******************************************************************
 * Program Name   : QDuck
 * Author         : Miguel Rodriguez & Luke Cavanaugh
 * Date           : 3 March 2016
 * Course/Section : CSC 264
 * Program Description: This program will contain the blueprints of
 *    the duck objects.
 *
 *
 * Methods:
 * -------
 * +QDuck()
 * +setSpeed(int x)
 * +resetDuck(int x)
 * +getCurrentLocation()
 * +getAppearance()
 * +setAppearance(ImageIcon i)
 * +advance()
 * +stop()
 * +isShot()
 * +getHits()
 * +resetHits()
 * +getRandom()
 *******************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class QDuck
{

    //constants
    private final int defaultX = 100; //sets ducks default X coordinate

    //variables
    private Point currentLocation;    //the ducks coordinate on the screen
    private int speed = 10;           //the rate at which the duck moves
    private static int hits = 0;      //records the number of hits per duck
    private ImageIcon image;          //the png image of the duck
    private Random rn;			      //random number that will determine the Y coordinate


    /******************************************************************
    * Program Name   : QDuck()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This will construct new ducks
    *
    ******************************************************************/
    public QDuck()
    {

       //set the starting location for the duck
       currentLocation = new Point(defaultX, getRandom());

       //set the inital image
       image = new ImageIcon(getClass().getResource("/Yduck3.png"));

    }//end QDuck

    /******************************************************************
    * Program Name   : setSpeed()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will set the speed of the duck
    *
    ******************************************************************/
    public void setSpeed(int z)
    {

	   //the speed the duck moves
       speed += z;

    }//end setSpeed

    /******************************************************************
    * Program Name   : resetDuck()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will reset the ducks location
    *
    ******************************************************************/
    public void resetDuck(int x)
    {

      //resets the duck back to a starting location
      currentLocation = new Point(x, getRandom());


    }//end resetDuck

    /******************************************************************
    * Program Name   : getCurrentLocation()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will return the ducks current location
    *
    ******************************************************************/
    public Point getCurrentLocation()
    {

	   //returns the ducks current point
       return currentLocation;

    }//end getCurrentLocation

    /******************************************************************
    * Program Name   : setAppearance()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will return the image representing
    *    the duck's current appearance
    *
    ******************************************************************/
    public ImageIcon getAppearance()
    {

		//returns the ducks appearance
        return image;

    }//end getAppearance

    /******************************************************************
    * Program Name   : setAppearance()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will set the ducks appearance
    *
    ******************************************************************/
    public void setAppearance(ImageIcon i)
    {

    	//allows change of duck appearance
    	image = i;

    }//end setAppearance

    /******************************************************************
    * Program Name   : showSplashAndExit()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will allow the duck to swim forward
    *
    ******************************************************************/
    // This method allows the frames to advance as well as move the duck
    public void advance()
    {


        //move the duck forward 10 pixels
        currentLocation.translate(speed,0);

    }//end advance

    /******************************************************************
    * Program Name   : showSplashAndExit()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will stop the ducks movement
    *
    ******************************************************************/
    public void stop()
    {

        //stop the ducks movement
        currentLocation.translate(0,0);

    }//end stop

    /******************************************************************
    * Program Name   : showSplashAndExit()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will increase the hit count of the duck
    *
    ******************************************************************/
    public void isShot()
    {

		//increase hits count by one
    	hits++;

    }//end isShot

    /******************************************************************
    * Program Name   : showSplashAndExit()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will return the hit count of the duck
    *
    ******************************************************************/
    public int getHits()
    {

 		//return the total hit count
 		return hits;

    }//end getHits

    /******************************************************************
    * Program Name   : showSplashAndExit()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will reset the hit count of the duck
    *
    ******************************************************************/
    public void resetHits()
    {

  		//set the hit count to 0 for duck
    	hits = 0;

    }//end resetHits

    /******************************************************************
    * Program Name   : showSplashAndExit()
    * Author         : Miguel Rodriguez & Luke Cavanaugh
    * Date           : 3 March 2016
    * Course/Section : CSC 264
    * Program Description: This method will return a random number that
    *    is in a predefined range of values
    *
    ******************************************************************/
    public int getRandom()
    {

		//create a new random number
    	rn = new Random();

		//set bounds for random
    	int n = 700 - 300 + 1;

		//mod out number
        int i = rn.nextInt() % n;

		//place within bounds
        int randomNum =  400 + i;

		//return the random number
  		return randomNum;

   }//end getRandom

}//end QDuck
