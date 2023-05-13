package views;

//import all the necessary libraries and classes for the GUI
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import Controllers.UpdateProfile;
import models.ProfileTest;

public class UpdateCustomer extends JInternalFrame implements ActionListener {
	// declaring all components
	JLabel customerId;
	JTextField txtCustomerId;
	JLabel lblDOB;
	JLabel lblEmail;
	JTextField txtEmail;
	JLabel lblContact;
	JTextField txtContact;
	JLabel lblAddress;
	JTextField txtAddress;
	JButton btnSave;
	JButton btnClose;
	JDateChooser dateDOB;

	// creating constructor to set up frame
	public UpdateCustomer() {
		this.setSize(380, 450);
		this.setLayout(null);
		// initializing all components
		customerId = new JLabel();
		customerId.setText("Customer ID");
		customerId.setBounds(100, 20, 150, 35);
		customerId.setFont(new Font("Times New Roman", Font.BOLD, 20));

		txtCustomerId = new JTextField(ProfileTest.customerId);
		txtCustomerId.setBounds(220, 20, 50, 35);
		txtCustomerId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCustomerId.setBackground(new Color(224, 224, 224));
		txtCustomerId.setEditable(false);

		lblDOB = new JLabel("DOB");
		lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDOB.setBounds(20, 90, 100, 35);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date date = dateFormat.parse(ProfileTest.dateOfBirth);
			dateDOB = new JDateChooser(date);
			dateDOB.setDateFormatString("yyyy-MM-dd");
			dateDOB.setBounds(110, 90, 190, 35);
			dateDOB.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		} catch (ParseException e) {
			// Handle the exception here
			e.printStackTrace();
		}

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmail.setBounds(20, 160, 100, 35);

		txtEmail = new JTextField(ProfileTest.email);
		txtEmail.setBounds(110, 160, 190, 35);
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContact.setBounds(20, 230, 100, 35);

		txtContact = new JTextField(ProfileTest.contact);
		txtContact.setBounds(110, 230, 190, 35);
		txtContact.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddress.setBounds(20, 300, 100, 35);

		txtAddress = new JTextField(ProfileTest.address);
		txtAddress.setBounds(110, 300, 190, 35);
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 17));

		btnSave = new JButton("Save");
		btnSave.setBounds(100, 360, 75, 36);
		btnSave.setBorderPainted(false);
		btnSave.setBackground(new Color(0, 204, 204));
		btnSave.setForeground(Color.black);
		btnSave.setFocusable(false);
		btnSave.addActionListener(this);

		btnClose = new JButton("Close");
		btnClose.setBounds(190, 360, 75, 36);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(Color.red);
		btnClose.setForeground(Color.white);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);

		// adding all component to frame
		this.add(btnClose);
		this.add(btnSave);
		this.add(lblContact);
		this.add(txtContact);
		this.add(lblAddress);
		this.add(txtAddress);
		this.add(txtEmail);
		this.add(lblEmail);
		this.add(dateDOB);
		this.add(lblDOB);
		this.add(txtCustomerId);
		this.add(customerId);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnSave) {
			if ((dateDOB.getDate()).equals(null)) {
				JOptionPane.showMessageDialog(this, "Provide Your Name", "!", JOptionPane.WARNING_MESSAGE);
			} else if (txtEmail.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Provide Your Email", "!", JOptionPane.WARNING_MESSAGE);
			} else if (txtAddress.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Provide Your Address", "!", JOptionPane.WARNING_MESSAGE);
			} else if (txtContact.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Provide Your Contact Number", "!", JOptionPane.WARNING_MESSAGE);
			} else {
				// String name = dateDOB.getText();
				String email = txtEmail.getText();
				String contact = txtContact.getText();
				String address = txtAddress.getText();
				String dateOfBirth = ((JTextField) dateDOB.getDateEditor().getUiComponent()).getText();
				int customerId = Integer.parseInt(txtCustomerId.getText());
				boolean result = UpdateProfile.updateData(dateOfBirth, email, contact, address, customerId);
				if (result == true) {
					JOptionPane.showMessageDialog(this, "Successfully Updated");
					dispose();// disposing frame
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
				} else
					JOptionPane.showMessageDialog(this, "Sorry Couldn't Update Your Data");
			}
		} else if (ae.getSource() == btnClose) {
			this.dispose();
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
		}
	}
}
