package Hotel.Management.System;
import javax.swing.*;
import java.sql.*;
public class Conn {
	Connection c ;
	Statement s;
	public Conn() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "SYSTEM");
		}
		catch(Exception e) {
			System.out.println("Connection not Established");
		}
		s = c.createStatement();
		
		}
		catch(Exception e) {
			System.out.println("Driver not loaded");}
		}

}
