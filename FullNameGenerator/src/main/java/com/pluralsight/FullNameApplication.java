package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        String fullName=getFullName();
        System.out.print("Full name: "+fullName);
    }
    public static String getFullName(){
        System.out.println("Please enter your name");
        System.out.print("First name: ");
        String first=scanner.nextLine().trim();//retrieve first name, trim spaces
        System.out.print("Middle name: ");
        String middle=scanner.nextLine().trim();//retrieve middle name, trim spaces
        System.out.print("Last Name: ");
        String last=scanner.nextLine().trim();//retrieve last name, trim spaces
        System.out.print("Suffix: ");
        String suffix=scanner.nextLine().trim();//retrieve suffix, trim spaces
        String fullName="";
        fullName=fullName+first;//add first name to full name
        if(!middle.isEmpty()){//check if user had any input for middle name, if yes then add to full name
            fullName=fullName+" "+middle;
        }
        if(!last.isEmpty()){//check if user had any input for last name, if yes then add to full name
            fullName=fullName+" "+last;
        }
        if(!suffix.isEmpty()){//check if user had any input for suffix, if yes then add to full name
            fullName=fullName+", "+suffix;
        }
        return fullName;
    }
}
