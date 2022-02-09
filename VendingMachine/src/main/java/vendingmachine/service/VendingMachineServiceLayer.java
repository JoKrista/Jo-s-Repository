/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.Map;
import vendingmachine.dao.VendingPersistenceException;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author joaqu
 */
public interface VendingMachineServiceLayer {
    
    void checkIfEnoughDeposit(VendingMachine productName, BigDecimal deposit) throws
            InsufficientFundsException;
    
    void removeOneItemFromInventory (String name) throws
            NoMoreItemInventoryException,
            VendingPersistenceException;
    
    Map<String, BigDecimal> getItemsInStockWithPrice() throws
            InsufficientFundsException,
            NoMoreItemInventoryException,
            VendingPersistenceException;
    
    Map<BigDecimal, BigDecimal> getChangePerCoin(VendingMachine productName, BigDecimal money);
    
}
