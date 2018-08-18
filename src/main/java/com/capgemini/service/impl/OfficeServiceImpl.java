package com.capgemini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.OfficeDao;
import com.capgemini.domain.OfficeEntity;
import com.capgemini.mappers.OfficeMapper;
import com.capgemini.service.OfficeService;
import com.capgemini.to.OfficeTO;

@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeDao officeDao;

	@Override
	@Transactional(readOnly = false)
	public OfficeTO addNewOffice(OfficeTO newOffice) {
		OfficeTO office = OfficeMapper.toOfficeTO(officeDao.addNewOffice(OfficeMapper.toOfficeEntity(newOffice)));
		return office;
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteOffice(OfficeTO removeOffice) {
		officeDao.deleteOffice(OfficeMapper.toOfficeEntity(removeOffice));
	}

	@Override
	@Transactional(readOnly = false)
	public OfficeTO updateOfficeData(OfficeTO updatedOffice) {
		OfficeEntity officeEntity = officeDao.updateOfficeData(OfficeMapper.toOfficeEntity(updatedOffice));
		return OfficeMapper.toOfficeTO(officeEntity);

	}

}
