package com.capgemini.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.capgemini.dao.EmployeePositionDao;
import com.capgemini.domain.EmployeePositionEntity;

public class EmployeePositionDaoImpl extends AbstractDao<EmployeePositionEntity, Long> implements EmployeePositionDao {

	@Override
	public EmployeePositionEntity addNewPosition(EmployeePositionEntity newPosition) {
		TypedQuery<EmployeePositionEntity> query = entityManager.createQuery(
				"select ep from EmployeePositionEntity ep where ep.position = :position", EmployeePositionEntity.class);
		query.setParameter("position", newPosition.getPosition());

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return save(newPosition);

		}
	}
}
