package com.techelevator;

import com.techelevator.Product.Beverage;
import com.techelevator.UI.Inventory;

import java.util.Scanner;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!
		Inventory actualInventory = new Inventory();
		actualInventory.createInventory();

		//Start of CLI interface that will be shown to user as well as getting input
		Scanner input = new Scanner(System.in);
		Money userBalance = new Money();
		System.out.println("------Vendo-Matic 800------");
		System.out.println("Please select one below");
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
			actualInventory.printInventory();
//			actualInventory.getInventory();
//			System.out.println("Are we here ????");
		}
		//TODO remember when feeding money to feed a double or string then convert
		while(userResponseMainMenu != "3"){
			if(userResponseMainMenu.equals("2")){
				String userResponsePurchaseMenu = "0";
				System.out.println("Please select one below");
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction ");
				System.out.println("Current Money Provided: " + userBalance.getBalance());
				userResponsePurchaseMenu = input.nextLine();
				while(userResponsePurchaseMenu != "3"){ //TODO THIS IS STILL AN INFINITE LOOP - COME BACK TO FIX
					//TODO validation for not choosing correct
					if(userResponsePurchaseMenu.equals("1")){
						System.out.println("Please feed in money in whole dollar amounts $1, $2, $5, $10");
						System.out.println("How much are you feeding? ");
						//TODO input validation required
						String moneyInserted = input.nextLine();
//					System.out.println(moneyInserted);
						//convert from string to double
						//update balance by calling feedMoney(moneyInserted<---as a double)
						double moneyInsertedAsDouble = Double.parseDouble(moneyInserted);
//					System.out.println(moneyInsertedAsDouble);
						userBalance.feedMoney(moneyInsertedAsDouble);
						System.out.println("Current Money Provided: " + userBalance.getBalance());
						break;
					}
					if(userResponsePurchaseMenu.equals("2")){
						/*
						-Print inventory
						-Pick item by slot location
						-keep track of total per item (starts @ 5)
						 */
//						Beverage testDrink = new Beverage("Coke", "3.0",  5);
//						System.out.println(testDrink.getCost());
//						System.out.println(testDrink.getStock() + " stock");
//						System.out.println(testDrink.getName());
						break;
					}

				}
			}
		}

	}
}
