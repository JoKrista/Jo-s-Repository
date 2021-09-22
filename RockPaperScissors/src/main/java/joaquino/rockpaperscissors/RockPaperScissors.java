/*
 * Author: Jo Aquino
 * Date submitted: September 20, 2021
 * 
 */
package joaquino.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class RockPaperScissors {
    public static void main(String[] args) {
        boolean keepPlaying = true;
        int numberOfRounds;
        do {
            numberOfRounds = getNumberOfRounds();
            
            if (numberOfRounds < 0 || numberOfRounds > 10) {
                System.out.println("How many rounds would you like to play with a maximum of 10 rounds?");
                System.out.println("That is not a valid number of rounds. Goodbye.");
                break;
            }
            
            playTheGame(numberOfRounds);//this limits the game to how many rounds the user has entered
            
            keepPlaying = shouldPlayAgain();//asks if user wants to play again after playTheGame has been fully executed
        } while (keepPlaying);
    }
    
    private static int getNumberOfRounds() {
        //ask how many rounds user wants to play
        // read console input and convert it into int with Integer.parseInt(userInput);
        System.out.println("How many rounds do you want to play?");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        return Integer.parseInt(userAnswer);
    }
    
    private static void playTheGame(int numberOfRounds) {
        
        int tie = 0;
        int win = 0;
        int lose = 0;
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int compHand;
        int user;
        boolean noMoreRounds = false;
         
        while(numberOfRounds > 0) {
   
            
            do{
               compHand = aiHand();
               user = userHand();
               if (user == compHand){
                   tie++;
                   System.out.println("It's a tie");
               }else if(user == 1 && compHand == 2){
                   lose++;
                   System.out.println("You lose");
               }else if(user == 1 && compHand == 3){
                   win++;
                   System.out.println("You win");
               }else if(user == 2 && compHand == 1){
                   win++;
                   System.out.println("You win");
               }else if(user == 2 && compHand == 3){
                   lose++;
                   System.out.println("You lose");
               }else if(user == 3 && compHand == 1){
                   lose++;
                   System.out.println("You lose");
               }else{
                   win++;
                   System.out.println("You win");
               }
               
             
                System.out.println("Computer: " + compHand + " " + "Yours: " + user);
             
                 numberOfRounds -= 1;
            }while(noMoreRounds);
            
  
           
        }
            System.out.println("You have won a total of " + win + ".");
            System.out.println("You have lost a total of " + lose + ".");
            System.out.println("You tied a total of " + tie + ".");
    }
    
    private static int userHand(){
        

        Scanner hand = new Scanner(System.in);
        System.out.println("What's your hand?");
        int handOfUser = hand.nextInt();
        hand.nextLine();
        
        return handOfUser;
        
    }
    
    private static int aiHand(){
           Random compHand = new Random();
          return compHand.nextInt(3)+1;
            
    }
    
    private static boolean shouldPlayAgain() {
        System.out.println("Would you like to play again? Yes/No");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine();
        if (userAnswer.equals("Yes")) {
            return true;
        } else {
            return false;
        }
    }
   
}
         
        
    

        
        

    
    

