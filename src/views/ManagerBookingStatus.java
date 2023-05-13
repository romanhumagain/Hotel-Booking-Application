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

import Controllers.BookingJDBC;
import Controllers.CancelBooking;
import Controllers.ManagerBookingTableJDBC;
import models.Booking;
import models.Cancel;
import models.GlobalManager;
import models.Room;

public class ManagerBookingStatus extends JInternalFrame implements ActionListener {
	// declaring all components
	JPanel panel;
	JTable tblBooking;
	DefaultTableModel model;
	JButton cancelBooking;
	JButton confirmBooking;
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
	JLabel lblRoomType;
	JTextField txtRoomType;
	JButton checkOut;

	// creating default constructor to set up frame
	public ManagerBookingStatus() {
		this.setSize(900, 450);// setting size of the frame
		this.setTitle("Booking Details"); // setting the title of the frame
		panel = new JPanel();
		panel.setLayout(null);// setting layout of the panel to null

		// initializing new table
		tblBooking = new JTable();
		model = new DefaultTableModel();
		tblBooking.setModel(model); // adding model to the table
		// model = (DefaultTableModel) tblBooking.getModel();
		// adding column in the table
		model.setColumnIdentifiers(new String[] { "Booking Id", "Name", "Cust ID", "Cust Type", "Company_Name",
				"Company_Contact", "CheckIn", "CheckOut", "No Of Room", "Booking Status", "Room No", "Room Type",
				"Payment Status" });
		tblBooking.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblBooking.setFillsViewportHeight(true);
		tblBooking.setEnabled(true);
		tblBooking.setBackground(Color.white);

		JScrollPane scroll = new JScrollPane(tblBooking); // adding scrollpane to the table
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 900, 240);
		panel.add(scroll);

		tblBooking.setBackground(new Color(215, 215, 215));
		JTableHeader tblHeader1 = tblBooking.getTableHeader();
		tblHeader1.setBackground(Color.black);
		tblHeader1.setForeground(Color.white);
		tblHeader1.setPreferredSize(new Dimension(50, 25));
		tblHeader1.setFont(new Font("Verdana", Font.PLAIN, 10));
		tblBooking.setFont(new Font("Arial", Font.PLAIN, 15));

