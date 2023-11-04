package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class ManagerInfo extends JFrame implements ActionListener{
	JTable t;
	JButton b;
	
	public ManagerInfo() {
	setBounds(200,100,1050,600);
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
	
	t = new JTable();
	t.setBounds(0, 35, 1050, 300);
	add(t);
	try{
		Conn c = new Conn();
		ResultSet rs = c.s.executeQuery("Select * From employee where job = 'Manager'");
		t.setModel(DbUtils.resultSetToTableModel(rs));
		
	}catch(Exception e) {
		
	}
	
	JLabel name = new JLabel("Name");
	name.setBounds(20, 10, 100, 20);
	add(name);
	
	JLabel age = new JLabel("Age");
	age.setBounds(150, 10, 100, 20);
	add(age);
	
	JLabel gender = new JLabel("Gender");
	gender.setBounds(280, 10, 100, 20);
	add(gender);
	
	JLabel job = new JLabel("Job");
	job.setBounds(410, 10, 100, 20);
	add(job);
	
	JLabel salary = new JLabel("Salary");
	salary.setBounds(540, 10, 100, 20);
	add(salary);
	
	JLabel phone = new JLabel("Phone Number");
	phone.setBounds(670, 10, 100, 20);
	add(phone);
	
	JLabel email = new JLabel("Email Id");
	email.setBounds(805, 10, 100, 20);
	add(email);
	
	JLabel adhar = new JLabel("Adhar Id");
	adhar.setBounds(930, 10, 100, 20);
	add(adhar);
	
	b = new JButton("BACK");
	add(b);
	b.setBounds(440, 500, 150, 30);
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
		ManagerInfo mi = new ManagerInfo();

	}

}
