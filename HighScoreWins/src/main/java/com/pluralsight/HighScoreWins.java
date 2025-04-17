package com.pluralsight;

import java.util.Scanner;

public class HighScoreWins {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        boolean gettingScore=true;
        while(gettingScore){
            System.out.print("What was the score? (Use format Team1:Team2|Score1:Score2): ");
            String fullScore = scanner.nextLine().trim();
            String[] nameScoreSplit=fullScore.split("\\|");
            if(nameScoreSplit.length==2){
                String[] nameSplit=nameScoreSplit[0].split(":");
                String[] scoreSplit=nameScoreSplit[1].split(":");
                if (nameSplit.length == 2 && scoreSplit.length == 2) {
                    String team1 = nameSplit[0];
                    String team2 = nameSplit[1];
                    int score1 = Integer.parseInt(scoreSplit[0]);
                    int score2 = Integer.parseInt(scoreSplit[1]);
                    String winner = (score1 > score2) ? team1 : (score2 > score1) ? team2 : "Tie";
                    System.out.println("Winner: " + winner);
                    gettingScore = false;
                }
                else{
                    System.out.println("Error: invalid input.");
                }
            }
            else{
                System.out.println("Error: invalid input.");
            }
        }
    }
}
