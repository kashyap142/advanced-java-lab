/*
 * Write a program that uses Java Swing and JDBC to create a stand-alone application: 
 * Create two tables namely, Representative (RepNo, RepName, State, Commission, Rate) and 
 * Customer (CustNo, CustName, State, Credit_Limit, RepNo) in MySQL database.
 * Use appropriate Swing components to insert values in a form.
 * Display in frame those customers and representatives belonging to a particular state
 */

package pgm8_Representative;

public class Main {
	public static void main(String[] args) {
		 new FrontEnd();
	}
}
