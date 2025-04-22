package com.springemployeepayroll.service;


import com.springemployeepayroll.entities.EmpEntities;
import com.springemployeepayroll.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeePayrollService {
    @Autowired
    EmployeePayrollRepository er;

    //add
    public ResponseEntity<?> addEmp(EmpEntities emp) {
        er.save(emp);
        return new ResponseEntity<String>("added payroll", HttpStatus.OK);
    }

    //edit
    public ResponseEntity<?> updateEmp(Long id,EmpEntities emp) {
        Optional<EmpEntities> opt = er.findById(id);
        if (opt.isPresent()) {
            EmpEntities e = opt.get();
            e.setName(emp.getName());
            e.setSalary(emp.getSalary());
            er.save(e);
            return new ResponseEntity<String>("updated successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //view
    public ResponseEntity<?> viewEmp(Long id) {
        Optional<EmpEntities> opt = er.findById(id);
        if (opt.isPresent()) {
            EmpEntities e = opt.get();
           return new ResponseEntity<>(e, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("User not Found",HttpStatus.NOT_FOUND);
        }
    }

    //delete
    public ResponseEntity<?> deleteEmp(Long id) {
        Optional<EmpEntities> opt = er.findById(id);
        if (opt.isPresent()) {
            EmpEntities e = opt.get();
            er.delete(e);
            return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not Found!",HttpStatus.NOT_FOUND);
        }
    }

}
