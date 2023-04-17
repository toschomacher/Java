import java.awt.Color;

import javax.swing.JOptionPane;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public abstract class GraphicsSystem extends LBUGraphics
{

	public GraphicsSystem() 
	{	
		super();
		System.out.println("GraphicsSystem constructor called");
	}
	private void tCap(int x, int y, int stroke, int size)
	{
		setxPos(x);
		setyPos(y);
		setStroke(stroke);
		penDown();
		forward(5 * size);
		turnLeft(180);
		forward(5 * size);
		turnLeft(90);
		forward(2 * size);
		turnLeft(180);
		forward(4 * size);
		penUp();
		forward(25);
		turnRight(90);
	}

	private void oSml(int x, int y, int stroke, int size)
	{
		setxPos(x);
		setyPos(y);
		setStroke(stroke);
		penDown();
		turnRight(90);
		forward(1 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(2 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(2 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(135);
		penUp();
		forward(200);
	}

	private void dSml(int x, int y, int stroke, int size)
	{
		setxPos(x);
		setyPos(y);
		setStroke(stroke);
		penDown();
		turnRight(90);
		forward(1 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(2 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(45);
		forward(5 * size);
		turnLeft(180);
		forward(6 * size);
		turnLeft(180);
		forward(3 * size);
		turnLeft(45);
		forward(1 * size);
		turnLeft(135);
		penUp();
		forward(200);
	}

	private void rSml(int x, int y, int stroke, int size)
	{
		setxPos(x);
		setyPos(y);
		setStroke(stroke);
		penDown();
		forward(4 * (int) (size * 0.85));
		turnLeft(180);
		forward(3 * (int) (size * 0.85));
		turnRight(45);
		forward(1 * size);
		turnRight(45);
		forward(1 * size);
		penUp();
		forward(55);
		turnRight(45);
	}

	private void square(int length)
	{
		for (int i = 0; i < 4; i++)
		{
			setPenColour(getPenColour());
			penDown();
			forward(length);
			turnLeft(90);
			penUp();
		}
		turnRight(90); // taking the turtle
		forward(40); // away from the square
		turnLeft(90); // so it's visible
	}

	private void triangle(int length)
	{
		turnRight(30);
		for (int i = 0; i < 3; i++)
		{
			setPenColour(getPenColour());
			penDown();
			forward(length);
			turnLeft(120);
			penUp();
		}
		turnRight(60); // taking the turtle
		forward(40); // away from the square
		turnLeft(90); // so it's visible
	}
	public void about() // overriding the about method
	{
		setBackground_Col(Color.DARK_GRAY);
		clear();
		super.about();
		myName();
		System.out.println("My about method called.");
	}

	public void reset()
	{
		super.reset();
		penDown();
	}

	private void myName()
	{
		//Letters letter = new Letters();
		setTurtleSpeed(1);
		setPenColour(Color.BLACK);
		tCap(318, 300, 2, 10);
		oSml(345, 318, 2, 10);
		dSml(375, 318, 2, 10);
		oSml(405, 318, 2, 10);
		rSml(417, 318, 2, 10);
		setxPos(105);
		setyPos(305);
		setPenColour(Color.WHITE);
		penDown();
		circle(50);
		penUp();
		System.out.println("Calling myName method.");
	}

	protected void commands(String command)
	{
		String message1 = "Invalid parameter";
		displayMessage("");
		String par;
		String[] myArray = command.toLowerCase().split(" ");
		String cmd = myArray[0];
		int values;
		int arLength = myArray.length;
		boolean comValidation = false;
		// Setting up variables
		if (arLength > 1)
		{
			par = myArray[1];
			try
			{
				values = Integer.parseInt(myArray[1]);
				if (values<0)
				{
					values = -1;
				}
			} catch (NumberFormatException e)
			{
				values = -1;
				displayMessage(message1);
			}
		} else
		{
			par = null;
			values = 0;
			displayMessage("No parameter entered");
		}
		// FORWARD
		if (cmd.equals("forward") && arLength == 1)
		{
			forward(40); // Default forward value
			displayMessage("Missing parameter. Default Forward called");
			comValidation = true;
		} else if (cmd.equals("forward") && arLength > 1 && values !=-1 && values !=0)
		{
			forward(values);
			displayMessage("Forward by " + par + " pixels");
			comValidation = true;
		} else if (cmd.equals("forward") && arLength > 1 && values ==-1)
		{
			displayMessage(message1);
			comValidation = true;
		} else if (cmd.equals("forward") && arLength > 1 && values ==0)
		{
			displayMessage("Enter parameter higher than 0");
			comValidation = true;
		}
		// BACKWARD
		if (cmd.equals("backward") && arLength == 1)
		{
			forward(-40); // Default forward value
			displayMessage("Missing parameter. Default Backward called");
			comValidation = true;
		} else if (cmd.equals("backward") && arLength > 1 && values !=-1 && values !=0)
		{
			forward(values*-1);
			displayMessage("Forward by " + par + " pixels");
			comValidation = true;
		} else if (cmd.equals("backward") && arLength > 1 && values ==-1)
		{
			displayMessage(message1);
			comValidation = true;
		} else if (cmd.equals("backward") && arLength > 1 && values ==0)
		{
			displayMessage("Enter parameter higher than 0");
			comValidation = true;
		}
		// Turn LEFT
		if (cmd.equals("left"))
		{
			if (arLength == 1)
			{
				turnLeft();
				comValidation = true;
				displayMessage("Missing parameter. Default Left called");
			} else
			{
				turnLeft(values);
				comValidation = true;
			}
		}
		// Turn RIGHT
		if (cmd.equals("right"))
		{
			if (myArray.length == 1)
			{
				turnRight();
				comValidation = true;
				displayMessage("Missing parameter. Default Right called");
			} else
			{
				par = myArray[1]; // TO DO integer validation
				values = Integer.parseInt(par);
				turnRight(values);
				comValidation = true;
			}
		}
		// CLEAR
		if (cmd.equals("clear"))
		{
			clear();
			comValidation = true;
		}
		// Pen commands for UP DOWN and COLOUR
		if (cmd.equals("pen"))
		{
			if (myArray.length == 1)
			{
				displayMessage("Missing parameter");
				return;
			}
			par = myArray[1];
			if (par.equals("red"))
			{
				setPenColour(Color.RED);
				comValidation = true;
			}
			if (par.equals("green"))
			{
				setPenColour(Color.GREEN);
				comValidation = true;
			}
			if (par.equals("blue"))
			{
				setPenColour(Color.BLUE);
				comValidation = true;
			}
			if (par.equals("black"))
			{
				setPenColour(Color.BLACK);
				comValidation = true;
			}
			if (par.equals("white"))
			{
				setPenColour(Color.WHITE);
				comValidation = true;
			}
			if (par.equals("yellow"))
			{
				setPenColour(Color.YELLOW);
				comValidation = true;
			}
			if (par.equals("up"))
			{
				penUp();
				comValidation = true;
			}
			if (par.equals("down"))
			{
				penDown();
				comValidation = true;
			}
		}
		// Background colour
		if (cmd.equals("background"))
		{
			if (myArray.length == 1)
			{
				displayMessage("Missing parameter");
				return;
			}
			par = myArray[1];
			if (par.equals("red"))
			{
				setBackground_Col(Color.RED);
				clear();
				comValidation = true;
			}
			if (par.equals("green"))
			{
				setBackground_Col(Color.GREEN);
				clear();
				comValidation = true;
			}
			if (par.equals("blue"))
			{
				setBackground_Col(Color.BLUE);
				clear();
				comValidation = true;
			}
			if (par.equals("black"))
			{
				setBackground_Col(Color.BLACK);
				clear();
				comValidation = true;
			}
			if (par.equals("white"))
			{
				setBackground_Col(Color.WHITE);
				clear();
				comValidation = true;
			}
			if (par.equals("yellow"))
			{
				setBackground_Col(Color.YELLOW);
				clear();
				comValidation = true;
			}
		}
		// PAINT
		if (cmd.equals("paint"))
		{
			paintComponent(getGraphics());
			comValidation = true;
		}
		// SQUARE
		if (cmd.equals("square") && arLength == 1)
		{
			displayMessage("Missing parameter. Drawing a default square");
			square(20);
			comValidation = true;
		} else if (cmd.equals("square") && arLength > 1)
		{
			square(values);
			comValidation = true;
		}
		// TRIANGLE
		if (cmd.equals("triangle") && arLength == 1)
		{
			displayMessage("Missing parameter. Drawing a default triangle");
			triangle(20);
			comValidation = true;
		} else if (cmd.equals("triangle") && arLength > 1 && values!=-1 && values !=0)
		{
			triangle(values);
			comValidation = true;
		} else if (cmd.equals("triangle") && arLength > 1 && values==0)
		{
			displayMessage("Enter parameter higher than 0");
			comValidation = true;
		}
		// RESET
		if (cmd.equals("reset"))
		{
			reset();
			comValidation = true;
		}
		// ABOUT
		if (cmd.equals("about"))
		{
			clear();
			reset();
			about();
			comValidation = true;
		}
		// COMMAND VALIDATION must be last in this method to validate commands above
		if (!comValidation)
		{
			displayMessage("Final if - Invalid command");
			JOptionPane.showMessageDialog(getComponentPopupMenu(), "Press OK to continue!", "Invalid command",
					JOptionPane.WARNING_MESSAGE);
			displayMessage("Enter command");
		}
	}
}
