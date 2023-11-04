package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Departments extends JFrame implements ActionListener{
	JTable t;
	JButton back;
	public Departments(){
		setBounds(400,200,700,480);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		t = new JTable();
		t.setBounds(1, 50, 700, 350);
		add(t);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * From DEPARTMENTS");
			t.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
		}
		
		JLabel d = new JLabel("Departments");
		d.setBounds(150, 10, 100, 20);
		add(d);
		
		JLabel b1 = new JLabel("Budget");
		b1.setBounds(480, 10, 100, 20);
		add(b1);
		
		back = new JButton("Back");
		add(back);
		back.setBounds(280, 400, 120, 30);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Reception();
		}
		
	}

	public static void main(String[] args) {
		Departments d = new Departments();

	}

}
