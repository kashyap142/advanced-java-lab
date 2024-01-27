package pgm2_missed_call;
import java.util.HashMap;	
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class Manager {
	private HashMap<String, Caller>hm;
	private LinkedList<Caller>list;
	private Scanner sc;
	
	Manager() {
		hm = new HashMap<>();
		list = new LinkedList<>();
		sc = new Scanner(System.in);
	}
	
	void addCaller() {
		// input caller
		System.out.print("Number to add, input 'private' if unknown: ");
		String num = sc.nextLine();
		Caller c;
		if(num.equalsIgnoreCase("private")) {
			c = new Caller(num);
		}
		else {
			System.out.print("Name: ");
			String name = sc.nextLine();
			c = new Caller(num, name);
		}
		hm.put(num, c);
		list.add(c);
		System.out.println("added new caller");
	}
	
	void removeCaller() {
		// input number
		System.out.print("Enter number to remove: "); 
		String num = sc.nextLine();
		if(hm.containsKey(num)) {
			Caller c = hm.get(num);
			hm.remove(num);
			list.remove(c);
			System.out.println("Removed successfully");
		}
		else {
			System.out.println("Number doesn't exist in list");
		}
	}
	
	void displayCalls() {
		Iterator<Caller>itr = list.iterator();
		System.out.println("Missed call list is:");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	void nameStartingWithA() {
		Iterator<Caller>itr = list.iterator();
		System.out.println("Name starting with A are:");
		while(itr.hasNext()) {
			Caller c = itr.next();
			char firstChar = c.name.charAt(0);
			if(firstChar == 'A' || firstChar == 'a') {
				System.out.println(c);
			}
		}
	}
}
