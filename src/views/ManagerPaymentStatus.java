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
import Controllers.ManagerBillTableJDBC;
import models.GlobalBill;

public class ManagerPaymentStatus extends JInternalFrame implements ActionListener {
	// declaring all components
	JPanel panel;
	JTable tblBill;
	DefaultTableModel model;
	// Timer timer;
	Timer refressTimer;
	Timer refressTimer1;
	JButton btnViewPayment;
	JButton btnViewUnPaid;

	// to create default constructor
	public ManagerPaymentStatus() {
		this.setSize(900, 450);// setting the size of the frame
		this.setTitle("Payment Details"); // setting the title of the frame
		panel = new JPanel();
		panel.setLayout(null);
		// initializing all the components

		tblBill = new JTable();
		model = new DefaultTableModel();
		tblBill.setModel(model); // adding model to the table
		model.setColumnIdentifiers(
				new String[] { "Booking_ID", "Name", "Bill_ID", "Amount", "Payment Status", "Payment_Date" });// adding column

		tblBill.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblBill.setFillsViewportHeight(true);
		tblBill.setEnabled(true);
		tblBill.setBackground(Color.white);

		JScrollPane scroll = new JScrollPane(tblBill);// adding scrollpane in the table
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 900, 330);
		panel.add(scroll);

		tblBill.setBackground(new Color(215, 215, 215));
		JTableHeader tblHeader1 = tblBill.getTableHeader();
		tblHeader1.setBackground(Color.black);
		tblHeader1.setForeground(Color.white);
		tblHeader1.setPreferredSize(new Dimension(50, 25));
		tblHeader1.setFont(new Font("Verdana", Font.PLAIN, 13));
		tblBill.setFont(new Font("Arial", Font.PLAIN, 15));

		tblBill.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblBill.setSelectionBackground(Color.cyan);
		tblBill.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// to get the selected data from the table
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int rowIndex = tblBill.getSelectedRow();
					if (rowIndex != -1) {
						// to add the selected data in the global variable
						String bookingId = tblBill.getValueAt(rowIndex, 0).toString();
						GlobalBill.bookingId = bookingId;
						String amount = tblBill.getValueAt(rowIndex, 3).toString();
						GlobalBill.amount = amount;
						// for printing bill
						String name = tblBill.getValueAt(rowIndex, 1).toString();
						GlobalBill.customerName = name;
						int billNo = Integer.parseInt(tblBill.getValueAt(rowIndex, 2).toString());
						GlobalBill.billNo = billNo;
						String staus = tblBill.getValueAt(rowIndex, 4).toString();
						GlobalBill.paymentStatus = staus;
					}
				}
			}
		});
		model = ManagerBillTableJDBC.getBillData();
		tblBill.setModel(model);// adding model to the table

		btnViewUnPaid = new JButton("View UnPaid Payment");
		btnViewUnPaid.setBounds(550, 350, 200, 40);
		btnViewUnPaid.setBackground(Color.black);
		btnViewUnPaid.setForeground(Color.red);
		btnViewUnPaid.setFont(new Font("times new roman", Font.BOLD, 17));
		btnViewUnPaid.setFocusable(false);
		btnViewUnPaid.addActionListener(this);
		panel.add(btnViewUnPaid);

		btnViewPayment = new JButton("View Payment Details");
		btnViewPayment.setBounds(550, 350, 200, 40);
		btnViewPayment.setBackground(Color.black);
		btnViewPayment.setForeground(Color.red);
		btnViewPayment.setFont(new Font("times new roman", Font.BOLD, 17));
		btnViewPayment.setFocusable(false);
		btnViewPayment.addActionListener(this);
		panel.add(btnViewPayment);

		this.add(panel, BorderLayout.CENTER);
		// Refresh the table every 1 second

		refressTimer = new Timer(1000, e -> {
			model = ManagerBillTableJDBC.getBillData();
			tblBill.setModel(model);
		});
		refressTimer.start();

		this.setVisible(true); // make the frame visible true
	}

	@Override
	public void dispose() {
		// Stop the timer before closing the window
		refressTimer.stop();
		super.dispose();
	}

	// methods for action listener
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnViewUnPaid) {
			refressTimer.stop();
			btnViewUnPaid.setVisible(false);
			btnViewPayment.setVisible(true);
			model = ManagerBillTableJDBC.getUnPaidBillData();
			tblBill.setModel(model);
			refressTimer1 = new Timer(1000, e -> {
				model = ManagerBillTableJDBC.getUnPaidBillData();
				tblBill.setModel(model);
			});
			refressTimer1.start();

		} else if (ae.getSource() == btnViewPayment) {
			refressTimer.start();
			refressTimer1.stop();
			btnViewPayment.setVisible(false);
			btnViewUnPaid.setVisible(true);
			model = ManagerBillTableJDBC.getBillData();
			tblBill.setModel(model);
		}
	}

	// calling the default constructor in the main method
	public static void main(String[] args) {
		new ManagerPaymentStatus();
	}
}
