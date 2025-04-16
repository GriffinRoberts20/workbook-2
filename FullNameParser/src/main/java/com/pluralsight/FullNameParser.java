package com.pluralsight;

import java.util.Scanner;

public class FullNameParser {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        parseName();
    }
    public static void parseName(){
        System.out.println("Please enter your name in the format \"first last\" or \"first middle last\"");
        String fullName=scanner.nextLine().trim();//take user input, full next line, removing spaces from front and back
        String[] fullNameSplit=fullName.split(" +");//split name into parts on spaces, removing extra spaces
        String first=fullNameSplit[0];//set first name to first index
        byte i=1;//next index to be referenced
        String middle="(none)";//default middle name
        if(fullNameSplit.length>2){//check if user input middle name, and if they did set middle name to value at i(second index) and increment i to next index
            middle=fullNameSplit[i];
            i++;
        }
        String last=fullNameSplit[i];//set last name to value at index i
        System.out.printf("First name: %s\nMiddle name: %s\nLast name: %s",first,middle,last);
    }
}
