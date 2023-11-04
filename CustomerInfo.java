package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
	JTable t;
	JButton b;
	public CustomerInfo() {
		setBounds(200,100,1050,600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		t = new JTable();
		t.setBounds(0, 35, 1050, 400);
		add(t);
		try{
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("Select * From CUSTOMER");
			t.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			
		}
		
		JLabel id = new JLabel("ID");
		id.setBounds(20, 10, 100, 20);
		add(id);
		
		JLabel no = new JLabel("Id Number");
		no.setBounds(150, 10, 100, 20);
		add(no);
		
		JLabel name = new JLabel("Name");
		name.setBounds(290, 10, 100, 20);
		add(name);
		
		JLabel gen = new JLabel("Gender");
		gen.setBounds(420, 10, 100, 20);
		add(gen);
		
		JLabel con = new JLabel("Country");
		con.setBounds(550, 10, 100, 20);
		add(con);
		
		JLabel room = new JLabel("Allocated Rooms");
		room.setBounds(670, 10, 100, 20);
		add(room);
		
		JLabel time = new JLabel("Checkin Time");
		time.setBounds(805, 10, 100, 20);
		add(time);
		
		JLabel depos = new JLabel("Deposit");
		depos.setBounds(930, 10, 100, 20);
		add(depos);
		
		b = new JButton("BACK");
		add(b);
		b.setBounds(430, 500, 150, 30);
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
		CustomerInfo cf = new CustomerInfo();

	}

}
