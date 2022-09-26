package L3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * CET - CS Academic Level 3
 * Course: CST8130 - Data Structures
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * 
 *  This class contains the arraylist and its methods
 *  
 * @author gabko
 *
 */
public class Binarysearch {
	
	//the arraylist of integers
	private ArrayList<Integer> numList = new ArrayList<Integer>();
	
	/**
	 * class constructor
	 */
	public Binarysearch() {
			
		
	}

	/**
	 * adds an integer to the arraylist
	 * 
	 * @param num : the integer to add to the arraylist
	 */
	public void addItem(int num) {
		
		numList.add(num);
		Collections.sort(numList);
	}
	
	/**
	 * recursive method to find the index of a given integer in the arraylist
	 * 
	 * @param num : integer to find the index of
	 * @param min : the lower bound of the search area of the arraylist
	 * @param max : the upper bound of the search area of the arraylist
	 * @return : the index of num in the arraylist
	 */
	public int binarySearch(int num, int min, int max) {
	
		int middle = (max + min) / 2;
		
		try {
			
			//recursive stuff happens here and returns the index of num
			if (numList.get(middle) == num) {
				
				return middle;
			}
			else if(numList.get(middle) > num) {
				
				return binarySearch(num, min, middle - 1);
			}
			else {
				
				return binarySearch(num, middle + 1, min);
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
	 * prints the contents of the arraylist
	 */
	public void displayList() {
		
		System.out.println(numList.toString());
	}
	
	/**
	 * returns the size of the arraylist
	 * @return : size of the arraylist
	 */
	public int numListSize() {
		
		return numList.size()-1;
	}
}
