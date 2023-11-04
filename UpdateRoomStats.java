package Hotel.Management.System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateRoomStats extends JFrame implements ActionListener{
		Choice customer;
		JTextField room, available1, status;
		JButton check, update, back;
		
		public UpdateRoomStats(){
			setBounds(200, 200, 970, 450);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel heading = new JLabel("Update Room Status");
			add(heading);
			heading.setBounds(100, 20, 200, 30);
			heading.setFont(new Font("Tahoma", Font.BOLD,18));
			
			JLabel id = new JLabel("Customer Id");
			id.setBounds(50, 90, 100, 20);
			add(id);
			
			customer = new Choice();
			customer.setBounds(180, 90, 150, 20);
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
				
			JLabel roomnumber = new JLabel("Room Number");
			roomnumber.setBounds(50, 140, 100, 20);
			add(roomnumber);
				room = new JTextField();
				room.setBounds(180, 140, 150, 20);
				room.setBackground(Color.WHITE);
				add(room);
			
			JLabel available = new JLabel("Availablity");
			available.setBounds(50, 190, 100, 20);
			add(available);
			available1 = new JTextField();
			available1.setBounds(180, 190, 150, 20);
			available1.setBackground(Color.WHITE);
				add(available1);
				
			JLabel cstatus = new JLabel("Cleaning Status");
			cstatus.setBounds(50, 240, 100, 20);
			add(cstatus);
				status = new JTextField();
				status.setBounds(180, 240, 150, 20);
				status.setBackground(Color.WHITE);
				add(status);
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
			Image i2 = i1.getImage().getScaledInstance(500, 330, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(400, 30, 500, 330);
			add(image);
				
			check = new JButton("Check");
			check.setBounds(30, 320, 100, 30);
			add(check);
			check.addActionListener(this);
			
			update = new JButton("Update");
			update.setBounds(150, 320, 100, 30);
			add(update);
			update.addActionListener(this);
			
			back = new JButton("Back");
			back.setBounds(280, 320, 100, 30);
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
					}
					ResultSet rs1 = con.s.executeQuery("SELECT * FROM ADDROOMS WHERE RoomNumber = '"+room.getText()+"'");
					while(rs1.next()) {
						available1.setText(rs1.getString("Available"));
						status.setText(rs1.getString("CleaningStatus"));
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(ae.getSource() == update) {
				String number = customer.getSelectedItem();
				String room1 = room.getText();
				String availablity = available1.getText();
				String stats = status.getText();

				try {
					Conn c = new Conn();
					c.s.executeUpdate("UPDATE ADDROOMS set Available ='"+availablity+"', CleaningStatus ='"+stats+"' WHERE RoomNumber = '"+room1+"'");
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
			UpdateRoomStats ur = new UpdateRoomStats();

		}

}
