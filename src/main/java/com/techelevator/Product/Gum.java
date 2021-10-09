package com.techelevator.Product;

import com.techelevator.Money;

public class Gum extends Product{

    public Gum(String name, String cost, int stock, String slotLocation) {
        super(name, cost, stock, slotLocation);
    }

    @Override
    public void returnMessage(Product stockToRemove, Money userBalance){
        System.out.println(stockToRemove.getName() + " $" + stockToRemove.getCost() + " $" + userBalance.getBalance() + " Chew Chew, Yum!");
    }
}
