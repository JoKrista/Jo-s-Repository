/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;
import java.math.BigDecimal;

/**
 *
 * @author joaqu
 */
public class VendingMachine {
    
    private String productName;
    private BigDecimal price;
    private int inventory;
  
    //price here points to String price as param instead of the BigDecimal one immediately
    public VendingMachine(String productName, String price, int inventory){
        this.productName = productName;
        this.price = new BigDecimal(price);
    }
    
    public VendingMachine(String productName){
        this.productName = productName;
    }
    
    public String getProductName(){
        return productName;
    }
    
    public int getInventory(){
        return inventory;
    }
    
    public void setInventory(int inventory){
        this.inventory = inventory;
    }
    
    public BigDecimal getPrice(){
        return price;
    }
    
    public void setPrice(BigDecimal price){
        this.price = price;
    }
 
}
