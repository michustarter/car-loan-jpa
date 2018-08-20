package com.capgemini.service;

import java.util.List;

import com.capgemini.to.CarTO;


public interface LoanService {


    List<CarTO> findCarsRentedMoreThan10Times();

    int numberOfCarsRentedBeetwenDates(String rentalDate, String returnDate);




}