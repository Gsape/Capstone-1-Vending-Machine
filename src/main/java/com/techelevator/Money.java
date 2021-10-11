package com.techelevator;

import com.techelevator.Product.Product;

import java.math.BigDecimal;

public class Money {
    //here is where we can deal with the money fed into the machine
    //do we want to do the transactions?
    private BigDecimal moneyFed = new BigDecimal(0);
    private BigDecimal balance = new BigDecimal(0); //used in "Current money provided: $2.00"
    private BigDecimal totalMoneyFed = new BigDecimal(0);
    private BigDecimal costAsBD = new BigDecimal(0); //delete?


    public Money() {
    }


    //methods:
    public void feedMoney(BigDecimal moneyFed) {
        this.moneyFed = moneyFed;
        balance = balance.add(moneyFed);
    }

    public boolean checkFunds(Money usersBalance, Product itemPurchased) {
//        System.out.println("hey we're gonna make sure you have enough");
        int resultOFComparison = usersBalance.getBalance().compareTo(itemPurchased.getCostBD());
        if (resultOFComparison < 0) {
            System.out.println("You're broke");
            return false;
        }
        return true;
    }

    public void subtractTransactionCost(Product itemPurchased) {
//       balance -=  Double.parseDouble(itemPurchased.getCost());
        BigDecimal costAsBD = new BigDecimal(itemPurchased.getCost());
        balance = balance.subtract(costAsBD);
    }

    public BigDecimal getBalance() {
        return balance;
    }

//    public void decreaseBalanceWithdraw(int coin){
//        //balance is BD we want subtract coin from balance
//        BigDecimal oneHundred = new BigDecimal("100");
//        balance.subtract(BigDecimal.valueOf(coin)).multiply(oneHundred);
//        //System.out.println(balance);
//    }

    public String changeReturned(BigDecimal balance) {
        String printoutPage = "";
        int quart = 25;
        int dime = 10;
        int nickle = 5;
        int quarterCount = 0;
        int dimeCount = 0;
        int nickleCount = 0;
        BigDecimal oneHundred = new BigDecimal("100");
        BigDecimal balanceBd = new BigDecimal(String.valueOf(balance.multiply(oneHundred)));
        int balanceAsInt100 = (balanceBd.intValue());
        while (balanceAsInt100 > 0) {

            if (balanceAsInt100 >= 25) {
                quarterCount++;
                balanceAsInt100 -= quart;
                //   decreaseBalanceWithdraw(quart);
            } else if (balanceAsInt100 >= 10) {
                dimeCount++;
                balanceAsInt100 -= dime;
            } else if (balanceAsInt100 >= 5) {
                nickleCount++;
                balanceAsInt100 -= nickle;
            }
        }
        printoutPage = quarterCount + " Quarters, " + dimeCount + " Dimes, " + nickleCount + " Nickles";
        return printoutPage;
    }
}
