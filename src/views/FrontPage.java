package views;

//import all the necessary libraries and classes for the GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import models.LoginTest;

public class FrontPage extends JFrame implements MouseListener {

	// declaring all the required components for JFrame
	JPanel panel_north;
	JPanel panel_center;
	JPanel panel_south;
	static JLabel lbl_img;
	JLabel lbl_logo;
	JLabel lbl_contact;
	JLabel lbl_email;
	JLabel lbl_location;
	JLabel lbl_signin;
	JLabel header1;
	JLabel header2;
	JLabel home;
	JLabel about;
	JLabel Rooms;
	JLabel contact;
	JLabel slogan;
	JLabel slogan1;
	JLabel lbl_about;
	JLabel lblServices;
	JLabel lblBarResturant;
	ImageIcon image;
	ImageIcon logo;
	JPanel panel4;
	JLabel lblProfile;
	ImageIcon imgProfile;
	JLabel lblBelowProfile;
	JSeparator homeSep;
	JSeparator contactSep;
	JSeparator roomSep;

	// creating default constructor to setup frame
	public FrontPage() {
		// setting title of the frame
		this.setTitle("Welcome " + LoginTest.customerName);
		// setting the size of frame relative to the screensize of the device
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);
		// this.setExtendedState(this.MAXIMIZED_BOTH);

		// intializine the panel_north
		panel_north = new JPanel();
		panel_north.setLayout(null);
		panel_north.setPreferredSize(new Dimension(1560, 70));
		panel_north.setBackground(Color.black);
		// intializine the lbl_contact
		lbl_contact = new JLabel();
		lbl_contact.setBounds(60, 20, 250, 30);
		lbl_contact.setText("Contact: +44 111 222 333");
		lbl_contact.setForeground(Color.white);
		lbl_contact.setFont(new Font("times new roman", Font.PLAIN, 20));
		// adding lbl_contacts to panel_north
		panel_north.add(lbl_contact);
		// intializine the lbl_location
		lbl_location = new JLabel();
		lbl_location.setBounds(550, 20, 400, 30);
		lbl_location.setText("Location: Regent Street, Luton, Bedfordshire");
		lbl_location.setForeground(Color.white);
		lbl_location.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel_north.add(lbl_location);

		// intializine the lbl_email
		lbl_email = new JLabel();
		lbl_email.setBounds(1230, 20, 400, 25);
		lbl_email.setText("Email: info@hotel.luton.org");
		lbl_email.setForeground(Color.white);
		lbl_email.setFont(new Font("times new roman", Font.PLAIN, 20));
		panel_north.add(lbl_email);

		// intializine the panel_south
		panel_south = new JPanel();
		panel_south.setLayout(null);
		panel_south.setPreferredSize(new Dimension(1560, 600));
		// panel_south.setBackground(Color.yellow);

		// intializine the panel_center
		panel_center = new JPanel();
		panel_center.setLayout(null);
		panel_center.setPreferredSize(new Dimension(1560, 600));
		panel_center.setBackground(Color.white);

		// creating ImageIcon object named image
		image = new ImageIcon("room11.png");

		lbl_img = new JLabel();
		lbl_img.setIcon(image);
		lbl_img.setBounds(0, -140, 1560, 750);
		// addimg lblimg t0 respective Panel
		panel_south.add(lbl_img);

		// creating ImageIcon object named logo
		logo = new ImageIcon("logo (1).png");
		lbl_logo = new JLabel();
		lbl_logo.setIcon(logo);
		lbl_logo.setBounds(10, -20, 200, 200);
		panel_center.add(lbl_logo);

