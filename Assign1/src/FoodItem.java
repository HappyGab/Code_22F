import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * Assignment 1
 * 
 * This abstract class has methods to be inherited by the types of items in their own extended classes
 *  
 * @author gabko
 *
 */
public abstract class FoodItem {

	//values of each item
	protected int itemCode = 0;
	protected String itemName = ""; 
	protected int itemQuantityInStock = 0; 
	protected float itemCost = 0;
	protected float itemSalePrice = 0;
	protected String itemSupplier = "";
	protected float itemJarSize = 0;

	/**
	 * prints the info of this item
	 */
	public abstract String toString();

	/**
	 * method to add an new item
	 * 
	 * @param keyboard : scanner that reads the keyboard's inputs
	 * @param iCode : the item code of the new item
	 * @return : true if the item was added successfully, false if it wasn't
	 */
	public abstract boolean addItem(Scanner keyboard, int iCode);

	/**
	 * method to update the quantity of an item
	 * 
	 * @param num : the amount to add/remove from the stock
	 * @return : true if the item was added successfully, false if it wasn't
	 */
	public abstract boolean updateItem(int num);

	/**
	 * unused method
	 * 
	 * @param keyboard : scanner that reads the keyboard's inputs
	 * @return : false
	 */
	public abstract boolean isEqual(Scanner keyboard);

	/**
	 * unused method
	 * 
	 * @param keyboard : scanner that reads the keyboard's inputs
	 * @return : false
	 */
	public abstract boolean inputCode(Scanner keyboard);

	/**
	 * 
	 * @return : the item code of the item
	 */
	public int getItemCode() {

		return itemCode;
	}

}
