/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import vendingmachine.dto.VendingMachine;

/**
 *
 * @author joaqu
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao{
    
    private final String VENDINGMACHINE_FILE;
    public VendingMachineDaoFileImpl(){
        VENDINGMACHINE_FILE = "vendingmachine.txt";
    }
    
    public VendingMachineDaoFileImpl(String vendingTextFile){
        VENDINGMACHINE_FILE = vendingTextFile;
    }
    
    public static final String DELIMITER = "::";
    
    private Map<String, VendingMachine> products = new HashMap<>();
    
    private VendingMachine unmarshallProduct(String productAsText){
        String[] productTokens = productAsText.split(DELIMITER);
        String productName = productTokens[0];
        VendingMachine productFromFile = new VendingMachine(productName);
        productFromFile.setInventory(productTokens[1]);
        return productFromFile;
    }
    
    private void loadMachine() throws VendingPersistenceException{
        Scanner scanner;
        
        try{
            scanner = new Scanner(new BufferedReader(
                      new FileReader(VENDINGMACHINE_FILE)));
        }catch (FileNotFoundException e){
        throw new VendingPersistenceException(
        "-_- Could not load Vending Machine data into memory.", e);
    }
        
        String currentLine;
        VendingMachine currentMachine;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentMachine = unmarshallProduct(currentLine);
            products.put(currentMachine.getProductName(), currentMachine);
        }
        scanner.close();
    }
    
    private String marshallProduct(VendingMachine aProduct){
        String productAsText = aProduct.getProductName() + DELIMITER;
        productAsText += aProduct.getInventory();
        return productAsText;
    }
    
    private void writeMachine() throws VendingPersistenceException, IOException{
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(VENDINGMACHINE_FILE));
        }catch(IOException e){
            throw new VendingPersistenceException(
            "Could not save product data.", e);
        }
        String productAsText;
        List<VendingMachine> productList = this.getProductNames();
        for(VendingMachine currentProduct : productList){
            productAsText = marshallProduct(currentProduct);
            out.println(productAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public VendingMachine buyProduct(VendingMachine productName, String inventory) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendingMachine coins(String deposit) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendingMachine inventory(VendingMachine productName, String inventory) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VendingMachine> getProductNames() throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VendingMachine deposit(String deposit) throws VendingPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
