package com.capgemini.mappers;

import java.util.List;

import com.capgemini.domain.AddressOfficeEntity;
import com.capgemini.to.AddressTO;
import com.capgemini.to.AddressTO.AddressTOBuilder;

import static java.util.stream.Collectors.toList;

public class AddressOfficeMapper {
	public static AddressTO toAddressTO(AddressOfficeEntity addressEntity) {
		if (addressEntity == null) {
			return null;
		}
		return new AddressTOBuilder()
				.withId(addressEntity.getId())
				.withStreet(addressEntity.getStreet())
				.withPostCode(addressEntity.getPostCode())
				.withCity(addressEntity.getCity()).build();
	}

	public static AddressOfficeEntity toAddressEntity(AddressTO addressTO) {
		if (addressTO == null) {
			return null;
		}
		AddressOfficeEntity addressEnitty = new AddressOfficeEntity();
		addressEnitty.setId(addressTO.getId());
		addressEnitty.setStreet(addressTO.getStreet());
		addressEnitty.setPostCode(addressTO.getPostCode());
		addressEnitty.setCity(addressTO.getCity());
		return addressEnitty;
	}

	public static List<AddressTO> map2TOs(List<AddressOfficeEntity> addressEntities) {
		return addressEntities.stream()
				.map(AddressOfficeMapper::toAddressTO)
				.collect(toList());
	}

	public static List<AddressOfficeEntity> map2Entities(List<AddressTO> addressTOs) {
		return addressTOs
				.stream()
				.map(AddressOfficeMapper::toAddressEntity)
				.collect(toList());
	}

}
