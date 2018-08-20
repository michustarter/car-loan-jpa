package com.capgemini.service;

import java.util.List;

import com.capgemini.to.EmployeeTO;
import com.capgemini.to.OfficeTO;

public interface EmployeeService {

	EmployeeTO addNewEmployee(EmployeeTO employee);

	void deleteEmployee(EmployeeTO removeEmployee);

	EmployeeTO findEmployeeById(Long Id);

	EmployeeTO update(EmployeeTO updateEmployee);

	EmployeeTO deleteEmployeeFromOffice(EmployeeTO employee);

	EmployeeTO setOfficeToEmployee(EmployeeTO employee, OfficeTO office);

	List<EmployeeTO> findOfficeEmployees(Long officeId);

	List<EmployeeTO> findCarKeepersFromOffice(Long officeId, Long carId);
	
}
