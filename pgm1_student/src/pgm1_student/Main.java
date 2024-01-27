package pgm1_student;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentList studList = new StudentList();
		Scanner sc = new Scanner(System.in);
		int choice = 100;
		
		while(choice != 5) {
			System.out.println("Choose\n1. Add student\n2. Print ISE Students\n"
					+ "3. Print students with CGPA >= 8.5\n4. C Section Students\n5. Exit\n");
			System.out.print("Enter choice: ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1:
				studList.addNewStud();
				break;
			case 2:
				studList.IseStudents();
				break;
			case 3:
				studList.studentWithHigherCgpa();
				break;
			case 4:
				studList.CSectionStudents();
				break;
			case 5: 
				choice = 5;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
		sc.close();
		System.out.println("....Exiting....");
	}
}
