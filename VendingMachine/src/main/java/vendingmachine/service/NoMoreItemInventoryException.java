/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

/**
 *
 * @author joaqu
 */
public class NoMoreItemInventoryException extends Exception{
    
     public NoMoreItemInventoryException(String message) {
        super(message);
    }
    
    public NoMoreItemInventoryException(String message, Throwable cause) {
        super(message,cause);
    }
    
}
