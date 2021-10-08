package com.techelevator.UI;
//I think we need to have this all under the com.techelevator then inside of product, I believe

import com.techelevator.Product.Gum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
    String[] splitLineAtBar;


    public Inventory(){
        File csvWeAreReading = new File(filename);
        //We shouldn't need to run any file verification - again this is bc we are giving the file - no user input needed on this portion
        //Test to see if the file reading is working - just simple print line from file
        //while file has a line print it out
        try (Scanner fileScanner = new Scanner(csvWeAreReading)) {
            //Just create the scanner
            System.out.println("File opened");
        } catch (FileNotFoundException e) {
            System.out.println("The only way file not found hits if I messed up the filepath which is entirely likely - so this stays for now");
        }
    }



    public void createInventory() {
        String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
        File csvWeAreReading = new File(filename);
//        System.out.println("Do we make it here?");
        //We shouldn't need to run any file verification - again this is bc we are giving the file - no user input needed on this portion
        //Test to see if the file reading is working - just simple print line from file
        //while file has a line print it out
        try (Scanner fileScanner2 = new Scanner(csvWeAreReading)) {
            while (fileScanner2.hasNextLine()) {
                String currentLine = fileScanner2.nextLine();
//                System.out.println(currentLine);
                splitLineAtBar = currentLine.split("\\|");
//                System.out.println(splitLineAtBar);
                //for i=
                //Chips i = new Chip()
//                Chips potatoCrisps = new Chips(potatoCrisps, 3.50, 5);
                for(int i = 0; i < 5; i++){
                    String productType = splitLineAtBar[3];
//                    System.out.println(splitLineAtBar[3]);
                    String slotPosition = splitLineAtBar[0];
                    String itemName = splitLineAtBar[1];
                    String itemCost = splitLineAtBar[2];
                    Gum testGumName = new Gum(itemName, itemCost, 5);
//                    System.out.println(testGumName.getCost());
//                    System.out.println(testGumName.getStock() + " stock");
//                    System.out.println(testGumName.getName());
                }



//                switch (variable or an integer expression)
//                {
//                    case constant:
//                        //Java code
//                        ;
//                    case constant:
//                        //Java code
//                        ;
//                    default:
//                        //Java code
//                        ;
//                }


//                System.out.println(Arrays.toString(splitLineAtBar)); //COMPLETELY RANDOM SIDE NOTE - just came to me we could do a dirty way to figure out what type of object we'll be creating by looking at the last char on each line lol
                //^^ these few lines are just to test file access / reading
                //I know we talked about doing a map for the each product but I just threw the array in real quick to test

                //TODO From here we need to start creating the product so I'm gonna hop over and build out a little of the product / subclasses
            }
        } catch (FileNotFoundException e) {
            System.out.println("The only way file not found hits if I messed up the filepath which is entirely likely - so this stays for now");
        }
    }

    public void printInventory(){
        System.out.println(Arrays.toString(splitLineAtBar));
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

