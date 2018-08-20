package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressOfficeDao;
import com.capgemini.domain.AddressOfficeEntity;
import com.capgemini.service.AddressOfficeService;
import com.capgemini.to.AddressTO;

import static com.capgemini.mappers.AddressOfficeMapper.toAddressEntity;
import static com.capgemini.mappers.AddressOfficeMapper.toAddressTO;

@Service
public class AddressOfficeServiceImpl implements AddressOfficeService{
	
	private final AddressOfficeDao addressOfficeDao;
	
	@Autowired
	public AddressOfficeServiceImpl(AddressOfficeDao addressOfficeDao) {
		this.addressOfficeDao = addressOfficeDao;
	}
	
	@Override
	public AddressTO addAddress(AddressTO address) {
		AddressOfficeEntity addressEntity = toAddressEntity(address);
		return toAddressTO(addressOfficeDao.save(addressEntity));
	}
}
