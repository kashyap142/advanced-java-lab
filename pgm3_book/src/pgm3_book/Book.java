package pgm3_book;

public class Book {
	private static int count = 1;
	String title;
	String author;
	String publisher;
	int price;
	private int _id;
	Book(String title, String author, String publisher, int price) {
		this._id = count++;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	public String toString() {
		return "[ id: " + _id + ",\nTitle: " + title + ",\nAuthor: " + author + ",\nPublisher: " + 
				publisher + ",\nPrice: " + price + " ]"; 
	}
}
