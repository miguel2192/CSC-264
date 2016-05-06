/*************************************************************************************
 * Program Name   : ducklHuntPanel.java
 * Author         : Luke Cavanaugh & Miguel Rodriguez
 * Date           : May 5, 2016
 * Course/Section : CSC264
 * Program Description:  Creates a frame and stacks multiple panels on top
 *    using the card layout. This eliminates having mutiple frames and
 *    it makes it nicer for the user to navegate through windows. Also it allows
 *    the user to start the game as well as to pause or play the background music.
 *
 *
 * Methods:
 * -------
 * +duckHuntPanel()
 **************************************************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class duckHuntPanel extends JFrame
{

  //*************************creates a frame and multiple panels,labels etc**********************//

  //Global Constants

  //Global variables
  private JPanel mainPanel;                                       //creates main panel
  private JPanel panelMain;                                       //creates pane main
  private JPanel panelNewGame;                                    //creates panel new game
  private JPanel panelHighScores;                                 //creates panel high scores
  private JPanel panelHelp;                                       //creates panel help
  private JPanel panelInfo;                                       //creates panel info
  private JTextField txtGetsName;                                 //creates a texfield to get users name
  private JSlider slider;                                         //creates a slider
  private JLabel lblMainMenu;                                     //holds a title main menu label for main menu
  private JLabel lblSetDifficulty;                                //holds a set difficulty label for main menu
  private JLabel lblEnterPlayersName;                             //holds a enter player name label for main menu
  private JLabel lblHighScores;                                   //holds a high scores label for main menu
  private JLabel lblAboutDuckHunt;                                //holds a about duck hunt label for main menu
  private JLabel lblAuthors;                                      //holds a authors label for main menu
  private JLabel lblGameInstructions;                             //holds a game instructions label for main menu
  private JLabel lblLow;                                          //holds a low label for main menu
  private JLabel lblMax;                                          //holds a max label for main menu
  private JLabel label;                                           //holds a label for main menu
  private JLabel lblNewLabel_2;                                   //holds a label for main menu
  private JLabel lblLukeCavanaugh;                                //holds a author label for main menu
  private JLabel lblRodriguez;                                    //holds a author label for main menu
  private JLabel lblDescriptionDucksniperIs;                      //holds a description label for main menu
  private JLabel lblDucksniperIsA;                                //holds a descripton label for main menu
  private JLabel lblThatAllowsPlayers;                            //holds a description label for main menu
  private JLabel lblWhetherAdvanceOr;                             //holds a description label for main menu
  private JLabel lblHaveTheOption;                                //holds a description label for main menu
  private JLabel lblCopyright;                                    //holds a description label for main menu
  private JLabel lblNewLabel_9;                                   //holds a label for main menu
  private JLabel lblNewLabel_5;                                   //holds a label for main menu
  private JLabel lblNewLabel_6;                                   //holds a label for main menu
  private JLabel lblNewLabel_7;                                   //holds a label for main menu
  private JLabel lblNewLabel_8;                                   //holds a label for main menu
  private JLabel lblDucksCrossThe;                                //holds a instructions label for main menu
  private JLabel lblSettings ;                                    //holds a instructions label for main menu
  private JLabel lblThereAreDifferent;                            //holds a instructions label for main menu
  private JLabel lblYouCanSelect;                                 //holds a instructions label for main menu
  private JLabel lblPossibleUsingThe;                             //holds a instructions label for main menu
  private JLabel lblScoring;                                      //holds a instructions label for main menu
  private JLabel lblScoringIsDetermined;                          //holds a instructions label for main menu
  private JLabel lblShootAlsoThe;                                 //holds a instructions label for main menu
  private JLabel lblDifficultyAreDisplayed;                       //holds a instructions label for main menu
  private JLabel lblAdditionalInformation;                        //holds a instructions label for main menu
  private JLabel lblThanksForPlaying;                             //holds a instructions label for main menu
  private JLabel lblNewLabel_10;                                  //holds a label for main menu
  private JButton btnNewGame;                                     //creates new game button
  private JButton btnHighScores;                                  //creates high scores button
  private JButton btnHelp,btnInfo;                                //creates help button
  private JButton btnStartGame;                                   //creates strat game button
  private JButton btnBackToMain1;                                 //creates backtomain1 button
  private JButton btnBackToMain2;                                 //creates backtomain2 button
  private JButton btnBackToMain3;                                 //creates backtomain3 button
  private JButton btnBackToMain4;                                 //creates backtomain4 button
  private JButton btnNewButton_2;                                 //creates play button
  private JButton btnStop;                                        //creates stop button
  private JButton btnExitGame;                                    //creates exit button
  private static String holder;                                   //holds the title of high scores
  private static String name;                                     //holds the player's name
  private String userAns;                                         //string variable to store users answer in the exit button
  private Clip clip;                                              //creates clip to play background music
  private Clip clip2;                                             //creates clip to play tick sound for buttons
  private SliderListener listener;                                //creates a slider listener to listen to slider
  public static int difficulty                  = 17;             //sets the difficulty
  private JTextArea scoreArea;                                    //creates text area

 /*************************************************************************************
 * Program Name   : duckHuntPanel()
 * Author         : Luke Cavanaugh & Miguel Rodriguez
 * Date           : May 5, 2016
 * Course/Section : CSC264
 * Program Description:  Creates a frame and stacks multiple panels on top
 *    using the card layout. This eliminates having mutiple frames and
 *    it makes it nicer for the user to navegate through windows.
 *
 *
 * Methods:
 * -------
 * +duckHuntPanel()
 *
 *
 * Begin duckHuntPanel()
 *    Initialiaze local constants
 *    Initialize local variables
 *    uses try/catch to catch exceptions related to audio
 *       gets audio from directory
 *       open the audio file and plays the background music
 *       keeps the audio playing in an infinite loop
 *    Ends try/catch
 *    uses try/catch to catch exceptions related to audio
 *       open the audio file and waits until user presses a button to play a tick sound
 *    Ends try/catch
 *    sets the title of the JFrame
 *    sets the size of the frame
 *    sets all the feautures necessary for the frame
 *    creates a panel main
 *    creates a new game panel
 *    creates a high scores panel
 *    creates a creates a help panel
 *    creates a creates a info panel
 *    displays "Main Menu" using a label
 *    under main menu title we have many buttons
 *    first button is New Game button
 *    New Game button sets the new game panel visible & panel main to invisible
 *    High scores button set high scores panel visible & panel main invisible
 *    help button sets the help panel visible & panel main invisible
 *    info button sets the info panel visible & panel main invisible
 *    exit button exits the games but checks if the user really wants to quit
 *    we add 'back to main' buttons for each panel except the panel main
 *    back to main butons set the panel main visible & the current panel invisible
 *    in the new game panel we add a slider to let user set difficulty
 *    in the new game panel we add a textfield to let the user enter their name
 *    in the new game panel we add a button that allows the user to start the game
 *    the button start game in the new game panel calls QduckGame class wish calls the QDcukPanel
 *    the high scores panel shows the name of the player with the scores
 *    the help panel provides the user with instructions to play the game
 *    the info panel provides information abou the game and its creators
 *    creates a play sound button that plays the background music
 *    creates a pause button the pauses the music
 *    creates a listener for the slider to store the difficulty or number of ducks
 * Ends duckHuntPanel()
 **************************************************************************************/
 public duckHuntPanel()
 {
	 //Local constants

	 //Local variables

	 //*********************Starts constructor*************************************//

     //*********************Plays Background music*********************************//
     try
     {
	   // Open an audio input stream.
	   URL url = this.getClass().getClassLoader().getResource("falling.wav");
	   AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

	   // Get a sound clip resource.
	   clip = AudioSystem.getClip();

	   // Open audio clip and load samples from the audio input stream.
	   clip.open(audioIn);

       //starts the song
	   clip.start();

	   //plays the song in a loop
	   clip.loop(Clip.LOOP_CONTINUOUSLY);

     }//ends try
     catch (UnsupportedAudioFileException e)
     {
        //prints StackTrace
        e.printStackTrace();

     }//ends catch
     catch (IOException e)
     {

		//prints StackTrace
        e.printStackTrace();

     }//ends catch
     catch (LineUnavailableException e)
     {
		//prints StackTrace
        e.printStackTrace();

     }//ends catch
     //*********************Ends Play Background music*********************************//

     //*********************Plays sound for buttons************************************//
     try
     {
	    // Open an audio input stream.
		URL url2 = this.getClass().getClassLoader().getResource("tick.wav");
	    AudioInputStream audioIn2 = AudioSystem.getAudioInputStream(url2);

		// Get a sound clip resource.
		clip2 = AudioSystem.getClip();

		// Open audio clip and load samples from the audio input stream.
		clip2.open(audioIn2);

		//stop the sound from playing
		clip2.stop();

     }//ends try
     catch (UnsupportedAudioFileException e)
     {
	    //prints StackTrace
        e.printStackTrace();

     }//catch
     catch (IOException e)
     {
	    //prints StackTrace
        e.printStackTrace();

     }//ends catch
     catch (LineUnavailableException e)
     {
		//prints StackTrace
        e.printStackTrace();
     }
     //*********************Ends Play sound for buttons************************************//


     //sets the title of the frame
     setTitle("FPS DuckSniper");

     //makes sures the application fully closes
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     //set the bounds of the frame
     setBounds(100, 100, 487, 392);

     //sets localtion to null which centers the frame
     setLocationRelativeTo(null);

     //keeps the user from resizing the application
     setResizable(false);

     //creates a main panel
     mainPanel = new JPanel();

     //adds mainpanel to contentPane
     setContentPane(mainPanel);

     //sets the layout of mainpanel to cardLayout
     mainPanel.setLayout(new CardLayout(0, 0));

     //creates panelMain(Menu)
     panelMain = new JPanel();

     //adds panelMain to mainPanel
     mainPanel.add(panelMain);

     //sets the layout of panelmain to null(none)
     panelMain.setLayout(null);

     //creates a label named lblMainMenu and adds it to panelMain
     lblMainMenu = new JLabel("Main Menu");
     lblMainMenu.setFont(new Font("Arial Black", Font.BOLD, 25));
     lblMainMenu.setBounds(150, 11, 197, 44);
     panelMain.add(lblMainMenu);

     //adds a button named btnNewGame to panelMain
     btnNewGame = new JButton("New Game");
     btnNewGame.setBounds(160, 82, 143, 40);
     panelMain.add(btnNewGame);
     btnNewGame.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent arg0)
        {
           //sets the new game panel to visible
           panelNewGame.setVisible(true);

           //sets the main panel to invisible
           panelMain.setVisible(false);

           //plays the button sound
           clip2.stop();
           clip2.setFramePosition(0);
           clip2.start();

        }
     });//ends button listener

     //creates a button named btnHighScores and adds it to panelMain
     btnHighScores = new JButton("High Scores");
     btnHighScores.setBounds(160, 133, 143, 40);
     panelMain.add(btnHighScores);
     btnHighScores.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {

           //sets high scores panel to visible
           panelHighScores.setVisible(true);

           //sets the main panel to invisible
           panelMain.setVisible(false);

           //plays sound for button
           clip2.stop();
           clip2.setFramePosition(0);
           clip2.start();

            //sends name to setter
           HighScore scores = new HighScore();

           //set text to text Area
           scoreArea.setText(holder + "\n" + "   "+ name+ scores.toString());

        }
     });//ends button listener

     //creates a button named btnHelp and adds it to panelMain
     btnHelp = new JButton("Help");
     btnHelp.setBounds(160, 184, 143, 40);
     panelMain.add(btnHelp);
     btnHelp.addActionListener(new ActionListener()
     {
        public void actionPerformed(ActionEvent e)
        {
	       //sets the panel help visible
           panelHelp.setVisible(true);

           //sets the panel main invisible
           panelMain.setVisible(false);

           //plays button sound
           clip2.stop();
           clip2.setFramePosition(0);
           clip2.start();

       }
    });//ends button listener

    //creates a button named btnInfo and adds it to panelMain
    btnInfo = new JButton("Info");
    btnInfo.setBounds(160, 235, 143, 40);
    panelMain.add(btnInfo);
    btnInfo.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e)
       {
		  //sets the panel info visible
          panelInfo.setVisible(true);

          //sets the panel main invisible
          panelMain.setVisible(false);

          //plays button sound
          clip2.stop();
          clip2.setFramePosition(0);
          clip2.start();

       }
    });//ends button listener

    //creates panelNewGame
    panelNewGame = new JPanel();

    //adds panelNewGame to mainPanel
    mainPanel.add(panelNewGame);

    //sets the layout for paneNewGame to null(none)
    panelNewGame.setLayout(null);

    //creates a slider
    slider = new JSlider( 1, 35);

    //sets the bounds of the slider
    slider.setBounds(126, 78, 228, 20);

    //creates a label for the first bound
    lblLow = new JLabel("0");
    lblLow.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblLow.setBounds(132, 60, 50, 100);
    panelNewGame.add(lblLow);

    //creates a label for the second bound
    lblMax = new JLabel("10");
    lblMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
    lblMax.setBounds(335, 60, 50, 100);
    panelNewGame.add(lblMax);

    //adds a listener to the slider
    listener = new SliderListener();
    slider.addChangeListener(listener);

    //adds the slider to panelNewGame
    panelNewGame.add(slider);

    //adds a label to panelNewGame to set the difficulty
    lblSetDifficulty = new JLabel("Set Difficulty");
    lblSetDifficulty.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblSetDifficulty.setBounds(126, 31, 165, 26);
    panelNewGame.add(lblSetDifficulty);

    //adds a label to panelNewGame to enter the payer's name
    lblEnterPlayersName = new JLabel("Enter Player's Name");
    lblEnterPlayersName.setFont(new Font("Tahoma", Font.BOLD, 17));
    lblEnterPlayersName.setBounds(126, 178, 204, 26);
    panelNewGame.add(lblEnterPlayersName);

    //adds a textField to panelNewGame to get the name from the user
    txtGetsName = new JTextField();
    txtGetsName.setBounds(126, 215, 228, 33);
    panelNewGame.add(txtGetsName);
    txtGetsName.setColumns(10);

    //adds a button to panelNewGame to start the game
    btnStartGame = new JButton("Start Game");
    btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnStartGame.setBounds(126, 259, 165, 52);
    panelNewGame.add(btnStartGame);

    btnStartGame.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent arg0)
       {

          //plays button sound
          clip2.stop();
          clip2.setFramePosition(0);
          clip2.start();

          //plays the background music continuesly
          clip.loop(Clip.LOOP_CONTINUOUSLY);
          clip.stop();

          //gets the name of the user
           name = txtGetsName.getText();

          //calls QDuckGame
          String[] arguments = new String[] {"123"};
          QDuckGame.main(arguments);
          setVisible(false);

       }
    });//ends listener

    //adds button to paneNewGame to go back to main
    btnBackToMain1 = new JButton("Back To Main");
    btnBackToMain1.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnBackToMain1.setBounds(334, 306, 117, 26);
    panelNewGame.add(btnBackToMain1);
    btnBackToMain1.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e)
       {
		  //sets the main panel to visible
          panelMain.setVisible(true);

          //sets the new game panel invisible
          panelNewGame.setVisible(false);

          //plays the button sound
          clip2.stop();
          clip2.setFramePosition(0);
          clip2.start();
       }
    });

    //creates a panel named HighScores and adds it to mainPanel
    panelHighScores = new JPanel();
    mainPanel.add(panelHighScores);
    panelHighScores.setLayout(null);

    //creates a label named lblHighScores and adds it to panelHighScores
    lblHighScores = new JLabel("High Scores");
    lblHighScores.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblHighScores.setBounds(142, 24, 186, 37);
    panelHighScores.add(lblHighScores);

    //created a button named btnBackToMain3 and adds it to panelHighScores
    btnBackToMain3 = new JButton("Back To Main");
    btnBackToMain3.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnBackToMain3.setBounds(334, 301, 117, 31);
    panelHighScores.add(btnBackToMain3);
    btnBackToMain3.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e)
       {
		  //sets the main panel to visible
          panelMain.setVisible(true);

          //sets the high scores panel to invisible
          panelHighScores.setVisible(false);

          //plays button sound
          clip2.stop();
          clip2.setFramePosition(0);
          clip2.start();
      }
    });//ends listener

    //creates another panel named panelHel and adds it to mainPanel
    panelHelp = new JPanel();
    mainPanel.add(panelHelp);

    //sets the panelHelp layout to null
    panelHelp.setLayout(null);

    //creates a button name btnBackToMain and adds it to panelHelp
    btnBackToMain2 = new JButton("Back To Main");
    btnBackToMain2.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnBackToMain2.setBounds(334, 303, 117, 29);
    panelHelp.add(btnBackToMain2);
    btnBackToMain2 .addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e)
       {
		  //sets the main panel to visible
          panelMain.setVisible(true);

          //sets the help panel to invisible
          panelHelp.setVisible(false);

          //plays button sound
          clip2.stop();
          clip2.setFramePosition(0);
          clip2.start();
      }
    });//ends listener

    //creates another panel called panelInfo
    panelInfo = new JPanel();

    //adds panelinfo to mainPanel
    mainPanel.add(panelInfo);

    //sets panelInfo's layout to null(none)
    panelInfo.setLayout(null);

    //creates a label named lblAboutDuckHunt and adds it to panelInfo
    lblNewLabel_2 = new JLabel("About DuckSniper");
    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
    lblNewLabel_2.setBounds(118, 11, 260, 37);
    panelInfo.add(lblNewLabel_2);

    //creates a label named lblAuthors and adds it to panelInfo
    JLabel lblVersion = new JLabel("Version: ");
    lblVersion.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblVersion.setBounds(118, 46, 86, 29);
    panelInfo.add(lblVersion);

    //creates a label for the version #
    label = new JLabel("1.0.0.0");
    label.setFont(new Font("Tahoma", Font.PLAIN, 16));
    label.setBounds(200, 46, 117, 29);
    panelInfo.add(label);

    //creates a label for the authors
    lblAuthors = new JLabel("Authors: ");
    lblAuthors.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblAuthors.setBounds(118, 74, 86, 29);
    panelInfo.add(lblAuthors);

    //creates a label to display authors
    lblLukeCavanaugh = new JLabel("Luke Cavanaugh & ");
    lblLukeCavanaugh.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblLukeCavanaugh.setBounds(199, 76, 188, 29);
    panelInfo.add(lblLukeCavanaugh);

    //prints the name of the second author
    lblRodriguez = new JLabel("Miguel Rodriguez");
    lblRodriguez.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblRodriguez.setBounds(200, 106, 178, 25);
    panelInfo.add(lblRodriguez);

    //descripton of the game
    lblDescriptionDucksniperIs = new JLabel("Description:");
    lblDescriptionDucksniperIs.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblDescriptionDucksniperIs.setBounds(118, 130, 107, 29);
    panelInfo.add(lblDescriptionDucksniperIs);

    //description of the game
    lblDucksniperIsA = new JLabel("DuckSniper is a FPS game");
    lblDucksniperIsA.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblDucksniperIsA.setBounds(235, 132, 204, 29);
    panelInfo.add(lblDucksniperIsA);

    //description of the game
    lblThatAllowsPlayers = new JLabel("that allows players to shoot ducks.");
    lblThatAllowsPlayers.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblThatAllowsPlayers.setBounds(200, 158, 251, 29);
    panelInfo.add(lblThatAllowsPlayers);

    //description of the game
    lblWhetherAdvanceOr = new JLabel("Whether advance or novice, players ");
    lblWhetherAdvanceOr.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblWhetherAdvanceOr.setBounds(200, 184, 261, 29);
    panelInfo.add(lblWhetherAdvanceOr);

    //description of the game
    lblHaveTheOption = new JLabel("have the option to set the difficuty.");
    lblHaveTheOption.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblHaveTheOption.setBounds(200, 209, 251, 29);
    panelInfo.add(lblHaveTheOption);

    //description of the game
    lblCopyright = new JLabel("Copyright \u00A9 All Rights Reserved");
    lblCopyright.setFont(new Font("Tahoma", Font.PLAIN, 20));
    lblCopyright.setBounds(118, 251, 293, 29);
    panelInfo.add(lblCopyright);

    //adds image about
    lblNewLabel_9 = new JLabel("");
    Image img = new ImageIcon(this.getClass().getResource("about.jpg")).getImage();
    lblNewLabel_9.setIcon(new ImageIcon(img));
    lblNewLabel_9.setBounds(22, 11, 86, 308);
    panelInfo.add(lblNewLabel_9);

    //creates a button named btnBackToMain and adds it to panelInfo
    btnBackToMain4 = new JButton("Back To Main");
    btnBackToMain4.setFont(new Font("Tahoma", Font.BOLD, 12));
    btnBackToMain4.setBounds(334, 303, 117, 29);
    panelInfo.add(btnBackToMain4);
    btnBackToMain4.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent e)
       {
		  //sets the main panel visible
          panelMain.setVisible(true);

          //sets the panel info to invisible
          panelInfo.setVisible(false);

          //plays button sound
          clip2.stop();
          clip2.setFramePosition(0);
          clip2.start();
       }
    });//ends listener

    //*********************Starts the instructions*******************************//

    //creates a label named lblGameInstructions and adds it to panelHelp
    lblGameInstructions = new JLabel("Game Instructions");
    lblGameInstructions.setFont(new Font("Arial Black", Font.PLAIN, 20));
    lblGameInstructions.setBounds(73, 11, 222, 15);
    panelHelp.add(lblGameInstructions);

    //title fro ducksniper instructions
    lblNewLabel_5 = new JLabel("DUCKSNIPER INSTRUCTION MANUAL");
    lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblNewLabel_5.setBounds(73, 38, 309, 29);
    panelHelp.add(lblNewLabel_5);

    //purpose of the game
    lblNewLabel_6 = new JLabel("Purpose: ");
    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblNewLabel_6.setBounds(73, 65, 70, 29);
    panelHelp.add(lblNewLabel_6);

    //purpose of the game
    lblNewLabel_7 = new JLabel("Annihilate as many ducks as you can");
    lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblNewLabel_7.setBounds(153, 66, 244, 29);
    panelHelp.add(lblNewLabel_7);

    //purpose of the game
    lblNewLabel_8 = new JLabel("before they cross the river. If too many ");
    lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblNewLabel_8.setBounds(153, 88, 256, 22);
    panelHelp.add(lblNewLabel_8);

    //purpose of the game
    lblDucksCrossThe = new JLabel("ducks cross the river, you lose!!");
    lblDucksCrossThe.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblDucksCrossThe.setBounds(153, 106, 256, 22);
    panelHelp.add(lblDucksCrossThe);

    //purpose of the game
    lblSettings = new JLabel("Settings:");
    lblSettings.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblSettings.setBounds(73, 127, 70, 29);
    panelHelp.add(lblSettings);

    //purpose of the game
    lblThereAreDifferent = new JLabel("There are different settings for difficulty.");
    lblThereAreDifferent.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblThereAreDifferent.setBounds(153, 131, 256, 22);
    panelHelp.add(lblThereAreDifferent);

    //purpose of the game
    lblYouCanSelect = new JLabel("You can select anywhere from easy to impossible ");
    lblYouCanSelect.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblYouCanSelect.setBounds(153, 151, 320, 22);
    panelHelp.add(lblYouCanSelect);

    //purpose of the game
    lblPossibleUsingThe = new JLabel("using the slider in the \"new game\" panel. ");
    lblPossibleUsingThe.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblPossibleUsingThe.setBounds(153, 171, 298, 22);
    panelHelp.add(lblPossibleUsingThe);

    //displays scoring
    lblScoring = new JLabel("Scoring:");
    lblScoring.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblScoring.setBounds(73, 201, 70, 29);
    panelHelp.add(lblScoring);

    //displays scoring
    lblScoringIsDetermined = new JLabel("Scoring is determined by how many ducks you");
    lblScoringIsDetermined.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblScoringIsDetermined.setBounds(153, 204, 298, 22);
    panelHelp.add(lblScoringIsDetermined);

    //displays scoring
    lblShootAlsoThe = new JLabel("shoot. Also, the players name and what ");
    lblShootAlsoThe.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblShootAlsoThe.setBounds(153, 222, 298, 22);
    panelHelp.add(lblShootAlsoThe);

    //displays scoring
    lblDifficultyAreDisplayed = new JLabel("difficulty are displayed as well to provide ");
    lblDifficultyAreDisplayed.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblDifficultyAreDisplayed.setBounds(153, 243, 298, 22);
    panelHelp.add(lblDifficultyAreDisplayed);

    //displays scoring
    lblAdditionalInformation = new JLabel("additional information.");
    lblAdditionalInformation.setFont(new Font("Tahoma", Font.BOLD, 12));
    lblAdditionalInformation.setBounds(153, 265, 298, 22);
    panelHelp.add(lblAdditionalInformation);

    //displays scoring
    lblThanksForPlaying = new JLabel("Thanks for playing DuckSniper!!");
    lblThanksForPlaying.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblThanksForPlaying.setBounds(10, 311, 298, 22);
    panelHelp.add(lblThanksForPlaying);

    //imports & displays the help image
    lblNewLabel_10 = new JLabel("");
    Image img2 = new ImageIcon(this.getClass().getResource("help.jpg")).getImage();
    lblNewLabel_10.setIcon(new ImageIcon(img2));
    lblNewLabel_10.setBounds(17, 22, 46, 278);
    panelHelp.add(lblNewLabel_10);
    //*************************Ends Instructions*************************************//

    //*************************Begins HighScores*************************************//

    //creates a text area to ouput the high scores
   	scoreArea = new JTextArea();
   	scoreArea.setBackground(Color.LIGHT_GRAY);
    scoreArea.setWrapStyleWord(true);
	scoreArea.setLineWrap(true);
    scoreArea.setFont(new Font("Verdana", Font.BOLD, 12));
    scoreArea.setBounds(10, 72, 460, 146);
	panelHighScores.add(scoreArea);

    //creates a title for the high scores
    holder ="   Name" + "\t" + "Score" + "\t" + "Difficulty" + "\t" + "Level" ;

    //*****************Ends high scores********************************//

    //creates a button that exits the game
    btnExitGame = new JButton("Exit Game");
    btnExitGame.setBounds(160, 286, 143, 40);
    panelMain.add(btnExitGame);
    btnExitGame.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent arg0)
       {
          //plays the button sound
          clip2.stop();
          clip2.setFramePosition(0); // rewind to the beginning
          clip2.start();

          //asks the user if they really wish to exit game
          userAns = JOptionPane.showInputDialog ("Are you sure you want to exit the game <y or n>?" );

          if(userAns.equalsIgnoreCase("y"))
          {
			 //exits game
             System.exit(0);

          }//ends if

       }
    });

    //creates a new button to play sound
    btnNewButton_2 = new JButton("Play Sound");
    btnNewButton_2.setBounds(10, 309, 106, 23);
    panelMain.add(btnNewButton_2);
    btnNewButton_2.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
           //plays button sound
           clip2.stop();
           clip2.setFramePosition(0); // rewind to the beginning
           clip2.start();

           //plays backfround music
           clip.start();
           clip.loop(Clip.LOOP_CONTINUOUSLY);


        }
    });//ends button play sound listener


    //create new button to pause sound
    btnStop = new JButton("Pause Sound");
    btnStop.setBounds(338, 309, 113, 23);
    panelMain.add(btnStop);
    btnStop.addActionListener(new ActionListener()
    {
       public void actionPerformed(ActionEvent arg0)
       {

          //plays button sound
          clip2.stop();
          clip2.setFramePosition(0); // rewind to the beginning
          clip2.start();

          //stops background sound
          clip.loop(Clip.LOOP_CONTINUOUSLY);
          clip.stop();

       }

    });//ends button pause sound listener

    //sets the frame to visible
    setVisible(true);

  }//ends constructor

  /*************************************************************************************
  * Program Name   : SliderListener
  * Author         : Luke Cavanaugh & Miguel Rodriguez
  * Date           : May 5, 2016
  * Course/Section : CSC264
  * Program Description:  Uses a slider to set the difficulty of the game. And by difficulty
  *   the number of ducks being generate it.
  *
  *
  * Methods:
  * -------
  **************************************************************************************/
  private class SliderListener implements ChangeListener
  {
	  //Local Constants

	  //Local variables

	  //***********Starts SliderListener************************************************//

      //gets the value of the slider
      public void stateChanged(ChangeEvent event)
      {

         //sets the difficulty using slider
         difficulty = slider.getValue();

         //creates an object
         HighScore scores2 = new HighScore();

         //sets the difficulty to setter in highScores
         scores2.setDiff(difficulty);

      }
   }//ends slider listener

}//ends class