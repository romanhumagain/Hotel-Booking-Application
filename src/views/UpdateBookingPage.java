package views;
//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import Controllers.UpdateBookingJDBC;
import models.GlobalBooking;
import models.UpdateBooking;

public class UpdateBookingPage extends JInternalFrame implements ActionListener {
//declaring all components
	JPanel panel;
	JLabel bookingId;
	JTextField txtBookingId;
	JLabel checkIn;
	JDateChooser checkInDate;
	JLabel checkOut;
	JDateChooser checkOutDate;
	JLabel note;
	JButton btnSave;
	JButton btnClose;
	JLabel lblFooter;
	JLabel lblType;
	JComboBox roomType;
	Timer refressTimer;
	int strBookingId;

  //creating constructor to set up frame
	public UpdateBookingPage() {
		this.setSize(340, 330);//setting size of frame

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);

		Date date = new Date();
		checkIn = new JLabel("Check In");
		checkIn.setBounds(30, 20, 90, 35);
		checkIn.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		panel.add(checkIn);
		checkInDate = new JDateChooser();
		checkInDate.setBounds(140, 20, 150, 35);
		checkInDate.setDateFormatString("yyyy-MM-dd");
		checkInDate.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		checkInDate.setMinSelectableDate(date);
		date = checkInDate.getDate();
		panel.add(checkInDate);

		checkOut = new JLabel("Check Out");
		checkOut.setBounds(30, 70, 90, 35);
		checkOut.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		panel.add(checkOut);

		Date dateOut = new Date();
		checkOutDate = new JDateChooser();
		checkOutDate.setBounds(140, 70, 150, 35);
		checkOutDate.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		checkOutDate.setDateFormatString("yyyy-MM-dd");
		checkOutDate.setMinSelectableDate(dateOut);
		date = checkOutDate.getDate();
		panel.add(checkOutDate);

		lblType = new JLabel("Room Type");
		lblType.setBounds(30, 130, 100, 35);
		lblType.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		panel.add(lblType);

		String types[] = { "Single Room", "Double Room", "Twin Room" };
		roomType = new JComboBox(types);
		roomType.setBounds(140, 130, 150, 35);
		roomType.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		panel.add(roomType);

		btnSave = new JButton("Update");
		btnSave.setBounds(70, 200, 100, 35);
		btnSave.setBackground(new Color(0, 204, 204));
		btnSave.setFocusable(false);
		btnSave.addActionListener(this);
		panel.add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setBounds(180, 200, 100, 35);
		btnClose.setFocusable(false);
		btnClose.setBackground(Color.red);
		btnClose.setForeground(Color.white);
		btnClose.addActionListener(this);
		panel.add(btnClose);
   //adding panel to the frame
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);//making frame visible
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnSave) {
			LocalDate checkinDate = null;
			if (checkInDate.getDate() != null) {
				checkinDate = checkInDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			LocalDate checkoutDate = null;
			if (checkOutDate.getDate() != null) {
				checkoutDate = checkOutDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			}
			else if (checkInDate.getDate() == null) {
				JOptionPane.showMessageDialog(this, "Please Enter a CheckIn Date");
			} else if (checkOutDate.getDate() == null) {
				JOptionPane.showMessageDialog(this, "Please Enter a CheckOut Date");
			}
			else if (checkoutDate.isBefore(checkinDate)) {
				JOptionPane.showMessageDialog(this, "Invalid input: Checkout date cannot be before check-in date",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (ae.getSource() == btnSave) {
			// Refresh the table every 1 second
			if (GlobalBooking.bookingId == null || GlobalBooking.bookingId.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please select your booking id from your booking status table");
			}
			else {
				refressTimer = new Timer(200, e -> {
					strBookingId = Integer.parseInt(GlobalBooking.bookingId);
				});
				refressTimer.start();

				String checkInDate1 = ((JTextField) checkInDate.getDateEditor().getUiComponent()).getText();
				String checkOutDate2 = ((JTextField) checkOutDate.getDateEditor().getUiComponent()).getText();
				strBookingId = Integer.parseInt(GlobalBooking.bookingId);

				UpdateBooking updateBooking = new UpdateBooking();
				UpdateBookingJDBC updateBookingJDBC = new UpdateBookingJDBC();
				updateBooking.setBookingId(strBookingId);
				updateBooking.setCheckIn(checkInDate1);
				updateBooking.setCheckOut(checkOutDate2);

				boolean result = updateBookingJDBC.bookingUpdate(updateBooking);
				if (result) {
					JOptionPane.showMessageDialog(this, "Successfully Updated");
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

				} else {
					JOptionPane.showMessageDialog(this, "Couldn't Update");
				}
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
	//calling constructor to the main method
	public static void main(String[] args) {
		new UpdateBookingPage();
	}
}
