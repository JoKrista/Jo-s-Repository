/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

/**
 *
 * @author joaqu
 */
public class DVDLibException extends Exception{
    
    public DVDLibException (String message){
   
        super(message);
    }
    
    public DVDLibException(String message, Throwable cause){
        super(message, cause);
    }
}
    

