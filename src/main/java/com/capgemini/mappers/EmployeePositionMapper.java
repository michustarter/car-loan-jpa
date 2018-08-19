package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.EmployeePositionEntity;
import com.capgemini.to.EmployeePositionTO;
import com.capgemini.to.EmployeePositionTO.EmployeePositionTOBuilder;

public class EmployeePositionMapper {

	public static EmployeePositionTO toEmployeePositionTO(EmployeePositionEntity emplPositionEntity) {
		if (emplPositionEntity == null) {
			return null;
		}
		return new EmployeePositionTOBuilder()
				.withId(emplPositionEntity.getId())
				.withPosition(emplPositionEntity.getPosition())
				.build();
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

	public static List<EmployeePositionTO> map2TOs(List<EmployeePositionEntity> emplPositionEntities) {
		return emplPositionEntities.stream().map(EmployeePositionMapper::toEmployeePositionTO)
				.collect(Collectors.toList());
	}

	public static List<EmployeePositionEntity> map2Entities(List<EmployeePositionTO> emplPositionTOs) {
		return emplPositionTOs.stream().map(EmployeePositionMapper::toEmployeePositionEntity)
				.collect(Collectors.toList());
	}

}
