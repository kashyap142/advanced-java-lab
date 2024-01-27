package pgm2_missed_call;

public class Caller {
	String name;
	String num;
	Caller(String num, String name) {
		this.num = num;
		this.name = name;
	}
	
	Caller(String num) {
		this.num = num;
		this.name = "Unknown";
	}
	
	public String toString() {
		return "[ Number: " + num + ", Caller: " + name + " ]";
	}
	
}
