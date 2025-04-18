package com.springmvc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    @Autowired
    private Dept dept;

    public Dept getDept() {
        return dept;
    }
}
