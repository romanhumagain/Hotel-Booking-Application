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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage extends
JFrame implements ActionListener, MouseListener {

	// declaring all the required components for JFrame
	JPanel panel_north;
	JPanel panel_center;
	JPanel panel_south;
	JPanel innerPanel;
	JPanel loginPanel;
	static JLabel lbl_img;
	JLabel lbl_logo;
	JLabel lbl_contact;
	JLabel lbl_email;
	JLabel lbl_location;
	JLabel header1;
	JLabel header2;
	JLabel slogan;
	JLabel slogan1;
	ImageIcon image;
	ImageIcon logo;
	JLabel lblSignIn;
	JButton btnSignIn;
	JLabel lblSignOut;
	JButton btnSignUp;
	JLabel about;
	JLabel gallary;
	JButton btnManager;

	public static JPanel innerSouthPanel;

	// creating default constructor to setup frame
	public MainPage() {

		// setting the size of frame relative to the screensize of the device
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screensize.width, screensize.height);
		this.setResizable(false);
		// this.setExtendedState(this.MAXIMIZED_BOTH);

		// intializine the panel_north
		panel_north = new JPanel();
		panel_north.setLayout(null);
		panel_north.setPreferredSize(new Dimension(1560, 90));
		panel_north.setBackground(Color.black);
		// intializine the lbl_contact
		lbl_contact = new JLabel();
		lbl_contact.setBounds(60, 20, 250, 30);
		lbl_contact.setText("Contact: +44 111 222 333");
		lbl_contact.setForeground(Color.white);
		lbl_contact.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		// adding lbl_contacts to panel_north
		panel_north.add(lbl_contact);

		// intializine the lbl_location
		lbl_location = new JLabel();
		lbl_location.setBounds(550, 20, 400, 30);
		lbl_location.setText("Location: Regent Street, Luton, Bedfordshire");
		lbl_location.setForeground(Color.white);
		lbl_location.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		panel_north.add(lbl_location);

		// intializine the lbl_email
		lbl_email = new JLabel();
		lbl_email.setBounds(1230, 25, 400, 25);
		lbl_email.setText("Email: info@hotel.luton.org");
		lbl_email.setForeground(Color.white);
		lbl_email.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		panel_north.add(lbl_email);

		// intializine the panel_south
		panel_south = new JPanel();
		panel_south.setLayout(null);
		panel_south.setPreferredSize(new Dimension(1560, 600));
		panel_south.setBackground(Color.yellow);

		// intializine the panel_center
		panel_center = new JPanel();
		panel_center.setLayout(null);
		panel_center.setPreferredSize(new Dimension(1560, 600));
		panel_center.setBackground(Color.white);

		// creating ImageIcon object named image
		image = new ImageIcon("resort.jpg");

		lbl_img = new JLabel();
		lbl_img.setIcon(image);
		lbl_img.setBounds(0, -60, 1550, 800);
		// addimg lblimg t0 respective Panel
		panel_south.add(lbl_img);

		// creating ImageIcon object named logo
		logo = new ImageIcon("logo (1).png");
		lbl_logo = new JLabel();
		lbl_logo.setIcon(logo);
		lbl_logo.setBounds(10, -30, 200, 200);
		panel_center.add(lbl_logo);

		slogan = new JLabel();
		slogan.setText("Your Perfect ");
		slogan.setBounds(40, 250, 900, 35);
		slogan.setFont(new Font("Arial", Font.BOLD, 40));
		slogan.setForeground(Color.white);
		// lbl_img.add(slogan); // adding JLabel slogan to lbl_img

		JLabel label = new JLabel();
		label.setBounds(40, -130, 900, 500);
		label.setFont(new Font("Sans Serif", Font.PLAIN, 25));
		label.setForeground(Color.black);
		lbl_img.add(label);

		slogan1 = new JLabel();
		slogan1.setText("Accommodation ! ");
		slogan1.setBounds(40, 290, 900, 50);
		slogan1.setFont(new Font("Arial", Font.BOLD, 35));
		slogan1.setForeground(Color.white);
		// lbl_img.add(slogan1);

		innerPanel = new JPanel();
		innerPanel.setBounds(1050, 0, 750, 600);
		innerPanel.setLayout(null);
		innerPanel.setBackground(Color.LIGHT_GRAY);
		// panel_south.add(innerPanel);

		innerSouthPanel = new JPanel();
		innerSouthPanel.setLayout(null);
		innerSouthPanel.setBounds(600, 200, 360, 360);
		innerSouthPanel.setBackground(new Color(0, 0, 0, 160));
		lbl_img.add(innerSouthPanel);

		lblSignIn = new JLabel();
		lblSignIn.setText("Already Have Account ?");
		lblSignIn.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblSignIn.setBounds(60, 40, 250, 30);
		lblSignIn.setForeground(Color.white);
		innerSouthPanel.add(lblSignIn);

		btnSignIn = new JButton("Login");
		btnSignIn.setBounds(120, 90, 130, 35);
		btnSignIn.setBackground(Color.black);
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSignIn.setForeground(Color.white);
		btnSignIn.setFocusable(false);
		btnSignIn.addActionListener(this);
		innerSouthPanel.add(btnSignIn);

		lblSignOut = new JLabel();
		lblSignOut.setText("Create New Account ?");
		lblSignOut.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblSignOut.setForeground(Color.white);
		lblSignOut.setBounds(80, 180, 250, 30);
		innerSouthPanel.add(lblSignOut);

		btnSignUp = new JButton("Register");
		btnSignUp.setBounds(120, 230, 130, 35);
		btnSignUp.setBackground(Color.black);
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnSignUp.setForeground(Color.white);
		btnSignUp.setFocusable(false);
		btnSignUp.addActionListener(this);
		innerSouthPanel.add(btnSignUp);

		JLabel mainHeader = new JLabel(
				"\"Stay Connected on the Go: Our user-friendly platform lets you  book your hotel anytime, anywhere.\"");
		mainHeader.setBounds(400, 52, 1400, 35);
		mainHeader.setFont(new Font("Arial", Font.PLAIN, 25));
		// mainHeader.setForeground(new Color(153, 101, 21));
		mainHeader.setForeground(Color.black);
		// panel_center.add(mainHeader);

		// creating JLabel named header
		header1 = new JLabel("Luton");
		header1.setBounds(240, 48, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 40));
		header1.setForeground(Color.black);
		panel_center.add(header1);

		// creating JLabel named header2
		header2 = new JLabel("Hotel");
		header2.setBounds(307, 79, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 18));
		header2.setForeground(new Color(153, 101, 21));
		panel_center.add(header2);

		about = new JLabel();
		about.setText("About");
		about.setBounds(700, 70, 65, 25);
		about.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		about.setForeground(new Color(153, 101, 21));
		about.addMouseListener(this);
		panel_center.add(about);

		gallary = new JLabel();
		gallary.setText("Gallary");
		gallary.setBounds(850, 70, 75, 25);
		gallary.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		gallary.setForeground(new Color(153, 101, 21));
		gallary.addMouseListener(this);
		panel_center.add(gallary);
		
		// adding respective panel to the frame and declaring their position
		this.add(panel_north, BorderLayout.NORTH);
		this.add(panel_south, BorderLayout.SOUTH);
		this.add(panel_center, BorderLayout.CENTER);

		// to make frame visible true
		this.setVisible(true);

	}

	// calling constructor in main method
	public static void main(String[] args) {
		new MainPage();

	}

	// This method handles the action event for "btnSignIn" button
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnSignIn) {
			innerSouthPanel.setVisible(false);
			LoginPage login = new LoginPage();
			lbl_img.add(login);
			login.setLocation(400, 130);

		}
		// This method handles the action event for "btnSignUp" button

		else if (ae.getSource() == btnSignUp) {
			innerSouthPanel.setVisible(false);
			RegisterPage register = new RegisterPage();
			lbl_img.add(register);
			register.setLocation(350, 55);
		}

		else {
			innerSouthPanel.setVisible(true);

		}
	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits on the "about" and "gallery" JLabel components
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == about) {
			new AboutHotelPage();
			this.dispose(); // disposing the current window
		}
		if (e.getSource() == gallary) {
			new GallaryPage();
			this.dispose(); // disposing the current window
		}

	}

	@Override
	public void mousePressed(MouseEvent ae) {
		if (ae.getSource() == about) {
			about.setForeground(Color.red); // setting color of text to respective JLabel

		}
		if (ae.getSource() == gallary) {
			gallary.setForeground(Color.red); // setting color of text to respective JLabel

		}
	}

	@Override
	public void mouseReleased(MouseEvent ae) {
		if (ae.getSource() == about) {
			about.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		}
		if (ae.getSource() == gallary) {
			gallary.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		}

	}

	@Override
	public void mouseEntered(MouseEvent ae) {
		if (ae.getSource() == about) {
			about.setForeground(Color.red); // setting color of text to respective JLabel

		}
		if (ae.getSource() == gallary) {
			gallary.setForeground(Color.red); // setting color of text to respective JLabel

		}

	}

	@Override
	public void mouseExited(MouseEvent ae) {
		if (ae.getSource() == about) {
			about.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		}
		if (ae.getSource() == gallary) {
			gallary.setForeground(new Color(153, 101, 21));// setting color of text to respective JLabel

		}

	}

	// creating method to dispose window
	public void disposeMainPage() {
		dispose();
	}
}