		// creating JLabel named header
		header1 = new JLabel("Luton");
		header1.setBounds(240, 50, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 40));
		header1.setForeground(Color.black);
		// panel_center.add(header1);
		// creating JLabel named header2
		header2 = new JLabel("Hotel");
		header2.setBounds(307, 81, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 18));
		header2.setForeground(new Color(153, 101, 21));
		// panel_center.add(header2);
		// creating JLabel named home
		home = new JLabel();
		home.setText("Home");
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setBounds(400, 70, 65, 25);
		home.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		home.setForeground(Color.red);
		panel_center.add(home);

		homeSep = new JSeparator();

		homeSep.setBounds(397, 100, 65, 50);
		homeSep.setSize(65, 10);
		homeSep.setForeground(Color.red);
		panel_center.add(homeSep);

		// creating JLabel named gallary
		Rooms = new JLabel();
		Rooms.setText("Book a Room");
		Rooms.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Rooms.setBounds(680, 70, 160, 25);
		Rooms.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		Rooms.setForeground(new Color(153, 101, 21));
		// Rooms.setForeground(Color.red);
		Rooms.addMouseListener(this);
		panel_center.add(Rooms); // adding JLabel Rooms to panel_center

		// creating JLabel named conract
		contact = new JLabel();
		contact.setText("Contact");

		contact.setBounds(530, 70, 80, 25);
		contact.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		contact.setForeground(new Color(153, 101, 21));
		contact.addMouseListener(this);
		panel_center.add(contact);// adding JLabel contact to panel_center
		contact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		contactSep = new JSeparator();
		contactSep.setBounds(530, 100, 80, 20);
		contactSep.setSize(80, 20);
		contactSep.setForeground(Color.red);
		contactSep.setBackground(Color.YELLOW);
		contactSep.setPreferredSize(new Dimension(contactSep.getWidth(), 20)); // set the preferred height to 20 pixels

		// panel_center.add(contactSep);
		contactSep.setVisible(false);

		lblServices = new JLabel("Services");
		lblServices.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblServices.setBounds(880, 70, 90, 25);
		lblServices.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lblServices.setForeground(new Color(153, 101, 21));
		// Rooms.setForeground(Color.red);
		lblServices.addMouseListener(this);
		panel_center.add(lblServices); // adding JLabel Rooms to panel_center

		lblBarResturant = new JLabel("Bar & Resturant");
		lblBarResturant.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBarResturant.setBounds(1030, 70, 170, 25);
		lblBarResturant.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lblBarResturant.setForeground(new Color(153, 101, 21));
		// Rooms.setForeground(Color.red);
		lblBarResturant.addMouseListener(this);
		panel_center.add(lblBarResturant); // adding JLabel Rooms to panel_center

		imgProfile = new ImageIcon("prof.png");

		lblProfile = new JLabel();
		lblProfile.setIcon(imgProfile);
		lblProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblProfile.setBackground(Color.white);
		lblProfile.setFocusable(false);
		lblProfile.setBounds(1430, 62, 40, 39);
		lblProfile.addMouseListener(this);
		panel_center.add(lblProfile);

		lblBelowProfile = new JLabel();
		lblBelowProfile.setBounds(1428, 105, 100, 30);
		lblBelowProfile.setForeground(Color.red);
		lblBelowProfile.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 17));
		panel_center.add(lblBelowProfile);

		slogan = new JLabel();
		slogan.setText("Your Perfect ");
		slogan.setBounds(50, 220, 900, 40);
		slogan.setFont(new Font("Arial", Font.BOLD, 40));
		slogan.setForeground(Color.white);
		lbl_img.add(slogan); // adding JLabel slogan to lbl_img

		slogan1 = new JLabel();
		slogan1.setText("Accommodation  !");
		slogan1.setBounds(50, 254, 900, 50);
		slogan1.setFont(new Font("Arial", Font.BOLD, 40));
		slogan1.setForeground(Color.white);
		lbl_img.add(slogan1);

		lbl_about = new JLabel();
		lbl_about.setText(
				"<html>Luton hotel offers comfortable accommodation<br>  with a wide variety of rooms, additional services,<br> and amenities available to all our guests. We offer <br>the highest level of hospitality and great customer <br>service</html>");
		lbl_about.setBounds(50, 0, 900, 900);
		lbl_about.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 24));
		lbl_about.setForeground(Color.white);

		lbl_img.add(lbl_about);// adding JLabel lbl_about to lbl_img

		// adding respective panel to the frame declaring their position
		this.add(panel_north, BorderLayout.NORTH);

		this.add(panel_south, BorderLayout.SOUTH);
		this.add(panel_center, BorderLayout.CENTER);

		// to make frame visible true
		this.setVisible(true);

	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == Rooms) {
			new RoomPage();

		} else if (e.getSource() == contact) {
			new Contact();
			dispose();// disposing the current window
		}

		else if (e.getSource() == lblProfile) {
			ProfilePage profilePage = new ProfilePage();
			this.dispose();// disposing the current window

		} else if (e.getSource() == lblServices) {

			JInternalFrame internalFrame = new JInternalFrame("Service");
			JPanel panelInternal = new JPanel();
			panelInternal.setLayout(null);

			internalFrame.setSize(500, 450);
			internalFrame.setVisible(true);
			panel_south.add(internalFrame);
			internalFrame.setLocation(590, 200);
			JPanel panelTop = new JPanel();
			panelTop.setBackground(Color.black);
			panelTop.setBounds(0, 0, 500, 60);
			panelTop.setLayout(null);
			internalFrame.add(panelTop);
			ImageIcon img = new ImageIcon("service.jpg");
			JLabel lblImg = new JLabel();
			lblImg.setIcon(img);
			lblImg.setBounds(0, 20, 500, 500);
			panelInternal.add(lblImg);

			JButton btnClose = new JButton("Close");
			btnClose.setBounds(330, 330, 70, 35);
			btnClose.setForeground(Color.white);
			btnClose.setBackground(Color.red);
			btnClose.setFocusable(false);
			lblImg.add(btnClose);

			JButton btnService = new JButton("Request Service");
			btnService.setBounds(150, 330, 170, 35);
			btnService.setForeground(Color.white);
			btnService.setBackground(new Color(0, 204, 204));
			btnService.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			btnService.setFocusable(false);
			lblImg.add(btnService);

			JLabel header = new JLabel("Request Your Service");
			header.setBounds(130, 10, 360, 35);
			header.setFont(new Font("times new roman", Font.BOLD, 25));
			header.setForeground(Color.white);
			panelTop.add(header);

			String serviceType[] = { "House Keeping", "Laundry Services", "Fitness Services", "Spa Services" };

			JLabel lblCombo = new JLabel("Service Type : ");
			lblCombo.setBounds(70, 120, 160, 35);
			lblCombo.setFont(new Font("times new roman", Font.BOLD, 25));
			lblCombo.setForeground(Color.black);
			lblImg.add(lblCombo);

			JComboBox comboBox = new JComboBox(serviceType);
			comboBox.setBounds(230, 120, 190, 35);
			comboBox.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			comboBox.setForeground(Color.black);

			lblImg.add(comboBox);

			JLabel lblAmount = new JLabel("Service Cost : ");
			lblAmount.setBounds(70, 190, 150, 35);
			lblAmount.setFont(new Font("times new roman", Font.BOLD, 25));
			lblAmount.setForeground(Color.black);
			lblImg.add(lblAmount);

			JTextField txtAmount = new JTextField();
			txtAmount.setBounds(230, 190, 120, 35);
			txtAmount.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
			txtAmount.setForeground(Color.black);

			lblImg.add(txtAmount);

			// adding action listener to the button
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					if (ae.getSource() == btnClose) {
						internalFrame.dispose();
					}

				}

			});

			internalFrame.add(panelInternal, BorderLayout.CENTER);
			lbl_img.add(internalFrame);

		} else if (e.getSource() == lblBarResturant) {

			JInternalFrame internalFrame = new JInternalFrame();
			internalFrame.setSize(500, 400);
			internalFrame.setVisible(true);
			panel_south.add(internalFrame);
			internalFrame.setLocation(500, 100);

		}

	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == contact) {
			contactSep.setVisible(true);
			contact.setForeground(Color.red);// setting color of text to respective JLabel

		} else if (e.getSource() == Rooms) {
			Rooms.setForeground(Color.red);// setting color of text to respective JLabel

		} else if (e.getSource() == lblProfile) {
			lblBelowProfile.setText("Profile");

		} else if (e.getSource() == lblServices) {
			lblServices.setForeground(Color.red);// setting color of text to respective JLabel

		} else if (e.getSource() == lblBarResturant) {
			lblBarResturant.setForeground(Color.red);// setting color of text to respective JLabel

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == about) {

			about.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == Rooms) {
			Rooms.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == contact) {
			contactSep.setVisible(false);
			contact.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == lblProfile) {
			lblBelowProfile.setText("");

		} else if (e.getSource() == lblServices) {
			lblServices.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == lblBarResturant) {
			lblBarResturant.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == contact) {

			contact.setForeground(Color.red);
			contactSep.setVisible(true);

		} else if (e.getSource() == Rooms) {
			Rooms.setForeground(Color.red);// setting color of text to respective JLabel

		} else if (e.getSource() == lblProfile) {
			lblBelowProfile.setText("Profile");

		} else if (e.getSource() == lblServices) {
			lblServices.setForeground(Color.red);// setting color of text to respective JLabel

		} else if (e.getSource() == lblBarResturant) {
			lblBarResturant.setForeground(Color.red);// setting color of text to respective JLabel

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == about) {
			about.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == Rooms) {
			Rooms.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == contact) {
			contactSep.setVisible(false);
			contact.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == lblProfile) {
			lblBelowProfile.setText("");

		} else if (e.getSource() == lblServices) {
			lblServices.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		} else if (e.getSource() == lblBarResturant) {
			lblBarResturant.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		}

	}

	// calling constructor in main method
	public static void main(String[] args) {
		new FrontPage();
	}

}
