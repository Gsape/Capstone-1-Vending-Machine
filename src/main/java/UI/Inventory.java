package UI;
//I think we need to have this all under the com.techelevator then inside of product, I believe

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        //Pull in the csv - we can hard code this as a string bc it is given - we do not need to ask the user for file location (like previous assignments)
        //TODO fix the filepath - I guess I could just use the absolute for testing purposes
        String filename = "C:\\Users\\Student\\workspace\\TE-Capstone-1\\java-capstone-module-1-team-0\\vendingmachine.csv";
        File csvWeAreReading = new File(filename);
        //We shouldn't need to run any file verification - again this is bc we are giving the file - no user input needed on this portion
        //Test to see if the file reading is working - just simple print line from file
        //while file has a line print it out
        try (Scanner fileScanner = new Scanner(csvWeAreReading)){
            while(fileScanner.hasNextLine()){
                String currentLine = fileScanner.nextLine();
                System.out.println(currentLine);
                String [] splitLineAtBar = currentLine.split("\\|");
                System.out.println(Arrays.toString(splitLineAtBar)); //COMPLETELY RANDOM SIDE NOTE - just came to me we could do a dirty way to figure out what type of object we'll be creating by looking at the last char on each line lol
                //^^ these few lines are just to test file access / reading
                //I know we talked about doing a map for the each product but I just threw the array in real quick to test

                //TODO From here we need to start creating the product so I'm gonna hop over and build out a little of the product / subclasses
            }
        } catch (FileNotFoundException e) {
            System.out.println("The only way filenotfound hits if I messed up the filepath which is entirely likely - so this stays for now");
        }
    }


}
/* scanner read csv

FYI, the input file for the Vending machine is pipe delimited e.g A1|Potato Crisps|3.05|Chip
When you process the file, you may need to split the line up so you can work with each item individually. Splitting Strings is done with Regular Expressions and pipes are a reserved character for Regular Expressions. So, to split on a pipe, you must escape it using a backslash. And to get a backslash character in a String, you must escape it too. That leaves us with "\\|" to result in \|
tl;dr
myLineOfStuff.split("\\|")

for every line create object based on type 

loop and populate inventory


 */

