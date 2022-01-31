/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.service;

import clasroster.dao.ClassRosterAuditDao;
import clasroster.dao.ClassRosterPersistenceException;

/**
 *
 * @author joaqu
 */
public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao{

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothing...
    }
    
}
