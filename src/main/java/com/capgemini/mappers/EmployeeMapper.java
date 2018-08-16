package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.EmployeeEntity;
import com.capgemini.to.CarTO;
import com.capgemini.to.EmployeeTO;
import com.capgemini.to.EmployeeTO.EmployeeTOBuilder;

public class EmployeeMapper {

	public static EmployeeTO toEmployeeTO(EmployeeEntity employeeEnitity) {
		if(employeeEnitity==null) {
			return null;
		}
		List<CarTO> carTOs=CarMapper.map2TOs(employeeEnitity.getCars());
		return new EmployeeTOBuilder()
				.withId(employeeEnitity.getId())
				.withOffice(OfficeMapper.toOfficeTO(employeeEnitity.getOffice()))
				.withEmployeePosition(EmployeePositionMapper.toEmployeePositionTO(employeeEnitity.getEmployeePosition()))
				.withFirstName(employeeEnitity.getFirstName())
				.withLastName(employeeEnitity.getLastName())
				.withBirthDate(employeeEnitity.getBirthDate())
				.withCars(carTOs)
				.build();
	}
	
	public static EmployeeEntity toEmployeeEntity(EmployeeTO employeeTO) {
		if (employeeTO==null) {
			return null;
		}
		EmployeeEntity employeeEntity = new EmployeeEntity();
		List<CarEntity> cars=CarMapper.map2Entities(employeeTO.getCars());
		employeeEntity.setOffice(OfficeMapper.toOfficeEntity(employeeTO.getOffice()));
		employeeEntity.setEmployeePosition(EmployeePositionMapper.toEmployeePositionEntity(employeeTO.getEmployeePosition()));
		employeeEntity.setFirstName(employeeTO.getFirstName());
		employeeEntity.setLastName(employeeTO.getLastName());
		employeeEntity.setBirthDate(employeeTO.getBirthDate());
		employeeEntity.setCars(cars);
		return employeeEntity;
	}
	public static List<EmployeeTO> map2TOs(List<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toList());
	}
	public static List<EmployeeEntity> map2Entities(List<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
	}
}
