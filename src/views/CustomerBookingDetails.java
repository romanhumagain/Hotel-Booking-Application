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
import Controllers.BookingTableJDBC;
import models.GlobalBooking;
import models.ProfileTest;

//creating constructor to set up frame
public class CustomerBookingDetails extends JInternalFrame {
	JPanel panel;
	JTable tblBooking;
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

	// creating constructor to set up frame
	public CustomerBookingDetails() {
		this.setSize(890, 220);// setting the size of frame
		this.setTitle("Your Booking Details");// setting the title of frame
		panel = new JPanel();
		panel.setLayout(null);

		tblBooking = new JTable();
		model = new DefaultTableModel();
		tblBooking.setModel(model);
		// model = (DefaultTableModel) tblBooking.getModel();
		model.setColumnIdentifiers(new String[] { "Name", "Booking Id", "CheckIn", "CheckOut", "Booking Status",
				"Room No", "Room Type", "Payment Status" });
		tblBooking.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblBooking.setFillsViewportHeight(true);
		tblBooking.setEnabled(true);
		tblBooking.setBackground(Color.white);

		JScrollPane scroll = new JScrollPane(tblBooking);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 890, 220);
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
			// to get the selected data from table
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int rowIndex = tblBooking.getSelectedRow();
					if (rowIndex != -1) {
						String bookingId = tblBooking.getValueAt(rowIndex, 1).toString();
						GlobalBooking.bookingId = bookingId;
					}
				}
			}
		});

		int customerId = Integer.parseInt(ProfileTest.customerId);
		model = BookingTableJDBC.getData(customerId);// calling the method

		// Set the updated booking data as the model for the JTable
		tblBooking.setModel(model);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);

		// Refresh the table every 1 second

		refressTimer = new Timer(1000, e -> {
			model = BookingTableJDBC.getData(customerId);

			// Set the updated booking data as the model for the JTable
			tblBooking.setModel(model);
		});
		refressTimer.start();
		this.setVisible(true);// to make frame visible true
	}

	@Override
	public void dispose() {
		// Stop the timer before closing the window
		refressTimer.stop();
		super.dispose();
	}

}
