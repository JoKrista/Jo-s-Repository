/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.controller;

import clasroster.dao.ClassRosterDaoException;
import clasroster.dao.ClassRosterDaoFileImpl;
import clasroster.dao.classRosterDao;
import classroster.dto.Student;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;
import java.util.List;

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
    private classRosterDao dao;
    
     public ClassRosterController(classRosterDao dao, ClassRosterView view){
        this.dao = dao;
        this.view = view;
    }
    
    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while(keepGoing){
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Student");
            io.print("4. Remove a Student");
            io.print("5. Exit");
            
            menuSelection = io.readInt("Please select from the" + " above choices.", 1, 5);
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
    }catch (ClassRosterDaoException e){
        view.displayErrorMessage(e.getMessage());
    }
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
   
    
    private void createStudent() throws ClassRosterDaoException{
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }
    
    private void listStudents() throws ClassRosterDaoException{
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterDaoException{
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterDaoException{
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = dao.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage(){
        view.displayExitBanner();
    }
    
    
}
