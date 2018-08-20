package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.dao.AddressCustomerDao;
import com.capgemini.domain.AddressCustomerEntity;
import com.capgemini.mappers.AddressCustomerMapper;
import com.capgemini.service.AddressCustomerService;
import com.capgemini.to.AddressTO;

public class AddressCustomerServiceImpl implements AddressCustomerService {

	private AddressCustomerDao addressCustomerDao;

	@Autowired
	public AddressCustomerServiceImpl(AddressCustomerDao addressCustomerDao) {
		this.addressCustomerDao = addressCustomerDao;
	}

	@Override
	public AddressTO addAddress(AddressTO address) {
		AddressCustomerEntity addressEntity = AddressCustomerMapper.toAddressEntity(address);

		return AddressCustomerMapper.toAddressTO(addressCustomerDao.addNewAddress(addressEntity));
	}

}
