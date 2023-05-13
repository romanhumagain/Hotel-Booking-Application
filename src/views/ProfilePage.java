package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controllers.CancelBooking;
import Controllers.JDBC;
import models.Cancel;
import models.Customer;
import models.GlobalBooking;
import models.LoginTest;
import models.ProfileTest;

public class ProfilePage extends JFrame implements ActionListener, MouseListener {
	// declaring all the component
	JPanel panelMain;
	static JPanel profilePanel;
	JPanel statusPanel;
	JPanel panelTop;
	JLabel headerTop;
	JLabel header1;
	JLabel header2;
	static JLabel profileImage;
	static JLabel profile;
	static JLabel lblDOB;
	static JLabel getDOB;
	static JLabel fullName;
	static JLabel getFullName;
	static JLabel email;
	static JLabel getEmail;
	static JLabel contact;
	static JLabel getContact;
	static JLabel customerId;
	static JLabel getCustomerId;
	static JLabel address;
	static JLabel getAddress;
	ImageIcon imgProfile;
	ImageIcon imgHeader;
	JPanel billingPanel;
	JButton btnLogOut;
	JButton btnBack;
	JLabel lblEdit;
	JButton btnCancel;
	JButton btnBill;
	JButton btnView;
	static JTable tblBooking;
	JTable tblBill;
	JLabel lblBooking;
	JLabel lblBill;
	JLabel changePassword;
	JLabel lblImageHeader;
	DefaultTableModel model;
	Object headerName[];
	JLabel updateBooking;
	JDesktopPane desktopPane;
	JPanel updateBookingPanel;
	JPanel panel;

	Timer refressTimer;

	// creating default constructor to setup frame
	public ProfilePage() {
		// Set the size of the window to the size of the screen and prevent resizing
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screensize.width, screensize.height);// setting the size of the frame
		this.setResizable(false);

		// Create a JDesktopPane and set its properties
		desktopPane = new JDesktopPane();
		desktopPane.setLayout(null);
		desktopPane.setBackground(Color.white);
		desktopPane.setBounds(10, 3, 610, 620);
		desktopPane.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		// Create a JPanel for the top section and set its properties
		panelTop = new JPanel();
		panelTop.setLayout(null);
		panelTop.setPreferredSize(new Dimension(screensize.width, 198));
		panelTop.setBackground(Color.LIGHT_GRAY);

		// create imageicon
		imgHeader = new ImageIcon("contact.jpg");
		lblImageHeader = new JLabel();
		lblImageHeader.setIcon(imgHeader);
		lblImageHeader.setBounds(0, 0, screensize.width, 300);
		panelTop.add(lblImageHeader);

		// Create a JPanel for the center section and set its properties
		panelMain = new JPanel();
		panelMain.setLayout(null);
		panelMain.setBackground(Color.white);

		// initializing for imageicon and setting it at background image
		ImageIcon image = new ImageIcon("manager.jpg");
		JLabel lblPanelCenter = new JLabel();
		lblPanelCenter.setBounds(0, 0, 1600, 1067);
		lblPanelCenter.setIcon(image);

		// Create a label for the header and set its properties
		headerTop = new JLabel();
		headerTop.setText("My Profile");
		headerTop.setForeground(Color.black);
		headerTop.setFont(new Font("Arial", Font.BOLD, 45));
		headerTop.setBounds(600, 40, 300, 80);
		lblImageHeader.add(headerTop);

		// Create a "Log Out" button and a "Back" button and set their properties
		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(1410, 65, 85, 35);
		btnLogOut.setFocusable(false);
		btnLogOut.setBackground(Color.red);
		btnLogOut.setForeground(Color.white);
		btnLogOut.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnLogOut.addActionListener(this);
		lblImageHeader.add(btnLogOut);

		btnBack = new JButton("Back");
		btnBack.setBounds(1310, 65, 85, 35);
		btnBack.setFocusable(false);
		btnBack.setBackground(Color.red);
		btnBack.setForeground(Color.white);
		btnBack.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnBack.addActionListener(this);
		lblImageHeader.add(btnBack);

		// Create a JPanel for the profile information and set its properties
		profilePanel = new JPanel();
		profilePanel.setLayout(null);
		profilePanel.setBackground(new Color(255, 255, 255, 70));
		profilePanel.setBounds(10, 3, 610, 620);
		profilePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

