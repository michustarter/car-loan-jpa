package com.capgemini.dao;

import com.capgemini.domain.AddressOfficeEntity;

public interface AddressOfficeDao extends Dao<AddressOfficeEntity, Long> {
	AddressOfficeEntity addNewAddress(AddressOfficeEntity newAddress);
}
