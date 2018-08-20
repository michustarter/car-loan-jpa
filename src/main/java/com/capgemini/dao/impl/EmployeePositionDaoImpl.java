package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeePositionDao;
import com.capgemini.domain.EmployeePositionEntity;

@Repository
public class EmployeePositionDaoImpl extends AbstractDao<EmployeePositionEntity, Long> implements EmployeePositionDao {
}
