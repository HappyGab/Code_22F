import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * Assignment 1
 * 
 * This class extends FoodItem, its for vegetables
 *  
 * @author gabko
 *
 */

public class Vegetable extends FoodItem {

	@Override
	public String toString() {

		System.out.print("Item: " + getItemCode() + " " + getItemName() + " (" + getItemQuantityInStock()+ ") price: $");
		System.out.printf("%.2f", getItemSalePrice());
		System.out.print(" cost: $");
		System.out.printf("%.2f", getItemCost());		
		System.out.print(" farm supplier: " + getItemSupplier() + "\n\n");
		return null;
	}

	@Override
	public boolean addItem(Scanner keyboard, int iCode) {

		String userInput = "";
		int userInputNum = 0;
		float userInputF = 0;

		boolean validInput = false;

		String s = "";

		setItemCode(iCode);
		
		s = keyboard.nextLine();

		try {
			//user's input
			System.out.print("Enter the name for the item: ");
			userInput = keyboard.nextLine();
			setItemName(userInput);			

			while (validInput == false) {
				try {
					System.out.print("Enter the quantity for the item: ");
					userInputNum = keyboard.nextInt();
					if (userInputNum >= 0) {
						setItemQuantityInStock(userInputNum);
						validInput = true;
					}
					else {
						System.out.println("Cannot add a negative value of items");

					}
				}
				catch ( java.util.InputMismatchException e) {
					System.out.println("Invalid Input");
					s = keyboard.nextLine();
				}
			}

			s = keyboard.nextLine();
			validInput = false;

			while (validInput == false) {
				try {
					System.out.print("Enter the cost of the item: ");
					userInputF = keyboard.nextFloat();
					if (userInputF >= 0) {
						setItemCost(userInputF);
						validInput = true;
					}
					else {
						System.out.println("Cannot add a negative value of items");

					}
				}
				catch ( java.util.InputMismatchException e) {
					System.out.println("Invalid Input");
					s = keyboard.nextLine();
				}
			}


			s = keyboard.nextLine();
			validInput = false;

			while (validInput == false) {
				try {
					System.out.print("Enter the sales price of the item: ");
					userInputF = keyboard.nextFloat();
					if (userInputF >= 0) {
						setItemSalePrice(userInputF);
						validInput = true;
					}
					else {
						System.out.println("Cannot add a negative value of items");
					
					}
				}
				catch ( java.util.InputMismatchException e) {
					System.out.println("Invalid Input");
					s = keyboard.nextLine();
				}
			}

			s = keyboard.nextLine();
			validInput = false;

			System.out.print("Enter the name of the farm supplier: ");
			userInput = keyboard.nextLine();
			setItemSupplier(userInput);

			System.out.print("\n");

		}
		catch ( java.util.InputMismatchException e) {

			//flushes the scanner & error message
			s = keyboard.nextLine();
			System.out.println("Invalid Input");
			return false;
		}

		return true;
	}

	@Override
	public boolean updateItem(int num) {

		int temp = getItemQuantityInStock();

		temp = temp + num;

		if (temp < 0) {

			return false;
		}

		setItemQuantityInStock(temp);

		return true;

	}

	@Override
	public boolean isEqual(Scanner keyboard) {

		return false;
	}

	@Override
	public boolean inputCode(Scanner keyboard) {

		return false;
	}

	//****************************************************************************************************
	//****************************************************************************************************

	// All setters and getters

	public int getItemCode() {
		return itemCode;
	}

	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	public void setItemQuantityInStock(int itemQuantityInStock) {
		this.itemQuantityInStock = itemQuantityInStock;
	}

	public float getItemCost() {
		return itemCost;
	}

	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}

	public float getItemSalePrice() {
		return itemSalePrice;
	}

	public void setItemSalePrice(Float itemSalePrice) {
		this.itemSalePrice = itemSalePrice;
	}

	public String getItemSupplier() {
		return itemSupplier;
	}

	public void setItemSupplier(String itemSupplier) {
		this.itemSupplier = itemSupplier;
	}
}
