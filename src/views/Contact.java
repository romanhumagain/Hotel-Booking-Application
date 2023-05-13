package views;

//import all the necessary libraries and classes for the GUI

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.LoginTest;

public class Contact extends JFrame implements MouseListener, ActionListener, FocusListener {
	// declaring all the components
	JPanel panel_north;
	JPanel panel_west;
	JPanel panel_center;
	JLabel header;
	JLabel header1;
	JLabel header2;
	JLabel home;
	JLabel arrow;
	JLabel contact;
	ImageIcon main_img;
	JLabel lbl_img;
	JLabel center;
	JLabel lbl_fname;
	JTextField txt_fname;
	JLabel lbl_lname;
	JTextField txt_lname;
	JLabel lbl_email;
	JTextField txt_email;
	JLabel lbl_phone;
	JTextField txt_phone;
	JTextArea area;
	JButton btn_send;
	JLabel lbl_mail, mail1;
	JLabel lbl_location, location1;
	JLabel lbl_contact, contact1;

	// creating default constructor to set up frame
	public Contact() {
		// to get screensize
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		// to set size of frame
		this.setSize(screensize.width, screensize.height);
		// to disable the frame resizable
		this.setResizable(false);

		// initializing all the components
		panel_north = new JPanel();
		panel_north.setLayout(null);
		panel_north.setPreferredSize(new Dimension(screensize.width, 180));
		panel_north.setBackground(Color.black);

		panel_west = new JPanel();
		panel_west.setLayout(null);
		panel_west.setPreferredSize(new Dimension(700, screensize.height));
		panel_west.setBackground(Color.LIGHT_GRAY);

		lbl_fname = new JLabel();
		lbl_fname.setText("First Name");
		lbl_fname.setBounds(50, 10, 200, 30);
		lbl_fname.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_west.add(lbl_fname);

		txt_fname = new JTextField();
		txt_fname.setBounds(50, 50, 200, 40);
		txt_fname.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		panel_west.add(txt_fname);

		lbl_lname = new JLabel();
		lbl_lname.setText("Last Name");
		lbl_lname.setBounds(390, 10, 200, 30);
		lbl_lname.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_west.add(lbl_lname);

		txt_lname = new JTextField();
		txt_lname.setBounds(390, 50, 200, 40);
		txt_lname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_west.add(txt_lname);

		lbl_email = new JLabel();
		lbl_email.setText("Email");
		lbl_email.setBounds(50, 140, 200, 30);
		lbl_email.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_west.add(lbl_email);

		txt_email = new JTextField();
		txt_email.setBounds(50, 180, 200, 40);
		txt_email.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_west.add(txt_email);

		lbl_phone = new JLabel();
		lbl_phone.setText("Phone");
		lbl_phone.setBounds(390, 140, 200, 30);
		lbl_phone.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_west.add(lbl_phone);

		txt_phone = new JTextField();
		txt_phone.setBounds(390, 180, 200, 40);
		txt_phone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_west.add(txt_phone);

		area = new JTextArea("Please provide us with your feedback.");
		area.setBounds(50, 260, 544, 300);
		area.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
		panel_west.add(area);
		area.addFocusListener(this);

		btn_send = new JButton();
		btn_send.setBounds(240, 580, 125, 40);
		btn_send.setFocusable(false);
		btn_send.setBackground(new Color(0, 204, 204));
		btn_send.setForeground(Color.black);
		btn_send.setText("Send Message");
		btn_send.addActionListener(this);
		panel_west.add(btn_send);

		header = new JLabel("Every Stay Is A Memorable Experience...");
		header.setBounds(450, 20, 600, 40);
		header.setFont(new Font("Arial", Font.BOLD, 30));
		header.setForeground(Color.black);
		panel_north.add(header);

		header1 = new JLabel("Luton");
		header1.setBounds(20, 50, 200, 40);
		header1.setFont(new Font("Arial", Font.BOLD, 45));
		header1.setForeground(Color.black);
		panel_north.add(header1);

		header2 = new JLabel("Hotel");
		header2.setBounds(79, 83, 80, 40);
		header2.setFont(new Font("Arial", Font.PLAIN, 28));
		header2.setForeground(new Color(153, 101, 21));
		panel_north.add(header2);

		main_img = new ImageIcon("contact.jpg");

		lbl_img = new JLabel();
		lbl_img.setIcon(main_img);
		lbl_img.setBounds(0, 0, screensize.width, 300);
		panel_north.add(lbl_img);

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

		contact = new JLabel();
		contact.setText("Contact");
		contact.setBounds(710, 98, 200, 25);
		contact.setForeground(new Color(150, 0, 0));
		contact.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lbl_img.add(contact);

		panel_center = new JPanel();
		panel_center.setLayout(null);
		panel_center.setBackground(Color.white);

		lbl_location = new JLabel("Address:");
		lbl_location.setBounds(320, 50, 90, 30);
		lbl_location.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_center.add(lbl_location);

		location1 = new JLabel("Regent Street, Luton, Bedfordshire");
		location1.setBounds(250, 90, 390, 30);
		location1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		location1.setForeground(new Color(153, 101, 21));
		panel_center.add(location1);

		lbl_mail = new JLabel("E-Mail:");
		lbl_mail.setBounds(330, 190, 90, 30);
		lbl_mail.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_center.add(lbl_mail);

		mail1 = new JLabel("info@hotel.luton.org");
		mail1.setBounds(290, 230, 390, 30);
		mail1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		mail1.setForeground(new Color(153, 101, 21));
		panel_center.add(mail1);

		lbl_contact = new JLabel("Phones:");
		lbl_contact.setBounds(320, 335, 90, 30);
		lbl_contact.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		panel_center.add(lbl_contact);

		contact1 = new JLabel("+44 111 222 333 , +44 333 222 111");
		contact1.setBounds(230, 375, 390, 30);
		contact1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		contact1.setForeground(new Color(153, 101, 21));
		panel_center.add(contact1);

		// adding all the panel to the frame along with their position
		this.add(panel_center, BorderLayout.CENTER);
		this.add(panel_north, BorderLayout.NORTH);
		this.add(panel_west, BorderLayout.WEST);
		// to make the frame visible
		this.setVisible(true);

	}

