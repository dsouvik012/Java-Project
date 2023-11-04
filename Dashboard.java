package Hotel.Management.System;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Dashboard extends JFrame implements ActionListener{
	public Dashboard() {
		setBounds(0, 0, 1372, 800);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1372, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JLabel text = new JLabel("WELCOME TO DUTTA GROUP");
		text.setBounds(380, 40, 1100, 70);
		text.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 46));
		text.setForeground(Color.YELLOW);
		image.add(text);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1372, 30);
		image.add(mb);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		mb.add(hotel);
		hotel.setForeground(Color.BLUE);
		JMenuItem recep = new JMenuItem("RECEPTION");
		recep.setForeground(Color.RED);
		recep.addActionListener(this);
		hotel.add(recep);
		
		JMenu admin = new JMenu("ADMIN");
		mb.add(admin);
		admin.setForeground(Color.BLUE);
		JMenuItem emp = new JMenuItem("ADD EMPLOYEE");
		emp.setForeground(Color.RED);
		emp.addActionListener(this);
		admin.add(emp);
		
		JMenuItem room = new JMenuItem("ADD ROOMS");
		room.setForeground(Color.RED);
		room.addActionListener(this);
		admin.add(room);
		
		JMenuItem drive = new JMenuItem("ADD DRIVERS");
		drive.setForeground(Color.RED);
		drive.addActionListener(this);
		admin.add(drive);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee(); 
		}else if(ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}else if(ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDrivers();
		}else if(ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		setVisible(false); 
	}

	public static void main(String[] args) {
		Dashboard ds = new Dashboard();// TODO Auto-generated method stub

	}

}
