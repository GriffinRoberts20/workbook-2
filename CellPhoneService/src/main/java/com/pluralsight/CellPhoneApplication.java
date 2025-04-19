package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {

    static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
        boolean appRunning=true;
        while(appRunning){
            CellPhone[] phoneList = new CellPhone[2];
            phoneList[0]=createNewPhone();
            printDivider(30);
            phoneList[1] = createNewPhone();
            printDivider(30);
            phoneList[0].dial(phoneList[1].getPhoneNumber());
            while(appRunning){
                printDivider(30);
                //select cell phone to access
                int user=askQuestionGetInt("Which account would you like to access? (1)"+phoneList[0].getOwner()+" (2)"+phoneList[1].getOwner()+"\n")-1;
                //check that user is on list
                if(user<phoneList.length&&user>-1){
                    //select whether you want to update cell phone properties, display cell phone properties, or stop running
                    switch (nextAction()) {
                        case 1: {
                            printDivider(30);
                            updateProperty(phoneList[user]);
                            break;
                        }
                        case 2: {
                            printDivider(30);
                            display(phoneList[user]);
                            break;
                        }
                        case 3: {
                            appRunning = false;
                            break;
                        }
                        default: {
                            printDivider(30);
                            System.out.println("Error, invalid input.");
                        }
                    }
                }
                else{
                    printDivider(30);
                    System.out.println("Error: invalid user.");
                }
            }
        }
    }
    //input the question you want answered, returns answer, expects string
    public static String askQuestionGetString(String q){
        System.out.print(q);
        return scanner.nextLine();
    }
    //input the question you want answered, returns answer, expects integer
    public static int askQuestionGetInt(String q){
        boolean asking=true;
        int answer=-1;
        while(asking){
            try{
                System.out.print(q);
                answer = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                printDivider(30);
                System.out.println("Error: must enter a number.");
                printDivider(30);
                continue;
            }
            asking=false;
        }
        return answer;
    }
    //asks for and set cell phone properties, and returns cell phone object
    public static CellPhone createNewPhone(){
        CellPhone cell=new CellPhone();
        cell.setSerialNumber(askQuestionGetInt("What is the serial number? "));
        cell.setModel(askQuestionGetString("What model is the phone? "));
        cell.setCarrier(askQuestionGetString("Who is the carrier? "));
        cell.setPhoneNumber(askQuestionGetString("What is the phone number? "));
        cell.setOwner(askQuestionGetString("Who is the owner of the phone? "));
        return cell;
    }
    //prints cell phone's properties
    public static void display(CellPhone cell){
        System.out.println("Serial Number: "+cell.getSerialNumber());
        System.out.println("Model: "+cell.getModel());
        System.out.println("Carrier: "+cell.getCarrier());
        System.out.println("Phone Number: "+cell.getPhoneNumber());
        System.out.println("Owner: "+cell.getOwner());
    }
    //prints n character long "-" text divider
    public static void printDivider(int n){
        StringBuilder dividerBuilder=new StringBuilder();
        for(int i=0;i<n;i++){
            dividerBuilder.append("-");
        }
        System.out.println(dividerBuilder);
    }
    //select next action
    public static int nextAction(){
        int answer=askQuestionGetInt("Would you like to do anything else? (1)Update properties (2)Show properties (3)Stop\n");
        return answer;
    }
    //select property to update and update that property
    public static void updateProperty(CellPhone cell){
        boolean updatingProperty=true;
        while(updatingProperty){
            switch (askQuestionGetInt("Which property to update? (1)Serial Number (2)Model (3)Carrier (4)Phone Number (5)Owner\n")) {
                case 1: {
                    cell.setSerialNumber(askQuestionGetInt("Enter new Serial Number: "));
                    updatingProperty=false;
                    break;
                }
                case 2: {
                    cell.setModel(askQuestionGetString("Enter new Model: "));
                    updatingProperty=false;
                    break;
                }
                case 3: {
                    cell.setCarrier(askQuestionGetString("Enter new Carrier: "));
                    updatingProperty=false;
                    break;
                }
                case 4: {
                    cell.setPhoneNumber(askQuestionGetString("Enter new Phone Number: "));
                    updatingProperty=false;
                    break;
                }
                case 5: {
                    cell.setOwner(askQuestionGetString("Enter new Owner: "));
                    updatingProperty=false;
                    break;
                }
                default:{
                    System.out.println("Error:invalid input.");
                }
            }
        }
    }
}
