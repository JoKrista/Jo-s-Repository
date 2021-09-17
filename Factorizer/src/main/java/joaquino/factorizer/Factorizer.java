/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.factorizer;

import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class Factorizer {
    public static void main(String[] args){
        int userNumFactor = 0;
        int factorNum = 0;
         boolean primeOrNot = false;
        Scanner inputNum = new Scanner(System.in);
        System.out.println("Please give a number to factor.");
        int userNum = inputNum.nextInt();
       
        inputNum.nextLine();
        System.out.println("The factors of "+ userNum + " are:");
        for(userNumFactor = 1; userNumFactor < userNum; userNumFactor++){
            if(userNum % userNumFactor == 0){
                
                System.out.println(userNumFactor + " ");
               
            }else if(userNum % userNumFactor != 0){
                
                System.out.println(userNum + " is a perfect number");
            }
        }
        for(userNumFactor = 2; userNumFactor <= userNum/2; ++userNumFactor){
            if(userNum % userNumFactor == 0){
                primeOrNot = true;
                break;
               
            }if(!primeOrNot){
                System.out.println(userNum + " is a prime number.");
            
            }else{
                primeOrNot = true;
            
                System.out.println(userNum + " is not a prime number");
            }
        }
       // System.out.println("The factors of " + userNum +" are:" + userNumFactor);
       //System.out.println(userNum + "has " + factorNum + " factors" );
       // System.out.println(userNum + "is " + );
       // System.out.println(userNum + " is" + );
 
    }
    
}
