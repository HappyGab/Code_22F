import java.util.Scanner;
import java.util.ArrayList;	

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
	 * inventory ArrayList
	 */
	private ArrayList<FoodItem> inventory = new ArrayList<FoodItem>();

	/**
	 * method to add items to the inventory array
	 * 
	 * @param keyboard : scanner, reads keyboard inputs
	 */
	public void addItem(Scanner keyboard) {

		String userInput = "";
		int userInputNum = 0;
		
		boolean validInput = false;
		
		//asks for the type of produce until a valid input
		while(validInput == false) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
			try {
				//user's input
				userInput = keyboard.next();
				if (userInput.equals("f") || userInput.equals("v") || userInput.equals("p")) {
					validInput = true;
				}
				else {
					System.out.println("Invalid Input");
				}
			}
			catch (java.util.InputMismatchException e) {
	
				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid Input");
			}
		}
		
		validInput = false;
		
		//checks if the users had a valid input		
		while (validInput == false) {
			if (userInput.equals("f") || userInput.equals("v") || userInput.equals("p")) {
	
	
				//user inputs item code
				while (validInput == false) {
					System.out.print("Enter the code for the item: ");
					try {
						//user's input
						userInputNum = keyboard.nextInt();
						validInput = true;
					}
					catch ( java.util.InputMismatchException e) {
		
						//flushes the scanner & error message
						String s = keyboard.nextLine();
						System.out.println("Invalid Input");
					}
				}
				
				validInput = false;				
	
				//checks if the code already exists
				int iCode = alreadyExists(userInputNum);
				if (iCode != -1) {
	
					System.out.println("Item code already exists\n");
					return;
				}
				
				int itemIndex = 0;
				
				//steps to find where the new item should go in the arraylist to keep it ordered
				if (inventory.size() == 1) {
					
					if (inventory.get(0).getItemCode() < userInputNum) {
						itemIndex = 1;
					}
				}
				else if(inventory.size() > 1) {
					
					itemIndex = binarySearch(userInputNum, 0, inventory.size()-1);
					
					try {
						if (inventory.get(itemIndex).getItemCode() < userInputNum) {
							itemIndex = itemIndex + 1;
						}
					}
					catch (Exception e) {
					}
					
				}
	 
				switch (userInput) {
	
				//steps to add a fruit
				case "f" :
	
					Fruit tempFruit = new Fruit();
					boolean addedF = tempFruit.addItem(keyboard, userInputNum);
	
					if (addedF == true) {
						inventory.add(itemIndex, tempFruit);
					}
					else {
						System.out.println("Could not add the Item");
						return;
					}
					break;
	
					//steps to add a vegetable
				case "v" :
	
					Vegetable tempVeg = new Vegetable();
					boolean addedV = tempVeg.addItem(keyboard, userInputNum);
	
					if (addedV == true) {
						inventory.add(itemIndex, tempVeg);
					}
					else {
						System.out.println("Could not add the Item");
						return;
					}
					break;
	
					//steps to add a preserve
				case "p" :
	
					Preserve tempPre = new Preserve();
					boolean addedP = tempPre.addItem(keyboard, userInputNum);
	
					if (addedP == true) {
						inventory.add(itemIndex, tempPre);
					}
					else {
						System.out.println("Could not add the Item");
						return;
					}
					break;
				}
			}
			//in case of an invalid user input
			else {
	
				System.out.println("Invalid Entry");
			}
			validInput = true;
		}

	}

	/**
	 * method to checks if there already is an item with the item code
	 * 
	 * @param num : the item code
	 * @return the index of the item with the item code, or -1 if none exists 
	 */
	public int alreadyExists(int num) {

		//check for the index of the closest or exact code in the array
		int itemIndex = binarySearch(num, 0, inventory.size()-1);
		
		//checks if the item code of the index is equal to the given code
		try {
			if(inventory.get(itemIndex).getItemCode() == num) {
				
				return itemIndex;
			}
		}
		catch (Exception e) {
			
			return -1;
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

		int userInput = 0;
		
		boolean validInput = false;

		//gets the wanted item code from the user
		
		while (validInput == false) {
		System.out.println("Enter the code for the item: ");
			try {
				//user's input
				userInput = keyboard.nextInt();
				validInput = true;
			}
			catch ( java.util.InputMismatchException e) {
	
				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid Input");
			}
		}
		
		validInput = false;

		//checks if the item exists
		int index = alreadyExists(userInput);

		if (index == -1) {

			System.out.println("Error...could not buy item");
			return false;
		}

		//if we buy the item
		if (buySell == true) {

			while (validInput == false) {
			System.out.println("Enter valid quantity to buy: ");
				try {
					//user's input
					userInput = keyboard.nextInt();
					validInput = true;
				}
				catch ( java.util.InputMismatchException e) {
	
					//flushes the scanner & error message
					String s = keyboard.nextLine();
					System.out.println("Invalid Input");
				}
			}
			
			validInput = false;

			//if the item could not be bought
			if (userInput <= 0) {
				System.out.println("Error...could not buy item");
				return false;
			}

			boolean bought = inventory.get(index).updateItem(userInput);

			if (bought == false) {
				System.out.println("Error...could not buy item");
				return false;				
			}

		}
		//if we sell the item
		else {

			while (validInput == false) {
				System.out.println("Enter valid quantity to sell: ");
				try {
					//user's input
					userInput = keyboard.nextInt();
					validInput = true;
				}
				catch ( java.util.InputMismatchException e) {
	
					//flushes the scanner & error message
					String s = keyboard.nextLine();
					System.out.println("Invalid Input");
				}
			}
			
			validInput = false;

			//if the item could not be sold
			if (userInput <= 0) {
				System.out.println("Error...could not sell item");
				return false;
			}

			userInput = userInput * -1;
			boolean sold = inventory.get(index).updateItem(userInput);

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

		//calls the toString method of all the arraylist elements
		for (int i = 0; i < inventory.size(); i++) {

			if (inventory.get(i) != null) {

				inventory.get(i).toString();
			}
		}
		return "";
	}
	
	/**
	 * recursive method to find the index of a given item code in the arraylist
	 * 
	 * @param num : code to find the index of
	 * @param min : the lower bound of the search area of the arraylist
	 * @param max : the upper bound of the search area of the arraylist
	 * @return : the index of num in the arraylist
	 */
	public int binarySearch(int num, int min, int max) {
	
		int middle = (max + min) / 2;
		
		try {
			
			//recursive stuff happens here and returns the index of num
			if (inventory.get(middle).getItemCode() == num) {
				
				return middle;
			}
			else if(min >= max) {
				
				return middle;
			} 
			else if(inventory.get(middle).getItemCode() > num) {
				
				return binarySearch(num, min, middle - 1);
			}
			else {
				
				return binarySearch(num, middle + 1, max);
			}
		}
		
		//catch exceptions return -1 if num is not in the arraylist
		catch(Exception e) {
			return -1;
		}
		catch(StackOverflowError e2) {
			return -1;
		}
				
	}
	
	/**
	 * method to search for a specific item using its code
	 * 
	 * @param keyboard : keyboard input reader
	 */
	public void searchForItem(Scanner keyboard) {
		
		boolean validInput = false;
		int userInputNum = 0;
		
		//user inputs item code
		while (validInput == false) {
			System.out.print("Enter the code for the item: ");
			try {
				//user's input
				userInputNum = keyboard.nextInt();
				validInput = true;
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid Input");
			}
		}
		
		//checks if the item exists
		int index = alreadyExists(userInputNum);
		
		//if it doesnt exist
		if(index == -1) {
			System.out.println("Item Code not found in the Inventory\n");
		}
		//if it does exist
		else {
			inventory.get(index).toString();
		}
	}

}
