/**
 * Processing data using Doubly Linked List CST8130 Data Structures,
 * Computer Engineering Technology-Computer Science: Level 3
 * 
 * Professor: James Mwangi PhD
 * 
 * Lab4
 * Student Name: Gabriel Koscielniak
 * Student ID: 041062261
 * Program:
 * Course:
 * Lab Section:
 * 
 */

// ===================== class starts here=============================
class Node {
	public int mData; // data item
	public Node next; // next node in list
	public Node previous; // previous node in list
	// -------------------------------------------------------------

	public Node(int d) // constructor
	{
		mData = d;
	}

	// -------------------------------------------------------------
	// display this node data
	public void displayNode() {
		System.out.print(mData + " ");
	}
	// -------------------------------------------------------------
} // end class Node

// ===================== class design starts here =============================
class DoublyLinkedList {
	private Node first;
	private Node last;

	// -------------------------------------------------------------
	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	// -------------------------------------------------------------
	public boolean isEmpty() {
		return first == null;
	}

	// -------------------------------------------------------------
	public void insertFirst(int num) {
		Node newNode = new Node(num);

		// write your code here

	}

	// -------------------------------------------------------------
	public void insertLast(int num) {
		// write your code here
	}

	// insert newNumber just after numToFind
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)

		// write your code here
		
	}

	// ------------------------------------------------// delete first node

	public Node deleteFirstNode() {

		// write your code here

	}

	// -----------------------------------------------// delete last node

	public Node deleteLastNode() {

		// write your code here

	}

	// -------------------------------------------------------------

	// -----------------------------------------finds, deletes and returns the node
	// that contains the given int value
	public Node searchAndDelete(int number) {

		// write your code here

	}

	// -------------------------------------------display data from first node to
	// last node
	public void printForwards() {

		// write your code here

	}

	// -------------------------------------------display data from last node to
	// first node
	public void printBackwards() {

		// write your code here

	}
	// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
