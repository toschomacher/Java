package Todor;

import java.awt.Color; //imported by Todor
//import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import uk.ac.leedsbeckett.oop.LBUGraphics;

class MyHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
}

public class MainClass extends LBUGraphics
{
	public static void main(String[] args)
	{
		new MainClass(); // create instance of class that extends LBUGraphics (could be separate class
							// without main), gets out of static context
	}

	public MainClass()
	{	
		JFrame MainFrame = new JFrame("Turtle Graphics Application"); // create a frame to display the turtle panel on
		
		//Button 1

		MainFrame.setResizable(false);
		MainFrame.setDefaultCloseOperation(3);
		MainFrame.setLayout(null);
		setMaximumSize(null);
		
		String txt = "<html>This program is in process of development by Todor Vasilev," +
					 " a student from LBU CS4D.<br><br>Todor is still learning.</html>";
		JLabel lbl = new JLabel(txt);
		lbl.setBounds(810,15,260,95);	//setting the size and position of the label
		MainFrame.add(lbl);	//adding the label to he window
		
		JButton btn1 = new JButton("Close");
		btn1.setBounds(900,340, 100, 30);
		MainFrame.add(btn1);
		MyHandler hnd = new MyHandler();
		btn1.addActionListener(hnd);
		//MainFrame.setLayout(new FlowLayout(2)); // not strictly necessary
		MainFrame.add(this); // "this" is this object that extends turtle graphics so we are adding a turtle
								// graphics panel to the frame
		//MainFrame.setSize(1100,400); // set the frame to a size we can see
		MainFrame.setBounds(550, 350, 1100, 435);
		MainFrame.setVisible(true); // now display it

		// about(); //call the LBUGraphics about method to display version information.
	}

	public void processCommand(String command) // this method must be provided because LBUGraphics will call it when
												// it's JTextField is used
	{
		// String parameter is the text typed into the LBUGraphics JTextfield
		// lands here if return was pressed or "ok" JButton clicked
		// TO DO

		String par;
		String[] myArray = command.split(" ");
		String cmd = myArray[0];
		int values;
		int arLength = myArray.length;

		// Setting up variables
		if (myArray.length > 1)
		{
			par = myArray[1];
			try
			{
				values = Integer.parseInt(myArray[1]);
				// true code
			} catch (NumberFormatException e)
			{
				// false code
				values = 0;
			}
		} else
		{
			par = null;
			values = 0;
		}

		// FORWARD
		if (cmd.equals("forward") && arLength == 1)
		{
			forward(20); // Default forward value
		} else if (cmd.equals("forward") && arLength > 1)
		{
			forward(values);
		}

		// Turn LEFT
		if (cmd.equals("left"))
		{
			if (arLength == 1)
			{
				turnLeft();
			} else
			{
				turnLeft(values);
			}
		}

		// Turn RIGHT
		if (cmd.equals("right"))
		{
			if (myArray.length == 1)
			{
				turnRight();
			} else
			{
				par = myArray[1]; // TO DO integer validation
				values = Integer.parseInt(par);
				turnRight(values);
			}
		}

		// CLEAR
		if (cmd.equals("clear"))
			clear();

		// Pen commands for UP DOWN and COLOUR
		if (cmd.equals("pen"))
		{
			par = myArray[1];
			if (par.equals("red"))
				setPenColour(Color.RED);
			if (par.equals("green"))
				setPenColour(Color.GREEN);
			if (par.equals("blue"))
				setPenColour(Color.BLUE);
			if (par.equals("black"))
				setPenColour(Color.BLACK);
			if (par.equals("white"))
				setPenColour(Color.WHITE);
			if (par.equals("yellow"))
				setPenColour(Color.YELLOW);
			if (par.equals("up"))
				penUp();
			if (par.equals("down"))
				penDown();
		}

		// Background colour
		// still not working
		if (cmd.equals("background"))
		{
			par = myArray[1];
			if (par.equals("red"))
			{
				setBackground_Col(Color.RED);
				clear();
			}
			if (par.equals("green"))
			{
				setBackground_Col(Color.GREEN);
				clear();
			}
			if (par.equals("blue"))
			{
				setBackground_Col(Color.BLUE);
				clear();
			}
			if (par.equals("black"))
			{
				setBackground_Col(Color.BLACK);
				clear();
			}
			if (par.equals("white"))
			{
				setBackground_Col(Color.WHITE);
				clear();
			}
			if (par.equals("yellow"))
			{
				setBackground_Col(Color.YELLOW);
				clear();
			}
		}

		// RESET
		if (cmd.equals("reset"))
		{
			reset();
		}

	}

}
