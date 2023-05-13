package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import models.GlobalBill;

public class PrintBill extends JFrame implements MouseListener {
	// declaring all components
	JPanel panel;
	JLabel header;
	JLabel header1;
	JLabel header2;
	JLabel date;
	JLabel bookingId;
	JLabel customerName;
	JLabel lblBillNo;
	JLabel paymentStatus;
	JSeparator separator;
	JSeparator separator1;
	JSeparator separator2;
	JSeparator vSeparator;
	JMenuBar menubar;
	JMenu menu;
	JLabel lblLogo;
	JLabel lblManager;

	// creating default constructor
	public PrintBill() {
		this.setSize(550, 450); // setting size of the frame
		this.setLocationRelativeTo(null);
		this.setResizable(false); // to make the frame resizable false

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);

		// adding menubar
		menubar = new JMenuBar();
		menu = new JMenu("Print");
		menu.addMouseListener(this);
		menubar.add(menu);
		menubar.setLayout(null);
		this.setJMenuBar(menubar);

		ImageIcon img = new ImageIcon("logoo1.png");

		lblLogo = new JLabel("");
		lblLogo.setIcon(img);
		lblLogo.setBounds(10, 10, 90, 90);
		lblLogo.setBackground(Color.white);
		panel.add(lblLogo);

		JLabel lb = new JLabel();
		lb.setText("http//:www.hotelluton.com");
		lb.setFont(new Font("times new roman", Font.PLAIN, 17));
		lb.setBounds(200, 10, 400, 30);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setForeground(new Color(0, 190, 204));

		JLabel lb1 = new JLabel();
		lb1.setText("Location: Regent Street, Luton, Bedfordshire");
		lb1.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		lb1.setBounds(150, 32, 410, 30);
		lb1.setForeground(new Color(0, 190, 204));

		JLabel lb2 = new JLabel();
		lb2.setText("Contact: +44 111 222 333");
		lb2.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		lb2.setBounds(200, 54, 500, 30);
		lb2.setForeground(new Color(0, 190, 204));

		// panel.add(lb3);
		panel.add(lb2);
		panel.add(lb1);
		panel.add(lb);

