package com.techelevator;

import com.techelevator.Product.*;
import com.techelevator.UI.Inventory;
import com.techelevator.UI.Menu;

import java.lang.reflect.Array;
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
        Menu newTestMenu = new Menu(); //maybe keep if I get to move it into menu...

        //Start of CLI interface that will be shown to user as well as getting input
        Scanner input = new Scanner(System.in);
        Money userBalance = new Money();
        System.out.println("------Vendo-Matic 800------");
        String userResponseMainMenu = "0";

        while (userResponseMainMenu != "3") {
            System.out.println("Main Main Menu");
            System.out.println("Please select one below");
            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            userResponseMainMenu = input.nextLine();

            if (userResponseMainMenu.equals("1")) {
                actualInventory.printInventory();

            } else if (userResponseMainMenu.equals("2")) {
                String userResponsePurchaseMenu = "0";
                System.out.println("purchase menu");
                System.out.println("Please select one below");
                System.out.println("(1) Feed Money");
                System.out.println("(2) Select Product");
                System.out.println("(3) Finish Transaction ");
                System.out.println("Current Money Provided: " + userBalance.getBalance());
                userResponsePurchaseMenu = input.nextLine();
                boolean isResponseValid = false;

                if (userResponsePurchaseMenu.equals("1") || userResponsePurchaseMenu.equals("2") || userResponsePurchaseMenu.equals("3")) {
                    isResponseValid = true;
                }

                if (isResponseValid) {
                    if (userResponsePurchaseMenu.equals("1")) {

                        while (true) {
                            System.out.println("Please feed in money in whole dollar amounts $1, $2, $5, $10");
                            System.out.println("How much are you feeding? ");
                            String moneyInserted = input.nextLine();
                            try {
                                Integer test = Integer.parseInt(moneyInserted);
                            } catch (NumberFormatException e) {
                                System.out.println("Not valid");
                                break;
                            }

                            BigDecimal moneyInsertedAsBD = new BigDecimal(moneyInserted);

                            System.out.println(moneyInsertedAsBD + "You just inserted");
                            userBalance.feedMoney(moneyInsertedAsBD);
                            System.out.println("Current Money Provided: " + userBalance.getBalance());
                            break;
                        }
                    } else if (userResponsePurchaseMenu.equals("2")) {
						/*
						-Print inventory OK*
						-Pick item by slot location
						-keep track of total per item (starts @ 5)
						 */
                        actualInventory.printInventory();
                        System.out.println("Select product code");
                        String userProductChoice = input.nextLine();
                        String[] testSlot = new String[16];
                        for (int i = 0; i < 16; i++) {
                            testSlot[i] = arrayedListInventory.get(i).getSlotLocation();
                        }
                        for (String slot : testSlot) {
                            if (slot.equals(userProductChoice)) {
                                System.out.println("You selected " + userProductChoice);
                                //need iterate thru arrayedListInventory.getSlotLocation && compare to userProductChoice
                                for (Product singleItem : arrayedListInventory) {//index
                                    //CALL money w/  userBalance.getBalance to start validation
                                    if (singleItem.getSlotLocation().equals(userProductChoice)) {
//                                        System.out.println("Checking for stock");
                                        if (singleItem.inStock(singleItem) && userBalance.checkFunds(userBalance, singleItem)) {
                                            singleItem.removeStock(singleItem, userBalance);
//                                            System.out.println(userBalance.getBalance() + " User balance before transaction");
                                            userBalance.subtractTransactionCost(singleItem);
//                                            System.out.println(userBalance.getBalance() + " User balance after transaction");
                                        }
                                    }
                                }
                                userResponsePurchaseMenu = "3"; // this exits to the MAIN
                            }
                        }
                        System.out.println("Wrong!");
                    }
                } else {
                    System.out.println("You entered the wrong number!");
                }
            } else if (userResponseMainMenu.equals("3")) {
                System.out.println(userBalance.changeReturned(userBalance.getBalance()));
                System.out.println(userBalance.getBalance());
                System.out.println("EXITING");
                break;
            } else {
                System.out.println("You entered the wrong number!");

            }

        }

    }
}