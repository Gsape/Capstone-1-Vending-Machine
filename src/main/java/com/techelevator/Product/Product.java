package com.techelevator.Product;

import com.techelevator.Money;

import java.math.BigDecimal;

//Ok we are going to use this class to create each of our items so lets go
public abstract class Product {
    private String name;
    private String cost;
    private String slotLocation;
    private int stock; //always 5
    //couple private fields to be able to assign getters
        //note - these should not require setters as we are getting this data from the CSV
        //user does not have access to change any of this


    //TODO Constructor(s)? - do we need more than one?
    //I don't think so
    public Product(String name, String cost, int stock, String slotLocation){
        this.slotLocation = slotLocation;
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }

    //getters for those fields
    public String getName() {
        return name;
    }
    public String getCost() {
        return cost;
    }


    public BigDecimal getCostBD() {
        BigDecimal costAsBDFromStr = new BigDecimal(cost);
        return costAsBDFromStr;
    }
    public int getStock(){
        return stock;
    }
    public String getSlotLocation(){
        return slotLocation;
    }

    public boolean inStock(Product itemWanted){
        if(itemWanted.getStock() <=0){
            System.out.println("Sold out");
            return false;
        } else {
            return true;
        }
    }

    //
    public Product removeStock(Product stockToRemove, Money userBalance) {
        System.out.println(stockToRemove.getStock());
        stock--;
        System.out.println(stockToRemove.getStock());
        returnMessage(stockToRemove, userBalance);
        return stockToRemove;

    }

    public void returnMessage(Product stockToRemove, Money userBalance){
        //item name cost money remaining + message
        System.out.println(stockToRemove.getName() + " $" + stockToRemove.getCost() + " $" + userBalance.getBalance());
    }



    //TODO - just a note I defaulted to string bc we have used this in the past but we may want to double this?
    //or just force a conversion when we need to math?
}

