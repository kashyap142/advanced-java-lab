package pgm1_student;

public class Student {
	String name;
	String usn;
	String dept;
	String sec;
	float cgpa;
	Student(String name, String usn, String dept, String sec, float cgpa) {
		this.name = name;
		this.usn = usn;
		this.dept = dept.toUpperCase();
		this.sec = sec.toUpperCase();
		this.cgpa = cgpa;
	}
	
	public String toString() {
		return ("[ Name: " + name + ", USN: " + usn + ", Dept: " + dept 
				+ ", Section: " + sec + ", CGPA: " + cgpa + " ]\n");
	}
}
