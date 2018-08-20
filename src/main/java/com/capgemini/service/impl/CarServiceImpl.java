package com.capgemini.service.impl;

import static com.capgemini.mappers.CarMapper.map2TOs;
import static com.capgemini.mappers.CarMapper.toCarEntity;
import static com.capgemini.mappers.CarMapper.toCarTO;
import static java.util.Collections.emptyList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.CarDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.mappers.EmployeeMapper;
import com.capgemini.service.CarService;
import com.capgemini.to.CarTO;
import com.capgemini.to.EmployeeTO;
import com.capgemini.util.NotFoundException;

@Service
public class CarServiceImpl implements CarService {

	private final CarDao carDao;
	private final EmployeeDao employeeDao;

	@Autowired
    public CarServiceImpl(CarDao carDao, EmployeeDao employeeDao) {
        this.carDao = carDao;
        this.employeeDao = employeeDao;
    }

	@Override
	@Transactional
	public CarTO addNewCar(CarTO carTO) {
		CarEntity savedCar = carDao.save(toCarEntity(carTO));
		return toCarTO(savedCar);
	}

	@Override
	@Transactional
	public void deleteCar(Long carId) {
		carDao.delete(carId);
	}

	@Override
	@Transactional
	public CarTO updateCarData(CarTO carTO) {
		CarEntity updatedCar = carDao.update(toCarEntity(carTO));
		return toCarTO(updatedCar);
	}
	
	@Override
	public CarTO findCarById(Long carId) {
		return toCarTO(carDao.findOne(carId));
	}

	@Override
	@Transactional
	public void assignToKeeper(CarTO carTO, EmployeeTO employeeTO) {
        CarEntity car = carDao.findOne(carTO.getId());
        if (car == null) {
            throw new NotFoundException("Cannot find car with given id: " + carTO.getId());
        }

        EmployeeEntity employee = employeeDao.findOne(employeeTO.getId());
        if (employee == null) {
            throw new NotFoundException("Cannot find employee with given id: " + employeeTO.getId());
        }

        employee.getCars().add(toCarEntity(carTO));
        employeeDao.update(employee);
	}

	@Override
	public List<CarTO> findCarsByTypeAndBrand(String type, String brand) {
		return map2TOs(carDao.findCarsByTypeAndBrand(type, brand));
	}

	@Override
	public List<CarTO> findCarsByKeeper(EmployeeTO keeperTO) {
		List<CarEntity> cars = carDao.findCarsByKeeper(EmployeeMapper.toEmployeeEntity(keeperTO));
		if (!cars.isEmpty()) {
			return map2TOs(cars);
		}
		return emptyList();
	}
}
