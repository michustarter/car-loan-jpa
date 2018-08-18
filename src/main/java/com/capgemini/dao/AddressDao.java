package com.capgemini.dao;

import com.capgemini.domain.AddressEntity;

public interface AddressDao extends Dao<AddressEntity, Long> {

    AddressEntity addNewAddress(AddressEntity newAddress);

    void deleteAddress(long id);


}
