package com.springemployeepayroll.controller;

import com.springemployeepayroll.entities.EmpEntities;
import com.springemployeepayroll.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

    @Autowired
     EmployeePayrollService es;

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody EmpEntities emp){
        return es.addEmp(emp);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return es.viewEmp(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody EmpEntities emp){
        return es.updateEmp(id, emp);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return es.deleteEmp(id);
    }

}
