package com.capgemini.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.AddressEntity;
import com.capgemini.to.AddressTO;
import com.capgemini.to.AddressTO.AddressTOBuilder;

public class AddressMapper {
	public static AddressTO toAddressTO(AddressEntity addressEntity) {
		if (addressEntity == null) {
			return null;
		}
		return new AddressTOBuilder()
				.withId(addressEntity.getId())
				.withStreet(addressEntity.getStreet())
				.withPostCode(addressEntity.getPostCode())
				.withCity(addressEntity.getCity()).build();
	}

	public static AddressEntity toAddressEntity(AddressTO addressTO) {
		if (addressTO == null) {
			return null;
		}
		AddressEntity addressEnitty = new AddressEntity();
		addressEnitty.setId(addressTO.getId());
		addressEnitty.setStreet(addressTO.getStreet());
		addressEnitty.setPostCode(addressTO.getPostCode());
		addressEnitty.setCity(addressTO.getCity());
		return addressEnitty;

	}

	public static Set<AddressTO> map2TOs(Set<AddressEntity> addressEntities) {
		return addressEntities
				.stream()
			   .map(AddressMapper::toAddressTO)
			   .collect(Collectors.toSet());
	}

	public static Set<AddressEntity> map2Entities(Set<AddressTO> addressTOs) {
		return addressTOs
				.stream()
				.map(AddressMapper::toAddressEntity)
				.collect(Collectors.toSet());
	}

}