		// initializing for imageicon
		imgProfile = new ImageIcon("profile.png");
		profileImage = new JLabel();
		profileImage.setBounds(230, 20, 150, 149);
		profileImage.setIcon(imgProfile);
		profileImage.setBackground(Color.black);
		profileImage.setHorizontalAlignment(SwingConstants.CENTER);
		desktopPane.add(profileImage);

		// Create a label for the profile name and set its properties
		profile = new JLabel();
		profile.setBounds(0, 188, 600, 40);
		profile.setFont(new Font("times new roman", Font.BOLD, 28));
		profile.setHorizontalAlignment(SwingConstants.CENTER);
		profile.setBackground(Color.cyan);
		desktopPane.add(profile);
		// Create a label for the customer id
		customerId = new JLabel("ID:");
		customerId.setBounds(20, 230, 140, 40);
		customerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(customerId);
		// Create a label to get customer id
		getCustomerId = new JLabel();
		getCustomerId.setBounds(130, 230, 280, 40);
		getCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(getCustomerId);
		// Create a label for the DOB
		lblDOB = new JLabel("DOB:");
		lblDOB.setBounds(20, 280, 140, 40);
		lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(lblDOB);
		// Create a label to get DOB
		getDOB = new JLabel();
		getDOB.setBounds(130, 280, 280, 40);
		getDOB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(getDOB);
		// Create a label for the email
		email = new JLabel("Email:");
		email.setBounds(20, 330, 140, 40);
		email.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(email);
		// Create a label to get email
		getEmail = new JLabel();
		getEmail.setText("roman@gmail.com");
		getEmail.setBounds(130, 330, 420, 40);
		getEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(getEmail);
		// Create a label for contact
		contact = new JLabel("Contact:");
		contact.setBounds(20, 380, 190, 40);
		contact.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(contact);
		// Create a label to get contact
		getContact = new JLabel();
		getContact.setBounds(130, 380, 320, 40);
		getContact.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(getContact);
		// Create a label for the address
		address = new JLabel("Address:");
		address.setBounds(20, 430, 190, 40);
		address.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(address);
		// Create a label to get addreess
		getAddress = new JLabel();
		getAddress.setBounds(130, 430, 320, 40);
		getAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		desktopPane.add(getAddress);
		// Create a label for the edit profile
		lblEdit = new JLabel("Edit Profile");
		lblEdit.setBounds(56, 575, 110, 35);
		lblEdit.setBackground(new Color(0, 204, 204));
		lblEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEdit.setForeground(Color.red);
		lblEdit.setFocusable(false);
		lblEdit.addMouseListener(this);
		desktopPane.add(lblEdit);
		// create button for cancelling the booking
		btnCancel = new JButton("Cancel Booking");
		btnCancel.setBounds(30, 520, 150, 35);
		btnCancel.setBackground(new Color(0, 204, 204));
		btnCancel.setForeground(Color.black);
		btnCancel.setFont(new Font("times new roman", Font.BOLD, 17));
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		desktopPane.add(btnCancel);

		btnBill = new JButton("Payment Status");
		btnBill.setBounds(210, 520, 150, 35);
		btnBill.setBackground(new Color(0, 204, 204));
		btnBill.setForeground(Color.black);
		btnBill.setFont(new Font("times new roman", Font.BOLD, 17));
		btnBill.setFocusable(false);
		btnBill.addActionListener(this);
		desktopPane.add(btnBill);

		btnView = new JButton("View Booking Status");
		btnView.setBounds(400, 520, 190, 35);
		btnView.setForeground(Color.black);
		btnView.setBackground(new Color(0, 204, 204));
		btnView.setFont(new Font("times new roman", Font.BOLD, 17));
		btnView.setFocusable(false);
		btnView.addActionListener(this);
		desktopPane.add(btnView);

		changePassword = new JLabel("Change Password ?");
		changePassword.setBounds(410, 580, 240, 25);
		changePassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		changePassword.setForeground(Color.red);
		changePassword.addMouseListener(this);
		desktopPane.add(changePassword);

		updateBooking = new JLabel("Update Booking ?");
		updateBooking.setBounds(220, 580, 240, 25);
		updateBooking.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		updateBooking.setForeground(Color.red);
		updateBooking.addMouseListener(this);
		desktopPane.add(updateBooking);
		statusPanel = new JPanel();

