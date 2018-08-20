package com.capgemini.mappers;

import java.util.List;

import com.capgemini.domain.AddressCustomerEntity;
import com.capgemini.to.AddressTO;
import com.capgemini.to.AddressTO.AddressTOBuilder;

import static java.util.stream.Collectors.toList;

public class AddressCustomerMapper {

	public static AddressTO toAddressTO(AddressCustomerEntity addressEntity) {
		if (addressEntity == null) {
			return null;
		}

		return new AddressTOBuilder()
				.withId(addressEntity.getId())
				.withStreet(addressEntity.getStreet())
				.withPostCode(addressEntity.getPostCode())
				.withCity(addressEntity.getCity()).build();
	}

	public static AddressCustomerEntity toAddressEntity(AddressTO addressTO) {
		if (addressTO == null) {
			return null;
		}

		AddressCustomerEntity addressEnitty = new AddressCustomerEntity();
		addressEnitty.setId(addressTO.getId());
		addressEnitty.setStreet(addressTO.getStreet());
		addressEnitty.setPostCode(addressTO.getPostCode());
		addressEnitty.setCity(addressTO.getCity());
		return addressEnitty;
	}

	public static List<AddressTO> map2TOs(List<AddressCustomerEntity> addressEntities) {
		return addressEntities.stream()
				.map(AddressCustomerMapper::toAddressTO)
				.collect(toList());
	}

	public static List<AddressCustomerEntity> map2Entities(List<AddressTO> addressTOs) {
		return addressTOs.stream()
				.map(AddressCustomerMapper::toAddressEntity)
				.collect(toList());
	}
}
