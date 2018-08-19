package com.capgemini.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.domain.CustomerEntity;
import com.capgemini.domain.LoanEntity;
import com.capgemini.to.CustomerTO;
import com.capgemini.to.CustomerTO.CustomerTOBuilder;
import com.capgemini.to.LoanTO;

public class CustomerMapper {

	public static CustomerTO toCustomerTO(CustomerEntity customerEntity) {
		if(customerEntity==null) {
			return null;
		}
		List<LoanTO> loansTOs=LoanMapper.map2TOs(customerEntity.getLoans());
		return new CustomerTOBuilder()
				.withId(customerEntity.getId())
				.withFirstName(customerEntity.getFirstName())
				.withLastName(customerEntity.getLastName())
				.withAddress(AddressMapper.toAddressTO(customerEntity.getAddress()))
				.withLoans(loansTOs)
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
		List<LoanEntity> loansToEntity = LoanMapper.map2Entities(customerTO.getLoans());
		CustomerEntity customerEntity=new CustomerEntity();
		customerEntity.setId(customerTO.getId());
		customerEntity.setFirstName(customerTO.getFirstName());
		customerEntity.setLastName(customerTO.getLastName());
		customerEntity.setAddress(AddressMapper.toAddressEntity(customerTO.getAddress()));
		customerEntity.setLoans(loansToEntity);
		customerEntity.setBirthDate(customerTO.getBirthDate());
		customerEntity.setPhoneNumber(customerTO.getPhoneNumber());
		customerEntity.setCreditCardNumber(customerTO.getCreditCardNumber());
		customerEntity.setMail(customerTO.getMail());
		return customerEntity;
	}
	public static List<CustomerTO> map2Tos(List<CustomerEntity> customerEntities) {
		return customerEntities.stream().map(CustomerMapper::toCustomerTO).collect(Collectors.toList());
	}
	public static List<CustomerEntity> map2Entitiess(List<CustomerTO> customerTOs) {
		return customerTOs.stream().map(CustomerMapper::toCustomerEntity).collect(Collectors.toList());
	}
}
