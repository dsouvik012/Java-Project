package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AddRooms extends JFrame implements ActionListener{
	JTextField room2, price2;
	JComboBox avail2, clean2, bed2;
	JButton adroom, cancel;
	
	public AddRooms() {
		setBounds(200, 100, 1000, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("ADD ROOMS");
		add(heading);
		heading.setBounds(150, 20, 200, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD,18));
		
		JLabel room1 = new JLabel("ROOM NUMBER");
		add(room1);
		room1.setBounds(80, 80, 100, 20);
		room1.setFont(new Font("Tahoma", Font.TYPE1_FONT,12));
		
		 room2 = new JTextField();
		add(room2);
		room2.setBounds(220, 80, 150, 20);
		
		JLabel avail1 = new JLabel("AVAILBLE");
		add(avail1);
		avail1.setBounds(80, 130, 100, 20);
		avail1.setFont(new Font("Tahoma", Font.TYPE1_FONT,12));
		
		String str[] = {"Available", "Occupied"};
		 avail2 = new JComboBox(str);
		avail2.setBounds(220, 130, 150, 20);
		avail2.setBackground(Color.WHITE);
		add(avail2);
		
		JLabel clean1 = new JLabel("CLEANING STATUS");
		add(clean1);
		clean1.setBounds(80, 180, 150, 20);
		clean1.setFont(new Font("Tahoma", Font.TYPE1_FONT,12));
		
		String str1[] = {"Clean", "Dirty"};
		 clean2 = new JComboBox(str1);
		clean2.setBounds(220, 180, 150, 20);
		clean2.setBackground(Color.WHITE);
		add(clean2);
		
		JLabel price1 = new JLabel("PRICE");
		add(price1);
		price1.setBounds(80, 230, 100, 20);
		price1.setFont(new Font("Tahoma", Font.TYPE1_FONT,12));
		
		 price2 = new JTextField();
		add(price2);
		price2.setBounds(220, 230, 150, 20);
		
		JLabel bed1 = new JLabel("BED TYPE");
		add(bed1);
		bed1.setBounds(80, 280, 100, 20);
		bed1.setFont(new Font("Tahoma", Font.TYPE1_FONT,12));
		
		String str2[] = {"Single Bed", "Double Bed"};
		 bed2 = new JComboBox(str2);
		add(bed2);
		bed2.setBounds(220, 280, 150, 20);
		bed2.setBackground(Color.WHITE);
		
		 adroom = new JButton("ADD ROOM");
		add(adroom);
		adroom.setBounds(80, 340, 125, 30);
		adroom.addActionListener(this);
		
		 cancel = new JButton("CANCEL");
		add(cancel);
		cancel.setBounds(240, 340, 130, 30);
		cancel.addActionListener(this);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 0, 600, 500);
		add(image);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == adroom) {
			String room = room2.getText();
			String available = (String)avail2.getSelectedItem();
			String clean = (String)clean2.getSelectedItem();
			String price = price2.getText();
			String bed = (String)bed2.getSelectedItem();
		
			try {
				Conn con = new Conn();
				String query =("Insert into AddRooms values('"+room+"','"+available+"','"+clean+"','"+price+"','"+bed+"')");
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rooms added succesfully");
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		AddRooms adr = new AddRooms();// TODO Auto-generated method stub

	}

}
