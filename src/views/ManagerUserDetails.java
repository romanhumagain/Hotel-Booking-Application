package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Controllers.CancelBooking;
import Controllers.ManagerUserTableJDBC;
import models.Customer;
import models.GlobalManager;

public class ManagerUserDetails extends JInternalFrame implements ActionListener {
	//declaring all components
	JPanel panel;
	JTable tblUser;
	DefaultTableModel model;
	JButton deleteUser;
	JLabel lblCustomerName;
	JTextField txtCustomerName;
	JLabel lblAddress;
	JTextField txtAddress;
	JLabel lblCardNo;
	JTextField txtCardNo;
	JLabel lblCompanyName;
	JTextField txtCompanyName;
	JLabel lblType;
	JTextField txtType;
	JLabel lblContact;
	JTextField txtContact;
	Timer refressTimer;
	Timer refressTimer2;

	// creating default constructor to set up frame
	public ManagerUserDetails() {
		this.setSize(900, 450);// setting size of the panel
		this.setTitle("User Details");// setting title of the frame
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);

		tblUser = new JTable();
		model = new DefaultTableModel();
		tblUser.setModel(model); // adding model to the table
		// model = (DefaultTableModel) tblBooking.getModel();
		model.setColumnIdentifiers(new String[] { "Customer Id", "Name", "DOB", "Address", "Email", "Country",
				"Cust Type", "Card No", "Comp_Name", "Comp_Contact" });
		tblUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblUser.setFillsViewportHeight(true);
		tblUser.setEnabled(true);

