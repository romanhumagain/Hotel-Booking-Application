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

import Controllers.ManagerRoomTableJDBC;
import models.GlobalManager;

public class ManagerRoomDetails extends JInternalFrame implements ActionListener {
	JPanel panel;
	JTable tblRoom;
	DefaultTableModel model;
	JButton viewAllRooom;
	JButton viewAvailableRooom;
	Timer refressTimer;
	Timer refressTimer1;

	// creating default constructor
	public ManagerRoomDetails() {
		this.setSize(900, 450); // setting the size of the frame
		this.setTitle("Available Room Details");// setting the title of the frame
		panel = new JPanel();
		panel.setLayout(null); // setting layout of the panel to null

		tblRoom = new JTable();
		model = new DefaultTableModel();
		tblRoom.setModel(model); // adding model to the table
		// model = (DefaultTableModel) tblBooking.getModel();
		model.setColumnIdentifiers(new String[] { "Room_NO", "Room_Type", "Room_Price", "Availability Status" });// adding column
		
		tblRoom.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblRoom.setFillsViewportHeight(true);
		tblRoom.setEnabled(true);
		tblRoom.setBackground(Color.white);

		JScrollPane scroll = new JScrollPane(tblRoom);// adding scrollpane to the table
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 900, 330);
		panel.add(scroll);

		tblRoom.setBackground(new Color(215, 215, 215));
		JTableHeader tblHeader1 = tblRoom.getTableHeader();
		tblHeader1.setBackground(Color.black);
		tblHeader1.setForeground(Color.white);
		tblHeader1.setPreferredSize(new Dimension(50, 25));
		tblHeader1.setFont(new Font("Verdana", Font.PLAIN, 13));
		tblRoom.setFont(new Font("Arial", Font.PLAIN, 15));

		viewAllRooom = new JButton("View ALL Room");
		viewAllRooom.setBounds(550, 350, 200, 40);
		viewAllRooom.setBackground(Color.black);
		viewAllRooom.setForeground(Color.red);
		viewAllRooom.setFont(new Font("times new roman", Font.BOLD, 17));
		viewAllRooom.setFocusable(false);
		viewAllRooom.addActionListener(this);
		panel.add(viewAllRooom);

		viewAvailableRooom = new JButton("View Available Room");
		viewAvailableRooom.setBounds(550, 350, 200, 40);
		viewAvailableRooom.setBackground(Color.black);
		viewAvailableRooom.setForeground(Color.red);
		viewAvailableRooom.setFont(new Font("times new roman", Font.BOLD, 17));
		viewAvailableRooom.setFocusable(false);
		viewAvailableRooom.addActionListener(this);
		panel.add(viewAvailableRooom);

		tblRoom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblRoom.setSelectionBackground(Color.cyan);
		tblRoom.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			// get the selected value from the table
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int rowIndex = tblRoom.getSelectedRow();
					if (rowIndex != -1) {
						// adding the selected value to the global variable
						String roomId = tblRoom.getValueAt(rowIndex, 0).toString();
						GlobalManager.roomRoomId = roomId;
						String roomType = tblRoom.getValueAt(rowIndex, 1).toString();
						GlobalManager.roomTypeRoom = roomType;
						String status = tblRoom.getValueAt(rowIndex, 3).toString();
						GlobalManager.availabilityStatus = status;
					}
				}
			}
		});
		// calling method of another class
		model = ManagerRoomTableJDBC.getRoomData();
		tblRoom.setModel(model);// adding model to the table

		// refress table in every 1 sec
		refressTimer = new Timer(1000, e -> {
			model = ManagerRoomTableJDBC.getRoomData();
			tblRoom.setModel(model);
		});
		refressTimer.start();// to start the refress time

		// adding panel to the frame along with thier position
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);// to make the frame visible
	}

	@Override
	public void dispose() {
		// to stop time before disposing the window
		refressTimer.stop();
		super.dispose();
	}

	// methods for action listener
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == viewAllRooom) {
			refressTimer.stop();
			viewAllRooom.setVisible(false);
			viewAvailableRooom.setVisible(true);
			model = ManagerRoomTableJDBC.getAllRoomData();
			tblRoom.setModel(model);

			// to refress table in every 1 sec
			refressTimer1 = new Timer(1000, e -> {
				model = ManagerRoomTableJDBC.getAllRoomData();
				tblRoom.setModel(model); // adding model to the table

			});
			refressTimer1.start();

		} else if (ae.getSource() == viewAvailableRooom) {
			refressTimer.start();
			refressTimer1.stop();
			viewAvailableRooom.setVisible(false);
			viewAllRooom.setVisible(true);
			tblRoom.setVisible(true);
			model = ManagerRoomTableJDBC.getRoomData();
			tblRoom.setModel(model);
		}
	}
}
