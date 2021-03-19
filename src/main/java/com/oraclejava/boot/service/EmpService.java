package com.oraclejava.boot.service;

import com.oraclejava.boot.dto.Employee;

public interface EmpService {
	Employee login(String empId, String passwd);
}