	// calling constructor in the main method
	public static void main(String[] args) {
		new Contact();

	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
	// and exits
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == home) {
			home.setForeground(new Color(150, 0, 0));
			new FrontPage();
			dispose();

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn_send) {
			// validating the registration page
			if (txt_fname.getText().isEmpty()) {

				JOptionPane.showMessageDialog(panel_west, "Please Enter Your First Name", "!",
						JOptionPane.WARNING_MESSAGE);
			} else if (txt_lname.getText().isEmpty()) {

				JOptionPane.showMessageDialog(panel_west, "Please Enter Your Last Name", "!",
						JOptionPane.WARNING_MESSAGE);
			} else if (txt_email.getText().isEmpty()) {

				JOptionPane.showMessageDialog(panel_west, "Please Enter Your Email", "!", JOptionPane.WARNING_MESSAGE);
			} else if (txt_phone.getText().isEmpty()) {

				JOptionPane.showMessageDialog(panel_west, "Please Enter Your Phone Number", "!",
						JOptionPane.WARNING_MESSAGE);
			} else if (area.getText().equals("Please provide us with your feedback.")) {

				JOptionPane.showMessageDialog(panel_west, "Please Provide Feedback", "!",
						JOptionPane.WARNING_MESSAGE);
			} else if (area.getText().isEmpty()) {

				JOptionPane.showMessageDialog(panel_west, "Please Provide Feedback", "!",
						JOptionPane.WARNING_MESSAGE);
			}

			else {
				String message = area.getText();

				try {

					String url = "jdbc:mysql://localhost:3306/java";
					String userName = "root";
					String passWord = "";
					String query = "INSERT INTO usermessage (Message ,Customer_ID) VALUES (?,?)";
					String sql = "SELECT * FROM usermessage";
					Connection connection = DriverManager.getConnection(url, userName, passWord);

					PreparedStatement prst = connection.prepareStatement(query);
					prst.setString(1, message);
					prst.setInt(2, LoginTest.customerId);

					prst.executeUpdate();

					prst.close();

					JOptionPane.showMessageDialog(panel_west, "successfully sent your feedback");
					area.setText("");
					connection.close();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(panel_west, "Couldn't Send Your Message");
					System.out.println("ERROR" + ex.getMessage());// to get error message
				}

			}

		}
	}

	// methods for focus listener
	@Override
	public void focusGained(FocusEvent ae) {
		if (ae.getSource() == area) {

			if (area.getText().equals("Please provide us with your feedback.")) {

				area.setText("");
			}
		}

	}

	@Override
	public void focusLost(FocusEvent ae) {
		if (ae.getSource() == area) {

			if (area.getText().equals("")) {

				area.setText("Please provide us with your feedback.");
			}
		}

	}
}
