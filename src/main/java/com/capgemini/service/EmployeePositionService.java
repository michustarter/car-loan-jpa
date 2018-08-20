package com.capgemini.service;

import com.capgemini.to.EmployeePositionTO;

public interface EmployeePositionService {

	EmployeePositionTO findEmployeePositionById(Long id);

	EmployeePositionTO addNewPosition(EmployeePositionTO position);

	EmployeePositionTO updatePosition(EmployeePositionTO position);
	
}
