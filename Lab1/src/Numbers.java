import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Gabriel Koscielniak
 * Student Number: 041062261
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * 
  */
public class Numbers {
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {
		// TODO Write code here to initialize a "default" array since this is the default constructor
		numbers = new Float[1];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		// TODO Write code here to initialize the numbers array of max 'size'
		numbers = new Float[size];
	}
	
	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard, boolean fromFile, float num) {
		
		if (fromFile == false) {
			boolean nextVal = false;
			int nextValPlace = 0;
			
			for (int i = 0; i<numbers.length; i++) {
				
				if (nextVal == false) {
					if (numbers[i] == null) {
						nextVal = true;
						nextValPlace = i;
					}
				}
			}
			
			if (nextVal == true) {
				
				float numToAdd = 0;
					
				System.out.println("Enter value:");
				
				try {
					//user's input
					numToAdd = keyboard.nextFloat();
				}
				catch ( java.util.InputMismatchException e) {
					
					//flushes the scanner
					String s = keyboard.nextLine();
				}	
				
				numbers[nextValPlace] = numToAdd;
			}
			else {
				
				System.out.println("Array full");
			}
		}
	}
	
	/**
	 * Adds multiple values in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addMultipleValue(Scanner keyboard) {
		
		int numsToAdd = 0;
		
		System.out.println("How many vlaues do you wish to add?");
		try {
			//user's input
			numsToAdd = keyboard.nextInt();
		}
		catch ( java.util.InputMismatchException e) {
			
			//flushes the scanner
			System.out.println("Something went wrong");
			String s = keyboard.nextLine();
		}
		
		for(int i = 1; i <= numsToAdd; i++) {
			boolean nextVal = false;
			int nextValPlace = 0;
			
			for (int i2 = 0; i2<numbers.length; i2++) {
				
				if (nextVal == false) {
					if (numbers[i2] == null) {
						nextVal = true;
						nextValPlace = i2;
					}
				}
			}
			
			if (nextVal == true) {
				
				float numToAdd = 0;
					
				System.out.println("Enter value:");
				
				try {
					//user's input
					numToAdd = keyboard.nextFloat();
				}
				catch ( java.util.InputMismatchException e) {
					
					//flushes the scanner
					String s = keyboard.nextLine();
				}	
				
				numbers[nextValPlace] = numToAdd;
			}
			else {
				
				System.out.println("Array full");
			}
		}
	}
	
	
	/**
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		
		int nextVal = 0;
		float total = 0;
		float avg = 0;
		boolean nextValNull = false;
		
		while(nextValNull == false) {
			
			if (numbers[nextVal] != null) {
				total = total + numbers[nextVal];			
				nextVal++;
			}else {
				nextValNull = true;
			}
			
			if (nextVal >= numbers.length) {
				nextValNull = true;
			}
		}
		
		avg = total / nextVal;
		
		return avg;
	}
	
	/**
	 * finds the minimum, maximum and max modulo min in the array
	 * @return array with the min, max and max mod min of the array
	 */
	public float[] findMinMax() {
		
		float[] res = new float[3];
		
		float min = 0;
		float max = 0;
		
		if(numbers[0] != null) {
			min = numbers[0];
		}
		
		if(numbers[0] != null) {
			max = numbers[0];
		}
		
		for (int i = 0; i < numbers.length; i++) {
			
			if(numbers[i] != null) {
				if(numbers[i] < min) {
					
					min = numbers[i];
				}
				if(numbers[i] > max) {
					
					max = numbers[i];
				}
			}
		}
		
		float maxModMin = max % min;
		
		res[0] = min;
		res[1] = max;
		res[2] = maxModMin;
		
		return res;
	}
/**
 * Prints the contents of the array
 */
	@Override
	public String toString() {

		System.out.println("Numbers are:");
		
		for (int i = 0; i < numbers.length; i++ ) {
			
			if (numbers[i] != null) {
				System.out.println(numbers[i]);
			}
		}
		System.out.println("\n");
		
		return "";
	}
	
}
