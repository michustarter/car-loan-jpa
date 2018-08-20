package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.EmployeePositionDao;
import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.mappers.EmployeePositionMapper;
import com.capgemini.service.EmployeePositionService;
import com.capgemini.to.EmployeePositionTO;

@Service
@Transactional
public class EmployeePositionServiceImpl implements EmployeePositionService {

	EmployeePositionDao employeePositionDao;

	@Autowired
	public EmployeePositionServiceImpl(EmployeePositionDao employeePositionDao) {
		this.employeePositionDao = employeePositionDao;
	}

	@Override
	public EmployeePositionTO findEmployeePositionById(Long id) {
		  EmployeePositionEntity positionEntity = employeePositionDao.findOne(id);
	        return EmployeePositionMapper.toEmployeePositionTO(positionEntity);
	}

	@Override
	public EmployeePositionTO addNewPosition(EmployeePositionTO position) {
		EmployeePositionEntity positionEntity = employeePositionDao.save(EmployeePositionMapper.toEmployeePositionEntity(position));
		return EmployeePositionMapper.toEmployeePositionTO(positionEntity);
	}

	@Override
	public EmployeePositionTO updatePosition(EmployeePositionTO position) {
		EmployeePositionEntity positionEntity = employeePositionDao.update(EmployeePositionMapper.toEmployeePositionEntity(position));
		return EmployeePositionMapper.toEmployeePositionTO(positionEntity);
	}

}
