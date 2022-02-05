/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author joaqu
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    
    public BigDecimal deposit(){
        return io.readBigDecimal("Please enter how much you want to deposit.");
    }
    
   public String options(Map<String, BigDecimal> vendingItems){
       vendingItems.entrySet().forEach(entry ->{
           System.out.println(entry.getKey() + "= $" + entry.getValue());
       });
       return io.readString("Type in the name of the product you want to buy. Or type 1 to Exit");
   }
    
    public void notEnoughFunds(){
        io.print("You do not have enough money to buy that product.");
    }
    
    public void displayExitBanner(){
        io.print("Thank you and goodbye!");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void opening() {
       io.print("Welcome to the Vending Machine. Please don't forget to deposit before buying the product.");
    }

    
    
    
   

    
}
