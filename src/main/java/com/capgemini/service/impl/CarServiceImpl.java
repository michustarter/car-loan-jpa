package com.capgemini.service.impl;

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
		CarTO car = CarMapper.toCarTO(carDao.addNewCar(CarMapper.toCarEntity(carTO)));
		return car;
	}

	@Override
	public void deleteCar(Long id) {
		carDao.delete(id);
	}

	@Override
	public CarTO updateCarData(CarTO carTO) {
		CarEntity carEntity = CarMapper.toCarEntity(carTO);
		return CarMapper.toCarTO(carDao.save(carEntity));
	}

	@Override
	public void assignToKeeper(CarTO carTO, EmployeeTO employeeTO) {
		carDao.assignToKeeper(CarMapper.toCarEntity(carTO), EmployeeMapper.toEmployeeEntity(employeeTO));

	}

	@Override
	public List<CarTO> findCarsByTypeAndBrand(String type, String brand) {
		return CarMapper.map2TOs(carDao.findCarsByTypeAndBrand(type, brand));
	}
	

	@Override
	public List<CarTO> findCarsByKeeper(Long employeeId) {
		return CarMapper.map2TOs(carDao.findCarsByKeeper(employeeId));
	}

}
