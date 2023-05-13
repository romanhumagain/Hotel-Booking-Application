package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.toedter.calendar.JDateChooser;
import Controllers.BookingJDBC;
import models.Bill;
import models.Booking;
import models.LoginTest;
import models.Room;

public class BookingPage extends JInternalFrame implements ActionListener {
	// declaring all components
	JPanel north;
	JLabel header;
	JPanel panel;
	JLabel header1;
	JLabel header2;
	JLabel header3;
	JLabel checkin_lbl;
	JLabel checkout_lbl;
	JLabel roomType_lbl;
	static JTextField roomType_txt;
	JComboBox roomtype;
	JLabel roomNumber_lbl;
	JSpinner spinner;
	JLabel costPerRoom_lbl;
	static JTextField costPerRoom_txt;
	JLabel totalCost_lbl;
	JTextField totalCost_txt;
	JLabel numberOfAdult;
	JTextField adult;
	JButton adultPlus;
	JButton adultMinus;
	JButton btn_save;
	JButton btn_update;
	JButton btn_delete;
	JButton btn_close;
	JDateChooser dateChooserIn;
	JDateChooser dateChooserOut;
	JCheckBox creditCardBox;
	JButton buttonCredit;
	JLabel lblNote;
	private CreditCardPage creditCard;

