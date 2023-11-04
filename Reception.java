package Hotel.Management.System;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.event.*;
import java.awt.*;

public class Reception extends JFrame implements ActionListener{
	JButton newcustomer, room, department, empinfo, custinfo, maninfo, roomsrch;
	JButton update, roomstat, pickup, checkout, logout;
	public Reception() {
		setBounds(200, 100, 900, 570);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		newcustomer = new JButton("New Customer Form");
		add(newcustomer);
		newcustomer.setBounds(50, 30, 150, 30);
		newcustomer.addActionListener(this);
		
		room = new JButton("ROOM");
		add(room);
		room.setBounds(50, 70, 150, 30);
		room.addActionListener(this);
		
		department = new JButton("DEPARTMENT");
		add(department);
		department.setBounds(50, 110, 150, 30);
		department.addActionListener(this);
		
		empinfo = new JButton("All Employee Info.");
		add(empinfo);
		empinfo.setBounds(50, 150, 150, 30);
		empinfo.addActionListener(this);
		
		custinfo = new JButton("Customer Info.");
		add(custinfo);
		custinfo.setBounds(50, 190, 150, 30);
		custinfo.addActionListener(this);
		
		maninfo = new JButton("Manager info.");
		add(maninfo);
		maninfo.setBounds(50, 230, 150, 30);
		maninfo.addActionListener(this);
		
		checkout = new JButton("Check Out");
		add(checkout);
		checkout.setBounds(50, 270, 150, 30);
		checkout.addActionListener(this);
		
		update = new JButton("Update Status");
		add(update);
		update.setBounds(50, 310, 150, 30);
		update.addActionListener(this);
		
		roomstat = new JButton("Update Room Status");
		add(roomstat);
		roomstat.setBounds(50, 350, 150, 30);
		roomstat.addActionListener(this);
		
		pickup = new JButton("Pick Up Service");
		add(pickup);
		pickup.setBounds(50, 390, 150, 30);
		pickup.addActionListener(this);;
		
		roomsrch = new JButton("Search Room");
		add(roomsrch);
		roomsrch.setBounds(50, 430, 150, 30);
		roomsrch.addActionListener(this);
		
		logout = new JButton("LOGOUT");
		add(logout);
		logout.setBounds(50, 470, 150, 30);
		logout.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 470,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250, 30, 600, 470);
		add(image);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == newcustomer) {
			setVisible(false);
			new NewCustomerForm();
		}else if(ae.getSource() == room) {
			setVisible(false);
			new Rooms();
		}else if(ae.getSource() == department) {
			setVisible(false);
			new Departments();
			
		}else if(ae.getSource() == empinfo) {
			setVisible(false);
			new EmployeeInfo();
		}else if(ae.getSource() == custinfo) {
			setVisible(false);
			new CustomerInfo();
		}else if(ae.getSource() == maninfo) {
			setVisible(false);
			new ManagerInfo();
		}else if(ae.getSource() == roomsrch) {
			setVisible(false);
			new SearchRoom();
		}else if(ae.getSource() == update) {
			setVisible(false);
			new UpdateCheck();
		}else if(ae.getSource() == roomstat) {
			setVisible(false);
			new UpdateRoomStats();
		}else if(ae.getSource() == pickup) {
			setVisible(false);
			new SearchDriver();
		}else if(ae.getSource() == checkout) {
			setVisible(false);
			new CheckOut();
		}else if(ae.getSource() == logout) {
			setVisible(false);
			System.exit(0);;
		}
		
	}

	public static void main(String[] args) {
		Reception re = new Reception();// TODO Auto-generated method stub

	}

}
