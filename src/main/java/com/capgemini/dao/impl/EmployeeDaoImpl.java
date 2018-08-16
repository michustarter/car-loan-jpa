package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class EmployeeDaoImpl extends AbstractDao<EmployeeEntity, Long> implements EmployeeDao {

	@Override
	public EmployeeEntity addNewEmployee(EmployeeEntity newEmployee) {
		return save(newEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		delete(id);
	}

	@Override
	public EmployeeEntity updateEmployeeData(EmployeeEntity employeeEntity) {
		return save(employeeEntity);
	}

}
