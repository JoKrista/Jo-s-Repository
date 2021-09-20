/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class LuckySevens {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        
        
        int bet; //money that user is betting
        int rollsTillBroke = 0; //how many rolls in total before becoming a destitute
        int timeToQuit = 0; //the specific roll number that the user has the most money
        
        System.out.println("How much money would you like to bet?");
        
        bet = userInput.nextInt();
        userInput.nextLine();
        
        int wouldHaveWon = bet; //the highest amount of money that has been won
        //was originally in the wrong place right below rollsTillBroke
        //where a certain line of code is can make a whole lot of difference
        
        while(bet > 0){//this was initially an if but it was making the code 
                        //stop even before all the money had been spent
            int diceSum = rngEsus() + rngEsus();
            rollsTillBroke++;
            if(diceSum == 7){
                bet += 4;
                if(bet > wouldHaveWon){
                    wouldHaveWon = bet;
                    timeToQuit++;
                    //wouldHaveWon = timeToQuit; just tried this part out just in case
                    // but it was not helping me track what roll was my highest number
                    //wonder why? It was making me quit the game before I reach 0 money
                }
                
            }else{
                bet -= 1;
            }
            
            
            
        }
        
        System.out.println("You were kicked out of the casino after "+ rollsTillBroke + " rolls");
        System.out.println("Maybe you should have quit after "+ timeToQuit + " rolls.");
        System.out.println("The best that luck have given you was "+ wouldHaveWon);
        
       
    }
    public static int rngEsus(){
           Random rngLuck = new Random();
           return rngLuck.nextInt(6) + 1;
        }
    //I did not use a method but use just Random originally. It was messy :D
}
