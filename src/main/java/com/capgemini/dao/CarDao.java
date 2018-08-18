package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;

public interface CarDao extends Dao<CarEntity, Long> {

	 CarEntity addNewCar(CarEntity carEntity);
	 
	 void deleteCar(Long carId);
	 
	 CarEntity updateCarData(CarEntity carEntity);
	 
	 void assignToKeeper(CarEntity carEntity, EmployeeEntity employeeEntity);
	 
	 List<CarEntity> findCarsByTypeAndBrand(String type, String brand);

	List<CarEntity> findCarsByKeeper(EmployeeEntity keeperEntity);

	

	 

	

	
}
