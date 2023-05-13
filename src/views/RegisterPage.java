package views;

//importing all  the required libraries
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Controllers.RegisterJDBC;
import models.Register;

public class RegisterPage extends JInternalFrame implements ActionListener {
	// declaring all the components
	JPanel north;
	JLabel header;
	JPanel panel;
	JLabel lbl_fname;
	JTextField txt_fname;
	JLabel lbl_gender;
	JRadioButton rb_gender1;
	JRadioButton rb_gender2;
	JLabel lbl_type;
	JComboBox<String> comboBox;
	JLabel lbl_address;
	JTextField txt_address;
	JLabel lbl_country;
	JTextField txt_country;
	JLabel lbl_email;
	JTextField txt_email;
	JLabel lbl_phone;
	JTextField txt_phone;
	JLabel lbl_username;
	JTextField txt_username;
	JLabel lbl_password;
	JPasswordField txt_password;
	JLabel lbl_repassword;
	JPasswordField txt_repassword;
	JLabel DOB;
	JDateChooser dateDOB;
	JPanel corporatePanel;
	JButton submit;
	JButton exit;
	ButtonGroup bg;
	String selectedGender = ""; // Declare a variable to store the selected gender
	JInternalFrame internalFrame;
	JLabel companyNameLabel;
	JTextField companyNameTextField;
	JLabel contactLabel;
	JTextField contactTextField;
	String customerType;
	String dateOfBirth;

	// creating default constructor to setup frame
	public RegisterPage() {
		// to get the screensize
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(880, 620);
		// this.setLocation(630 , 136);
		// this.setResizable(true);
		this.setTitle("Registration Page"); // setting title of the frame

		// initializing all the declared components
		north = new JPanel();
		north.setPreferredSize(new Dimension(900, 70));
		north.setBackground(Color.black);
		north.setLayout(null);

		header = new JLabel();
		header.setBounds(280, 15, 500, 40);
		header.setText("Customer Registrations");
		header.setFont(new Font("times new roman", Font.BOLD, 30));
		header.setForeground(Color.white);
		north.add(header);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(900, 600));
		panel.setBackground(Color.white);

		corporatePanel = new JPanel();
		corporatePanel.setBounds(498, 300, 333, 150);
		corporatePanel.setBackground(Color.LIGHT_GRAY);
		corporatePanel.setLayout(null);

		panel.add(corporatePanel);

