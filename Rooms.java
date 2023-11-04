package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Rooms extends JFrame implements ActionListener{
	JTable t;
	JButton b;
	public Rooms() {
		setBounds(200,100,1050,600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 0, 800, 600);
		add(image);
		
		t = new JTable();
		t.setBounds(0, 35, 500, 400);
		add(t);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * From ADDROOMS");
			t.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
		}
		
		JLabel r1 = new JLabel("Room Number");
		r1.setBounds(5, 10, 100, 20);
		add(r1);
		
		JLabel a1 = new JLabel("Availablity");
		a1.setBounds(110, 10, 100, 20);
		add(a1);
		
		JLabel cs1 = new JLabel("Cleaning Status");
		cs1.setBounds(200, 10, 100, 20);
		add(cs1);
		
		JLabel p1 = new JLabel("Price");
		p1.setBounds(320, 10, 100, 20);
		add(p1);
		
		JLabel bt1 = new JLabel("Bed Type");
		bt1.setBounds(410, 10, 100, 20);
		add(bt1);
		
		b = new JButton("BACK");
		add(b);
		b.setBounds(155, 500, 150, 30);
		b.addActionListener(this);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b) {
			setVisible(false);
			new Reception();
		}
		
	}

	public static void main(String[] args) {
		Rooms r = new Rooms();

	}

}
