package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.to.CarTO;
import com.capgemini.to.CarTO.CarTOBuilder;
import com.capgemini.to.EmployeeTO;

public class CarMapper {
	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity==null) {
			return null;
		}
		List<EmployeeTO> employeeTOs=EmployeeMapper.map2TOs(carEntity.getKeepers());
		return new CarTOBuilder()
				.withId(carEntity.getId())
				.withType(carEntity.getType())
				.withBrand(carEntity.getBrand())
				.withModel(carEntity.getModel())
				.withProductionYear(carEntity.getProductionYear())
				.withColor(carEntity.getColor())
				.withEngineCapacity(carEntity.getEngineCapacity())
				.withPower(carEntity.getPower())
				.withMileage(carEntity.getMileage())
				.withKeepers(employeeTOs)
				.build();
	}
	
	public static CarEntity toCarEntity(CarTO carTO) {
		if (carTO==null) {
			return null;
		}
		CarEntity carEntity = new CarEntity();
		List<EmployeeEntity> keepers = EmployeeMapper.map2Entities(carTO.getKeepers());
	carEntity.setId(carTO.getId());
	carEntity.setType(carTO.getType());
	carEntity.setBrand(carTO.getBrand());
	carEntity.setModel(carTO.getModel());
	carEntity.setProductionYear(carTO.getProductionYear());
	carEntity.setColor(carTO.getColor());
	carEntity.setEngineCapacity(carTO.getEngineCapacity());
	carEntity.setPower(carTO.getPower());
	carEntity.setMileage(carTO.getMileage());
	carEntity.setKeepers(keepers);
	return carEntity;
}
	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(Collectors.toList());
	}
	public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
		return carTOs.stream().map(CarMapper::toCarEntity).collect(Collectors.toList());
	}
	
}