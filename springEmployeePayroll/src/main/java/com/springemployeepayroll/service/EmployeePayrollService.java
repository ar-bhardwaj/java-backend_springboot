package com.springemployeepayroll.service;

import com.springemployeepayroll.dto.EmpDTO;
import com.springemployeepayroll.entities.EmpEntities;
import com.springemployeepayroll.exception.EmpException;
import com.springemployeepayroll.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Slf4j

public class EmployeePayrollService {
    @Autowired
    EmployeePayrollRepository er;

    //add
    public ResponseEntity<?> addEmp(EmpDTO dto) {
        log.info("Adding employee payroll");

        EmpEntities emp = new EmpEntities();

        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());
        er.save(emp);
        log.debug("employee payroll saved");
        return new ResponseEntity<String>("added payroll", HttpStatus.OK);
    }

    //edit
    public ResponseEntity<?> updateEmp(Long id, EmpDTO dto) {
        try{
            log.info("Updating employee payroll");
            Optional<EmpEntities> opt = er.findById(id);
            if (opt.isPresent()) {
                EmpEntities e = opt.get();
                e.setName(dto.getName());
                e.setSalary(dto.getSalary());
                er.save(e);
                log.debug("updated employee payroll");
                return new ResponseEntity<String>("updated successfully", HttpStatus.OK);
            }
            else{
                log.warn("employee payroll not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            throw new EmpException("Invalid Input "+e.getMessage());
        }

    }

    //view
    public ResponseEntity<?> viewEmp(Long id) {
        try {
            log.info("Viewing employee payroll");
            Optional<EmpEntities> opt = er.findById(id);
            if (opt.isPresent()) {
                EmpEntities e = opt.get();
                EmpDTO dto = new EmpDTO();
                dto.setId(e.getId());
                dto.setName(e.getName());
                dto.setSalary(e.getSalary());

                return new ResponseEntity<>(dto, HttpStatus.OK);
            } else {
                log.warn("employee payroll not found");
                return new ResponseEntity<String>("User not Found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            throw new EmpException("Invalid Input "+e.getMessage());
        }
    }

    //delete
    public ResponseEntity<?> deleteEmp(Long id) {
        log.info("Deleting employee payroll");
        Optional<EmpEntities> opt = er.findById(id);
        if (opt.isPresent()) {
            EmpEntities e = opt.get();
            er.delete(e);
            log.debug("deleted employee payroll");
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }
        else{
            log.warn("employee payroll not found");
            return new ResponseEntity<>("Not Found!",HttpStatus.NOT_FOUND);
        }
    }

}
