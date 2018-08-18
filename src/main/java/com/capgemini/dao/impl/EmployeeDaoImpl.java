package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.domain.OfficeEntity;

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
	public EmployeeEntity setOfficeToEmployee(Long employeeId, Long officeId) {
		TypedQuery<EmployeeEntity> queryEmpl = entityManager.createQuery(
                "select ee from EmployeeEntity ee where ee.id = :employeeId"
                , EmployeeEntity.class);
        queryEmpl.setParameter("employeeId", employeeId);

        TypedQuery<OfficeEntity> queryOff = entityManager.createQuery(
                "select oe from OfficeEntity oe where oe.id = :officeId"
                , OfficeEntity.class);
        queryOff.setParameter("officeId", officeId);

        try {
            OfficeEntity office = queryOff.getSingleResult();
            EmployeeEntity employee = queryEmpl.getSingleResult();
            employee.setOffice(office);
            return entityManager.merge(employee);
        } catch (NoResultException e) {
            return null;
        }
	}

	@Override
	public EmployeeEntity deleteEmployeeFromOffice(Long employeeId) {
		TypedQuery<EmployeeEntity> queryEmployee = entityManager
				.createQuery("select ee from EmployeeEntity ee where ee.id = :employeeId", EmployeeEntity.class);
		queryEmployee.setParameter("employeeId", employeeId);

		try {

			EmployeeEntity employeeEntity = queryEmployee.getSingleResult();
			employeeEntity.setOffice(null);
			return entityManager.merge(employeeEntity);
		} catch (NoResultException e) {
			return null;
		}
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
