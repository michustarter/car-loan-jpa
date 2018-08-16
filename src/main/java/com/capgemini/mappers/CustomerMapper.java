package com.capgemini.mappers;

import java.util.Set;
import java.util.stream.Collectors;

import com.capgemini.domain.CustomerEntity;
import com.capgemini.to.CustomerTO;
import com.capgemini.to.CustomerTO.CustomerTOBuilder;

public class CustomerMapper {

	public static CustomerTO toCustomerTO(CustomerEntity customerEntity) {
		if(customerEntity==null) {
			return null;
		}
		return new CustomerTOBuilder()
				.withId(customerEntity.getId())
				.withFirstName(customerEntity.getFirstName())
				.withLastName(customerEntity.getLastName())
				.withAddress(AddressMapper.toAddressTO(customerEntity.getAddress()))
				.withBirthDate(customerEntity.getBirthDate())
				.withPhoneNumber(customerEntity.getPhoneNumber())
				.withCreditCardNumber(customerEntity.getCreditCardNumber())
				.withMail(customerEntity.getMail())
				.build();
	}
	
	public static CustomerEntity toCustomerEntity(CustomerTO customerTO) {
		if(customerTO==null) {
			return null;
		}
		CustomerEntity customerEntity=new CustomerEntity();
		customerEntity.setFirstName(customerTO.getFirstName());
		customerEntity.setLastName(customerTO.getLastName());
		customerEntity.setAddress(AddressMapper.toAddressEntity(customerTO.getAddress()));
		customerEntity.setBirthDate(customerTO.getBirthDate());
		customerEntity.setPhoneNumber(customerTO.getPhoneNumber());
		customerEntity.setCreditCardNumber(customerTO.getCreditCardNumber());
		customerEntity.setMail(customerTO.getMail());
		return customerEntity;
	}
	public static Set<CustomerTO> map2Tos(Set<CustomerEntity> customerEntities) {
		return customerEntities.stream().map(CustomerMapper::toCustomerTO).collect(Collectors.toSet());
	}
	public static Set<CustomerEntity> map2Entitiess(Set<CustomerTO> customerTOs) {
		return customerTOs.stream().map(CustomerMapper::toCustomerEntity).collect(Collectors.toSet());
	}
}
