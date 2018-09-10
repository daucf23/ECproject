package ecp1;

/*  Name:  David Almeida II    
 *  Course: CNT 4714 – Fall 2018     
 *  Assignment title: Program 1 – Event-driven Programming    
 *  Date: Sunday September 9, 2018
 *  */ 


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.*;
import java.awt.event.MouseAdapter;


public class bookGUI implements ActionListener {
	private static JTextField numItems;
	private static JTextField bookID;
	private static JTextField itemQuan;
	private static JTextField itemInfo;
	private static JTextField orderSubtotal;
	static int itemCount = 1;
	static int totalItems;
	static String input = "";
	static double subtotal = 0.0;
	static String temp;

	
	
	public static void main(String[] args) throws Exception
	{
		
		File file = new File("inventory.txt");
		BufferedReader bfr = new BufferedReader(new FileReader(file));
		String strdr;
		String[] inventory = new String[500];
		int i = 0;
		while((strdr = bfr.readLine()) != null)
		{
			//System.out.println(strdr);
			inventory[i] = strdr;
			//System.out.println(inventory[i]);
			i++;
		}
		
		
		//File log = new File();
		
		bookGUI();
		//System.out.println("hello");
		bfr.close();
		
	}
	
	public static void bookGUI() throws Exception {
	JFrame gui = new JFrame();
	gui.getContentPane().setBackground(Color.LIGHT_GRAY);
	
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setTitle("Book Store Galore");
	gui.setSize(720,720);
	
	
	gui.getContentPane().setLayout(null);
	
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.DARK_GRAY);
	panel.setBounds(0, 648, 704, 33);
	gui.getContentPane().add(panel);
	
	final int orderCount;
	final String idNumber[][] = new String [100][3];
	
	final double quantity[] = new double [20];
	final double discount[] = new double [20];
	

	final DecimalFormat moneyFormat = new DecimalFormat("####.##");
	
	
	final JButton btnConfirmOrder = new JButton("Confirm Item " + itemCount);
	final JButton btnViewOrder = new JButton("View Order");
	final JButton btnProcessItem = new JButton("Process Item " + itemCount);
	final JButton btnFinishOrder = new JButton("Finish Order");
	
	final JLabel lblNewLabel = new JLabel("Book ID for Item " + itemCount +":");
	lblNewLabel.setBounds(197, 266, 158, 14);
	gui.getContentPane().add(lblNewLabel);
	
	final JLabel lblNewLabel_1 = new JLabel("Enter Quantity for Item " + itemCount + ":");
	lblNewLabel_1.setBounds(163, 319, 192, 14);
	gui.getContentPane().add(lblNewLabel_1);
	
	final JLabel lblNewLabel_2 = new JLabel("Item " + itemCount + " Info:");
	lblNewLabel_2.setBounds(231, 365, 124, 14);
	gui.getContentPane().add(lblNewLabel_2);
	
	bookID = new JTextField();
	bookID.setBounds(322, 263, 372, 20);
	gui.getContentPane().add(bookID);
	bookID.setColumns(10);
	
	itemQuan = new JTextField();
	itemQuan.setBounds(322, 316, 372, 20);
	gui.getContentPane().add(itemQuan);
	itemQuan.setColumns(10);
	
	
	itemInfo = new JTextField();
	itemInfo.setBounds(322, 362, 372, 20);
	gui.getContentPane().add(itemInfo);
	itemInfo.setColumns(10);
	
	final JLabel lblOrderSubtotalFor = new JLabel("Order Subtotal for "+ itemCount + " Items:");
	lblOrderSubtotalFor.setBounds(158, 419, 197, 14);
	gui.getContentPane().add(lblOrderSubtotalFor);
	
	orderSubtotal = new JTextField();
	orderSubtotal.setBounds(322, 416, 372, 20);
	gui.getContentPane().add(orderSubtotal);
	orderSubtotal.setColumns(10);
	btnProcessItem.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			itemCount = (int) Double.parseDouble(numItems.getText());
			idNumber[itemCount] = readFile(bookID.getText());
			quantity[itemCount] = Double.parseDouble(itemQuan.getText());
			
