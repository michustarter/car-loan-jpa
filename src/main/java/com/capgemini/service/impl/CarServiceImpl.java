package com.capgemini.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.mappers.CarMapper;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.CarService;
import com.capgemini.to.CarTO;
import com.capgemini.to.EmployeeTO;

@Service
@Transactional
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;

	@Override
	@Transactional(readOnly = false)
	public CarTO addNewCar(CarTO carTO) {
		CarEntity carEntity = carDao.addNewCar(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(carEntity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCar(Long carId) {
		carDao.deleteCar(carId);
	}

	@Override
	@Transactional(readOnly = false)
	public CarTO updateCarData(CarTO carTO) {
		CarEntity carEntity = carDao.updateCarData(CarMapper.toCarEntity(carTO));
		return CarMapper.toCarTO(carEntity);
	}
	
	@Override
	public CarTO findCarById(Long carId) {
		return CarMapper.toCarTO(carDao.findOne(carId));
	}

	@Override
	@Transactional(readOnly = false)
	public void assignToKeeper(CarTO carTO, EmployeeTO employeeTO) {
		carDao.assignToKeeper(CarMapper.toCarEntity(carTO), EmployeeMapper.toEmployeeEntity(employeeTO));

	}

	@Override
	public List<CarTO> findCarsByTypeAndBrand(String type, String brand) {
		return CarMapper.map2TOs(carDao.findCarsByTypeAndBrand(type, brand));
	}

	@Override
	public List<CarTO> findCarsByKeeper(EmployeeTO keeperTO) {
		List<CarEntity> cars = carDao.findCarsByKeeper(EmployeeMapper.toEmployeeEntity(keeperTO));
		if (!cars.isEmpty()) {
			return CarMapper.map2TOs(cars);
		}
		return new ArrayList<>();
	}

}
