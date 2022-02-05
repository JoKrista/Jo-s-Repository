/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author joaqu
 */
public interface VendingMachineDao {
    
    VendingMachine buyProduct(VendingMachine productName, String inventory)
            throws VendingPersistenceException;
    
    VendingMachine coins(String deposit)
            throws VendingPersistenceException;
    
    VendingMachine inventory(VendingMachine productName, String inventory)
            throws VendingPersistenceException;
    
    List<VendingMachine> getProductNames()
            throws VendingPersistenceException;
    
    VendingMachine deposit(String deposit)
            throws VendingPersistenceException;
}
