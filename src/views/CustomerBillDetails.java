package views;

//import all the necessary libraries and classes for the GUI

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import Controllers.BillingTableJDBC;
import models.ProfileTest;

public class CustomerBillDetails extends JInternalFrame {
	JPanel panel;
	JTable tblBill;
	DefaultTableModel model;
	JButton cancelBooking;
	JButton checkOut;
	Timer refressTimer;
	Timer refressTimer2;
	JLabel lblBookingId;
	JTextField txtBookingId;
	JLabel lblCustomerName;
	JTextField txtCustomerName;
	JLabel lblCheckIn;
	JTextField txtCheckIn;
	JLabel lblCheckOut;
	JTextField txtCheckOut;
	JLabel lblRoomNo;
	JTextField txtRoomNo;

	// creating constructor
	public CustomerBillDetails() {
		this.setSize(800, 200);// setting size of frame
		this.setTitle("Your Payment Details");// setting title of frame
		panel = new JPanel();
		panel.setLayout(null);

		tblBill = new JTable();
		model = new DefaultTableModel();
		tblBill.setModel(model);
		// model = (DefaultTableModel) tblBooking.getModel();
		model.setColumnIdentifiers(new String[] { "Booking Id", "Name", "Total Amount", "Payment Status" });
		tblBill.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblBill.setFillsViewportHeight(true);
		tblBill.setEnabled(true);
		tblBill.setBackground(Color.white);

		JScrollPane scroll = new JScrollPane(tblBill);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 800, 200);
		panel.add(scroll);

		tblBill.setBackground(new Color(215, 215, 215));
		JTableHeader tblHeader1 = tblBill.getTableHeader();
		tblHeader1.setBackground(Color.black);
		tblHeader1.setForeground(Color.white);
		tblHeader1.setPreferredSize(new Dimension(50, 25));
		tblHeader1.setFont(new Font("Verdana", Font.PLAIN, 10));
		tblBill.setFont(new Font("Arial", Font.PLAIN, 15));

		tblBill.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblBill.setSelectionBackground(Color.cyan);
		tblBill.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// to select date from table
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int rowIndex = tblBill.getSelectedRow();
					if (rowIndex != -1) {
						String bookingId = tblBill.getValueAt(rowIndex, 0).toString();
						// GlobalBooking.bookingId = bookingId;
					}
				}
			}
		});

		int customerId = Integer.parseInt(ProfileTest.customerId);

		model = BillingTableJDBC.getData(customerId);
		tblBill.setModel(model);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		// Refresh the table every 1 second

		refressTimer = new Timer(1000, e -> {
			model = BillingTableJDBC.getData(customerId);
			tblBill.setModel(model);// adding model to the table
		});
		refressTimer.start();
		this.setVisible(true);// to make frame visible
	}

	@Override
	public void dispose() {
		// Stop the timer before closing the window
		refressTimer.stop();
		super.dispose();// to dispose the frame
	}
}
