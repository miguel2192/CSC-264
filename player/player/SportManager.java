 /**********************************************************
 * Program Name   : SportManager
 * Author         : Miguel Rodriguez
 * Date           : February 26, 2016
 * Course/Section : CSC264
 * Program Description: This program manages three
 *    different sports. Baseball, Hockey and Basketball. It then
 *    computes their scores.
 * Methods:
 * -------
 * +main(String[] args)
 *
 **********************************************************/


public class SportManager
{

    /**********************************************************
    * Method Name    : SportManager - manages different sports
    * Author         : Miguel Rodriguez
    * Date           : February 26, 2016
    * Course/Section : CSC264
    * Program Description: allows user to manage three sports
    *
    * BEGIN SportManager
    *    provides options or e to quit
    *    WHILE(ans not equal e)
    *       SWITCH(ans)
    *          case a:
    *             Process baseball
    *          case b:
    *             Process hockey
    *          case c:
    *             Process basketball
    *        END SWITCH
    *    END WHILE
    *    Displays toString()
    * END SportManager
    **********************************************************/

    public static void main(String[] args)
    {

	    //Local Constants
	    final String EXIT      = "exit";

        //Local variables
        String uChoice;             //holds the user's choice
        String fName;               //holds the player's first name
        String lName;               //holds the player's last name
        String pPosition;           //holds the player's position
        double nHits;               //holds the number of hits
        double nBats;               //holds the number of bats
        double goals;               //holds the number of goals
        double assists;             //holds the number of assists
        double ttlPts;              //holds the number of three poitn shots
        Baseball baseball;          //creates an object for baseball
        Hockey hockey;              //creates an object for hockey
        Basketball basketball;      //creates an object for basketball

		//creates an object to call the library class
        Library64 myLib = new Library64();

        /********************   Start main method  *****************/

        //displays a line
        System.out.println();

        //displays the title
        System.out.print(Util.setLeft(17,"Please choose a sport from the options below: \n"));

        //displays a line
        System.out.println();

        //Provides the user with options
        System.out.print(Util.setLeft(17,"(baseball) for Baseball\n") + Util.setLeft(17,"(hockey) for Hockey\n")+
                         Util.setLeft(17,"(basketball) for Basketball\n")+ Util.setLeft(17,"(exit) to exit:  "));
        uChoice = Keyboard.readString();

        //displays a line
        System.out.println();

        //while begin
        while(!uChoice.equalsIgnoreCase(EXIT))
        {

           //switch begin
           switch (uChoice)
           {

              case "baseball":

                     //asks for the player's first name
                     System.out.print(Util.setLeft(17,"Please enter the first name       : "));
                     fName = Keyboard.readString();

                     //asks for the player's last name
                     System.out.print(Util.setLeft(17,"Please enter the last name        : "));
				     lName = Keyboard.readString();

                     //asks for the player's positon
				     System.out.print(Util.setLeft(17,"Please enter the player's position: "));
				     pPosition = Keyboard.readString();

				     //asks for the player's positon
					 System.out.print(Util.setLeft(17,"Please enter the number of hits   : "));
				     nHits = Keyboard.readDouble();

				     //asks for the player's positon
				     System.out.print(Util.setLeft(17,"Please enter the number of bats   : "));
				     nBats = Keyboard.readDouble();

				     //clears screen
					 myLib.clrscr();

					 //displays a line
					 System.out.println();

                     //takes the players information
				     baseball = new Baseball(fName, lName, pPosition,nHits,nBats);

                     //displays a line
                     System.out.println();

                     //displays the player indformation
                     System.out.println(baseball.toString());

                     //displays a line
                     System.out.println();

                     //displays the title
					 System.out.print(Util.setLeft(17,"Please choose a sport from the options below: \n"));

					 //displays a line
                     System.out.println();

				     //Provides the user with options
					 System.out.print(Util.setLeft(17,"(baseball) for Baseball\n") + Util.setLeft(17,"(hockey) for Hockey\n")+
					                  Util.setLeft(17,"(basketball) for Basketball\n")+ Util.setLeft(17,"(exit) to exit:  "));
                     uChoice = Keyboard.readString();

                     //displays a line
                     System.out.println();

                   break;



              case "hockey":

                    //asks for the player's first name
					System.out.print(Util.setLeft(17,"Please enter the first name       : "));
					fName = Keyboard.readString();

				    //asks for the player's last name
					System.out.print(Util.setLeft(17,"Please enter the last name        : "));
					lName = Keyboard.readString();

					   //asks for the player's positon
					System.out.print(Util.setLeft(17,"Please enter the player's position: "));
					pPosition = Keyboard.readString();

					//asks for the player's positon
					System.out.print(Util.setLeft(17,"Please enter the number of goals  : "));
					goals = Keyboard.readDouble();

					//asks for the player's positon
					System.out.print(Util.setLeft(17,"Please enter the number of assists: "));
					assists = Keyboard.readDouble();

					//clears screen
					myLib.clrscr();

                    //displays a line
				    System.out.println();

					//takes the players information
					hockey = new Hockey(fName, lName, pPosition,goals,assists);

					//displays a line
				    System.out.println();

					//displays the player indformation
				    System.out.println(hockey.toString());

					//displays a line
					System.out.println();

					//displays the title
					System.out.print(Util.setLeft(17,"Please choose a sport from the options below: \n"));

					//displays a line
					System.out.println();

					//Provides the user with options
				    System.out.print(Util.setLeft(17,"(baseball) for Baseball\n") + Util.setLeft(17,"(hockey) for Hockey\n")+
										          Util.setLeft(17,"(basketball) for Basketball\n")+ Util.setLeft(17,"(exit) to exit:  "));
                    uChoice = Keyboard.readString();

                    //displays a line
                    System.out.println();

                   break;



              case "basketball":

                    //asks for the player's first name
					System.out.print(Util.setLeft(17,"Please enter the first name                 : "));
					fName = Keyboard.readString();

					//asks for the player's last name
					System.out.print(Util.setLeft(17,"Please enter the last name                  : "));
					lName = Keyboard.readString();

					   //asks for the player's positon
					System.out.print(Util.setLeft(17,"Please enter the player's position          : "));
					pPosition = Keyboard.readString();


					//asks for fault poitn shots
					System.out.print(Util.setLeft(17,"Please enter the number of total points     : "));
					ttlPts = Keyboard.readDouble();

					//clears screen
					myLib.clrscr();

                    //displays a line
					System.out.println();

					//takes the players information
					basketball = new Basketball(fName, lName, pPosition,ttlPts);

					//displays a line
					System.out.println();

					//displays the player indformation
					System.out.println(basketball.toString());

					//displays a line
					System.out.println();

					//displays the title
					System.out.print(Util.setLeft(17,"Please choose a sport from the options below: \n"));

					//displays a line
					System.out.println();

					//Provides the user with options
				    System.out.print(Util.setLeft(17,"(baseball) for Baseball\n") + Util.setLeft(17,"(hockey) for Hockey\n")+
								     Util.setLeft(17,"(basketball) for Basketball\n")+ Util.setLeft(17,"(exit) to exit:  "));
                     uChoice = Keyboard.readString();

                    //displays a line
                    System.out.println();

                  break;

               case "exit":

                    //set uChoice to ext
                    uChoice=  "exit";
                  break;
		 }//ends switch

	  }//ends while

      //Displays good bye
	  System.out.println(Util.setLeft(17,"Good Bye!"));

	  //skips a line
	  System.out.println();

	}//end main

} //ends class player
