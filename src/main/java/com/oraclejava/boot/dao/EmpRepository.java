package com.oraclejava.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oraclejava.boot.dto.Employee;

public interface EmpRepository extends JpaRepository<Employee, String>{
	Employee findByEmployeeIdAndPassword(String empId, String passwd);
}
