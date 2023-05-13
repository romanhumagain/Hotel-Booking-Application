package views;
//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class RoomPage extends JFrame implements MouseListener {
	// declaring all component
	JPanel panel_image;
	JPanel panel_south;
	JLabel header;
	JLabel header1;
	JLabel header2;
	JLabel lbl_img;
	ImageIcon main_img;
	ImageIcon imgSingle;
	ImageIcon imgDouble;
	ImageIcon imgTwin;
	static JLabel lbl_imgSingle;
	static JLabel lbl_imgDouble;
	static JLabel lbl_imgTiwn;
	JLabel home;
	JLabel arrow;
	JLabel gallary;
	JLabel singleRoom;
	JLabel doubleRoom;
	JLabel twinRoom;
	static JLabel singleprice;
	static JLabel doubleprice;
	static JLabel familyprice;
	static JButton single_room;
	static JButton double_room;
	static JButton family_room;
	JButton suite_room;
	JPanel panelSingle;
	JPanel panelDouble;
	JPanel panelTwin;
	JLabel headerSingle;
	JLabel serviceSingle;
	JLabel headerDouble;
	JLabel serviceDouble;
	JLabel headerTwin;
	JLabel serviceTwin;

	// creating default constructor to setup frame
	public RoomPage() {
		// getting screensize
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		// setting the size of frame
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);

		// initializing all the component
		panel_image = new JPanel();
		panel_image.setLayout(null);
		panel_image.setPreferredSize(new Dimension(screensize.width, 190));
		panel_image.setBackground(Color.black);

		panel_south = new JPanel();
		panel_south.setLayout(null);
		panel_south.setPreferredSize(new Dimension(screensize.width, 640));
		panel_south.setBackground(Color.white);

		main_img = new ImageIcon("contact.jpg");
		lbl_img = new JLabel();
		lbl_img.setIcon(main_img);
		lbl_img.setBounds(0, 0, screensize.width, 350);

		header = new JLabel("Explore Our Room Choices....");
		header.setBounds(550, 20, 500, 40);
		header.setFont(new Font("Arial", Font.BOLD, 30));
		header.setForeground(Color.black);
		panel_image.add(header);

		header1 = new JLabel("Luton");
		header1.setBounds(20, 50, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 45));
		header1.setForeground(Color.black);
		panel_image.add(header1);

		header2 = new JLabel("Hotel");
		header2.setBounds(79, 83, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 28));
		header2.setForeground(new Color(153, 101, 21));
		panel_image.add(header2);

		home = new JLabel();
		home.setText("Home");
		home.setBounds(600, 100, 59, 20);
		home.setForeground(Color.black);
		home.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		home.addMouseListener(this);
		lbl_img.add(home);

		arrow = new JLabel();
		arrow.setText("→");
		arrow.setBounds(670, 100, 70, 20);
		arrow.setForeground(Color.black);
		arrow.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbl_img.add(arrow);

		gallary = new JLabel();
		gallary.setText("Rooms & Suites");
		gallary.setBounds(710, 98, 200, 25);
		gallary.setForeground(new Color(180, 0, 0));
		gallary.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lbl_img.add(gallary);

		panelSingle = new JPanel();
		panelSingle.setBounds(20, 470, 450, 150);
		panelSingle.setBackground(new Color(215, 215, 215));
		panelSingle.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelSingle.setLayout(null);
		panel_south.add(panelSingle);

		imgSingle = new ImageIcon("singleroom.jpg");
		singleRoom = new JLabel(imgSingle);
		singleRoom.setBounds(50, 40, 400, 350);
		singleRoom.setBackground(Color.red);

		lbl_imgSingle = new JLabel();
		lbl_imgSingle.setText("Single Room");
		lbl_imgSingle.setForeground(Color.black);
		lbl_imgSingle.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lbl_imgSingle.setBounds(50, 400, 180, 30);
		// lbl_img1.setFont(new Font("Arial" , Font.LAYOUT_NO_LIMIT_CONTEXT ,18));

		singleprice = new JLabel();
		singleprice.setText("Price: Rs 3000 /-");
		singleprice.setBounds(280, 65, 420, 35);
		singleprice.setFont(new Font("times new roman", Font.ITALIC, 20));
		singleprice.setForeground(Color.red);
		panelSingle.add(singleprice);

		single_room = new JButton();
		single_room.setText("Book Now");
		single_room.setBounds(330, 400, 120, 40);
		single_room.setBackground(new Color(0, 204, 204));
		single_room.setFocusable(false);
		single_room.setForeground(Color.white);
		single_room.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));

		headerSingle = new JLabel("Available Service For Single Room");
		headerSingle.setFont(new Font("times new roman", Font.BOLD, 20));
		headerSingle.setBounds(70, 5, 420, 35);
		panelSingle.add(headerSingle);

		serviceSingle = new JLabel();
		serviceSingle.setText(
				"<html>* No Of Beds = 1 <br>* AC Available <br>* Free WI-FI Available <br>* Telephone Service Available</html>");
		serviceSingle.setBounds(10, 30, 420, 100);
		serviceSingle.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 15));
		panelSingle.add(serviceSingle);

		imgDouble = new ImageIcon("doubleroom.jpg");
		doubleRoom = new JLabel(imgDouble);
		doubleRoom.setBounds(570, 40, 400, 350);
		doubleRoom.setBackground(Color.red);

		panelDouble = new JPanel();
		panelDouble.setBounds(540, 470, 450, 150);
		panelDouble.setBackground(new Color(215, 215, 215));
		panelDouble.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelDouble.setLayout(null);
		panel_south.add(panelDouble);

		headerDouble = new JLabel("Available Service For Double Room");
		headerDouble.setFont(new Font("times new roman", Font.BOLD, 20));
		headerDouble.setBounds(70, 5, 420, 35);
		panelDouble.add(headerDouble);

		serviceDouble = new JLabel();
		serviceDouble.setText(
				"<html>* No Of Beds = 2 <br>* AC Available <br>* Free WI-FI Available <br>* Telephone Service Available</html>");
		serviceDouble.setBounds(10, 30, 420, 100);
		serviceDouble.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 15));
		panelDouble.add(serviceDouble);

		lbl_imgDouble = new JLabel();
		lbl_imgDouble.setText("Double Room");
		lbl_imgDouble.setForeground(Color.black);
		lbl_imgDouble.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lbl_imgDouble.setBounds(570, 400, 180, 30);

		doubleprice = new JLabel();
		doubleprice.setText("Price: Rs 4000 /-");
		doubleprice.setBounds(280, 65, 420, 35);
		doubleprice.setFont(new Font("times new roman", Font.ITALIC, 20));
		doubleprice.setForeground(Color.red);

		double_room = new JButton();
		double_room.setText("Book Now");

		double_room.setBounds(850, 400, 120, 40);
		double_room.setBackground(new Color(0, 204, 204));
		double_room.setFocusable(false);
		double_room.setForeground(Color.white);
		double_room.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));

		imgTwin = new ImageIcon("familyroom.jpg");

		twinRoom = new JLabel(imgTwin);
		twinRoom.setBounds(1070, 40, 400, 350);
		twinRoom.setBackground(Color.red);

		panelTwin = new JPanel();
		panelTwin.setBounds(1050, 470, 450, 150);
		panelTwin.setBackground(new Color(215, 215, 215));
		panelTwin.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		panelTwin.setLayout(null);
		panel_south.add(panelTwin);

		headerTwin = new JLabel("Available Service For Twin Room");
		headerTwin.setFont(new Font("times new roman", Font.BOLD, 20));
		headerTwin.setBounds(70, 5, 420, 35);
		panelTwin.add(headerTwin);

		serviceTwin = new JLabel();
		serviceTwin.setText(
				"<html>* No Of Beds = 3 <br>* AC Available <br>* Free WI-FI Available <br>* Telephone Service Available</html>");
		serviceTwin.setBounds(10, 30, 420, 100);
		serviceTwin.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 15));
		panelTwin.add(serviceTwin);

		lbl_imgTiwn = new JLabel();
		lbl_imgTiwn.setText("Twin Room");
		lbl_imgTiwn.setForeground(Color.black);
		lbl_imgTiwn.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lbl_imgTiwn.setBounds(1070, 400, 180, 30);

		familyprice = new JLabel();
		familyprice.setText("Price: Rs 5000 /-");
		familyprice.setBounds(280, 65, 420, 35);
		familyprice.setFont(new Font("times new roman", Font.ITALIC, 20));
		familyprice.setForeground(Color.red);

		family_room = new JButton();
		family_room.setText("Book Now");

		family_room.setBounds(1350, 400, 120, 40);
		family_room.setBackground(new Color(0, 204, 204));
		family_room.setFocusable(false);
		family_room.setForeground(Color.white);
		family_room.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));

		panel_image.add(lbl_img);

		// adding the component in the panel_south
		panel_south.add(singleRoom);
		panel_south.add(doubleRoom);
		panel_south.add(twinRoom);

		panel_south.add(lbl_imgSingle);
		panel_south.add(lbl_imgDouble);
		panel_south.add(lbl_imgTiwn);

		panel_south.add(single_room);
		panel_south.add(double_room);
		panel_south.add(family_room);

		panelSingle.add(singleprice);
		panelDouble.add(doubleprice);
		panelTwin.add(familyprice);

		// -----
		// addineg panel to the frame along with their position
		this.add(panel_image, BorderLayout.NORTH);
		this.add(panel_south, BorderLayout.SOUTH);
		this.setVisible(true);

		// adding action listener to the button
		single_room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookingPage booking_page = new BookingPage();
				FrontPage.lbl_img.add(booking_page);
				booking_page.setLocation(525, 140);

				String singleType = lbl_imgSingle.getText();
				int singleRoomPrice = 3000;
				String singlePrice = Integer.toString(singleRoomPrice);

				BookingPage.setSingle(singleType, singlePrice);
				FrontPage.lbl_img.add(booking_page);

			}
		});
		double_room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookingPage booking_page = new BookingPage();

				FrontPage.lbl_img.add(booking_page);
				booking_page.setLocation(525, 140);

				String doubleType = lbl_imgDouble.getText();

				int doubleRoomPrice = 4000;
				String doublePrice = Integer.toString(doubleRoomPrice);
				BookingPage.setDouble(doubleType, doublePrice);
			}
		});
		family_room.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookingPage booking_page = new BookingPage();

				FrontPage.lbl_img.add(booking_page);
				booking_page.setLocation(525, 140);

				String familyType = lbl_imgTiwn.getText();

				int familyRoomPrice = 5000;
				String familyPrice = Integer.toString(familyRoomPrice);
				BookingPage.setFamily(familyType, familyPrice);
			}
		});

	}
	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == home) {
			home.setForeground(new Color(150, 0, 0));
			new FrontPage();
			this.dispose();

		}
	}
    //calling constructor in the main method
	public static void main(String[] args) {
		new RoomPage();
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == home) {
			home.setForeground(new Color(150, 0, 0));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == home) {
			home.setForeground(Color.black);
		}

	}
}
