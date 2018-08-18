package com.capgemini.service;

import com.capgemini.to.OfficeTO;

public interface OfficeService {

OfficeTO addNewOffice(OfficeTO newOffice);
	
	void deleteOffice(OfficeTO removeOffice);
	
	OfficeTO updateOfficeData(OfficeTO updatedOffice);
}
