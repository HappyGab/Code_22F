package assignment3;



import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Starter file for Assigment3 for CST8130
 * @author James, Georger
 * 
 * 
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 * Assignment 3
 * 
 * This class contains the driver class and method
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		
		//hashmap of PostalCodeEntry objects
		HashMap<String, PostalCodeEntry> pCodes = new HashMap<>();

		String filename = "OttawaPostalCodes.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
				
				//splits the line into the correct fields and puts them into an array
				String[] fields = line.split(",");
				
				//creates the PostalCodeEntry object
				PostalCodeEntry postCode = new PostalCodeEntry(fields);
				
				//gets the prefix and add the object in the hashmap with the prefix as the key
				String prefix = postCode.getPrefix();
				pCodes.put(prefix, postCode);
				
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 
		// no need to close input. Used try-with-resources above
		
		System.out.println("\n\n\n");
		
		//loop to get 10 random prefixes and check if they exist in the hashmap
		for(int i = 0; i < 10; i++) {
			
			//random prefix gotten
			String tempPrefix = PostalCodeEntry.getRandomPrefix();			
			System.out.println("Retrieving: "+ tempPrefix);
			
			//checks if the prefix is a key in the hashmap
			if(pCodes.containsKey(tempPrefix)) {
				
				//prints the value attached to the key if it exists
				PostalCodeEntry keyFound = pCodes.get(tempPrefix);				
				String toPrint = keyFound.toString();				
				System.out.println("\t" + toPrint);
				
			}
			else {
				
				//prints if the random key is not in the hashmap
				System.out.println("\tNOT FOUND\n");
			}
		}
	}// main()

}// class
