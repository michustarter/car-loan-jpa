package com.capgemini.dao;

import com.capgemini.domain.EmployeePositionEntity;

public interface EmployeePositionDao extends Dao<EmployeePositionEntity, Long> {

	EmployeePositionEntity addNewPosition(EmployeePositionEntity newPosition);

}