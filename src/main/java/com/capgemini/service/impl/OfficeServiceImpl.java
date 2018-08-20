package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.OfficeDao;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.service.OfficeService;
import com.capgemini.to.OfficeTO;

import static com.capgemini.mappers.OfficeMapper.toOfficeEntity;
import static com.capgemini.mappers.OfficeMapper.toOfficeTO;
/**
 * Klasa serwisowa reprezentująca oddzial wypozyczalni, znajdują sie w niej typowe 
 * metody zwiazane z dodawaniem, usuwaniem i aktualizowaniem oddzialu wypozyczlani.
 * @author MRATAJCZ
 *
 */
@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

	private final OfficeDao officeDao;

	@Autowired
	public OfficeServiceImpl(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	@Override
	public OfficeTO addNewOffice(OfficeTO newOffice) {
		OfficeEntity savedOffice = officeDao.save(toOfficeEntity(newOffice));
		return toOfficeTO(savedOffice);
	}

	@Override
	public void deleteOffice(OfficeTO removeOffice) {
		officeDao.delete(toOfficeEntity(removeOffice));
	}

	@Override
	public OfficeTO updateOfficeData(OfficeTO officeToUpdate) {
		OfficeEntity officeUpdated = officeDao.update(toOfficeEntity(officeToUpdate));
		return toOfficeTO(officeUpdated);
	}
}
