package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
	JTable t;
	JButton sub, b;
	JComboBox bed1;
	JCheckBox available;
	
	public SearchRoom() {
		setBounds(200,100,1050,600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Search for Room");
		add(heading);
		heading.setBounds(400, 30, 300, 40);
		heading.setFont(new Font("Tahoma", Font.BOLD,18));
		
		JLabel bed = new JLabel("BedType");
		add(bed);
		bed.setBounds(50, 90, 100, 20);
		
		String str[] = {"Single Bed", "Double Bed"};
		bed1 = new JComboBox(str);
		add(bed1);
		bed1.setBounds(140, 90, 150, 20);
		bed1.setBackground(Color.WHITE);
		
		available = new JCheckBox("Only Display Available");
		available.setBounds(700, 90, 200, 20);
		available.setBackground(Color.WHITE);
		add(available);
		
		t = new JTable();
		t.setBounds(0, 165, 1050, 300);
		add(t);
		try{
			Conn c = new Conn();
			ResultSet rs1 = c.s.executeQuery("Select * From ADDROOMS");
			t.setModel(DbUtils.resultSetToTableModel(rs1));
			
		}catch(Exception e) {
			
		}
		
		JLabel r1 = new JLabel("Room Number");
		r1.setBounds(20, 130, 100, 20);
		add(r1);
		
		JLabel a1 = new JLabel("Availablity");
		a1.setBounds(230, 130, 100, 20);
		add(a1);
		
		JLabel cs1 = new JLabel("Cleaning Status");
		cs1.setBounds(450, 130, 100, 20);
		add(cs1);
		
		JLabel p1 = new JLabel("Price");
		p1.setBounds(660, 130, 100, 20);
		add(p1);
		
		JLabel bt1 = new JLabel("Bed Type");
		bt1.setBounds(870, 130, 100, 20);
		add(bt1);
		
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
				String query1 = "SELECT * FROM ADDROOMS WHERE BedType ='"+bed1.getSelectedItem()+"'";
				String query2 = ("SELECT * FROM ADDROOMS WHERE Available = 'Available' AND BedType = '"+bed1.getSelectedItem()+"'");
				ResultSet rs2;
				if(available.isSelected()) {
					rs2 = con.s.executeQuery(query2);
				}else {
					rs2 = con.s.executeQuery(query1);
					}
				t.setModel(DbUtils.resultSetToTableModel(rs2));
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
		SearchRoom ar = new SearchRoom();

	}

}
