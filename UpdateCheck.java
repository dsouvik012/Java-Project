package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
	
	Choice customer;
	JTextField name1, room, time1, paid1, pending1;
	JButton check, update, back;
	
	public UpdateCheck(){
		setBounds(200, 200, 1000, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Update Status");
		add(heading);
		heading.setBounds(150, 20, 200, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD,18));
		
		JLabel id = new JLabel("Customer Id");
		id.setBounds(50, 80, 100, 20);
		add(id);
		
		customer = new Choice();
		customer.setBounds(180, 80, 150, 20);
		add(customer);
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM CUSTOMER");
			while(rs.next()) {
				customer.add(rs.getString("Number"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
		JLabel roomnumber = new JLabel("Allocate Room");
		roomnumber.setBounds(50, 120, 100, 20);
		add(roomnumber);
			room = new JTextField();
			room.setBounds(180, 120, 150, 20);
			room.setBackground(Color.WHITE);
			add(room);
		
		JLabel name = new JLabel("Name");
		name.setBounds(50, 160, 100, 20);
		add(name);
			name1 = new JTextField();
			name1.setBounds(180, 160, 150, 20);
			name1.setBackground(Color.WHITE);
			add(name1);
			
		JLabel time = new JLabel("CheckIn Time");
		time.setBounds(50, 200, 100, 20);
		add(time);
			time1 = new JTextField();
			time1.setBounds(180, 200, 150, 20);
			time1.setBackground(Color.WHITE);
			add(time1);
		
		JLabel paid = new JLabel("Amount Paid");
		paid.setBounds(50, 240, 100, 20);
		add(paid);
			paid1 = new JTextField();
			paid1.setBounds(180, 240, 150, 20);
			paid1.setBackground(Color.WHITE);
			add(paid1);
			
		JLabel pending = new JLabel("pending Ammount");
		pending.setBounds(50, 280, 120, 20);
		add(pending);
			pending1 = new JTextField();
			pending1.setBounds(180, 280, 150, 20);
			pending1.setBackground(Color.WHITE);
			add(pending1);
			
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 60, 500, 350);
		add(image);
			
		check = new JButton("Check");
		check.setBounds(30, 340, 150, 30);
		add(check);
		check.addActionListener(this);
		
		update = new JButton("Update");
		update.setBounds(200, 340, 150, 30);
		add(update);
		update.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(120, 390, 150, 30);
		add(back);
		back.addActionListener(this);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == check) {
			String id = customer.getSelectedItem();
			String query = ("SELECT * FROM CUSTOMER WHERE Number = '"+id+"'");
			try {
				Conn con = new Conn();
				ResultSet rs = con.s.executeQuery(query);
				while(rs.next()) {
					room.setText(rs.getString("AllocatedRoomNumber"));
					name1.setText(rs.getString("Name"));
					time1.setText(rs.getString("CheckInTime"));
					paid1.setText(rs.getString("Deposit"));
				}
				ResultSet rs1 = con.s.executeQuery("SELECT * FROM ADDROOMS WHERE RoomNumber = '"+room.getText()+"'");
				while(rs1.next()) {
					String price = rs1.getString("Price");
					int amountpaid = Integer.parseInt(price) - Integer.parseInt(paid1.getText());
					pending1.setText(""+ amountpaid);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == update) {
			String number = customer.getSelectedItem();
			String name2 = name1.getText();
			String room1 = room.getText();
			String checkin = time1.getText();
			String paid2 =paid1.getText();
			
			try {
				Conn c = new Conn();
				c.s.executeUpdate("UPDATE CUSTOMER set AllocatedRoomNumber ='"+room1+"', Name ='"+name2+"', CheckInTime ='"+checkin+"', Deposit ='"+paid2+"' WHERE Number = '"+number+"'");
				JOptionPane.showMessageDialog(null, "Update Successfully");
				
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
		UpdateCheck uc = new UpdateCheck();

	}

}
