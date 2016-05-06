/******************************************************************
* Program Name   : QDuckPanel
* Author         : Miguel Rodriguez & Luke Cavanaugh
* Date           : 3 March 2016
* Course/Section : CSC 264
* Program Description: This program will create an arraylist of duck
*    objects which will then be painted to the screen. The user wiill
*    then control a scope image used to shoot the ducks. Also, this panel
*    will show number of hits, lives left, and also contain a pause, play,
*    and exit button located on the score panel at the top of the users screen.
*
*
* Methods:
* -------
* +QDuckPanel()
* +paintComponent(Graphics page)
* +DuckListener()
* +CoordinatesListener()
* +ScopeMouseMotionListener()
*
* BEGIN QDuckPanel
* 	initialize constants
*	initialize variables
*	create game timer
*	FOR (cycle through ducks)
*		create a new duck and add to arraylist
*	END FOR
*	set the ducks x, y movement
*	TRY (music)
*		load sound file
*	END TRY
*	CATCH
*		handle exceptions
*	END CATCH
*	TRY (shotgun sound)
*		load sound file
*	END TRY
*	CATCH
*		handle exceptions
*	END CATCH
*	TRY (gameover sound)
*		load sound file
*	END TRY
*	CATCH
*		handle exceptions
*	END CATCH
*	set window sizing
*	set background color
*	add mouse,scope listeners
*	create score panel w/ dimensions and background
*	set score panel labels
*	set score panel buttons	(pause,resume,exit)
*	BEGIN resumeButton listener
*		sets pause to false
*	END resumeButton listener
*	BEGIN pauseButton listener
*		sets pause to true
*	END pauseButton listener
*	BEGIN quitButton listener
*		sets exit to true
*	END quitButton listener
*	BEGIN paintComponents
*		IF pause = true
*			FOR (cycle through all ducks)
*				set appearance
*				stop duck
*				paint duck
*				set duck invincible
*			END FOR
*		END IF
*		ELSE
*			FOR (cycle through all ducks)
*				set appearance
*				advance duck
*				paint duck
*				let duck be able to get shot
*			END FOR
*		END ELSE
*		set the scope image and paint
*		set various splatter images based on hit count
*		IF numHits % 2 = 0
*			splash = splash1
*		ELSE IF numHits % 3 = 0
*			splash = splash2
*		ELSE
*			splash = splash3
*		END IF
*		IF duck is shot
*			paint splash image at ducks location
*		END IF
*		IF no lives left
*			reset hits
*			hide panel
*		END IF
*	END paintComponents
*	BEGIN DuckListener
* 		set level 2 bounds
*		set level 3 bounds
*		set level 4 bounds
*		set level 5 bounds
*		set level 6 bounds
*		set level 7 bounds
*		set level 8 bounds
*		set level 9 bounds
*		IF (every 25 kills)
*			FOR (cycle through all ducks)
*				increase speed of ducks
*			END FOR
*		END IF
*		FOR (cycle through ducks)
*			select duck
*			IF ducks location is passed screen
*				reset duck
*				decrement lives left
*				set lives left label
*			END IF
*		END FOR
*	END DuckListener
*	BEGIN CoordinatesListener
*		BEGIN mousePressed
*			set mousex = click
*			set mousy  = click
*			FOR (cycle through ducks)
*				set rectangle
*				IF rectangle contains x and y of click
*					duck = shot
*					reset duck
*					increment number of hits
*					set duckShot to true
*					set hits label
*					repaint
*				END IF
*			END FOR
*		END mousePressed
*	END CoordinatesListener
*	BEGIN ScopeMouseMotionListener
*		BEGIN mouseDragged
*			set scope x
*			set scope y
*	 	END mouseDragged
*		BEGIN mouseMoved
*			scopeX  = motions X
*			scopeY  = motions Y
*		END mouseMoved
*	END ScopeMouseMotionListener
* END QDuckPanel
*******************************************************************/
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;


public class QDuckPanel extends JPanel
{

   //constants
   private final int WIDTH                      = 800;  					   //sets the width
   private final int HEIGHT                     = 500;  					   //sets the height
   private final int DELAY                      = 120;  					   //sets the delay
   private final int IMAGE_SIZE                 = 10;   					   //keeps track of the runaway ducks
   private final int SIZE                       = 15;   					   //diameter of dot