		JScrollPane scroll = new JScrollPane(tblUser);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 900, 240);
		panel.add(scroll);

		tblUser.setBackground(new Color(215, 215, 215));
		JTableHeader tblHeader1 = tblUser.getTableHeader();
		tblHeader1.setBackground(Color.black);
		tblHeader1.setForeground(Color.white);
		tblHeader1.setPreferredSize(new Dimension(50, 25));
		tblHeader1.setFont(new Font("Verdana", Font.PLAIN, 10));
		tblUser.setFont(new Font("Arial", Font.PLAIN, 15));

		tblUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblUser.setSelectionBackground(Color.cyan);
		tblUser.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// getting the data from the selected row from the table
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int rowIndex = tblUser.getSelectedRow();
					if (rowIndex != -1) {

						// adding the selected value to the global variable
						String customerId = tblUser.getValueAt(rowIndex, 0).toString();
						GlobalManager.customerId = customerId;

						String name = tblUser.getValueAt(rowIndex, 1).toString();
						GlobalManager.cusName = name;

						String customerName = tblUser.getValueAt(rowIndex, 1).toString();
						GlobalManager.customerName = customerName;

						String address = tblUser.getValueAt(rowIndex, 3).toString();
						GlobalManager.customerAddress = address;

						String type = tblUser.getValueAt(rowIndex, 6).toString();
						GlobalManager.customerType = type;

						String card = tblUser.getValueAt(rowIndex, 7) != null
								? tblUser.getValueAt(rowIndex, 7).toString()
								: "";
						GlobalManager.customerCardNo = card;

						String comName = tblUser.getValueAt(rowIndex, 8) != null
								? tblUser.getValueAt(rowIndex, 8).toString()
								: "";
						GlobalManager.companyName = comName;

						String coContact = tblUser.getValueAt(rowIndex, 9) != null
								? tblUser.getValueAt(rowIndex, 9).toString()
								: "";
						GlobalManager.companyContact = coContact;

						if (type.equals("Corporate Customer")) {
							lblCompanyName.setVisible(true);
							lblContact.setVisible(true);
							txtCompanyName.setVisible(true);
							txtContact.setVisible(true);
						} else {
							txtCompanyName.setVisible(false);
							txtContact.setVisible(false);
							lblCompanyName.setVisible(false);
							lblContact.setVisible(false);
						}
					}
				}
			}
		});

		// calling method from another class
		model = ManagerUserTableJDBC.getUserData();
		tblUser.setModel(model); // adding model too the table

		lblCustomerName = new JLabel("Name :");
		lblCustomerName.setBounds(10, 260, 100, 35);
		lblCustomerName.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblCustomerName);

		txtCustomerName = new JTextField(GlobalManager.customerName);
		txtCustomerName.setBounds(70, 260, 140, 35);
		txtCustomerName.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(txtCustomerName);

		lblAddress = new JLabel("Address :");
		lblAddress.setBounds(230, 260, 130, 35);
		lblAddress.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblAddress);

		txtAddress = new JTextField(GlobalManager.customerAddress);
		txtAddress.setBounds(300, 260, 90, 35);
		txtAddress.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(txtAddress);

		lblType = new JLabel("Customer Type :");
		lblType.setBounds(410, 260, 130, 35);
		lblType.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblType);

		txtType = new JTextField(GlobalManager.customerType);
		txtType.setBounds(530, 260, 160, 35);
		txtType.setFont(new Font("times new roman", Font.PLAIN, 15));
		panel.add(txtType);

		lblCardNo = new JLabel("Card No.");
		lblCardNo.setBounds(700, 260, 110, 35);
		lblCardNo.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblCardNo);

		txtCardNo = new JTextField(GlobalManager.customerCardNo);
		txtCardNo.setBounds(775, 260, 100, 35);
		txtCardNo.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(txtCardNo);

		lblCompanyName = new JLabel("Company Name :");
		lblCompanyName.setBounds(10, 320, 130, 35);
		lblCompanyName.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblCompanyName);

		txtCompanyName = new JTextField(GlobalManager.companyName);
		txtCompanyName.setBounds(140, 320, 140, 35);
		txtCompanyName.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(txtCompanyName);

		lblContact = new JLabel("Company Contact :");
		lblContact.setBounds(600, 320, 170, 35);
		lblContact.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblContact);

		txtContact = new JTextField(GlobalManager.companyContact);
		txtContact.setBounds(745, 320, 120, 35);
		txtContact.setFont(new Font("times new roman", Font.BOLD, 15));
		panel.add(txtContact);

		deleteUser = new JButton("Delete User");
		deleteUser.setBounds(390, 360, 130, 40);
		// deleteUser.setFont(new Font("a" ,Font.PLAIN ,20));
		deleteUser.setFocusable(false);
		deleteUser.setBackground(Color.black);
		deleteUser.setForeground(Color.red);
		deleteUser.addActionListener(this);
		panel.add(deleteUser);
		// adding panel to the frame along with their position
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true); // to make the frame visible

		// Refresh the table every 1.5 second
		refressTimer = new Timer(1500, e -> {
			model = ManagerUserTableJDBC.getUserData();
			tblUser.setModel(model);
		});
		refressTimer.start(); // to start the refresstimer

		refressTimer2 = new Timer(200, e -> {
			txtCustomerName.setText(GlobalManager.customerName);
			txtAddress.setText(GlobalManager.customerAddress);
			txtType.setText(GlobalManager.customerType);
			txtCardNo.setText(GlobalManager.customerCardNo);
			txtCompanyName.setText(GlobalManager.companyName);
			txtContact.setText(GlobalManager.companyContact);
		});
		refressTimer2.start();
		this.setVisible(true); // to make the frame visible
	}
	@Override
	public void dispose() {
		// Stop the timer before closing the window
		refressTimer.stop();
		refressTimer2.stop();
		super.dispose();
	}

	// calling constructor in main method
	public static void main(String[] args) {
		new ManagerUserDetails();
	}
	// method for actionlistener
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == deleteUser) {
			if (GlobalManager.customerId.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Select the Row That You Want To Delete", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int ans = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to delete User of Customer ID " + GlobalManager.customerId,
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (ans == JOptionPane.YES_OPTION) {
					CancelBooking cancelBooking = new CancelBooking();
					Customer customer = new Customer();
					customer.setCustomerId(Integer.parseInt(GlobalManager.customerId));
					boolean result = cancelBooking.deleteUser(customer);
					if (result) {
						JOptionPane.showMessageDialog(this,
								"Successfully Deleted User Having ID " + GlobalManager.customerId);
					} else {
						JOptionPane.showMessageDialog(this,
								"Couldn't Delete User Having ID " + GlobalManager.customerId);
					}
				} else {
				}
			}
		}
	}
}
