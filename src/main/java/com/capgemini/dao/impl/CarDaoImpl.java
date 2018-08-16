package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;


public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public List<CarEntity> findCarsByTypeAndBrand(String type, String brand) {
		   TypedQuery<CarEntity> query = entityManager.createQuery(
	                "select car from CarEntity car where car.type = :type and car.brand = :brand", CarEntity.class);
	        query.setParameter("type", type);
	        query.setParameter("brand", brand);

	        return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByKeeper(Long employeeId) {
		TypedQuery<CarEntity> query=entityManager.createQuery(
	                "select car from CarEntity car where :employee_id member of car.keepers", CarEntity.class);
	        query.setParameter("employee_id", employeeId);
	        return query.getResultList();
	}

	@Override
	public CarEntity addNewCar(CarEntity carEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarEntity updateCarData(CarEntity carEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignToKeeper(CarEntity carEntity, EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		
	}

}
