package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheaterReservations {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {//app running
            String fullNameInput = "";
            String fullNameOutput = "";
            boolean gettingName = true;
            while (gettingName) {//getting the name
                System.out.print("Please enter your name(first last): ");
                try {//trying to split name based on expected format, any errors restart getting the name
                    fullNameInput = scanner.nextLine().trim();
                    String[] fullNameSplit = fullNameInput.split(" +");
                    if (fullNameSplit.length == 2) {//enforces the use of 2 names
                        fullNameOutput = fullNameSplit[1] + ", " + fullNameSplit[0];
                    } else {//error too many names entered
                        System.out.println("Error: invalid name.");
                        continue;
                    }
                } catch (Exception e) {//error: too few names entered
                    System.out.println("Error: invalid name.");
                    continue;
                }
                gettingName = false;
            }
            boolean gettingDate = true;
            String dateStr = "";
            DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            while (gettingDate) {//getting the date
                System.out.print("Please enter the date (MM/dd/yyyy): ");
                try {//try retrieving date based on given format, any errors restart getting the date
                    String dateInput = scanner.nextLine().trim();
                    LocalDate date = LocalDate.parse(dateInput, inputDateFormat);
                    dateStr = date.toString();
                } catch (Exception e) {//error:invalid date based on format
                    System.out.println("Error: invalid date.");
                    continue;
                }
                gettingDate = false;
            }
            boolean gettingTickets = true;
            while (gettingTickets) {//getting the tickets
                System.out.print("How many tickets: ");
                try {//try getting the number of tickets, making sure that the input is a number and is positive, any errors restarting getting the tickets
                    int tickets = scanner.nextInt();
                    scanner.nextLine();
                    if (tickets > 0) {//must have at least 1 ticket
                        if (tickets == 1) {//final output with 1 ticket
                            System.out.printf("\n%d ticket reserved for %s under %s.", tickets, dateStr, fullNameOutput);
                        } else {//final output with multiple tickets
                            System.out.printf("\n%d tickets reserved for %s under %s.", tickets, dateStr, fullNameOutput);
                        }
                    } else {//error:0 or less ticket amount entered
                        System.out.println("Error: invalid ticket amount.");
                        continue;
                    }
                } catch (Exception e) {//error:string or char entered
                    scanner.nextLine();
                    System.out.println("Error: invalid ticket input.");
                    continue;
                }
                gettingTickets = false;
            }
            running = false;
        }
    }
}
