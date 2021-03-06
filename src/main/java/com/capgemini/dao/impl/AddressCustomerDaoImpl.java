package com.capgemini.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AddressCustomerDao;
import com.capgemini.domain.AddressCustomerEntity;

@Repository
public class AddressCustomerDaoImpl extends AbstractDao<AddressCustomerEntity, Long> implements AddressCustomerDao {

    @Override
    public AddressCustomerEntity addNewAddress(AddressCustomerEntity newAddress) {
        TypedQuery<AddressCustomerEntity> query = entityManager.createQuery(
                "select ac from AddressCustomerEntity ac where ac.street = :street " +
                        " and ac.postCode=:postCode and ac.city=:city ", AddressCustomerEntity.class);
        query.setParameter("street", newAddress.getStreet());
        query.setParameter("postCode", newAddress.getPostCode());
        query.setParameter("city",newAddress.getCity());

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return save(newAddress);
        }

    }
}