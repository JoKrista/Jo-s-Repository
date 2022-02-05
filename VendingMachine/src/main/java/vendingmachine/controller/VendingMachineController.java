/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.Map;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingPersistenceException;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author joaqu
 */
public class VendingMachineController {
    
    private VendingMachineView view;
    private VendingMachineDao dao;
    
    public VendingMachineController(VendingMachineDao dao, VendingMachineView view){
        this.dao = dao;
        this.view = view;
    }
    
    
    public void run(){
        
            boolean keepGoing = true;
            String selection = "";
            BigDecimal despositMoney;
            view.opening();
            buyProduct();
            
        try {
            despositMoney = deposit();
            while(keepGoing){
                selection = buyProduct();
                
                if (selection.equalsIgnoreCase("1")){
                    keepGoing = false;
                    break;
                }
            }
        } catch (VendingPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
            
    }
    
    
    private BigDecimal deposit() throws VendingPersistenceException{
        return view.deposit();
    }
    
    private String buyProduct(){
        //is this because of my params in View?
        Map<String, BigDecimal> vendingItems = null;
        return view.options(vendingItems);
    }
    
    
    
}
