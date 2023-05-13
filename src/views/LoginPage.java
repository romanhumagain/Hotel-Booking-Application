package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import Controllers.ForgotPasswordJDBC;
import Controllers.ManageCustomer;
import Controllers.ManagerLoginJDBC;
import models.Customer;
import models.Login;
import models.LoginTest;
import models.ProfileTest;

public class LoginPage extends JInternalFrame implements ActionListener, FocusListener, MouseListener {
	// declaring all the component
	JPanel panel_west;
	JPanel panel_north;
	JPanel panel_east;
	JPanel panel_center;

	ImageIcon reception_img, logo_img;
	JLabel recept_lbl, header_lbl1;
	JLabel header_lbl;
	JLabel logo;

	JLabel lblHeader;

	JLabel lbl_username;
	JLabel lbl_password;
	private JTextField txt_username;
	private JPasswordField txt_password;

	JLabel lblForgotten;
	JButton btn_show;
	JButton btn_hide;
	JButton btn_login;
	JButton btn_register;
	JButton btn_close;
	JButton btnManagerLogin;
	ImageIcon show_img;
	ImageIcon hide_img;
	MainPage mainPage;

	// getter methods to retrieve username
	public String getUsername() {
		return txt_username.getText();

	}

	// getter methods to retrieve password
	public String getPassword() {
		return new String(txt_password.getPassword());

	}

