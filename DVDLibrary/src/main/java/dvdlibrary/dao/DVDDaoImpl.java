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
        //DVDAsText expects a line read from file
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
        
        String currentLine;//most recent line
        DVD currentDVD;//most recent movie
        //next block of code will run until there are no more dvds
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
            //not handling the IOException, but translating it to an application
            //specific exception and then reporting it to the code that called
            //It's the responsibility of the calling code to handle the errors
            //basically, catching the IOException and translate it into our exception
            throw new DVDLibException(
            "Could not save DVD data", e);
        }
        
        String DVDAsText;
        List<DVD> dvdList = this.getAllDVD();
        for(DVD currentDVD : dvdList){
            DVDAsText = marshallDVD(currentDVD);
            out.println(DVDAsText);
            out.flush();//if only it would write the one for edited too >.>
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
    
    @Override
    public DVD removeDVD(String Title) throws DVDLibException {
        loadLibrary();//at first, I didn't have this here, but it still worked?
        DVD removedDVD = dvd.remove(Title);
        writeLibrary();
        return removedDVD;//kinda ironic that we're returning something we've removed
    }

    @Override
    public DVD editTheDVD(String Title, String newMPAARating, 
           String newDirectorName, String newStudio, String newUserRating, String newReleaseDate) throws DVDLibException {
        loadLibrary();
        //I tried to use the dvd.replace but it rewrote the whole file instead
        //and erased everything else I've put in it
        DVD newEdit = dvd.get(Title);
        newEdit.setDirectorName(newDirectorName);
        newEdit.setMPAARating(newMPAARating);
        newEdit.setStudio(newStudio);
        newEdit.setUserRating(newUserRating);
        newEdit.setReleaseDate(newReleaseDate);
        writeLibrary();
        return newEdit;
    }
}
