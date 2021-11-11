/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author joaqu
 */
public class DVDDaoImpl implements DVDDao{
    
    public static final String DVD_FILE = "DVD.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, DVD> dvd = new HashMap<>();
    
    private DVD unmarshallDVD(String DVDAsText){
        String[] DVDToken = DVDAsText.split(DELIMITER);
        String Title = DVDToken[0];
        DVD dvdFromFile = new DVD(Title);
        dvdFromFile.setDirectorName(DVDToken[1]);
        dvdFromFile.setMPAARating(DVDToken[2]);
        dvdFromFile.setReleaseDate(DVDToken[3]);
        dvdFromFile.setStudio(DVDToken[4]);
        dvdFromFile.setUserRating(DVDToken[5]);
        return dvdFromFile;
    }
    
    private void loadLibrary() throws DVDLibException{
        Scanner scanner;
        
        try{
            
            scanner = new Scanner(
            new BufferedReader(
            new FileReader(DVD_FILE)));
        }catch (FileNotFoundException e){
            throw new DVDLibException(
            "-_- Could not load library date into memory.", e);
        
        }
        
        String currentLine;
        DVD currentDVD;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvd.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }
    
    private String marshallDVD (DVD aDVD){
        String DVDAsText = aDVD.getTitle() + DELIMITER;
        DVDAsText += aDVD.getReleaseDate() + DELIMITER;
        DVDAsText += aDVD.getMPAARating() + DELIMITER;
        DVDAsText += aDVD.getDirectorName() + DELIMITER;
        DVDAsText += aDVD.getStudio() + DELIMITER;
        DVDAsText += aDVD.getUserRating();
        return DVDAsText;
    }
    
    private void writeLibrary() throws DVDLibException {
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(DVD_FILE));
        }catch(IOException e){
            throw new DVDLibException(
            "Could not save DVD data", e);
        }
        //check for other solution
        String DVDAsText;
        List<DVD> dvdList = this.getAllDVD();
        for(DVD currentDVD : dvdList){
            DVDAsText = marshallDVD((DVD) currentDVD);
            out.println(DVDAsText);
            out.flush();
        }
        out.close();
    }
    

    @Override
    public DVD addDVD(String Title, DVD dvds) throws DVDLibException {
        
        loadLibrary();
        DVD newDVD = dvd.put(Title, dvds);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVD() throws DVDLibException {
        loadLibrary();
        return new ArrayList<DVD>(dvd.values());
    }

    @Override
    public DVD getDVD(String Title) throws DVDLibException {
        loadLibrary();
        return dvd.get(Title);
    }
    //put in boolean for implementation
    @Override
    public DVD removeDVD(String Title) throws DVDLibException {
        DVD removedDVD = dvd.remove(Title);
        writeLibrary();
        return removedDVD;
    }

    @Override
    public DVD editTheDVD(String Title, DVD thisDVD) throws DVDLibException {
        loadLibrary();
        //dvd.get(Title);
        DVD newEdit = dvd.replace(Title, thisDVD);
        writeLibrary();
        return newEdit;
        
    }
}
