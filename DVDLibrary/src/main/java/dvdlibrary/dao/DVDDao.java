/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author joaqu
 */
public interface DVDDao {
    
    DVD addDVD(String Title, DVD dvd)
            throws DVDLibException;
    
    List<DVD> getAllDVD()
            throws DVDLibException;
    
    DVD getDVD (String Title)
            throws DVDLibException;
    
    DVD removeDVD(String Title)
            throws DVDLibException;
    
    /*DVD editUserRating(String Title, String UserRating)
            throws DVDLibException;
    */
}
