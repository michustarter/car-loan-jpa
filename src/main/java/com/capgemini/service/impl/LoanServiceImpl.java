package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.LoanDao;
import com.capgemini.mappers.CarMapper;
import com.capgemini.service.LoanService;
import com.capgemini.to.CarTO;
/**
 * Klasa serwisowa reprezentująca wypozyczenia samochodow
 * @author MRATAJCZ
 *
 */
@Service
public class LoanServiceImpl implements LoanService {

	private LoanDao loanDao;

	@Autowired
	public LoanServiceImpl(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

	@Override
	public List<CarTO> findCarsRentedMoreThan10Times() {
		return CarMapper.map2TOs(loanDao.findCarsRented10TimesBy10DifferentCustomer());
	}

	@Override
	public int numberOfCarsRentedBeetwenDates(String rentalDate, String returnDate) {
		return loanDao.countCarsRentedBeetweenDates(rentalDate, returnDate);

	}

}