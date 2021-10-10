package com.techelevator;

import com.techelevator.Product.Product;

import java.math.BigDecimal;

public class Money {
    //here is where we can deal with the money fed into the machine
    //do we want to do the transactions?
    private BigDecimal moneyFed = new BigDecimal(0);
    private BigDecimal balance = new BigDecimal(0); //used in "Current money provided: $2.00"
    private BigDecimal totalMoneyFed = new BigDecimal(0);
    private BigDecimal costAsBD = new BigDecimal(0);


    public Money () {
    }
/*
methods:
    //create method to take in userProductChoice as an object
 */
    public void feedMoney (BigDecimal moneyFed){
        this.moneyFed = moneyFed;
        balance = balance.add(moneyFed);
    }

    public BigDecimal getMoneyFed(){
        //totalMoneyFed += moneyFed;
        return totalMoneyFed;
    }

    public boolean checkFunds(Money usersBalance, Product itemPurchased) {
        System.out.println("hey we're gonna make sure you have enough");
        int resultOFComparison = usersBalance.getBalance().compareTo(itemPurchased.getCostBD());
//        System.out.println(resultOFComparison + "this is our RESULT PRINTLINE");

        if(resultOFComparison < 0 ) {
            System.out.println("You're broke");
            return false;
        }

        return true;



            /*
            firstBigDecimal.compareTo(secondBigDecimal) < 0 // "<"
    firstBigDecimal.compareTo(secondBigDecimal) > 0 // ">"
    firstBigDecimal.compareTo(secondBigDecimal) == 0 // "=="
    firstBigDecimal.compareTo(secondBigDecimal) >= 0 // ">="
             */


//        if (usersBalance.getBalance() < Double.parseDouble(itemPurchased.getCost())){
////            System.out.println("broke bitch");
//            return false;
//        }
    }

    public void subtractTransactionCost(Product itemPurchased){
//       balance -=  Double.parseDouble(itemPurchased.getCost());
       BigDecimal costAsBD = new BigDecimal(itemPurchased.getCost());
       balance = balance.subtract(costAsBD);
    }

    public BigDecimal getBalance(){
        return balance;
    }
    /*
    public bigDecimal changeReturned(BD balance){

        do all the math

    }
     */

    /*
    public double
     */



}
