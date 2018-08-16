package com.capgemini.service.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.to.EmployeeTO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional(readOnly = false)
	public EmployeeTO addNewEmployee(EmployeeTO employee) {
		EmployeeEntity employeeEntity = EmployeeMapper.toEmployeeEntity(employee);
		return EmployeeMapper.toEmployeeTO(employeeDao.save(employeeEntity));
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeDao.delete(id);
	}

}