		statusPanel.setBackground(Color.white);
		statusPanel.setBounds(630, 50, 890, 220);
		statusPanel.setLayout(new GridLayout());
		statusPanel.setBackground(new Color(255, 255, 255, 70));
		statusPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		lblBooking = new JLabel("Your Booking Status");
		lblBooking.setBounds(930, 5, 340, 40);
		lblBooking.setForeground(Color.black);
		lblBooking.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		lblPanelCenter.add(lblBooking);

		billingPanel = new JPanel();
		billingPanel.setLayout(new GridLayout());
		billingPanel.setBackground(new Color(255, 255, 255, 70));

		billingPanel.setBounds(680, 380, 800, 200);
		billingPanel.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		lblBill = new JLabel("Your Generated Bill");
		lblBill.setBounds(930, 335, 340, 40);
		lblBill.setForeground(Color.black);
		lblBill.setFont(new Font("Times New Roman", Font.PLAIN, 30));

		lblPanelCenter.add(lblBill);

		// creating JLabel named header
		header1 = new JLabel("Luton");
		header1.setBounds(80, 50, 200, 45);
		header1.setFont(new Font("Arial", Font.BOLD, 47));
		header1.setForeground(Color.black);
		lblImageHeader.add(header1);

		// creating JLabel named header2
		header2 = new JLabel("Hotel");
		header2.setBounds(149, 90, 80, 45);
		header2.setFont(new Font("Arial", Font.PLAIN, 25));
		header2.setForeground(new Color(153, 101, 21));

		lblImageHeader.add(header2);

		updateBookingPanel = new JPanel();
		updateBookingPanel.setBounds(0, 0, 380, 350);
		updateBookingPanel.setLayout(null);
		updateBookingPanel.setBackground(Color.red);
		// profilePanel.add(updateBookingPanel);

		lblPanelCenter.add(billingPanel);
		lblPanelCenter.add(statusPanel);
		// panelMain.add(profilePanel);
		panelMain.add(desktopPane);

		this.add(panelTop, BorderLayout.NORTH);
		this.add(panelMain, BorderLayout.CENTER);

		panelMain.add(lblPanelCenter);
		this.setVisible(true);

		JDBC jdbc = new JDBC();
		Customer customer = new Customer();

		LoginPage loginPage = new LoginPage();

		String username = loginPage.getUsername();
		String password = loginPage.getPassword();

		customer.setCustomerUserName(LoginTest.str1);
		customer.setCustomerPassword(LoginTest.str2);
		customer = jdbc.login(customer);

