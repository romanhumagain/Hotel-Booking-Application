package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controllers.CreditCardJDBC;
import models.CreditCard;
import models.ProfileTest;

public class CreditCardPage extends JInternalFrame implements ActionListener {
	// declaring all components
	JLabel lblCardNumber;
	JLabel lblCardType;
	JLabel lblName;
	JTextField txtCardNumber;
	JComboBox txtCardType;
	JTextField txtName;
	JPanel panel;
	JButton btndata;

	// creating default constructor to set up frame
	public CreditCardPage() {
		this.setSize(240, 330);// setting frame size
		this.setClosable(true);
		// initializing all components
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(215, 215, 215));

		lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setBounds(10, 10, 150, 35);
		lblCardNumber.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(lblCardNumber);

		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(10, 45, 200, 30);
		txtCardNumber.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		panel.add(txtCardNumber);

		lblCardType = new JLabel("Card Type:");
		lblCardType.setBounds(10, 80, 150, 35);
		lblCardType.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(lblCardType);

		String cardTypes[] = { "Visa Card", " Mastercard" };
		txtCardType = new JComboBox(cardTypes);
		txtCardType.setBounds(10, 115, 200, 30);
		txtCardType.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		panel.add(txtCardType);

		lblName = new JLabel("Card Holder Name:");
		lblName.setBounds(10, 160, 140, 35);
		lblName.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(lblName);

		txtName = new JTextField();
		txtName.setBounds(10, 195, 200, 30);
		txtName.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		panel.add(txtName);

		btndata = new JButton("Add Existing Data");
		btndata.setBounds(10, 245, 200, 35);
		btndata.setBackground(new Color(0, 204, 204));
		btndata.setFocusable(false);
		btndata.addActionListener(this);

		panel.add(btndata);
		// adding panel to the frame
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true); // to make frame visible
	}

	// calling constructor in main method
	public static void main(String[] args) {
		new CreditCardPage();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btndata) {
			if (txtCardNumber.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide Your Credit Card Number", "!",
						JOptionPane.WARNING_MESSAGE);
			}

			else if (txtName.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide Card Holder Name", "!",
						JOptionPane.WARNING_MESSAGE);
			} else {
				int customerId = Integer.parseInt(ProfileTest.customerId);
				String cardNumb = txtCardNumber.getText();
				String cardHolderName = txtName.getText();
				String cardType = "Visa Card";
				CreditCard card = new CreditCard();
				card.setCardHolderName(cardHolderName);
				card.setCardNumber(cardNumb);
				card.setCardType(cardType);
				card.setCustomerId(customerId);

				CreditCardJDBC creditCardJDBC = new CreditCardJDBC();
				boolean result = creditCardJDBC.cardData(card);
				if (result) {
					JOptionPane.showMessageDialog(this, "Scuccessfully Registered Card Details");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Couldn't Register Your Card Details", "!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	public void closeInternalFrame() {
		this.dispose();
		
	}
}
