import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.File; 
import java.io.FileNotFoundException; 

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * This Class contains the treemap, treeset and their methods
 * 
 * @author Gabriel Koscielniak
 *
 */
public class SetMapLib {

	//treemap and treesets
	private TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
	private TreeSet<Integer> keysTreeSet = new TreeSet<Integer>();
	private TreeSet<String> namesTreeSet = new TreeSet<String>();

	/**
	 * reads the given file and puts its data into the treemap
	 * 
	 * @return : true if it was successful, false if it was not
	 */
	public boolean tMapFromFile() {

		try {
			//scans the file
			File pOwnersFile = new File("productowners.txt");
			Scanner fileReader = new Scanner(pOwnersFile);
			
			//reads the file and puts its contents into the treemap
			while (fileReader.hasNext()) {
				
				String tempName = fileReader.next() + " " + fileReader.next();
				String name = tempName.replace(",", "");
				
				int key = fileReader.nextInt();
				
				treeMap.put(key, name);
			}
			fileReader.close();
			return true;
		} 
		//exception handling
		catch (FileNotFoundException e) {

			System.out.println("Error, file not found.");
			return false;
		}
		catch(Exception e) {

			System.out.println("Error: something went wrong.");
			return false;
		}

	}
	
	/**
	 * creates the 2 treesets from the data in the treemap
	 */
	public void tSet() {
		
		//initializes the teesets
		namesTreeSet = new TreeSet<String>();
		keysTreeSet.addAll(treeMap.keySet());
		namesTreeSet.addAll(treeMap.values());
		
		//prints the treesets
		System.out.println("Keys TreeSet is: " + keysTreeSet);
		System.out.println("Names TreeSet is: " + namesTreeSet + "\n");
	}
	
	/**
	 * prints the treemap
	 */
	public void printTreeMap() {
		
		//prints the treemap
		System.out.println("Current TreeMap: " + treeMap + "\n");
	}
	
	/**
	 * puts the data of the names treeset into descending order
	 */
	public void descendingTreeSet() {
		
		//new temporary treeset with descending ordering
		TreeSet<String> tempNamesTreeSet = new TreeSet<>(new descendingComparator());
		tempNamesTreeSet.addAll(namesTreeSet);
		
		//turns the original treeset into the temporary one
		namesTreeSet = tempNamesTreeSet;
		
		//prints the original treeset in descending order
		System.out.println("...Names TreeSet was sorted in descending order...");
		System.out.println(namesTreeSet + "\n");
	}
	
	/**
	 * gets a name and a key from the user to add into the treemap
	 * 
	 * @param keyboard : scanner for user input
	 */
	public void addIntoTreeMap(Scanner keyboard) {
		
		System.out.println("Please enter the name to add: ");
		
		boolean goodName = false;
		String name = "";
		String s = keyboard.nextLine();

		//loop as long as the user doesnt enter a valid input
		while (goodName == false) {

			try {
				//user's input
				name = keyboard.nextLine();
				goodName = true;
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s2 = keyboard.nextLine();
				System.out.println("Invalid input, please enter an integer");
			}
		}
		
		System.out.println("Please enter the key for " + name + ": ");
		
		boolean goodKey = false;
		int key = 0;

		//loop as long as the user doesnt enter a valid input
		while (goodKey == false) {

			try {
				//user's input
				key = keyboard.nextInt();
				goodKey = true;
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s2 = keyboard.nextLine();
				System.out.println("Invalid input, please enter an integer");
			}
		}
		
		//adds the value and key gotten from the user into the treemap
		treeMap.put(key, name);
		System.out.println("");
	}
	
	/**
	 * finds if there is a object in the treemap with the wanted key
	 * 
	 * @param keyboard : scanner for user input
	 */
	public void findKey(Scanner keyboard) {
		
		System.out.println("Please enter the key to search: ");
		
		boolean goodKey = false;
		int key = 0;

		//loop as long as the user doesnt enter a valid input
		while (goodKey == false) {

			try {
				//user's input
				key = keyboard.nextInt();
				goodKey = true;
			}
			catch ( java.util.InputMismatchException e) {

				//flushes the scanner & error message
				String s = keyboard.nextLine();
				System.out.println("Invalid input, please enter an integer");
			}
		}
		
		//true if the key is in the treemap, false if it is not
		boolean keyValue = treeMap.containsKey(key);
		
		//prints correct message according to boolean keyValue
		if(keyValue == true) {
			
			System.out.println("...Key " + key + " was found...\n");
		}
		else {
			
			System.out.println("...Key " + key + " not found...\n");
		}
	}
}

/**
 * comparator class used to put the treeset in descending order
 * 
 * @author gabko
 *
 */
class descendingComparator implements Comparator<String> {
	 
    public int compare(String name1, String name2)
    {
        // compare using compareTo() method
        return name2.compareTo(name1);
    }
}
