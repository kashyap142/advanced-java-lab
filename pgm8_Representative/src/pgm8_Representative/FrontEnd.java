package pgm8_Representative;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class FrontEnd {
	private JFrame jf = new JFrame("form");
	private JTextField[] jtf = new JTextField[20];
	private JLabel[] jl = new JLabel[20];
	private JButton jb1 = new JButton("Add rep");
	private JButton jb2 = new JButton("Add Cust");
	
	// for db
	String db = "jdbc:mysql://localhost:3306/pgm8";
	String dbUName = "root";
	String dbPwd = "root";
	
	FrontEnd() {
		__init();
		jl[0] = new JLabel("Rep No.");
		jl[1] = new JLabel("Name");
		jl[2] = new JLabel("State");
		jl[3] = new JLabel("Commission");
		jl[4] = new JLabel("Rate");
		
		jl[5] = new JLabel("Cust No.");
		jl[6] = new JLabel("Name");
		jl[7] = new JLabel("State");
		jl[8] = new JLabel("Credit Limit");
		jl[9] = new JLabel("Rep No.");
		
		for(int i=0; i<10; i++) {
			jf.add(jl[i]);
			jf.add(jtf[i]);
		}
		jf.add(jb1); jb1.addActionListener(this::addRep);
		jf.add(jb2); jb2.addActionListener(this::addCust);
		
		jf.setSize(400, 700);
		jf.setLayout(new GridLayout(11, 2));
		jf.setVisible(true);
	}
	
	private void addRep(ActionEvent ae) {
		String[] arr = new String[5];
		for(int i=0; i<5; i++) { // 0 - 4
			arr[i] = jtf[i].getText();
			if(arr[i].equals("")) {
				JOptionPane.showMessageDialog(jf, "fill all the fields");
				return;
			}
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(db, dbUName, dbPwd);
			PreparedStatement query = conn.prepareStatement("insert into rep values(?,?,?,?,?);");
			
			for(int i=0; i<5; i++) {
				query.setString(i + 1, arr[i]);
				jtf[i].setText(""); // clear TextField
			}
			
			query.executeUpdate();
			System.out.println("added rep");
			JOptionPane.showMessageDialog(jf, "added rep");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	}
	
	private void addCust(ActionEvent ae) {
		String[] arr = new String[5];
		for(int i=0; i<5; i++) { // 5 - 9
			arr[i] = jtf[i + 5].getText();
			if(arr[i].equals("")) {
				JOptionPane.showMessageDialog(jf, "fill all the fields");
				return;
			}
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(db, dbUName, dbPwd);
			PreparedStatement query = conn.prepareStatement("insert into cust values(?,?,?,?,?);");
			
			for(int i=0; i<5; i++) {
				query.setString(i + 1, arr[i]);
				jtf[i + 5].setText(""); // clear TextField, 5 - 9
			}
			
			query.executeUpdate();
			System.out.println("added cust");
			JOptionPane.showMessageDialog(jf, "added cust");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	}
	
	
	private void __init() {
		for(int i=0; i<20; i++) {
			jtf[i] = new JTextField("", 20);
			jl[i] = new JLabel();
		}
	}
}
