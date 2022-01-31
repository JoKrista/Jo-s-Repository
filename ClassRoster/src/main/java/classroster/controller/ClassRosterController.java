/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.controller;

import clasroster.dao.ClassRosterPersistenceException;
import clasroster.dao.ClassRosterDaoFileImpl;
import classroster.dto.Student;
import classroster.service.ClassRosterDataValidationException;
import classroster.service.ClassRosterDuplicateIdException;
import classroster.service.ClassRosterServiceLayer;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;
import java.util.List;
import clasroster.dao.ClassRosterDao;

/**
 *
 * @author joaqu
 */
public class ClassRosterController {
    //calls for the interface UserIO and the class that implements it
    //it'll then prompt all the method that had been listed in it
    //and a user menu will be displayed for the user
    private UserIO io = new UserIOConsoleImpl();
    private ClassRosterView view;
    //replace ClassRosterDao dao with ClassRosterServiceLayer service
    //private ClassRosterDao dao;
    private ClassRosterServiceLayer service;
    
    //modified the constructor so that it initizlizes ClassRosterServiceLayer
    //instead of the ClasRosterDao. Changed this.dao to this.service
     public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view){
        this.service = service;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while(keepGoing){
            
            menuSelection = getMenuSelection();
            switch(menuSelection){
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();
    }catch (ClassRosterPersistenceException e){
        view.displayErrorMessage(e.getMessage());
    }
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
   
    //more extensive changes to createStudent because of the validations
    //if want to see original, check ClassRoster in Milestone 2
    //note this part also demonstrates the syntax for catching more than one exception
    private void createStudent() throws ClassRosterPersistenceException{
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do{
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            }catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e){
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        }while (hasErrors);
        
    }
    
    private void listStudents() throws ClassRosterPersistenceException{
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterPersistenceException{
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterPersistenceException{
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
    
    
}
