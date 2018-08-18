package com.capgemini.service;

import java.util.List;

import com.capgemini.to.CarTO;
import com.capgemini.to.EmployeeTO;

public interface CarService {

	CarTO addNewCar(CarTO carTO);
	 
	 void deleteCar(Long carId);
	 
	 CarTO updateCarData(CarTO carTO);
	 
	 CarTO findCarById(Long carId);
	 
	 void assignToKeeper(CarTO carTO, EmployeeTO employeeTO);
	 
	List<CarTO> findCarsByTypeAndBrand(String type, String brand);

	 List<CarTO> findCarsByKeeper(EmployeeTO keeperTO);
}
