package com.techelevator;

import com.techelevator.Product.*;
import com.techelevator.UI.Inventory;
import com.techelevator.UI.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!

		//Ok this is a bit redundant here I think we're creating an inventory object but also an arraylist of chip objects
		Inventory actualInventory = new Inventory();

		ArrayList<Product> arrayedInventoryChips = new ArrayList<>();
		arrayedInventoryChips = actualInventory.createInventory();
		System.out.println(arrayedInventoryChips.get(0).getName());
		Menu newTestMenu = new Menu();

//		Beverage bev1 = new Beverage("Cola", "1.25",5);
//		Beverage bev2 = new Beverage("Dr. Salt", "1.50",5);
//		Beverage bev3 = new Beverage("Mountain Melter", "1.50",5);
//		Beverage bev4 = new Beverage("Heavy", "1.50",5);
//		Chips chip1 = new Chips("Potato Crisps", "3.05",5);
//		Chips chip2 = new Chips("Stackers", "1.45",5);
//		Chips chip3 = new Chips("Grain Waves", "2.75",5);
//		Chips chip4 = new Chips("Cloud Popcorn", "3.65",5);
//		Gum gum1 = new Gum("U-Chews", "0.85",5);
//		Gum gum2 = new Gum("Little League Chew", "0.95",5);
//		Gum gum3 = new Gum("Chiclets", "0.75",5);
//		Gum gum4 = new Gum("Triplemint", "0.75",5);
//		Candy candy1 = new Candy("Moonpie", "1.80",5);
//		Candy candy2 = new Candy("Cowtales", "1.50",5);
//		Candy candy3 = new Candy("Wonka Bar", "1.50",5);
//		Candy candy4 = new Candy("Crunchie", "1.75",5);

		//lets take all product objects and create 4 hash maps for each item type

		//Start of CLI interface that will be shown to user as well as getting input
		Scanner input = new Scanner(System.in);
		Money userBalance = new Money();
		System.out.println("------Vendo-Matic 800------");





		//bunch of object array list tests
//		int stockInStock = arrayedInventoryChips.get(0).getStock();
//		System.out.println(stockInStock);






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
						-Print inventory OK*
						-Pick item by slot location
						-keep track of total per item (starts @ 5)
						 */
//						Beverage testDrink = new Beverage("Coke", "3.0",  5);
//						System.out.println(testDrink.getCost());
//						System.out.println(testDrink.getStock() + " stock");
//						System.out.println(testDrink.getName());
						actualInventory.printInventory();

						break;
					}

				}
			}
		}

	}
}