		// Set name label to customer's name
		profile.setText(customer.getCustomerName());
		getDOB.setText(customer.getDateOfBirth());
		getEmail.setText(customer.getCustomerEmail());
		getContact.setText(customer.getCustomerContact());
		getCustomerId.setText(Integer.toString(customer.getCustomerId()));
		getAddress.setText(customer.getCustomerAddress());

	}

	// calling constructor in main method
	public static void main(String[] args) {
		ProfilePage profilepage = new ProfilePage();

	}

	// This method handles the action event for different buttons
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnLogOut) {

			GlobalBooking.bookingId = "";

			int ans = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Warning",
					JOptionPane.YES_NO_OPTION);
			if (ans == JOptionPane.YES_OPTION) {
				MainPage main = new MainPage();
				dispose();
			} else
				return;

		}

		else if (ae.getSource() == btnBack) {
			GlobalBooking.bookingId = "";
			Customer customer = new Customer();
			FrontPage front = new FrontPage();
			dispose();

		} else if (ae.getSource() == btnView) {
			statusPanel.removeAll();
			CustomerBookingDetails customerBooking = new CustomerBookingDetails();
			statusPanel.add(customerBooking);

		}

		else if (ae.getSource() == btnBill) {
			billingPanel.removeAll();
			CustomerBillDetails customerBill = new CustomerBillDetails();
			billingPanel.add(customerBill);

			// --

			String cusId = getCustomerId.getText();
			ProfileTest.customerId = cusId;

		} else if (ae.getSource() == btnCancel) {

			if (GlobalBooking.bookingId == null || GlobalBooking.bookingId.isEmpty()) {
				JOptionPane.showMessageDialog(desktopPane,
						"Please select your booking id from your booking status table", "ERROR!", JOptionPane.ERROR_MESSAGE);
			} else {
				int bookingId = Integer.parseInt(GlobalBooking.bookingId);

				CancelBooking cancelBooking = new CancelBooking();

				Cancel cancel = new Cancel();
				cancel.setBookingId(bookingId);
				boolean cancelResult = cancelBooking.cancelBooking(cancel);

				if (cancelResult) {
					JOptionPane.showMessageDialog(profilePanel,
							"Successfully Canceled Booking of Booking ID: " + GlobalBooking.bookingId);
				} else {
					JOptionPane.showMessageDialog(profilePanel,
							"Please select your booking id from your booking status table");
				}
			}

		}

	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	@Override
	public void mouseClicked(MouseEvent ae) {

		if (ae.getSource() == lblEdit) {

			profileImage.setVisible(false);
			profile.setVisible(false);
			customerId.setVisible(false);
			getCustomerId.setVisible(false);
			lblDOB.setVisible(false);
			getDOB.setVisible(false);
			email.setVisible(false);
			getEmail.setVisible(false);
			contact.setVisible(false);
			getContact.setVisible(false);
			address.setVisible(false);
			getAddress.setVisible(false);

			String customerId = getCustomerId.getText();
			String dob = getDOB.getText();
			String email = getEmail.getText();
			String address = getAddress.getText();
			String contact = getContact.getText();

			ProfileTest.email = email;
			ProfileTest.contact = contact;
			ProfileTest.address = address;
			ProfileTest.customerId = customerId;
			ProfileTest.dateOfBirth = dob;

			UpdateCustomer updateProfile = new UpdateCustomer();

			desktopPane.add(updateProfile); // adding updateProfile page to the desktop pane

		}

		else if (ae.getSource() == changePassword) {

			ChangePasswordPage changePassword = new ChangePasswordPage();
			desktopPane.add(changePassword);
			profileImage.setVisible(false);
			profile.setVisible(false);
			customerId.setVisible(false);
			getCustomerId.setVisible(false);
			lblDOB.setVisible(false);
			getDOB.setVisible(false);
			email.setVisible(false);
			getEmail.setVisible(false);
			contact.setVisible(false);
			getContact.setVisible(false);
			address.setVisible(false);
			getAddress.setVisible(false);

			String customerId = getCustomerId.getText();
			ProfileTest.customerId = customerId;

		}

		else if (ae.getSource() == updateBooking) {

			UpdateBookingPage updateBooking = new UpdateBookingPage();
			// updateBooking.setLocation(240, 190);
			desktopPane.add(updateBooking);

			profileImage.setVisible(false);
			profile.setVisible(false);
			customerId.setVisible(false);
			getCustomerId.setVisible(false);
			lblDOB.setVisible(false);
			getDOB.setVisible(false);
			email.setVisible(false);
			getEmail.setVisible(false);
			contact.setVisible(false);
			getContact.setVisible(false);
			address.setVisible(false);
			getAddress.setVisible(false);

		}

	}

	@Override
	public void mousePressed(MouseEvent ae) {
		if (ae.getSource() == changePassword) {
			changePassword.setForeground(Color.black);
		}
		if (ae.getSource() == lblEdit) {
			lblEdit.setForeground(Color.black);
		}

		if (ae.getSource() == updateBooking) {
			updateBooking.setForeground(Color.black);
		}
	}

	@Override
	public void mouseReleased(MouseEvent ae) {
		if (ae.getSource() == changePassword) {
			changePassword.setForeground(Color.red);
		}
		if (ae.getSource() == lblEdit) {
			lblEdit.setForeground(Color.red);
		}
		if (ae.getSource() == updateBooking) {
			updateBooking.setForeground(Color.red);
		}
	}

	@Override
	public void mouseEntered(MouseEvent ae) {
		if (ae.getSource() == changePassword) {
			changePassword.setForeground(Color.black);
		}
		if (ae.getSource() == lblEdit) {
			lblEdit.setForeground(Color.black);
		}

		if (ae.getSource() == updateBooking) {
			updateBooking.setForeground(Color.black);
		}
	}

	@Override
	public void mouseExited(MouseEvent ae) {
		if (ae.getSource() == changePassword) {
			changePassword.setForeground(Color.red);
		}
		if (ae.getSource() == lblEdit) {
			lblEdit.setForeground(Color.red);
		}
		if (ae.getSource() == updateBooking) {
			updateBooking.setForeground(Color.red);
		}
	}

}
