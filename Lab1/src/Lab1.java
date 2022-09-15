import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * This class contains the dynamically allocated array and it's processing
 * Student Name: 
 * Student Number:  
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
public class Lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Numbers num = new Numbers();
		
		// keyboard input reader
		Scanner keyboard = new Scanner(System.in);

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
				break;
				
			case 4:
				
				//calls method to display the values in the array
				break;
				
			case 5:
				
				//calls method to display the info about the values in the arrau
				break;
				
			case 6:
				
				//quits
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
				+ "6: To Exit");
		
	}
}
