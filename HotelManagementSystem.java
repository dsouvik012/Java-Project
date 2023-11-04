package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
	public HotelManagementSystem() {
		//setSize(1250,550);
		//setLocation(100,100);
		setBounds(100, 100, 1250, 550);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
		add(image);
		image.setBounds(0, 0, 1250, 550);
		
		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		image.add(text);
		text.setForeground(Color.YELLOW);
		text.setBounds(30, 420, 1200, 90);
		text.setFont(new Font("serif",Font.LAYOUT_RIGHT_TO_LEFT, 40));
		
		JButton next = new JButton("NEXT");
		next.setBounds(1030, 440, 150, 50);
		next.setForeground(Color.RED);
		next.addActionListener(this);
		image.add(next);
		setVisible(true);
		
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println("Exception caugth in text");
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}
			catch(Exception e){
				System.out.println("Exception caugth in text");
			}
		}

	}
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		Login l = new Login();
	}
	

	public static void main(String[] args) {
		HotelManagementSystem hms = new HotelManagementSystem();// TODO Auto-generated method stub
	
	}
}
	
	
