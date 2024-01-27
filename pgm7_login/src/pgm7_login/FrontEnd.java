package pgm7_login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FrontEnd {
	private JFrame jf = new JFrame("Login form");
	private JLabel[] jl = new JLabel[3];
	private JTextField[] jtf = new JTextField[3];
	private JButton jb = new JButton("Add");
	
	FrontEnd() {
		__init();
		jl[0] = new JLabel("Name");
		jl[1] = new JLabel("UserId");
		jl[2] = new JLabel("Password");
		
		jf.add(jl[0]); jf.add(jtf[0]);
		jf.add(jl[1]); jf.add(jtf[1]);
		jf.add(jl[2]); jf.add(jtf[2]);
		jf.add(jb); jb.addActionListener(this::addToDB);
		
		jf.setSize(300, 300);
		jf.setLayout(new GridLayout(4, 2));
		jf.setVisible(true);
	}
	
	private void addToDB(ActionEvent ae) {
		String[] arr = new String[3];
		for(int i=0; i<3; i++) {
			arr[i] = jtf[i].getText();
			if(arr[i].equals("")) {
				JOptionPane.showMessageDialog(jf, "fill all the fields");
				return;
			}
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String db = "jdbc:mysql://localhost:3306/pgm7";
			String uName = "root";
			String pwd = "root";
			
			Connection conn = DriverManager.getConnection(db, uName, pwd);
			
			PreparedStatement query = conn.prepareStatement("insert into users values(?, ?, ?)");
			
			query.setString(1, arr[0]);
			query.setString(2, arr[1]);
			query.setString(3, arr[2]);
			
			System.out.println("query: " + query);
			
			query.executeUpdate();
			
			System.out.println("added new user");
			JOptionPane.showMessageDialog(jf, "added user");
			
			// clear the input filed
			for(int i=0; i<3; i++) {
				jtf[i].setText("");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	}
	
	private void __init() {
		for(int i=0; i<3; i++) {
			jtf[i] = new JTextField("", 20);
			jl[i] = new JLabel();
		}
	}
}
