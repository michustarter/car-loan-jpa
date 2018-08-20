package com.capgemini.dao;

import com.capgemini.domain.AddressCustomerEntity;

public interface AddressCustomerDao extends Dao<AddressCustomerEntity, Long> {

    AddressCustomerEntity addNewAddress(AddressCustomerEntity newAddress);
}
