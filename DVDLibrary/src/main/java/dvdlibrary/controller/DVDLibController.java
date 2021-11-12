/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controller;

import dvdlibrary.dao.DVDDao;
import dvdlibrary.dao.DVDDaoImpl;
import dvdlibrary.dao.DVDLibException;
import dvdlibrary.dto.DVD;
import dvdlibrary.ui.DVDLibView;
import java.util.List;

/**
 *
 * @author joaqu
 */
public class DVDLibController {
    
   
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
                
                menuSelection = getLibMenuSelection();
                
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
                    case 5:
                        editDVD();
                        break;
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
    
    
    private void editDVD() throws DVDLibException{
        String thisDVD = null;
        view.displayEditThisDVD();
        view.displayEdited();
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
    
}
