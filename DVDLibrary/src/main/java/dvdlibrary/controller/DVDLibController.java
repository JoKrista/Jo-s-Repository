/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controller;

import dvdlibrary.dao.DVDDao;
import dvdlibrary.dao.DVDLibException;
import dvdlibrary.dto.DVD;
import dvdlibrary.ui.DVDLibView;
import dvdlibrary.ui.UserIO;
import dvdlibrary.ui.UserIOImpl;
import java.util.List;

/**
 *
 * @author joaqu
 */
public class DVDLibController {
    
    private UserIO io = new UserIOImpl();
    private DVDLibView view;
    private DVDDao dao;
    
    
    public DVDLibController(DVDDao dao, DVDLibView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while(keepGoing){
                io.print("Main Menu");
                io.print("1. List DVD Library");
                io.print("2. Add New DVD");
                io.print("3. View DVD Details");
                io.print("4. Remove DVD from Library");
                io.print("5. Edit DVD User Rating");
                io.print("6. Exit");
                
                menuSelection = io.readInt("Please select from the" + " above choices", 1, 6);
                switch(menuSelection){
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    /*case 5://Edit DVD*/
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        }catch (DVDLibException e){
            String errorMsg = null;
            view.displayErrorMessage(errorMsg);
        }
    }
    
    private int getLibMenuSelection(){
        return view.printLibAndSelect();
    }
    
    private void addDVD() throws DVDLibException{
        view.displayAddDVD();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddedSuccessfully();
    }
    
    private void listDVDs() throws DVDLibException{
        view.displayLibrary();
        List<DVD> dvdList = dao.getAllDVD();
        view.displayLibraryList(dvdList);
    }
    
    private void viewDVD() throws DVDLibException{
        view.displayDVDBanner();
        String Title = view.getDVDTitleChoice();
        DVD dvd = dao.getDVD(Title);
        view.displayDVD(dvd);
    }
    
    private void removeDVD() throws DVDLibException{
        view.displayRemoveDVDBanner();
        String Title = view.getDVDTitleChoice();
        DVD removedDVD = dao.removeDVD(Title);
        view.displayRemoveDVD(removedDVD);
    }
    
    /*private void editDVD() throws DVDLibException{
        //view.chooseDVDToEdit();
        String Title = view.chooseDVDToEdit();
        String userEdit;
        userEdit = dao.editUserRating(UserRating);
        view.displayEdited();
    }*/
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
    
}
