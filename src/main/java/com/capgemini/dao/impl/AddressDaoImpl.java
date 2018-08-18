package com.capgemini.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AddressDao;
import com.capgemini.domain.AddressEntity;

@Repository
public class AddressDaoImpl extends AbstractDao<AddressEntity, Long> implements AddressDao {


    @Override
    public AddressEntity addNewAddress(AddressEntity newAddress) {
        TypedQuery<AddressEntity> query = entityManager.createQuery(
                "select a from AddressEntity a where a.street = :street " +
                        " and a.postCode=:postCode and a.city=:city ", AddressEntity.class);
        query.setParameter("street", newAddress.getStreet());
        query.setParameter("postCode", newAddress.getPostCode());
        query.setParameter("city",newAddress.getCity());

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return save(newAddress);
        }

    }

    @Override
    public void deleteAddress(long id) {
        delete(id);
    }


}