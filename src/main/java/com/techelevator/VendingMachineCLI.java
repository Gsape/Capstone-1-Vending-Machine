package com.techelevator;

import java.util.Scanner;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!

		//Start of CLI interface that will be shown to user as well as getting input
		Scanner input = new Scanner(System.in);
		System.out.println("------Vendo-Matic 800------");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		String userResponseMainMenu = input.nextLine();
		//TODO couple of options to go from here
			/*
			- We could do a few if statements to decide the movement
			- We could set up a switch statement
			 */


	}
}
