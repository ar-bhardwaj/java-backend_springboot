package com.springemployeepayroll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payroll")
public class EmployeePayrollController {

    @GetMapping()
    public  String payroll() {
        return "Hello from Employee Payroll";
    }
}
