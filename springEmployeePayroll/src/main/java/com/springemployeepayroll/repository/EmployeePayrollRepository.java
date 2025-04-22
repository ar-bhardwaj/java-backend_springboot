package com.springemployeepayroll.repository;

import com.springemployeepayroll.entities.EmpEntities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<EmpEntities,Long> {
}
