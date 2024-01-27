package pgm4_student;
import java.util.HashMap;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Database {
	private HashMap<String, Student>hm;
	private JFrame jf = new JFrame("Student form");
	private JTextField[] jtf = new JTextField[10];
	private JLabel[] jl = new JLabel[10];
	private JButton jb1 = new JButton("Add");
	private JButton jb2 = new JButton("Compute");
	private JButton jb3 = new JButton("Display");
	
	
	Database() {
		hm = new HashMap<>();
		__init();
		jl[0] = new JLabel("Name");
		jl[1] = new JLabel("USN");
		jl[2] = new JLabel("Address");
		jl[3] = new JLabel("Age");
		
		jl[4] = new JLabel("Sem 1");
		jl[5] = new JLabel("Sem 2");
		jl[6] = new JLabel("Sem 3");
		jl[7] = new JLabel("Sem 4");
		
		for(int i=0; i<8; i++) {
			jf.add(jl[i]); 
			jf.add(jtf[i]);
		}
		jf.add(jb1); jb1.addActionListener(this::addStud);
		jf.add(jb2); jb2.addActionListener(this::computeCGPA);
		jf.add(jb3); jb3.addActionListener(this::displayAll);
		jf.setSize(400, 600);
		jf.setLayout(new GridLayout(10, 2));
		jf.setVisible(true);
	}
	
	private void computeCGPA(ActionEvent ae) {
		float[] arr = new float[4];
		try {
			float total = 0;
			for(int i=0; i<4; i++) { // 4 - 7
				arr[i] = Float.parseFloat(jtf[i + 4].getText());
				if(arr[i] < 0F || arr[i] > 10F) {
					JOptionPane.showMessageDialog(jf, "SGPA should be in in between 0-10");
					return;
				}
				total += arr[i];
			}
			float cgpa = total / 4F;
			System.out.println("CGPA: " + cgpa);
			
			JOptionPane.showMessageDialog(jf, "CGPA: " + cgpa);
			clearField(4, 8);
		}
		catch(NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
			JOptionPane.showMessageDialog(jf, "SGPA should be numbers only");
		}
	}
	
	private void addStud(ActionEvent ae) {
		String[] arr = new String[4];
		try {
			for(int i=0; i<4; i++) {
				arr[i] = jtf[i].getText();
				if(arr[i].equals("")) {
					JOptionPane.showMessageDialog(jf, "fill all fields");
					return;
				}
			}
			int age = Integer.parseInt(arr[3]);
			if(age < 18 || age > 30)
				throw new NumberFormatException();
			Student st = new Student(arr[0], arr[1], arr[2], age);
			
			hm.put(arr[1], st);
			System.out.println("added student");
			
			clearField(0, 4);
			JOptionPane.showMessageDialog(jf, "added student");
		}catch(NumberFormatException nfe) {
			String msg = "Age should in between 18 - 30";
			JOptionPane.showMessageDialog(jf, msg);
		}
	}
	
	private void displayAll(ActionEvent ae) {
		JTextArea jta = new JTextArea();
		for(HashMap.Entry<String, Student>pr: hm.entrySet()) {
			jta.append(pr.getValue() + "\n");
		}
		JOptionPane.showMessageDialog(null, jta);
	}
	
	private void clearField(int s, int e) {
		for(int i=s; i<e; i++) {
			jtf[i].setText("");
		}
	}
	
	private void __init() {
		for(int i=0; i<10; i++) {
			jtf[i] = new JTextField("", 20);
			jl[i] = new JLabel();
		}
	}
}
