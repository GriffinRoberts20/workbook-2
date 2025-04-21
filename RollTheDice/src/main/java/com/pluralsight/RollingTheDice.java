package com.pluralsight;

public class RollingTheDice {

    public static void main(String[] args) {
        Dice dice=new Dice();
        int roll1=0;
        int roll2=0;
        int twoCounter=0;
        int fourCounter=0;
        int sixCounter=0;
        int sevenCounter=0;
        for(int i=1;i<101;i++){
            roll1=dice.roll();
            roll2=dice.roll();
            int sum=roll1+roll2;
            System.out.printf("Roll %d: %d - %d Sum:%d\n",i,roll1,roll2,sum);
            if(sum==2){
                twoCounter++;
            }
            else if(sum==4){
                fourCounter++;
            }
            else if(sum==6){
                sixCounter++;
            } else if (sum==7) {
                sevenCounter++;
            }
        }
        System.out.printf("# of\n2's:%d\n4's:%d\n6's:%d\n7's:%d",twoCounter,fourCounter,sixCounter,sevenCounter);
    }
}