   //variables
   private QDuck duck;														   //new duck object
   private int numDucks                         = duckHuntPanel.difficulty;    //# of ducks that are generated for the game
   private int x;															   //x coordinate
   private int y;															   //y coordinate
   private int moveX;														   //moves duck x
   private int moveY;														   //moves duck y
   private int numHits 							= 0;						   //number of kills
   private int shotX;														   //the x coordinate of the splatter
   private int shotY;														   //the y coordinate of the splatter
   private int scopeX;   													   //the scopes current x
   private int scopeY;                                                         //the scopes current y
   private int mouseX                           = 50;                          //the mouses current x when clicked
   private int mouseY                           = 50;                          //the mouses current y when clicked
   private int livesLeft                        = 10;                          //number of lives left
   private boolean duckShot                     = false;                       //when duck is shot, sets to true
   private boolean pause 						= false;                       //when pause button is pressed, sets to true and runs method
   private boolean exit 					    = false;                       //when quit button is pressed, sets to true and runs method
   private JFrame frame2;                                                      //game frame
   private QDuckGame duckGame;                                                 //new duckGame object
   private JPanel ScorePanel;                                                  //score panel at top of frame
   private JLabel lblScore;                                                    //holds "kills: " text
   private JLabel lblNumHits;                                                  //number of kills label
   private JLabel lblRunawayTag;                                               //holds "Lives Left: " text
   private JLabel lblRunaway;                                                  //value of livesLeft
   private JLabel lblTimer;                                                    //game timer
   private JLabel lblDuckSpeed;                                                //ducks rate of speed
   private JLabel lblDuckSpeedTag;                                             //holds duck speed value
   private ImageIcon image;                                                    //ducks ong image
   private ImageIcon scope;                                                    //sniper scope image
   private ImageIcon splash;                                                   //splatter image
   private javax.swing.Timer timer;                                            //sets the game timer
   private Clip clip2;                                                         //plays sound when duck is kill
   private Clip clip3;                                                         //plays sound fro shotgun
   private Clip clip4;                                                         //plays sound for gameover
   private JButton resumeButton;                                               //resume button in scorepanel
   private JButton quitButton;                                                 //quit button in scorepanel
   private JButton pauseButton;                                                //pause button in scorepanel
   private ArrayList<QDuck> ducks              = new ArrayList<QDuck>();       //creates new arraylist to hold the ducks
   private Rectangle logoImageRect             = new Rectangle(0,0, 100, 100); //creates invisible rectangle around ducks to register when shot

   /******************************************************************
   * Program Name   : QDuckPanel
   * Author         : Miguel Rodriguez & Luke Cavanaugh
   * Date           : 3 March 2016
   * Course/Section : CSC 264
   * Program Description: This program will create an arraylist of duck
   *    objects which willSets up the panel, including the timer for the animation.
   *
   * Methods:
   * -------
   * +QDuckPanel()
   * +paintComponent(Graphics page)
   * +DuckListener()
   * +CoordinatesListener()
   * +ScopeMouseMotionListener()
   *******************************************************************/

