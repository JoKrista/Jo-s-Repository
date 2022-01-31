/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.simplefileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author joaqu
 */
public class SimpleFileIO {
    
    public static void main(String[] args) throws Exception{
        //makes the OutFile.txt file
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        //writes lines for the OutFile.txt file
        out.println("This is a line in my file");
        out.println("This is a second line");
        out.println("Having a headache does not excuse you from doing what you need to do");
        out.flush();
        out.close();
        //reading the contents of the file
        //printing it out in console
        Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
        //checking if there are lines in the file to be read to be printed in the console
        while(sc.hasNextLine()){
            String currentLine = sc.nextLine();
            System.out.println(currentLine);
        }
        System.out.println("That's all the content in the file");
        
    }
    
}
