package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressOfficeDao;
import com.capgemini.domain.AddressOfficeEntity;
import com.capgemini.mappers.AddressOfficeMapper;
import com.capgemini.service.AddressOfficeService;
import com.capgemini.to.AddressTO;

@Service
public class AddressOfficeServiceImpl implements AddressOfficeService{
	
private AddressOfficeDao addressOfficeDao;
	
	@Autowired
	public AddressOfficeServiceImpl(AddressOfficeDao addressOfficeDao) {
		this.addressOfficeDao=addressOfficeDao;
	}
	
	@Override
	public AddressTO addAddress(AddressTO address) {
AddressOfficeEntity addressEntity= AddressOfficeMapper.toAddressEntity(address);

		return AddressOfficeMapper.toAddressTO(addressOfficeDao.addNewAddress(addressEntity));
	}

}
