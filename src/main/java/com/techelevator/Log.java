package com.techelevator;

import java.io.*;
import java.util.Scanner;


public class Log {

    Money userBalance = new Money();
//  File outPutFile = new File("outPutFile.txt");
    public Log(Money userBalance) {
        this.userBalance = userBalance;
    }

    //Methods:
    /*
        -write to file
        -collectionTime --- needs to collect date time action (feed $$ or what is fed out) current balance
     */

    public void writeToFile(){
        System.out.println("Time to write some stuff to file");

        //Turning this off for now because it works writing to file
        //I need to focus on getting the information from the other classes to this file
        try(FileWriter fileWriter = new FileWriter("outPutFile.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(userBalance.getBalance());
            printWriter.println("User balance should be above");
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


