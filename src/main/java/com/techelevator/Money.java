package com.techelevator;

public class Money {
    //here is where we can deal with the money fed into the machine
    //do we want to do the transactions?
    private double moneyFed = 0;
    private double balance = 0; //used in "Current money provided: $2.00"

    public Money () {
    }

    public void feedMoney (double moneyFed){
        this.moneyFed = moneyFed;
        balance += moneyFed;
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