   public QDuckPanel()
   {

       //**************Starts QDuckPanel()***************************//


       //new timer to control the game
       timer = new javax.swing.Timer(DELAY, new DuckListener());

       //for loop that runs through all the ducks
       for (int i = 0; i < numDucks; ++i)
       {

        //create a new duck and add to arraylist
        ducks.add(new QDuck());

       }//end for

       //set the direction the duck moves in X
       moveX = 5;

       //set the direction the duck moves in Y
       moveY = 0;

       //Plays the sound when duck is kill
       try
       {
          //open an audio input stream.
          URL url2 = this.getClass().getClassLoader().getResource("die.wav");
          AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(url2);

          //get a sound clip resource.
          clip2 = AudioSystem.getClip();

          //open audio clip and load samples from the audio input stream.
          clip2.open(audioIn2);

          //stop clip
          clip2.stop();

       }//end try

       catch (UnsupportedAudioFileException e)
       {

          //print stack trace
          e.printStackTrace();

       }//end catch

       catch (IOException e)
       {

          //print stack trace
          e.printStackTrace();

       }
       catch (LineUnavailableException e)
       {

          //print stack trace
          e.printStackTrace();

       } //ends music


	   //try statement for shotgun sound
       try
       {

           // Open an audio input stream.
           URL url3 = this.getClass().getClassLoader().getResource("shot.wav");
           AudioInputStream audioIn3 = AudioSystem.getAudioInputStream(url3);

           // Get a sound clip resource.
           clip3 = AudioSystem.getClip();

           // Open audio clip and load samples from the audio input stream.
           clip3.open(audioIn3);

           //stop clip3
           clip3.stop();

       }

       catch (UnsupportedAudioFileException e)
       {

           //print stack trace
           e.printStackTrace();

       }

       catch (IOException e)
       {

          //print stack trace
          e.printStackTrace();

       }

       catch (LineUnavailableException e)
       {

          //print stack trace
          e.printStackTrace();
       }

       //try statement for game over sound
       try
       {

           // Open an audio input stream.
           URL url4 = this.getClass().getClassLoader().getResource("gameOver.wav");
           AudioInputStream audioIn4 = AudioSystem.getAudioInputStream(url4);

           // Get a sound clip resource.
           clip4 = AudioSystem.getClip();

           // Open audio clip and load samples from the audio input stream.
           clip4.open(audioIn4);

           //stop clip3
           clip4.stop();

       }//end catch

       catch (UnsupportedAudioFileException e)
       {

           //print stack trace
           e.printStackTrace();

       }//end catch

       catch (IOException e)
       {

           //print stack trace
           e.printStackTrace();

       }//end catch

       catch (LineUnavailableException e)
       {

           //print stack trace
           e.printStackTrace();

       }//end catch


       //set the preferred window size the WIDTH and HEIGHT size
       setPreferredSize(new Dimension(WIDTH, HEIGHT));

       //create the water-like background
       setBackground(Color.cyan);

       //start the game timer
       timer.start();

       //add the the coordinates lsitener to capture mouse coordinates
       addMouseListener(new CoordinatesListener());

       //add the scope motion listener for the sniper scope
       addMouseMotionListener(new ScopeMouseMotionListener());

       //hides the cursor from the screeen
       setCursor(getToolkit().createCustomCursor(
         new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0),
         "null"));

       //create the score panel at the top of the game screen
       ScorePanel = new JPanel();

       //add the score panel to frame
       add(ScorePanel);

       //set the background of score panel to white
       ScorePanel.setBackground(Color.cyan);

       //set default layout for score panel
       ScorePanel.setLayout(null);

       //set the visibilty of score panel to true
       ScorePanel.setVisible(true);

       //set the dimensions of the score panel
       ScorePanel.setPreferredSize(new Dimension(1200, 40));

       //set the kills label text
       lblScore = new JLabel("Kills : ");

       //set the kills label font and size
       lblScore.setFont(new Font("Verdana", Font.BOLD, 18));

       //set the size of the kills label
       lblScore.setBounds(100, 5, 86, 29);

       //add the kills label to the score panel
       ScorePanel.add(lblScore);

       //creates a label to display the number of hits
       lblNumHits = new JLabel(Integer.toString(numHits));

       //set the font and text size for kills variable
       lblNumHits.setFont(new Font("Verdana", Font.BOLD, 18));

       //set the bounds for the kills variable
       lblNumHits.setBounds(170, 5, 86, 29);

       //add the kills variable to the score panel
       ScorePanel.add(lblNumHits);

       //add the resume button
       resumeButton = new JButton("Resume");

       //set the bounds for the resume button
       resumeButton.setBounds(260, 10, 90, 23);

       //add the resume button to the score panel
       ScorePanel.add(resumeButton);

       //adds the stop button
       pauseButton = new JButton("Pause");

       //set the bounds of the pause button
       pauseButton.setBounds(350, 10, 80, 23);

       //add to score panel
       ScorePanel.add(pauseButton);

       //set lives left text
       lblRunawayTag = new JLabel("Lives Left : ");

       //set the lives left size and font
       lblRunawayTag.setFont(new Font("Verdana", Font.BOLD, 18));

       //set size of label
       lblRunawayTag.setBounds(450, 5, 150, 29);

       //add label
       ScorePanel.add(lblRunawayTag);

       //creates a label to display the number of hits
       lblRunaway = new JLabel(Integer.toString(livesLeft));

