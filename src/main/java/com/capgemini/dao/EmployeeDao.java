package com.capgemini.dao;

import com.capgemini.domain.EmployeeEntity;

public interface EmployeeDao extends Dao<EmployeeEntity, Long> {

	EmployeeEntity addNewEmployee(EmployeeEntity newEmployee);

	void deleteEmployee(Long id);

	EmployeeEntity updateEmployeeData(EmployeeEntity employeeEntity);

}
