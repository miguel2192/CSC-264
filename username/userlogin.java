 /**************************************************************
 * Program Name   : userloginMR
 * Author         : Miguel Rodriguez
 * Date           : January 29, 2016
 * Course/Section : CSC-264 - 001
 * Program Description: This program creates usernames and passwords
 *    for a user, it then stores that usernames and passwors into
 *    two different arrays. The maximum value of the array is 10.
 *    These functions are perfom using different methods store in
 *    the class userLog.
 * Methods:
 * -------
 *    +main(String[]args)       :void
 *    +username                 :String
 *    +password                 :String
 *    +print                    :void
 **************************************************************/
 import java.util.*;
 public class userlogin
 {

     /**************************************************************
	 * Program Name   : userloginMR
	 * Author         : Miguel Rodriguez
	 * Date           : January 29, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This program creates usernames and passwords
	 *    for a user, it then stores that usernames and passwors into
	 *    two different arrays. The maximum value of the array is 10.
	 *    These functions are perfom using different methods store in
     *    the class userLog
	 *
	 * BEGIN userLogin
	 *    create usernameArray and initialize it from 0 to 9
	 *    create passwordArray and initialize it from 0 to 9
	 *    Enter the first name or -1 to quit
	 *    WHILE (firstname is not = -1)
	 *       Enter the last name or -1 to quit
	 *       call method username
	 *       call method password
	 *    FOR(All indexes in the usernameArray)
	 *    IF (username = existing username)
	 *      add the number from 1 to 3 to the username
	 *      username = newUsername
	 *    END IF
	 *       store usernames into the usernameArray
	 *       store passwords into the passwordArray
	 *       IF(userArray = full)
	 *          firstname = -1
	 *       ELSE
	 *         Enter the firstname or -1
	 *       END IF
	 *    END WHILE
	 *    call method print
	 * END userLogin
	 **************************************************************/

	 public static void main(String[] args)
	 {
		 //Local constants
         final int ARRAY_MAX  = 10;
         final String EXIT    = "-1";

		 //Local variables
		 String fullname = "";    //stores the fullname
		 String username = "";    //stores the username
		 String fname    = "";    //stores the fisrtname
		 String lname    = "";    //stores the last name
         int randomInt2;          //stores a random integer
         String passwordf= "";    //stores the final password
         String usernamef= "";    //stores the final username
         int count       = 0;     //counts while loop
         int dNum        = 1;     //creates an uniques username


         //creates two arrays and initialize them to 9
		 String[] usernameArray = new String[ARRAY_MAX];
	     String[] passwordArray = new String[ARRAY_MAX];

	     //creates an object to call the library class
         Library64 myLib = new Library64();

         /********************   Start main method  *****************/
         //creates a space
         System.out.println();

         //ask the user to enter their first name
	     System.out.print(Util.setLeft(19, "Please enter the firstname or -1 to quit: "));

	     //stores the firstname into the fname variable
         fname = Keyboard.readString();

         //checks whether the user enters -1 to quit
         while(!fname.equals(EXIT))
         {

		     //creates a space
		     System.out.println();

		     //akss the user to enter their last name
		     System.out.print(Util.setLeft(26, "Please enter the lastname: "));

		     //stores the lastname into the varible lname
             lname = Keyboard.readString();

             //clears the screen
             myLib.clrscr();

             //calls the method username store in the accounts class
             usernamef = username(fname,lname);

             //creates a random generator object
             Random rnmGen = new Random();

             //inserts the username into the usernameArray
		     for(int j = 0; j<usernameArray.length; j++)
		 	 {

				//checks to see if the index is empty
				if(usernameArray[j] == null)
				{
					//loops through all the array
                    for(int s = 0; s<usernameArray.length; s++)
                    {

					 //compares the username to the ones in the array
					 if(usernameArray[s] == usernamef)
					 {

						if(dNum < 3)
						{
						//increases by one each time
						dNum++;

						//adds one digit for 1 to 3
				        usernamef += dNum;

					    }
					    else
					    {
						 dNum = 0;
					    }//ends if

			         }//ends if

				    }//ends the for loop

                    //inserts username into the usernameArray
		 	        usernameArray[j] = usernamef;

			    }//ends if statement

		   	 }//ends for loop


             //calls the method password in class accounts
		   	 passwordf = password(fname);

             //inserts the passwords
		     for(int i = 0; i<passwordArray.length; i++)
			 {
				//inserts the passwrods into the passwords array
				passwordArray[i] = passwordf;

			 }//ends for loop


             //increments by one
			 count++;

             //if array is full exits
			 if (count == ARRAY_MAX)
			 {
			    //sets fname to 0
		        fname = EXIT;
			 }//ends if
			 else
			 {

                //creates a space
				System.out.println();

				//ask the user to enter their first name
				System.out.print(Util.setLeft(19, "Please enter the firstname or -1 to quit: "));

				//stores the firstname into the fname variable
				fname = Keyboard.readString();

			 }//ends else

             //clears the screen
             myLib.clrscr();

	        }//ends while loop

	     //prints the array
	     for(int f = 0; f < count; f++)
	     {
	        //creates a space
		    System.out.println();

		    //prints the array
	        System.out.print(Util.setLeft(31,"Username and Password: \n") + Util.setLeft(31, usernameArray[f])
	                         + "\n"+Util.setLeft(31, passwordArray[f]) + "\n");
            //creates a space
	        System.out.println();

	      }//ends for loop

     }//ends main

     /**************************************************************
	  * Program Name   : userloginMR
	  * Author         : Miguel Rodriguez
	  * Date           : January 29, 2016
	  * Course/Section : CSC-264 - 001
	  * Program Description: This program creates usernames and passwords
	  *    for a user, it then stores that usernames and passwors into
	  *    two different arrays. The maximum value of the array is 10.
	  *    These functions are perfom using different methods store in
	  *    the class userLog
	  *
	  * BEGIN username(firstname, lastname)
	  *    create newUsername
	  *    IF (firstname < 2 )
	  *      fullname = firstname + lastname
	  *      take the two letters
	  *      store them in username
	  *    ELSE
	  *      take the two letters of the firstname
	  *      store them in username
	  *    END IF
	  *    IF (lastname < 3 )
	  *      fullaname = firstname + lastname
	  *      take the first three letters
	  *      add them to username
	  *    ElSE
	  *      take the first three letters
	  *      add them to username
	  *    END IF
	  *    username.toLowerCase
	  *    Generate random number in the range of 1 to 3 inclusive
	  *    add number to username
	  *      return username
	  *    END FOR
	  * END username
	  **************************************************************/


	  public static String username(String firstname, String lastname)
	  {
	      //Local constants

	 	 //local variables
	 	 String username ="";  //stores the username
	 	 String fullname ="";  //stores the fullname
	 	 int randomInt;        //stores the first random number
	 	 int randomInt2;       //stores the first random number
	 	 String usernamel="";  //stores the lowercase username




	      //checks if the firstname is less than 2 characters
	 	 if(firstname.length() < 2)
	 	 {
	 	    //adds the firstname and the lastname
	 	    fullname = firstname + lastname;

	         //takes the first two characters of the string
	 	    username = fullname.substring(0, 2);

	 	 }//ends first if statement

	 	 else
	 	 {
	 	    //Takes the first two characters of the firstname
	 	    username = firstname.substring(0, 2);

	      }//ends first else

	         //checks if the lastname is less than two chracters long
	 	 if(lastname.length() < 3)
	 	 {
	 	  	//adds the firstname and the lastname
	 	  	fullname = firstname + lastname;
	 	    //takes the first two characters of fullname
	 	  	username += fullname.substring(0, 3);

	 	 }//ends second if statement

	 	 else
	 	 {
	 	  	//take first three characters of the lastname
	 	  	username += lastname.substring(0, 3);
	 	 }//ends second else

	         //converts the username to lowercase
	         usernamel =  username.toLowerCase();

	         //random object
	         Random rnmGen = new Random();

	         //creates a random number in range of 1 to 3 inclusive
	         randomInt = rnmGen.nextInt(3)+1;
	         //adds the number to the username
	         usernamel += randomInt;

	      //returns the username
	      return usernamel;
	  }//ends username method


	  /**************************************************************
	  * Program Name   : userloginMR
	  * Author         : Miguel Rodriguez
	  * Date           : January 29, 2016
	  * Course/Section : CSC-264 - 001
	  * Program Description: This program creates usernames and passwords
	  *    for a user, it then stores that usernames and passwors into
	  *    two different arrays. The maximum value of the array is 10.
	  *    These functions are perfom using different methods store in
	  *    the class userLog
	  *
	  *	 BEGIN password(firstname)
	  *	     password = firstname.toLowerCase
	  *	     return password
	  *   END password
	  **************************************************************/
	  public static String password(String firstname)
	  {
	   String password   ="";  //stores the password
	   String firstnamel ="";  //stores the lowercase firstname

	   //converts the firstname to lowercase
	   firstnamel = firstname.toLowerCase();
	   //stores the lowercase firstname into password
	   password = firstnamel;

	   //returns password
	   return password;

      }//ends password method





  }//ends userlogin

