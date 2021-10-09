package com.techelevator.UI;
//TODO things we dont wanna forget / push off / next in line to attack after we solve the object issue - which I kind of solved but need to do a major refactor sadly

//Inventory
    /*
    -I want to rework this and maybe use the menu for the actual menu stuff (i forgot about this class when building earlier)
        - not 100% necessary or priority but if we have time we should move the whole prompt to Menu


     -Inventory rework
        -create new inventory on CLI with new Inventory() - we should only need to do this once per running the program
           -have the constructor call create inventory?? - kind of doing this now partially'


        -Actually figure logic between creating objects and giving names in loop

     */





//Functionality of transactions
            /*
            -check to see if we have enough money
            -check to see if enough stock
            -if both OK
                -remove from user balance
                -remove from stock
                -add to log (all info)
             -
             */

import com.techelevator.Product.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
    String[] splitLineAtBar;
    ArrayList<Product> arrayListOfProducts = new ArrayList<>();

    Chips chips;
    Beverage beverages;
    Gum gums;
    Candy candies;

//couple ideas for our object issue. we could just return some sort of collection of objects in the creation method
    //or
    //create an empty collection (hash map / array / arraylist whatever) then pass that into the creation fill it up and return it
    //idk just rambling ideas to get them out and on paper for tomorrow
    public Inventory(){
        //this would allow us to remove the redundancy we have on the CLI at the moment
        //TODO deal with this unnessary redundancy
    }

    public ArrayList<Product> createInventory() {
        String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
        File csvWeAreReading = new File(filename);
//        System.out.println("Do we make it here?");
        //We shouldn't need to run any file verification - again this is bc we are giving the file - no user input needed on this portion
        //Test to see if the file reading is working - just simple print line from file
        //while file has a line print it out
        //We shouldn't need to run any file verification - again this is bc we are giving the file - no user input needed on this portion
        //Test to see if the file reading is working - just simple print line from file
        //while file has a line print it out
        try (Scanner fileScanner2 = new Scanner(csvWeAreReading)) {
            while (fileScanner2.hasNextLine()) {
                String currentLine = fileScanner2.nextLine();
//                System.out.println(currentLine);
                splitLineAtBar = currentLine.split("\\|");
//                System.out.println("should be 16 prints");
                //
//                System.out.println(splitLineAtBar + "inside while");
                //if splitLineAtBar[3] == chips
//                System.out.println(arrayListOfProducts.size());

                String productType = splitLineAtBar[3];
//                    System.out.println(splitLineAtBar[3]);
                String slotPosition = splitLineAtBar[0];
                String itemName = splitLineAtBar[1];
                String itemCost = splitLineAtBar[2];
//
//                System.out.println(splitLineAtBar[3]);
                if(productType.equals("Chip")){
                    chips = new Chips(itemName, itemCost,5, slotPosition);
                    arrayListOfProducts.add(chips);
//                    System.out.println("test is it in the ifs");
                }
                if(productType.equals("Drink")){
                    beverages = new Beverage(itemName, itemCost,5, slotPosition);
                    arrayListOfProducts.add(beverages);
                }
                if(productType.equals("Gum")){
                    gums = new Gum(itemName, itemCost,5, slotPosition);
                    arrayListOfProducts.add(gums);
                }
                if(productType.equals("Candy")){
                    candies = new Candy(itemName, itemCost,5, slotPosition);
                    arrayListOfProducts.add(candies);
                }
//

//                System.out.println(Arrays.toString(splitLineAtBar)); //COMPLETELY RANDOM SIDE NOTE - just came to me we could do a dirty way to figure out what type of object we'll be creating by looking at the last char on each line lol
                //^^ these few lines are just to test file access / reading
                //I know we talked about doing a map for the each product but I just threw the array in real quick to test

                //TODO From here we need to start creating the product so I'm gonna hop over and build out a little of the product / subclasses
            }
        } catch (FileNotFoundException e) {
            System.out.println("The only way file not found hits if I messed up the filepath which is entirely likely - so this stays for now");
        }
//        System.out.println(splitLineAtBar + "split line at bar array");
//        System.out.println(arrayListOfProducts + "arraylist of products as address");
//        for(int i = 0; i <= arrayListOfProducts.size(); i++){

//                    products = new Chips(itemName, itemCost,5, slotPosition);
////                    System.out.println(currentLine);
//                    arrayListOfProducts.add(products);
//                    System.out.println("Is this printing 5 times");
//        }

//        for(Product chipsinside : arrayListOfProducts){
//            System.out.println(chipsinside.getName()  + "test did it work");
//        }
//        int stockInStock = arrayListOfProducts.get(0).getStock();
//        System.out.println(stockInStock);
//        System.out.println("did we make it");
//        System.out.println(arrayListOfProducts.get(0).getName());
        System.out.println(arrayListOfProducts.size() + "is this runnning twice?");
        return arrayListOfProducts;


    }

    public void printInventory(){
        for (Product insideOfArray : arrayListOfProducts){
            System.out.println(insideOfArray.getSlotLocation()+ " " +insideOfArray.getName() + " " + insideOfArray.getCost() + " " + insideOfArray.getStock());
        }
//        for(String inside : splitLineAtBar){
////            System.out.println(inside);
//        }

    }
}
/* \
//Pull in the csv - we can hard code this as a string bc it is given - we do not need to ask the user for file location (like previous assignments)
        //TODO fix the filepath - I guess I could just use the absolute for testing purposes
//        String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
        String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
        File csvWeAreReading = new File(filename);
        //We shouldn't need to run any file verification - again this is bc we are giving the file - no user input needed on this portion
        //Test to see if the file reading is working - just simple print line from file
        //while file has a line print it out
        try (Scanner fileScanner = new Scanner(csvWeAreReading)) {
            while (fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                System.out.println(currentLine);
                String[] splitLineAtBar = currentLine.split("\\|");
                System.out.println(Arrays.toString(splitLineAtBar)); //COMPLETELY RANDOM SIDE NOTE - just came to me we could do a dirty way to figure out what type of object we'll be creating by looking at the last char on each line lol
                //^^ these few lines are just to test file access / reading
                //I know we talked about doing a map for the each product but I just threw the array in real quick to test

                //TODO From here we need to start creating the product so I'm gonna hop over and build out a little of the product / subclasses
            }
        } catch (FileNotFoundException e) {
            System.out.println("The only way filenotfound hits if I messed up the filepath which is entirely likely - so this stays for now");
        }





scanner read csv

FYI, the input file for the Vending machine is pipe delimited e.g A1|Potato Crisps|3.05|Chip
When you process the file, you may need to split the line up so you can work with each item individually. Splitting Strings is done with Regular Expressions and pipes are a reserved character for Regular Expressions. So, to split on a pipe, you must escape it using a backslash. And to get a backslash character in a String, you must escape it too. That leaves us with "\\|" to result in \|
tl;dr
myLineOfStuff.split("\\|")

for every line create object based on type 

loop and populate inventory


 */

