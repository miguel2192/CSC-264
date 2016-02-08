 /**************************************************************
 * Program Name   : userloginMR
 * Author         : Miguel Rodriguez
 * Date           : February 7, 2016
 * Course/Section : CSC-264 - 001
 * Program Description: This program creates usernames and passwords
 *    for a user, it then stores the usernames and passwords into
 *    two different arrays. The maximum value of the array is 10.
 *    These functions are perfomed using different methods. It then outputs
 *    the usernames and passwords accordingly.
 * Methods:
 * -------
 *    +main(String[]args)       :void
 *    +username                 :String
 *    +password                 :String
 **************************************************************/
 import java.util.*;
 public class userlogin
 {

     /**************************************************************
	 * Program Name   : userloginMR
	 * Author         : Miguel Rodriguez
	 * Date           : February 7, 2016
	 * Course/Section : CSC-264 - 001
	 * Program Description: This program creates usernames and passwords
	 *    for a user, it then stores the usernames and passwords into
	 *    two different arrays. The maximum value of the array is 10.
	 *    These functions are perfomed using different methods. It then
	 *    outputs the usernames and passwords accordingly.
	 *
	 * BEGIN userLogin
	 *    create usernameArray and initialize it from 0 to 9
	 *    create passwordArray and initialize it from 0 to 9
	 *    enter the first name or -1 to quit
	 *    WHILE (firstname is not = -1)
	 *       Enter the last name or -1 to quit
	 *       call method username
	 *       call method password
	 *    FOR(All indexes in the usernameArray)
	 *    IF (username = existing username)
	 *       add the number from 1 to 3 to the username
	 *       username = newUsername
	 *    END IF
	 *       store usernames into the usernameArray
	 *       store passwords into the passwordArray
	 *       IF(userArray = full)
	 *          firstname = -1
	 *       ELSE
	 *         enter the firstname or -1
	 *       END IF
	 *    END WHILE
	 * END userLogin
	 **************************************************************/

	 public static void main(String[] args)
	 {
		 //Local constants
         final int ARRAY_MAX  = 10;       //stores the maximum size of the arrays
         final String EXIT    = "-1";     //stores a sentinel to exit the program
         final int DUP_USER   = 3;        //stores a value that helps avoid duplicate users

		 //Local variables
		 String fName         = "";       //stores the fisrt name
		 String lName         = "";       //stores the last name
         int randomInt2;                  //stores a random integer
         String passwordF     = "";       //stores the final password
         String usernameF     = "";       //stores the final username
         int count            = 0;        //counts the while loop
         int threeCount       = 0;        //creates an unique username


         //creates two arrays and initializes them to 10
		 String[] usernameArray = new String[ARRAY_MAX];
	     String[] passwordArray = new String[ARRAY_MAX];

	     //creates an object to call the library class
         Library64 myLib = new Library64();

         /********************   Start main method  *****************/
         //creates a space
         System.out.println();

         //ask the user to enter a first name
	     System.out.print(Util.setLeft(20, "Please enter the first name or -1 to quit: "));

	     //stores the first name into the fname variable
         fName = Keyboard.readString();

         //checks whether the user enters -1 to quit
         while(!fName.equals(EXIT))
         {

		     //creates a space
		     System.out.println();

		     //asks the user to enter a last name
		     System.out.print(Util.setLeft(27, "Please enter the last name: "));

		     //stores the last name into the varible lname
             lName = Keyboard.readString();

             //clears the screen
             myLib.clrscr();

             //calls the method username store in the accounts class
             usernameF = username(fName,lName);

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
					   if(usernameArray[s] == usernameF)
					   {

					      if(threeCount < DUP_USER)
					      {
					          //increases by one each time
					          threeCount++;

				              //adds one digit for 1 to 3
				              usernameF += threeCount;

					      }//ends inner if statement
					      else
					      {
							  //restarts the count every three times
					          threeCount = 0;
					      }//ends inner else

			           }//ends outer if

				  }//ends for loop

             //inserts username into the usernameArray
		 	 usernameArray[j] = usernameF;

			    }//ends if statement

		   	 }//ends for loop


             //calls the method password in class accounts
		   	 passwordF = password(fName);

             //inserts the passwords
		     for(int i = 0; i<passwordArray.length; i++)
			 {
				//inserts the passwords into the passwords array
				passwordArray[i] = passwordF;

			 }//ends for loop


             //increments by one
			 count++;

             //if array is full exits
			 if (count == ARRAY_MAX)
			 {
			    //sets fname to 0
		        fName = EXIT;
			 }//ends if
			 else
			 {

                //creates a space
				System.out.println();

				//ask the user to enter their first name
				System.out.print(Util.setLeft(20, "Please enter the first name or -1 to quit: "));

				//stores the first name into the fname variable
				fName = Keyboard.readString();

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
	  * Date           : February 7, 2016
	  * Course/Section : CSC-264 - 001
	  * Program Description: This program creates usernames and passwords
	  *    for a user, it then stores that usernames and passwords into
	  *    two different arrays. The maximum value of the array is 10.
	  *    These functions are perfom using different methods. It then
	  *    outputs the usernames accordingly.
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
	  *      fullname = firstname + lastname
	  *      take the first three letters
	  *      add them to username
	  *    ElSE
	  *      take the first three letters
	  *      add them to username
	  *    END IF
	  *    username.toLowerCase
	  *    Generate random number in the range of 1 to 3 inclusive
	  *    add random number to username
	  *    return username
	  *    END FOR
	  * END username
	  **************************************************************/


	  public static String username(String firstname, String lastname)
	  {
	      //Local constants

	 	 //local variables
	 	 String userName   ="";  //stores the username
	 	 String fullName   ="";  //stores the fullname
	 	 int randomInt;          //stores the first random number
	 	 String usernameL  ="";  //stores the lowercase username




	      //checks if the firstname is less than 2 characters
	 	 if(firstname.length() < 2)
	 	 {
	 	    //adds the firstname and the lastname
	 	    fullName = firstname + lastname;

	         //takes the first two characters of the string
	 	    userName = fullName.substring(0, 2);

	 	 }//ends first if statement

	 	 else
	 	 {
	 	    //Takes the first two characters of the firstname
	 	    userName = firstname.substring(0, 2);

	      }//ends first else

	         //checks if the lastname is less than two chracters long
	 	 if(lastname.length() < 3)
	 	 {
	 	  	//adds the firstname and the lastname
	 	  	fullName = firstname + lastname;
	 	    //takes the first two characters of fullname
	 	  	userName += fullName.substring(0, 3);

	 	 }//ends second if statement

	 	 else
	 	 {
	 	  	//take first three characters of the lastname
	 	  	userName += lastname.substring(0, 3);

	 	 }//ends second else

	     //converts the username to lowercase
	     usernameL =  userName.toLowerCase();

	     //random object
	     Random rnmGen = new Random();

	     //creates a random number in range of 1 to 3 inclusive
	     randomInt = rnmGen.nextInt(3)+1;

	     //adds the number to the username
	     usernameL += randomInt;

	     //returns the username
	     return usernameL;

	  }//ends username method


	  /**************************************************************
	  * Program Name   : userloginMR
	  * Author         : Miguel Rodriguez
	  * Date           : Feb 7, 2016
	  * Course/Section : CSC-264 - 001
	  * Program Description: This program creates usernames and passwords
	  *    for a user, it then stores that usernames and passwords into
	  *    two different arrays. The maximum value of the array is 10.
	  *    These functions are perfomed using different methods. It then
	  *    outputs the usernames and passwords accordingly.
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

