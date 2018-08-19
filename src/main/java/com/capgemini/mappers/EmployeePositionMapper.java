package com.capgemini.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.to.EmployeePositionTO;
import com.capgemini.to.EmployeePositionTO.EmployeePositionTOBuilder;

public class EmployeePositionMapper {

	public static EmployeePositionTO toEmployeePositionTO(EmployeePositionEntity emplPositionEntity) {
		if (emplPositionEntity == null) {
			return null;
		}
		return new EmployeePositionTOBuilder().withId(emplPositionEntity.getId())
				.withPosition(emplPositionEntity.getPosition()).build();
	}

	public static EmployeePositionEntity toEmployeePositionEntity(EmployeePositionTO emplPositionTO) {
		if (emplPositionTO == null) {
			return null;
		}
		EmployeePositionEntity emplPositionEntity = new EmployeePositionEntity();
		emplPositionEntity.setId(emplPositionTO.getId());
		emplPositionEntity.setPosition(emplPositionTO.getPosition());
		return emplPositionEntity;
	}

	public static Set<EmployeePositionTO> map2TOs(Set<EmployeePositionEntity> emplPositionEntities) {
		return emplPositionEntities.stream().map(EmployeePositionMapper::toEmployeePositionTO)
				.collect(Collectors.toSet());
	}

	public static Set<EmployeePositionEntity> map2Entities(Set<EmployeePositionTO> emplPositionTOs) {
		return emplPositionTOs.stream().map(EmployeePositionMapper::toEmployeePositionEntity)
				.collect(Collectors.toSet());
	}

}
