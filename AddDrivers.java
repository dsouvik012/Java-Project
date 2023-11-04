package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {
	JTextField nam2, age2, company2, car2, avail1, location2;
	JRadioButton male, female;
	JComboBox avail2;
	JButton addriver, cancel;
	public AddDrivers() {
		setBounds(200, 100, 1000, 500);
		//setBackground(getBackground().WHITE);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel heading = new JLabel("ADD DRIVERS");
		add(heading);
		heading.setBounds(150, 20, 200, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD,18));
		
		JLabel nam1 = new JLabel("NAME");
		add(nam1);
		nam1.setBounds(80, 70, 100, 20);
		nam1.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 nam2 = new JTextField();
		nam2.setBounds(220, 70, 160, 30);
		add(nam2);
		
		JLabel age1 = new JLabel("AGE");
		add(age1);
		age1.setBounds(80, 110, 100, 20);
		age1.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 age2 = new JTextField();
		age2.setBounds(220, 110, 160, 30);
		add(age2);
		
		JLabel gender = new JLabel("GENDER");
		add(gender);
		gender.setBounds(80, 150, 150, 20);
		gender.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 male = new JRadioButton("Male");
		male.setBounds(220, 150, 70, 30);
		add(male);
		male.setBackground(Color.WHITE);
		male.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
		
		 female = new JRadioButton("Female");
		female.setBounds(270, 150, 70, 30);
		add(female);
		female.setBackground(Color.WHITE);
		female.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JLabel company = new JLabel("CAR COMPANY");
		add(company);
		company.setBounds(80, 190, 100, 20);
		company.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
		
		 company2 = new JTextField();
		 company2.setBounds(220, 190, 160, 30);
			add(company2);
		
		JLabel car = new JLabel("CAR MODEL");
		add(car);
		car.setBounds(80, 230, 100, 20);
		car.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		car2 = new JTextField();
		car2.setBounds(220, 230, 160, 30);
		add(car2);
		
		JLabel avail1 = new JLabel("AVAILBLE");
		add(avail1);
		avail1.setBounds(80, 270, 100, 20);
		avail1.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		String str[] = {"Available", "Occupied"};
		 avail2 = new JComboBox(str);
		 avail2.setBounds(220, 270, 160, 30);
		 avail2.setBackground(Color.WHITE);
		add(avail2);
		
		JLabel location1 = new JLabel("LOCATION");
		add(location1);
		location1.setBounds(80, 310, 100, 20);
		location1.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		location2 = new JTextField();
		location2.setBounds(220, 310, 160, 30);
		add(location2);
		
		addriver = new JButton("ADD DRIVERS");
		add(addriver);
		addriver.setBounds(80, 370, 130, 30);
		addriver.addActionListener(this);
		
		cancel = new JButton("CANCEL");
		add(cancel);
		cancel.setBounds(230, 370, 140, 30);
		cancel.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 400,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 20, 550, 400);
		add(image);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addriver) {
			String name = nam2.getText();
			String age = age2.getText();
			String carcompany = company2.getText();
			String car = car2.getText();
			String location = location2.getText();
			String available = (String)avail2.getSelectedItem();
			
			String gender = null;
			if(male.isSelected()) {
				gender = "Male";
			}else if(female.isSelected()) {
				gender = "Female";
			}
		
			try {
				Conn con = new Conn();
				String query =("Insert into AddDrivers values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+car+"','"+available+"','"+location+"')");
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Driver added succesfully");
				setVisible(false);
				
			}catch(Exception e) {
				//System.out.println("Exception cught here");
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		AddDrivers driver = new AddDrivers();// TODO Auto-generated method stub

	}

}
