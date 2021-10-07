package UI;

public class Inventory {
}
/* scanner read csv

FYI, the input file for the Vending machine is pipe delimited e.g A1|Potato Crisps|3.05|Chip
When you process the file, you may need to split the line up so you can work with each item individually. Splitting Strings is done with Regular Expressions and pipes are a reserved character for Regular Expressions. So, to split on a pipe, you must escape it using a backslash. And to get a backslash character in a String, you must escape it too. That leaves us with "\\|" to result in \|
tl;dr
myLineOfStuff.split("\\|")

for every line create object based on type 

loop and populate inventory


 */