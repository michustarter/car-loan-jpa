package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public List<CarEntity> findCarsByTypeAndBrand(String type, String brand) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where car.type = :type and car.brand = :brand", CarEntity.class);
		query.setParameter("type", type);
		query.setParameter("brand", brand);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarEntity> findCarsByKeeper(EmployeeEntity keeperEntity) {
		Query query = entityManager
				.createQuery("select ee.cars from EmployeeEntity ee where ee.id = :employee_id");
		query.setParameter("employee_id", keeperEntity.getId());
		return query.getResultList();
	}
}
