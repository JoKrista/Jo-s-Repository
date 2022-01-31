/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joaquino.classroster;

import clasroster.dao.ClassRosterAuditDao;
import clasroster.dao.ClassRosterAuditDaoFileImpl;
import clasroster.dao.ClassRosterDaoFileImpl;
import classroster.controller.ClassRosterController;
import classroster.service.ClassRosterServiceLayer;
import classroster.service.ClassRosterServiceLayerImpl;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;
import clasroster.dao.ClassRosterDao;

/**
 *
 * @author joaqu
 */
public class App {
    public static void main(String[] args){
        //Instantiate the UserIO implementation
        UserIO myIO = new UserIOConsoleImpl();
        //Instantiate the View and wire the UserIO impl into it
        ClassRosterView myView = new ClassRosterView(myIO);
        //Dao
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        //Audit Dao
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
        //Instantiate Service Layer and wire the DAO and Audit DAO into it. Pass it in the constructor
        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        //Instantiate the Controller and wire the Service Layer into it
        ClassRosterController controller = new ClassRosterController(myService, myView);
        //Kick off the controller
        controller.run();
    }
    
}
