package com.techelevator.Product;

import com.techelevator.Money;

public class Beverage extends Product{

    public Beverage(String name, String cost, int stock, String slotLocation) {
        super(name, cost, stock, slotLocation);

        //TODO thought came to me - we should maybe be taking in the slot location
            //or not it's late and im a little tired/confused
    }

    @Override
    public void returnMessage(Product stockToRemove, Money userBalance){
        System.out.println(stockToRemove.getName() + " $" + stockToRemove.getCost() + " $" + userBalance.getBalance() + " Glug Glug, Yum!");
    }

}
