import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException; 


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
public class TestSetMap {
	
	
	/**
	 * Start of the program
	 * 
	 * @param args : none
	 */
	public static void main(String[] args) {
		
		SetMapLib tMap = new SetMapLib(); 
		
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
			
			switch (playerIn) {
			
				//if the user chose menu option 1
				case 1:{
					
					boolean option1 = tMap.tMapFromFile();
					
					if(option1 == true) {
						
						System.out.println("...TreeMap created...\n");
					}
					else {
						
						System.out.println("...Error, TreeMap creation failes...\n");
					}
					
					break;
				}
				
				//if the user chose menu option 2
				case 2:{
					
					tMap.printTreeMap();
					
					break;
				}
				
				//if the user chose menu option 3
				case 3:{
					
					tMap.findKey(keyboard);
					
					break;
				}
				
				//if the user chose menu option 4
				case 4:{
					
					tMap.tSet();
					
					break;
				}
				
				//if the user chose menu option 5
				case 5:{
					
					tMap.descendingTreeSet();
					
					break;
				}
				
				//if the user chose menu option 6
				case 6:{
					
					tMap.addIntoTreeMap(keyboard);
					
					break;
				}
				
				//if the user chose menu option 7
				case 7:{
					
					System.out.println("...exiting...");
					toExit = true;
					
					break;
				}
			
			}
		}
	}

	/**
	 * method to print the menu
	 */
	private static void showmenu() {

		System.out.println("Please Enter:\n"
				+ "1. Create a TreeMap of data from the text file.\n"
				+ "2. Display the TreeMap.\n"
				+ "3. Search for a given key or value in the TreeMap.\n"
				+ "4. Create and display a keys TreeSet and a values TreeSet from the TreeMap.\n"
				+ "5. Sort and display values TreeSet in descending order.\n"
				+ "6. Add new key-value data to the TreeMap.\n"
				+ "7. Exit");
	}
}
