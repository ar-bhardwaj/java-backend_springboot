package com.springemployeepayroll.controller;

import com.springemployeepayroll.dto.EmpDTO;
import com.springemployeepayroll.entities.EmpEntities;
import com.springemployeepayroll.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payroll")
public class EmployeePayrollController {

    @Autowired
     EmployeePayrollService es;

    @PostMapping("/post")
    public ResponseEntity<?> post(@RequestBody EmpDTO dto){
        log.info("Inside post method of EmployeePayrollController");

        return es.addEmp(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){

        return es.viewEmp(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody EmpDTO dto){
        return es.updateEmp(id, dto);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        return es.deleteEmp(id);
    }

}
