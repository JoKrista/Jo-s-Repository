/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.healthyhearts;

import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class HealthyHearts {
    public static void main(String[] args){
        
        System.out.println("What is your age?");
        
        int maxHeart;
        
        
        Scanner age = new Scanner(System.in);
        int userAge = age.nextInt();
        
        maxHeart = 220-userAge;
        
       //int targetMin = maxHeart * (50/100);
       //int targetMax = maxHeart * (85/100);
       //I tried doing the two formulas above but it wouldn't give me the desired result
       //it was giving 0-0 HR
        
        
        System.out.println("Your maximum heart rate should be " + maxHeart + " beats per minute.");
  
        
        System.out.println("Your target HR Zone is " + (maxHeart * .50) + "-" + (maxHeart * .85) + " beats per minute");
        
        
    }
    
}
