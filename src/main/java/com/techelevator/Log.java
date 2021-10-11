package com.techelevator;

import com.techelevator.Product.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Log {

    Money userBalance = new Money();
    public Log(Money userBalance) {
        this.userBalance = userBalance;
    }

    //Methods:
    /*
        -write to file
        -collectionTime --- needs to collect date time action (feed $$ or what is fed out) current balance
     */

    public void writeToFileMoney(BigDecimal moneyFed){
        LocalDateTime dateObject = LocalDateTime.now();
        DateTimeFormatter patternToFormatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        String formattedDateTime = dateObject.format(patternToFormatDateTime);
        try(FileWriter fileWriter = new FileWriter("outPutFile.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(formattedDateTime + " FEED MONEY: $" + moneyFed + " $" +userBalance.getBalance());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeToFileTransaction(Product productBought){
        LocalDateTime dateObject = LocalDateTime.now();
        DateTimeFormatter patternToFormatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        String formattedDateTime = dateObject.format(patternToFormatDateTime);
        try(FileWriter fileWriter = new FileWriter("outPutFile.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(formattedDateTime + " " + productBought.getName() + " " + productBought.getSlotLocation() +" $" + userBalance.getBalance() + " $" +(userBalance.getBalance().subtract(productBought.getCostBD()))); //this isn't ideal lol
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeToFileChange(){
        LocalDateTime dateObject = LocalDateTime.now();
        DateTimeFormatter patternToFormatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss a");
        String formattedDateTime = dateObject.format(patternToFormatDateTime);
        try(FileWriter fileWriter = new FileWriter("outPutFile.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(formattedDateTime + " GIVE CHANGE: $" + userBalance.getBalance() + " $0.00"); //this 0 is hardcoded because we haven't addressed the issue with userBalance not truly updating --- but this was before the Great OOP revelation of Oct. 10 2021 hahahah
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}



/*
IDEAS FOR LOG:

Requirements:

DATE //////// TIME ////////// ACTION://///////// BALANCE BEFORE ////// BALANCE AFTER
DATE //////// TIME ////////// ACTION://///////// BALANCE BEFORE ////// BALANCE AFTER
DATE //////// TIME ////////// ACTION://///////// BALANCE BEFORE ////// BALANCE AFTER
DATE //////// TIME ////////// ACTION://///////// BALANCE BEFORE ////// BALANCE AFTER
DATE //////// TIME ////////// ACTION://///////// BALANCE BEFORE ////// BALANCE AFTER

10/10/2021 2:00:00 PM FEED MONEY


Rather than print to file @ time of interaction collect an array/arraylist/ of all changes
    -So at end of feedMoney, when validatin if in stock and userhas funds, giveChange
    -needs
        -import date/time
    -arguments
    -constructor?
    -methods
        -openAndWriteToFile(object arraylist someShitWeDid)
        -addActionToList(String?)   <----how do we want to do this? We can pass it in an entire string of what is going on or pass it some sort of object and make a string from it?






 */

    /*
    Code snippet taken from w3 schools to help create the date formatter ---- however also had to got o oracle docs to read about ofPattern to get the AM/PM printing.
    https://www.w3schools.com/java/java_date.asp
    LocalDateTime myDateObj = LocalDateTime.now();
    System.out.println("Before formatting: " + myDateObj);
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    System.out.println("After formatting: " + formattedDate);
     */
