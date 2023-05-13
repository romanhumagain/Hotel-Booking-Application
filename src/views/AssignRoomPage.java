package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controllers.AssignRoomJDBC;
import models.GlobalManager;
import models.Room;
import models.UpdateBooking;

public class AssignRoomPage extends JInternalFrame implements ActionListener {
	// declaring all components
	public static JPanel panelCenter;
	JLabel header;
	JLabel lblBookingId;
	JLabel lblRoomNo;
	JTextField txtBookingId;
	JLabel lblRoomType;
	JTextField txtRoomType;
	JTextField txtRoomNo;
	JButton assignRoom;
	JButton btnClose;
	Timer refressTimer;

	// creating the default constructor
	public AssignRoomPage() {
		// setting the size of the frame
		this.setSize(550, 450);
		panelCenter = new JPanel(); // initializing panel
		panelCenter.setLayout(null);
		panelCenter.setBackground(Color.white);

		// initializing all the component
		header = new JLabel();
		header.setText("Assigning Room");
		header.setFont(new Font("times new roman", Font.BOLD, 30));
		header.setBounds(180, 20, 400, 40);
		panelCenter.add(header);

		lblBookingId = new JLabel("Booking ID :");
		lblBookingId.setBounds(20, 100, 200, 40);
		lblBookingId.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(lblBookingId);

		txtBookingId = new JTextField(GlobalManager.roomBookingId);
		txtBookingId.setBounds(170, 103, 70, 40);
		txtBookingId.setFont(new Font("times new roman", Font.PLAIN, 25));
		txtBookingId.setEditable(false);
		panelCenter.add(txtBookingId);

		lblRoomType = new JLabel("Room Type : ");
		lblRoomType.setBounds(270, 103, 140, 35);
		lblRoomType.setFont(new Font("Times new roman", Font.PLAIN, 25));
		panelCenter.add(lblRoomType);

		txtRoomType = new JTextField(GlobalManager.roomType);
		txtRoomType.setBounds(410, 103, 120, 40);
		txtRoomType.setFont(new Font("Times new roman", Font.PLAIN, 20));
		txtRoomType.setEditable(false);
		txtRoomType.setForeground(Color.DARK_GRAY);
		panelCenter.add(txtRoomType);

		lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(150, 180, 200, 40);
		lblRoomNo.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(lblRoomNo);

		txtRoomNo = new JTextField(GlobalManager.roomRoomId);
		txtRoomNo.setBounds(270, 183, 100, 40);
		txtRoomNo.setFont(new Font("times new roman", Font.PLAIN, 25));
		txtRoomNo.setEditable(false);
		panelCenter.add(txtRoomNo);

		assignRoom = new JButton("Assign Room");
		assignRoom.setBounds(145, 280, 120, 35);
		assignRoom.setBackground(new Color(0, 204, 204));
		assignRoom.setFocusable(false);
		assignRoom.addActionListener(this);
		panelCenter.add(assignRoom);

		btnClose = new JButton("Close");
		btnClose.setBounds(290, 280, 80, 35);
		btnClose.setBackground(Color.red);
		btnClose.setForeground(Color.white);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		panelCenter.add(btnClose);

		// adding panel in the frame along with thier position
		this.add(panelCenter, BorderLayout.CENTER);
		this.setVisible(true);// to make the frame visible

		// to initialize the refress timer
		refressTimer = new Timer(100, e -> {
			txtRoomNo.setText(GlobalManager.roomRoomId);
			txtBookingId.setText(GlobalManager.roomBookingId);
			txtRoomType.setText(GlobalManager.roomType);
		});
		refressTimer.start();

	}

	@Override
	public void dispose() {
		refressTimer.stop();
		super.dispose();
	}

	// methods for actionlistener
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == assignRoom) {
			if (!GlobalManager.roomId.equals("0")) {
				JOptionPane.showMessageDialog(this, "Room Already Assigned For Booking ID " + GlobalManager.bookingId);
				GlobalManager.roomBookingId = "";
				GlobalManager.roomRoomId = "";
			}

			else if (txtRoomNo.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Please Select Appropriate Room", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

			else {
				Room room = new Room();
				UpdateBooking updateBooking = new UpdateBooking();
				String roomNo = txtRoomNo.getText();
				int roomId = Integer.parseInt(roomNo);
				int bookingId = Integer.parseInt(txtBookingId.getText());

				if (!GlobalManager.roomType.equals(GlobalManager.roomTypeRoom)) {
					JOptionPane.showMessageDialog(this, "Please Assign The Same Room As Requested By The Customer",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					GlobalManager.roomRoomId = "";
				} else if (GlobalManager.availabilityStatus.equals("Available")) {
					room.setRoomId(roomId);
					updateBooking.setBookingId(bookingId);
					boolean result = AssignRoomJDBC.assignRoom(room, updateBooking);
					if (result = true) {
						txtRoomNo.setText("");
						txtBookingId.setText("");

						String availableRoom = "Booked";
						room.setAvailabilityStatus(availableRoom);
						room.setRoomId(roomId);
						boolean result1 = AssignRoomJDBC.availableRoom(room);
						if (result1 == true) {
							// JOptionPane.showMessageDialog(this, "Successfully Assigned Room");
						}
					} else {
						JOptionPane.showMessageDialog(this, "Sorry Couldn't Assign Room", "!",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				else {
					JOptionPane.showMessageDialog(this, "This room is already assigned to another customer", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (ae.getSource() == btnClose) {
			this.dispose();
			GlobalManager.roomRoomId = "";
			GlobalManager.roomBookingId = "";
		}
	}

	// calling the constructor in the main method
	public static void main(String[] args) {
		new AssignRoomPage();
	}
}
