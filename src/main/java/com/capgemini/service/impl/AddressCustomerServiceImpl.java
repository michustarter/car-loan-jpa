package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressCustomerDao;
import com.capgemini.domain.AddressCustomerEntity;
import com.capgemini.service.AddressCustomerService;
import com.capgemini.to.AddressTO;

import static com.capgemini.mappers.AddressCustomerMapper.toAddressEntity;
import static com.capgemini.mappers.AddressCustomerMapper.toAddressTO;

@Service
public class AddressCustomerServiceImpl implements AddressCustomerService {

	private final AddressCustomerDao addressCustomerDao;

	@Autowired
	public AddressCustomerServiceImpl(AddressCustomerDao addressCustomerDao) {
		this.addressCustomerDao = addressCustomerDao;
	}

	@Override
	public AddressTO addAddress(AddressTO address) {
		AddressCustomerEntity addressEntity = toAddressEntity(address);
		return toAddressTO(addressCustomerDao.addNewAddress(addressEntity));
	}
}
