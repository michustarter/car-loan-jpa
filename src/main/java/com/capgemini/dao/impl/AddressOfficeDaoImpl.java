package com.capgemini.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AddressOfficeDao;
import com.capgemini.domain.AddressOfficeEntity;

@Repository
public class AddressOfficeDaoImpl extends AbstractDao<AddressOfficeEntity, Long> implements AddressOfficeDao {

	@Override
	public AddressOfficeEntity addNewAddress(AddressOfficeEntity newAddress) {
		  TypedQuery<AddressOfficeEntity> query = entityManager.createQuery(
	                "select ac from AddressOfficeEntity ac where ac.street = :street " +
	                        " and ac.postCode=:postCode and ac.city=:city ", AddressOfficeEntity.class);
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
