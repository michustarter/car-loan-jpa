package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.AddressOfficeDao;
import com.capgemini.domain.AddressOfficeEntity;
import com.capgemini.service.AddressOfficeService;
import com.capgemini.to.AddressTO;

import static com.capgemini.mappers.AddressOfficeMapper.toAddressEntity;
import static com.capgemini.mappers.AddressOfficeMapper.toAddressTO;
/**
 * Klasa serwisowa adresów wypozyczalni - zawiera metodę addAddress
 * @author MRATAJCZ
 *
 */
@Service
public class AddressOfficeServiceImpl implements AddressOfficeService{
	
	private final AddressOfficeDao addressOfficeDao;
	
	@Autowired
	public AddressOfficeServiceImpl(AddressOfficeDao addressOfficeDao) {
		this.addressOfficeDao = addressOfficeDao;
	}
	/**
	 * Metoda addAddress przyjmuje obiekt typu DTO.
	 * Tworzony jest obiekt typu Entity, który jest przemapowanym obiektem DTO na Entity.
	 * Następnie poprzez instancje interfejsu AddressCustomerDao nowy address jest 
	 * dodawany do bazy danych i zwracany w metodzie głównej już w postaci DTO
	 */
	@Override
	public AddressTO addAddress(AddressTO address) {
		AddressOfficeEntity addressEntity = toAddressEntity(address);
		return toAddressTO(addressOfficeDao.save(addressEntity));
	}
}
