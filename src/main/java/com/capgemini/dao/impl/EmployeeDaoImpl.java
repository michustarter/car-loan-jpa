package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

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
	public void deleteEmployee(EmployeeEntity removedEmployee) {
		delete(removedEmployee);
	}

	@Override
	public EmployeeEntity updateEmployeeData(EmployeeEntity updateEmployee) {
		return update(updateEmployee);
	}
	

	@Override
	public List<EmployeeEntity> findOfficeEmployees(Long officeId) {
		TypedQuery<EmployeeEntity> query = entityManager.createQuery(
				"select ee from EmployeeEntity ee inner join ee.office o where o.id = :officeId ",
				EmployeeEntity.class);
		query.setParameter("officeId", officeId);

		try {
			List<EmployeeEntity> employeesEntity = query.getResultList();
			return employeesEntity;

		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<EmployeeEntity> findCarKeepersfromOffice(Long officeId, Long carId) {
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery(
						"select ee " + "from EmployeeEntity ee inner join ee.office of "
								+ "inner join ee.cars c where of.id= :officeId" + "and c.id= :carId",
						EmployeeEntity.class);
		query.setParameter("officeId", officeId);
		query.setParameter("carId", carId);

		try {

			List<EmployeeEntity> employeesEntity = query.getResultList();
			return employeesEntity;

		} catch (NoResultException e) {
			return null;
		}
	}

}
