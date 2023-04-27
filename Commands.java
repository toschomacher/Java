package todor.lbu;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Commands extends GraphicsSystem
{
	private static final long serialVersionUID = 1L;

	public Commands()
	{
		// super();
		System.out.println("MainClass constructor called");
		GUIparts myGUI = new GUIparts();
		myGUI.myGUI(this);
		penDown();
	}

	public void processCommand(String command)
	{
		String message1 = "Invalid/non-numeric parameter";
		String message2 = "Excessively large number input";
		displayMessage("");
		String parStr1;
		String[] myArray = command.toLowerCase().split(" ");
		String cmd = myArray[0];
		int parameter1;
		int parameter2 = -1;
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
				if (parameter1 < 0)
				{
					parameter1 = -1;
					parameter2 = -1;
					parameter3 = -1;
				} else if (parameter1 > 999)
				{
					displayMessage(message2);
				}
			} catch (NumberFormatException e)
			{
				parameter1 = -1;
				displayMessage(message1);
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
					displayMessage(message2);
				}
			} catch (NumberFormatException e)
			{
				parameter1 = -1;
				displayMessage(message1);
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
					displayMessage(message2);
				}
			} catch (NumberFormatException e)
			{
				parameter2 = -1;
				displayMessage(message1);
			}
			try
			{
				parameter3 = Integer.parseInt(myArray[3]);
				if (parameter3 < 0)
				{
					parameter3 = -1;
				} else if (parameter1 > 999)
				{
					displayMessage(message2);
				}
			} catch (NumberFormatException e)
			{
				parameter3 = -1;
				displayMessage(message1);
				System.out.println("Catch p3 called");
			}
		} else
		{
			parStr1 = null;
			parameter1 = 0;
			parameter2 = 0;
			parameter3 = 0;
			// displayMessage("No parameter entered");
		}

		// COMMANDS LIST

		// FORWARD
		if (cmd.equals("forward") && arLength == 1)
		{
			displayMessage("Missing parameter. Default Forward called");
			forward(40); // Default forward value
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 > 0 && parameter1 < 1000)
		{
			displayMessage("Forward by " + parStr1 + " pixels");
			forward(parameter1);
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 > 999)
		{
			displayMessage(message2);
		}
		else if (cmd.equals("forward") && arLength == 2 && parameter1 == -1)
		{
			displayMessage(message1);
		} else if (cmd.equals("forward") && arLength == 2 && parameter1 == 0)
		{
			displayMessage("Enter parameter higher than 0");
		} else if (cmd.equals("forward") && arLength > 2)
		{
			displayMessage(message1);
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
			displayMessage(message2);
		}
		else if (cmd.equals("backward") && arLength == 2 && parameter1 == -1)
		{
			displayMessage(message1);
		} else if (cmd.equals("backward") && arLength == 2 && parameter1 == 0)
		{
			displayMessage("Enter parameter higher than 0");
		} else if (cmd.equals("backward") && arLength > 2)
		{
			displayMessage(message1);
		}
		// Turn LEFT
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
		// Turn RIGHT
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
		// CLEAR
		else if (cmd.equals("clear"))
		{
			clear();
			if (arLength > 1)
			{
				displayMessage("");
			}
		}
		// Pen commands for UP DOWN and COLOUR
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
					displayMessage("Pen is up");
				} else if (parStr1.equals("down"))
				{
					penDown();
					displayMessage("Pen is down");
				} else
				{
					displayMessage(message1);
				}
			} else
			{
				displayMessage(message1);
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
				displayMessage(message1);
			}

			else
			{
				displayMessage("Pen width parameter shoud be a value betwean 1 and 10");
			}
		}
		// Background colour
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
					displayMessage(message1);
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
				displayMessage(message1);
			}
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
		// RESET
		else if (cmd.equals("reset"))
		{
			reset();
			displayMessage("Reset successful");
		}
		// ABOUT
		else if (cmd.equals("about"))
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
		// GET DIRECTION
		else if (cmd.equals("direction"))
		{
			displayMessage("Turtle at " + Integer.toString(getDirection()) + " degrees");
		}
		// X POSITION
		else if (cmd.equals("xpos"))
		{
			xPosition();
		}
		// SET X POS
		else if (cmd.equals("setx") && arLength == 2 && parameter1 >= 0 && parameter1 <= 800)
		{
			setxPos(parameter1);
			turnLeft(360);
		} else if (cmd.equals("setx"))
		{
			displayMessage("Enter parameter between 0 and 800");
		}
		// Y POSITION
		else if (cmd.equals("ypos"))
		{
			yPosition();
		}
		// SET Y POS
		else if (cmd.equals("sety") && arLength == 2 && parameter1 >= 0 && parameter1 <= 400)
		{
			setyPos(parameter1);
			turnLeft(360);
		} else if (cmd.equals("sety"))
		{
			displayMessage("Enter parameter between 0 and 800");
		} else
		{
			validCommand = false;
		}
		// COMMAND VALIDATION must be last in this method to validate commands above
		if (!validCommand)
		{
			displayMessage("Final if - Invalid command");
			JOptionPane.showMessageDialog(getComponentPopupMenu(), "Press OK to continue!", "Invalid command",
					JOptionPane.WARNING_MESSAGE);
			displayMessage("Enter command");
		}
	}
}
