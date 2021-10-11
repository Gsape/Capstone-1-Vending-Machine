package com.techelevator.Product;

import com.techelevator.Money;

public class Chips extends Product {
    public Chips(String name, String cost, int stock, String slotLocation) {
        super(name, cost, stock, slotLocation);
    }


    @Override
    public void returnMessage(Product stockToRemove, Money userBalance){
        String printOut = stockToRemove.getName() + " $" + stockToRemove.getCost() + " $" + userBalance.getBalance() + " Crunch crunch, Yum!";
        System.out.println(printOut);
    }
}
