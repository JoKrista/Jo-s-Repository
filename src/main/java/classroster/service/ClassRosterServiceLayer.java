/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.service;

import clasroster.dao.ClassRosterPersistenceException;
import classroster.dto.Student;
import java.util.List;

/**
 *
 * @author joaqu
 */
public interface ClassRosterServiceLayer {
    
    public void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
    
    public List<Student> getAllStudents() throws
            ClassRosterPersistenceException;
    
    public Student getStudent(String studentId) throws
            ClassRosterPersistenceException;
    
    public Student removeStudent(String studentId) throws
            ClassRosterPersistenceException;
    
}