       //set label font and size
       lblRunaway.setFont(new Font("Verdana", Font.BOLD, 18));

       //set label size
       lblRunaway.setBounds(570, 5, 100, 29);

       //add label to score panel
       ScorePanel.add(lblRunaway);

       //creates a label to display the number of hits
       lblTimer = new JLabel();

       //set labe lsize and font
       lblTimer.setFont(new Font("Verdana", Font.BOLD, 18));

       //set timer bounds
       lblTimer.setBounds(510, 5, 100, 29);

       //add timer
       ScorePanel.add(lblTimer);

       //creates a label to display the duck speed
       lblDuckSpeedTag = new JLabel("Duck Speed : ");

       //set label size and font
       lblDuckSpeedTag.setFont(new Font("Verdana", Font.BOLD, 18));

       //set label bounds
       lblDuckSpeedTag.setBounds(615, 5, 200, 29);

       //add label
       ScorePanel.add(lblDuckSpeedTag);

       //creates a label to display the number of hits
       lblDuckSpeed= new JLabel("Slow Level 1");

       //set label size and font
       lblDuckSpeed.setFont(new Font("Verdana", Font.BOLD, 18));

       //set label bounds
       lblDuckSpeed.setBounds(760, 5, 250, 29);

       //add label
       ScorePanel.add(lblDuckSpeed);

       //add the resume button
       quitButton = new JButton("Quit Game");

       //set the bounds for the resume button
       quitButton.setBounds(1000, 10, 150, 20);

       //add the resume button to the score panel
       ScorePanel.add(quitButton);

