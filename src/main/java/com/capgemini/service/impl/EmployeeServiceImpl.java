package com.capgemini.service.impl;

import java.util.List;

import com.capgemini.util.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.service.EmployeeService;
import com.capgemini.to.EmployeeTO;
import com.capgemini.to.OfficeTO;

import static com.capgemini.mappers.EmployeeMapper.map2TOs;
import static com.capgemini.mappers.EmployeeMapper.toEmployeeEntity;
import static com.capgemini.mappers.EmployeeMapper.toEmployeeTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	@Transactional
	public EmployeeTO addNewEmployee(EmployeeTO employee) {
		EmployeeEntity savedEmployee = employeeDao.save(toEmployeeEntity(employee));
		return toEmployeeTO(savedEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployee(EmployeeTO removeEmployee) {
		employeeDao.delete(removeEmployee.getId());
	}
	
	@Override
	public EmployeeTO findEmployeeById(Long employeeId) {
		return toEmployeeTO(employeeDao.findOne(employeeId));
	}
		
	@Override
	@Transactional
	public EmployeeTO update(EmployeeTO employee) {
		if (employee.getId() == null) {
			EmployeeEntity savedEmployee = employeeDao.save(toEmployeeEntity(employee));
			return toEmployeeTO(savedEmployee);
		} else {
			EmployeeEntity updatedEmployee = employeeDao.update(toEmployeeEntity(employee));
			return toEmployeeTO(updatedEmployee);
		}
	}

	@Override
	@Transactional
	public EmployeeTO deleteEmployeeFromOffice(EmployeeTO employee) {
		if (employee.getId() == null) {
			throw new NotFoundException("Cannot find employee with id set to null.");
		}
		employee.setOffice(null);
		return update(employee);
	}

	@Override
	@Transactional
	public EmployeeTO setOfficeToEmployee(EmployeeTO employee, OfficeTO office) {
		if (employee.getId() != null && office.getId() != null) {
			employee.setOffice(office);
			employee = update(employee);
		}
		return employee;
	}

	@Override
	public List<EmployeeTO> findOfficeEmployees(Long officeId) {
		return map2TOs(employeeDao.findOfficeEmployees(officeId));
	}

	@Override
	public List<EmployeeTO> findCarKeepersFromOffice(Long officeId, Long carId) {
		  return map2TOs(employeeDao.findCarKeepersFromOffice(officeId, carId));
	}

}
