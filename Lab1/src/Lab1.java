import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
public class Lab1 {

	private static Scanner rF;
	/**
	 * entry into the program
	 */
	public static void main(String[] args) {

		Numbers num = new Numbers();
		
		// keyboard input reader
		Scanner keyboard = new Scanner(System.in);
		
		//file scanner and reader
		//Scanner rF;
		FileWriter wF; 

		// looping variable
		// true = keep playing, false = stop playing
		boolean keepPlay = true;

		int playerIn = 0;
		
		while (keepPlay == true) {
			
			displayMainMenu();
			
			try {
				//user's input
				playerIn = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {
				
				//flushes the scanner
				String s = keyboard.nextLine();
			}
			
			switch (playerIn) {
			
			case 1:
				
				//calls method to initialize a default array
				num = new Numbers();
				break;
				
			case 2:
				
				//asks the user for the max size of the array
				System.out.println("Enter the desired max size fot the array");
				
				int size = 0;
				
				boolean wrongIn = true;

				//loops until the input is valid
				while (wrongIn == true) {
					try {
						//user's input
						size = keyboard.nextInt();
						wrongIn = false;
					}
					catch ( java.util.InputMismatchException e) {
						
						//flushes the scanner
						String s = keyboard.nextLine();
						System.out.println("Invalid input, please enter a valid option");
					}
				}
				
				//calls method to specify the max size of the array
				num = new Numbers(size);
				break;
				
			case 3:
				
				//calls method to add a value to the array
				num.addValue(keyboard, false, 0);
				System.out.println("\n");
				break;
				
			case 4:
				
				num.toString();
				//calls method to display the values in the array
				break;
				
			case 5:
				
				//calls method to display the info about the values in the array
				float avg = num.calcAverage();
				float[] info = num.findMinMax();
				
				System.out.println("Average is: " + avg + " Minimum value is: "
						+ info[0] + " Maximum value is: " + info[1]
						+ " Max mod min is: " + info[2]);
				System.out.println("\n");
				
				break;
			
			case 6:
				//calls method to add multiple values
				num.addMultipleValue(keyboard);
				System.out.println("\n");
				
				break;
				
			case 7:
				
				System.out.println("Name of the file to read from:");
				
				String fileName = "";
				
				try {
					//user's input
					fileName = keyboard.next();
				}
				catch ( java.util.InputMismatchException e) {
					
					//flushes the scanner
					String s = keyboard.nextLine();
				}
				
				boolean fileFound = readFile(fileName);
				
				if (fileFound == true) {
					while (rF.hasNextFloat() == true) {
					
						num.addValue(keyboard, true, rF.nextFloat());
					}
				}
				
				break;
				
			case 8:
				
				
				break;
				
			case 9:
				
				//quits
				keepPlay = false;
				System.out.println("Exiting");
				break;
				
			default:
				
				boolean wrongIn2 = true;

				
				while (wrongIn2 == true) {
					
					System.out.println("Invalid input, please enter a valid option");
					
					try {
						//user's input
						playerIn = keyboard.nextInt();
					}
					catch ( java.util.InputMismatchException e) {
						
						//flushes the scanner
						String s = keyboard.nextLine();
					}
					
					if (playerIn >=1 && playerIn <=6) {
						
						wrongIn2 = false;
					}
					
				}
				
			}
			
		}

	}

	/**
	 * Displays the menu
	 */
	public static void displayMainMenu() {
		
		System.out.println("Please select one of the following:\r\n"
				+ "1: Initialize a default array\r\n"
				+ "2: To specify the max size of the array\r\n"
				+ "3: Add value to the array\r\n"
				+ "4: Display values in the array\r\n"
				+ "5: Display average of the values, minimum value, maximum value, max mod min\r\n"
				+ "6: Enter multiple values\r\n"
				+ "7: Read values from files\r\n"
				+ "8: Save values to file\r\n"
				+ "9: To exit\r\n");
		
	}
	
	public static boolean readFile(String fileName) {
		
		try {
			rF = new Scanner(new File(fileName));
			return true;
		}
		catch (FileNotFoundException e1) {
			System.out.println("Error: File not found");
		}
		
		return false;
		
	}
}
