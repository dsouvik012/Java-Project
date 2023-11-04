package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchDriver extends JFrame implements ActionListener{
		JTable t;
		JButton sub, b;
		Choice car;
		
		public SearchDriver() {
			setBounds(200,100,1050,600);
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel heading = new JLabel("Search for Driver");
			add(heading);
			heading.setBounds(400, 30, 300, 40);
			heading.setFont(new Font("Tahoma", Font.BOLD,18));
			
			JLabel tcar = new JLabel("Type of Car");
			add(tcar);
			tcar.setBounds(50, 90, 100, 20);
			
			car = new Choice();
			add(car);
			car.setBounds(150, 90, 150, 20);
			car.setBackground(Color.WHITE);
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery("SELECT * FROM ADDDRIVERs");
				while(rs.next()) {
					car.add(rs.getString("Car"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			t = new JTable();
			t.setBounds(0, 165, 1050, 300);
			add(t);
			try{
				Conn c = new Conn();
				ResultSet rs1 = c.s.executeQuery("Select * From ADDDRIVERs");
				t.setModel(DbUtils.resultSetToTableModel(rs1));
				
			}catch(Exception e) {
				
			}
			
			JLabel r1 = new JLabel("Name");
			r1.setBounds(30, 130, 100, 20);
			add(r1);
			
			JLabel a1 = new JLabel("Age");
			a1.setBounds(180, 130, 100, 20);
			add(a1);
			
			JLabel cs1 = new JLabel("Gender");
			cs1.setBounds(330, 130, 100, 20);
			add(cs1);
			
			JLabel p1 = new JLabel("CarCompany");
			p1.setBounds(480, 130, 100, 20);
			add(p1);
			
			JLabel bt1 = new JLabel("Car");
			bt1.setBounds(650, 130, 100, 20);
			add(bt1);
			
			JLabel avail = new JLabel("Availablity");
			avail.setBounds(790, 130, 100, 20);
			add(avail);
			
			JLabel location = new JLabel("Location");
			location.setBounds(930, 130, 100, 20);
			add(location);
			
			sub = new JButton("Submit");
			add(sub);
			sub.setBounds(300, 500, 150, 30);
			sub.addActionListener(this);
			setVisible(true);
			
			b = new JButton("BACK");
			add(b);
			b.setBounds(550, 500, 150, 30);
			b.addActionListener(this);
			setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource() == sub) {
				try{
					Conn con = new Conn();
					String query = ("SELECT * FROM ADDDRIVERs WHERE Car ='"+car.getSelectedItem()+"'");
					ResultSet rs = con.s.executeQuery(query);
					t.setModel(DbUtils.resultSetToTableModel(rs));
					}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}else if(ae.getSource() == b) {
				setVisible(false);
				new Reception();
			}
		}

		public static void main(String[] args) {
			SearchDriver sr = new SearchDriver();

		}

}
