package com.capgemini.dao.impl;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.OfficeDao;
import com.capgemini.domain.OfficeEntity;

@Repository
public class OfficeDaoImpl extends AbstractDao<OfficeEntity, Long> implements OfficeDao {

	@Override
	public OfficeEntity addNewOffice(OfficeEntity newOffice) {
		return save(newOffice);
	}

	@Override
	public void deleteOffice(OfficeEntity removeOffice) {
		delete(removeOffice);
	}

	@Override
	public OfficeEntity updateOfficeData(OfficeEntity updatedOffice) {
		return update(updatedOffice);
	}

}
