package com.techelevator;

import com.techelevator.UI.Inventory;

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
		//TODO While userResponseMainMenu = 3
		if (userResponseMainMenu.equals("1")){
			Inventory actualInventory = new Inventory();
			actualInventory.getInventory();
//			System.out.println("Are we here ????");
		}
		//TODO remember when feeding money to feed a double or string then convert
		if(userResponseMainMenu.equals("2")){
			String userResponsePurchaseMenu = "0";
			System.out.println("(1) Feed Money");
			System.out.println("(2) Select Product");
			System.out.println("(3) Finish Transaction");
		}

	}
}
