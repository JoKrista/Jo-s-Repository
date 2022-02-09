/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.Map;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingPersistenceException;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author joaqu
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{
    
    private VendingMachineAuditDao auditDao;
    private VendingMachineDao dao;

    @Override
    public void checkIfEnoughDeposit(VendingMachine productName, BigDecimal deposit) throws InsufficientFundsException {
       if (productName.getPrice().compareTo(deposit) == 1){
           throw new InsufficientFundsException(
           "ERROR: Insufficent funds, you only have "+ deposit);
       }
    }

    @Override
    public void removeOneItemFromInventory(String name) throws NoMoreItemInventoryException, VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, BigDecimal> getItemsInStockWithPrice() throws InsufficientFundsException, NoMoreItemInventoryException, VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<BigDecimal, BigDecimal> getChangePerCoin(VendingMachine productName, BigDecimal money) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void removeAnItem(String name) throws NoMoreItemInventoryException, VendingPersistenceException {
        
    }
    
}
