package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class CheckOut extends JFrame implements ActionListener{
	Choice customer;
	JLabel roomnum, checkin1, checkout1;
	JButton checkout2, back;
	
	public CheckOut() {
		setBounds(350, 200, 830, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Customer CheckOut");
		add(heading);
		heading.setBounds(90, 20, 200, 30);
		heading.setFont(new Font("Tshoma",Font.BOLD,18));
		
		JLabel id = new JLabel("Customer Id");
		id.setBounds(30, 90, 100, 20);
		add(id);
		
		customer = new Choice();
		customer.setBounds(150, 90, 150, 20);
		add(customer);
		
		
		JLabel room = new JLabel("Room Number");
		add(room);
		room.setBounds(30, 140, 100, 20);
			roomnum = new JLabel();
			add(roomnum);
			roomnum.setBounds(150, 140, 150, 20);
			
		JLabel checkin = new JLabel("CheckIn Time");
		add(checkin);
		checkin.setBounds(30, 190, 100, 20);
			checkin1 = new JLabel();
			add(checkin1);
			checkin1.setBounds(150, 190, 150, 20);
			
		JLabel checkout = new JLabel("CheckOut Time");
		add(checkout);
		checkout.setBounds(30, 240, 100, 20);
			Date d = new Date();
			checkout1 = new JLabel(""+ d);
			add(checkout1);
			checkout1.setBounds(150, 240, 150, 20);
			
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM CUSTOMER");
			while(rs.next()) {
				customer.add(rs.getString("Number"));
				roomnum.setText(rs.getString("AllocatedRoomNumber"));
				checkin1.setText(rs.getString("CheckInTime"));	
			}
				
		}catch(Exception e) {
				e.printStackTrace();
		}
			
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(455, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(330, 25, 455, 350);
		add(image);
		
		checkout2 = new JButton("CHECKOUT");
		checkout2.setBounds(30, 320, 120, 30);
		add(checkout2);
		checkout2.addActionListener(this);
		
		back = new JButton("BACK");
		back.setBounds(190, 320, 120, 30);
		add(back);
		back.addActionListener(this);
	
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == checkout2) {
			String query1 = ("DELETE FROM CUSTOMER WHERE Number = '"+customer.getSelectedItem()+"'");
			String query2 = ("UPDATE ADDROOMS SET Available = 'Available' WHERE RoomNumber = '"+roomnum.getText()+"'");
			System.out.println(query2);
			try {
				Conn c = new Conn();
				c.s.executeUpdate(query1);
				System.out.println(query2);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "ChecOut Done");
				
				setVisible(false);
				new Reception();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == back) {
			setVisible(false);
			new Reception();
			
		}
		
	}
	public static void main(String[] args) {
		CheckOut co = new CheckOut();

	}

}
