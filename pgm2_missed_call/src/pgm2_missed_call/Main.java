package pgm2_missed_call;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);
		int choice = 100;
		
		while(choice != 5) {
			System.out.println("Choose option\n1. Dispaly All\n2. Add Caller\n"
					+ "3. Reomve caller\n4. Print names starting with A\n5. Exit\n");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:
				manager.displayCalls();
				break;
			case 2:
				manager.addCaller();
				break;
			case 3:
				manager.removeCaller();
				break;
			case 4:
				manager.nameStartingWithA();
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid input");
			}
			System.out.println();
		}
		
		sc.close();
		System.out.println("....Exiting....");
	}
}
