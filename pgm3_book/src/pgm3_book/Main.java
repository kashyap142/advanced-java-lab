package pgm3_book;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Database db = new Database();
		Scanner sc = new Scanner(System.in);
		
		int choice = 100;
		
		while(choice != 5) {
			System.out.println("Enter choice\n1. Add book\n2. Search by auhtor name\n"
					+ "3. Sort based on price\n4. Filter by price\n5. Exit\n");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				db.addNewBook();
				break;
			case 2:
				System.out.print("Enter author name to search: ");
				String authorName = sc.nextLine();
				db.searchByAuthor(authorName);
				break;
			case 3:
				db.sortBook();
				break;
			case 4:
				System.out.print("Enter price limit");
				int limit = Integer.parseInt(sc.nextLine());
				db.priceFilter(limit);
				break;
			case 5:
				choice = 5;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
			System.out.println();
		}
		
		sc.close();
		System.out.println("....Exiting....");
	}
}
