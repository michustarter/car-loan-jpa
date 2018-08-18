package com.capgemini.dao;

import com.capgemini.domain.OfficeEntity;

public interface OfficeDao extends Dao<OfficeEntity, Long> {
	
	OfficeEntity addNewOffice(OfficeEntity newOffice);
	
	void deleteOffice(OfficeEntity removeOffice);
	
	OfficeEntity updateOfficeData(OfficeEntity updatedOffice);
}
