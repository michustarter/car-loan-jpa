package com.capgemini.mappers;

import java.util.Set;
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
		Set<CarTO> carTOs=CarMapper.map2TOs(employeeEnitity.getCars());
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
		Set<CarEntity> cars=CarMapper.map2Entities(employeeTO.getCars());
		employeeEntity.setOffice(OfficeMapper.toOfficeEntity(employeeTO.getOffice()));
		employeeEntity.setEmployeePosition(EmployeePositionMapper.toEmployeePositionEntity(employeeTO.getEmployeePosition()));
		employeeEntity.setFirstName(employeeTO.getFirstName());
		employeeEntity.setLastName(employeeTO.getLastName());
		employeeEntity.setBirthDate(employeeTO.getBirthDate());
		employeeEntity.setCars(cars);
		return employeeEntity;
	}
	public static Set<EmployeeTO> map2TOs(Set<EmployeeEntity> employeeEntities) {
		return employeeEntities.stream().map(EmployeeMapper::toEmployeeTO).collect(Collectors.toSet());
	}
	public static Set<EmployeeEntity> map2Entities(Set<EmployeeTO> employeeTOs) {
		return employeeTOs.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toSet());
	}
}
