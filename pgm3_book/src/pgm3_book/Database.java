package pgm3_book;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

import javax.swing.*;

class PriceComparator implements Comparator<Book>{
	public int compare(Book b1, Book b2) {
		return b1.price - b2.price;
	}
}

public class Database {
	private ArrayList<Book>al;
	private JFrame jf = new JFrame("Book form");
	private JLabel jl1, jl2, jl3, jl4;
	private JTextField jtf1, jtf2, jtf3, jtf4;
	private JButton jb = new JButton("Submit");
	
	Database() {
		al = new ArrayList<>();
		
		jl1 = new JLabel("Title"); jtf1 = new JTextField("", 20);
		jl2= new JLabel("Author"); jtf2 = new JTextField("", 20);
		jl3 = new JLabel("Publisher"); jtf3 = new JTextField("", 20);
		jl4 = new JLabel("Price"); jtf4 = new JTextField("", 20);
		
		jf.add(jl1); jf.add(jtf1);
		jf.add(jl2); jf.add(jtf2);
		jf.add(jl3); jf.add(jtf3);
		jf.add(jl4); jf.add(jtf4);
		
		jf.add(jb); jb.addActionListener(this::submit);
		jf.setSize(400, 400);
		jf.setLayout(new GridLayout(5, 2));
	}
	
	private void submit(ActionEvent ae) {
		String title = jtf1.getText();
		String author = jtf2.getText();
		String publisher = jtf3.getText();
		if(title.equals("") || author.equals("") 
				|| publisher.equals("") || jtf4.getText().equals("")) {
			JOptionPane.showMessageDialog(jf, "Fill all the fields");
			return;
		}
		int price = Integer.parseInt(jtf4.getText());
		Book b = new Book(title, author, publisher, price);
		al.add(b);
		JOptionPane.showMessageDialog(jf, "added new Book");
		
		// clear input field
		jtf1.setText("");
		jtf2.setText("");
		jtf3.setText("");
		jtf4.setText("");
		
		jf.setVisible(false);
	}
	
	void addNewBook() {
		jf.setVisible(true);
	}
	
	void searchByAuthor(String authorName) {
		System.out.println("Books by author '" + authorName + "' are:");
		Iterator<Book>itr = al.iterator();
		while(itr.hasNext()) {
			Book b = itr.next();
			if(b.author.equalsIgnoreCase(authorName)) {
				System.out.println(b);
			}
		}
	}
	
	void priceFilter(int limit) {
		Iterator<Book>itr = al.iterator();
		System.out.println("Books with price greater than " + limit + " are:");
		while(itr.hasNext()) {
			Book b = itr.next();
			if(b.price >= limit) {
				System.out.println(b);
			}
		}
	}
	
	void sortBook() {
		ArrayList<Book>temp = new ArrayList<Book>(al);
		System.out.println("Book sorted on price:");
		temp.sort(new PriceComparator());
		for(Book b: temp) {
			System.out.println(b);
		}
	}
}
