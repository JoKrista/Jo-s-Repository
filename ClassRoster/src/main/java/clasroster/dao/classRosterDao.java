/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasroster.dao;

import classroster.dto.Student;
import java.util.List;

/**
 *
 * @author joaqu
 */
public interface classRosterDao {
    
    Student addStudent(String studentId, Student student)
            throws ClassRosterDaoException;
    
    List<Student> getAllStudents()
            throws ClassRosterDaoException;
    
    Student getStudent(String studentId)
            throws ClassRosterDaoException;
    
    Student removeStudent(String studentId)
            throws ClassRosterDaoException;
    
}