		lbl_fname = new JLabel();
		lbl_fname.setText("Full Name");
		lbl_fname.setBounds(10, 20, 120, 30);
		lbl_fname.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_fname);

		txt_fname = new JTextField();

		txt_fname.setBounds(210, 20, 200, 35);
		txt_fname.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_fname);

		lbl_username = new JLabel();
		lbl_username.setText("Username: ");
		lbl_username.setBounds(10, 310, 120, 30);
		lbl_username.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_username);

		txt_username = new JTextField();

		txt_username.setBounds(210, 310, 200, 35);
		txt_username.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_username);

		lbl_gender = new JLabel();
		lbl_gender.setText("Gender: ");
		lbl_gender.setBounds(10, 90, 120, 30);
		lbl_gender.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_gender);

		rb_gender1 = new JRadioButton("Male");
		rb_gender1.setBounds(210, 90, 80, 35);
		rb_gender1.setFocusable(false);
		rb_gender1.setFont(new Font("times new roman", Font.PLAIN, 20));
		rb_gender1.addActionListener(this);
		panel.add(rb_gender1);
		rb_gender2 = new JRadioButton("Female");
		rb_gender2.setBounds(305, 90, 105, 35);
		rb_gender2.setFont(new Font("times new roman", Font.PLAIN, 20));
		rb_gender2.setFocusable(false);
		rb_gender2.addActionListener(this);
		panel.add(rb_gender2);

		bg = new ButtonGroup();
		bg.add(rb_gender1);
		bg.add(rb_gender2);

		lbl_type = new JLabel("Type");
		lbl_type.setBounds(500, 20, 70, 30);
		lbl_type.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_type);

		String types[] = { "Non Corporate Customer", "Corporate Customer" };
		comboBox = new JComboBox<>(types);
		comboBox.setBounds(625, 20, 240, 35);
		comboBox.setFont(new Font("times new roman", Font.PLAIN, 18));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		panel.add(comboBox);

		// add actionlistener to the combobox
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedType = (String) comboBox.getSelectedItem();
				if (selectedType.equals("Corporate Customer")) {
					showInternalFrame();
				} else {
					hideInternalFrame();
				}
			}
		});

		// Create the JInternalFrame
		internalFrame = new JInternalFrame("Corporate Customer Details", true);
		internalFrame.setLayout(null);

		// Create the JLabels and JTextFields
		companyNameLabel = new JLabel("Company Name:");
		companyNameLabel.setBounds(10, 10, 150, 20);
		companyNameLabel.setFont(new Font("times new roman", Font.CENTER_BASELINE, 17));
		companyNameTextField = new JTextField();
		companyNameTextField.setBounds(140, 10, 160, 35);
		companyNameTextField.setFont(new Font("times new roman", Font.CENTER_BASELINE, 18));
		contactLabel = new JLabel("Contact No:");
		contactLabel.setBounds(10, 60, 100, 20);
		contactLabel.setFont(new Font("times new roman", Font.CENTER_BASELINE, 17));
		contactTextField = new JTextField();
		contactTextField.setBounds(140, 60, 160, 35);
		contactTextField.setFont(new Font("times new roman", Font.CENTER_BASELINE, 18));
		// Add the components to the JInternalFrame
		internalFrame.add(companyNameLabel);
		internalFrame.add(companyNameTextField);
		internalFrame.add(contactLabel);
		internalFrame.add(contactTextField);

		// Set the position and size of the JInternalFrame using setBounds
		internalFrame.setBounds(0, 0, 333, 150);
		// internalFrame.setVisible(true);
		// Add the JInternalFrame to the JPanel
		corporatePanel.add(internalFrame);

		lbl_address = new JLabel();
		lbl_address.setText("Address: ");
		lbl_address.setBounds(10, 165, 120, 30);
		lbl_address.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_address);

		txt_address = new JTextField();

		txt_address.setBounds(210, 165, 200, 35);
		txt_address.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_address);

		lbl_country = new JLabel();
		lbl_country.setText("Country: ");
		lbl_country.setBounds(500, 90, 120, 30);
		lbl_country.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_country);

		txt_country = new JTextField();

		txt_country.setBounds(630, 90, 200, 35);
		txt_country.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_country);

		DOB = new JLabel("DOB");
		DOB.setBounds(10, 240, 150, 30);
		DOB.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(DOB);

		dateDOB = new JDateChooser();
		dateDOB.setDateFormatString("yyyy-MM-dd");
		dateDOB.setBounds(210, 240, 200, 35);
		dateDOB.setFont(new Font("times new roman", Font.PLAIN, 18));
		panel.add(dateDOB);

		lbl_phone = new JLabel();
		lbl_phone.setText("Phone: ");
		lbl_phone.setBounds(500, 165, 120, 30);
		lbl_phone.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_phone);

		txt_phone = new JTextField();

		txt_phone.setBounds(630, 165, 200, 35);
		txt_phone.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_phone);

		lbl_password = new JLabel();
		lbl_password.setText("Password: ");
		lbl_password.setBounds(10, 382, 150, 30);
		lbl_password.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_password);

		txt_password = new JPasswordField();

		txt_password.setBounds(210, 382, 200, 35);
		txt_password.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_password);

		lbl_repassword = new JLabel();
		lbl_repassword.setText("Confirm-Password: ");
		lbl_repassword.setBounds(10, 460, 200, 30);
		lbl_repassword.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_repassword);

		txt_repassword = new JPasswordField();

		txt_repassword.setBounds(210, 460, 200, 35);
		txt_repassword.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_repassword);

		lbl_email = new JLabel();
		lbl_email.setText("E-Mail: ");
		lbl_email.setBounds(500, 240, 120, 30);
		lbl_email.setFont(new Font("times new roman", Font.CENTER_BASELINE, 20));
		panel.add(lbl_email);

		txt_email = new JTextField();

		txt_email.setBounds(630, 240, 200, 35);
		txt_email.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel.add(txt_email);

		submit = new JButton();
		submit.setText("Submit");
		submit.setBounds(560, 460, 90, 35);
		submit.setBackground(new Color(0, 0, 220));
		submit.setForeground(Color.white);

		submit.setFocusable(false);
		submit.addActionListener(this);
		panel.add(submit);

		exit = new JButton();
		exit.setText("Exit");
		exit.setBounds(680, 460, 70, 35);
		exit.setBackground(Color.red);
		exit.setForeground(Color.white);
		exit.setFocusable(false);
		exit.addActionListener(this);
		panel.add(exit);

		// to add panel to the frame along with their position
		this.add(panel, BorderLayout.CENTER);
		this.add(north, BorderLayout.NORTH);
		this.setVisible(true);

		// to add action listener to the JRdaio Button
		rb_gender1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedGender = "Male";
			}
		});

		rb_gender2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedGender = "Female";
			}
		});

	}

	// create methods to make the internalFrame visible
	public void showInternalFrame() {

		internalFrame.setVisible(true);
	}

	// create methods to make the internalframe visibility false
	public void hideInternalFrame() {
		internalFrame.setVisible(false);

	}

	// This method handles the action event for different buttons
	@Override
	public void actionPerformed(ActionEvent ae) {
		char[] passwordChars = txt_password.getPassword();
		char[] rePasswordChars = txt_repassword.getPassword();

		if (ae.getSource() == exit) {
			MainPage.innerSouthPanel.setVisible(true);
			dispose();
		}

		else if (ae.getSource() == submit) {
			customerType = (String) comboBox.getSelectedItem(); // to get the selected items in string
			// fromjcombobox
			dateOfBirth = ((JTextField) dateDOB.getDateEditor().getUiComponent()).getText(); //// to get the
			//// selected items
			//// in string from
			//// jdatechooser

			// to validate all the textfield

			if (txt_fname.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your Name", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (txt_address.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your  Address", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (txt_email.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your Email Address", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (txt_country.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your Country Name", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (dateOfBirth.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your Date Of Birth", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (txt_phone.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your Phone Number", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (!rb_gender1.isSelected() && !rb_gender2.isSelected()) {
				JOptionPane.showMessageDialog(this, "Select Your Gender", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (txt_username.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter Your Username", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (new String(txt_password.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(this, "Enter a new Password", "ERROR", JOptionPane.ERROR_MESSAGE);

			}

			else if (new String(txt_password.getPassword()).length() < 8) {

				JOptionPane.showMessageDialog(this, "Please choose a password that is at least 8 characters long", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			else if (new String(txt_repassword.getPassword()).isEmpty()) {
				JOptionPane.showMessageDialog(this, "Confirm Your Password", "ERROR", JOptionPane.ERROR_MESSAGE);

			} else if (!isValidEmail(txt_email.getText())) {
				JOptionPane.showMessageDialog(this, "Invalid email format", "ERROR", JOptionPane.ERROR_MESSAGE);
			}

			else if (internalFrame.isVisible()
					&& (companyNameTextField.getText().isEmpty() || contactTextField.getText().isEmpty())) {
				JOptionPane.showMessageDialog(this, "Please provide your company name and company contact number", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			else if (!Arrays.equals(passwordChars, rePasswordChars)) {
				JOptionPane.showMessageDialog(this, "Password didn't match.", "Error", JOptionPane.ERROR_MESSAGE);
			}

			else {
				int customerid = 0;
				String name = txt_fname.getText();
				String address = txt_address.getText();
				String contact = txt_phone.getText();
				String email = txt_email.getText();
				String gender = selectedGender;
				String country = txt_country.getText();
				String customerusername = txt_username.getText();
				String customerpassword = new String(txt_password.getPassword());
				String companyName = companyNameTextField.getText();
				String companyContact = contactTextField.getText();

				Register register = new Register();
				register.setCustomerId(customerid);
				register.setAddress(address);
				register.setFullName(name);
				register.setContact(contact);
				register.setEmail(email);
				register.setGender(gender);
				register.setCustomerType(customerType);
				register.setCountry(country);
				register.setCustomerUserName(customerusername);
				register.setCustomerPassword(customerpassword);
				register.setDateOfBirth(dateOfBirth);
				register.setCompanyName(companyName);
				register.setCompanyContact(companyContact);

				RegisterJDBC registerJDBC = new RegisterJDBC();

				boolean result = registerJDBC.insert(register);

				if (result == true) {

					JOptionPane.showMessageDialog(this, "Successfullt Registered");
					txt_fname.setText("");
					txt_address.setText("");
					txt_phone.setText("");
					txt_password.setText("");
					txt_repassword.setText("");
					txt_email.setText("");
					txt_country.setText("");
					txt_username.setText("");
					companyNameTextField.setText("");
					contactTextField.setText("");
					dateDOB.setDate(null);
				} else {
					JOptionPane.showMessageDialog(this, "Sorry We Couldn't Register You", "ERROR",
							JOptionPane.ERROR_MESSAGE);

				}

			}

		}
	}

	// to validate email in correct format
	public boolean isValidEmail(String email) {
		String validEmail = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern emailPattern = Pattern.compile(validEmail);
		return emailPattern.matcher(email).matches();
	}

}
