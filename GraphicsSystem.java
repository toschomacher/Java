package todor.lbu;

import java.awt.Color;
import java.io.*;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public abstract class GraphicsSystem extends LBUGraphics
{

	boolean screenUpdate = false;
	private static final long serialVersionUID = 1L;

	public GraphicsSystem()
	{
		System.out.println("GraphicsSystem class constructor called");
	}

	// FILE SAVE LOAD
	@SuppressWarnings("resource")
	public void FileHandling()
	{
		final int ENDOFFILE = -1;
		FileInputStream in = null;
		FileOutputStream out = null;

		try
		{
			in = new FileInputStream("input.txt");
		} catch (FileNotFoundException e)
		{

			displayMessage("File not found");
			return;
		}

		try
		{
			out = new FileOutputStream("output.txt");
		} catch (FileNotFoundException e)
		{
			displayMessage("Cannot write file");
			return;
		}

		int c = 0;

		do
		{
			try
			{
				c = in.read();

				System.out.print("*" + (char) c);
				if (c != ENDOFFILE)
				{
					out.write(c);
					displayMessage("File writing successful");
				}

			} catch (IOException e)
			{
				System.out.println("error reading/writing file");
				return;
			}
		} while (c != ENDOFFILE);

		try
		{
			in.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			out.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished");

	}

	// CUSTOM COLOUR
	public Color myColour(int r, int g, int b)
	{
		Color color = new Color(r, g, b);
		return color;
	}

	public void forward(int distance)
	{
		super.forward(distance);
		if (getPenState())
		{
			screenUpdate = true;
		}
		if (xPos > 800)
		{
			System.out.println("Out of bounds");
			setxPos(800);
			turnLeft(360);
			return;
		}
		if (xPos < 0)
		{
			System.out.println("Out of bounds");
			setxPos(0);
			turnLeft(360);
			return;
		}
		if (yPos > 400)
		{
			System.out.println("Out of bounds");
			setyPos(400);
			turnLeft(360);
			return;
		}
		if (yPos < 0)
		{
			System.out.println("Out of bounds");
			setyPos(0);
			turnLeft(360);
			return;
		}
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
		// forward(200);
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
		// forward(200);
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
		turnRight(90);
	}

	protected void square(int length)
	{
		if ((getxPos() + length * 4 + 5) > 800 || (getyPos() + length * 4 + 5) > 400)
		{
			displayMessage("Can not draw a square of this size that close to boarders");
		} else
		{
			for (int i = 0; i < 4; i++)
			{
				setPenColour(getPenColour());
				penDown();
				forward(length * 4);
				turnLeft(90);
				penUp();
			}
			turnRight(90); // taking the turtle
			forward(40); // away from the square
			turnLeft(90); // so it's visible
		}
	}

	protected void triangle(int length)
	{
		if ((getxPos() + length * 4) > 800 || getxPos() < length * 4 || (getyPos() + length * 4) > 400
				|| getyPos() < length * 4)
		{
			displayMessage("Can not draw a triangle of this size that close to boarders");
		} else
		{
			turnRight(30);
			for (int i = 0; i < 3; i++)
			{
				setPenColour(getPenColour());
				penDown();
				forward(length * 4);
				turnLeft(120);
				penUp();
			}
			turnRight(60); // taking the turtle
			forward(40); // away from the square
			turnLeft(90); // so it's visible
		}

	}

	protected void triangle(int length1, int length2, int length3)
	{
		if ((getxPos() + length2 * 4 + 5) > 800 || (getyPos() + length1 * 4 + 5) > 400)
		{
			displayMessage("Can not draw a triangle of this size that close to boarders");
		} else
		{
			int currentXpos = getxPos();
			int currentYpos = getyPos();
			reset();
			setxPos(currentXpos);
			setyPos(currentYpos);
			penDown();
			forward(length1 * 4);
			turnLeft(90);
			forward(length2 * 4);
			turnLeft(150);
			forward(length3 * 4);
			penUp();
			turnLeft(120);
			forward(-50);
		}
	}

	public void about() // overriding the about method
	{
		setBackground_Col(Color.DARK_GRAY);
		clear();
		displayMessage("Todor Vasilev");
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
		// Letters letter = new Letters();
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

	public void xPosition()
	{
		System.out.println(getxPos());
		displayMessage(Integer.toString(getxPos()));
	}

	public void yPosition()
	{
		System.out.println(getyPos());
		displayMessage(Integer.toString(getyPos()));
	}

	public void align(int degrees)
	{
		String message1 = "You are already aligned";
		String message2 = "You are diagonaly, no alignment necessary";
		if (degrees < 0)
		{
			degrees *= -1;
			if (degrees == 0 || degrees == 90 || degrees == 180 || degrees == 270)
			{
				displayMessage(message1);
			} else
			{
				if (1 <= degrees && degrees <= 44)
				{
					turnRight(degrees);
				} else if (46 <= degrees && degrees <= 89)
				{
					turnLeft(90 - degrees);
				} else if (91 <= degrees && degrees <= 134)
				{
					turnRight(degrees - 90);
				} else if (136 <= degrees && degrees <= 179)
				{
					turnLeft(180 - degrees);
				} else if (181 <= degrees && degrees <= 224)
				{
					turnRight(degrees - 180);
				} else if (226 <= degrees && degrees <= 269)
				{
					turnLeft(270 - degrees);
				} else if (271 <= degrees && degrees <= 314)
				{
					turnRight(degrees - 270);
				} else if (316 <= degrees && degrees <= 359)
				{
					turnLeft(360 - degrees);
				} else
				{
					displayMessage(message2);
				}
			}
		} else
		{
			if (degrees == 0 || degrees == 90 || degrees == 180 || degrees == 270)
			{
				displayMessage(message1);
			} else
			{
				if (1 <= degrees && degrees <= 44)
				{
					turnLeft(degrees);
				} else if (46 <= degrees && degrees <= 89)
				{
					turnRight(90 - degrees);
				} else if (91 <= degrees && degrees <= 134)
				{
					turnLeft(degrees - 90);
				} else if (136 <= degrees && degrees <= 179)
				{
					turnRight(180 - degrees);
				} else if (181 <= degrees && degrees <= 224)
				{
					turnLeft(degrees - 180);
				} else if (226 <= degrees && degrees <= 269)
				{
					turnRight(270 - degrees);
				} else if (271 <= degrees && degrees <= 314)
				{
					turnLeft(degrees - 270);
				} else if (316 <= degrees && degrees <= 359)
				{
					turnRight(360 - degrees);
				} else
				{
					displayMessage(message2);
				}
			}
		}
	}
}
