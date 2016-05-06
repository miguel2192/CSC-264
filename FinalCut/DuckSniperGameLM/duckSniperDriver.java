 /*********************************************************************************
 * Program Name   : duckSniperDriver.java
 * Author         : Luke Cavanaugh & Miguel Rodriguez
 * Date           : May 3, 2016
 * Course/Section : CSC264
 * Program Description:  This is the main application of duckSniper, its
 *   goal is to execute the other components of the game. It calls
 *   the splashScreen.java first, the splashScreen runs for an specific amount
 *   time given in the constructor and them the splashScreen calls the
 *   duckHuntPanel.java class and sets its visibility to true. From the Main Menu
 *   we can start the game by calling the QDuckGame which calls the QDuckPanel
 *   which creates the game.
 *
 * Methods:
 * -------
 * +main(String[] args)
 *
 *
 * Begin duckSniperDriver
 *    Initialize local constants
 *    Initialize local variables
 *    creates a main method
 *    set the duration of the splash screen
 *    calls the splash screen
 * End duckSniperDriver
 ********************************************************************************/

public class duckSniperDriver {

	public static void main(String[] args) {

		//Local constants

		//Local variables

		//************************starts main*******************************//

			 //sets duration for the splash screen
			 SplashScreen splash = new SplashScreen(5000);

			 //calls the splashScreen class
             splash.showSplashAndExit();

	}//ends main class

}//ends duckHunt class