				if (itemCount<1)
					JOptionPane.showMessageDialog(null,"You asked to order less than 1 item. Would you like to try again?");
				else{
					itemInfo.setText(idNumber[itemCount][0]+" "+idNumber[itemCount][1]+" $"+idNumber[itemCount][2]
							+" "+(int)quantity[itemCount]+" "+(int)discount(quantity[itemCount])+"% $"+ 
							moneyFormat.format(((1-discount(quantity[itemCount]) *.01) * quantity[itemCount] * Double.parseDouble(idNumber[itemCount][2]))));
				
					numItems.setEditable(false);
					btnConfirmOrder.setEnabled(true);
				}
		}
	});
	btnProcessItem.setVerticalAlignment(SwingConstants.BOTTOM);
	panel.add(btnProcessItem);
	
	
	panel.add(btnConfirmOrder);
	btnConfirmOrder.setEnabled(false);
	btnConfirmOrder.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(null,"Item #" + itemCount + " accepted");
			
			subtotal += ((1-discount(quantity[itemCount]) *.01) * quantity[itemCount] * Double.parseDouble(idNumber[itemCount][2]));
			temp = idNumber[itemCount][2];
			itemCount++;
			
		
	
			lblNewLabel.setText("Book ID for Item " + itemCount + " :");
			lblNewLabel_1.setText("Enter quantity for number for item #" + itemCount);
			lblNewLabel_2.setText("Item " + itemCount + " Info:");
			lblOrderSubtotalFor.setText("Order Subtotal for "+ (itemCount - 1) + " Items:");
			
			btnConfirmOrder.setEnabled(false);
			btnProcessItem.setEnabled(true);
			btnFinishOrder.setEnabled(true);
			btnViewOrder.setEnabled(true);
			
			itemInfo.setText("");
			orderSubtotal.setText("$"+moneyFormat.format(subtotal));
			btnProcessItem.setText("   Process Item "+itemCount+"  ");
			btnConfirmOrder.setText("   Confirm Item "+itemCount+"  ");
			
			//for last item
			if(itemCount == itemCount-1)
			{
				numItems.setText ("");
				bookID.setText ("");
				itemQuan.setText ("");
				bookID.setEditable(false);
				itemQuan.setEditable(false);
				btnProcessItem.setEnabled(false);
			}

		}
		
	});
	
	
	
	

	

	
	panel.add(btnViewOrder);
	
	btnViewOrder.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String viewTemp = "";
			int i;
			for (i=1;i<itemCount;i++){
			viewTemp= viewTemp.concat(i+". "+idNumber[i][0]+" "+idNumber[i][1]+" $"+idNumber[i][2]
					+" "+(int)quantity[i]+" "+(int)discount(quantity[i])+"% $"+
				moneyFormat.format((1-discount(quantity[i]) *.01) * quantity[i] * Double.parseDouble(idNumber[i][2]))+"\n");
			}
			JOptionPane.showMessageDialog(null, viewTemp);
		}
	});
	
	
	

	
	
	panel.add(btnFinishOrder);
	btnFinishOrder.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Format paneForm = new SimpleDateFormat("dd/MM/yy HH:mm:ss zzzz");
			Format transForm = new SimpleDateFormat("yyMMddHHmmss");
			Date timestamp = new Date();
			String transTemp="";
			double tax = 0.06;
			int i;

			String finishTemp = "Date:"+ paneForm.format(timestamp) + "\n\n";
			finishTemp= finishTemp.concat("Number of line items: "+itemCount+"\n\n"+
				"Item# / ID / Title / Price / Qty / Disc% / Subtotal:\n\n");
			
			for (i=1;i<itemCount;i++){
			transTemp = (i+". "+idNumber[i][0]+" "+idNumber[i][1]+" $"+idNumber[i][2]
					+" "+(int)quantity[i]+" "+(int)discount(quantity[i])+"% $"+
				moneyFormat.format((1-discount(quantity[i]) *.01) * quantity[i] * Double.parseDouble(idNumber[i][2]))+"\n");
			finishTemp = finishTemp.concat(transTemp);
			writeFile(transForm.format(timestamp) + ", " + transTemp);
			

			}
			
			finishTemp = finishTemp.concat("\n\n\nOrder subtotal: $"+moneyFormat.format(subtotal)
				+"\n\nTax rate:    6%\n\nTax amount:    $"+ moneyFormat.format(tax*subtotal)+ "\n\nOrder total:    $"+
					moneyFormat.format(tax*subtotal+subtotal)+"\n\nThanks for Shopping!");
			
			
		
			JOptionPane.showMessageDialog(null,finishTemp);
		}
	});

	btnFinishOrder.setEnabled(false);
	

	JButton btnNewOrder = new JButton("New Order");
	btnNewOrder.addMouseListener(new MouseListener() {

		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			try {
				bookGUI();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	numItems.setBounds(322, 210, 372, 20);
	gui.getContentPane().add(numItems);
	numItems.setColumns(10);
	//totalItems = Integer.parseInt(numItems.getText());

	
	gui.setVisible(true);
	
	}


	
		
	public static double discount(double quantity) {
		double discount=0.0;
		
		//1-5:0%, 5-9:10%, 10-14:15%, 15+:20%
		if (quantity>=15.0)
			discount=20.0;
		else if (quantity>=10.0)
			discount=15.0;
		else if (quantity>=5.0)
			discount=10.0;
		
		//return discount rate
		return discount;
	}
	
	public static String[] readFile(String string) {

		String[] strSplit = null;
		String inFileStr;

		try {
			FileInputStream file = new FileInputStream("U:\\UCF Classwork\\CNT4714 Enterprise\\cnt4714\\Project 1\\bookStore\\src\\bookStore\\inventory.txt");
			DataInputStream in = new DataInputStream(file);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
				

			while ((inFileStr = buffer.readLine()) != null) {
				strSplit = inFileStr.split(", ");
				if (string.equalsIgnoreCase(strSplit[0])) {
					buffer.close();
					in.close();
					return strSplit;
				}

			}
			buffer.close();
			in.close();
		} catch (Exception error) {
			System.err.println("Error\n\t " + error.getMessage());
		}
		return null;
	}
	
	public static void writeFile(String string)
	{
		FileWriter fileOut;
		try {
			fileOut = new FileWriter("transactions.txt");
			BufferedWriter out = new BufferedWriter(fileOut);
			out.write(string);
			out.newLine();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