		tblBooking.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblBooking.setSelectionBackground(Color.cyan);
		tblBooking.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// to get the selected value from the table
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int rowIndex = tblBooking.getSelectedRow();
					if (rowIndex != -1) {
						String bookingId = tblBooking.getValueAt(rowIndex, 0).toString();
						String name = tblBooking.getValueAt(rowIndex, 1).toString();
						String checkIn = tblBooking.getValueAt(rowIndex, 6).toString();
						String checkOut = tblBooking.getValueAt(rowIndex, 7).toString();
						String roomNo = tblBooking.getValueAt(rowIndex, 10).toString();
						String roomType = tblBooking.getValueAt(rowIndex, 11).toString();
						String roomBookingId = tblBooking.getValueAt(rowIndex, 0).toString();
						String payment = tblBooking.getValueAt(rowIndex, 12).toString();
						String bStatus = tblBooking.getValueAt(rowIndex, 9).toString();

						// adding the above selected value to the global variable
						GlobalManager.bookingId = bookingId;
						GlobalManager.name = name;
						GlobalManager.checkIn = checkIn;
						GlobalManager.checkOut = checkOut;
						GlobalManager.roomId = roomNo;
						GlobalManager.roomType = roomType;
						GlobalManager.roomBookingId = roomBookingId;
						GlobalManager.payment = payment;
						GlobalManager.bookingStatus = bStatus;

					}
				}
			}
		});

		model = ManagerBookingTableJDBC.getBookingData(); // calling method from another class
		tblBooking.setModel(model); // adding model to the table

		lblCustomerName = new JLabel("Name :");
		lblCustomerName.setBounds(50, 260, 100, 35);
		lblCustomerName.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblCustomerName);

		txtCustomerName = new JTextField(GlobalManager.name);
		txtCustomerName.setBounds(110, 260, 140, 35);
		txtCustomerName.setFont(new Font("times new roman", Font.PLAIN, 17));
		panel.add(txtCustomerName);

		lblBookingId = new JLabel("Booking ID :");
		lblBookingId.setBounds(280, 260, 130, 35);
		lblBookingId.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblBookingId);

		txtBookingId = new JTextField(GlobalManager.bookingId);
		txtBookingId.setBounds(380, 260, 50, 35);
		txtBookingId.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(txtBookingId);

		lblCheckIn = new JLabel("CheckIn :");
		lblCheckIn.setBounds(460, 260, 130, 35);
		lblCheckIn.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblCheckIn);

		txtCheckIn = new JTextField(GlobalManager.checkIn);
		txtCheckIn.setBounds(540, 260, 90, 35);
		txtCheckIn.setFont(new Font("times new roman", Font.PLAIN, 17));
		panel.add(txtCheckIn);

		lblCheckOut = new JLabel("CheckOut :");
		lblCheckOut.setBounds(660, 260, 130, 35);
		lblCheckOut.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblCheckOut);

		txtCheckOut = new JTextField(GlobalManager.checkOut);
		txtCheckOut.setBounds(750, 260, 90, 35);
		txtCheckOut.setFont(new Font("times new roman", Font.PLAIN, 17));
		panel.add(txtCheckOut);

		lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(50, 320, 130, 35);
		lblRoomNo.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblRoomNo);

		txtRoomNo = new JTextField(GlobalManager.roomId);
		txtRoomNo.setBounds(140, 320, 50, 35);
		txtRoomNo.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(txtRoomNo);

		lblRoomType = new JLabel("Room Type :");
		lblRoomType.setBounds(220, 320, 130, 35);
		lblRoomType.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(lblRoomType);

		txtRoomType = new JTextField(GlobalManager.roomType);
		txtRoomType.setBounds(320, 320, 110, 35);
		txtRoomType.setFont(new Font("times new roman", Font.BOLD, 17));
		panel.add(txtRoomType);

		confirmBooking = new JButton("Confirm Booking");
		confirmBooking.setBounds(400, 370, 160, 40);
		confirmBooking.setBackground(Color.black);
		confirmBooking.setForeground(Color.red);
		confirmBooking.setFont(new Font("times new roman", Font.BOLD, 15));
		confirmBooking.setFocusable(false);
		confirmBooking.addActionListener(this);
		panel.add(confirmBooking);

		checkOut = new JButton("Check Out");
		checkOut.setBounds(580, 370, 130, 40);
		checkOut.setBackground(Color.black);
		checkOut.setForeground(Color.red);
		checkOut.setFont(new Font("times new roman", Font.BOLD, 15));
		checkOut.setFocusable(false);
		checkOut.addActionListener(this);
		panel.add(checkOut);

		cancelBooking = new JButton("Cancel Booking");
		cancelBooking.setBounds(730, 370, 150, 40);
		cancelBooking.setBackground(Color.red);
		cancelBooking.setForeground(Color.white);
		cancelBooking.setFont(new Font("times new roman", Font.BOLD, 15));
		cancelBooking.setFocusable(false);
		cancelBooking.addActionListener(this);
		panel.add(cancelBooking);
		this.add(panel, BorderLayout.CENTER);

		this.setVisible(true);

		// to make the table refress in every 1.5 sec
		refressTimer = new Timer(1500, e -> {
			model = ManagerBookingTableJDBC.getBookingData();
			tblBooking.setModel(model);
		});
		
		refressTimer.start(); // to start refress timer

		refressTimer2 = new Timer(200, e -> {
			txtCustomerName.setText(GlobalManager.name);
			txtBookingId.setText(GlobalManager.bookingId);
			txtCheckIn.setText(GlobalManager.checkIn);
			txtCheckOut.setText(GlobalManager.checkOut);
			txtRoomNo.setText(GlobalManager.roomId);
			txtRoomType.setText(GlobalManager.roomType);
		});
		refressTimer2.start();
	}
	@Override
	public void dispose() {
		refressTimer2.stop();
		refressTimer.stop();
		super.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == cancelBooking) {
			if (GlobalManager.bookingId.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Select the Row That You Want To Cancel", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			else {
				int ans = JOptionPane.showConfirmDialog(this,
						"Are you sure you want to cancel booking of Booking ID " + GlobalManager.bookingId,
						"Confirmation", JOptionPane.YES_NO_OPTION);
				if (ans == JOptionPane.YES_OPTION) {
					CancelBooking cancelBooking = new CancelBooking();
					Cancel cancel = new Cancel();
					cancel.setBookingId(Integer.parseInt(GlobalManager.bookingId));
					boolean result = cancelBooking.cancelBooking(cancel);
					if (result) {
						JOptionPane.showMessageDialog(this,
								"Successfully Canceled Booking Having Booking ID " + GlobalManager.bookingId);
					} else {
						JOptionPane.showMessageDialog(this,
								"Couldn't Cancel Booking Having Booking ID " + GlobalManager.bookingId);
					}
				} else {
				}
			}
		}
		else if (ae.getSource() == confirmBooking) {
			if (GlobalManager.bookingId == "") {
				JOptionPane.showMessageDialog(this, "Select Booking From Table", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			} else if (!GlobalManager.roomId.equals("0")) {
				BookingJDBC bookingJDBC = new BookingJDBC();
				Booking booking = new Booking();
				booking.setBookingStatus("Approved");
				booking.setBookingId(Integer.parseInt(GlobalManager.bookingId));
				boolean result = bookingJDBC.checkOut(booking);
				if (result) {
					JOptionPane.showMessageDialog(this, "Successfully Confirmed Booking Of " + GlobalManager.name);
					GlobalManager.bookingId = "";
				} else {
					JOptionPane.showMessageDialog(this, "Couldn't confirm booking of " + GlobalManager.cusName, "ERROR",
							JOptionPane.ERROR_MESSAGE);
					GlobalManager.bookingId = "";
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Please assign room first", "WARNING", JOptionPane.WARNING_MESSAGE);
			}
		} else if (ae.getSource() == checkOut) {
			if (GlobalManager.bookingStatus.equals("Approved")) {
				Room room = new Room();
				room.setRoomId(Integer.parseInt(GlobalManager.roomId));
				ManagerBookingTableJDBC checkOut = new ManagerBookingTableJDBC();
				boolean result = checkOut.checkOut(room);
				if (result) {
					JOptionPane.showMessageDialog(this, "Successfully checked out");
				} else {
					JOptionPane.showMessageDialog(this, "couldn't checked out");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Couldn't check out " + GlobalManager.name, "ERROR !",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	// calling constructor to the main method
	public static void main(String[] args) {
		new ManagerBookingStatus();
	}
}
