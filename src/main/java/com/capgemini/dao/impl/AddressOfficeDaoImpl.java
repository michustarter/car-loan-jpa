package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.AddressOfficeDao;
import com.capgemini.domain.AddressOfficeEntity;

@Repository
public class AddressOfficeDaoImpl extends AbstractDao<AddressOfficeEntity, Long> implements AddressOfficeDao {
}