	// creating default constructor to set up frame
	public BookingPage() {
		// to get screenzise
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		// setting the size of frame
		this.setSize(730, 540);
		// setting the location of the frame
		this.setLocation(580, 256);
		// this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		// to make the frame resizable false
		this.setResizable(false);

		// initializing all the component
		north = new JPanel();
		north.setPreferredSize(new Dimension(900, 80));
		north.setBackground(Color.black);
		north.setLayout(null);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(900, 600));
		panel.setBackground(Color.white);
		// panel.setBackground(new Color(0, 204, 204));
		// creating JLabel named header
		header1 = new JLabel("Luton");
		header1.setBounds(10, 10, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 40));
		header1.setForeground(Color.white);
		north.add(header1);
		// creating JLabel named header2
		header2 = new JLabel("Hotel");
		header2.setBounds(75, 40, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 18));
		header2.setForeground(Color.red);
		// header2.setForeground(new Color(153, 101, 21));
		north.add(header2);

		header3 = new JLabel("Booking Form");
		header3.setBounds(280, 20, 300, 40);
		header3.setFont(new Font("Arial", Font.BOLD, 28));
		header3.setForeground(Color.white);
		north.add(header3);

		checkin_lbl = new JLabel();
		checkin_lbl.setText("Check In");
		checkin_lbl.setBounds(10, 20, 100, 30);
		checkin_lbl.setForeground(Color.black);
		checkin_lbl.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(checkin_lbl);
		Date date = new Date();
		dateChooserIn = new JDateChooser();
		dateChooserIn.setMinSelectableDate(date);
		dateChooserIn.setBounds(155, 20, 180, 40);
		dateChooserIn.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(dateChooserIn);

		checkout_lbl = new JLabel();
		checkout_lbl.setText("Check Out");
		checkout_lbl.setBounds(380, 20, 100, 30);
		checkout_lbl.setForeground(Color.black);
		checkout_lbl.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(checkout_lbl);

		dateChooserOut = new JDateChooser();
		dateChooserOut.setMinSelectableDate(date);
		dateChooserOut.setBounds(520, 20, 180, 40);
		dateChooserOut.setFont(new Font("Arial", Font.PLAIN, 18));
		panel.add(dateChooserOut);

		roomType_lbl = new JLabel();
		roomType_lbl.setText("Room Type");
		roomType_lbl.setBounds(10, 90, 120, 30);
		roomType_lbl.setForeground(Color.black);
		roomType_lbl.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(roomType_lbl);

		roomType_txt = new JTextField();
		roomType_txt.setBounds(155, 90, 180, 40);
		roomType_txt.setForeground(Color.DARK_GRAY);
		roomType_txt.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(roomType_txt);

		roomNumber_lbl = new JLabel();
		roomNumber_lbl.setText("Number of Room");
		roomNumber_lbl.setBounds(380, 90, 160, 30);
		roomNumber_lbl.setForeground(Color.black);
		roomNumber_lbl.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(roomNumber_lbl);

		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 10, 1);
		spinner = new JSpinner(spinnerModel);
		spinner.setBounds(550, 86, 70, 40);
		spinner.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(spinner);

		costPerRoom_lbl = new JLabel();
		costPerRoom_lbl.setText("Room Price ($)");
		costPerRoom_lbl.setBounds(10, 170, 140, 30);
		costPerRoom_lbl.setForeground(Color.black);
		costPerRoom_lbl.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(costPerRoom_lbl);

		creditCardBox = new JCheckBox("Credit Card Details");
		creditCardBox.setBounds(40, 265, 200, 40);
		creditCardBox.setBackground(Color.white);
		creditCardBox.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		creditCardBox.setFocusable(false);
		panel.add(creditCardBox);

		buttonCredit = new JButton("ADD");
		buttonCredit.setBounds(40, 280, 165, 35);
		buttonCredit.setFocusable(false);
		// buttonCredit.setBackground(new Color(0, 204, 204));
		buttonCredit.addActionListener(this);

		buttonCredit.setForeground(Color.black);
		// panel.add(buttonCredit);

		if (LoginTest.customerType.equals("Non Corporate Customer")) {
			creditCardBox.setSelected(true);
			creditCard = new CreditCardPage();
			FrontPage.lbl_img.add(creditCard);
			creditCard.setLocation(1265, 250);

		}

		lblNote = new JLabel("Note : Non Corporate Customer Should Fill The Credit Card Details");
		lblNote.setBounds(10, 320, 600, 35);
		lblNote.setFont(new Font("times new roman", Font.ITALIC, 15));
		lblNote.setForeground(Color.black);
		panel.add(lblNote);

		costPerRoom_txt = new JTextField();
		costPerRoom_txt.setBounds(155, 165, 180, 40);
		costPerRoom_txt.setForeground(Color.DARK_GRAY);
		costPerRoom_txt.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(costPerRoom_txt);

		totalCost_lbl = new JLabel();
		totalCost_lbl.setText("Total Cost ($)");
		totalCost_lbl.setBounds(380, 165, 150, 30);
		totalCost_lbl.setForeground(Color.black);
		totalCost_lbl.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(totalCost_lbl);

		totalCost_txt = new JTextField();
		totalCost_txt.setBounds(520, 165, 180, 40);
		totalCost_txt.setForeground(Color.black);
		totalCost_txt.setEditable(false);
		totalCost_txt.setFont(new Font("Arial", Font.PLAIN, 20));
		panel.add(totalCost_txt);

		numberOfAdult = new JLabel();
		numberOfAdult.setText("Adults");
		numberOfAdult.setBounds(550, 240, 100, 30);
		numberOfAdult.setForeground(Color.black);
		numberOfAdult.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 18));
		panel.add(numberOfAdult);

		adultPlus = new JButton("+");
		adultPlus.setBounds(480, 275, 50, 34);
		adultPlus.setForeground(Color.black);
		adultPlus.setFont(new Font("Arial", Font.BOLD, 20));
		adultPlus.setFocusable(false);
		adultPlus.setBackground(Color.LIGHT_GRAY);
		panel.add(adultPlus, BorderLayout.WEST);
		adultPlus.addActionListener(this);

		adult = new JTextField("0");
		adult.setBounds(530, 275, 100, 35);
		adult.setForeground(Color.DARK_GRAY);
		adult.setFont(new Font("Arial", Font.PLAIN, 20));
		adult.setHorizontalAlignment(JTextField.CENTER);
		panel.add(adult);

		adultMinus = new JButton("-");
		adultMinus.setBounds(628, 275, 50, 34);
		adultMinus.setForeground(Color.black);
		adultMinus.setFont(new Font("Arial", Font.BOLD, 20));
		adultMinus.setBackground(Color.LIGHT_GRAY);
		adultMinus.setFocusable(false);
		panel.add(adultMinus, BorderLayout.EAST);
		adultMinus.addActionListener(this);

		btn_save = new JButton();
		btn_save.setText("Book");
		btn_save.setBounds(220, 375, 160, 40);
		btn_save.setBackground(new Color(0, 204, 204));
		btn_save.setForeground(Color.black);
		btn_save.setFont(new Font("sans serif", Font.CENTER_BASELINE, 18));
		btn_save.setFocusable(false);
		btn_save.addActionListener(this);
		panel.add(btn_save);

		btn_close = new JButton();
		btn_close.setText("Close");
		btn_close.setBounds(395, 375, 80, 40);
		btn_close.setFocusable(false);
		btn_close.setBackground(Color.red);
		btn_close.setForeground(Color.white);
		btn_close.setFont(new Font("sans serif", Font.CENTER_BASELINE, 15));
		btn_close.addActionListener(this);
		panel.add(btn_close);

		// adding panel to the frame along with their position
		this.add(panel, BorderLayout.CENTER);
		this.add(north, BorderLayout.NORTH);
		this.setVisible(true);
		// Add action listeners to the text fields and spinner
		costPerRoom_txt.addActionListener((ActionListener) this);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculateTotalCost();
			}
		});

	}

	// adding actionlistner to the button
	public void actionPerformed(ActionEvent e) {
		calculateTotalCost();

		if (e.getSource() == adultPlus) {
			int defaultValue = Integer.parseInt(adult.getText());
			adult.setText(Integer.toString(defaultValue + 1));
		} else if (e.getSource() == adultMinus) {
			int defaultValue = Integer.parseInt(adult.getText());
			if (defaultValue > 0) {
				adult.setText(Integer.toString(defaultValue - 1));
			}
		} else if (e.getSource() == btn_save) {
			Object value = spinner.getValue();
			int strSpinner = (int) value;
			String price = costPerRoom_txt.getText();
			int roomPrice = Integer.parseInt(price);
			// get the selected date from the JDateChooser for checkin date
			Date selectedDateIn = dateChooserIn.getDate();
			// convert the date to a string using the SimpleDateFormat class
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String selectedDateStringIn = selectedDateIn != null ? dateFormat.format(selectedDateIn) : "";
			// get the selected date from the JDateChooser for checkout date
			Date selectedDateOut = dateChooserOut.getDate();
			// convert the date to a string using the SimpleDateFormat class
			String selectedDateStringOut = selectedDateOut != null ? dateFormat.format(selectedDateOut) : "";
			int defaultValue = Integer.parseInt(adult.getText());
			LocalDate checkinDate = dateChooserIn.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate checkoutDate = dateChooserOut.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if (checkoutDate.isBefore(checkinDate)) {
				JOptionPane.showMessageDialog(this, "Invalid input: Checkout date cannot be before check-in date.",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else if (selectedDateStringIn.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide Your Arrival Date", " !",
						JOptionPane.WARNING_MESSAGE);
			} else if (selectedDateStringOut.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide Your Departure Date", " !",
						JOptionPane.WARNING_MESSAGE);
			} else if (strSpinner == 0) {
				JOptionPane.showMessageDialog(this, "You Have To Book Atleast One Room", " !",
						JOptionPane.WARNING_MESSAGE);
			} else if (defaultValue == 0) {
				JOptionPane.showMessageDialog(this, "Please Provide a Number of Adult for Booking", " !",
						JOptionPane.WARNING_MESSAGE);
			} else {
				Booking booking = new Booking();
				Room room = new Room();
				Bill bill = new Bill();
				booking.setBookingStatus("Requested");
				booking.setCheckIn(selectedDateStringIn);
				booking.setRoomType(roomType_txt.getText());
				booking.setCheckOut(selectedDateStringOut);
				booking.setPaymentStatus("pending");
				booking.setNumberOfRoom(strSpinner);
				booking.setCustomerId(LoginTest.customerId);
				room.setRoomPrice(roomPrice);
				room.setRoomType(roomType_txt.getText());
				room.setAvailabilityStatus("Available");
				String totalPrice = totalCost_txt.getText();
				double totalCost = (Double.parseDouble(totalPrice));
				int totalAmount = (int) totalCost;
				bill.setTotalAmount(totalAmount);
				BookingJDBC bookingJDBC = new BookingJDBC();
				boolean result = bookingJDBC.insertBooking(room, booking, bill);
				if (result) {
					JOptionPane.showMessageDialog(this, "Successfully Requested");
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "Couldn't Accept You Booking Request", "Sorry",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource() == btn_close) {
			if(creditCard.isVisible()) {
				
				creditCard.closeInternalFrame();
				
			}
			dispose();
		} else if (creditCardBox.isSelected()) {
			if (e.getSource() == buttonCredit) {
				CreditCardPage creditCard = new CreditCardPage();
				FrontPage.lbl_img.add(creditCard);
				creditCard.setLocation(1265, 250);
			} else {
				buttonCredit.setEnabled(false);
			}
		}
	}

	private void calculateTotalCost() {
		double costPerRoom = 0;
		int numRooms = 1;
		// Parse the cost per room from the text field
		try {
			costPerRoom = Double.parseDouble(costPerRoom_txt.getText());
		} catch (NumberFormatException e) {
			// If the text field doesn't contain a valid number, just return without
			// calculating the total cost
			return;
		}
		// Get the number of rooms from the spinner
		numRooms = (Integer) spinner.getValue();
		// Calculate the total cost and set the text field value
		double totalCost = costPerRoom * numRooms;
		totalCost_txt.setText(Double.toString(totalCost));
	}

	public static void setSingle(String singleType, String singlePrice) {
		roomType_txt.setText(singleType);
		roomType_txt.setEditable(false);
		costPerRoom_txt.setText(singlePrice);
		costPerRoom_txt.setEditable(false);
	}

	public static void setDouble(String doubleType, String doublePrice) {
		roomType_txt.setText(doubleType);
		roomType_txt.setEditable(false);
		costPerRoom_txt.setText(doublePrice);
		costPerRoom_txt.setEditable(false);
	}

	public static void setFamily(String familyType, String familyPrice) {
		roomType_txt.setText(familyType);
		roomType_txt.setEditable(false);
		costPerRoom_txt.setText(familyPrice);
		costPerRoom_txt.setEditable(false);
	}

	// calling constructor in the main method
	public static void main(String[] args) {
		BookingPage booking_page = new BookingPage();
		booking_page.setVisible(true);
	}
}
