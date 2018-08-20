package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.CarEntity;
import com.capgemini.domain.LoanEntity;

public interface LoanDao extends Dao<LoanEntity, Long> {
    List<CarEntity> findCarsRented10TimesBy10DifferentCustomer();

    int countCarsRentedBeetweenDates(String rentalDate, String returnDate);
}