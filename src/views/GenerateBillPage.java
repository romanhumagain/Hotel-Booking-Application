package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import Controllers.BillingTableJDBC;
import Controllers.BookingJDBC;
import Controllers.ManagerBillTableJDBC;
import models.Bill;
import models.Booking;
import models.GlobalBill;

public class GenerateBillPage extends JInternalFrame implements ActionListener {
	// declaring all components
	JPanel panelCenter;
	JLabel header;
	JLabel lblBookingId;
	JLabel lblDiscount;
	JTextField txtBookingId;
	JTextField txtDiscount;
	JLabel lblAmount;
	JTextField txtAmount;
	JButton generateBill;
	JButton btnClose;
	JLabel lblPresentDate;
	JLabel lblVat;
	JTextField txtVat;
	JLabel lblsc;
	JTextField txtsc;
	Timer refressTimer;

	// creating default constructor
	public GenerateBillPage() {
		this.setSize(550, 450); // setting size of frame
		panelCenter = new JPanel();
		panelCenter.setLayout(null);

		// initializing all components
		header = new JLabel();
		header.setText("Generate Bill");
		header.setFont(new Font("times new roman", Font.BOLD, 30));
		header.setBounds(180, 20, 400, 40);
		panelCenter.add(header);

		LocalDate presentDate = LocalDate.now();

		// Creating a formatter for the desired date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Formatting the date using the formatter
		String date = presentDate.format(formatter);

		lblPresentDate = new JLabel(date);
		lblPresentDate.setBounds(440, 25, 100, 35);
		lblPresentDate.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 16));
		panelCenter.add(lblPresentDate);

		lblBookingId = new JLabel("Booking ID :");
		lblBookingId.setBounds(120, 100, 200, 40);
		lblBookingId.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(lblBookingId);

		txtBookingId = new JTextField(GlobalBill.bookingId);
		txtBookingId.setBounds(270, 103, 130, 40);
		txtBookingId.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(txtBookingId);

		lblDiscount = new JLabel("Discount % :");
		lblDiscount.setBounds(10, 260, 200, 35);
		lblDiscount.setFont(new Font("times new roman", Font.PLAIN, 18));
		panelCenter.add(lblDiscount);

		txtDiscount = new JTextField("0");
		txtDiscount.setBounds(115, 260, 60, 35);
		txtDiscount.setFont(new Font("times new roman", Font.PLAIN, 20));
		panelCenter.add(txtDiscount);

		lblVat = new JLabel("VAT : ");
		lblVat.setBounds(195, 260, 100, 35);
		lblVat.setFont(new Font("times new roman", Font.PLAIN, 18));
		panelCenter.add(lblVat);

		txtVat = new JTextField("13");
		txtVat.setBounds(250, 260, 50, 35);
		txtVat.setFont(new Font("times new roman", Font.PLAIN, 18));
		txtVat.setEditable(false);
		panelCenter.add(txtVat);

		lblsc = new JLabel("Service Charge(% ) : ");
		lblsc.setBounds(325, 260, 200, 35);
		lblsc.setFont(new Font("times new roman", Font.PLAIN, 18));
		panelCenter.add(lblsc);

		txtsc = new JTextField("0");
		txtsc.setBounds(480, 260, 50, 35);
		txtsc.setFont(new Font("times new roman", Font.PLAIN, 18));
		panelCenter.add(txtsc);

		lblAmount = new JLabel();
		lblAmount.setText("Total Amount");
		lblAmount.setBounds(120, 180, 200, 40);
		lblAmount.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(lblAmount);

		txtAmount = new JTextField(GlobalBill.amount);
		txtAmount.setBounds(270, 180, 130, 40);
		txtAmount.setFont(new Font("times new roman", Font.PLAIN, 25));
		panelCenter.add(txtAmount);

		generateBill = new JButton("Generate Bill");
		generateBill.setBounds(155, 350, 120, 35);
		generateBill.setBackground(new Color(0, 204, 204));
		generateBill.setFocusable(false);
		generateBill.addActionListener(this);
		panelCenter.add(generateBill);

		btnClose = new JButton("Close");
		btnClose.setBounds(315, 350, 80, 35);
		btnClose.setBackground(Color.red);
		btnClose.setForeground(Color.white);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		panelCenter.add(btnClose);

		// adding panel to the frame at the center position
		this.add(panelCenter, BorderLayout.CENTER);
		this.setVisible(true);// to make the frame visible

		// initializing the refress timer
		refressTimer = new Timer(100, e -> {
			txtAmount.setText(GlobalBill.amount);
			txtBookingId.setText(GlobalBill.bookingId);
		});
		refressTimer.start(); // to start refress timer

	}

	@Override
	public void dispose() {
		refressTimer.stop(); // to stop refress timer
		super.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// to validate
		if (ae.getSource() == generateBill) {
			if (txtBookingId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide Booking Id", "!", JOptionPane.WARNING_MESSAGE);
			} else if (txtAmount.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please Provide Total Amount", "!", JOptionPane.WARNING_MESSAGE);
			} else if (txtDiscount.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "You Cant't Left Your Discount Field Empty", "!",
						JOptionPane.WARNING_MESSAGE);
			}

			else {
				Booking booking = new Booking();
				booking.setBookingId(Integer.parseInt(GlobalBill.bookingId));
				ManagerBillTableJDBC billPrint = new ManagerBillTableJDBC();
				billPrint.printBill(booking);

				if (GlobalBill.roomId == null) {
					JOptionPane.showMessageDialog(this, "Please Assign Room First to Generate Bill", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				else {
					float discount = 0;
					float serviceCharge = 0;
					float vat = 0;
					float totalAmount = Float.parseFloat(txtAmount.getText());
					discount = Float.parseFloat(txtDiscount.getText());
					vat = Float.parseFloat(txtVat.getText());
					serviceCharge = Float.parseFloat(txtsc.getText());

					float discountAmount = ((discount / 100) * totalAmount);
					float vatAmount = ((vat / 100) * totalAmount);
					float scAmount = ((serviceCharge / 100) * totalAmount);
					float billTotalAmount = ((totalAmount - discountAmount) + vatAmount + scAmount);

					GlobalBill.totalAmount = billTotalAmount;
					GlobalBill.vatAmount = vatAmount;
					GlobalBill.discountAmount = discountAmount;
					GlobalBill.scAmount = scAmount;

					Bill bill = new Bill();

					LocalDate Date = LocalDate.now();

					// Converting present date to string
					String dateString = Date.toString();
					bill.setTotalAmount((int) billTotalAmount);
					bill.setPaymentDate(dateString);
					bill.setBookingId(Integer.parseInt(txtBookingId.getText()));

					BillingTableJDBC generateBill = new BillingTableJDBC();
					boolean result = generateBill.paymentDate(bill);
					if (result == true) {
						String paymentStatus = "Paid";
						int bookingId = Integer.parseInt(txtBookingId.getText());

						booking.setBookingId(bookingId);
						booking.setPaymentStatus(paymentStatus);

						BookingJDBC bookingJDBC = new BookingJDBC();
						boolean result1 = bookingJDBC.paymentStatus(booking);
						if (result1 == true) {
							JOptionPane.showMessageDialog(this,
									"successfully Generated Bill for Booking_Id " + txtBookingId.getText());
							GlobalBill.amount = "";
							// GlobalBill.bookingId ="";
							txtBookingId.setText("");
							txtDiscount.setText("");
							txtAmount.setText("");

							PrintBill print = new PrintBill();
							ManagerPage.innerPanelEast.removeAll();
							ManagerPage.innerPanelEast.add(print);
						}

					} else {
						JOptionPane.showMessageDialog(this, "Couldn't Generate Bill", "!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		} else if (ae.getSource() == btnClose) {
			this.dispose();
			GlobalBill.amount = "";
			GlobalBill.bookingId = "";
		}
	}

	// calling constructor in main method
	public static void main(String[] args) {
		new GenerateBillPage();
	}
}
