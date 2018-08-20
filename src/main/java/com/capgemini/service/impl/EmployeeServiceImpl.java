package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.OfficeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.mappers.OfficeMapper;
import com.capgemini.service.EmployeeService;
import com.capgemini.to.EmployeeTO;
import com.capgemini.to.OfficeTO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	private OfficeDao officeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao, OfficeDao officeDao) {
		this.employeeDao=employeeDao;
		this.officeDao=officeDao;
	}
	
	

	@Override
	@Transactional(readOnly = false)
	public EmployeeTO addNewEmployee(EmployeeTO employee) {

		EmployeeEntity employeeEntity = employeeDao.addNewEmployee(EmployeeMapper.toEmployeeEntity(employee));
		return EmployeeMapper.toEmployeeTO(employeeEntity);

	}

	@Override
	public void deleteEmployee(EmployeeTO removeEmployee) {
		employeeDao.deleteEmployee(EmployeeMapper.toEmployeeEntity(removeEmployee));
	}
	
	@Override
	public EmployeeTO findEmployeeById(Long employeeId) {
		return EmployeeMapper.toEmployeeTO(employeeDao.findOne(employeeId));
	}
		
	@Override
	public EmployeeTO updateEmployeeData(EmployeeTO updateEmployee) {
		EmployeeEntity employee = employeeDao.updateEmployeeData(EmployeeMapper.toEmployeeEntity(updateEmployee));
		return EmployeeMapper.toEmployeeTO(employee);
	}

	@Override
	public EmployeeTO deleteEmployeeFromOffice(Long officeId, Long employeeId) {
		 EmployeeEntity employeeEntity = employeeDao.deleteEmployeeFromOffice(employeeId);
	        return EmployeeMapper.toEmployeeTO(employeeEntity);
	}
	
	@Override
	public EmployeeTO setOfficeToEmployee(EmployeeTO employee, OfficeTO office) {
		
		if(employee.getId()==null) {
			employeeDao.save(EmployeeMapper.toEmployeeEntity(employee));
		}
		if(office.getId()==null) {
			officeDao.save(OfficeMapper.toOfficeEntity(office));
		}
		employee.setOffice(office);
		employee=updateEmployeeData(employee);
		
		return employee;
		
	}
	@Override
	public List<EmployeeTO> findOfficeEmployees(Long officeId) {
		return EmployeeMapper.map2TOs(employeeDao.findOfficeEmployees(officeId));
	}

	@Override
	public List<EmployeeTO> findCarKeepersfromOffice(Long officeId, Long carId) {
		  return EmployeeMapper.map2TOs(employeeDao.findCarKeepersfromOffice(officeId, carId));
	}

}
