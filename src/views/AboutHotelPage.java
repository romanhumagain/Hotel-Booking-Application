package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class AboutHotelPage extends JFrame implements MouseListener {
    //declaring all the component
	JPanel panel_north;
	JPanel panel_west;
	JPanel panel_center;
	JLabel header;
	JLabel header1;
	JLabel header2;
	JLabel home;
	JLabel arrow;
	JLabel about;
	ImageIcon main_img;
	JLabel lbl_img;
	JLabel center;
	JLabel text;
	JLabel lbl_frontdesk;
	ImageIcon frontdesk_img;
	JPanel panel_south;
	// creating default constructor to setup frame
	public AboutHotelPage() {
		//getting screensize
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		//setting the size of frame
		this.setSize(screensize.width , screensize.height);
		//to make frame resizable false
		this.setResizable(false);
		
		//initializing all the component
		panel_north = new JPanel();
		panel_north.setLayout(null);
		panel_north.setPreferredSize(new Dimension(screensize.width , 210));
		panel_north.setBackground(Color.black);
		
		panel_west = new JPanel();
		panel_west.setLayout(null);
		panel_west.setPreferredSize(new Dimension(650 , screensize.height));
		panel_west.setBackground(Color.white);
		
		panel_south = new JPanel();
		panel_south.setLayout(null);
		panel_south.setBackground(Color.DARK_GRAY);
		panel_south.setPreferredSize(new Dimension(screensize.width , 140));
	
		JLabel lb3 = new JLabel();
		lb3.setText("Contact Us");
		lb3.setFont(new Font("times new roman", Font.BOLD, 18));
		lb3.setBounds(688, 10, 150, 30);
		lb3.setFont(new Font("times new roman", Font.BOLD, 25));
		lb3.setForeground(Color.white);

		JLabel lb = new JLabel();
		lb.setText("http//:www.hotelluton.com");
		lb.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		lb.setBounds(650, 40, 400, 30);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		lb.setForeground(Color.white);

		JLabel lb1 = new JLabel();
		lb1.setText("Location: Regent Street, Luton, Bedfordshire");
		lb1.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		lb1.setBounds(590, 70, 410, 30);
		lb1.setForeground(Color.white);

		JLabel lb2 = new JLabel();
		lb2.setText("Contact: +44 111 222 333");
		lb2.setFont(new Font("times new roman", Font.ROMAN_BASELINE, 17));
		lb2.setBounds(650, 100, 500, 30);
		lb2.setForeground(Color.white);

		//adding labels to the panel_south
		panel_south.add(lb3);
		panel_south.add(lb2);
		panel_south.add(lb1);
		panel_south.add(lb);
		
		//initializing imageicon
		frontdesk_img = new ImageIcon("front_desk.jpg"); 
		lbl_frontdesk = new JLabel();
		lbl_frontdesk.setIcon(frontdesk_img);
		lbl_frontdesk.setBounds(30 ,0, 650 ,450);
		panel_west.add(lbl_frontdesk);
		
		
		header = new JLabel("Every Stay Is A Memorable Experience...");
		header.setBounds(450 ,20 ,600 , 40);
		header.setFont(new Font("Arial" , Font.BOLD , 30));
		header.setForeground(Color.black);
		panel_north.add(header);
		
		header1 = new JLabel("Luton");
		header1.setBounds(30 ,50 ,200 , 40);
		header1.setFont(new Font("Arial" , Font.BOLD , 45));
		header1.setForeground(Color.black);
		panel_north.add(header1);
		
		
		header2 = new JLabel("Hotel");
		header2.setBounds(89,83 ,80 , 40);
		header2.setFont(new Font("Arial" , Font.PLAIN, 28));
		header2.setForeground(new Color(153 , 101 ,21));
		panel_north.add(header2);
		
       main_img = new ImageIcon("contact.jpg");
		
		lbl_img = new JLabel();
		lbl_img.setIcon(main_img);
		lbl_img.setBounds(0 , 0,screensize.width,300);
		panel_north.add(lbl_img);
		
		home = new JLabel();
		home.setText("Home");
		home.setBounds(600 , 100 ,59 ,20);
		home.setForeground(Color.black);
		home.setFont(new Font("Times New Roman" , Font.ROMAN_BASELINE, 25));
		home.addMouseListener(this);
		lbl_img.add(home);
		
		arrow = new JLabel();
		arrow.setText("→");
		arrow.setBounds(670 , 100 ,70 ,20);
		arrow.setForeground(Color.black);
		arrow.setFont(new Font("Times New Roman" , Font.BOLD, 25));
		lbl_img.add(arrow);
		
		about = new JLabel();
		about.setText("About");
		about.setBounds(710 , 98 ,200 ,25);
		about.setForeground(new Color(150,0 ,0));
		about.setFont(new Font("Times New Roman" , Font.ROMAN_BASELINE, 25));
		lbl_img.add(about);
		
		panel_center = new JPanel();
		panel_center.setLayout(null);
		panel_center.setBackground(Color.white);
		
		center = new JLabel();
		center.setText("A Few Words About Us");
		center.setBounds(230 , 20 ,500 ,60);
		center.setFont(new Font("Arial" , Font.BOLD ,30));
		center.setForeground(new Color(153, 101, 21));
		panel_center.add(center);
		
		text = new JLabel();
		text.setText("<html><div style ='text-allign: justify;'>The Luton Hotel is a suitable option for those seeking a comfortable and affordable place to stay in Luton, whether for business or leisure purposes. These hotels typically provide various facilities to ensure a comfortable stay. Whether your trip is for business or pleasure,our hotel is the perfect choice for anyone looking for comfort and convenience.If you're searching for the perfect accommodation for your next vacation, our luxurious hotel is the answer. Here, we also provide you with the most competitive offers,  ensuring that you receive the best deals during your stay with us.</div></html>");
		text.setBounds(30 ,50 , 830 , 400);
		text.setFont(new Font("Times New Roman" , Font.PLAIN,25));
		text.setForeground(Color.black);
		panel_center.add(text);
		
		//adding panel to the frame along with their position
		this.add(panel_south ,BorderLayout.SOUTH);
		this.add(panel_center ,BorderLayout.CENTER);
		this.add(panel_north ,BorderLayout.NORTH);
		this.add(panel_west ,BorderLayout.WEST);
		this.setVisible(true);
		
	}
	
	//calling constructor in the main method
	public static void main(String[] args) {
		new AboutHotelPage();

	}
	// These are event handling methods for mouse clicks, presses, releases, enters,
		// and exits
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==home) {
			home.setForeground(new Color(150,0 ,0));
			new MainPage();
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
		if(e.getSource()==home) {
			home.setForeground(new Color(150,0 ,0));
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==home) {
			home.setForeground(Color.black);
			
		}
		
	}


}
