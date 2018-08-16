package com.capgemini.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.OfficeEntity;
import com.capgemini.to.OfficeTO;
import com.capgemini.to.OfficeTO.OfficeTOBuilder;

public class OfficeMapper {

	public static OfficeTO toOfficeTO(OfficeEntity officeEntity) {
		if (officeEntity == null) {
			return null;
		}
		return new OfficeTOBuilder().withId(officeEntity.getId())
				.withAddress(AddressMapper.toAddressTO(officeEntity.getAddress()))
				.withPhoneNumber(officeEntity.getPhoneNumber()).withMail(officeEntity.getMail()).build();
	}

	public static OfficeEntity toOfficeEntity(OfficeTO officeTO) {
		if (officeTO == null) {
			return null;
		}
		OfficeEntity officeEntity = new OfficeEntity();
		officeEntity.setAddress(AddressMapper.toAddressEntity(officeTO.getAddress()));
		officeEntity.setPhoneNumber(officeTO.getPhoneNumber());
		officeEntity.setMail(officeEntity.getMail());
		return officeEntity;
	}

	public static Set<OfficeTO> map2TOs(Set<OfficeEntity> officeEntities) {
		return officeEntities.stream().map(OfficeMapper::toOfficeTO).collect(Collectors.toSet());
	}

	public static Set<OfficeEntity> map2Entities(Set<OfficeTO> officeTOs) {
		return officeTOs.stream().map(OfficeMapper::toOfficeEntity).collect(Collectors.toSet());
	}
}
