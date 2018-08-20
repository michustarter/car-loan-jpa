package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.AddressOfficeEntity;
import com.capgemini.to.AddressTO;
import com.capgemini.to.AddressTO.AddressTOBuilder;

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
		return addressEntities
				.stream()
			   .map(AddressOfficeMapper::toAddressTO)
			   .collect(Collectors.toList());
	}

	public static List<AddressOfficeEntity> map2Entities(List<AddressTO> addressTOs) {
		return addressTOs
				.stream()
				.map(AddressOfficeMapper::toAddressEntity)
				.collect(Collectors.toList());
	}

}
