package todor.lbu;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MainClass extends Commands
{
	private String txt1, txt2, txt3, txt4;

	public static void main(String[] args)
	{

		new MainClass();
	}

	public MainClass()
	{
		super();
		txt1 = "<html>This program was partly developed by Todor Vasilev, "
				+ "LBU student - CS4D 2022-2023.<br><br>Student ID - c3643417<br>"
				+ "_____________________________________</html>";
		txt2 = "<html>Available commands:<br>"
				+"ABOUT - plays Turtle Graphics Demo<br>"
				+"RESET - resets the turtle at the start<br>"
				+"CLEAR - clears the drawing field<br>"
				+ "TURNRIGHT or TURNRIGHT [parameter]<br>"
				+ "PENUP<br>"
				+ "PENDOWN<br></html>";
		txt3 = "<html>Saving commands history</html>";
		txt4 = "<html>Loading file</html>";
		JLabel lbl2 = new JLabel(txt1);
		JLabel lbl3 = new JLabel("");
		JButton btn1 = new JButton("Close");
		JButton btn2 = new JButton("Help");
		JButton btn3 = new JButton("Save");
		JButton btn4 = new JButton("Load");
		JFrame mainFrame = new JFrame("Turtle Graphics Application"); // create a frame to display the turtle panel on
		JLabel lbl1 = new JLabel();
		lbl3.setVerticalAlignment(JLabel.TOP);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(3);
		mainFrame.setLayout(null);
		setMaximumSize(null);
		//Adding TurtleGraphics Panel to the main frame
		mainFrame.add(this);
		mainFrame.setBounds(240, 200, 1100, 440); // 1080p 1k resolution
		// mainFrame.setBounds(390, 270, 1100, 435); //1440p 2k resolution
		// mainFrame.setBounds(550, 350, 1100, 435); //2160p 4k resolution
		mainFrame.setVisible(true); // now display it
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

		penDown();
		setPenColour(Color.GREEN);
		// about();
	}

	public void processCommand(String command)
	{
		commands(command);
	}
}
