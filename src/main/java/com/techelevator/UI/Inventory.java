package com.techelevator.UI;
import com.techelevator.Product.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
    String[] splitLineAtBar;
    ArrayList<Product> arrayListOfProducts = new ArrayList<>();

    Chips chips;
    Beverage beverages;
    Gum gums;
    Candy candies;

    public Inventory(){
    }

    public ArrayList<Product> createInventory() {
        File csvWeAreReading = new File(filename);
        try (Scanner fileScanner2 = new Scanner(csvWeAreReading)) {
            while (fileScanner2.hasNextLine()) {
                String currentLine = fileScanner2.nextLine();
                splitLineAtBar = currentLine.split("\\|");

                String productType = splitLineAtBar[3];
                String slotPosition = splitLineAtBar[0];
                String itemName = splitLineAtBar[1];
                String itemCost = splitLineAtBar[2];
                if(productType.equals("Chip")){
                    chips = new Chips(itemName, itemCost,5, slotPosition);
                    arrayListOfProducts.add(chips);
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
            }
        } catch (FileNotFoundException e) {
            System.out.println("The only way file not found hits if I messed up the filepath which is entirely likely - so this stays for now");
        }
        return arrayListOfProducts;
    }

    public void printInventory(){
        for (Product insideOfArray : arrayListOfProducts) {
            if (insideOfArray.getStock() == 0){
                System.out.println(insideOfArray.getSlotLocation()+ " " +insideOfArray.getName() + " " + insideOfArray.getCost() + " sold out!");
            } else {
                System.out.println(insideOfArray.getSlotLocation()+ " " +insideOfArray.getName() + " " + insideOfArray.getCost() + " " + insideOfArray.getStock());
            }
//

        }
    }
}
