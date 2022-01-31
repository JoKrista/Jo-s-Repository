/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasroster.dao;

import classroster.dto.Student;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaqu
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao{
    
    
    private final String ROSTER_FILE;
    public ClassRosterDaoFileImpl(){
        //provides the earlier default behavior
        //specifically: public static final String ROSTER_FILE = "roster.txt";
        ROSTER_FILE = "roster.txt";
    }
    public ClassRosterDaoFileImpl(String rosterTextFile){
        //overloaded constructor that allows us to create instances that utilize
        //another file- allowing the file reference to be injected upon construction
        //this will be used for test setup and ensures we dont overwrite our
        //production application data
        ROSTER_FILE = rosterTextFile;
    }
    
    public static final String DELIMITER = "::";
    
    private Map<String, Student> students = new HashMap<>();
    
    private Student unmarshallStudent(String studentAsText){
        String[] studentTokens = studentAsText.split(DELIMITER);
        String studentId = studentTokens[0];
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        return studentFromFile;
    }
    
    private void loadRoster() throws ClassRosterPersistenceException{
        Scanner scanner;
        
        try{
            //create scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                    new FileReader(ROSTER_FILE)));
        }catch (FileNotFoundException e){
            throw new ClassRosterPersistenceException(
            "-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        Student currentStudent;
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }
    
    private String marshallStudent(Student aStudent){
        String studentAsText = aStudent.getStudentId() + DELIMITER;
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();
        return studentAsText;
    }
    
    private void writeRoster() throws ClassRosterPersistenceException, IOException{
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        }catch(IOException e){
            throw new ClassRosterPersistenceException(
            "Could not save student data.", e);
        }
        String studentAsText;
        List studentList = this.getAllStudents();
        for(Object currentStudent : studentList){
            studentAsText = marshallStudent((Student) currentStudent);
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public Student addStudent(String studentId, Student student) 
    throws ClassRosterPersistenceException {
        
        loadRoster();
        Student newStudent = students.put(studentId, student);
        try {
            writeRoster();
        } catch (IOException ex) {
            Logger.getLogger(ClassRosterDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) 
    throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) 
    throws ClassRosterPersistenceException {
        Student removedStudent = students.remove(studentId);
        try {
            writeRoster();
        } catch (IOException ex) {
            Logger.getLogger(ClassRosterDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return removedStudent;
    }

   
    }
    

