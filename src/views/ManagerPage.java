package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import models.GlobalManager;

public class ManagerPage extends JFrame implements ActionListener {
	// declaring all component
	JPanel panelNorth;
	JPanel panelCenter;
	JPanel innerPanelWest;
	public static JPanel innerPanelEast;
	JLabel lblHeader;
	JLabel header1;
	JLabel header2;
	JLabel header3;
	JButton btnUserDetails;
	JButton btnBookingDetails;
	JButton btnRoomDetails;
	JButton btnPaymentDetails;
	JButton btnLogOut;
	JButton addRoom;
	JButton assignRoom;
	JButton generateBill;
	JButton deleteUser;
	JButton cancelBooking;
	JButton btnViewMessage;
	JButton thankYou;
	ImageIcon imgHeader;
	JLabel lblImageHeader;
	JInternalFrame internalFrame;

	// creating constructor to set up frame
	public ManagerPage() {
		// getting screensize
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// setting the size of screen to the frame
		this.setSize(screenSize.width, screenSize.height);

		// initializing all the components
		panelNorth = new JPanel();
		panelNorth.setLayout(null);
		panelNorth.setPreferredSize(new Dimension(screenSize.width, 180));
		panelNorth.setBackground(Color.LIGHT_GRAY);
		panelNorth.setLayout(null);

		imgHeader = new ImageIcon("contact.jpg");
		lblImageHeader = new JLabel();
		lblImageHeader.setIcon(imgHeader);
		lblImageHeader.setBounds(0, 0, screenSize.width, 300);
		panelNorth.add(lblImageHeader);

		// adding new image
		ImageIcon image = new ImageIcon("manager.jpg");

		panelCenter = new JPanel();
		panelCenter.setLayout(null);
		panelCenter.setBackground(Color.white);

		JLabel lblPanelCenter = new JLabel();
		lblPanelCenter.setBounds(0, -250, 1600, 1067);
		lblPanelCenter.setIcon(image);
		panelCenter.add(lblPanelCenter);

		innerPanelWest = new JPanel();
		innerPanelWest.setBounds(20, 330, 900, 450);
		innerPanelWest.setBackground(new Color(255, 255, 255, 70));
		innerPanelWest.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		innerPanelWest.setLayout(null);

		btnUserDetails = new JButton();
		btnUserDetails.setText("User Details");
		btnUserDetails.setBackground(Color.DARK_GRAY);
		btnUserDetails.setForeground(Color.white);
		btnUserDetails.setBounds(20, 270, 130, 35);
		btnUserDetails.setFocusable(false);
		btnUserDetails.addActionListener(this);
		lblPanelCenter.add(btnUserDetails);

		btnBookingDetails = new JButton();
		btnBookingDetails.setText("Booking Details");
		btnBookingDetails.setBackground(Color.DARK_GRAY);
		btnBookingDetails.setForeground(Color.white);
		btnBookingDetails.setBounds(170, 270, 130, 35);
		btnBookingDetails.setFocusable(false);
		btnBookingDetails.addActionListener(this);
		lblPanelCenter.add(btnBookingDetails);

		btnRoomDetails = new JButton();
		btnRoomDetails.setText("Check Availability");
		btnRoomDetails.setBackground(Color.DARK_GRAY);
		btnRoomDetails.setForeground(Color.white);
		btnRoomDetails.setBounds(320, 270, 160, 35);
		btnRoomDetails.setFocusable(false);
		btnRoomDetails.addActionListener(this);
		lblPanelCenter.add(btnRoomDetails);

		btnPaymentDetails = new JButton();
		btnPaymentDetails.setText("Payment Details");
		btnPaymentDetails.setBackground(Color.DARK_GRAY);
		btnPaymentDetails.setForeground(Color.white);
		btnPaymentDetails.setBounds(500, 270, 130, 35);
		btnPaymentDetails.setFocusable(false);
		btnPaymentDetails.addActionListener(this);
		lblPanelCenter.add(btnPaymentDetails);

		addRoom = new JButton();
		addRoom.setText("Add Room");
		addRoom.setBackground(Color.black);
		addRoom.setForeground(Color.red);
		addRoom.setBounds(950, 330, 130, 35);
		addRoom.setFont(new Font("times new roman", Font.BOLD, 17));
		addRoom.setFocusable(false);
		addRoom.addActionListener(this);
		lblPanelCenter.add(addRoom);

		assignRoom = new JButton();
		assignRoom.setText("Assign Room");
		// assignRoom.setBackground(new Color(0, 204, 204));
		assignRoom.setBackground(Color.black);
		assignRoom.setForeground(Color.red);
		assignRoom.setBounds(1100, 330, 130, 35);
		assignRoom.setFont(new Font("times new roman", Font.BOLD, 17));
		assignRoom.setFocusable(false);
		assignRoom.addActionListener(this);
		lblPanelCenter.add(assignRoom);

		generateBill = new JButton();
		generateBill.setText("Generate Bill");
		generateBill.setBackground(new Color(0, 204, 204));
		generateBill.setFont(new Font("times new roman", Font.BOLD, 17));
		generateBill.setBackground(Color.black);
		generateBill.setForeground(Color.red);

		generateBill.setBounds(1250, 330, 130, 35);
		generateBill.setFocusable(false);
		lblPanelCenter.add(generateBill);
		generateBill.addActionListener(this);

		innerPanelEast = new JPanel();
		innerPanelEast.setBounds(950, 380, 550, 450);
		innerPanelEast.setBackground(new Color(255, 255, 255, 70));
		innerPanelEast.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		innerPanelEast.setLayout(null);

		lblHeader = new JLabel();
		lblHeader.setText("Hotel Administrator");
		lblHeader.setBackground(Color.black);
		lblHeader.setBounds(600, 50, 400, 40);
		lblHeader.setForeground(Color.black);
		lblHeader.setFont(new Font("times new roman", Font.BOLD, 40));
		lblImageHeader.add(lblHeader);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(1400, 50, 100, 35);
		btnLogOut.setFocusable(false);
		btnLogOut.setFont(new Font("sans serif", Font.PLAIN, 15));
		btnLogOut.setBackground(Color.red);
		btnLogOut.setForeground(Color.white);
		btnLogOut.addActionListener(this);
		lblImageHeader.add(btnLogOut);

		// creating JLabel named header
		header1 = new JLabel("Luton");
		header1.setBounds(40, 50, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 45));
		header1.setForeground(Color.black);
		lblImageHeader.add(header1);
		// creating JLabel named header2
		header2 = new JLabel("Hotel");
		header2.setBounds(105, 83, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 25));
		header2.setForeground(new Color(153, 101, 21));
		lblImageHeader.add(header2);

		btnViewMessage = new JButton("View Message");
		btnViewMessage.setBounds(750, 800, 150, 40);
		btnViewMessage.setBackground(new Color(0, 204, 204));

		btnViewMessage.setForeground(Color.black);
		btnViewMessage.setFont(new Font("times new roman", Font.BOLD, 18));
		btnViewMessage.setFocusable(false);
		btnViewMessage.addActionListener(this);
		btnViewMessage.setVisible(false);
		lblPanelCenter.add(btnViewMessage);

		lblPanelCenter.add(innerPanelEast);
		lblPanelCenter.add(innerPanelWest);

		// adding panel to the frame along with their position
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelNorth, BorderLayout.NORTH);
		this.setVisible(true); //to make frame visible
	}
	// calling constructor in the main method
	public static void main(String[] args) {
		ManagerPage managerPage = new ManagerPage();
	}
	// method that handles ActionEvents triggered by various buttons
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnLogOut) {
			this.dispose();
			MainPage mainPage = new MainPage();
		} 
		else if (ae.getSource() == btnUserDetails) {
			innerPanelWest.removeAll();
			ManagerUserDetails managerUser = new ManagerUserDetails();
			innerPanelWest.add(managerUser);
			btnViewMessage.setVisible(true);
		} else if (ae.getSource() == btnRoomDetails) {
			innerPanelWest.removeAll();
			ManagerRoomDetails managerRoom = new ManagerRoomDetails();
			innerPanelWest.add(managerRoom);
			btnViewMessage.setVisible(false);
		} else if (ae.getSource() == btnPaymentDetails) {
			innerPanelWest.removeAll();
			ManagerPaymentStatus managerRoom = new ManagerPaymentStatus();
			innerPanelWest.add(managerRoom);
			btnViewMessage.setVisible(false);
		} else if (ae.getSource() == assignRoom) {
			innerPanelEast.removeAll();
			AssignRoomPage assignRoom = new AssignRoomPage();
			innerPanelEast.add(assignRoom);
		} else if (ae.getSource() == addRoom) {
			innerPanelEast.removeAll();
			AddRoomPage addRoom = new AddRoomPage();
			innerPanelEast.add(addRoom);
		} else if (ae.getSource() == btnBookingDetails) {
			innerPanelWest.removeAll();
			ManagerBookingStatus managerBooking = new ManagerBookingStatus();
			innerPanelWest.add(managerBooking);
			btnViewMessage.setVisible(false);
		}
		else if (ae.getSource() == generateBill) {
			innerPanelEast.removeAll();
			GenerateBillPage generateBill = new GenerateBillPage();
			innerPanelEast.add(generateBill);
		} else if (ae.getSource() == btnViewMessage) {
			System.out.println(GlobalManager.message);
			innerPanelEast.removeAll();
			internalFrame = new JInternalFrame("Customer Feedback");
			internalFrame.setSize(550, 450);
			internalFrame.setClosable(true);
			JPanel panel = new JPanel();
			panel.setLayout(null);
			internalFrame.add(panel);
			internalFrame.setVisible(true);
			innerPanelEast.add(internalFrame);
			JLabel lblDetail = new JLabel("Send by : null ");
			lblDetail.setBounds(30, 20, 400, 35);
			lblDetail.setForeground(Color.black);
			lblDetail.setFont(new Font("times new roman", Font.BOLD, 20));
			panel.add(lblDetail);

			JTextArea area = new JTextArea("null");
			area.setBounds(30, 80, internalFrame.getWidth() - 60, 250);
			area.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			area.setForeground(Color.black);
			panel.add(area);

			thankYou = new JButton("Thank you");
			thankYou.setBounds(190, 360, 150, 35);
			thankYou.setBackground(new Color(0, 204, 204));
			thankYou.setForeground(Color.black);
			thankYou.setFont(new Font("times new roman", Font.PLAIN, 20));
			thankYou.addActionListener(this);
			panel.add(thankYou);

			if (GlobalManager.customerId.equals("")) {
				thankYou.setVisible(false);
				JOptionPane.showMessageDialog(internalFrame, "Please select ID from Table", "ERROR",
						JOptionPane.WARNING_MESSAGE);

			} else {
				thankYou.setVisible(true);
				try {

					String url = "jdbc:mysql://localhost:3306/java";
					String userName = "root";
					String passWord = "";
					String sql = "SELECT * FROM usermessage WHERE Customer_ID =?";
					Connection connection = DriverManager.getConnection(url, userName, passWord);

					PreparedStatement prst = connection.prepareStatement(sql);
					prst.setInt(1, Integer.parseInt(GlobalManager.customerId));

					ResultSet rs = prst.executeQuery();
					while (rs.next()) {
						lblDetail.setText("Send by : " + GlobalManager.cusName);
						String message = rs.getString("Message");
						area.setText(message);
					}
					prst.close();
					connection.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(innerPanelEast, "Couldn't View Your Message");
					internalFrame.dispose();
					System.out.println("ERROR" + ex.getMessage());
				}
			}
		} else if (ae.getSource() == thankYou) {
			internalFrame.dispose();
			GlobalManager.customerId = "";
		}
	}
}
