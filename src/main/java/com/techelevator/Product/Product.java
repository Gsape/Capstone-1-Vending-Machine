package com.techelevator.Product;

import com.techelevator.Money;

import java.math.BigDecimal;

public abstract class Product {
    private String name;
    private String cost;
    private String slotLocation;
    private int stock;
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
}

