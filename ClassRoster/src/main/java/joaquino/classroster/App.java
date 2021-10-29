/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.classroster;

import clasroster.dao.ClassRosterDaoFileImpl;
import clasroster.dao.classRosterDao;
import classroster.controller.ClassRosterController;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author joaqu
 */
public class App {
    public static void main(String[] args){
        
        UserIO myIO = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIO);
        classRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(myDao, myView);
        controller.run();
    }
    
}
