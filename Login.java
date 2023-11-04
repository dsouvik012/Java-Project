package Hotel.Management.System;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JTextField username;
	JPasswordField password;
	JButton login, cancel;
	public Login() {
		setBounds(500, 200, 600, 300);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		add(user);
		user.setBounds(50, 20, 100, 30);
		
		 username = new JTextField();
		username.setBounds(155, 20, 160, 30);
		add(username);
		
		JLabel pass = new JLabel("Password");
		add(pass);
		pass.setBounds(50, 70, 100, 30);
		
		 password = new JPasswordField();
		password.setBounds(155, 70, 160, 30);
		add(password);
		
		 login = new JButton("LOGIN");
		login.setBounds(60, 140, 100, 30);
		login.addActionListener(this);
		add(login);
		 cancel = new JButton("CANCEL");
		cancel.setBounds(180, 140, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 10, 200, 200);
		add(image);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			String user = username.getText();
			String pass = password.getText();
			try {
				Conn c = new Conn();
				String query =( "select * from login where username = '"+user+"' and password = '"+pass+"'");
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()){
					setVisible(false);
					Dashboard ds = new Dashboard();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);
				}
			}
			catch(Exception e) {
				System.out.println("Exception caught herre");
			}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		Login l = new Login();// TODO Auto-generated method stub

	}
	

}
