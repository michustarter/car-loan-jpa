package com.capgemini.mappers;

import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.LoanEntity;
import com.capgemini.to.CarTO;
import com.capgemini.to.CarTO.CarTOBuilder;
import com.capgemini.to.LoanTO;

import static java.util.stream.Collectors.toList;

public class CarMapper {
	public static CarTO toCarTO(CarEntity carEntity) {
		if (carEntity == null) {
			return null;
		}

		List<LoanTO> loansTOs = LoanMapper.map2TOs(carEntity.getLoans());
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
				.withLoans(loansTOs)
				.build();
	}
	
	public static CarEntity toCarEntity(CarTO carTO) {
		if (carTO == null) {
			return null;
		}
		CarEntity carEntity = new CarEntity();
		List<LoanEntity> loansToEntity = LoanMapper.map2Entities(carTO.getLoans());
		carEntity.setId(carTO.getId());
		carEntity.setType(carTO.getType());
		carEntity.setBrand(carTO.getBrand());
		carEntity.setModel(carTO.getModel());
		carEntity.setProductionYear(carTO.getProductionYear());
		carEntity.setColor(carTO.getColor());
		carEntity.setEngineCapacity(carTO.getEngineCapacity());
		carEntity.setPower(carTO.getPower());
		carEntity.setMileage(carTO.getMileage());
		carEntity.setLoans(loansToEntity);
		return carEntity;
	}

	public static List<CarTO> map2TOs(List<CarEntity> carEntities) {
		return carEntities.stream().map(CarMapper::toCarTO).collect(toList());
	}

	public static List<CarEntity> map2Entities(List<CarTO> carTOs) {
		return carTOs.stream().map(CarMapper::toCarEntity).collect(toList());
	}
}