import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * Assignment 1
 * 
 * This class contains the driver class and its method
 *  
 * @author gabko
 *
 */
public class Assign1 {

	/**
	 * starting method, gives the menu options
	 * 
	 * @param args : nothing
	 */
	public static void main(String[] args) {

		Inventory Iv = new Inventory();

		Scanner keyboard = new Scanner(System.in);

		boolean toExit = false;
		int playerIn = 0;

		//loop as long as the user doesn't exit the program
		while (toExit == false) {

			//call to the print menu function
			displayMenu();

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

			//steps to add an item to the inventory
			case 1:

				Iv.addItem(keyboard);				
				break;

				//steps to display the inventory
			case 2:

				Iv.toString();
				break;

				//steps to buy items
			case 3:

				Iv.updateQuantity(true, keyboard);
				break;

				//steps to sell items
			case 4:

				Iv.updateQuantity(false, keyboard);
				break;

				//steps to exit the program	
			case 5:

				System.out.println("Exiting");
				toExit = true;
				keyboard.close();
				break;

				//steps the the user didn't input a valid value
			default:

				System.out.println("Invalid input");
				break;

			}
		}
	}

	/**
	 * displays the menu options
	 */
	private static void displayMenu() {

		System.out.println("Please select one of the following:\r\n"
				+ "1: Add Item to Inventory\r\n"
				+ "2: Display Current Inventory\r\n"
				+ "3: Buy Item(s)\r\n"
				+ "4: Sell Item(s)\r\n"
				+ "5: To Exit");
	}

}
