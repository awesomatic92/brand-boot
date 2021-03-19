package com.oraclejava.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.boot.dao.EmpRepository;
import com.oraclejava.boot.dto.Employee;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public Employee login(String empId, String passwd) {
		Employee emp = empRepository.findByEmployeeIdAndPassword(empId, passwd);
		return emp;
	}

}
