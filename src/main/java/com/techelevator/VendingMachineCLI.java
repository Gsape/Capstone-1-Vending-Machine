package com.techelevator;

import com.techelevator.Product.*;
import com.techelevator.UI.Inventory;
import com.techelevator.UI.Menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Vending Machine Command Line Interface application
public class VendingMachineCLI {

	public static void main(String[] args) {
		// Make some objects here!

		//Ok this is a bit redundant here I think we're creating an inventory object but also an arraylist of chip objects
		Inventory actualInventory = new Inventory();

		ArrayList<Product> arrayedListInventory = new ArrayList<>();
		arrayedListInventory = actualInventory.createInventory();
		System.out.println(arrayedListInventory.get(0).getName());
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
		String userResponseMainMenu = "0";




		//bunch of object array list tests
//		int stockInStock = arrayedInventoryChips.get(0).getStock();
//		System.out.println(stockInStock);


		//TODO couple of options to go from here
			/*
			- We could do a few if statements to decide the movement
			- We could set up a switch statement
			 */
		//TODO While userResponseMainMenu = 3

		//TODO remember when feeding money to feed a double or string then convert
		while(userResponseMainMenu != "3"){
			System.out.println("Main Main Menu");
			System.out.println("Please select one below");
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			userResponseMainMenu = input.nextLine();

			if (userResponseMainMenu.equals("1")){
				actualInventory.printInventory();
//			actualInventory.getInventory();
//			System.out.println("Are we here ????");

			}
			if(userResponseMainMenu.equals("2")){
				String userResponsePurchaseMenu = "0";
				System.out.println("purchase menu");
				System.out.println("Please select one below");
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction ");
				System.out.println("Current Money Provided: " + userBalance.getBalance());
				//TODO this is where we need to get back to the purchase menu not main menu - preferably without whileCEPTION

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
						//double moneyInsertedAsDouble = Double.parseDouble(moneyInserted);
						BigDecimal moneyInsertedAsBD = new BigDecimal(moneyInserted);

//						double moneyInsertedAsDouble = Double.parseDouble(moneyInserted);
					System.out.println(moneyInsertedAsBD + "You just inserted");
						userBalance.feedMoney(moneyInsertedAsBD);
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
						System.out.println("Here is the inventory");
						actualInventory.printInventory();
						System.out.println("Select product code");
						//todo validation
						String userProductChoice = input.nextLine();
						System.out.println("You selected " + userProductChoice);

						//need iterate thru arrayedListInventory.getSlotLocation && compare to userProductChoice
						for(Product singleItem : arrayedListInventory) {//index
							//CALL money w/  userBalance.getBalance to start validation
							if (singleItem.getSlotLocation().equals(userProductChoice)) {
								System.out.println("Checking for stock");
//								singleItem.inStock(singleItem);
//								if (singleItem.inStock(singleItem)) {
//									System.out.println("removing one item from stock");
//									singleItem.removeStock(singleItem);
//								} else {
//									System.out.println("sold out");
//								}
//								System.out.println("Checking funds");
//								userBalance.checkFunds(userBalance, singleItem);
							if (singleItem.inStock(singleItem) && userBalance.checkFunds(userBalance, singleItem)){
								singleItem.removeStock(singleItem, userBalance);
								System.out.println(userBalance.getBalance() + "zeros");
								userBalance.subtractTransactionCost(singleItem);
								System.out.println(userBalance.getBalance() + "here");

							}

							}




						}

						/*
						userBalance.getBalance();
						if balance available to transact feed userProductChoice as an object to Money

						 */

//						System.out.println("transaction stuff happening behind scenes");
//						userResponseMainMenu = "0";
						userResponsePurchaseMenu = "3"; // this exits to the MAIN //todo fix to purchase
//						userResponseMainMenu = "3";
						//Go back to purchase menu - not main - bc if want to purchase more
						//Finish transaction takes you back to MAIN to choose exit
						/*
						-validate user chose A-4 / D-4 (if code does not exist)
						-check if sold out - if so informed and return purchase menu
						-if valid remove stock remove balance
						-we will need an arraylist for LOG later. - so pop something in there when purchase
						-print if candy gum etc noise
						-after dispense update balance and return customer to purchase menu (with break at end)
						 */
					}

				}
			}
			if(userResponseMainMenu.equals("3")){
				System.out.println("EXITING");
				break;

			}

		}

	}
}