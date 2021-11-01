/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import dvdlibrary.dto.DVD;
import java.util.List;

/**
 *
 * @author joaqu
 */
public class DVDLibView {
    private UserIO io;
    
    public DVDLibView(UserIO io){
        this.io = io;
    }
    
    public int printLibAndSelect(){
        io.print("Main Menu");
        io.print("1. List DVD Library");
        io.print("2. Add New DVD");
        io.print("3. View DVD Details");
        io.print("4. Remove DVD from Library");
        io.print("5. Edit DVD User Rating");
        io.print("6. Exit");
        
        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public DVD getNewDVDInfo(){
        String Title = io.readString("Please enter DVD Title");
        String ReleaseDate = io.readString("Release Date");
        String MPAARating = io.readString("MPAARating");
        String DirectorName = io.readString("Director's Name");
        String Studio = io.readString("Studio");
        String UserRating = io.readString("Viewer Rating");
        DVD currentDVD = new DVD(Title);
        currentDVD.setReleaseDate(ReleaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirectorName(DirectorName);
        currentDVD.setStudio(Studio);
        currentDVD.setUserRating(UserRating);
        return currentDVD;
    }
    
    public void displayAddDVD(){
        io.print("=== Add DVD ===");
    }
    public void displayAddedSuccessfully(){
        io.readString("DVD added successfully. Please hit enter to continue");
    }
    
    public void displayLibraryList(List<DVD> dvdList){
        for(DVD currentDVD : dvdList){
            String dvdInfo = String.format("#%s : %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMPAARating(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudio(),
                    currentDVD.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit Enter to continue");
    }
    
    public void displayLibrary(){
        io.print("=== DVD Library ===");
    }
    
    public void displayDVDBanner(){
        io.print("=== DVD Information ===");
    }
    
    public String getDVDTitleChoice(){
        return io.readString("Please enter the DVD Title");
    }
    
    public void displayDVD(DVD dvd){
        if (dvd != null){
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMPAARating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
        }else{
            io.print("That DVD does not exist in the Library");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayRemoveDVDBanner(){
        io.print("=== Remove DVD from Library ===");
    }
    
    public void displayRemoveDVD(DVD dvdRecord){
        if (dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("DVD does not exist in the library.");
        }
        io.readString("Please hit enter to continue");
    }
    
    public void displayEditUserRating(DVD dvdUserRate){
        
    }
    
    public void displayExitBanner(){
        io.print("Thank you for visiting the library and goodbye!");
    }
    
    public void displayUnknownCommandBanner(){
        io.print("Unknown Comman");
    }
    
    public void displayErrorMessage(String errorMsg){
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