       /******************************************************************
	   * Program Name   : resumeButton - actionPerformed
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method controls the pause function
       *
       *******************************************************************/
       resumeButton.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               //set the pause value to false
               pause = false;
           }

       }); //end resumeButton - actionPerformed

       /******************************************************************
	   * Program Name   : pauseButton - actionPerformed
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method updates the position
	   *    of the image
       *
       *******************************************************************/
       pauseButton.addActionListener(new ActionListener()
       {
    	   public void actionPerformed(ActionEvent arg0)
    	   {
    		  //set pause value to truye
    		  pause = true;
    	   }

    	}); //end pauseButton - actionPerformed

       /******************************************************************
	   * Program Name   : quitButton - actionPerformed
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method updates the position
	   *    of the image
       *
       *******************************************************************/
       quitButton.addActionListener(new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {

			 //**************Starts actionPeformed()*********************//

			 //sets exit value to true
             exit = true;

             //catches any gltiches by setting lives to 0
             livesLeft = 0;
           }

       }); //end quitButton - actionPerformed

   }//end QDuckPanel

   /******************************************************************
   * Program Name   : paintComponents
   * Author         : Miguel Rodriguez & Luke Cavanaugh
   * Date           : 3 March 2016
   * Course/Section : CSC 264
   * Program Description: This method draws the images in
   *    specified locations
   *
   *******************************************************************/

   public void paintComponent(Graphics page)
   {

       //**************Starts paintComponent()**********************//

       //paint compenent page
       super.paintComponent(page);

	   //if pause is set to true or game is over
       if (pause == true || livesLeft <= 0)
       {
          //FOR cycle through all ducks
          for (int i =0; i < numDucks; i++)
          {
             //duck object is current duck
             duck = ducks.get(i);

             //get the appearance
             image = duck.getAppearance();

             //stop the duck
             duck.stop();

             //paint duck at current position
             image.paintIcon(this, page, duck.getCurrentLocation().x, duck.getCurrentLocation().y);

             //set shot rectangle to 0 so duck cannot be shot while in pause or game is over
             logoImageRect.setBounds(0,0, 0, 0);

        }//end for

      }//end if

	  //else game is running normal
      else
      {

         //FOR cycle through all ducks
         for (int i =0; i < numDucks; i++)
        {

             //duck object is current duck
             duck = ducks.get(i);

             //get ducks appearance
             image = duck.getAppearance();

             //advance duck
             duck.advance();

             //paint duck at current position
             image.paintIcon(this, page, duck.getCurrentLocation().x, duck.getCurrentLocation().y);

             //set the shot rectangles bounds
             logoImageRect.setBounds(0,0, 100, 100);

            } //end for

        } //end else

        //set the scope image
        scope = new ImageIcon(getClass().getResource("/scope.png"));

        //paint the scope on screen at mouses current hovering position
        scope.paintIcon(this, page, scopeX, scopeY);

        //if shows various splatter images based on hit count
        if((numHits % 2) == 0)
        {
           //set splash = splash1
           splash = new ImageIcon(getClass().getResource("/splash1.png"));
        }//end else

        else if ((numHits % 3) == 0)
        {
           //set splash = splash
           splash = new ImageIcon(getClass().getResource("/splash.png"));
        }//end else

        else
        {
           //set splash = splash2
           splash = new ImageIcon(getClass().getResource("/splash2.png"));
	    }//end else

        //if duck is shot
        if (duckShot == true)
        {
           //paint splatter at ducks location
           splash.paintIcon(this,page, shotX, shotY);

	    }//end if


        if(livesLeft <= 0)
        {

            HighScore scores = new HighScore();
            scores.setLevel(lblDuckSpeed.getText());

            //plays GameOver sound
            clip4.start();

            //FOR cycles through ducks
            for (int i =0; i < numDucks; i++)
            {
		       //duck object is current duck
       		   duck = ducks.get(i);

       		   //reset hit count for next game
       		   duck.resetHits();

	        }//end for

            try
            {

		       //if exit is set to true
               if (exit == true)
               {

                   //create new duck game
                   duckGame =  new QDuckGame();

                   //hide duck panel
                   duckGame.hidePanel();

                   //set frame invisible
                   frame2.setVisible(false);

               }//end if

           }//end try

           //catch
           catch(Exception e)
           {

              //print to console back to main message
              System.out.println("Back To Main");

           }

      } // end if

   }//end paint


   /******************************************************************
   * Program Name   : DuckListener
   * Author         : Miguel Rodriguez & Luke Cavanaugh
   * Date           : 3 March 2016
   * Course/Section : CSC 264
   * Program Description: Represents the action listener for the timer.
   *
   * Methods:
   * -------
   *
   *******************************************************************/

   private class DuckListener implements ActionListener
   {

       /******************************************************************
	   * Program Name   : actionPerformed
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method updates the position
	   *    of the image
       *
       *******************************************************************/
       public void actionPerformed(ActionEvent event)
       {

           //**************Starts actionPerformed()***************************//

           //move X
           x += moveX;

           //moveY
           y += moveY;

           //set level 2 bounds
           if (numHits >= 25 && numHits < 50)
           lblDuckSpeed.setText("Medium Level 2");

          //set level 3 bounds
          else if (numHits >= 50 && numHits < 75)
          lblDuckSpeed.setText("Fast Level 3");

          //set level 4 bounds
          else if (numHits >= 75 && numHits < 100)
          lblDuckSpeed.setText("Lightening Level 4");

          //set level 5 bounds
          else if (numHits >= 100 && numHits < 150)
          lblDuckSpeed.setText("Carpel Tunnel Level 5");

          //set level 6 bounds
          else if (numHits >= 150 && numHits < 200)
          lblDuckSpeed.setText("Arthritis Level 6");

          //set level 7 bounds
          else if (numHits >= 200 && numHits < 250)
          lblDuckSpeed.setText("Warp Speed Level 7");

          //set level 8 bounds
          else if (numHits >= 250 && numHits < 350)
          lblDuckSpeed.setText("Insanity Level 8");

          //set level 9 bounds
          else if (numHits >= 300)
          lblDuckSpeed.setText("Speed of Light Level9");

          //if statement that changes difficulty
          if (numHits != 0 && (numHits % 25) == 0)
          {
             //for that cylces through ducks
             for (int i = 0; i < numDucks; i++)
             {
                //duck object = current duck
                duck = ducks.get(i);

                //increase speed by
                duck.setSpeed(1);
             }//end for

          } //end if

         for (int i = 0; i < numDucks; i++)
         {
             //duck object = current duck
             duck = ducks.get(i);

            //if duck moves out of the screen, repaint at start of screen
             if (duck.getCurrentLocation().x > 1500)
             {
                //reset the ducks location to offscreen left
                duck.resetDuck(-200);

                //decrement lives left counter
                livesLeft--;

                //set the lives left label to current lives left
                lblRunaway.setText(Integer.toString(livesLeft));

             }//end if

             //if duck enters screen, remove the duckShot value
             if (duck.getCurrentLocation().x > 15)
             {

                 //set duckShot = false
                 duckShot = false;

             }//end if

             //repaint method
             repaint();

         }//end for

       } //end actionPerformed

   }//end DuckListener

   /******************************************************************
   * Program Name   : DuckListener
   * Author         : Miguel Rodriguez & Luke Cavanaugh
   * Date           : 3 March 2016
   * Course/Section : CSC 264
   * Program Description:  Represents the listener for mouse events.
   *
   * Methods:
   * -------
   *
   *******************************************************************/

   private class CoordinatesListener implements MouseListener
   {

       /******************************************************************
	   * Program Name   : mousePressed
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method represents the mouse
	   *    click events
	   *
       *******************************************************************/

       public void mousePressed(MouseEvent event)
       {

           //**************Starts mousePressed()***************************//

           //set the mouses x val to where the mosue was pressed
           mouseX = event.getX();

           //set the mouses y to where the mouse was pressed
           mouseY = event.getY();

           //play duck squeel
           clip3.stop();
           clip3.setFramePosition(0);
           clip3.start();

		   //for cycles through all ducks
           for (int i = 0; i < numDucks; i++)
           {

               //set an invisible rectangle around each duck that registers when shot
               logoImageRect.setLocation(ducks.get(i).getCurrentLocation().x+10, ducks.get(i).getCurrentLocation().y+10);

               //if the mouse is clicked within the bounds of the rectangle (A.K.A. duck is shot)
               if (logoImageRect.contains(mouseX, mouseY))
               {

                   //select the duck at i
                   duck = ducks.get(i);

                   //set the ducks appearance to image
                   duck.setAppearance(image);

                   //call the isShot() method
                   duck.isShot();

                   //reset the duck back to the left of the screen
                   duck.resetDuck(-200);

                   //incremement the hit counter
                   numHits = ducks.get(i).getHits();

                   //set the duckshot equal to true
                   duckShot = true;
                   shotX = mouseX-75;
                   shotY = mouseY-75;

                   HighScore scores2 = new HighScore();
                   scores2.setScore(numHits);

 			       //play duck squeel
                   clip2.stop();
                   clip2.setFramePosition(0);
                   clip2.start();

                   //converts the number of hits from int to string(to display in label)
                   lblNumHits.setText(Integer.toString(numHits));

                   //repaint
                   repaint();
               }//end if

           } //end for

       }//end listener

         //empty definitions for unused mouse event methods
         public void mouseClicked(MouseEvent event) {}
         public void mouseReleased(MouseEvent event) {}
         public void mouseEntered(MouseEvent event) {}
         public void mouseExited(MouseEvent event) {}

   }//end mouse listener

   /******************************************************************
   * Program Name   : ScopeMouseMotionListener
   * Author         : Miguel Rodriguez & Luke Cavanaugh
   * Date           : 3 March 2016
   * Course/Section : CSC 264
   * Program Description: This method represents the listener for mouse events.
   *
   * Methods:
   * -------
   * +mouseDragged(MouseEvent e)
   * +mouseMoved(MouseEvent e)
   *******************************************************************/

   public class ScopeMouseMotionListener implements MouseMotionListener
   {

       /******************************************************************
	   * Program Name   : mouseDragged
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method represents the mouse
	   *    click and drag events
	   *
       *******************************************************************/
       public void mouseDragged(MouseEvent e)
       {

          //**************Starts mouseDragged()**************************//

          //sets the scopes x coordinate
           scopeX = e.getX()-55;

           //sets the scopes y coordiante
           scopeY = e.getY()-55;

       }//end mouseDragged

	   /******************************************************************
	   * Program Name   : mouseMoved
	   * Author         : Miguel Rodriguez & Luke Cavanaugh
	   * Date           : 3 March 2016
	   * Course/Section : CSC 264
	   * Program Description: This method represents the mouse
	   *    motion events
	   *
       *******************************************************************/
       public void mouseMoved(MouseEvent e)
       {

           //**************Starts mouseMoved()***************************//

           //set the scopes x coordinate
           scopeX = e.getX()-55;

           //sets the scopes y coordinate
           scopeY = e.getY()-55;

       }//end mouseMoved

    }//end ScopeMouseListener

} //end class