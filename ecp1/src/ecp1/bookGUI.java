package ecp1;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class bookGUI {
	private static JTextField numItems;
	private static JTextField textField;
	private static JTextField textField_1;
	
	
	public static void main(String[] args)
	{
		bookGUI();
		System.out.println("hello");
	}
	

	public static void bookGUI() {
	JFrame gui = new JFrame();
	
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setTitle("Book Store Galore");
	gui.setSize(720,720);
	
	int itemCount = 1;
	gui.getContentPane().setLayout(null);
	
	
	JPanel panel = new JPanel();
	panel.setBounds(0, 648, 704, 33);
	gui.getContentPane().add(panel);
	
	int totalItems = 0;
	
	JButton btnNewButton = new JButton("Process Item " + itemCount);
	btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Confirm Item " + itemCount);
	panel.add(btnNewButton_1);
	
	JButton btnViewOrder = new JButton("View Order");
	panel.add(btnViewOrder);
	
	JButton btnFinishOrder = new JButton("Finish Order");
	panel.add(btnFinishOrder);
	
	JButton btnNewOrder = new JButton("New Order");
	panel.add(btnNewOrder);
	
		
	JButton btnNewButton_2 = new JButton("Exit");
	panel.add(btnNewButton_2);
	
	JLabel lblNumberOfItems = new JLabel("Number of Items in this Order:");
	lblNumberOfItems.setBounds(143, 204, 146, 33);
	gui.getContentPane().add(lblNumberOfItems);
	
	numItems = new JTextField();
	numItems.setBounds(299, 210, 86, 20);
	gui.getContentPane().add(numItems);
	numItems.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("Book ID for Item " + itemCount +":");
	lblNewLabel.setBounds(197, 231, 92, 14);
	gui.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Enter Quantity for Item " + itemCount + ":");
	lblNewLabel_1.setBounds(163, 249, 126, 14);
	gui.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Item " + itemCount + " Info:");
	lblNewLabel_2.setBounds(236, 322, 146, 14);
	gui.getContentPane().add(lblNewLabel_2);
	
	textField = new JTextField();
	textField.setBounds(299, 228, 86, 20);
	gui.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(299, 246, 86, 20);
	gui.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	totalItems = Integer.parseInt(numItems.getText());
	
	
	
	gui.setVisible(true);
	
	}
}
