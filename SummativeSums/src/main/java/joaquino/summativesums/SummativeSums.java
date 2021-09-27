/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.summativesums;


import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class SummativeSums {
    public static void main(String[] args){
        
        int arrSize = 0;
        int[] numToAdd = new int[enterArrSize()];
        
        int sum = 0;
        
        System.out.println("Enter the elements of the array");
        Scanner arrScan = new Scanner(System.in);
        
        //this would be the index data and it can only be entered = number of array size the user had given
        for(int l = 0; l < arrSize; l++){
            numToAdd[l] = arrScan.nextInt(); //getting array elements from the user
            sum = sum + numToAdd[l];

        }
            System.out.println("The array sum is: " + sum);
        }
    
    
    private static int enterArrSize(){
        
        int arrSize;
        
        Scanner arrScan = new Scanner(System.in);
        System.out.println("Enter the size of the array.");
     
        arrSize = arrScan.nextInt();
        
        int[] array = new int[arrSize];//this willl be the array size
        
             return arrSize;
        }
    /*  This was the original program that I submitted
        jaggedArray();

    }
    public static void jaggedArray() {
        
       
        
        int[] arr = {1, 90, - 33, -55, 67, -16, 28, -55, 15};
        int[] arrOne = new int[] {999, -60, -77, 14, 160, 301};
        int[] arrTwo = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };
        int sum = 0;//sum for arr
        int sumOne = 0;//sum for arrOne
        int sumTwo = 0;//sum for arrTwo
        //arr calculation for sum
        for(int i = 0; i < arr.length; i++){
            sum = sum+arr[i];
            
        }
        System.out.println("Array 1: " + sum);
        
        //arrPme calculation for sum
        for(int j = 0; j < arrOne.length; j++){
            sumOne = sumOne + arrOne[j];
        }
        System.out.println("Array 2: " + sumOne);
        
        
        //arrTwo calculation for sum
        for(int k = 0; k < arrTwo.length; k++){
            sumTwo = sumTwo + arrTwo[k];
        }
        System.out.println("Array 3: " + sumTwo);
        
    }*/
        
 
   
  }
