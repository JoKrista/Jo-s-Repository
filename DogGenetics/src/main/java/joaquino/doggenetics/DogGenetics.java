/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.doggenetics;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class DogGenetics {
    public static void main(String[] args){
        
        
       
        System.out.println("What is your dog's name?");
        Scanner dog = new Scanner(System.in);
        String dogName = dog.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s pretigious background right here.");
        System.out.println(dogName + " is: ");
        
        Random r = new Random();
        int n1 = r.nextInt(100);
        System.out.println(n1 + "% St. Bernard");
        int n2 = r.nextInt(100 - n1);
        System.out.println(n2 + "% Chihuahua");
        int n3 = r.nextInt(100 - n1 - n2);
        System.out.println(n3 + "% Dramatic RedNosed Asian Pug");
        int n4 = r.nextInt(100 - n1 - n2 - n3);
        System.out.println(n4 + "% Common Cur");
        int n5 = 100 - n1 - n2 - n3 - n4;
        System.out.println(n5 + "% King Doberman");
        
        System.out.println("Wow, that's quite the dog!");
        
        //there is a problem that occurs here where sometimes, the number generated is 0
        //Please fix that
 
    }

}
