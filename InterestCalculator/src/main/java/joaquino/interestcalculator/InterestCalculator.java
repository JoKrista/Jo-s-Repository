/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class InterestCalculator {
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        
        float interestRate;
        float principal;
        int numOfYears;
        
        
        System.out.println("What is your principal amount?");
        principal = inputReader.nextFloat();
        System.out.println("What is the yearly interest rate?");
        interestRate = inputReader.nextFloat();
        System.out.println("How many years are you going to invest?");
        numOfYears = inputReader.nextInt();
        
         System.out.println("Calculating...");
         System.out.println("");
         
         
        for(int yearNum = 1; yearNum <= numOfYears; yearNum++){
            
           
             System.out.println("Year:" + yearNum);
             System.out.println("");
             System.out.println("Began with: " + principal);
             
             
             
             System.out.println("Earned: " + (principal * (interestRate/100)));
             principal = principal * (interestRate/100)+ principal;
             System.out.println("Ended with: " + principal);
             System.out.println("");
        }
        
        
    }
    
}
