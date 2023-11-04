package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
	JTextField nam2, age2, salary2, phn2, email2, adhar2;
	JRadioButton male, female;
	JComboBox job2;
	JButton submit;
	
	public AddEmployee(){
		setBounds(200, 100, 1000, 500);
		//setBackground(getBackground().WHITE);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel nam = new JLabel("NAME");
		add(nam);
		nam.setBounds(80, 30, 100, 30);
		nam.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 nam2 = new JTextField();
		nam2.setBounds(188, 30, 200, 30);
		add(nam2);
		
		JLabel age = new JLabel("AGE");
		add(age);
		age.setBounds(80, 70, 100, 30);
		age.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 age2 = new JTextField();
		age2.setBounds(188, 70, 200, 30);
		add(age2);
		
		JLabel gender = new JLabel("GENDER");
		add(gender);
		gender.setBounds(80, 110, 100, 30);
		gender.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 male = new JRadioButton("Male");
		male.setBounds(188, 110, 70, 30);
		add(male);
		male.setBackground(Color.WHITE);
		male.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
		
		 female = new JRadioButton("Female");
		female.setBounds(280, 110, 70, 30);
		add(female);
		female.setBackground(Color.WHITE);
		female.setFont(new Font("Tahoma",Font.TYPE1_FONT,12));
		
		ButtonGroup bg =new ButtonGroup();
		bg.add(male);
		bg.add(female);
		
		JLabel job = new JLabel("JOB");
		add(job);
		job.setBounds(80, 150, 100, 30);
		job.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		String str[] = {"Manager", "Accoutant", "Front Desk Clerk", "Chefs", "Kitchen Staff", "Room Service", "HouseKeeping", "Waiter"};
		 job2 = new JComboBox(str);
		job2.setBounds(188, 150, 200, 30);
		job2.setBackground(Color.WHITE);
		add(job2);
		
		JLabel salary = new JLabel("SALARY");
		add(salary);
		salary.setBounds(80, 190, 100, 30);
		salary.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 salary2 = new JTextField();
		salary2.setBounds(188, 190, 200, 30);
		add(salary2);
		
		JLabel phn = new JLabel("PHONE");
		add(phn);
		phn.setBounds(80, 230, 100, 30);
		phn.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 phn2 = new JTextField();
		phn2.setBounds(188, 230, 200, 30);
		add(phn2);
		
		JLabel email = new JLabel("EMAIL");
		add(email);
		email.setBounds(80, 270, 100, 30);
		email.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 email2 = new JTextField();
		email2.setBounds(188, 270, 200, 30);
		add(email2);
		
		JLabel adhar = new JLabel("ADHAR NO.");
		add(adhar);
		adhar.setBounds(80, 310, 100, 30);
		adhar.setFont(new Font("Tahoma",Font.TYPE1_FONT,14));
		
		 adhar2 = new JTextField();
		adhar2.setBounds(188, 310, 200, 30);
		add(adhar2);
		
		 submit = new JButton("SUBMIT");
		add(submit);
		submit.setBounds(188, 380, 200, 30);
		submit.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 550,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 10, 550, 550);
		add(image);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		String name = nam2.getText();
		String age = age2.getText();
		String salary = salary2.getText();
		String phone = phn2.getText();
		String email = email2.getText();
		String adhar = adhar2.getText();
		
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}
		
		String job = (String) job2.getSelectedItem();
		try {
			Conn con = new Conn();
			String query = ("Insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+adhar+"')");
			con.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employee added successfully");
			setVisible(false);
		}catch(Exception e) {
			System.out.println("Exception cught here");
		}
		
	}


	public static void main(String[] args) {
		AddEmployee ae = new AddEmployee();// TODO Auto-generated method stub

	}

}