		header1 = new JLabel("Luton");
		header1.setBounds(20, 10, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 30));
		header1.setForeground(Color.black);
		// panel.add(header1);

		header2 = new JLabel("Hotel");
		header2.setBounds(58, 35, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 18));
		header2.setForeground(new Color(153, 101, 21));
		// panel.add(header2);

		LocalDate presentDate = LocalDate.now();

		// Creating a formatter for the desired date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// Formatting the date using the formatter
		String localDate = presentDate.format(formatter);

		date = new JLabel("Date:  " + localDate);
		date.setBounds(365, 90, 400, 35);
		date.setFont(new Font("times new roman", Font.BOLD, 18));
		date.setForeground(Color.black);

		// Add a horizontal line below the date label
		separator = new JSeparator();
		separator.setBounds(20, 130, 500, 5);
		// panel.add(separator);

		customerName = new JLabel("Name: " + GlobalBill.customerName);
		customerName.setBounds(20, 140, 500, 35);
		customerName.setFont(new Font("Verdana", Font.PLAIN, 15));
		customerName.setForeground(Color.black);

		lblBillNo = new JLabel("Invoice No: " + GlobalBill.billNo);
		lblBillNo.setBounds(366, 140, 200, 35);
		lblBillNo.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBillNo.setForeground(Color.black);

		bookingId = new JLabel("Booking Id : " + GlobalBill.bookingId);
		bookingId.setBounds(20, 180, 500, 35);
		bookingId.setFont(new Font("Verdana", Font.PLAIN, 15));
		bookingId.setForeground(Color.black);

		paymentStatus = new JLabel("Status : Paid");
		paymentStatus.setBounds(366, 180, 200, 35);
		paymentStatus.setFont(new Font("Verdana", Font.PLAIN, 15));
		paymentStatus.setForeground(Color.black);

		// creating a seperator line
		separator2 = new JSeparator();
		separator2.setBounds(20, 240, 500, 5);
		panel.add(separator2);

		vSeparator = new JSeparator();
		vSeparator.setBounds(40, 365, 100, 75);
		vSeparator.setForeground(Color.black);
		panel.add(vSeparator);

		JLabel roomType = new JLabel("Room ");
		roomType.setBounds(10, 250, 100, 35);
		roomType.setFont(new Font("Verdana", Font.BOLD, 13));
		roomType.setForeground(Color.red);
		panel.add(roomType);

		JLabel getRoomType = new JLabel(GlobalBill.RoomType);
		getRoomType.setBounds(10, 280, 110, 35);
		getRoomType.setFont(new Font("Verdana", Font.PLAIN, 14));
		getRoomType.setForeground(Color.black);
		panel.add(getRoomType);

		JLabel noRoom = new JLabel("<html>No.of<br>Room</html>");
		noRoom.setBounds(115, 250, 100, 30);
		noRoom.setFont(new Font("Verdana", Font.BOLD, 12));
		noRoom.setForeground(Color.red);

		JLabel getRoom = new JLabel(Integer.toString(GlobalBill.noOfRoom));
		getRoom.setBounds(120, 280, 100, 35);
		getRoom.setFont(new Font("Verdana", Font.PLAIN, 12));
		getRoom.setForeground(Color.black);

		JLabel lblamount = new JLabel("<html>Room<br>Price</html>");
		lblamount.setBounds(170, 250, 100, 30);
		lblamount.setFont(new Font("Verdana", Font.BOLD, 13));
		lblamount.setForeground(Color.red);
		panel.add(lblamount);

		JLabel amountPrice = new JLabel(Integer.toString(GlobalBill.roomPrice));
		amountPrice.setBounds(170, 280, 100, 35);
		amountPrice.setFont(new Font("Verdana", Font.PLAIN, 14));
		amountPrice.setForeground(Color.black);
		panel.add(amountPrice);

		JLabel lblDiscount = new JLabel("Discount(%) ");
		lblDiscount.setBounds(250, 250, 200, 35);
		lblDiscount.setFont(new Font("Verdana", Font.BOLD, 13));
		lblDiscount.setForeground(Color.red);
		panel.add(lblDiscount);

		JLabel discountPrice = new JLabel(Double.toString(GlobalBill.discountAmount));
		discountPrice.setBounds(250, 280, 80, 35);
		discountPrice.setFont(new Font("Verdana", Font.PLAIN, 14));
		discountPrice.setForeground(Color.black);
		panel.add(discountPrice);

		JLabel lblvat = new JLabel("VAT(%) ");
		lblvat.setBounds(370, 250, 100, 35);
		lblvat.setFont(new Font("Verdana", Font.BOLD, 13));
		lblvat.setForeground(Color.red);
		panel.add(lblvat);

		JLabel vatPrice = new JLabel(Double.toString(GlobalBill.vatAmount));
		vatPrice.setBounds(370, 280, 80, 35);
		vatPrice.setFont(new Font("Verdana", Font.PLAIN, 14));
		vatPrice.setForeground(Color.black);
		panel.add(vatPrice);

		JLabel scCharge = new JLabel("SC(%) ");
		scCharge.setBounds(460, 250, 100, 35);
		scCharge.setFont(new Font("Verdana", Font.BOLD, 13));
		scCharge.setForeground(Color.red);
		panel.add(scCharge);

		JLabel scPrice = new JLabel(Float.toString(GlobalBill.scAmount));
		scPrice.setBounds(460, 280, 80, 35);
		scPrice.setFont(new Font("Verdana", Font.PLAIN, 14));
		scPrice.setForeground(Color.black);
		panel.add(scPrice);

		JLabel totalAmount = new JLabel("Total Amount:  ");
		totalAmount.setBounds(300, 345, 200, 35);
		totalAmount.setFont(new Font("Verdana", Font.PLAIN, 14));
		totalAmount.setForeground(Color.red);
		panel.add(totalAmount);

		JLabel getTotalAmount = new JLabel(Double.toString(GlobalBill.totalAmount));
		getTotalAmount.setBounds(420, 345, 100, 35);
		getTotalAmount.setFont(new Font("Verdana", Font.BOLD, 15));
		getTotalAmount.setForeground(Color.black);
		panel.add(getTotalAmount);

		JLabel lblManagerSign = new JLabel("roman");
		lblManagerSign.setBounds(60, 336, 100, 35);
		Font font = new Font("Lucida Handwriting", Font.BOLD, 15);
		font = font.deriveFont(Font.ITALIC);
		lblManagerSign.setFont(font);

		lblManagerSign.setForeground(Color.black);
		panel.add(lblManagerSign);

		lblManager = new JLabel("Manager");
		lblManager.setBounds(65, 360, 100, 35);
		lblManager.setFont(new Font("times new roman", Font.BOLD, 15));
		lblManager.setForeground(Color.black);
		panel.add(lblManager);

		// Add a horizontal line below the date label
		separator1 = new JSeparator();
		separator1.setBounds(20, 330, 500, 5);

		// adding all components in panel
		panel.add(separator1);
		panel.add(getRoom);
		panel.add(noRoom);
		panel.add(paymentStatus);
		panel.add(bookingId);
		panel.add(lblBillNo);
		panel.add(customerName);
		panel.add(date);
		panel.add(getTotalAmount);
		// adding panel in frame
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);// to make frame visible

	}

	// calling constructor in main method
	public static void main(String[] args) {
		new PrintBill();
	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	@Override
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == menu) {
			// to print bill in pdf format
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setJobName("Print Data");
			job.setPrintable(new Printable() {
				public int print(Graphics pg, PageFormat pf, int pageNum) {
					pf.setOrientation(PageFormat.LANDSCAPE);
					if (pageNum > 0) {
						return Printable.NO_SUCH_PAGE;
					}

					Graphics2D g2 = (Graphics2D) pg;
					g2.translate(pf.getImageableX(), pf.getImageableY());

					double scaleX = 550.0 / panel.getWidth();
					double scaleY = 450.0 / panel.getHeight();
					double scale = Math.min(scaleX, scaleY);
					g2.scale(scale, scale);

					panel.print(g2);
					return Printable.PAGE_EXISTS;
				}
			});

			boolean ok = job.printDialog();
			if (ok) {
				try {
					job.print();
				} catch (PrinterException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
