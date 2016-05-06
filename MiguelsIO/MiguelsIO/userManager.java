 /**********************************************************
 * Program Name   : Program userManager - Manages different users
 * Author         : Miguel Rodriguez
 * Date           : March 03, 2016
 * Course/Section : CSC264
 * Program Description: This program reads usernames and passwords from
 *   from a txt file. It then allows the user to login, logout, change
 *   their password and quit the program. It also saves the login history
 *   to a log file.
 *
 * Methods:
 * -------
 * Main - Manages different users
 *
 **********************************************************/
 import java.util.*;
 import java.io.*;
 public class userManager
 {

	 //class constants

	 //class variables

    /**********************************************************
    * Program Name   : Program userManager - Manages different users
    * Author         : Miguel Rodriguez
    * Date           : March 03, 2016
    * Course/Section : CSC264
    * Program Description: This method reads usernames and passwords from
    *   from a txt file. It then allows the user to login, logout, change
    *   their password and quit the program using a switch. It also saves the login history
    *   to a log file. Try and catch is to catch all error exceptions.
    *
    *
    * BEGIN userManager
    *   initialize local constants and variables
    *   asks the user for a file name and extension
    *   use try and catch to avoid IOExceptions while reading the file
    *   WHILE(there are more words in the input file)
    *      Read line
    *      WHILE(there are more words iin line)
    *         store first token which is username to username array
    *         store second toked which is password to password array
    *      END WHILE
    *      increase array index by one
    *      IF(array is not full)
    *         Get next line from file
    *      ELSE
    *         exit the while loop
    *    END WHILE
    *   Display menu (login)login,(logout)logout,(passChange)Change password,(quit)quit
    *   store the user's input in ans
    *   WHILE(ans not equal quit)
    *      SWITCH(ans)
    *         case login:
    *            Enter username and password
    *            IF(Someone is not login)
    *               IF(username equals a username in username array AND password equals password a password in passsword array)
    *                  Diplay You have login successfully
    *                  Write username and password index to log file
    *               ELSE
    *                  Displays wrong username or password
    *            ELSE
    *               Display "someone is login at this tme please try later"
    *         case logout:
    *            initilize a counter to zero
    *            everytime anyone login increase counter by one
    *            IF (counter is greater then zero)
    *               Enter username and password
    *               IF(username equals a username in username array AND password equals password in password array)
    *                  Diplay You have logout successfully
    *               ELSE
    *                  Display "Incorrect Password or Username"
    *            ELSE
    *               Display "There are no users logged in, Need to be login to logout"
    *            END IF
    *         case passChange:
    *            IF(counter is greater then zero)
    *               Enter username and password
    *               IF(username equals username in username array AND password equals password in password array)
	*                  Diplay You have login successfully
	*                  Prompt user for for their current password
	*                  IF(password equals password in password array)
	*                     prompt user for their new password
	*                     Display 'password was updated successfully
    *                  ELSE
    *                     Display 'Sorry invalid password'
    *                ELSE
    *                   Display 'sorry invalid username and password
    *             ELSE
    *                Display "There is no one login, Please login first
    *            END IF
    *         case exit:
    *            close file and save usernames and passwords
    *            Display 'all data was saved
    *            Exit program
    *      END SWITCH
    *   END WHILE
    * END userManger
    **********************************************************/

    public static void main (String [] args) throws Exception
    {

      //local constants
      final int ARRAY_MAX      = 10;
      final int LOGIN          =  1;
      final int LOGOUT         =  2;
      final int CHANGE         =  3;
      final int EXIT           = -1;

      //local variables
      int option;                                //holds the users choice for the menu
      String username          = "";             //holds a username
	  String password          = "";             //holds a password
	  String newPassword       = "";             //holds a new password
	  int counter              = 0 ;             //keep track if the user is logged in
	  int index                = 0 ;             //holds the index for the array
	  FileReader inFile;
	  BufferedReader bFile;                      //object reades from input file
	  FileWriter fw, fwn;                        //object writes to output file
	  BufferedWriter w, wn;                      //object is ready to write
	  String s, word, temp     = "";
	  String inputFile         = "";             //name of file to input from
	  String outFile           = "Output.txt";   //file to write to
	  StringTokenizer line;                      //keeps usermes and passwords separate
	  PrintWriter pw;
	  String uFound            = "";
	  String pFound            = "";

      //creates an usernames array and initialize its size to ten
	  String usernames[] = new String[ARRAY_MAX];

	  //creates an passwords array and initialize its size to ten
	  String passwords[] = new String[ARRAY_MAX];

      //library class
	  Library64 myLib = new Library64();

      /********************   Start main method  *****************/

      //skips a line
      System.out.println();

      //prompts the user for a file name
      System.out.print(Util.setLeft(17,"Enter a filename with its extension to continue: "));
      inputFile = Keyboard.readString();

      try
      {

         //reads the file path
         inFile = new FileReader(inputFile);

         //crates a buffered reader object and takes file reader
         bFile  = new BufferedReader(inFile);

         //creates a FileWriter object
	     fw = new FileWriter(outFile);

	     //takes the FileWriter object
         w  = new BufferedWriter (fw);

         //creates a line to read and store eery file
         s = bFile.readLine();

         //goes through every single non-null line
         while(s != null)
         {
            //Read in the line
	        line = new StringTokenizer(s);

            while(line.hasMoreTokens())
            {
				//stores usernames in username array
				usernames[index] = line.nextToken();

				//stores the passwords in passwrods array
				passwords[index] = line.nextToken();

	        }//ends inner while

            //increases index by one every time
            index++;

            if(index < usernames.length)
            {
				//continues reading
				s = bFile.readLine();

			}//ends if
			else
			{
				//sets s to null which exits the while loop
				s = null;

			}//ends else

	      }//ends while

          //skips a line
	      System.out.println();

          //provides the user with many options
	      System.out.print(Util.setLeft(17,"(1)  login\n")+ Util.setLeft(17, "(2)  logout\n")+
	                       Util.setLeft(17,"(3)  change password\n")+ Util.setLeft(17,"(-1) quit: "));
	      option = Keyboard.readInt();

	      while(option != EXIT)
	      {
             switch(option)
             {
			    case LOGIN:
                            //checks to see if someone is logged in
			                if(counter > 0)
			                {
							   //Displays an error to the user
						       System.out.print(Util.setLeft(17,"Someone is logged in at this time! Please try again later."));
					        }//ends if
					        else
					        {
                               //skips a line
                               System.out.println();

                               //prompts user for username
			                   System.out.print(Util.setLeft(17,"Enter Username: "));
			                   username = Keyboard.readString();

                               //prompts the user for password
			                   System.out.print(Util.setLeft(17,"Enter password: "));
			                   password = Keyboard.readString();

			                   //skips a line
                               System.out.println();

                               //runs ten times
                               for(int i =0; i<ARRAY_MAX; i++)
                               {

                                   //checks to see if username and password exist
			                       if(username.equals(usernames[i]) && password.equals(passwords[i]))
                                   {

                                      //sets uFound equals to the found username and pFound equals tot he found password
                                      uFound = usernames[i];
                                      pFound = passwords[i];

                                      //writes to the file when user login
									  w.write(usernames[i] + " login to the system.");

									  //new line
									  w.newLine();

									  //flush
								      w.flush();

				                      //increments the counter by one, keeps track of who is login
				                      counter++;

			                        }//ends if

			                    }//ends for loop
			                    if(username.equals(uFound) && password.equals(pFound))
			                    {

									//displays login was successfull
				                    System.out.println(Util.setLeft(17,"Login was successfull"));

								}//ends if
								else
								{
									 //displays login wasn't successfull
								     System.out.println(Util.setLeft(17,"Incorrent Username or Password!\n")+
								                        Util.setLeft(17,"Login was'nt successfull"));
								}//ends else

						     }//ends else

			                 //skips line
			                 System.out.println();

			                 //provides the user with many options
			                 System.out.print(Util.setLeft(17,"(1)  login\n")+ Util.setLeft(17, "(2)  logout\n")+
							                  Util.setLeft(17,"(3)  change password\n")+ Util.setLeft(17,"(-1) quit: "));
	                         option = Keyboard.readInt();
                             break;

			    case LOGOUT:
			                 if(counter > 0)
			                 {
					            //skips a line
					            System.out.println();

					            //prompts user for username
					            System.out.print(Util.setLeft(17,"Enter Username: "));
					            username = Keyboard.readString();

					            //prompts the user for password
					            System.out.print(Util.setLeft(17,"Enter password: "));
					            password = Keyboard.readString();

					            //skips a line
					            System.out.println();

                                //runs ten times
								for(int i =0; i<ARRAY_MAX; i++)
                                {
					               //checks to see if username and password exists
					               if(username.equals(usernames[i]) && password.equals(passwords[i]))
					               {

                                      //sets uFound equals to the found username and pFound equals tot he found password
						              uFound = usernames[i];
                                      pFound = passwords[i];

                                      //writes to the file when user logout
									  w.write(usernames[i] + " logout of the system.");

									  //new line
									  w.newLine();

									  //flush
								      w.flush();

						              //increments the counter by one
						              counter--;

					                }//ends if

							     }//ends for

                                 if(username.equals(uFound) && password.equals(pFound))
			                     {

							        //displays login successfull
						            System.out.println(Util.setLeft(17,"Logout was successfull"));

								 }//ends if
								 else
								 {
									 //displays login wasn't successfull
								     System.out.println(Util.setLeft(17,"Incorrent Username or Password!\n")+
								                        Util.setLeft(17,"Logout was'nt successfull"));
							     }//ends else
				              }//ends if
				              else
				              {
                                 //skips alin
                                 System.out.println();

					             //Displays an error saying that there are not users logged in
					             System.out.println(Util.setLeft(17,"There are no users logged in at this time!\n" +
					                                Util.setLeft(17,"Need to be logged in to logout.")));

				               }//ends else

				               //Skips a line
				               System.out.println();

				               //provides the user with many options
				               System.out.print(Util.setLeft(17,"(1)  login\n")+ Util.setLeft(17, "(2)  logout\n")+
								                Util.setLeft(17,"(3)  change password\n")+ Util.setLeft(17,"(-1) quit: "));
	                           option = Keyboard.readInt();
			                   break;

                 case CHANGE:

			                  if(counter > 0)
			                  {
					             //skips a line
					             System.out.println();;

			                     //prompts the user for password
			                     System.out.print(Util.setLeft(17,"Enter current password: "));
			                     password = Keyboard.readString();

                                 //skips a line
                                 System.out.println();

                                 //runs ten times
								 for(int i =0; i<ARRAY_MAX; i++)
                                 {
			                        //checks to see if username and password exists
					                if(password.equals(passwords[i]))
			                        {
									   //sets the found password to pFound
				                       pFound = passwords[i];

			                        }//ends if

							     }//ends for

							     if(password.equals(pFound))
							     {
						            //displays login successfull
							        System.out.println(Util.setLeft(17,"Correct password!"));

								    //skips line
							        System.out.println();

							        //prompts the user for new password
							        System.out.print(Util.setLeft(17,"Enter new password: "));
							        newPassword = Keyboard.readString();

                                    if(!newPassword.equals(password))
                                    {
									   for(int i =0; i<ARRAY_MAX; i++)
									   {
                                          //checks to see if username and password exists
					                      if(password.equals(passwords[i]))
					                      {
									         //replaces password with new password
                                              passwords[i] = newPassword;

                                              //Writes to the file
											  w.write(usernames[i] + " changed password.");

											  //newline
											  w.newLine();

											  //flush
									          w.flush();

									          fwn = new FileWriter(inputFile); //Another object reades from input file
									          wn = new BufferedWriter (fwn);   //Another object writes to output file

											  //Write the ur&pw combinations back to the input file
											  wn.write(usernames[i] + " " + passwords[i]);
											  wn.newLine();

											  //flushes the buffered
											  wn.flush();

											  //closes the buffered
											  wn.close();

                                              //skips a line
                                              System.out.println();

								 	          //Display password was changed
				                              System.out.println(Util.setLeft(17,"Password was change successfully!"));
									       }//ends if
									     }//ends for

								    }//ends inner if
								    else
								    {
										//Display password was changed
				                              System.out.println(Util.setLeft(17,"Invalid password, Please enter a unique pasword!"));
								    }//ends else

								  }//ends if
				                  else
				                  {
									  //Displasy an error
									  System.out.println(Util.setLeft(17, "Wrong password! Please enter a valid password!"));

							      }//ends else

			                     //skips line
				                 System.out.println();
						       }//ends if
				               else
				               {
								   //skips a line
								   System.out.println();

							 	   //Display an error
								   System.out.println(Util.setLeft(17, "Please login to change your password!"));

								   //Skips a line
								   System.out.println();

						       }//ends else

				               //provides the user with many options
				               System.out.print(Util.setLeft(17,"(1)  login\n")+ Util.setLeft(17, "(2)  logout\n")+
								                Util.setLeft(17,"(3)  change password\n")+ Util.setLeft(17,"(-1) quit: "));
	                           option = Keyboard.readInt();

			                   break;

			        case EXIT:

			                   //sets option to quit
			                   option = -1;

			                   //closes FileWriter
					           w.close();

			                   break;
		      }//ends switch
       }//ends while loop

       //closes FileWriter
	   w.close();

    }//ends try
    catch(java.io.FileNotFoundException e)
    {
        //skips a line
        System.out.println();

		//display incorrect file
		System.out.println(Util.setLeft(17,"Incorrect file! Please enter a valid (file.txt)"));

		//skips a line
		System.out.println();

    }//ends catch

    //skips a line
    System.out.println();

    //goodbye message
    System.out.println(Util.setLeft(17, "Thank you for using Miguel's system!"));

    //skips a line
    System.out.println();

  } //end main method
} //ends userManager

