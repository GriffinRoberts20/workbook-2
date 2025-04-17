package com.pluralsight;

import java.util.Scanner;

public class AddressBuilder {
    static Scanner scanner=new Scanner(System.in);
    static StringBuilder addressBuilder=new StringBuilder();
    public static void main(String[] args) {
        System.out.println("Please provide the following information:");
        System.out.print("Full name: ");
        addressBuilder.append(scanner.nextLine().trim());

        String billingAddress=getAddress("Billing");
        String shippingAddress=getAddress("Shipping");
        addressBuilder.append("\n\n");
        addressBuilder.append(billingAddress);
        addressBuilder.append("\n\n");
        addressBuilder.append(shippingAddress);
        System.out.println("-----------------------------");
        //new solution ^

        //old solution v
        /*System.out.print("\nBilling Street: ");
        addressBuilder.append("\n\nBilling Address:\n"+scanner.nextLine().trim()+"\n");
        System.out.print("Billing City: ");
        addressBuilder.append(scanner.nextLine().trim()+", ");
        System.out.print("Billing State: ");
        addressBuilder.append(scanner.nextLine().trim()+" ");
        System.out.print("Billing Zip: ");
        addressBuilder.append(scanner.nextLine().trim());
        System.out.print("\nShipping Street: ");
        addressBuilder.append("\n\nShipping Address:\n"+scanner.nextLine().trim()+"\n");
        System.out.print("Shipping City: ");
        addressBuilder.append(scanner.nextLine().trim()+", ");
        System.out.print("Shipping State: ");
        addressBuilder.append(scanner.nextLine().trim()+" ");
        System.out.print("Shipping Zip: ");
        addressBuilder.append(scanner.nextLine().trim());*/

        String address=addressBuilder.toString();
        System.out.print(address);
    }
    //takes address type as input and prompts user for info to add address to string builder
    public static String getAddress(String addressType){
        StringBuilder address=new StringBuilder();
        System.out.print("\n"+addressType+" Street: ");
        address.append(addressType).append(" Address:\n").append(scanner.nextLine().trim()).append("\n");
        System.out.print(addressType+" City: ");
        address.append(scanner.nextLine().trim()).append(", ");
        System.out.print(addressType+" State: ");
        address.append(scanner.nextLine().trim()).append(" ");
        System.out.print(addressType+" Zip: ");
        address.append(scanner.nextLine().trim());
        return address.toString();
    }
}
