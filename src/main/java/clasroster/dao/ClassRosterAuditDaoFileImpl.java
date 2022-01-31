/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author joaqu
 */
public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {
    
    
    //How to make a text file just in case you forget
    public static final String AUDIT_FILE = "audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;
        
        try{
            //a file in append mode does not overwrite everything that was there before
            //it appends it hence the term. It is accomplished by setting the constructor
            //to true. It's the thing right next to AUDIT_FILE right below this statement
            out = new PrintWriter (new FileWriter(AUDIT_FILE, true));
        }catch (IOException e){
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }
        //... so there was something like this huh
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    
}
