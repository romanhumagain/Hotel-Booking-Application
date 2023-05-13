package views;

//import all the necessary libraries and classes for the GUI
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controllers.PasswordJDBC;
import models.Password;
import models.ProfileTest;

public class ChangePasswordPage extends JInternalFrame implements ActionListener {
	// declaring all components
	JLabel customerId;
	JTextField txtCustomerId;
	JLabel NewPassword;
	JPasswordField txtNewPassword;
	JLabel lblCoPassword;
	JPasswordField txtCoPasword;
	JButton btnSave;
	JButton btnClose;
	JCheckBox checkBox;

	// creating the default constructor to set up frame
	public ChangePasswordPage() {
		this.setSize(400, 350);// setting the size of the frame
		this.setLayout(null); // setting layout to null

		// initializing all the component
		customerId = new JLabel();
		customerId.setText("Customer ID");
		customerId.setBounds(100, 20, 150, 35);
		customerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		customerId.setForeground(Color.black);
		customerId.setVisible(false);

		txtCustomerId = new JTextField(ProfileTest.customerId);
		txtCustomerId.setBounds(220, 20, 50, 35);
		txtCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerId.setBackground(new Color(224, 224, 224));
		txtCustomerId.setEditable(false);
		txtCustomerId.setVisible(false);

		NewPassword = new JLabel("New Password:");
		NewPassword.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		NewPassword.setBounds(20, 80, 160, 35);

		txtNewPassword = new JPasswordField();
		txtNewPassword.setBounds(180, 80, 190, 35);
		txtNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		lblCoPassword = new JLabel("Confirm Password:");
		lblCoPassword.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		lblCoPassword.setBounds(20, 160, 160, 35);

		txtCoPasword = new JPasswordField();
		txtCoPasword.setBounds(180, 160, 190, 35);
		txtCoPasword.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		checkBox = new JCheckBox("Show Password");
		checkBox.setBounds(260, 205, 150, 35);
		checkBox.setFocusable(false);
		checkBox.addActionListener(this);

		btnSave = new JButton("Save");
		btnSave.setBounds(110, 260, 75, 36);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(0, 204, 204));
		btnSave.setForeground(Color.black);
		btnSave.setFocusable(false);
		btnSave.addActionListener(this);

		btnClose = new JButton("Close");
		btnClose.setBounds(200, 260, 75, 36);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.red);
		btnClose.setForeground(Color.white);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);

		// adding different componenet in the frame
		this.add(checkBox);
		this.add(btnClose);
		this.add(btnSave);
		this.add(lblCoPassword);
		this.add(txtCoPasword);
		this.add(NewPassword);
		this.add(txtNewPassword);
		this.add(NewPassword);
		this.add(txtCustomerId);
		this.add(customerId);
		this.setVisible(true);
	}

	// methods for action listener
	@Override
	public void actionPerformed(ActionEvent ae) {
		String password = new String(txtNewPassword.getPassword());
		String co_password = new String(txtCoPasword.getPassword());

		if (ae.getSource() == btnSave) {
			if (password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Enter New Password", "!", JOptionPane.WARNING_MESSAGE);
			} else if (co_password.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Confirm Your Password", "!", JOptionPane.WARNING_MESSAGE);
			} else if (password.equals(co_password)) {
				Password changePassword = new Password();
				PasswordJDBC passwordjdbc = new PasswordJDBC();
				int Id = Integer.parseInt(txtCustomerId.getText());
				changePassword.setCustomerId(Id);
				changePassword.setPassword(password);

				boolean result = passwordjdbc.updatePassword(changePassword);
				if (result == true) {
					JOptionPane.showMessageDialog(this, "Successfully Changed");
					JOptionPane.showMessageDialog(this, "Please Re_login Your Id");
					this.dispose();
					MainPage mainPage = new MainPage();

				} else
					JOptionPane.showMessageDialog(this, "Couldn't Change Your Password", "!",
							JOptionPane.WARNING_MESSAGE);
			} else
				JOptionPane.showMessageDialog(this, "Password Didn't Matched", "!", JOptionPane.WARNING_MESSAGE);
		}

		else if (ae.getSource() == btnClose) {
			dispose();
			ProfilePage.profileImage.setVisible(true);
			ProfilePage.profile.setVisible(true);
			ProfilePage.customerId.setVisible(true);
			ProfilePage.getCustomerId.setVisible(true);
			ProfilePage.lblDOB.setVisible(true);
			ProfilePage.getDOB.setVisible(true);
			ProfilePage.email.setVisible(true);
			ProfilePage.getEmail.setVisible(true);
			ProfilePage.contact.setVisible(true);
			ProfilePage.getContact.setVisible(true);
			ProfilePage.address.setVisible(true);
			ProfilePage.getAddress.setVisible(true);
		} else if (checkBox.isSelected()) {
			txtNewPassword.setEchoChar((char) 0);
			txtCoPasword.setEchoChar((char) 0);
		} else {
			txtNewPassword.setEchoChar('\u2022');
			txtCoPasword.setEchoChar('\u2022');
		}
	}
}