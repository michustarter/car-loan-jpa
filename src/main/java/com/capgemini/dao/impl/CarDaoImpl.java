package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

	@Override
	public CarEntity addNewCar(CarEntity carEntity) {
		return save(carEntity);
	}
	@Override
	public void deleteCar(Long carId) {
		delete(carId);
	}

	@Override
	public CarEntity updateCarData(CarEntity carEntity) {
		return update(carEntity);
	}

	@Override
	public void assignToKeeper(CarEntity carEntity, EmployeeEntity employeeEntity) {
		TypedQuery<EmployeeEntity> query = entityManager
				.createQuery("select ee from EmployeeEntity ee where e.id = :id", EmployeeEntity.class);
		query.setParameter("id", employeeEntity.getId());
		try{
		EmployeeEntity wantedEmployee = query.getSingleResult();
		wantedEmployee.getCars().add(carEntity);
		entityManager.merge(wantedEmployee);
		} catch (NoResultException e) {
			
		}

	}

	@Override
	public List<CarEntity> findCarsByTypeAndBrand(String type, String brand) {
		TypedQuery<CarEntity> query = entityManager.createQuery(
				"select car from CarEntity car where car.type = :type and car.brand = :brand", CarEntity.class);
		query.setParameter("type", type);
		query.setParameter("brand", brand);
		return query.getResultList();
	}

	@Override
	public List<CarEntity> findCarsByKeeper(EmployeeEntity keeperEntity) {
		TypedQuery<CarEntity> query = entityManager
				.createQuery("select ee.cars from EmployeeEntity ee where ee.id = :employee", CarEntity.class);
		query.setParameter("employee", keeperEntity.getId());
		return query.getResultList();
	}

}
