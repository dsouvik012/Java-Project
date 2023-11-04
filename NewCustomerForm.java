package Hotel.Management.System;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;


public class NewCustomerForm extends JFrame implements ActionListener{
	JComboBox idcom;
	TextField num, name1, country1, depos;
	JRadioButton male, female;
	Choice roomnum1;
	JLabel checktime;
	JButton customer, back;
	public NewCustomerForm() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(250,200,850,500);
		setLayout(null);
		
		JLabel heading = new JLabel("NEW CUSTOMER FORM");
		add(heading);
		heading.setBounds(80, 10, 250, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD,18));
		
		JLabel id = new JLabel("ID");
		id.setBounds(30,60,100,20);
		id.setFont(new Font("Tahoma",Font.BOLD,14));
		add(id);
		
			String str[] = {"Passport", "Adhar Card", "Voter Id", "Driving Licence", "Ration Card"};
			idcom = new JComboBox(str);
			add(idcom);
			idcom.setBounds(220, 60, 160, 20);
			idcom.setBackground(Color.WHITE);
		
		
		JLabel number = new JLabel("Number");
		number.setBounds(30,100,100,20);
		number.setFont(new Font("Tahoma",Font.BOLD,14));
		add(number);
		
			num = new TextField();
			num.setBounds(220, 100, 160, 20);
			add(num);
		
		JLabel name = new JLabel("Name");
		name.setBounds(30,140,100,30);
		name.setFont(new Font("Tahoma",Font.BOLD,14));
		add(name);
		
			name1 = new TextField();
			name1.setBounds(220, 140, 160, 20);
			add(name1);
		
		JLabel gender = new JLabel("Gender");
		gender.setBounds(30,170,100,30);
		gender.setFont(new Font("Tahoma",Font.BOLD,14));
		add(gender);
		
			male = new JRadioButton("Male");
			male.setBounds(220, 170, 70, 30);
			add(male);
			male.setBackground(Color.WHITE);
			male.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
			
			female = new JRadioButton("Female");
			female.setBounds(300, 175, 70, 20);
			add(female);
			female.setBackground(Color.WHITE);
			female.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
		
		JLabel country = new JLabel("Country");
		country.setBounds(30,210,100,20);
		country.setFont(new Font("Tahoma",Font.BOLD,14));
		add(country);
		
			country1 = new TextField();
			country1.setBounds(220, 210, 160, 20);
			add(country1);
			
		JLabel roomnum = new JLabel("Allocated Room Number");
		roomnum.setBounds(30,250,170,30);
		roomnum.setFont(new Font("Tahoma",Font.BOLD,14));
		add(roomnum);
		
			roomnum1 = new Choice();
			try {
				Conn con = new Conn();
				String query= ("Select * From ADDROOMS where Available = 'Available'");
				ResultSet rs = con.s.executeQuery(query);
				while(rs.next()) {
					roomnum1.add(rs.getString("RoomNumber"));
				}
			}catch(Exception ae) {
				System.out.println("Exception cought here");
			}
			roomnum1.setBounds(220,250,160,20);
			add(roomnum1);
			
		JLabel ctime = new JLabel("CheckIn Time");
		ctime.setBounds(30,290,100,20);
		ctime.setFont(new Font("Tahoma",Font.BOLD,14));
		add(ctime);
		
			Date d = new Date();
			checktime = new JLabel(""+ d);
			checktime.setBounds(220, 290, 160, 20);
			checktime.setFont(new Font("Tahoma",Font.BOLD,14));
			add(checktime);
		
		JLabel deposit = new JLabel("Deposit");
		deposit.setBounds(30,330,100,20);
		deposit.setFont(new Font("Tahoma",Font.BOLD,14));
		add(deposit);
		
			depos = new TextField();
			depos.setBounds(220, 330, 160, 20);
			add(depos);
			
		customer = new JButton("Add Customer");
		add(customer);
		customer.setBounds(30, 370, 130, 30);
		customer.addActionListener(this);
			
		back = new JButton("Back");
		add(back);
		back.setBounds(220, 370, 130, 30);
		back.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 10, 400, 470);
		add(image);
			
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == customer) {
			String id1 = (String)idcom.getSelectedItem();
			String number = num.getText();
			String name =name1.getText();
			
			String gender = null;
			if(male.isSelected()) {
				gender = "Male";
			}else if(female.isSelected()) {
				gender = "Female";
			}
			String country = country1.getText();
			String roomnum = roomnum1.getSelectedItem();
			String time = checktime.getText();
			String deposit = depos.getText();
			
			try {
				Conn con = new Conn();
				String query1 = ("Insert into customer values('"+id1+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+roomnum+"', '"+time+"', '"+deposit+"')");
				String query2 = ("Update ADDROOMS set Available = 'Occupied' where RoomNumber = '"+roomnum+"'");
				con.s.executeUpdate(query1);
				con.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Customer added successfully");
				
				setVisible(false);
				new Reception();
				
			}catch(Exception e) {
				//System.out.println("Exception caught here");
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == back){
			setVisible(false);
			new Reception();
		}
		
	}

	public static void main(String[] args) {
		NewCustomerForm ncm = new NewCustomerForm();// TODO Auto-generated method stub

	}

}
