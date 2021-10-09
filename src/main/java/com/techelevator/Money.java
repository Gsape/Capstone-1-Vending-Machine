package com.techelevator;

import com.techelevator.Product.Product;

public class Money {
    //here is where we can deal with the money fed into the machine
    //do we want to do the transactions?
    private double moneyFed = 0;
    private double balance = 0; //used in "Current money provided: $2.00"
    private double totalMoneyFed = 0;
    public Money () {
    }


/*
methods:
    //create method to take in userProductChoice as an object
 */
    public void feedMoney (double moneyFed){
        this.moneyFed = moneyFed;
        balance += moneyFed;
        moneyFed = totalMoneyFed;
    }

    public double getMoneyFed(){
        totalMoneyFed += moneyFed;
        return totalMoneyFed;
    }

    public boolean checkFunds(Money usersBalance, Product itemPurchased) {
        System.out.println("hey we're gonna make sure you have enough");
        if (usersBalance.getBalance() < Double.parseDouble(itemPurchased.getCost())){
//            System.out.println("broke bitch");
            return false;
        }
        return true;
    }

    public void subtractTransactionCost(Product itemPurchased){
       balance -=  Double.parseDouble(itemPurchased.getCost());
    }

    public double getBalance(){
        return balance;
    }
    /*
    public double changeReturned(Double balance, Product item){
        do all the math

    }
     */

    /*
    public double
     */



}
