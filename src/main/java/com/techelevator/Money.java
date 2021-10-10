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

    public void decreaseBalanceWithdraw(int coin){
        //balance is BD we want subtract coin from balance
       balance = balance.subtract(BigDecimal.valueOf(coin));
    }

    public String changeReturned(BigDecimal balance){
        String printoutPage = "";
//        int balanceAsInt = balance.intValue();
        int quart = 25;
        int dime = 10;
        int nickle = 5;

        BigDecimal balance100 = balance.multiply(BigDecimal.valueOf(100));
        int balanace100asInt = balance100.intValue();

        BigDecimal zeroAsBD = new BigDecimal(0);

        int quarterCount = 0;
        int dimeCount = 0;
        int nickleCount = 0;

        while (balanace100asInt > 0){
            if (balance100.compareTo(BigDecimal.valueOf(quart)) >= 1){
                quarterCount++;
//                balanceAsInt = balanceAsInt - 25;
//                System.out.println("here is your current balance ");
//                System.out.println("here is your current balance " + balanace100asInt);
                balance100.subtract(BigDecimal.valueOf(quart));
//                System.out.println("here is your current balance After " + balance);
                balanace100asInt -= quart;
                decreaseBalanceWithdraw(quart);

            }
//             if(balanceAsInt > 10){
//                dimeCount++;
//                balanceAsInt = balanceAsInt - 10;
//            }  if (balanceAsInt > 5) {
//                nickleCount++;
//                balanceAsInt = balanceAsInt - 5;
//            }
        }

         printoutPage = quarterCount + " Quarters " + "balanceAsInt" + " balance as INT";
        return printoutPage;
    }
    /*
    public bigDecimal changeReturned(BD balance){

        parse BD balance to int x 100

        int quart = 25
        int dime = 10
        int nickle = 5
        //TODO convert back by dividing by 100

       int quarterCount
       int dimeCount
       int nickleCount


        while (balance >= 0)


        **need new method for withdrawBalance()

        do all the math


        **** balance 20 ****
        while balance >= 0
           quarterCount ++
           balance-=25




    }
     */

    /*
    public double
     */



}
