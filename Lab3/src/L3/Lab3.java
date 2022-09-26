package L3;

import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * This Class is the driver class with main method and the menu
 * 
 * @author Gabriel Koscielniak
 *
 */
public class Lab3 {

	/**
	 * Start of the program
	 * 
	 * @param args : none
	 */
	public static void main(String[] args) {
		
		//necessary variables
		Binarysearch arr = new Binarysearch();

		Scanner keyboard = new Scanner(System.in);

		boolean toExit = false;
		int playerIn = 0;

		//loop as long as the user doesnt exit the program
		while (toExit == false) {

			//call to the print menu function
			showmenu();

			try {
				//user's input
				playerIn = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s = keyboard.nextLine();
			}

			//for the menu options
			switch (playerIn) {

			//steps to add a integer to the arraylist
			case 1:
				
				System.out.print("Please specify an Integer: ");
				try {
					//user's input
					playerIn = keyboard.nextInt();
				}
				catch ( java.util.InputMismatchException e) {

					//flushes the scanner & error message
					String s = keyboard.nextLine();
					System.out.println("Invalid Input");
				}
				
				arr.addItem(playerIn);
				System.out.println("");
				break;

			//steps to find the index of the wanted integer in the arraylist
			case 2:
				
				System.out.print("Please specify an Integer: ");
				try {
					//user's input
					playerIn = keyboard.nextInt();
				}
				catch ( java.util.InputMismatchException e) {

					//flushes the scanner & error message
					String s = keyboard.nextLine();
					System.out.println("Invalid Input");
				}
				
				int index = arr.binarySearch(playerIn, 0, arr.numListSize());
				
				if (index != -1) {
					System.out.println("Index of Integer is: " + index);
				}
				else {
					System.out.println("Index of Integer is: Not Found");
				}
				System.out.println("");
				break;

			//steps to print the contents of the arraylist
			case 3:
				
				arr.displayList();
				System.out.println("");
				break;

			//steps to exit the program	
			case 4:
				
				System.out.println("Exiting");
				toExit = true;
				break;

			//steps the the user didnt input a valid value
			default:

				System.out.println("Invalid input");
				break;

			}

		}
	}

	/**
	 * method to print the menu
	 */
	private static void showmenu() {

		System.out.println("Please Enter:\n"
				+ "1. Add Item\n"
				+ "2. Search for Item\n"
				+ "3. Display List\n"
				+ "4. Exit");
	}

}
