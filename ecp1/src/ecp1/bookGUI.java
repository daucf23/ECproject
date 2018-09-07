package ecp1;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;


public class bookGUI {
	private static JTextField numItems;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	
	
	public static void main(String[] args)
	{
		bookGUI();
		System.out.println("hello");
	}
	

	


	public static void bookGUI() {
	JFrame gui = new JFrame();
	gui.getContentPane().setBackground(Color.LIGHT_GRAY);
	
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setTitle("Book Store Galore");
	gui.setSize(720,720);
	
	int itemCount = 1;
	gui.getContentPane().setLayout(null);
	
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.DARK_GRAY);
	panel.setBounds(0, 648, 704, 33);
	gui.getContentPane().add(panel);
	
	int totalItems = 0;
	
	JButton btnProcessItem = new JButton("Process Item " + itemCount);
	btnProcessItem.setVerticalAlignment(SwingConstants.BOTTOM);
	btnProcessItem.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	panel.add(btnProcessItem);
	
	JButton btnConfirmOrder = new JButton("Confirm Item " + itemCount);
	btnConfirmOrder.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	panel.add(btnConfirmOrder);
	
	JButton btnViewOrder = new JButton("View Order");
	btnViewOrder.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	panel.add(btnViewOrder);
	
	JButton btnFinishOrder = new JButton("Finish Order");
	btnFinishOrder.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	panel.add(btnFinishOrder);
	
	JButton btnNewOrder = new JButton("New Order");
	btnNewOrder.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	panel.add(btnNewOrder);
	
		
	JButton btnExit = new JButton("Exit");
	btnExit.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	panel.add(btnExit);
	
	JLabel lblNumberOfItems = new JLabel("Number of Items in this Order:");
	lblNumberOfItems.setBounds(143, 204, 212, 33);
	gui.getContentPane().add(lblNumberOfItems);
	
	numItems = new JTextField();
	numItems.setBounds(365, 210, 259, 20);
	gui.getContentPane().add(numItems);
	numItems.setColumns(10);
	
	
	JLabel lblNewLabel = new JLabel("Book ID for Item " + itemCount +":");
	lblNewLabel.setBounds(197, 266, 158, 14);
	gui.getContentPane().add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("Enter Quantity for Item " + itemCount + ":");
	lblNewLabel_1.setBounds(163, 319, 192, 14);
	gui.getContentPane().add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("Item " + itemCount + " Info:");
	lblNewLabel_2.setBounds(231, 365, 124, 14);
	gui.getContentPane().add(lblNewLabel_2);
	
	textField = new JTextField();
	textField.setBounds(365, 263, 259, 20);
	gui.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(365, 316, 259, 20);
	gui.getContentPane().add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setBounds(365, 362, 259, 20);
	gui.getContentPane().add(textField_2);
	textField_2.setColumns(10);
	
	JLabel lblOrderSubtotalFor = new JLabel("Order Subtotal for "+ itemCount + " Items:");
	lblOrderSubtotalFor.setBounds(158, 419, 197, 14);
	gui.getContentPane().add(lblOrderSubtotalFor);
	
	textField_3 = new JTextField();
	textField_3.setBounds(365, 416, 259, 20);
	gui.getContentPane().add(textField_3);
	textField_3.setColumns(10);
	//totalItems = Integer.parseInt(numItems.getText());
	
	
	
	gui.setVisible(true);
	
	}
}
