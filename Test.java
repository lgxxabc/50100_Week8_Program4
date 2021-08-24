package Week8_Program4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * =========================================
 * Name:             Guanxiaoxiong Liu 
 * Date:             08/23/2021
 * Course name:      Programming Foundations 
 * Semester:         Summer 2 
 * Assignment Name:  Program 4
 * =========================================
 */

public class Test {

	public static void main(String[] args) {
		// Create a new Set object
		Set mySet = new Set();
		
		// Print basic info
		printInfo();
		
		Scanner scan = new Scanner(System.in);
		
		// Infinite loop
		while(true) {
			System.out.println("Enter command: ");
			String command = scan.nextLine();
			
			String[] array = command.split(" ");
			String strCommand = array[0];	// the command itself
			String strInt = array[1];		// the integer x
			
			// Verify that the user enters a valid integer.
			boolean isNumber = patternControl(strInt);
			while (!isNumber) {
				System.out.println("Enter command: ");
				command = scan.nextLine();
				
				array = command.split(" ");
				strCommand = array[0];
				strInt = array[1];
				
				isNumber = patternControl(strInt);
			}
			
			// String --> int
			int x = Integer.parseInt(strInt);
			
			if (strCommand.equalsIgnoreCase("add")) {
				mySet.add(x);
				System.out.println(mySet.toString());
			} else if (strCommand.equalsIgnoreCase("del")) {
				mySet.delete(x);
				System.out.println(mySet.toString());
			} else if (strCommand.equalsIgnoreCase("exists")) {
				System.out.println(mySet.exists(x));
			}	
		}
	}
	
	private static void printInfo() {
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Guanxiaoxiong Liu");
		System.out.println("PROGRAMMING ASSIGNMENT 4 - SET");
		System.out.println();
	}
	
	// Verify if the input value is a number.
	private static boolean patternControl(String input) {
		Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
		Matcher number = pattern.matcher(input);
		if (!number.matches()) {
			return false;
		} else {
			return true;
		}
	}
	
	/*
		Output 1:
		Programming Fundamentals
		NAME: Guanxiaoxiong Liu
		PROGRAMMING ASSIGNMENT 4 - SET
		
		Enter command: 
		add 1
		 1 
		Enter command: 
		add 2
		 2 1 
		Enter command: 
		add -1
		 -1 2 1 
		Enter command: 
		add car
		Enter command: 
		add pensil
		Enter command: 
		add 0
		 0 -1 2 1 
		Enter command: 
	 */
}

/*
	Output 2:
	Programming Fundamentals
	NAME: Guanxiaoxiong Liu
	PROGRAMMING ASSIGNMENT 4 - SET

	Enter command: 
	add 5
	 5 
	Enter command: 
	add 8
	 8 5 
	Enter command: 
	add 6
	 6 8 5 
	Enter command: 
	add 24
	 24 6 8 5 
	Enter command: 
	add 6
	 24 6 8 5 
	Enter command: 
	exists 6
	true
	Enter command: 
	exists 13
	false
	Enter command: 
	exists 24
	true
	Enter command: 
	del 6
	 24 8 5 
	Enter command: 
	del 12
	 24 8 5 
	Enter command: 
	add 8
	 24 8 5 
	Enter command: 
	del 8
	 24 5 
	Enter command: 
*/
