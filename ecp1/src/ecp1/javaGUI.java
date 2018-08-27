package ecp1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

public class javaGUI 
{

	
	
	
	public static void main(String[] args) 
	{
		JFrame f = new JFrame("Application");
	    f.setSize(720, 500);
	    f.setLocation(300,200);
	    //final JTextArea textArea = new JTextArea(100, 400);
	    //f.getContentPane().add(BorderLayout.CENTER, textArea);
	    final JButton button = new JButton("Click Me");
	    f.getContentPane().add(BorderLayout.SOUTH, button);
	    button.addActionListener(new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            //textArea.append("Button was clicked\n");

	        }
	    });

	    f.setVisible(true);
		
	}
	
	
	
}
