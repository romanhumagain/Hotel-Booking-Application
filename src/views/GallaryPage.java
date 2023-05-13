package views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GallaryPage extends JFrame implements MouseListener {
	//declaring all the component
	JPanel panel_north;
	JLabel headerLabel;
	JLabel header1;
	JLabel header2;
	ImageIcon main_img;
	JPanel panel_south;
	JLabel lbl_img;
	JLabel home;
	JLabel arrow;
	JLabel gallary;
    //creating default constructor
	public GallaryPage() {
		//setting the title of the page
		this.setTitle("Image Gallery");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getting screensize
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//setting the size of the frame
		this.setSize(screenSize.width, 2400);

		//initializing all component
		panel_north = new JPanel();
		panel_north.setLayout(null);
		panel_north.setPreferredSize(new Dimension(screenSize.width, 180));
		panel_north.setBackground(Color.white);

		// create header panel

		headerLabel = new JLabel("Image Gallery");
		headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		panel_north.add(headerLabel);
		this.add(panel_north, BorderLayout.NORTH);

		JLabel header = new JLabel("Hotel Luton Gallary");
		header.setBounds(540, 50, 600, 40);
		header.setFont(new Font("times new roman", Font.BOLD, 40));
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
		lbl_img.setBounds(0, 0, screenSize.width, 300);
		panel_north.add(lbl_img);

		home = new JLabel();
		home.setText("Home");
		home.setBounds(600, 120, 59, 20);
		home.setForeground(Color.black);
		home.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		home.addMouseListener(this);
		lbl_img.add(home);

		arrow = new JLabel();
		arrow.setText("→");
		arrow.setBounds(670, 120, 70, 20);
		arrow.setForeground(Color.black);
		arrow.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbl_img.add(arrow);

		gallary = new JLabel();
		gallary.setText("Gallary");
		gallary.setBounds(710, 118, 200, 25);
		gallary.setForeground(new Color(150, 0, 0));
		gallary.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lbl_img.add(gallary);

		panel_south = new JPanel();
		panel_south.setLayout(null);
		panel_south.setBackground(Color.black);
		panel_south.setBounds(0, 1550, screenSize.width, 200);

		// create center panel with 5 image JLabels
		JPanel panelCenter = new JPanel(null);
		panelCenter.setPreferredSize(new Dimension(900, 1800)); // set panel size for scrolling
		JLabel label1 = new JLabel(new ImageIcon("singleroom.jpg"));
		label1.setBounds(100, 50, 400, 400);
		panelCenter.add(label1);
		panelCenter.add(panel_south);
		JLabel detailsLabel1 = new JLabel("Single Room");
		detailsLabel1.setBounds(100, 450, 400, 50);
		detailsLabel1.setHorizontalAlignment(JLabel.CENTER);
		detailsLabel1.setFont(new Font("times new roman", Font.BOLD, 25));
		panelCenter.add(detailsLabel1);

		JLabel label2 = new JLabel(new ImageIcon("doubleroom.jpg"));
		label2.setBounds(550, 50, 400, 400);
		panelCenter.add(label2);
		JLabel detailsLabel2 = new JLabel("Double Room");
		detailsLabel2.setBounds(550, 450, 400, 50);
		detailsLabel2.setHorizontalAlignment(JLabel.CENTER);
		detailsLabel2.setFont(new Font("times new roman", Font.BOLD, 25));
		panelCenter.add(detailsLabel2);

		JLabel label3 = new JLabel(new ImageIcon("familyroom.jpg"));
		label3.setBounds(1000, 50, 400, 400);
		panelCenter.add(label3);
		JLabel detailsLabel3 = new JLabel("Twin Room");
		detailsLabel3.setBounds(1000, 450, 400, 50);
		detailsLabel3.setHorizontalAlignment(JLabel.CENTER);
		detailsLabel3.setFont(new Font("times new roman", Font.BOLD, 25));
		panelCenter.add(detailsLabel3);

		JLabel label4 = new JLabel(new ImageIcon("C:\\Users\\Victus\\Pictures\\indorswm.jpg"));
		label4.setBounds(100, 550, 400, 400);
		panelCenter.add(label4);
		JLabel detailsLabel4 = new JLabel("Indoor Swiming Pool");
		detailsLabel4.setBounds(100, 950, 400, 50);
		detailsLabel4.setFont(new Font("times new roman", Font.BOLD, 25));
		detailsLabel4.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(detailsLabel4);

		JLabel label5 = new JLabel(new ImageIcon("C:\\Users\\Victus\\Documents\\outdoorswm.jpg"));
		label5.setBounds(550, 550, 400, 400);
		panelCenter.add(label5);
		JLabel detailsLabel5 = new JLabel("Outdoor Swiming Pool");
		detailsLabel5.setFont(new Font("times new roman", Font.BOLD, 25));
		detailsLabel5.setBounds(550, 950, 400, 50);
		detailsLabel5.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(detailsLabel5);

		JLabel label6 = new JLabel(new ImageIcon("C:\\Users\\Victus\\Pictures\\hotell.jpg"));
		label6.setBounds(1000, 550, 400, 400);
		panelCenter.add(label6);
		JLabel detailsLabel6 = new JLabel("Luton Hotel");
		detailsLabel6.setFont(new Font("times new roman", Font.BOLD, 25));
		detailsLabel6.setBounds(1000, 950, 400, 50);
		detailsLabel6.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(detailsLabel6);

		JLabel label7 = new JLabel(new ImageIcon("C:\\Users\\Victus\\Pictures\\view.jpg"));
		label7.setBounds(100, 1050, 400, 400);
		panelCenter.add(label7);
		JLabel detailsLabel7 = new JLabel("Hotel View");
		detailsLabel7.setFont(new Font("times new roman", Font.BOLD, 25));
		detailsLabel7.setBounds(100, 1450, 400, 50);
		detailsLabel7.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(detailsLabel7);

		JLabel label8 = new JLabel(new ImageIcon("C:\\Users\\Victus\\Pictures\\bar.jpg"));
		label8.setBounds(550, 1050, 400, 400);
		panelCenter.add(label8);
		JLabel detailsLabel8 = new JLabel("Hotel Bar");
		detailsLabel8.setFont(new Font("times new roman", Font.BOLD, 25));
		detailsLabel8.setBounds(550, 1450, 400, 50);
		detailsLabel8.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(detailsLabel8);

		JLabel label9 = new JLabel(new ImageIcon("C:\\Users\\Victus\\Pictures\\resturant.jpg"));
		label9.setBounds(1000, 1050, 400, 400);
		panelCenter.add(label9);
		JLabel detailsLabel9 = new JLabel("Resturant");
		detailsLabel9.setFont(new Font("times new roman", Font.BOLD, 25));
		detailsLabel9.setBounds(1000, 1450, 400, 50);
		detailsLabel9.setHorizontalAlignment(JLabel.CENTER);
		panelCenter.add(detailsLabel9);

		JLabel lb3 = new JLabel();
		lb3.setText("Contact Us");
		lb3.setFont(new Font("Arial", Font.BOLD, 18));
		lb3.setBounds(688, 20, 150, 30);
		lb3.setFont(new Font("times new roman", Font.BOLD, 30));
		lb3.setForeground(Color.white);

		JLabel lb = new JLabel();
		lb.setText("http//:www.hotelluton.com");
		lb.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		lb.setBounds(650, 70, 400, 30);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setForeground(Color.white);

		JLabel lb1 = new JLabel();
		lb1.setText("Location: Regent Street, Luton, Bedfordshire");
		lb1.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		lb1.setBounds(580, 110, 410, 30);
		lb1.setForeground(Color.white);

		JLabel lb2 = new JLabel();
		lb2.setText("Contact: +44 111 222 333");
		lb2.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 20));
		lb2.setBounds(650, 150, 500, 30);
		lb2.setForeground(Color.white);

		//adding lable to the panel_south
		panel_south.add(lb3);
		panel_south.add(lb2);
		panel_south.add(lb1);
		panel_south.add(lb);

		// add center panel with JScrollPane to frame
		JScrollPane scrollPane = new JScrollPane(panelCenter);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane, BorderLayout.CENTER);

		this.setVisible(true);
	}

	//calling constructor in main method
	public static void main(String[] args) {
		new GallaryPage();
	}

	// These are event handling methods for mouse clicks, presses, releases, enters,
		// and exits
	@Override
	public void mouseClicked(MouseEvent ae) {
		if (ae.getSource() == home) {
			this.dispose();
			new MainPage();

		}

	}

	@Override
	public void mousePressed(MouseEvent ae) {
		if (ae.getSource() == home) {
			home.setForeground(new Color(150, 0, 0));
			;

		}

	}

	@Override
	public void mouseReleased(MouseEvent ae) {
		if (ae.getSource() == home) {
			home.setForeground(Color.black);
			;

		}

	}

	@Override
	public void mouseEntered(MouseEvent ae) {
		if (ae.getSource() == home) {
			home.setForeground(new Color(150, 0, 0));
			;

		}

	}

	@Override
	public void mouseExited(MouseEvent ae) {

		if (ae.getSource() == home) {
			home.setForeground(Color.black);
			;

		}

	}
}
