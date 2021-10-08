package com.techelevator.Product;
//Ok we are going to use this class to create each of our items so lets go
public abstract class Product {
    private String name;
    private String cost;
    //couple private fields to be able to assign getters
        //note - these should not require setters as we are getting this data from the CSV
        //user does not have access to change any of this


    //TODO Constructor(s)? - do we need more than one?
    //I don't think so
    public Product(String name, String cost){
        this.name = name;
        this.cost = cost;
    }

    //getters for those fields
    public String getName() {
        return name;
    }
    public String getCost() {
        return cost;
    }//TODO - just a note I defaulted to string bc we have used this in the past but we may want to double this?
    //or just force a conversion when we need to math?
}
