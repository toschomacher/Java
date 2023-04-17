import java.awt.Color;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MainClass extends GraphicsSystem
{
	public String txt;
	
	public static void main(String[] args)
	{
		
		new MainClass();
	}

	public MainClass()
	{
		super();
		MyHandler hnd = new MyHandler();
		JLabel lbl1 = new JLabel();
		JFrame mainFrame = new JFrame("Turtle Graphics Application"); // create a frame to display the turtle panel on
		lbl1.setBounds(805, 18, 275, 90);
		lbl1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(3);
		mainFrame.setLayout(null);
		setMaximumSize(null);
		txt = "<html>This program is in process of development by Todor Vasilev, "
				+ "LBU student - CS4D 2022-2023.<br><br>Student ID - c3643417</html>";
		JLabel lbl2 = new JLabel(txt);
		lbl2.setBounds(810, 15, 265, 95); // setting the size and position of the label
		mainFrame.add(lbl2); // adding the label to the window
		mainFrame.add(lbl1);
		JButton btn1 = new JButton("Close");
		btn1.setBounds(810, 340, 80, 30);
		mainFrame.add(btn1);
		btn1.addActionListener(hnd);
		mainFrame.add(this);
		mainFrame.setBounds(240, 200, 1100, 440); // 1080p 1k resolution
		// mainFrame.setBounds(390, 270, 1100, 435); //1440p 2k resolution
		// mainFrame.setBounds(550, 350, 1100, 435); //2160p 4k resolution
		mainFrame.setVisible(true); // now display it
		penDown();
		setPenColour(Color.GREEN);
		// about();
	}

	public void processCommand(String command)
	{
		commands(command);
	}
}
