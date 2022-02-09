/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author joaqu
 */
public class VendingMachineAuditDaoFileImpl implements VendingMachineAuditDao{
    
    private final String AUDIT_FILE;
    public VendingMachineAuditDaoFileImpl(){
        this.AUDIT_FILE = "audit.text";
    }

    @Override
    public void writeAuditEntry(String entry) throws VendingPersistenceException {
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        }catch (IOException e){
            //I noticed if I did not create the AUDIT_FILE at the start, it would make it in this method
            //and remove the catch clause. Why is that?
            throw new VendingPersistenceException("Could not persist audit information", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
}
