import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * Assignment 1
 * 
 * This class has the inventory array and methods for its objects
 *  
 * @author gabko
 *
 */

public class Inventory {

	/**
	 * inventory array
	 */
	private FoodItem[] inventory = new FoodItem[20];

	/**
	 * method to add items to the inventory array
	 * 
	 * @param keyboard : scanner, reads keyboard inputs
	 */
	public void addItem(Scanner keyboard) {

		String playerIn = "";
		int playerInNum = 0;

		System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
		try {
			//user's input
			playerIn = keyboard.next();
		}
		catch ( java.util.InputMismatchException e) {

			//flushes the scanner & error message
			String s = keyboard.nextLine();
			System.out.println("Invalid Input");
			return;
		}

		//checks of the users had a valid input
		if (playerIn.equals("f") || playerIn.equals("v") || playerIn.equals("p")) {

			int num = 19;
			while (inventory[num] == null) {

				num = num - 1;

				if (num <= 0) {
					break;
				}
			}
			
			num++;

			//user inputs item code
			System.out.print("Enter the code for the item: ");
			try {
				//user's input
				playerInNum = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid Input");
				return;
			}

			//checks if the code already exists
			int iCode = alreadyExists(playerInNum);

			if (iCode != -1) {

				System.out.println("Item code already exists");
				return;
			}

			switch (playerIn) {

			//steps to add a fruit
			case "f" :

				Fruit tempFruit = new Fruit();
				boolean addedF = tempFruit.addItem(keyboard, playerInNum);

				if (addedF == true) {
					inventory[num] = tempFruit;
				}
				else {
					System.out.println("Could not add the Item");
					return;
				}
				break;

				//steps to add a vegetable
			case "v" :

				Vegetable tempVeg = new Vegetable();
				boolean addedV = tempVeg.addItem(keyboard, playerInNum);

				if (addedV == true) {
					inventory[num] = tempVeg;
				}
				else {
					System.out.println("Could not add the Item");
					return;
				}
				break;

				//steps to add a preserve
			case "p" :

				Preserve tempPre = new Preserve();
				boolean addedP = tempPre.addItem(keyboard, playerInNum);

				if (addedP == true) {
					inventory[num] = tempPre;
				}
				else {
					System.out.println("Could not add the Item");
					return;
				}
				break;
			}
		}
		else {

			System.out.println("Invalid Entry");
		}
	}

	/**
	 * method to checks if there already is an item with the item code
	 * 
	 * @param num : the item code
	 * @return the index of the item with the item code, or -1 if none exists 
	 */
	public int alreadyExists(int num) {

		for (int i = 0; i < inventory.length; i++) {

			if (inventory[i] != null) {
				if (inventory[i].getItemCode() == num) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * method to update the quantity of an item in inventory
	 * 
	 * @param buySell : true if we buy the item, false if we sell it
	 * @param keyboard : scanner that reads the keyboard's inputs
	 * @return : true if the update was a success, false if it wasn't
	 */
	public boolean updateQuantity(boolean buySell, Scanner keyboard) {

		int playerIn = 0;

		//gets the wanted item code from the user
		System.out.println("Enter the code for the item: ");
		try {
			//user's input
			playerIn = keyboard.nextInt();
		}
		catch ( java.util.InputMismatchException e) {

			//flushes the scanner & error message
			String s = keyboard.nextLine();
			System.out.println("Invalid Input");
			return false;
		}

		//checks if the item exists
		int index = alreadyExists(playerIn);

		if (index == -1) {

			System.out.println("Error...could not buy item");
			return false;
		}

		//if we buy the item
		if (buySell == true) {

			System.out.println("Enter valid quantity to buy: ");
			try {
				//user's input
				playerIn = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid Input");
				return false;
			}

			if (playerIn <= 0) {
				System.out.println("Error...could not buy item");
				return false;
			}

			boolean bought = inventory[index].updateItem(playerIn);

			if (bought == false) {
				System.out.println("Error...could not buy item");
				return false;				
			}

		}
		//if we sell the item
		else {

			System.out.println("Enter valid quantity to sell: ");
			try {
				//user's input
				playerIn = keyboard.nextInt();
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid Input");
				return false;
			}

			if (playerIn <= 0) {
				System.out.println("Error...could not sell item");
				return false;
			}

			playerIn = playerIn * -1;
			boolean sold = inventory[index].updateItem(playerIn);

			if (sold == false) {
				System.out.println("Error...could not buy item");
				return false;				
			}

		}

		return true;
	}

	/**
	 * method to print the contents of the inventory array
	 */
	public String toString() {

		System.out.println("Inventory:");

		for (int i = 0; i < inventory.length; i++) {

			if (inventory[i] != null) {

				inventory[i].toString();
			}
		}
		return "";
	}

}
