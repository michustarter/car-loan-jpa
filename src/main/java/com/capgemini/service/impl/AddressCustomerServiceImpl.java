package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressCustomerDao;
import com.capgemini.domain.AddressCustomerEntity;
import com.capgemini.service.AddressCustomerService;
import com.capgemini.to.AddressTO;

import static com.capgemini.mappers.AddressCustomerMapper.toAddressEntity;
import static com.capgemini.mappers.AddressCustomerMapper.toAddressTO;
/**
 * Klasa serwisowa adresów klientów - zawiera metodę addAddress
 * @author MRATAJCZ
 *
 */
@Service
public class AddressCustomerServiceImpl implements AddressCustomerService {

	private final AddressCustomerDao addressCustomerDao;

	@Autowired
	public AddressCustomerServiceImpl(AddressCustomerDao addressCustomerDao) {
		this.addressCustomerDao = addressCustomerDao;
	}
/**
 * Metoda addAddress przyjmuje obiekt typu DTO.
 * Tworzony jest obiekt typu Entity, który jest przemapowanym obiektem DTO na Entity.
 * Następnie poprzez instancje interfejsu AddressCustomerDao nowy address jest dodawany
 *  do bazy danych i zwracany w metodzie głównej już w postaci DTO.
 */
	@Override
	public AddressTO addAddress(AddressTO address) {
		AddressCustomerEntity addressEntity = toAddressEntity(address);
		return toAddressTO(addressCustomerDao.addNewAddress(addressEntity));
	}
}
