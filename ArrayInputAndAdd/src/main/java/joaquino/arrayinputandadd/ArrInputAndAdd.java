/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.arrayinputandadd;


import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class ArrInputAndAdd {
    public static void main(String[] args){  
        System.out.println("Enter the required size of the array :: ");
      Scanner s = new Scanner(System.in);
      int size = s.nextInt();
      int myArray[] = new int [size];
      int sum = 0;
      System.out.println("Enter the elements of the array one by one ");

      for(int i=0; i<size; i++){
         myArray[i] = s.nextInt();
         sum = sum + myArray[i];
      }

      System.out.println("Sum of the elements of the array: "+sum);
        
        }  
    
}
