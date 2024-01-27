package pgm1_student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentList {
	ArrayList<Student>al;
	Scanner sc;
	StudentList() {
		al = new ArrayList<>();
		sc = new Scanner(System.in);
	}
	
	void addNewStud() {
		System.out.print("Name: "); String name = sc.nextLine();
		System.out.print("USN: "); String usn = sc.nextLine();
		System.out.print("Dept: "); String dept = sc.nextLine();
		System.out.print("Sec: "); String sec = sc.nextLine();
		System.out.print("CGPA: "); float cgpa = Float.parseFloat(sc.nextLine());
		Student s = new Student(name, usn, dept, sec, cgpa);
		al.add(s);
		System.out.println("added new student\n");
	}
	
	void studentWithHigherCgpa() {
		Iterator<Student>itr = al.iterator();
		System.out.println("Students with CGPA above 8.5 are\n");
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.cgpa >= 8.5f) {
				System.out.println(s);
			}
		}
	}
	
	void IseStudents() {
		Iterator<Student>itr = al.iterator();
		System.out.println("Students of ISE are\n");
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.dept.equals("ISE")) {
				System.out.println(s);
			}
		}
	}
	
	void CSectionStudents() {
		Iterator<Student>itr = al.iterator();
		System.out.println("C section students are\n");
		while(itr.hasNext()) {
			Student s = itr.next();
			if(s.sec.equals("C")) {
				System.out.println(s);
			}
		}	
	}
}
