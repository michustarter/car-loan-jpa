package com.capgemini.service;

import com.capgemini.to.EmployeeTO;

public interface EmployeeService {

	EmployeeTO addNewEmployee(EmployeeTO employee);

	void deleteEmployee(Long id);
}
