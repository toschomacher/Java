package todor.lbu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Commands extends GraphicsSystem
{
	JFrame mainFrame = new JFrame("Turtle Graphics Application");
	JLabel lbl4 = new JLabel(); //pen image label
	private String txt1, txt2, txt3, txt4;
	public int penIsDown = 1; //1 = pen down and 0 = pen up
	private static final long serialVersionUID = 1L;
	private ImageIcon[] imgs;

	public void myGUI(Commands tHis)
	{
		System.out.println("myGUI method called");
		txt1 = "<html>This program was partly developed by Todor Vasilev, "
				+ "LBU student - CS4D 2022-2023.<br><br>Student ID - c3643417<br>"
				+ "_____________________________________</html>";
		txt2 = "<html>Available commands:<br>" + "ABOUT - plays Turtle Graphics Demo<br>"
				+ "RESET - resets the turtle at the start<br>" + "CLEAR - clears the drawing field<br>"
				+ "TURNRIGHT or TURNRIGHT [parameter]<br>" + "PENUP<br>" + "PENDOWN<br></html>";
		txt3 = "<html>Saving commands history</html>";
		txt4 = "<html>Loading file</html>";
		
		// Array with list of file names
		String[] files = new String[]
		{ "penup.png", "pendown.png" };
		//Images path
		String path = "C:/Users/tosch/eclipse-workspace/TurtleGraphics/Images/";
		imgs = new ImageIcon[files.length];
		for(int k = 0; k < imgs.length; k++)
		{
			imgs[k] = new ImageIcon(path + files[k]);
		}
		lbl4 = new JLabel(imgs[1]);
		lbl4.setBounds(10, 10, 80, 80);
		mainFrame.add(lbl4);
		lbl4.setBounds(1000, 275, 80, 80);
		JLabel lbl1 = new JLabel(); //Main label for user interaction
		JLabel lbl2 = new JLabel(txt1);
		JLabel lbl3 = new JLabel("");
		JButton btn1 = new JButton("Close");
		JButton btn2 = new JButton("Help");
		JButton btn3 = new JButton("Save");
		JButton btn4 = new JButton("Load");
		lbl3.setVerticalAlignment(JLabel.TOP);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(3);
		mainFrame.setLayout(null);
		// Adding TurtleGraphics Panel to the main frame
		mainFrame.add(tHis);
		mainFrame.setBounds(240, 200, 1100, 440);
		// Bevel Border LOWERED for additional interaction
		lbl1.setBounds(805, 10, 275, 340);
		lbl1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		lbl2.setBounds(810, 15, 255, 95); // setting the size and position of the label
		mainFrame.add(lbl2); // adding the label to the window
		lbl3.setBounds(810, 110, 255, 195); // setting the size and position of the label
		mainFrame.add(lbl3);
		mainFrame.add(lbl1);
		// Button 1 CLOSE
		btn1.setBounds(800, 360, 70, 30);
		mainFrame.add(btn1);
		btn1.addActionListener(e -> System.exit(0));
		// Button 2 HELP
		btn2.setBounds(871, 360, 70, 30);
		mainFrame.add(btn2);
		btn2.addActionListener(e -> lbl3.setText(txt2));
		// Button 3 SAVE
		btn3.setBounds(942, 360, 70, 30);
		mainFrame.add(btn3);
		btn3.addActionListener(e ->
		{
			lbl3.setText(txt3); // adding the label to the window
		});
		// Button 4 LOAD
		btn4.setBounds(1013, 360, 70, 30);
		mainFrame.add(btn4);
		btn4.addActionListener(e ->
		{
			lbl3.setText(txt4);
		});
		// Main frame visible
		mainFrame.setVisible(true); // now display it
	}
	//Overriding penUp()
	public void penUp()
	{
		penIsDown = 0;
		lbl4.setIcon(imgs[penIsDown]);
		displayMessage("Pen is up");
		super.penUp();
	}
	//Overriding penDown()
	public void penDown()
	{
		penIsDown = 1;
		lbl4.setIcon(imgs[penIsDown]);
		displayMessage("Pen is down");
		super.penDown();
	}
	
	public Commands()
	{
		System.out.println("Commands class constructor called");
		
		myGUI(this);
		penDown();
	}

	public void processCommand(String command)
	{
		String msgInvalidPar = "Invalid/non-numeric parameter";
		String msgExcessiveNum = "Excessively large number input";
		displayMessage("");
		String parStr1;
		String[] myArray = command.toLowerCase().split(" ");
		String cmd = myArray[0];
		int parameter1;
		int parameter2;
		int parameter3 = -1;
		int arLength = myArray.length;
		boolean validCommand = true;
		boolean doubleCheck = true;
		
		// Setting up variables
		if (arLength == 2)
		{
			parStr1 = myArray[1];
			try
			{
				parameter1 = Integer.parseInt(myArray[1]);
				parameter2 = -1;
				parameter3 = -1;
				if (parameter1 < 0)
				{
					parameter1 = -1;
				} else if (parameter1 > 999)
				{
					displayMessage(msgExcessiveNum);
				}
			} catch (NumberFormatException e)
			{
				parameter1 = -1;
				parameter2 = -1;
				parameter3 = -1;
				displayMessage(msgInvalidPar);
				doubleCheck = false;
			}
		} else if (arLength == 4)
		{
			parStr1 = myArray[1];
			try
			{
				parameter1 = Integer.parseInt(myArray[1]);
				if (parameter1 < 0)
				{
					parameter1 = -1;
				} else if (parameter1 > 999)
				{
					displayMessage(msgExcessiveNum);
				}
			} catch (NumberFormatException e)
			{
				parameter1 = -1;
				displayMessage(msgInvalidPar);
			}
			try
			{
				parameter2 = Integer.parseInt(myArray[2]);
				if (parameter2 < 0)
				{
					parameter2 = -1;
					System.out.println("Catch p2 called");
				} else if (parameter1 > 999)
				{
					displayMessage(msgExcessiveNum);
				}
			} catch (NumberFormatException e)
			{
				parameter2 = -1;
				displayMessage(msgInvalidPar);
			}
			try
			{
				parameter3 = Integer.parseInt(myArray[3]);
				if (parameter3 < 0)
				{
					parameter3 = -1;
				} else if (parameter1 > 999)
				{
					displayMessage(msgExcessiveNum);
				}
			} catch (NumberFormatException e)
			{
				parameter3 = -1;
				displayMessage(msgInvalidPar);
				System.out.println("Catch p3 called");
			}
		} else
		{
			parStr1 = null;
			parameter1 = 0;
			parameter2 = 0;
			parameter3 = 0;
		}

		// COMMANDS CHECK LIST

		// ABOUT
		if (cmd.equals("about"))
		{
			clear();
			reset();
			about();
		}
		// ALIGN TURTLE
		else if (cmd.equals("align"))
		{
			align(getDirection());
		}
		// BACKGROUND COLOUR
		else if (cmd.equals("background"))
		{
			if (arLength == 1)
			{
				displayMessage("Missing parameter");
				return;
			} else if (arLength == 2)
			{
				parStr1 = myArray[1];
				if (parStr1.equals("red"))
				{
					setBackground_Col(Color.RED);
					displayMessage("Background set to red");
					clear();
				} else if (parStr1.equals("green"))
				{
					setBackground_Col(Color.GREEN);
					displayMessage("Background set to green");
					clear();
				} else if (parStr1.equals("blue"))
				{
					setBackground_Col(Color.BLUE);
					displayMessage("Background set to blue");
					clear();
				} else if (parStr1.equals("black"))
				{
					setBackground_Col(Color.BLACK);
					displayMessage("Background set to black");
					clear();
				} else if (parStr1.equals("white"))
				{
					setBackground_Col(Color.WHITE);
					displayMessage("Background set to white");
					clear();
				} else if (parStr1.equals("yellow"))
				{
					setBackground_Col(Color.YELLOW);
					displayMessage("Background set to yellow");
					clear();
				} else
				{
					displayMessage(msgInvalidPar);
				}
			}
			// BACKGROUND R G B
			else if (arLength == 4)
			{
				if (parameter1 >= 0 && parameter1 <= 255 && parameter2 >= 0 && parameter2 <= 255 && parameter3 >= 0
						&& parameter3 <= 255)
				{
					displayMessage("Custom background colour set");
					setBackground_Col(myColour(parameter1, parameter2, parameter3));
					clear();
				} else
				{
					displayMessage("Invalid parameter. Each parameter should be a number between 0 and 255");
				}
			} else
			{
				displayMessage(msgInvalidPar);
			}
		}
		// BACKWARD
		else if (cmd.equals("backward") && arLength == 1)
		{
			displayMessage("Missing parameter. Default Backward called");
			forward(-40); // Default forward value
		} else if (cmd.equals("backward") && arLength == 2 && parameter1 > 0 && parameter1 < 1000)
		{
			displayMessage("Backward by " + parStr1 + " pixels");
			forward(parameter1 * -1);
		} else if (cmd.equals("backward") && arLength == 2 && parameter1 > 999)
		{
			displayMessage(msgExcessiveNum);
		} else if (cmd.equals("backward") && arLength == 2 && parameter1 == -1)
		{
			displayMessage(msgInvalidPar);
		} else if (cmd.equals("backward") && arLength == 2 && parameter1 == 0)
		{
			displayMessage("Enter parameter higher than 0");
		} else if (cmd.equals("backward") && arLength > 2)
		{
			displayMessage(msgInvalidPar);
		}
		// CLEAR
		else if (cmd.equals("clear"))
		{
			if (screenUpdate)
			{
				int dialogButton = JOptionPane.showConfirmDialog(null,
						"Graphics not saved. " + "Are you sure you want to clear the screen without saving?",
						"Unsaved work!", JOptionPane.YES_NO_CANCEL_OPTION);
				if (dialogButton == JOptionPane.YES_OPTION)
				{
					clear();
					screenUpdate = false;
				} else if (dialogButton == JOptionPane.NO_OPTION)
				{
					turnLeft();
				} else if (dialogButton == JOptionPane.CANCEL_OPTION)
				{
					turnRight();
				}
			} else
			{
				clear();
				screenUpdate = false;
			}

		}
		// FILL
		else if (cmd.equals("fill") && arLength == 1)
		{
			try
			{
				fill();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				displayMessage("Not surrounded by graphical area");
			}
		}
		// FORWARD
		else if (cmd.equals("forward") && arLength == 1)
		{
			displayMessage("Missing parameter. Default Forward called");
			forward(40); // Default forward value
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 > 0 && parameter1 < 1000)
		{
			displayMessage("Forward by " + parStr1 + " pixels");
			forward(parameter1);
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 > 999)
		{
			displayMessage(msgExcessiveNum);
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 == -1)
		{
			displayMessage(msgInvalidPar);
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 == 0)
		{
			displayMessage("Enter parameter higher than 0");
		} else if (cmd.equals("forward") && arLength > 2)
		{
			displayMessage(msgInvalidPar);
		}
		// GET DIRECTION
		else if (cmd.equals("direction"))
		{
			displayMessage("Turtle at " + Integer.toString(getDirection()) + " degrees");
		}
		// PEN commands for UP DOWN and COLOUR
		else if (cmd.equals("pen"))
		{
			if (myArray.length == 1)
			{
				displayMessage("Missing parameter");
			} else if (arLength == 2)
			{
				parStr1 = myArray[1];
				if (parStr1.equals("red"))
				{
					setPenColour(Color.RED);
					displayMessage("Pen is red");
				} else if (parStr1.equals("green"))
				{
					setPenColour(Color.GREEN);
					displayMessage("Pen is green");
				} else if (parStr1.equals("blue"))
				{
					setPenColour(Color.BLUE);
					displayMessage("Pen is blue");
				} else if (parStr1.equals("black"))
				{
					setPenColour(Color.BLACK);
					displayMessage("Pen is black");
				} else if (parStr1.equals("white"))
				{
					setPenColour(Color.WHITE);
					displayMessage("Pen is white");
				} else if (parStr1.equals("yellow"))
				{
					setPenColour(Color.YELLOW);
					displayMessage("Pen is yellow");
				} else if (parStr1.equals("up"))
				{
					penUp();
				} else if (parStr1.equals("down"))
				{
					penDown();
				} else
				{
					displayMessage(msgInvalidPar);
				}
			} else
			{
				displayMessage(msgInvalidPar);
			}
		}
		// PENCOLOUR R G B
		else if (cmd.equals("pencolour") && arLength == 4)
		{
			if (parameter1 >= 0 && parameter1 <= 255 && parameter2 >= 0 && parameter2 <= 255 && parameter3 >= 0
					&& parameter3 <= 255)
			{
				displayMessage("Custom pen colour set");
				setPenColour(myColour(parameter1, parameter2, parameter3));
			} else
			{
				displayMessage("Invalid parameter. Each parameter should be a number between 0 and 255");
			}
		} else if (cmd.equals("pencolour"))
		{
			displayMessage("Missing parameter");
		}
		// PEN STATE
		else if (cmd.equals("penstate"))
		{
			if (getPenState())
			{
				displayMessage("Pen is DOWN");

			} else
			{
				displayMessage("Pen is UP");
			}
		}
		// PEN STROKE GETTER
		else if (cmd.equals("penwidth") && arLength == 1)
		{
			displayMessage("The width of the pen is " + Float.toString(getStroke()));
		}
		// PEN STROKE SETTER
		else if (cmd.equals("penwidth") && arLength == 2)
		{

			if (parameter1 >= 1 && parameter1 <= 10)
			{
				displayMessage("Pen width set to " + Integer.toString(parameter1));
				setStroke(parameter1);
			} else if (!doubleCheck)
			{
				displayMessage(msgInvalidPar);
			}

			else
			{
				displayMessage("Pen width parameter shoud be a value betwean 1 and 10");
			}
		}
		// RESET
		else if (cmd.equals("reset"))
		{
			reset();
			penIsDown = 1;
			lbl4.setIcon(imgs[penIsDown]);
			displayMessage("Reset successful");
		}
		// SAVE LOAD FILE
		else if (cmd.equals("save") && arLength == 2 && parStr1.equals("commands"))
		{
			FileHandling();
		}
		// SQUARE
		else if (cmd.equals("square") && arLength == 1)
		{
			displayMessage("Missing parameter. Drawing a default square");
			square(20);
		} else if (cmd.equals("square") && arLength > 1)
		{
			square(parameter1);
		}
		// TRIANGLE
		else if (cmd.equals("triangle") && arLength == 1)
		{
			displayMessage("Missing parameter. Drawing a default triangle");
			triangle(20);
		} else if (cmd.equals("triangle") && arLength > 1 && parameter1 != -1 && parameter1 != 0 && arLength != 4)
		{
			triangle(parameter1);
		} else if (cmd.equals("triangle") && arLength > 1 && parameter1 == 0 && arLength != 4)
		{
			displayMessage("Enter parameter higher than 0");
		}
		// TRIANGLE WITH PARAMETERS
		else if (cmd.equals("triangle") && arLength == 4)
		{
			displayMessage("Drawing custom triangle");
			triangle(parameter1, parameter2, parameter3);
		}
		// TURN LEFT
		else if (cmd.equals("left"))
		{
			if (arLength == 1)
			{
				displayMessage("Missing parameter. Default Left called");
				turnLeft();
			} else
			{
				turnLeft(parameter1);
			}
		}
		// TURN RIGHT
		else if (cmd.equals("right"))
		{
			if (arLength == 1)
			{
				displayMessage("Missing parameter. Default Right called");
				turnRight();
			} else
			{
				turnRight(parameter1);
			}
		}
		// X GET POSITION
		else if (cmd.equals("xpos"))
		{
			xPosition();
		}
		// X SET POSITION
		else if (cmd.equals("setx") && arLength == 2 && parameter1 >= 0 && parameter1 <= 800)
		{
			setxPos(parameter1);
			turnLeft(360);
		} else if (cmd.equals("setx"))
		{
			displayMessage("Enter parameter between 0 and 800");
		}
		// Y GET POSITION
		else if (cmd.equals("ypos"))
		{
			yPosition();
		}
		// Y SET POSITION
		else if (cmd.equals("sety") && arLength == 2 && parameter1 >= 0 && parameter1 <= 400)
		{
			setyPos(parameter1);
			turnLeft(360);
		} else if (cmd.equals("sety"))
		{
			displayMessage("Enter parameter between 0 and 800");
		}
		// FINAL ELSE validating commands
		else
		{
			validCommand = false;
		}
		// COMMAND VALIDATION must be the last if statement in this method to validate
		// all commands above
		if (!validCommand)
		{
			displayMessage("Final if - Invalid command");
			JOptionPane.showMessageDialog(getComponentPopupMenu(), "Press OK to continue!", "Invalid command",
					JOptionPane.WARNING_MESSAGE);
			displayMessage("Enter command");
		}
	}
}
