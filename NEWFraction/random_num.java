/*********************************************************************
 * Program Name   : random_num
 * Author         : Miguel Rodriguez
 * Date           : January 28, 2016
 * Course/Section : CSC-264 - 001
 * Program Description: This program creates random numbers and
 *    and stores them into an array, it then displays them.
 *
 * Methods:
 * -------
 * Main - main(String[] args)
 *
 ********************************************************************/
import java.util.*;
import java.text.*;

public class random_num
{

  /******************************************************************
    * Method Name    : random_num: generate random numbers
    * Author         : Miguel Rodriguez
    * Date           : January 28, 2016
    * Course/Section : CSC-264 - 001
    * Program Description: This program generates a random number between 5 to 10
    *    and than creates and array and intantiates it to the value of the random
    *    number. After that it generates numbers in the range of 0 to 100 inclusive
    *    and inserts them into the array. It them displays each number from the array.
    *
    * BEGIN Pseudocode problem
    *    Generate random_num int between 5 and 10 inclusive
    *    intantiate array random_num
    *    FOR(from zero to array size)
    *       Generate newNum2 between 0 to 100 inclusive
    *       array2[i] = newNum2
    *    END FOR
    *    FOR(each element in array2)
    *      Display array2
    *    END FOR
    * END Pseudocode problem
    ****************************************************************/
public static void main(String[] args)
 {

   //Local Contants

   //Local Variables
   int randomInt;      //stores the first random number
   int Asize;          //stores the size of the array
   int randomInt2;     //stores the second random number
   String title;       //stores the title
   //int rdm1 = 0;     //the first counter for loop one
   //int rdm2 = 0;     //the second counter for loop two

   //formats the output
   DecimalFormat fmt = new DecimalFormat();

   //Creates the random object generator
   Random rnmGen = new Random();

   /********************   Start main method  *****************/

   //generates a number between 5 and 10
   randomInt = rnmGen.nextInt(6)+5;

   //stores an string in the title variable
   title = "First Random Number: ";

   //creates a space
   System.out.println();

   //displays the string
   System.out.print(Util.setLeft(29, title));

   //displays the number
   System.out.println();
   System.out.println(Util.setRight(39, fmt.format(randomInt)));
   //skips a line
   System.out.println();

   //instantiates an array to the previously created random number
   int[] Array1 = new int[randomInt];

   //finds the size of the array and stores it into Asize
   Asize = Array1.length;

   /*repeats for how many times the size of the array
   Generates a random number each time on the range of 0 to 100 inclusive
   stores the random number being generated into the array each time*/
   for(int rdm1 = 0; rdm1<Asize; rdm1++)
     {

      //Generates a number in the range of 0 to 100 inclusive
      randomInt2 = rnmGen.nextInt(101);

      //stores the random number being generated into the array
      Array1[rdm1] = randomInt2;

     }//ends first for loop

   //prints the title
   System.out.println(Util.setLeft(32, "Random Numbers: "));

   //repeats for how many times the size of the array
   for(int rdm2 = 0; rdm2<Asize; rdm2++)
     {
       //displays each element from the array
	   System.out.println(Util.setRight(39, fmt.format(Array1[rdm2])));

     }//ends second for loop

   //creates a space between output and press any key line
   System.out.println();

  }//ends main method
}//ends class random_num