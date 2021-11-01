/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.dvdlibrary;

import dvdlibrary.controller.DVDLibController;
import dvdlibrary.dao.DVDDao;
import dvdlibrary.dao.DVDDaoImpl;
import dvdlibrary.ui.DVDLibView;
import dvdlibrary.ui.UserIO;
import dvdlibrary.ui.UserIOImpl;

/**
 *
 * @author joaqu
 */
public class App {
    public static void main(String[] args){
        UserIO myIO = new UserIOImpl();
        DVDLibView myView = new DVDLibView(myIO);
        DVDDao myDao = new DVDDaoImpl();
        DVDLibController controller = new DVDLibController(myDao, myView);
        controller.run();
    }
    
}
