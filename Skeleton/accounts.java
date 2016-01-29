
 /***************************************************************
 * Program Name   : accounts
 * Author         : Miguel Rodriguez
 * Date           : January 29, 2016
 * Course/Section : CSC-264 - 001
 * Program Description: This program creates usernames and passwords
 *    for a user, it then stores that usernames and passwors into
 *    two different arrays. The maximum value of the array is 10.
 *    These functions are perfom using different methods store in
 *    the class userLog
 ****************************************************************/

public class accounts
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
 * BEGIN username(firstname, lastname)
 *    create usernameArray and initialize it from 0 to 9
 *    create passwordArray and initialize it from 0 to 9
 *    IF (firstname < 2 )
 *      fullname = firstname + lastname
 *      take the two letters
 *    ELSE
 *      take the two letters of the firstname
 *    END IF
 *    IF (lastname < 3 )
 *      fullaname = firstname + lastname
 *      take the first three letters
 *    ElSE
 *      take the first three letters
 *    END IF
 *      username.toLowerCase
 *    IF (username = existing username)
 *      create a random number in the range of 1 t 3 inclu
 *      username += random number
 *    ELSE
 *      create a random digit in the range of 1 to 3
 *      username += random digit
 *    END IF
 *      return firstname
 * END username
 **************************************************************/
 public String username()
 {

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
 public String password()
 {


 }//ends password method

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
 *	 BEGIN print
 *	       FOR(each username and password)
 *	          Display "Your usernames are: "
 *	          Display username
 *	          Display "Your passwords are: "
 *	          Display password
 *	       END FOR
 *	    return print
 *   END print
 **************************************************************/
 public void print()
 {
  }//ends print method

}//ends accounts