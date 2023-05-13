package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controllers.InsertRoomJDBC;
import models.Room;

public class AddRoomPage extends JInternalFrame implements ActionListener {
	// declaring all components
	JPanel panelCenter;
	JLabel header;
	JLabel lblRoomType;
	JComboBox roomType;
	JLabel lblRoomPrice;
	JTextField txtRoomPrice;
	JLabel lblAvailablityStatus;
	JComboBox availablityStatus;
	JButton addRoom;
	JButton btnClose;

	// creating constructor to set up frame
	public AddRoomPage() {
		this.setSize(550, 450); // setting size of frame
		// initializing all components
		panelCenter = new JPanel();
		panelCenter.setLayout(null);

		header = new JLabel();
		header.setText("Adding New Room");
		header.setFont(new Font("times new roman", Font.BOLD, 30));
		header.setBounds(140, 15, 400, 40);
		panelCenter.add(header);

		lblRoomType = new JLabel("Room Type:");
		lblRoomType.setFont(new Font("times new roman", Font.PLAIN, 25));
		lblRoomType.setBounds(100, 100, 150, 30);
		panelCenter.add(lblRoomType);

		roomType = new JComboBox(new String[] { "Single Room", "Double Room", "Twin Room" });
		roomType.setBounds(250, 100, 200, 35);
		roomType.setFont(new Font("times new roman", Font.PLAIN, 25));
		roomType.addActionListener(this);
		panelCenter.add(roomType);

		lblRoomPrice = new JLabel("Room Price:");
		lblRoomPrice.setFont(new Font("times new roman", Font.PLAIN, 25));
		lblRoomPrice.setBounds(100, 180, 150, 30);
		panelCenter.add(lblRoomPrice);

		txtRoomPrice = new JTextField("3000");
		txtRoomPrice.setBounds(250, 180, 200, 35);
		txtRoomPrice.setFont(new Font("times new roman", Font.PLAIN, 25));
		txtRoomPrice.setEditable(false);
		panelCenter.add(txtRoomPrice);

		lblAvailablityStatus = new JLabel("Availability Status:");
		lblAvailablityStatus.setFont(new Font("times new roman", Font.PLAIN, 25));
		lblAvailablityStatus.setBounds(100, 250, 250, 35);
		panelCenter.add(lblAvailablityStatus);

		availablityStatus = new JComboBox(new String[] { "Available", "Booked" });
		availablityStatus.setBounds(310, 250, 140, 30);
		availablityStatus.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(availablityStatus);

		addRoom = new JButton("Add Room");
		addRoom.setBounds(155, 320, 120, 35);
		addRoom.setBackground(new Color(0, 204, 204));
		addRoom.setFocusable(false);
		addRoom.addActionListener(this);
		panelCenter.add(addRoom);

		btnClose = new JButton("Close");
		btnClose.setBounds(315, 320, 80, 35);
		btnClose.setBackground(Color.red);
		btnClose.setForeground(Color.white);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		panelCenter.add(btnClose);

		// adding panel to the frame at the center position
		this.add(panelCenter, BorderLayout.CENTER);
		this.setVisible(true);
	}

	// methods for action listener
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == roomType) {
			String selectedRoomType = (String) roomType.getSelectedItem();
			if (selectedRoomType.equals("Single Room")) {
				txtRoomPrice.setText("3000");
			} else if (selectedRoomType.equals("Double Room")) {
				txtRoomPrice.setText("4000");
			} else if (selectedRoomType.equals("Twin Room")) {
				txtRoomPrice.setText("5000");
			}
		} else if (ae.getSource() == addRoom) {
			Room room = new Room();
			String roomtype = (String) roomType.getSelectedItem();
			int roomPrice = Integer.parseInt(txtRoomPrice.getText());
			String availabilityStatus = (String) availablityStatus.getSelectedItem();

			room.setRoomType(roomtype);
			room.setRoomPrice(roomPrice);
			room.setAvailabilityStatus(availabilityStatus);

			InsertRoomJDBC insertRoom = new InsertRoomJDBC();
			boolean result = insertRoom.addRoom(room);
			if (result == true) {
				JOptionPane.showMessageDialog(this, "Successfully Added Room");
			} else {
				JOptionPane.showMessageDialog(this, "Sorry Couldn't Add Room", "!", JOptionPane.WARNING_MESSAGE);
			}
		} else if (ae.getSource() == btnClose) {
			dispose(); //disposing the frame
		}
	}
}
