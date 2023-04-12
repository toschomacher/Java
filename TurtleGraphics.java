package todor.lbu;

import java.awt.Color; //imported by Todor
//import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import uk.ac.leedsbeckett.oop.LBUGraphics;

class MyHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}

public class MainClass extends LBUGraphics {
	Letters letter = new Letters();

	public static void main(String[] args) {
		new MainClass(); // create instance of class that extends LBUGraphics (could be separate class
							// without main), gets out of static context
	}

	public void about() // overriding the about method
	{
		setBackground_Col(Color.DARK_GRAY);
		clear();
		super.about();
		myName();
		System.out.println("My about method called.");
	}

	public void myName() {

		setTurtleSpeed(1);
		setPenColour(Color.BLACK);
		letter.tCap(318, 300, 2, 10);
		letter.oSml(345, 318, 2, 10);
		letter.dSml(375, 318, 2, 10);
		letter.oSml(405, 318, 2, 10);
		letter.rSml(417, 318, 2, 10);
		setxPos(105);
		setyPos(305);
		setPenColour(Color.WHITE);
		penDown();
		circle(50);
		penUp();
		System.out.println("Calling myName method.");
	}

	public MainClass() {
		JLabel lbl1 = new JLabel();
		JFrame mainFrame = new JFrame("Turtle Graphics Application"); // create a frame to display the turtle panel on
		lbl1.setBounds(805, 18, 275, 90);
		lbl1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		// Button 1

		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(3);
		mainFrame.setLayout(null);
		setMaximumSize(null);
		//setPreferredSize(1000, 600);	// not working for now
		//setPanelSize(1000, 600);		// not working for now
		String txt = "<html>This program is in process of development by Todor Vasilev, "
				+ "LBU student - CS4D 2022-2023.<br><br>Student ID - c3643417</html>";
		JLabel lbl2 = new JLabel(txt);
		lbl2.setBounds(810, 15, 265, 95); // setting the size and position of the label
		mainFrame.add(lbl2); // adding the label to the window
		mainFrame.add(lbl1);
		JButton btn1 = new JButton("Close");

		btn1.setBounds(810, 340, 80, 30);

		mainFrame.add(btn1);

		MyHandler hnd = new MyHandler();
		btn1.addActionListener(hnd);

		// mainFrame.setLayout(new FlowLayout(2)); // not strictly necessary
		mainFrame.add(this); // "this" is this object that extends turtle graphics so we are adding a turtle
								// graphics panel to the frame
		// mainFrame.setSize(1100,400); // set the frame to a size we can see
		mainFrame.setBounds(240, 200, 1100, 440); // 1080p 1k resolution
		// mainFrame.setBounds(390, 270, 1100, 435); //1440p 2k resolution
		// mainFrame.setBounds(550, 350, 1100, 435); //2160p 4k resolution
		mainFrame.setVisible(true); // now display it

		about(); // call the LBUGraphics about method to display version information.
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
		if (myArray.length > 1) {
			par = myArray[1];
			try {
				values = Integer.parseInt(myArray[1]);
				// true code
			} catch (NumberFormatException e) {
				// false code
				values = 0;
			}
		} else {
			par = null;
			values = 0;
		}

		// FORWARD
		if (cmd.equals("forward") && arLength == 1) {
			forward(20); // Default forward value
		} else if (cmd.equals("forward") && arLength > 1) {
			forward(values);
		}

		// Turn LEFT
		if (cmd.equals("left")) {
			if (arLength == 1) {
				turnLeft();
			} else {
				turnLeft(values);
			}
		}

		// Turn RIGHT
		if (cmd.equals("right")) {
			if (myArray.length == 1) {
				turnRight();
			} else {
				par = myArray[1]; // TO DO integer validation
				values = Integer.parseInt(par);
				turnRight(values);
			}
		}

		// CLEAR
		if (cmd.equals("clear"))
			clear();

		// Pen commands for UP DOWN and COLOUR
		if (cmd.equals("pen")) {
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
		if (cmd.equals("background")) {
			par = myArray[1];
			if (par.equals("red")) {
				setBackground_Col(Color.RED);
				clear();
			}
			if (par.equals("green")) {
				setBackground_Col(Color.GREEN);
				clear();
			}
			if (par.equals("blue")) {
				setBackground_Col(Color.BLUE);
				clear();
			}
			if (par.equals("black")) {
				setBackground_Col(Color.BLACK);
				clear();
			}
			if (par.equals("white")) {
				setBackground_Col(Color.WHITE);
				clear();
			}
			if (par.equals("yellow")) {
				setBackground_Col(Color.YELLOW);
				clear();
			}
		}

		// RESET
		if (cmd.equals("reset")) {
			reset();
		}

		// ABOUT
		if (cmd.equals("about")) {
			clear();
			reset();
			about();
		}

	}

	class Letters {
		public void tCap(int x, int y, int stroke, int size) {
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

		public void oSml(int x, int y, int stroke, int size) {
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

		public void dSml(int x, int y, int stroke, int size) {
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

		public void rSml(int x, int y, int stroke, int size) {
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
	}
}
