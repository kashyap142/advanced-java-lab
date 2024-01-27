package pgm4_student;

public class Student {
	String name;
	String usn;
	String address;
	int age;

	Student(String name, String usn, String address, int age) {
		this.name = name;
		this.usn = usn;
		this.address = address;
		this.age = age;
	}
	
	public String toString() {
		return "[ Name: " + name + ", USN: " + usn +
				", Address: " + address + ", Age: " + age + " ]";
	}
}
