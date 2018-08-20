package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	EmployeeEntity addNewEmployee(EmployeeEntity newEmployee);

	void deleteEmployee(EmployeeEntity removedEmployee);
	
	EmployeeEntity updateEmployeeData(EmployeeEntity updateEmployee);
	
	List<EmployeeEntity> findOfficeEmployees(Long officeId);

	List<EmployeeEntity> findCarKeepersfromOffice(Long officeId, Long carId);

}
