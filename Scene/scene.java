 /**********************************************************
 * Program Name   : scene
 * Author         : Miguel Rodriguez
 * Date           : February 31, 2016
 * Course/Section : CSC264
 * Program Description: This program creates a scene using swing.
 * Methods:
 * -------
 * +main(String[] args)
 *
 **********************************************************/
import java.awt.*;
import javax.swing.*;

public class scene extends JFrame {
	/**********************************************************
	* Method Name    : scene - creates a scene
	* Author         : Miguel Rodriguez
	* Date           : February 31, 2016
	* Course/Section : CSC264
	* Program Description: Creates a scene using java swing.
	*
	* BEGIN scene
	*    creates a frame
	*    creates panel
	*    change the color of the panel
	*    creates many labels to adds images and text
	* END scene
    **********************************************************/

	public static void main(String[] args)
	{

        //Local Contants

        //Local variables


        /************************Start main**************************/
        //creates the frame
        JFrame frame = new JFrame("Milky Way");

        //sets the frame to visible
	    frame.setVisible(true);

		//exits the application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//sets the bounds of the frame
		frame.setBounds(100, 100, 692, 428);

		//creates a JPanel
		JPanel contentPane = new JPanel();

		//sets the background color to black
		contentPane.setBackground(Color.BLACK);

		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        //sets the content pane
		frame.setContentPane(contentPane);

		//sets the contentPane layout to null
		contentPane.setLayout(null);


        //creates a label for the image sun
		JLabel lblNewLabel = new JLabel();

		//sets the size of the label
		lblNewLabel.setBounds(10, 31, 262, 206);

		//adds the new label to the content pane
		contentPane.add(lblNewLabel);

        //import the sun's image
		ImageIcon img = new ImageIcon("sun.jpg");

		//adds the image to the label
		lblNewLabel.setIcon(img);


        //creates a second label
		JLabel label = new JLabel();

		//sets the bounds of the label
		label.setBounds(254, 70, 99, 148);

		//adds it to the content pane
		contentPane.add(label);

        //imports the image from directory
		ImageIcon img2 = new ImageIcon("mercury.jpg");

		//adds it to the second label
		label.setIcon(img2);


        //creates a third label
		JLabel label_1 = new JLabel();

		//sets the bounds or the size of the label
		label_1.setBounds(349, 81, 107, 100);

		//adds the label to the content pane
		contentPane.add(label_1);

        //imports the image from the directory
		ImageIcon img3 = new ImageIcon("venus.jpg");

		//adds the image to the label
		label_1.setIcon(img3);


        //creates a fourth label
		JLabel label_2 = new JLabel();

		//sets the bounds of the label
		label_2.setBounds(466, 59, 107, 122);

		//adds the label to the content pane
		contentPane.add(label_2);

        //imports the image from directory
		ImageIcon img4 = new ImageIcon("earth.jpg");

		//adds the image to the label
		label_2.setIcon(img4);


        //creates label number five
		JLabel label_3 = new JLabel();

		//sets the bounds
		label_3.setBounds(556, 11, 107, 92);

		//adds label to the content pane
		contentPane.add(label_3);

        //import image from the directory
		ImageIcon img5 = new ImageIcon("mars.jpg");

		//adds the image to the label
		label_3.setIcon(img5);


        //creates a label
		JLabel label_4 = new JLabel();

		//sets the bounds for the label
		label_4.setBounds(-28, 297, 144, 81);

		//adds the label to the content pane
		contentPane.add(label_4);


        //imports an image from the directory
		ImageIcon img6 = new ImageIcon("sat.jpg");

		//adds the image to the label
		label_4.setIcon(img6);


        //creates a label
		JLabel label_5 = new JLabel();

		//sets bounds for the label
		label_5.setBounds(448, 216, 228, 173);

		//adds the label to the content pane
		contentPane.add(label_5);


        //imports an image from the directory
		ImageIcon img7 = new ImageIcon("ship.jpg");

		//adds the image to the label
		label_5.setIcon(img7);


        //creates a label
		JLabel label_6 = new JLabel();

		//sets the bounds for the label
		label_6.setBounds(478, 32, 80, 53);

		//adds the label to the content pane
		contentPane.add(label_6);


        //imports an image from the diectory
		ImageIcon img8 = new ImageIcon("moon.jpg");

		//adds the image to the label
		label_6.setIcon(img8);

		JLabel label_text = new JLabel("Hello");

	}//ends main
}//end class scene