	// creating default constructor to setup frame
	public LoginPage() {

		// to set the size of JFrame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(620, 450);
		// this.setClosable(true);
		this.setTitle("Login Page");

		// initialize the center panel
		panel_center = new JPanel();
		panel_center.setLayout(new BorderLayout());
		panel_center.setPreferredSize(new Dimension(400, 750));
		panel_center.setBackground(Color.DARK_GRAY);

		// initialize the west panel
		panel_west = new JPanel();
		panel_west.setLayout(null);
		panel_west.setPreferredSize(new Dimension(290, 750));
		panel_west.setBackground(Color.white);

		// initialize the north panel
		panel_north = new JPanel();
		panel_north.setLayout(null);
		panel_north.setPreferredSize(new Dimension(100, 100));
		panel_north.setBackground(Color.white);

		// create the logo image and label
		logo_img = new ImageIcon("logoo.png");
		logo = new JLabel();
		logo.setBounds(10, -10, 150, 125);
		logo.setIcon(logo_img);
		// panel_north.add(logo);

		// create the header label
		lblHeader = new JLabel();
		lblHeader.setText("Log in to access your account");
		lblHeader.setBounds(240, 30, 350, 40);
		lblHeader.setForeground(Color.black);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
		panel_north.add(lblHeader);

		// create the hotel name label
		header_lbl = new JLabel();
		header_lbl.setText("Luton");
		header_lbl.setBounds(20, 20, 200, 40);
		header_lbl.setFont(new Font("Arial", Font.BOLD, 45));
		header_lbl.setForeground(Color.black);

		panel_north.add(header_lbl);

		// create the "Hotel" label
		header_lbl1 = new JLabel();
		header_lbl1.setText("Hotel");
		header_lbl1.setBounds(79, 55, 80, 40);
		header_lbl1.setFont(new Font("Arial", Font.PLAIN, 28));
		header_lbl1.setForeground(new Color(153, 101, 21));
		panel_north.add(header_lbl1);
		// adding new image
		reception_img = new ImageIcon("signup-image.jpg");

		recept_lbl = new JLabel();
		recept_lbl.setIcon(reception_img);
		recept_lbl.setBounds(4, -95, 500, 500);
		panel_west.add(recept_lbl);

		panel_east = new JPanel();
		panel_east.setBackground(Color.white);
		panel_east.setPreferredSize(new Dimension(530, 750));
		panel_east.setLayout(null);

		lbl_username = new JLabel();
		lbl_username.setText("Username:");
		lbl_username.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_username.setBounds(150, 40, 140, 30);

		// panel_east.add(lbl_username);

		txt_username = new JTextField("Enter Your Username");
		txt_username.setBounds(240, 35, 210, 40);
		txt_username.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		panel_east.add(txt_username);
		txt_username.addFocusListener(this);

		lbl_password = new JLabel();
		lbl_password.setText("Password:");
		lbl_password.setFont(new Font("Arial", Font.BOLD, 25));
		lbl_password.setBounds(150, 110, 140, 30);

		// panel_east.add(lbl_password);

		txt_password = new JPasswordField("Enter Your Password");
		txt_password.setBounds(240, 100, 210, 40);
		txt_password.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		txt_password.setEchoChar((char) 0);
		panel_east.add(txt_password);
		txt_password.addFocusListener(this);

		// initializing image icon
		show_img = new ImageIcon("eye (1).png");
		hide_img = new ImageIcon("hidden.png");

		btn_show = new JButton();

		btn_show.setBounds(458, 108, 25, 25);
		btn_show.setBackground(Color.white);
		btn_show.setIcon(show_img);
		btn_show.setFocusable(false);
		btn_show.setBorderPainted(false);
		btn_show.addActionListener(this);
		panel_east.add(btn_show);

		btn_hide = new JButton();
		btn_hide.setBounds(458, 108, 25, 25);
		btn_hide.setBackground(Color.white);
		btn_hide.setIcon(hide_img);
		btn_hide.setFocusable(false);
		btn_hide.setBorderPainted(false);
		btn_hide.addActionListener(this);
		panel_east.add(btn_hide);

		btn_login = new JButton();
		btn_login.setText("Sign In");
		btn_login.setBounds(240, 170, 210, 35);
		btn_login.setFocusable(false);
		btn_login.setBackground(Color.blue);
		btn_login.setForeground(Color.white);
		btn_login.addActionListener(this);
		panel_east.add(btn_login);

		btnManagerLogin = new JButton();
		btnManagerLogin.setText("Log In As Manager");
		btnManagerLogin.setBounds(270, 220, 150, 35);
		btnManagerLogin.setFocusable(false);
		btnManagerLogin.setBackground(new Color(0, 204, 204));
		btnManagerLogin.setForeground(Color.black);
		btnManagerLogin.addActionListener(this);
		panel_east.add(btnManagerLogin);

		lblForgotten = new JLabel();
		lblForgotten.setText("Forgotten Password ?");
		lblForgotten.setForeground(Color.black);
		lblForgotten.setBounds(260, 270, 175, 35);
		lblForgotten.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		lblForgotten.addMouseListener(this);
		panel_east.add(lblForgotten);

		btn_close = new JButton();
		btn_close.setText("Close");
		btn_close.setBounds(450, 270, 70, 30);
		btn_close.setFocusable(false);
		btn_close.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 15));
		btn_close.setBackground(Color.red);
		btn_close.setForeground(Color.white);
		btn_close.addActionListener(this);
		panel_east.add(btn_close);

		// adding panel to the frame along with their position
		this.add(panel_center, BorderLayout.CENTER);
		this.add(panel_west, BorderLayout.WEST);
		this.add(panel_north, BorderLayout.NORTH);
		this.add(panel_east, BorderLayout.EAST);

		this.setResizable(false);
		// to make the frame visible
		this.setVisible(true);

	}

	// This method handles the action event for different buttons

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn_login) {

			if (txt_username.equals("Enter Your Username")) {
				JOptionPane.showMessageDialog(this, "You left the Username field blank", "ERROR!!",
						JOptionPane.ERROR_MESSAGE); // displaying an error message

			} else if (txt_password.equals("Enter Your Password")) {

				JOptionPane.showMessageDialog(this, "You left the Password field blank", "ERROR!!",
						JOptionPane.ERROR_MESSAGE);

			}

			else if (txt_username.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "You left the Username field blank", "ERROR!!",
						JOptionPane.ERROR_MESSAGE); // displaying an error message

			} else if (new String(txt_password.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(this, "You left the Password field blank", "ERROR!!",
						JOptionPane.ERROR_MESSAGE);
			}

			else {

				String username = txt_username.getText();
				String password = new String(txt_password.getPassword());

				Customer customer = new Customer();
				ManageCustomer customerManager = new ManageCustomer();
				Login login = new Login();
				login.setUsername(username);
				login.setPassword(password);

				customer.setCustomerUserName(username);
				customer.setCustomerPassword(password);
				customerManager.setCustomer(customer);
				customerManager.login();
				customer = customerManager.getCustomer();

				int customerId = customer.getCustomerId();

				ProfileTest.customerId = Integer.toString(customerId);

				if (customer.getCustomerId() >= 1) { // to login if the password and username provided by the username
					// are correct

					int cusId = customer.getCustomerId();
					String strCustomerName = customer.getCustomerName();
					String cusType = customer.getCustomerType();

					// setting the data to the global variable
					LoginTest.str1 = username;
					LoginTest.str2 = password;
					LoginTest.customerId = cusId;
					LoginTest.customerName = strCustomerName;
					LoginTest.customerType = cusType;

					JOptionPane.showMessageDialog(this, "Welcome " + LoginTest.customerName, "Welcome",
							JOptionPane.INFORMATION_MESSAGE);

					// to dispose the frame
					this.dispose();
					MainPage mainPage = (MainPage) SwingUtilities.getWindowAncestor(this);
					mainPage.disposeMainPage();
					// to dispose the mainPage
					mainPage.dispose();
					FrontPage frontPage = new FrontPage();

				} else
					JOptionPane.showMessageDialog(this, "Invalid Username/Password", "ERROR!!",
							JOptionPane.ERROR_MESSAGE); // displaying an error message if username and password are
				// invalid
			}
		}
		// doing validation
		if (ae.getSource() == btnManagerLogin) {

			if (txt_username.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "You left the Username field blank", "Alert!!",
						JOptionPane.ERROR_MESSAGE);

			} else if (new String(txt_password.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(this, "You left the Password field blank", "Alert!!",
						JOptionPane.ERROR_MESSAGE);

			} else {

				// get entered username and password
				String username = txt_username.getText();
				String password = new String(txt_password.getPassword());

				// check if username and password match data in database
				boolean result = ManagerLoginJDBC.checkCredentials(username, password);

				// perform action based on result
				if (result == true) {
					ManagerPage managerPage = new ManagerPage();
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(btn_login, "Invalid Username or Password");// displaying error message if
																																										// username and password are invalid
				}

			}

		}

		else if (ae.getSource() == btn_show) {

			txt_password.setEchoChar((char) 0);
			btn_show.setVisible(false);
			btn_hide.setVisible(true);
		} else if (ae.getSource() == btn_hide) {

			txt_password.setEchoChar('*');
			btn_hide.setVisible(false);
			btn_show.setVisible(true);
		} else if (ae.getSource() == btn_close) {
			MainPage.innerSouthPanel.setVisible(true);
			dispose();

		}
	}

	// to add focuslistener to the textfield and password field
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == txt_username) {
			if (txt_username.getText().equals("Enter Your Username")) {
				txt_username.setText("");
				txt_username.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == txt_password) {
			String password = new String(txt_password.getPassword());
			if (password.equals("Enter Your Password")) {
				txt_password.setText("");
				txt_password.setEchoChar('*');
				txt_password.setForeground(Color.BLACK);
			}
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == txt_username) {
			if (txt_username.getText().isEmpty()) {
				txt_username.setText("Enter Your Username");
				txt_username.setForeground(Color.black);
			}
		} else if (e.getSource() == txt_password) {
			String password = new String(txt_password.getPassword());
			if (password.isEmpty()) {
				txt_password.setText("Enter Your Password");
				txt_password.setForeground(Color.black);
				txt_password.setEchoChar((char) 0);
			}
		}
	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	@Override
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == lblForgotten) {

			String userName = JOptionPane.showInputDialog("Enter Your Username");

			if (userName != null && !userName.trim().isEmpty()) { // Check if Id is not null or empty

				String contact = JOptionPane.showInputDialog("Enter Your Contact");

				if (contact != null && !contact.trim().isEmpty()) { // Check if contact is not null or empty

					try {
						ForgotPasswordJDBC forgotPassword = new ForgotPasswordJDBC();
						Customer customer = forgotPassword.getData(userName, contact);

						if (customer != null) {

							String password = customer.getCustomerPassword();
							JOptionPane.showMessageDialog(null, "Password reset successful");
							JOptionPane.showMessageDialog(null, "Your Password Is: " + password);
						} else {
							JOptionPane.showMessageDialog(null, "Invalid Customer ID/Contact Number.", "!",
									JOptionPane.WARNING_MESSAGE);

						}

					} catch (Exception ex) {
						System.out.println("ERROR" + ex.getMessage());
					}
				} else if (contact != null) { // contact is not null but it's empty
					JOptionPane.showMessageDialog(null, "Please enter your contact number.", "!",
							JOptionPane.WARNING_MESSAGE);
				} else { // contact is null
					JOptionPane.getRootFrame().dispose();
				}

			} else if (userName != null) { // Id is not null but it's empty
				JOptionPane.showMessageDialog(null, "Please enter your ID.", "!", JOptionPane.WARNING_MESSAGE);
			} else { // Id is null
				JOptionPane.getRootFrame().dispose();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent ae) {
		lblForgotten.setForeground(Color.red);

	}

	@Override
	public void mouseReleased(MouseEvent ae) {
		lblForgotten.setForeground(Color.black);

	}

	@Override
	public void mouseEntered(MouseEvent ae) {
		lblForgotten.setForeground(Color.red);

	}

	@Override
	public void mouseExited(MouseEvent ae) {
		lblForgotten.setForeground(Color.black);

	}

	// calling constructor in main method
	public static void main(String[] args) {
		new LoginPage();
	}
}
