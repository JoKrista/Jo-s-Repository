/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.summativesums;

/**
 *
 * @author joaqu
 */
public class SummativeSums {
    public static void main(String[] args){
        
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
        
    }
  }
