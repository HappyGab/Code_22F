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

		String playerIn = "";
		int playerInNum = 0;
		float playerInF = 0;

		String s = "";

		setItemCode(iCode);

		try {
			//user's input
			System.out.print("Enter the name for the item: ");
			playerIn = keyboard.nextLine();
			setItemName(playerIn);

			s = keyboard.nextLine();
			
			System.out.print("Enter the quantity for the item: ");
			playerInNum = keyboard.nextInt();
			if (playerInNum >= 0) {
				setItemQuantityInStock(playerInNum);
			}
			else {
				System.out.println("Cannot add a negative value of items");
				return false;
			}

			s = keyboard.nextLine();

			System.out.print("Enter the cost of the item: ");
			playerInF = keyboard.nextFloat();
			if (playerInF >= 0) {
				setItemCost(playerInF);
			}
			else {
				System.out.println("Cannot add a negative value of items");
				return false;
			}

			s = keyboard.nextLine();

			System.out.print("Enter the sales price of the item: ");
			playerInF = keyboard.nextFloat();
			if (playerInF >= 0) {
				setItemSalePrice(playerInF);
			}
			else {
				System.out.println("Cannot add a negative value of items");
				return false;
			}

			s = keyboard.nextLine();

			System.out.print("Enter the name of the farm supplier: ");
			playerIn = keyboard.nextLine();
			setItemSupplier(playerIn);

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
